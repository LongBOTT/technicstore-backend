package com.example.technicstore.service;

import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;
import com.cloudinary.utils.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Map;

@Service
public class MediaService {

    private final Cloudinary cloudinary;

    @Autowired
    public MediaService(Cloudinary cloudinary) {
        this.cloudinary = cloudinary;
    }

    public void deleteMedia(String url, String folder) throws IOException {
        if (!StringUtils.isEmpty(url)) {
            String publicId = getPublicIdFromUrl(url);
            String fullPublicId = folder + "/" + publicId;
            Map result = cloudinary.uploader().destroy(fullPublicId, ObjectUtils.emptyMap());

            if (!"ok".equals(result.get("result"))) {
                throw new RuntimeException("Failed to delete the old image.");
            }
        }
    }

    public String uploadMedia(MultipartFile file, String folder) throws IOException {
        Map uploadParams = ObjectUtils.asMap(
                "folder", folder
        );

        Map uploadResult = cloudinary.uploader().upload(file.getBytes(), uploadParams);

        if (uploadResult.containsKey("error")) {
            throw new RuntimeException(uploadResult.get("error").toString());
        }

        return uploadResult.get("secure_url").toString();
    }

    private String getPublicIdFromUrl(String url) {
        try {
            URI uri = new URI(url);
            String path = uri.getPath();
            Path publicIdPath = Paths.get(path);
            String publicIdWithExtension = publicIdPath.getFileName().toString();
            return publicIdWithExtension.substring(0, publicIdWithExtension.lastIndexOf('.'));
        } catch (URISyntaxException e) {
            throw new RuntimeException("Invalid URL format: " + url, e);
        }
    }
}

