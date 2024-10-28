package com.example.technicstore.config;

import com.example.technicstore.entity.*;
import com.example.technicstore.entity.Module;
import com.example.technicstore.repository.*;
import com.example.technicstore.repository.Variant_AttributeRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Component
public class DataInitializer implements CommandLineRunner {

    private final CustomerRepository customerRepository;
    private final AttributeRepository attributeRepository;
    private final BrandRepository brandRepository;
    private final CategoryRepository categoryRepository;
    private final SupplierRepository supplierRepository;
    private final CarrierRepository carrierRepository;
    private final WarrantyRepository warrantyRepository;
    private final RoleRepository roleRepository;
    private final FunctionRepository functionRepository;
    private final ModuleRepository moduleRepository;
    private final DecentralizationRepository decentralizationRepository;

    private final AccountRepository accountRepository;

    private final ProductRepository productRepository;

    private final ImeiRepository imeiRepository;

    private final VariantRepository variantRepository;

    private final Variant_AttributeRepository variantValueRepository;
    private final CategoryAttributeRepository categoryAttributeRepository;


    public DataInitializer(CustomerRepository customerRepository, AttributeRepository attributeRepository, BrandRepository brandRepository, CategoryRepository categoryRepository, SupplierRepository supplierRepository, CarrierRepository carrierRepository, WarrantyRepository warrantyRepository, RoleRepository roleRepository, FunctionRepository functionRepository, ModuleRepository moduleRepository, DecentralizationRepository decentralizationRepository, AccountRepository accountRepository, ProductRepository productRepository, ImeiRepository imeiRepository, VariantRepository variantRepository, Variant_AttributeRepository variantValueRepository1, CategoryAttributeRepository categoryAttributeRepository) {
        this.customerRepository = customerRepository;
        this.attributeRepository = attributeRepository;
        this.brandRepository = brandRepository;
        this.categoryRepository = categoryRepository;
        this.supplierRepository = supplierRepository;
        this.carrierRepository = carrierRepository;
        this.warrantyRepository = warrantyRepository;
        this.roleRepository = roleRepository;
        this.functionRepository = functionRepository;
        this.moduleRepository = moduleRepository;
        this.decentralizationRepository = decentralizationRepository;
        this.accountRepository = accountRepository;
        this.productRepository = productRepository;
        this.imeiRepository = imeiRepository;
        this.variantRepository = variantRepository;
        this.variantValueRepository = variantValueRepository1;
        this.categoryAttributeRepository = categoryAttributeRepository;
    }


    @Override
    @Transactional
    public void run(String... args) throws Exception {

        // region role
        seedDataRole("Admin");
        seedDataRole("Customer");
        seedDataRole("Carrier");
        // endregion

        // region function
        seedDataFunction("Xem");
        seedDataFunction("Thêm");
        seedDataFunction("Sửa");
        seedDataFunction("Xoá");
        seedDataFunction("Xuất file");
        seedDataFunction("In file");
        // endregion

        // region module
        seedDataModule("Trang bán hàng");
        seedDataModule("Quản lý tài khoản");
        seedDataModule("Quản lý khách hàng");
        seedDataModule("Quản lý phí vận chuyển");
        seedDataModule("Quản lý sản phẩm");
        seedDataModule("Quản lý đơn hàng");
        seedDataModule("Quản lý phiếu đặt hàng");
        seedDataModule("Quản lý phiếu nhập hàng");
        seedDataModule("Quản lý nhà cung cấp");
        seedDataModule("Quản lý giao dịch khách hàng");
        seedDataModule("Quản lý chính sách bảo hành");
        seedDataModule("Quản lý đơn hàng bảo hành");
        // endregion

        // region decentralization
        seedDataDecentralization("Admin", "Trang bán hàng", "Xem");

        seedDataDecentralization("Admin", "Quản lý tài khoản", "Xem");
        seedDataDecentralization("Admin", "Quản lý tài khoản", "Thêm");
        seedDataDecentralization("Admin", "Quản lý tài khoản", "Sửa");
        seedDataDecentralization("Admin", "Quản lý tài khoản", "Xoá");
        seedDataDecentralization("Admin", "Quản lý tài khoản", "Xuất file");
        seedDataDecentralization("Admin", "Quản lý tài khoản", "In file");

        seedDataDecentralization("Admin", "Quản lý khách hàng", "Xem");
        seedDataDecentralization("Admin", "Quản lý khách hàng", "Thêm");
        seedDataDecentralization("Admin", "Quản lý khách hàng", "Sửa");
        seedDataDecentralization("Admin", "Quản lý khách hàng", "Xoá");
        seedDataDecentralization("Admin", "Quản lý khách hàng", "Xuất file");
        seedDataDecentralization("Admin", "Quản lý khách hàng", "In file");

        seedDataDecentralization("Admin", "Quản lý phí vận chuyển", "Xem");
        seedDataDecentralization("Admin", "Quản lý phí vận chuyển", "Thêm");
        seedDataDecentralization("Admin", "Quản lý phí vận chuyển", "Sửa");
        seedDataDecentralization("Admin", "Quản lý phí vận chuyển", "Xoá");
        seedDataDecentralization("Admin", "Quản lý phí vận chuyển", "Xuất file");
        seedDataDecentralization("Admin", "Quản lý phí vận chuyển", "In file");

        seedDataDecentralization("Admin", "Quản lý sản phẩm", "Xem");
        seedDataDecentralization("Admin", "Quản lý sản phẩm", "Thêm");
        seedDataDecentralization("Admin", "Quản lý sản phẩm", "Sửa");
        seedDataDecentralization("Admin", "Quản lý sản phẩm", "Xoá");
        seedDataDecentralization("Admin", "Quản lý sản phẩm", "Xuất file");
        seedDataDecentralization("Admin", "Quản lý sản phẩm", "In file");

        seedDataDecentralization("Admin", "Quản lý đơn hàng", "Xem");
        seedDataDecentralization("Admin", "Quản lý đơn hàng", "Thêm");
        seedDataDecentralization("Admin", "Quản lý đơn hàng", "Sửa");
        seedDataDecentralization("Admin", "Quản lý đơn hàng", "Xoá");
        seedDataDecentralization("Admin", "Quản lý đơn hàng", "Xuất file");
        seedDataDecentralization("Admin", "Quản lý đơn hàng", "In file");

        seedDataDecentralization("Admin", "Quản lý phiếu đặt hàng", "Xem");
        seedDataDecentralization("Admin", "Quản lý phiếu đặt hàng", "Thêm");
        seedDataDecentralization("Admin", "Quản lý phiếu đặt hàng", "Sửa");
        seedDataDecentralization("Admin", "Quản lý phiếu đặt hàng", "Xoá");
        seedDataDecentralization("Admin", "Quản lý phiếu đặt hàng", "Xuất file");
        seedDataDecentralization("Admin", "Quản lý phiếu đặt hàng", "In file");

        seedDataDecentralization("Admin", "Quản lý phiếu nhập hàng", "Xem");
        seedDataDecentralization("Admin", "Quản lý phiếu nhập hàng", "Thêm");
        seedDataDecentralization("Admin", "Quản lý phiếu nhập hàng", "Sửa");
        seedDataDecentralization("Admin", "Quản lý phiếu nhập hàng", "Xoá");
        seedDataDecentralization("Admin", "Quản lý phiếu nhập hàng", "Xuất file");
        seedDataDecentralization("Admin", "Quản lý phiếu nhập hàng", "In file");

        seedDataDecentralization("Admin", "Quản lý nhà cung cấp", "Xem");
        seedDataDecentralization("Admin", "Quản lý nhà cung cấp", "Thêm");
        seedDataDecentralization("Admin", "Quản lý nhà cung cấp", "Sửa");
        seedDataDecentralization("Admin", "Quản lý nhà cung cấp", "Xoá");
        seedDataDecentralization("Admin", "Quản lý nhà cung cấp", "Xuất file");
        seedDataDecentralization("Admin", "Quản lý nhà cung cấp", "In file");

        seedDataDecentralization("Admin", "Quản lý giao dịch khách hàng", "Xem");
        seedDataDecentralization("Admin", "Quản lý giao dịch khách hàng", "Thêm");
        seedDataDecentralization("Admin", "Quản lý giao dịch khách hàng", "Sửa");
        seedDataDecentralization("Admin", "Quản lý giao dịch khách hàng", "Xoá");
        seedDataDecentralization("Admin", "Quản lý giao dịch khách hàng", "Xuất file");
        seedDataDecentralization("Admin", "Quản lý giao dịch khách hàng", "In file");

        seedDataDecentralization("Admin", "Quản lý chính sách bảo hành", "Xem");
        seedDataDecentralization("Admin", "Quản lý chính sách bảo hành", "Thêm");
        seedDataDecentralization("Admin", "Quản lý chính sách bảo hành", "Sửa");
        seedDataDecentralization("Admin", "Quản lý chính sách bảo hành", "Xoá");
        seedDataDecentralization("Admin", "Quản lý chính sách bảo hành", "Xuất file");
        seedDataDecentralization("Admin", "Quản lý chính sách bảo hành", "In file");

        seedDataDecentralization("Admin", "Quản lý đơn hàng bảo hành", "Xem");
        seedDataDecentralization("Admin", "Quản lý đơn hàng bảo hành", "Thêm");
        seedDataDecentralization("Admin", "Quản lý đơn hàng bảo hành", "Sửa");
        seedDataDecentralization("Admin", "Quản lý đơn hàng bảo hành", "Xoá");
        seedDataDecentralization("Admin", "Quản lý đơn hàng bảo hành", "Xuất file");
        seedDataDecentralization("Admin", "Quản lý đơn hàng bảo hành", "In file");

        // endregion

        // region customer
        seedDataCustomer("Nguyễn Văn A", "0123456789", "123 Đường A, Quận 1, TP HCM", "nguyenvana@example.com", "1", "TP HCM");
        seedDataCustomer("Trần Thị B", "0987654321", "456 Đường B, Quận 2, TP HCM", "tranthib@example.com", "2", "TP HCM");
        seedDataCustomer("Lê Văn C", "0912345678", "789 Đường C, Quận 3, TP HCM", "levanc@example.com", "3", "TP HCM");
        seedDataCustomer("Phạm Thị D", "0908765432", "101 Đường D, Quận 4, TP HCM", "phamthid@example.com", "4", "TP HCM");
        seedDataCustomer("Hoàng Văn E", "0934567890", "202 Đường E, Quận 5, TP HCM", "hoangvane@example.com", "5", "TP HCM");
        seedDataCustomer("Đỗ Thị F", "0945678901", "303 Đường F, Quận 6, TP HCM", "dothif@example.com", "6", "TP HCM");
        seedDataCustomer("Vũ Văn G", "0976543210", "404 Đường G, Quận 7, TP HCM", "vuvang@example.com", "7", "TP HCM");
        seedDataCustomer("Ngô Thị H", "0887654321", "505 Đường H, Quận 8, TP HCM", "ngothih@example.com", "8", "TP HCM");
        seedDataCustomer("Bùi Văn I", "0865432109", "606 Đường I, Quận 9, TP HCM", "buivani@example.com", "9", "TP HCM");
        seedDataCustomer("Nguyễn Thị K", "0898765432", "707 Đường K, Quận 10, TP HCM", "nguyenthik@example.com", "10", "TP HCM");
        // endregion

        // region carrier
        seedDataCarrier("Grab");
        seedDataCarrier("Bee");
        seedDataCarrier("Giao hàng nhanh");
        seedDataCarrier("Giao hàng tiết kiệm");
        seedDataCarrier("Lalamove");
        seedDataCarrier("ViettelPost");
        //end region

        // region attribute

        seedDataAttribute("Xuất sứ", "Thông tin hàng hóa");
        seedDataAttribute("Thời điểm ra mắt", "Thông tin hàng hóa");
        seedDataAttribute("Màu sắc", "Thông tin hàng hóa");
        seedDataAttribute("Thời gian bảo hành", "Thông tin hàng hóa");


        seedDataAttribute("Kích thước", "Thiết kế & Trọng lượng");
        seedDataAttribute("Trọng lượng  sản phẩm", "Thiết kế & Trọng lượng");
        seedDataAttribute("Chất liệu", "Thiết kế & Trọng lượng");
        seedDataAttribute("Chuẩn kháng nước/Bụi bẩn", "Thiết kế & Trọng lượng");

        seedDataAttribute("Phiên bản CPU", "Bộ xử lý");
        seedDataAttribute("Loại CPU", "Bộ xử lý");
        seedDataAttribute("Số nhân", "Bộ xử lý");
        seedDataAttribute("Tốc độ tối đa", "Bộ xử lý");

        seedDataAttribute("RAM", "RAM");

        seedDataAttribute("Kích thước màn hình", "Màn hình");
        seedDataAttribute("Công nghệ màn hình", "Màn hình");
        seedDataAttribute("Chuẩn màn hình", "Màn hình");
        seedDataAttribute("Độ phân giải", "Màn hình");
        seedDataAttribute("Chất liệu mặt kính", "Màn hình");
        seedDataAttribute("Loại cảm ứng", "Màn hình");
        seedDataAttribute("Độ sáng tối đa", "Màn hình");
        seedDataAttribute("Độ tương phản", "Màn hình");
        seedDataAttribute("Tần số quét", "Màn hình");


        seedDataAttribute("Chip đồ họa (GPU)", "Đồ họa");


        seedDataAttribute("Dung lượng (Rom)", "Lưu trữ");
        seedDataAttribute("Danh bạ lưu trữ", "Lưu trữ");
        seedDataAttribute("Thẻ nhớ ngoài", "Lưu trữ");

        seedDataAttribute("Số camera sau", "Camera sau");
        seedDataAttribute("Camera", "Camera sau");
        seedDataAttribute("Resolution", "Camera sau");
        seedDataAttribute("Quay phim camerasau", "Camera sau");
        seedDataAttribute("Tính năng", "Camera sau");

        seedDataAttribute("Số camera selfie", "Camera selfie");
        seedDataAttribute("Resolution", "Camera selfie");
        seedDataAttribute("Quay phim camera selfie", "Camera selfie");
        seedDataAttribute("Tính năng", "Camera selfie");

        seedDataAttribute("Cảm biến", "Cảm biến");

        seedDataAttribute("Bảo mật", "Bảo mật");

        seedDataAttribute("Thẻ SIM", "Giao tiếp và kết nối");
        seedDataAttribute("Số khe SIM", "Giao tiếp và kết nối");
        seedDataAttribute("Hỗ trợ mạng", "Giao tiếp và kết nối");
        seedDataAttribute("Cổng giao tiếp", "Giao tiếp và kết nối");
        seedDataAttribute("Wifi", "Giao tiếp và kết nối");
        seedDataAttribute("GPS", "Giao tiếp và kết nối");
        seedDataAttribute("Bluetooth", "Giao tiếp và kết nối");
        seedDataAttribute("Kết nối khác", "Giao tiếp và kết nối");

        seedDataAttribute("Loại pin", "Thông tin Pin và sạc");
        seedDataAttribute("Dung lượng pin", "Thông tin Pin và sạc");
        seedDataAttribute("Thông tin thêm", "Thông tin Pin và sạc");

        seedDataAttribute("OS", "Hệ điều hành");
        seedDataAttribute("Version", "Hệ điều hành");

        seedDataAttribute("Phụ kiện trong hộp", "Phụ kiện trong hộp");

        seedDataAttribute("Kiểu bàn phím", "Bàn phím & TouchPad");
        seedDataAttribute("Bàn phím số", "Bàn phím & TouchPad");
        seedDataAttribute("Đèn bàn phím", "Bàn phím & TouchPad");
        seedDataAttribute("Màu đèn LED", "Bàn phím & TouchPad");
        seedDataAttribute("TouchPad", "Bàn phím & TouchPad");

        seedDataAttribute("Số lượng loa", "Thông số cơ bản");
        seedDataAttribute("Tính năng", "Camera selfie");

        seedDataAttribute("Tính năng", "Tính năng và tiện ích");
        seedDataAttribute("Tính năng đặc biệt", "Others");

        // thuộc tính lap top
        seedDataAttribute("Hãng CPU", "Bộ xử lý");
        seedDataAttribute("Công nghệ CPU", "Bộ xử lý");
        seedDataAttribute("Tốc độ CPU tối thiểu", "Bộ xử lý");

        seedDataAttribute("Hãng (Card Oboard)", "Đồ họa");
        seedDataAttribute("Model (Card Oboard)", "Đồ họa");
        seedDataAttribute("Tên đầy đủ (Card onbroad)", "Đồ họa");

        seedDataAttribute("Loại RAM", "RAM");
        seedDataAttribute("Tốc độ RAM", "RAM");
        seedDataAttribute("Số RAM onboard", "RAM");
        seedDataAttribute("Hỗ trợ RAM tối đa", "RAM");

        seedDataAttribute("Kiểu ổ cứng", "Lưu trữ");
        seedDataAttribute("Loại SSD", "Lưu trữ");

        seedDataAttribute("Loại màn hình", "Màn hình");
        seedDataAttribute("Tấm nền", "Màn hình");

        seedDataAttribute("Webcam", "Giao tiếp và kết nối");

        seedDataAttribute("Power Supply", "Thông tin Pin và sạc");

        seedDataAttribute("Số luồng", "Bộ xử lý");
        seedDataAttribute("Bộ nhớ", "Đồ họa");


        // region brand
        //   Thương hiệu điện thoại
        seedDataBrand("iPhone");
        seedDataBrand("Samsung");
        seedDataBrand("Xiaomi");
        seedDataBrand("Oppo");
        seedDataBrand("Realme");

        //   Thương hiệu laptop
        seedDataBrand("MacBook");
        seedDataBrand("Dell");
        seedDataBrand("HP");
        seedDataBrand("Lenovo");
        seedDataBrand("Asus");
        seedDataBrand("Acer");
        seedDataBrand("MSI");

        // Thương hiệu Tablet (Ipad,SamSung,Xiaomi,Oppo)
        seedDataBrand("Ipad");

        // Thương hiệu tai nghe (Apple,SamSung,Xiaomi)
        seedDataBrand("Apple");
        //Thương hiệu đồng hồ
        seedDataBrand("Citizen");
        seedDataBrand("Casio");
        seedDataBrand("Orient");

        // endregion

        // region category
        seedDataCategory("ĐIỆN THOẠI");
        seedDataCategory("LAPTOP");
        seedDataCategory("MÁY TÍNH BẢNG");
        seedDataCategory("ĐỒNG HỒ THÔNG MINH");


        seedDataCategory("PHỤ KIỆN");
        seedDataCategory("ĐIỆN MÁY");

        // Loa,tai nghe
        seedDataCategory("Loa");
        seedDataCategory("Tai nghe");

        // Phụ kiện
        seedDataCategory("Pin dự phòng");
        seedDataCategory("Cáp sạc");
        seedDataCategory("Ốp lưng điện thoại");
        seedDataCategory("Ốp lưng máy tính bảng");
        seedDataCategory("Chuột");
        seedDataCategory("Bàn phím");


        // endregion

        // region supplier
        seedDataSupplier("Apple", "apple@gmail.com", "0123456789", "123 Đường A, Quận 1, TP HCM", "Đang giao dịch");
        seedDataSupplier("Samsung", "samsung@gmail.com", "0987654321", "456 Đường B, Quận 2, TP HCM", "Đang giao dịch");
        seedDataSupplier("Dell", "dell@gmail.com", "0112233445", "789 Đường C, Quận 3, TP HCM", "Đang giao dịch");
        seedDataSupplier("HP", "hp@gmail.com", "0223344556", "101 Đường D, Quận 4, TP HCM", "Đang giao dịch");
        seedDataSupplier("Lenovo", "lenovo@gmail.com", "0334455667", "202 Đường E, Quận 5, TP HCM", "Ngưng giao dịch");
        seedDataSupplier("Xiaomi", "xiaomi@gmail.com", "0445566778", "303 Đường F, Quận 6, TP HCM", "Đang giao dịch");
        seedDataSupplier("Asus", "asus@gmail.com", "0556677889", "404 Đường G, Quận 7, TP HCM", "Ngưng giao dịch");
        seedDataSupplier("Sony", "sony@gmail.com", "0667788990", "505 Đường H, Quận 8, TP HCM", "Đang giao dịch");
        seedDataSupplier("Microsoft", "microsoft@gmail.com", "0778899001", "606 Đường I, Quận 9, TP HCM", "Ngưng giao dịch");
        seedDataSupplier("Huawei", "huawei@gmail.com", "0889900112", "707 Đường K, Quận 10, TP HCM", "Đang giao dịch");
        // endregion

        // endregion

        // region warranty
        seedDataWarranty("Không bảo hành", "Không", 0);
        seedDataWarranty("Bảo hành 1 tháng", "Tháng", 1);
        seedDataWarranty("Bảo hành 6 tháng", "Tháng", 6);
        seedDataWarranty("Bảo hành 1 năm", "Năm", 1);
        seedDataWarranty("Bảo hành 3 tháng", "Tháng", 3);
        // endregion

        // region account

        seedDataAccount("admin", "admin", "0123456789", 1L);
        seedDataAccount("customer", "customer", "0987654321", 2L);
        seedDataAccount("carrier", "carrier", "0112233445", 3L);
        // endregion


        // Điện thoại
        //Iphone 14
        seedDataProduct("Iphone 14", "Điện thoại", 0.5, 1, 1, 1);

        // phiên bản iphone 14
        seedDataVariant("iphone14", 21990000.0, 10, 1);
        seedDataVariant("iphone14", 24990000.0, 10, 1);
        seedDataVariant("iphone14", 27990000.0, 10, 1);

        // Thông số
        // điện thoại iphone 14 dung lượng 128 GB có 3 màu Đen, Trắng, Xanh giá 21.990.000
        seedDataVariantAtribute("Đen", 3, 1);
        seedDataVariantAtribute("Trắng", 3, 1);
        seedDataVariantAtribute("Xanh", 3, 1);
        seedDataVariantAtribute("128GB", 24, 1);

        // điện thoại iphone 14 dung lượng 256 GB có 3 màu Đen, Trắng, Xanh giá 24.990.000
        seedDataVariantAtribute("Đen", 3, 2);
        seedDataVariantAtribute("Trắng", 3, 2);
        seedDataVariantAtribute("Xanh", 3, 2);
        seedDataVariantAtribute("256GB", 24, 2);

        // điện thoại iphone 14 dung lượng 512 GB có 3 màu Đen, Trắng, Xanh giá 27.990.000
        seedDataVariantAtribute("Đen", 3, 3);
        seedDataVariantAtribute("Trắng", 3, 3);
        seedDataVariantAtribute("Xanh", 3, 3);
        seedDataVariantAtribute("512GB", 24, 3);

        // thông số kĩ thuật
        seedDataVariantAtribute("Trung quốc", 1, 1);
        seedDataVariantAtribute("09/2022", 2, 1);
        seedDataVariantAtribute("12", 4, 1);
        seedDataVariantAtribute("146.7 x 71.5 x 7.8 mm", 5, 1);
        seedDataVariantAtribute("172g", 6, 1);
        seedDataVariantAtribute("IP168", 8, 1);
        seedDataVariantAtribute("Apple A15 Bionic", 9, 1);
        seedDataVariantAtribute("6", 11, 1);
        seedDataVariantAtribute("3.22 GHz", 12, 1);
        seedDataVariantAtribute("6GB", 13, 1);
        seedDataVariantAtribute("6.1 inch", 14, 1);
        seedDataVariantAtribute("OLED", 15, 1);
        seedDataVariantAtribute("Super Retina XDR", 16, 1);
        seedDataVariantAtribute("1170 x 2532 pixels", 17, 1);
        seedDataVariantAtribute("60 Hz", 22, 1);
        seedDataVariantAtribute("Điện dung đa điểm", 19, 1);
        seedDataVariantAtribute("1200 nits", 20, 1);
        seedDataVariantAtribute("Apple GPU 5 nhân", 23, 1);
        seedDataVariantAtribute("Không", 26, 1);
        seedDataVariantAtribute("Double rear camera", 27, 1);
        seedDataVariantAtribute("Wide", 28, 1);
        seedDataVariantAtribute("12.0 MP", 29, 1);
        seedDataVariantAtribute("4K 4230p@30fps,FullHD 1080p@25fps,4K 4320p@24fps,FullHD 1080p@30fps,4K 4230p@60fps,HD 720p@30fps,FullHD 1080p@60fps", 30, 1);
        seedDataVariantAtribute("Single selfie camera", 32, 1);
        seedDataVariantAtribute("12.0", 33, 1);
        seedDataVariantAtribute("Cảm biến tiệm cận", 36, 1);
        seedDataVariantAtribute("Mở khóa khuôn mặt,Mở khóa bằng mật mã", 37, 1);
        seedDataVariantAtribute("1 eSIM, 1 Nano SIM", 38, 1);
        seedDataVariantAtribute("1", 39, 1);
        seedDataVariantAtribute("5G", 40, 1);
        seedDataVariantAtribute("1 Lightning", 41, 1);
        seedDataVariantAtribute("BEIDOU,GALILEO,GLONASS,GPS,QZSS", 43, 1);
        seedDataVariantAtribute("Lithium-ion", 46, 1);
        seedDataVariantAtribute("3279 mAh", 47, 1);
        seedDataVariantAtribute("iOS", 49, 1);
        seedDataVariantAtribute("iOS 16", 50, 1);
        seedDataVariantAtribute("Cáp sạc, Sách HDSD, Que lấy SIM", 51, 1);

        // iphone 14 plus
        seedDataProduct("Iphone 14 Plus", "Điện thoại", 0.5, 1, 1, 1);

        // phiên bản iphone 14 plus
        seedDataVariant("iphone14plus", 24990000.0, 10, 2);
        seedDataVariant("iphone14plus", 27990000.0, 10, 2);
        seedDataVariant("iphone14plus", 32990000.0, 10, 2);

        // Thông số
        // điện thoại iphone 14 plus dung lượng 128 GB có 3 màu Đen, Trắng, Xanh giá 24.990.000
        seedDataVariantAtribute("Đen", 3, 4);
        seedDataVariantAtribute("Trắng", 3, 4);
        seedDataVariantAtribute("Xanh", 3, 4);
        seedDataVariantAtribute("128GB", 24, 4);

        // điện thoại iphone 14 plus dung lượng 256 GB có 3 màu Đen, Trắng, Xanh giá 27.990.000
        seedDataVariantAtribute("Đen", 3, 5);
        seedDataVariantAtribute("Trắng", 3, 5);
        seedDataVariantAtribute("Xanh", 3, 5);
        seedDataVariantAtribute("256GB", 24, 5);

        // điện thoại iphone 14 plus dung lượng 512 GB có 3 màu Đen, Trắng, Xanh giá 32.990.000
        seedDataVariantAtribute("Đen", 3, 6);
        seedDataVariantAtribute("Trắng", 3, 6);
        seedDataVariantAtribute("Xanh", 3, 6);
        seedDataVariantAtribute("512GB", 24, 6);

        // thông số kĩ thuật
        seedDataVariantAtribute("Trung quốc", 1, 4);
        seedDataVariantAtribute("09/2022", 2, 4);
        seedDataVariantAtribute("12", 4, 4);
        seedDataVariantAtribute("160.8 x 78.1 x 7.8 mm", 5, 4);
        seedDataVariantAtribute("203g", 6, 4);
        seedDataVariantAtribute("IP168", 8, 4);
        seedDataVariantAtribute("Apple A15 Bionic", 9, 4);
        seedDataVariantAtribute("6", 11, 4);
        seedDataVariantAtribute("3.22 GHz", 12, 4);
        seedDataVariantAtribute("6GB", 13, 4);
        seedDataVariantAtribute("6.7 inch", 14, 4);
        seedDataVariantAtribute("OLED", 15, 4);
        seedDataVariantAtribute("Super Retina XDR", 16, 4);
        seedDataVariantAtribute("1284 x 2778 pixels", 17, 4);
        seedDataVariantAtribute("60 Hz", 22, 4);
        seedDataVariantAtribute("Điện dung đa điểm", 19, 4);
        seedDataVariantAtribute("2000 nits", 20, 4);
        seedDataVariantAtribute("Apple GPU 5 nhân", 23, 4);
        seedDataVariantAtribute("Không", 26, 4);
        seedDataVariantAtribute("Double rear camera", 27, 4);
        seedDataVariantAtribute("Ultra Wide", 28, 4);
        seedDataVariantAtribute("4K 4230p@30fps,FullHD 1080p@60fps,FullHD 1080p@25fps,HD 720p@30fps,4K 4320p@24fps,4K 4230p@60fps,FullHD 1080p@30fps", 30, 4);
        seedDataVariantAtribute("Single selfie camera", 32, 4);
        seedDataVariantAtribute("12.0 MP", 33, 4);
        seedDataVariantAtribute("Cảm biến tiệm cận", 36, 4);
        seedDataVariantAtribute("Mở khóa khuôn mặt,Mở khóa bằng mật mã", 37, 4);
        seedDataVariantAtribute("1 eSIM, 1 Nano SIM", 38, 4);
        seedDataVariantAtribute("1", 39, 4);
        seedDataVariantAtribute("5G", 40, 4);
        seedDataVariantAtribute("1 Lightning", 41, 4);
        seedDataVariantAtribute("802.11 a/b/g/n/ac/ax", 42, 4);
        seedDataVariantAtribute("BEIDOU,GALILEO,GLONASS", 43, 4);
        seedDataVariantAtribute("v5.3", 44, 4);
        seedDataVariantAtribute("Lithium-ion", 46, 4);
        seedDataVariantAtribute("4352 mAh", 47, 4);
        seedDataVariantAtribute("iOS", 49, 4);
        seedDataVariantAtribute("iOS 16", 50, 4);
        seedDataVariantAtribute("Cáp sạc, Sách HDSD, Que lấy SIM", 51, 4);

        // iphone 15
        seedDataProduct("Iphone 15", "Điện thoại", 0.5, 1, 1, 1);

        // phiên bản iphone 15
        seedDataVariant("iphone15", 22990000.0, 10, 3);
        seedDataVariant("iphone15", 25990000.0, 10, 3);
        seedDataVariant("iphone15", 31990000.0, 10, 3);

        // Thông số
        // điện thoại iphone 15 dung lượng 128 GB có 3 màu Đen, Trắng, Xanh giá 22.990.000
        seedDataVariantAtribute("Đen", 3, 7);
        seedDataVariantAtribute("Trắng", 3, 7);
        seedDataVariantAtribute("Xanh", 3, 7);
        seedDataVariantAtribute("128GB", 24, 7);

        // điện thoại iphone 15 dung lượng 256 GB có 3 màu Đen, Trắng, Xanh giá 25.990.000
        seedDataVariantAtribute("Đen", 3, 8);
        seedDataVariantAtribute("Trắng", 3, 8);
        seedDataVariantAtribute("Xanh", 3, 8);
        seedDataVariantAtribute("256GB", 24, 8);

        // điện thoại iphone 15 dung lượng 512 GB có 3 màu Đen, Trắng, Xanh giá 31.990.000
        seedDataVariantAtribute("Đen", 3, 9);
        seedDataVariantAtribute("Trắng", 3, 9);
        seedDataVariantAtribute("Xanh", 3, 9);
        seedDataVariantAtribute("512GB", 24, 9);

        // thông số kĩ thuật
        seedDataVariantAtribute("Trung quốc", 1, 7);
        seedDataVariantAtribute("09/2023", 2, 7);
        seedDataVariantAtribute("12", 4, 7);
        seedDataVariantAtribute("146.7 x 71.5 x 7.8 mm", 5, 7);
        seedDataVariantAtribute("171g", 6, 7);
        seedDataVariantAtribute("IP168", 8, 7);
        seedDataVariantAtribute("Khung máy: Nhôm nguyên khối,Mặt lưng máy: Kính", 7, 7);
        seedDataVariantAtribute("Apple A16 Bionic", 9, 7);
        seedDataVariantAtribute("6-Core", 10, 7);
        seedDataVariantAtribute("6", 11, 7);
        seedDataVariantAtribute("6GB", 13, 7);
        seedDataVariantAtribute("6.1 inch", 14, 7);
        seedDataVariantAtribute("OLED", 15, 7);
        seedDataVariantAtribute("Super Retina XDR", 16, 7);
        seedDataVariantAtribute("1179 x 2556 pixels", 17, 7);
        seedDataVariantAtribute("Phủ ceramic", 18, 7);
        seedDataVariantAtribute("Điện dung đa điểm", 19, 7);
        seedDataVariantAtribute("2000 nits", 20, 7);
        seedDataVariantAtribute("2.000.000:1", 21, 7);
        seedDataVariantAtribute("Apple GPU 5 nhân", 23, 7);
        seedDataVariantAtribute("Không giới hạn", 25, 7);
        seedDataVariantAtribute("Không", 26, 7);
        seedDataVariantAtribute("Double rear camera", 27, 7);
        seedDataVariantAtribute("Standard", 28, 7);
        seedDataVariantAtribute("12.0 MP", 29, 7);
        seedDataVariantAtribute("4K 4320p@24fps,4K 2160p@25fps,4K 4230p@30fps,4K 4230p@60fps,HD 720p@30fps,FullHD 1080p@25fps,FullHD 1080p@60fps,FullHD 1080p@30fps", 30, 7);
        seedDataVariantAtribute("Quay chậm (Slow Motion),Chụp chân dung,Chụp góc rộng (Wide),HDR,Chống rung quang học (OIS),Tự động lấy nét (AF),Chạm lấy nét,Flash LED", 31, 7);
        seedDataVariantAtribute("Single selfie camera", 32, 7);
        seedDataVariantAtribute("12.0 MP", 33, 7);
        seedDataVariantAtribute("Quay phim 4K,Quay phim FullHD,Quay phim Slow Motion", 34, 7);
        seedDataVariantAtribute("Tự động lấy nét (AF),HDR,Nhận diện khuôn mặt,Chế độ chân dung,Ổn định hình ảnh quang học,Flash màn hình", 35, 7);
        seedDataVariantAtribute("Cảm biến khí áp kế,Con quay hồi chuyển,Cảm biến ánh sáng,Cảm biến gia tốc,Cảm biến tiệm cận", 36, 7);
        seedDataVariantAtribute("Mở khóa khuôn mặt,Mở khóa bằng mật mã", 37, 7);
        seedDataVariantAtribute("1 eSIM, 1 Nano SIM", 38, 7);
        seedDataVariantAtribute("1", 39, 7);
        seedDataVariantAtribute("5G", 40, 7);
        seedDataVariantAtribute("Cổng sạc: Type C,Audio Jack: Type C", 41, 7);
        seedDataVariantAtribute("Wifi 6", 42, 7);
        seedDataVariantAtribute("BEIDOU,GALILEO,GLONASS,GPS,QZSS", 43, 7);
        seedDataVariantAtribute("v5.3", 44, 7);
        seedDataVariantAtribute("Lithium-ion", 46, 7);
        seedDataVariantAtribute("20 giờ", 47, 7);
        seedDataVariantAtribute("Hỗ trợ sạc không dây,Sạc pin nhanh,Sạc ngược cho thiết bị khác", 48, 7);
        seedDataVariantAtribute("iOS", 49, 7);
        seedDataVariantAtribute("iOS 17", 50, 7);
        seedDataVariantAtribute("Cáp USB-C to USB-C, Sách HDSD, Que lấy SIM", 51, 7);

        // iphone 15 plus
        seedDataProduct("Iphone 15 Plus", "Điện thoại", 0.5, 1, 1, 1);

        // phiên bản iphone 15 plus
        seedDataVariant("iphone15plus", 25990000.0, 10, 4);
        seedDataVariant("iphone15plus", 28990000.0, 10, 4);
        seedDataVariant("iphone15plus", 34990000.0, 10, 4);

        // Thông số
        // điện thoại iphone 15 plus dung lượng 128 GB có 3 màu Đen, Trắng, Xanh giá 25.990.000
        seedDataVariantAtribute("Đen", 3, 10);
        seedDataVariantAtribute("Trắng", 3, 10);
        seedDataVariantAtribute("Xanh", 3, 10);
        seedDataVariantAtribute("128GB", 24, 10);

        // điện thoại iphone 15 plus dung lượng 256 GB có 3 màu Đen, Trắng, Xanh giá 28.990.000
        seedDataVariantAtribute("Đen", 3, 11);
        seedDataVariantAtribute("Trắng", 3, 11);
        seedDataVariantAtribute("Xanh", 3, 11);
        seedDataVariantAtribute("256GB", 24, 11);

        // điện thoại iphone 15 plus dung lượng 512 GB có 3 màu Đen, Trắng, Xanh giá 34.990.000
        seedDataVariantAtribute("Đen", 3, 12);
        seedDataVariantAtribute("Trắng", 3, 12);
        seedDataVariantAtribute("Xanh", 3, 12);
        seedDataVariantAtribute("512GB", 24, 12);

        // thông số kĩ thuật
        seedDataVariantAtribute("Trung quốc", 1, 10);
        seedDataVariantAtribute("09/2023", 2, 10);
        seedDataVariantAtribute("12", 4, 10);
        seedDataVariantAtribute("160.8 x 78.1 x 7.8 mm", 5, 10);
        seedDataVariantAtribute("201g", 6, 10);
        seedDataVariantAtribute("IP68", 8, 10);
        seedDataVariantAtribute("Khung máy: Nhôm nguyên khối,Mặt lưng máy: Kính", 7, 10);
        seedDataVariantAtribute("Apple A16 Bionic", 9, 10);
        seedDataVariantAtribute("6-Core", 10, 10);
        seedDataVariantAtribute("6 GB", 13, 10);
        seedDataVariantAtribute("6.7 inch", 14, 10);
        seedDataVariantAtribute("OLED", 15, 10);
        seedDataVariantAtribute("Super Retina XDR", 16, 10);
        seedDataVariantAtribute("1290 x 2796 pixels", 17, 10);
        seedDataVariantAtribute("Phủ ceramic", 18, 10);
        seedDataVariantAtribute("Điện dung đa điểm", 19, 10);
        seedDataVariantAtribute("2000 nits", 20, 10);
        seedDataVariantAtribute("2.000.000:1", 21, 10);
        seedDataVariantAtribute("Apple GPU 5 nhân", 23, 10);
        seedDataVariantAtribute("Không giới hạn", 25, 10);
        seedDataVariantAtribute("Không", 26, 10);
        seedDataVariantAtribute("Double rear camera", 27, 10);
        seedDataVariantAtribute("Standard", 28, 10);
        seedDataVariantAtribute("12.0 MP", 29, 10);
        seedDataVariantAtribute("4K 2160p@25fps,4K 2160p@24fps,4K 2160p@60fps,4K 2160p@30fps,FullHD 1080p@25fps,FullHD 1080p@60fps,FullHD 1080p@30fps,HD 720p@30fps", 29, 10);
        seedDataVariantAtribute("Chụp chân dung,Quay chậm (Slow Motion),HDR,Chụp góc rộng (Wide),Chống rung quang học (OIS),Ổn định hình ảnh quang học,Trôi nhanh thời gian (Time Lapse),Toàn cảnh (Panorama),Nhận diện khuôn mặt,Tự động lấy nét (AF),Chạm lấy nét,Live Photo,Ban đêm (Night Mode),Chuyên nghiệp (Pro)", 31, 10);
        seedDataVariantAtribute("Single selfie camera", 32, 10);
        seedDataVariantAtribute("12.0 MP", 33, 10);
        seedDataVariantAtribute("Quay phim 4K,Quay phim FullHD", 34, 10);
        seedDataVariantAtribute("Tự động lấy nét (AF),Ban đêm (Night Mode),HDR,Live Photo,Flash màn hình,Nhận diện khuôn mặt,Ổn định hình ảnh quang học,Chế độ chân dung", 35, 10);
        seedDataVariantAtribute("Cảm biến khí áp kế,Con quay hồi chuyển,Cảm biến ánh sáng,Cảm biến la bàn,Cảm biến gia tốc,Cảm biến tiệm cận", 36, 10);
        seedDataVariantAtribute("Mở khóa khuôn mặt,Mở khóa bằng mật mã", 37, 10);
        seedDataVariantAtribute("1 eSIM, 1 Nano SIM", 38, 10);
        seedDataVariantAtribute("1", 39, 10);
        seedDataVariantAtribute("5G", 40, 10);
        seedDataVariantAtribute("Cổng sạc: Type C,Audio Jack: Type C", 41, 10);
        seedDataVariantAtribute("Wifi 6", 42, 10);
        seedDataVariantAtribute("BEIDOU,GALILEO,GLONASS,GPS,QZSS", 43, 10);
        seedDataVariantAtribute("v5.3", 44, 10);
        seedDataVariantAtribute("NFC", 45, 10);
        seedDataVariantAtribute("Lithium-ion", 46, 10);
        seedDataVariantAtribute("26 giờ", 47, 10);
        seedDataVariantAtribute("Hỗ trợ sạc không dây,Sạc pin nhanh,Sạc ngược cho thiết bị khác", 48, 10);
        seedDataVariantAtribute("iOS", 49, 10);
        seedDataVariantAtribute("iOS 17", 50, 10);
        seedDataVariantAtribute("Cáp USB-C to USB-C, Sách HDSD, Que lấy SIM", 51, 10);

        // iphone 15 pro
        seedDataProduct("Iphone 15 Pro", "Điện thoại", 0.5, 1, 1, 1);

        // phiên bản iphone 15 pro
        seedDataVariant("iphone15pro", 28990000.0, 10, 5);
        seedDataVariant("iphone15pro", 31990000.0, 10, 5);
        seedDataVariant("iphone15pro", 37990000.0, 10, 5);
        seedDataVariant("iphone15pro", 43990000.0, 10, 5);

        // Thông số
        // điện thoại iphone 15 pro dung lượng 128 GB có 3 màu Đen, Trắng, Xanh giá 28.990.000
        seedDataVariantAtribute("Đen", 3, 13);
        seedDataVariantAtribute("Trắng", 3, 13);
        seedDataVariantAtribute("Xanh", 3, 13);
        seedDataVariantAtribute("128GB", 24, 13);

        // điện thoại iphone 15 pro dung lượng 256 GB có 3 màu Đen, Trắng, Xanh giá 31.990.000
        seedDataVariantAtribute("Đen", 3, 14);
        seedDataVariantAtribute("Trắng", 3, 14);
        seedDataVariantAtribute("Xanh", 3, 14);
        seedDataVariantAtribute("256GB", 24, 14);

        // điện thoại iphone 15 pro dung lượng 512 GB có 3 màu Đen, Trắng, Xanh giá 37.990.000
        seedDataVariantAtribute("Đen", 3, 15);
        seedDataVariantAtribute("Trắng", 3, 15);
        seedDataVariantAtribute("Xanh", 3, 15);
        seedDataVariantAtribute("512GB", 24, 15);

        // điện thoại iphone 15 pro dung lượng 1 TB có 3 màu Đen, Trắng, Xanh giá 43.990.000
        seedDataVariantAtribute("Đen", 3, 16);
        seedDataVariantAtribute("Trắng", 3, 16);
        seedDataVariantAtribute("Xanh", 3, 16);
        seedDataVariantAtribute("1TB", 24, 16);

        // thông số kĩ thuật
        seedDataVariantAtribute("Trung quốc", 1, 13);
        seedDataVariantAtribute("09/2023", 2, 13);
        seedDataVariantAtribute("12", 4, 13);
        seedDataVariantAtribute("146.6 x 70.6 x 8.25 mm", 5, 13);
        seedDataVariantAtribute("187g", 6, 13);
        seedDataVariantAtribute("IP68", 8, 13);
        seedDataVariantAtribute("Khung máy: Titanium", 7, 13);
        seedDataVariantAtribute("Apple A17 Pro", 9, 13);
        seedDataVariantAtribute("6-Core", 10, 13);
        seedDataVariantAtribute("6", 11, 13);
        seedDataVariantAtribute("8 GB", 13, 13);
        seedDataVariantAtribute("6.1 inch", 14, 13);
        seedDataVariantAtribute("OLED", 15, 13);
        seedDataVariantAtribute("Super Retina XDR", 16, 13);
        seedDataVariantAtribute("1179 x 2556 pixels", 17, 13);
        seedDataVariantAtribute("Phủ ceramic", 18, 13);
        seedDataVariantAtribute("Điện dung đa điểm", 19, 13);
        seedDataVariantAtribute("2000 nits", 20, 13);
        seedDataVariantAtribute("2.000.000:1", 21, 13);
        seedDataVariantAtribute("Triple rear camera", 27, 13);
        seedDataVariantAtribute("Standard", 28, 13);
        seedDataVariantAtribute("12.0 MP", 29, 13);
        seedDataVariantAtribute("4K 2160p@25fps,4K 2160p@24fps,4K 2160p@30fps,4K 2160p@60fps,FullHD 1080p@25fps,FullHD 1080p@60fps,FullHD 1080p@30fps,HD 720p@30fps", 30, 13);
        seedDataVariantAtribute("Chụp chân dung,Quay chậm (Slow Motion),HDR,Chụp góc rộng (Wide),Chống rung quang học (OIS),Ổn định hình ảnh quang học,Trôi nhanh thời gian (Time Lapse),Toàn cảnh (Panorama),Nhận diện khuôn mặt,Tự động lấy nét (AF),Chạm lấy nét,Flash LED,Ban đêm (Night Mode),Chuyên nghiệp (Pro),Chụp góc siêu rộng (Ultrawide)", 31, 13);
        seedDataVariantAtribute("Single selfie camera", 32, 13);
        seedDataVariantAtribute("12.0 MP", 33, 13);
        seedDataVariantAtribute("Quay phim 4K,Quay phim FullHD", 34, 13);
        seedDataVariantAtribute("Chụp góc rộng (Wide),Ban đêm (Night Mode),HDR,Live Photo,Flash màn hình,Nhận diện khuôn mặt,Ổn định hình ảnh quang học,Chế độ chân dung", 35, 13);
        seedDataVariantAtribute("Cảm biến khí áp kế,Con quay hồi chuyển,Cảm biến ánh sáng,Cảm biến la bàn,Cảm biến gia tốc,Cảm biến tiệm cận", 36, 13);
        seedDataVariantAtribute("Mở khóa khuôn mặt,Mở khóa bằng mật mã", 37, 13);
        seedDataVariantAtribute("1 eSIM, 1 Nano SIM", 38, 13);
        seedDataVariantAtribute("1", 39, 13);
        seedDataVariantAtribute("5G", 40, 13);
        seedDataVariantAtribute("Cổng sạc: Type C,Audio Jack: Type C", 41, 13);
        seedDataVariantAtribute("Wifi 6", 42, 13);
        seedDataVariantAtribute("BEIDOU,GALILEO,GLONASS,GPS,QZSS", 43, 13);
        seedDataVariantAtribute("v5.3", 44, 13);
        seedDataVariantAtribute("NFC", 45, 13);
        seedDataVariantAtribute("Lithium-ion", 46, 13);
        seedDataVariantAtribute("23 giờ", 47, 13);
        seedDataVariantAtribute("Hỗ trợ sạc không dây,Sạc pin nhanh,Sạc ngược cho thiết bị khác", 48, 13);
        seedDataVariantAtribute("iOS", 49, 13);
        seedDataVariantAtribute("iOS 17", 50, 13);
        seedDataVariantAtribute("Cáp USB-C to USB-C, Sách HDSD, Que lấy SIM", 51, 13);

        // iphone 15 pro max
        seedDataProduct("Iphone 15 Pro Max", "Điện thoại", 0.5, 1, 1, 1);

        // phiên bản iphone 15 pro max
        seedDataVariant("iphone15promax", 34990000.0, 10, 6);
        seedDataVariant("iphone15promax", 40990000.0, 10, 6);
        seedDataVariant("iphone15promax", 46990000.0, 10, 6);

        // Thông số
        // điện thoại iphone 15 pro max dung lượng 256 GB có 3 màu Đen, Trắng, Xanh giá 34.990.000
        seedDataVariantAtribute("Đen", 3, 17);
        seedDataVariantAtribute("Trắng", 3, 17);
        seedDataVariantAtribute("Xanh", 3, 17);
        seedDataVariantAtribute("256GB", 24, 17);

        // điện thoại iphone 15 pro max dung lượng 512 GB có 3 màu Đen, Trắng, Xanh giá 40.990.000
        seedDataVariantAtribute("Đen", 3, 18);
        seedDataVariantAtribute("Trắng", 3, 18);
        seedDataVariantAtribute("Xanh", 3, 18);
        seedDataVariantAtribute("512GB", 24, 18);

        // điện thoại iphone 15 pro max dung lượng 1 TB có 3 màu Đen, Trắng, Xanh giá 46.990.000
        seedDataVariantAtribute("Đen", 3, 19);
        seedDataVariantAtribute("Trắng", 3, 19);
        seedDataVariantAtribute("Xanh", 3, 19);
        seedDataVariantAtribute("1TB", 24, 19);

        // thông số kĩ thuật
        seedDataVariantAtribute("Trung quốc", 1, 17);
        seedDataVariantAtribute("09/2023", 2, 17);
        seedDataVariantAtribute("12", 4, 17);
        seedDataVariantAtribute("159.9 x 76.7 x 8.25 mm", 5, 17);
        seedDataVariantAtribute("221g", 6, 17);
        seedDataVariantAtribute("IP68", 8, 17);
        seedDataVariantAtribute("Khung máy: Titanium", 7, 17);
        seedDataVariantAtribute("Apple A17 Pro", 9, 17);
        seedDataVariantAtribute("6-Core", 10, 17);
        seedDataVariantAtribute("8 GB", 13, 17);
        seedDataVariantAtribute("6.7 inch", 14, 17);
        seedDataVariantAtribute("OLED", 15, 17);
        seedDataVariantAtribute("Super Retina XDR", 16, 17);
        seedDataVariantAtribute("1290 x 2796 pixels", 17, 17);
        seedDataVariantAtribute("Phủ ceramic", 18, 17);
        seedDataVariantAtribute("Điện dung đa điểm", 19, 17);
        seedDataVariantAtribute("2000 nits", 20, 17);
        seedDataVariantAtribute("2.000.000:1", 21, 17);
        seedDataVariantAtribute("Triple rear camera", 27, 17);
        seedDataVariantAtribute("Standard", 28, 17);
        seedDataVariantAtribute("12.0 MP", 29, 17);
        seedDataVariantAtribute("4K 2160p@25fps,4K 2160p@24fps,4K 2160p@60fps,4K 2160p@30fps,FullHD 1080p@25fps,FullHD 1080p@60fps,FullHD 1080p@30fps,HD 720p@30fps", 30, 17);
        seedDataVariantAtribute("Chụp chân dung,Quay chậm (Slow Motion),HDR,Chụp góc rộng (Wide),Chống rung quang học (OIS),Ổn định hình ảnh quang học,Trôi nhanh thời gian (Time Lapse),Toàn cảnh (Panorama),Tự động lấy nét (AF),Chạm lấy nét,Flash LED,Ban đêm (Night Mode),Chuyên nghiệp (Pro),Chụp góc siêu rộng (Ultrawide),Chụp chuyển động", 31, 17);
        seedDataVariantAtribute("Single selfie camera", 32, 17);
        seedDataVariantAtribute("12.0 MP", 33, 17);
        seedDataVariantAtribute("Quay phim 4K,Quay phim FullHD", 34, 17);
        seedDataVariantAtribute("Chụp góc rộng (Wide),Tự động lấy nét (AF),Ban đêm (Night Mode),HDR,Flash màn hình,Ổn định hình ảnh quang học,Chế độ chân dung", 35, 17);
        seedDataVariantAtribute("Cảm biến khí áp kế,Con quay hồi chuyển,Cảm biến ánh sáng,Cảm biến la bàn,Cảm biến gia tốc,Cảm biến tiệm cận", 36, 17);
        seedDataVariantAtribute("Mở khóa khuôn mặt,Mở khóa bằng mật mã", 37, 17);
        seedDataVariantAtribute("1 eSIM, 1 Nano SIM", 38, 17);
        seedDataVariantAtribute("1", 39, 17);
        seedDataVariantAtribute("5G", 40, 17);
        seedDataVariantAtribute("Cổng sạc: Type C,Audio Jack: Type C", 41, 17);
        seedDataVariantAtribute("Wifi 6", 42, 17);
        seedDataVariantAtribute("BEIDOU,GALILEO,GLONASS,GPS,QZSS", 43, 17);
        seedDataVariantAtribute("v5.3", 44, 17);
        seedDataVariantAtribute("NFC", 45, 17);
        seedDataVariantAtribute("Lithium-ion", 46, 17);
        seedDataVariantAtribute("29 giờ", 47, 17);
        seedDataVariantAtribute("Hỗ trợ sạc không dây,Sạc pin nhanh,Sạc ngược cho thiết bị khác", 48, 17);
        seedDataVariantAtribute("iOS", 49, 17);
        seedDataVariantAtribute("iOS 17", 50, 17);
        seedDataVariantAtribute("Cáp USB-C to USB-C, Sách HDSD, Que lấy SIM", 51, 17);

        // iphone 16
        seedDataProduct("Iphone 16", "Điện thoại", 0.5, 1, 1, 1);

        // phiên bản iphone 16
        seedDataVariant("iphone16", 22990000.0, 10, 7);
        seedDataVariant("iphone16", 25990000.0, 10, 7);
        seedDataVariant("iphone16", 30990000.0, 10, 7);

        // Thông số
        // điện thoại iphone 16 dung lượng 128 GB có 3 màu Đen, Trắng, Xanh giá 22.990.000
        seedDataVariantAtribute("Đen", 3, 20);
        seedDataVariantAtribute("Trắng", 3, 20);
        seedDataVariantAtribute("Xanh", 3, 20);
        seedDataVariantAtribute("128GB", 24, 20);

        // điện thoại iphone 16 dung lượng 256 GB có 3 màu Đen, Trắng, Xanh giá 25.990.000
        seedDataVariantAtribute("Đen", 3, 21);
        seedDataVariantAtribute("Trắng", 3, 21);
        seedDataVariantAtribute("Xanh", 3, 21);
        seedDataVariantAtribute("256GB", 24, 21);

        // điện thoại iphone 16 dung lượng 512 GB có 3 màu Đen, Trắng, Xanh giá 30.990.000
        seedDataVariantAtribute("Đen", 3, 22);
        seedDataVariantAtribute("Trắng", 3, 22);
        seedDataVariantAtribute("Xanh", 3, 22);
        seedDataVariantAtribute("512GB", 24, 22);

        // thông số kĩ thuật
        seedDataVariantAtribute("Trung quốc", 1, 20);
        seedDataVariantAtribute("09/2024", 2, 20);
        seedDataVariantAtribute("12", 4, 20);
        seedDataVariantAtribute("146.6 x 71.6 x 7.8 mm", 5, 20);
        seedDataVariantAtribute("170", 6, 20);
        seedDataVariantAtribute("IP68", 8, 20);
        seedDataVariantAtribute("Khung máy: Nhôm nguyên khối,Mặt lưng máy: Kính", 7, 20);
        seedDataVariantAtribute("Apple A18", 9, 20);
        seedDataVariantAtribute("6-Core", 10, 20);
        seedDataVariantAtribute("6 GB", 13, 20);
        seedDataVariantAtribute("6.1 inch", 14, 20);
        seedDataVariantAtribute("OLED", 15, 20);
        seedDataVariantAtribute("Super Retina XDR", 16, 20);
        seedDataVariantAtribute("1179 x 2556 pixels", 17, 20);
        seedDataVariantAtribute("Phủ ceramic", 18, 20);
        seedDataVariantAtribute("Điện dung đa điểm", 19, 20);
        seedDataVariantAtribute("2000 nits", 20, 20);
        seedDataVariantAtribute("2.000.000:1", 21, 20);
        seedDataVariantAtribute("Apple GPU 5 nhân", 23, 20);
        seedDataVariantAtribute("Không giới hạn", 25, 20);
        seedDataVariantAtribute("Không", 26, 20);
        seedDataVariantAtribute("Double rear camera", 27, 20);
        seedDataVariantAtribute("Standard", 28, 20);
        seedDataVariantAtribute("12.0 MP", 29, 20);
        seedDataVariantAtribute("4K 2160p@25fps,4K 2160p@24fps,4K 4230p@30fps,4K 4230p@60fps,FullHD 1080p@25fps,FullHD 1080p@60fps,FullHD 1080p@30fps,HD 720p@30fps", 30, 20);
        seedDataVariantAtribute("Chụp chân dung,Quay chậm (Slow Motion),HDR,Chụp góc rộng (Wide),Chống rung quang học (OIS),Tự động lấy nét (AF), Chạm lấy nét, Flash LED,", 31, 20);
        seedDataVariantAtribute("Single selfie camera", 32, 20);
        seedDataVariantAtribute("12.0 MP", 33, 20);
        seedDataVariantAtribute("Quay phim 4K,Quay phim FullHD,Quay phim Slow Motion", 34, 20);
        seedDataVariantAtribute("Tự động lấy nét (AF),HDR,Nhận diện khuôn mặt, Chế độ chân dung,Ổn định hình ảnh quang học,Flash màn hình", 35, 20);
        seedDataVariantAtribute("Cảm biến khí áp kế,Con quay hồi chuyển,Cảm biến ánh sáng,Cảm biến gia tốc,Cảm biến tiệm cận", 36, 20);
        seedDataVariantAtribute("Mở khóa khuôn mặt,Mở khóa bằng mật mã", 37, 20);
        seedDataVariantAtribute("1 eSIM, 1 Nano SIM", 38, 20);
        seedDataVariantAtribute("1", 39, 20);
        seedDataVariantAtribute("5G", 40, 20);
        seedDataVariantAtribute("Cổng sạc: Type C,Audio Jack: Type C", 41, 20);
        seedDataVariantAtribute("Wifi 7", 42, 20);
        seedDataVariantAtribute("BEIDOU,GALILEO,GLONASS,QZSS", 43, 20);
        seedDataVariantAtribute("v5.3", 44, 20);
        seedDataVariantAtribute("NFC", 45, 20);
        seedDataVariantAtribute("Lithium-ion", 46, 20);
        seedDataVariantAtribute("22 giờ", 47, 20);
        seedDataVariantAtribute("Hỗ trợ sạc không dây,Sạc pin nhanh,Sạc ngược cho thiết bị khác", 48, 20);
        seedDataVariantAtribute("iOS", 49, 20);
        seedDataVariantAtribute("iOS 18", 50, 20);
        seedDataVariantAtribute("Cáp USB-C to USB-C, Sách HDSD, Que lấy SIM", 51, 20);

        // iphone 16 pro
        seedDataProduct("Iphone 16 Pro", "Điện thoại", 0.5, 1, 1, 1);

        // phiên bản iphone 16 pro
        seedDataVariant("iphone16pro", 28990000.0, 10, 8);
        seedDataVariant("iphone16pro", 31990000.0, 10, 8);
        seedDataVariant("iphone16pro", 37990000.0, 10, 8);
        seedDataVariant("iphone16pro", 43990000.0, 10, 8);

        // Thông số
        // điện thoại iphone 16 pro dung lượng 128 GB có 3 màu Đen, Trắng, Xanh giá 28.990.000
        seedDataVariantAtribute("Đen", 3, 23);
        seedDataVariantAtribute("Trắng", 3, 23);
        seedDataVariantAtribute("Xanh", 3, 23);
        seedDataVariantAtribute("128GB", 24, 23);

        // điện thoại iphone 16 pro dung lượng 256 GB có 3 màu Đen, Trắng, Xanh giá 31.990.000
        seedDataVariantAtribute("Đen", 3, 24);
        seedDataVariantAtribute("Trắng", 3, 24);
        seedDataVariantAtribute("Xanh", 3, 24);
        seedDataVariantAtribute("256GB", 24, 24);

        // điện thoại iphone 16 pro dung lượng 512 GB có 3 màu Đen, Trắng, Xanh giá 37.990.000
        seedDataVariantAtribute("Đen", 3, 25);
        seedDataVariantAtribute("Trắng", 3, 25);
        seedDataVariantAtribute("Xanh", 3, 25);
        seedDataVariantAtribute("512GB", 24, 25);

        // điện thoại iphone 16 pro dung lượng 1 TB có 3 màu Đen, Trắng, Xanh giá 43.990.000
        seedDataVariantAtribute("Đen", 3, 26);
        seedDataVariantAtribute("Trắng", 3, 26);
        seedDataVariantAtribute("Xanh", 3, 26);
        seedDataVariantAtribute("1TB", 24, 26);

        // thông số kĩ thuật
        seedDataVariantAtribute("Trung quốc", 1, 23);
        seedDataVariantAtribute("09/2024", 2, 23);
        seedDataVariantAtribute("12", 4, 23);
        seedDataVariantAtribute("149.6 x 71.5 x 8.25 mm", 5, 23);
        seedDataVariantAtribute("199 g", 6, 23);
        seedDataVariantAtribute("IP68", 8, 23);
        seedDataVariantAtribute("Khung máy: Titanium", 7, 23);
        seedDataVariantAtribute("Apple A18 Pro", 9, 23);
        seedDataVariantAtribute("6-Core", 10, 23);
        seedDataVariantAtribute("6", 11, 23);
        seedDataVariantAtribute("8 GB", 13, 23);
        seedDataVariantAtribute("6.3 inch", 14, 23);
        seedDataVariantAtribute("OLED", 15, 23);
        seedDataVariantAtribute("Super Retina XDR", 16, 23);
        seedDataVariantAtribute("1206  x 2622  pixels", 17, 23);
        seedDataVariantAtribute("Phủ ceramic", 18, 23);
        seedDataVariantAtribute("Điện dung đa điểm", 19, 23);
        seedDataVariantAtribute("2000 nits", 20, 23);
        seedDataVariantAtribute("2.000.000:1", 21, 23);
        seedDataVariantAtribute("Apple GPU 6 nhân", 23, 23);
        seedDataVariantAtribute("Không giới hạn", 25, 23);
        seedDataVariantAtribute("Không", 26, 23);
        seedDataVariantAtribute("Triple rear camera", 27, 23);
        seedDataVariantAtribute("Standard", 28, 23);
        seedDataVariantAtribute("12.0 MP", 29, 23);
        seedDataVariantAtribute("4K 2160p@25fps,4K 2160p@24fps,4K 2160p@30fps,4K 2160p@60fps,FullHD 1080p@25fps,FullHD 1080p@60fps,FullHD 1080p@30fps,HD 720p@30fps", 30, 23);
        seedDataVariantAtribute("Chụp chân dung,Quay chậm (Slow Motion),HDR,Chụp góc rộng (Wide),Chống rung quang học (OIS),Ổn định hình ảnh quang học,Trôi nhanh thời gian (Time Lapse),Toàn cảnh (Panorama),Nhận diện khuôn mặt,Tự động lấy nét (AF),Chạm lấy nét,Flash LED,Ban đêm (Night Mode),Chuyên nghiệp (Pro),Chụp góc siêu rộng (Ultrawide)", 31, 23);
        seedDataVariantAtribute("Single selfie camera", 32, 23);
        seedDataVariantAtribute("12.0 MP", 33, 23);
        seedDataVariantAtribute("Quay phim 4K,Quay phim FullHD", 34, 23);
        seedDataVariantAtribute("Chụp góc rộng (Wide),Ban đêm (Night Mode),HDR,Live Photo,Flash màn hình,Flash màn hình,Nhận diện khuôn mặt,Ổn định hình ảnh quang học,Chế độ chân dung", 35, 23);
        seedDataVariantAtribute("Cảm biến khí áp kế,Con quay hồi chuyển,Cảm biến ánh sáng,Cảm biến la bàn,Cảm biến gia tốc,Cảm biến tiệm cận", 36, 23);
        seedDataVariantAtribute("Mở khóa khuôn mặt,Mở khóa bằng mật mã", 37, 23);
        seedDataVariantAtribute("1 eSIM, 1 Nano SIM", 38, 23);
        seedDataVariantAtribute("1", 39, 23);
        seedDataVariantAtribute("5G", 40, 23);
        seedDataVariantAtribute("Cổng sạc: Type C,Audio Jack: Type C", 41, 23);
        seedDataVariantAtribute("Wifi 7", 42, 23);
        seedDataVariantAtribute("BEIDOU,GALILEO,GLONASS,QZSS,GPS", 43, 23);
        seedDataVariantAtribute("v5.3", 44, 23);
        seedDataVariantAtribute("NFC", 45, 23);
        seedDataVariantAtribute("Lithium-ion", 46, 23);
        seedDataVariantAtribute("27 giờ", 47, 23);
        seedDataVariantAtribute("Hỗ trợ sạc không dây,Sạc pin nhanh,Sạc ngược cho thiết bị khác", 48, 23);
        seedDataVariantAtribute("iOS", 49, 23);
        seedDataVariantAtribute("iOS 18", 50, 23);
        seedDataVariantAtribute("Cáp USB-C to USB-C, Sách HDSD, Que lấy SIM", 51, 23);

        // sam sung galaxy s24 FE
        seedDataProduct("Samsung Galaxy S24 FE", "Điện thoại", 0.5, 2, 1, 2);

        // phiên bản samsung galaxy s24 FE
        seedDataVariant("samsunggalaxys24fe", 16990000.0, 10, 9);

        // Thông số
        // điện thoại samsung galaxy s24 FE dung lượng 128 GB có 3 màu Đen, Trắng, Xanh giá 16.990.000
        seedDataVariantAtribute("Đen", 3, 27);
        seedDataVariantAtribute("Trắng", 3, 27);
        seedDataVariantAtribute("Xanh", 3, 27);
        seedDataVariantAtribute("128GB", 24, 27);

        // thông số kĩ thuật
        seedDataVariantAtribute("Trung quốc", 1, 27);
        seedDataVariantAtribute("09/2024", 2, 27);
        seedDataVariantAtribute("12", 4, 27);
        seedDataVariantAtribute("16.2 x 7.73 x 8 cm", 5, 27);
        seedDataVariantAtribute("213g", 6, 27);
        seedDataVariantAtribute("IP68", 8, 27);
        seedDataVariantAtribute("Mặt lưng máy: Gorilla Glass Victus+,Viền máy: Kim loại", 7, 27);
        seedDataVariantAtribute("Exynos 2400", 9, 27);
        seedDataVariantAtribute("Octa-Core", 10, 27);
        seedDataVariantAtribute("8", 11, 27);
        seedDataVariantAtribute("8 GB", 13, 27);
        seedDataVariantAtribute("6.7 inch", 14, 27);
        seedDataVariantAtribute("Dynamic AMOLED", 15, 27);
        seedDataVariantAtribute("FHD+", 16, 27);
        seedDataVariantAtribute("1080 x 2340 Pixels", 17, 27);
        seedDataVariantAtribute("Xclipse 940", 23, 27);
        seedDataVariantAtribute("Không giới hạn", 25, 27);
        seedDataVariantAtribute("Không", 26, 27);
        seedDataVariantAtribute("Triple rear camera", 27, 27);
        seedDataVariantAtribute("50 MP,12.0 MP,8.0 MP", 29, 27);
        seedDataVariantAtribute("Chụp góc siêu rộng (Ultrawide,Chụp chân dung đêm,AI CAM,Trợ lí Chỉnh ảnh (Gợi ý chỉnh sửa, Hậu kì sáng tạo),Chống rung kỹ thuật số AI VDIS và quang học OIS,Tự động lấy nét (AF),Zoom quang học 3x,Zoom kĩ thuật số 30x,Xóa phông,Toàn cảnh (Panorama),Chế độ Super HDR,Quay video hiển thị kép,Trôi nhanh thời gian (Time Lapse),Quay chậm (Slow Motion)", 31, 27);
        seedDataVariantAtribute("10.0 MP", 33, 27);
        seedDataVariantAtribute("Làm đẹp (Beautify)", 35, 27);
        seedDataVariantAtribute("Mở khóa khuôn mặt,Mở khóa bằng mật mã", 37, 27);
        seedDataVariantAtribute("Sạc nhanh 25 W,Sạc không dây,Sạc ngược không dây,Khoanh Vùng Search Đa năng,Trợ lý Chat thông minh,Trợ lý Chỉnh ảnh,Phiên dịch Trực tiếp,Samsung DeX,Trợ lý ảo Samsung Bixby,Ghi âm cuộc gọi,Màn hình luôn hiển thị,Chặn tin nhắn,Chặn cuộc gọi,Samsung Wallet,Thu nhỏ màn hình sử dụng một tay,AKG Dolby", 59, 27);
        seedDataVariantAtribute("1", 38, 27);
        seedDataVariantAtribute("1 eSIM, 1 Nano SIM", 39, 27);
        seedDataVariantAtribute("5G", 40, 27);
        seedDataVariantAtribute("Type C", 41, 27);
        seedDataVariantAtribute("802.11 a/b/g/n/ac,Dual-band (2.4 GHz/ 5 GHz),Wi-Fi Hotspot,Wi-Fi Direct,MIMO", 42, 27);
        seedDataVariantAtribute("BEIDOU,GALILEO,GLONASS,GPS,QZSS", 43, 27);
        seedDataVariantAtribute("v5.3", 44, 27);
        seedDataVariantAtribute("Lithium-ion", 46, 27);
        seedDataVariantAtribute("4700 mAh", 47, 27);
        seedDataVariantAtribute("Android", 49, 27);
        seedDataVariantAtribute("Android 14", 50, 27);
        seedDataVariantAtribute("Cáp, Sách HDSD, Que lấy SIM", 51, 27);

        // sam sung galaxy s23
        seedDataProduct("Samsung Galaxy S23", "Điện thoại", 0.5, 2, 1, 2);

        // phiên bản samsung galaxy s23
        seedDataVariant("samsunggalaxys23", 24990000.0, 10, 10);

        // Thông số
        // điện thoại samsung galaxy s23 dung lượng 256 GB có 3 màu Đen, Trắng, Xanh giá 24.990.000
        seedDataVariantAtribute("Đen", 3, 28);
        seedDataVariantAtribute("Trắng", 3, 28);
        seedDataVariantAtribute("Xanh", 3, 28);
        seedDataVariantAtribute("256GB", 24, 28);

        // thông số kĩ thuật
        seedDataVariantAtribute("Trung quốc", 1, 28);
        seedDataVariantAtribute("09/2024", 2, 28);
        seedDataVariantAtribute("12", 4, 28);
        seedDataVariantAtribute("146.3 x 70.9 x 7.6 mm", 5, 28);
        seedDataVariantAtribute("168g", 6, 28);
        seedDataVariantAtribute("IP68", 8, 28);
        seedDataVariantAtribute("Mặt lưng máy: Kính,Khung máy: Hợp kim nhôm", 7, 28);
        seedDataVariantAtribute("Snapdragon 8 Gen 2", 9, 28);
        seedDataVariantAtribute("Octa-Core", 10, 28);
        seedDataVariantAtribute("8", 11, 28);
        seedDataVariantAtribute("2.2 GHz", 12, 28);
        seedDataVariantAtribute("8 GB", 13, 28);
        seedDataVariantAtribute("6.1 inch", 14, 28);
        seedDataVariantAtribute("Dynamic AMOLED 2X", 15, 28);
        seedDataVariantAtribute("FHD+", 16, 28);
        seedDataVariantAtribute("1080 x 2340 Pixels", 17, 28);
        seedDataVariantAtribute("Gorilla Glass Victus", 18, 28);
        seedDataVariantAtribute("Điện dung đa điểm", 19, 28);
        seedDataVariantAtribute("2000 nits", 20, 28);
        seedDataVariantAtribute("120 Hz", 22, 28);
        seedDataVariantAtribute("Adreno 730", 23, 28);
        seedDataVariantAtribute("Không giới hạn", 25, 28);
        seedDataVariantAtribute("Không", 26, 28);
        seedDataVariantAtribute("Triple rear camera", 27, 28);
        seedDataVariantAtribute("Standard", 28, 28);
        seedDataVariantAtribute("50.0 MP,12.0 MP", 29, 28);
        seedDataVariantAtribute("4K 2160p@30fps,4K 2160p@60fps,4230p@30fps,8K 4230p@30fps,HD 720p@30fps,8K 4320p@24fps,FullHD 1080p@240fps,FullHD 1080p@30fps,FullHD 1080p@60fps", 30, 28);
        seedDataVariantAtribute("A.I Camera,Chống rung quang học (OIS)", 31, 28);
        seedDataVariantAtribute("Single selfie camera", 32, 28);
        seedDataVariantAtribute("12.0 MP", 33, 28);
        seedDataVariantAtribute("Quay phim 4k,Quay phim FullHD", 34, 28);
        seedDataVariantAtribute("A.I Camera,HDR,Làm đẹp (Beautify)", 35, 28);
        seedDataVariantAtribute("Cảm biến ánh sáng,Cảm biến vân tay", 36, 28);
        seedDataVariantAtribute("Mở khóa khuôn mặt,Mở khóa vân tay dưới màn hình", 37, 28);
        seedDataVariantAtribute("2 Nano SIM hoặc 1 eSIM, 1 Nano SIM", 38, 28);
        seedDataVariantAtribute("4G,5G", 40, 28);
        seedDataVariantAtribute("Cổng sạc: Type C", 41, 28);
        seedDataVariantAtribute("802.11 a/b/g/n/ac/ax,Dual-band (2.4 GHz/ 5 GHz)", 42, 28);
        seedDataVariantAtribute("GLONASS", 43, 28);
        seedDataVariantAtribute("v5.3", 44, 28);
        seedDataVariantAtribute("NFC", 45, 28);
        seedDataVariantAtribute("Lithium-ion", 46, 28);
        seedDataVariantAtribute("3900  mAh", 47, 28);
        seedDataVariantAtribute("Sạc pin nhanh,Sạc không dây", 48, 28);
        seedDataVariantAtribute("Android", 49, 28);
        seedDataVariantAtribute("Android 13.0", 50, 28);
        seedDataVariantAtribute("Cáp, Sách HDSD, Que lấy SIM", 51, 28);

        //Samsung Galaxy S24 Ultra
        seedDataProduct("Samsung Galaxy S24 Ultra", "Điện thoại", 0.5, 2, 1, 2);

        // phiên bản Samsung Galaxy S24 Ultra
        seedDataVariant("samsunggalaxys24ultra", 33990000.0, 10, 11);
        seedDataVariant("samsunggalaxys24ultra", 37990000.0, 10, 11);

        // Thông số
        // điện thoại Samsung Galaxy S24 Ultra dung lượng 256 GB có 3 màu Đen, Trắng, Xanh giá 33.990.000
        seedDataVariantAtribute("Đen", 3, 29);
        seedDataVariantAtribute("Trắng", 3, 29);
        seedDataVariantAtribute("Xanh", 3, 29);
        seedDataVariantAtribute("256GB", 24, 29);

        // điện thoại Samsung Galaxy S24 Ultra dung lượng 512 GB có 3 màu Đen, Trắng, Xanh giá 37.990.000
        seedDataVariantAtribute("Đen", 3, 30);
        seedDataVariantAtribute("Trắng", 3, 30);
        seedDataVariantAtribute("Xanh", 3, 30);
        seedDataVariantAtribute("512GB", 24, 30);

        // thông số kĩ thuật
        seedDataVariantAtribute("Việt Nam / Trung quốc", 1, 29);
        seedDataVariantAtribute("01/2024", 2, 29);
        seedDataVariantAtribute("12", 4, 29);
        seedDataVariantAtribute("79 x 162.3 x 8.6 mm", 5, 29);
        seedDataVariantAtribute("232 g", 6, 29);
        seedDataVariantAtribute("IP68", 8, 29);
        seedDataVariantAtribute("KKhung máy: Titan", 7, 29);
        seedDataVariantAtribute("Snapdragon 8 Gen 3", 9, 29);
        seedDataVariantAtribute("1 x 3.39 GHz + 2 x 3.1 GHz + 3 x 2.9 GHz + 2 x 2.2 GHz", 10, 29);
        seedDataVariantAtribute("8", 11, 29);
        seedDataVariantAtribute("3.39 GHz", 12, 29);
        seedDataVariantAtribute("12 GB", 13, 29);
        seedDataVariantAtribute("6.8 inch", 14, 29);
        seedDataVariantAtribute("QHD+", 15, 29);
        seedDataVariantAtribute("Dynamic AMOLED 2X", 16, 29);
        seedDataVariantAtribute("3120 x 1440 Pixels ", 17, 29);
        seedDataVariantAtribute("Corning Gorilla Glass Victus", 18, 29);
        seedDataVariantAtribute("2600 nits", 20, 29);
        seedDataVariantAtribute("120 Hz", 22, 29);
        seedDataVariantAtribute("Adreno 750", 23, 29);
        seedDataVariantAtribute("Không giới hạn", 25, 29);
        seedDataVariantAtribute("Không", 26, 29);
        seedDataVariantAtribute("Quad rear camera", 27, 29);
        seedDataVariantAtribute("Wide,Telephoto,Telephoto,Ultra Wide", 28, 29);
        seedDataVariantAtribute("200.0 MP,50.0 MP,10.0 MP,12.0 MP", 29, 29);
        seedDataVariantAtribute("UHD 8K (7680 x 4320)@30fps", 30, 29);
        seedDataVariantAtribute("Zoom quang học 3x,Zoom kĩ thuật số 30x,Chống rung kỹ thuật số AI VDIS và quang học OIS,Chụp hình & quay phim với Portrait AI,Chế độ Super HDR,Trợ lí Chỉnh ảnh (Gợi ý chỉnh sửa, Hậu kì sáng tạo),Chụp chân dung,Chụp góc rộng (Wide),HDR,Trôi nhanh thời gian (Time Lapse),Tự động lấy nét (AF),Ban đêm (Night Mode),Chụp góc siêu rộng (Ultrawide),Chống rung quang học (OIS),Zoom kĩ thuật số 100x,Zoom quang học 10x,Toàn cảnh (Panorama),Xóa phông,Quay siêu chậm (Super Slow Motion)", 31, 29);
        seedDataVariantAtribute("Single selfie camera", 32, 29);
        seedDataVariantAtribute("12.0 MP", 33, 29);
        seedDataVariantAtribute("Quay film chân dung", 34, 29);
        seedDataVariantAtribute("Chụp góc rộng (Wide),Ban đêm (Night Mode),HDR,Làm đẹp (Beautify),Chế độ chân dung", 35, 29);
        seedDataVariantAtribute("Mở khóa vân tay dưới màn hình,Mở khóa khuôn mặt", 37, 29);
        seedDataVariantAtribute("Thu nhỏ màn hình sử dụng một tay,Samsung Wallet (Samsung Pay),Phiên dịch Trực tiếp,Trợ lý Chỉnh ảnh,Trợ lý Chat thông minh,Khoanh Vùng Search Đa năng,Samsung DeX,Công nghệ NFC,Đa cửa sổ (chia đôi màn hình),Chạm 2 lần sáng màn hình,Sạc nhanh 45W,Tích hợp S-Pen trong thân máy,Trợ lý Note Quyền năng,AKG Dolby,Chặn tin nhắn,Chặn cuộc gọi,Màn hình luôn bật (Alway on display)", 59, 29);
        seedDataVariantAtribute("1 eSIM, 1 Nano SIM", 38, 29);
        seedDataVariantAtribute("1", 39, 29);
        seedDataVariantAtribute("4G, 5G", 40, 29);
        seedDataVariantAtribute("1 Type C", 41, 29);
        seedDataVariantAtribute("802.11 a/b/g/n/ac/ax,Dual-band (2.4 GHz/ 5 GHz),2x2 MIMO Wi-Fi Direct", 42, 29);
        seedDataVariantAtribute("BEIDOU,GALILEO,GLONASS,GPS,QZSS", 43, 29);
        seedDataVariantAtribute("v5.3", 44, 29);
        seedDataVariantAtribute("NFC,Bluetooth", 45, 29);
        seedDataVariantAtribute("Lithium-ion", 46, 29);
        seedDataVariantAtribute("5000 mAh", 47, 29);
        seedDataVariantAtribute("Sạc ngược cho thiết bị khác,Sạc pin nhanh,Hỗ trợ sạc không dây,Tiết kiệm pin", 48, 29);
        seedDataVariantAtribute("Android", 49, 29);
        seedDataVariantAtribute("Android 14", 50, 29);
        seedDataVariantAtribute("Cáp Type C, Sách HDSD, Que lấy SIM", 51, 29);

        //Samsung Galaxy Z Flip5
        seedDataProduct("Samsung Galaxy Z Flip5", "Điện thoại", 0.5, 2, 1, 2);

        // phiên bản Samsung Galaxy Z Flip5
        seedDataVariant("samsunggalaxyzflip5", 25990000.0, 10, 12);

        // Thông số
        // điện thoại Samsung Galaxy Z Flip5 dung lượng 256 GB có 3 màu Đen, Trắng, Xanh giá 25.990.000
        seedDataVariantAtribute("Đen", 3, 31);
        seedDataVariantAtribute("Trắng", 3, 31);
        seedDataVariantAtribute("Xanh", 3, 31);
        seedDataVariantAtribute("256GB", 24, 31);

        // thông số kĩ thuật
        seedDataVariantAtribute("Việt Nam / Trung quốc", 1, 31);
        seedDataVariantAtribute("07/2023", 2, 31);
        seedDataVariantAtribute("12", 4, 31);
        seedDataVariantAtribute("165.2 x 71.9 x 6.9 mm", 5, 31);
        seedDataVariantAtribute("187 g", 6, 31);
        seedDataVariantAtribute("IPX8", 8, 31);
        seedDataVariantAtribute("Mặt lưng máy: Kính cường lực,Khung máy: Nhôm nguyên khối", 7, 31);
        seedDataVariantAtribute("Snapdragon 8 Gen 2", 9, 31);
        seedDataVariantAtribute("Octa-Core", 10, 31);
        seedDataVariantAtribute("8", 11, 31);
        seedDataVariantAtribute("8 GB", 13, 31);
        seedDataVariantAtribute("6.7 inch", 14, 31);
        seedDataVariantAtribute("Dynamic AMOLED 2X", 15, 31);
        seedDataVariantAtribute("FHD+", 16, 31);
        seedDataVariantAtribute("1080 x 2636 Pixels", 17, 31);
        seedDataVariantAtribute("Diện dung đa điểm", 19, 31);
        seedDataVariantAtribute("1000 nits", 20, 31);
        seedDataVariantAtribute("120 Hz", 22, 31);
        seedDataVariantAtribute("Adreno 740", 23, 31);
        seedDataVariantAtribute("Không giới hạn", 25, 31);
        seedDataVariantAtribute("Không", 26, 31);
        seedDataVariantAtribute("Double rear camera", 27, 31);
        seedDataVariantAtribute("Wide,Ultra Wide", 28, 31);
        seedDataVariantAtribute("12.0 MP,12.0 MP", 29, 31);
        seedDataVariantAtribute("4K 2160p@30fps,4K 2160p@60fps,FullHD 1080p@30fps,FullHD 1080p@60fps,HD 720p@30fps", 30, 31);
        seedDataVariantAtribute("A.I Camera,Ban đêm (Night Mode),Cài đặt cân bằng trắng,Chống rung quang học (OIS),Chụp góc rộng (Wide),Chụp góc siêu rộng (Ultrawide),Chuyên nghiệp (Pro),Flash LED,Gắn thẻ ảnh địa lý,HDR,ISO Setting,Làm đẹp (Beautify),Làm đẹp video,Lấy nét laser,Lấy nét theo pha (PDAF),Nhận diện khuôn mặt,Ổn định hình ảnh quang học,Quay chậm (Slow Motion),Toàn cảnh (Panorama),Trôi nhanh thời gian (Time Lapse),Tự động lấy nét (AF),Xóa phông,Zoom quang học,Zoom kỹ thuật số", 31, 31);
        seedDataVariantAtribute("Single selfie camera", 32, 31);
        seedDataVariantAtribute("10.0 MP", 33, 31);
        seedDataVariantAtribute("Quay phim FullHD", 34, 31);
        seedDataVariantAtribute("A.I Camera,HDR,Nhãn dán (AR Stickers),Nhận diện khuôn mặt,Làm đẹp (Beautify),Tự động lấy nét (AF)", 35, 31);
        seedDataVariantAtribute("Cảm biến ánh sáng,Cảm biến tiệm cận,Cảm biến vân tay,Cảm biến la bàn", 36, 31);
        seedDataVariantAtribute("Mở khóa khuôn mặt,Mở khóa bằng mật mã", 37, 31);
        seedDataVariantAtribute("1 eSIM, 1 Nano SIM", 38, 31);
        seedDataVariantAtribute("1", 39, 31);
        seedDataVariantAtribute("4G,5G", 40, 31);
        seedDataVariantAtribute("Cổng sạc: Type C,Audio Jack: Type C", 41, 31);
        seedDataVariantAtribute("802.11 a/b/g/n", 42, 31);
        seedDataVariantAtribute("BEIDOU,GALILEO,GLONASS,GPS,QZSS", 43, 31);
        seedDataVariantAtribute("v5.3", 44, 31);
        seedDataVariantAtribute("NFC", 45, 31);
        seedDataVariantAtribute("Lithium polymer", 46, 31);
        seedDataVariantAtribute("3700 mAh", 47, 31);
        seedDataVariantAtribute("Sạc pin nhanh,Tiết kiệm pin,Sạc không dây,Sạc ngược cho thiết bị khác", 48, 31);
        seedDataVariantAtribute("Android", 49, 31);
        seedDataVariantAtribute("Android 13", 50, 31);
        seedDataVariantAtribute(" Sách HDSD, Que lấy SIM", 51, 31);

        // Samsung Galaxy A06
        seedDataProduct("Samsung Galaxy A06", "Điện thoại", 0.5, 2, 1, 1);

        // phiên bản Samsung Galaxy A06
        seedDataVariant("samsunggalaxya06", 3490000.0, 10, 13);

        // Thông số
        // điện thoại Samsung Galaxy A06 dung lượng128 GB có 3 màu Đen, Trắng, Xanh giá 3.490.000
        seedDataVariantAtribute("Đen", 3, 32);
        seedDataVariantAtribute("Trắng", 3, 32);
        seedDataVariantAtribute("Xanh", 3, 32);
        seedDataVariantAtribute("128GB", 24, 32);

        // thông số kĩ thuật
        seedDataVariantAtribute("Việt Nam / Trung quốc", 1, 32);
        seedDataVariantAtribute("09/2024", 2, 32);
        seedDataVariantAtribute("12", 4, 32);
        seedDataVariantAtribute("167.3 x 77.3 x 8 mm", 5, 32);
        seedDataVariantAtribute("189 g", 6, 32);
        seedDataVariantAtribute("Nhựa nguyên khối", 7, 32);
        seedDataVariantAtribute("Helio G85", 9, 32);
        seedDataVariantAtribute("8", 11, 32);
        seedDataVariantAtribute("4 GB", 13, 32);
        seedDataVariantAtribute("6.7 inch", 14, 32);
        seedDataVariantAtribute("PLS LCD", 15, 32);
        seedDataVariantAtribute("HD+", 16, 32);
        seedDataVariantAtribute("720 x 1600 Pixels", 17, 32);
        seedDataVariantAtribute("Không", 18, 32);
        seedDataVariantAtribute("Không", 19, 32);
        seedDataVariantAtribute("576 nits", 20, 32);
        seedDataVariantAtribute("Mali-G52 ", 23, 32);
        seedDataVariantAtribute("Không giới hạn", 25, 32);
        seedDataVariantAtribute("1 TB", 26, 32);
        seedDataVariantAtribute("Double rear camera", 27, 32);
        seedDataVariantAtribute("50 MP,2.0 MP", 29, 32);
        seedDataVariantAtribute("FullHD 1080p@60fps,HD 720p@120fps", 30, 32);
        seedDataVariantAtribute("Zoom kỹ thuật số,Xóa phông,Tự động lấy nét (AF),Toàn cảnh (Panorama),Quay chậm (Slow Motion),Chuyên nghiệp (Pro),Ban đêm (Night Mode)", 31, 32);
        seedDataVariantAtribute("8.0 MP", 33, 32);
        seedDataVariantAtribute("Làm đẹp (Beautify),Xóa phông", 35, 32);
        seedDataVariantAtribute("Mở khoá vân tay cạnh viền,Mở khóa khuôn mặt", 37, 32);
        seedDataVariantAtribute("Sạc nhanh 25 W", 59, 32);
        seedDataVariantAtribute("2 Nano SIM", 38, 32);
        seedDataVariantAtribute("2", 39, 32);
        seedDataVariantAtribute("4G", 40, 32);
        seedDataVariantAtribute("Type C", 41, 32);
        seedDataVariantAtribute("802.11 a/b/g/n/ac,Dual-band (2.4 GHz/ 5 GHz),Wi-Fi Hotspot,Wi-Fi Direct", 42, 32);
        seedDataVariantAtribute("BEIDOU,GALILEO,GLONASS,GPS,QZSS", 43, 32);
        seedDataVariantAtribute("v5.0", 44, 32);
        seedDataVariantAtribute("Lithium polymer", 46, 32);
        seedDataVariantAtribute("5000 mAh", 47, 32);
        seedDataVariantAtribute("Android", 49, 32);
        seedDataVariantAtribute("Android 14", 50, 32);
        seedDataVariantAtribute("Cáp, Sách HDSD, Que lấy SIM", 51, 32);

        // Samsung Galaxy A05
        seedDataProduct("Samsung Galaxy A05", "Điện thoại", 0.5, 2, 1, 1);

        // phiên bản Samsung Galaxy A05
        seedDataVariant("samsunggalaxya05", 2790000.0, 10, 14);

        // Thông số
        // điện thoại Samsung Galaxy A05 dung lượng 128 GB có 3 màu Đen, Trắng, Xanh giá 2.790.000
        seedDataVariantAtribute("Đen", 3, 33);
        seedDataVariantAtribute("Trắng", 3, 33);
        seedDataVariantAtribute("Xanh", 3, 33);
        seedDataVariantAtribute("128GB", 24, 33);

        // thông số kĩ thuật
        seedDataVariantAtribute("Việt Nam / Trung quốc", 1, 33);
        seedDataVariantAtribute("09/2023", 2, 33);
        seedDataVariantAtribute("12", 4, 33);
        seedDataVariantAtribute("168 x 78.2 x 8.8 mm", 5, 33);
        seedDataVariantAtribute("195 g", 6, 33);
        seedDataVariantAtribute("Nhựa Polycarbonate", 7, 33);
        seedDataVariantAtribute("Helio G85", 9, 33);
        seedDataVariantAtribute("8", 11, 33);
        seedDataVariantAtribute("4 GB", 13, 33);
        seedDataVariantAtribute("6.7 inch", 14, 33);
        seedDataVariantAtribute("PLS LCD", 15, 33);
        seedDataVariantAtribute("HD+", 16, 33);
        seedDataVariantAtribute("720 x 1600 Pixels", 17, 33);
        seedDataVariantAtribute("60 Hz", 22, 33);
        seedDataVariantAtribute("MicroSD", 26, 33);
        seedDataVariantAtribute("Double rear camera", 27, 33);
        seedDataVariantAtribute("Wide,Ultra Wide", 28, 33);
        seedDataVariantAtribute("50.0 MP,2.0 MP", 29, 33);

        seedDataVariantAtribute("Single selfie camera", 32, 33);
        seedDataVariantAtribute("8.0 MP", 33, 33);
        seedDataVariantAtribute("2 Nano SIM", 38, 33);
        seedDataVariantAtribute("2", 39, 33);
        seedDataVariantAtribute("4G", 40, 33);
        seedDataVariantAtribute("Type C", 41, 33);
        seedDataVariantAtribute("802.11 a/b/g", 42, 33);
        seedDataVariantAtribute("GLONASS", 43, 33);
        seedDataVariantAtribute("Có", 44, 33);
        seedDataVariantAtribute("5000 mAh", 47, 33);
        seedDataVariantAtribute("Android", 49, 33);
        seedDataVariantAtribute("Android 13.0", 50, 33);
        seedDataVariantAtribute("Cáp, Sách HDSD, Que lấy SIM", 51, 33);

        // OPPO A3
        seedDataProduct("OPPO A3", "Điện thoại", 0.5, 4, 1, 1);

        // phiên bản OPPO A3
        seedDataVariant("oppoa3", 4990000.0, 10, 15);

        // Thông số
        // điện thoại OPPO A3 dung lượng 128 GB có 3 màu Đen, Trắng, Xanh giá 4.990.000
        seedDataVariantAtribute("Đen", 3, 34);
        seedDataVariantAtribute("Trắng", 3, 34);
        seedDataVariantAtribute("Xanh", 3, 34);
        seedDataVariantAtribute("128GB", 24, 34);

        // thông số kĩ thuật
        seedDataVariantAtribute("Trung quốc", 1, 34);
        seedDataVariantAtribute("08/2024", 2, 34);
        seedDataVariantAtribute("12", 4, 34);
        seedDataVariantAtribute("165.7 x 76 x 7.68 mm", 5, 34);
        seedDataVariantAtribute("186 g", 6, 34);
        seedDataVariantAtribute("Khung máy: Nhựa cao cấp", 7, 34);
        seedDataVariantAtribute("Khung máy: Nhựa cao cấp", 8, 34);
        seedDataVariantAtribute("Snapdragon 6s 4G Gen1", 9, 34);
        seedDataVariantAtribute("Octa-Core", 10, 34);
        seedDataVariantAtribute("8", 11, 34);
        seedDataVariantAtribute("2.1 GHz", 12, 34);
        seedDataVariantAtribute("6 GB", 13, 34);
        seedDataVariantAtribute("6.67 inch", 14, 34);
        seedDataVariantAtribute("LCD", 15, 34);
        seedDataVariantAtribute("HD+", 16, 34);
        seedDataVariantAtribute("720 x 1600 Pixels", 17, 34);
        seedDataVariantAtribute("Kính cường lực Panda", 18, 34);
        seedDataVariantAtribute("Điện dung đa điểm", 19, 34);
        seedDataVariantAtribute("1000 nits", 20, 34);
        seedDataVariantAtribute("90 Hz", 22, 34);
        seedDataVariantAtribute("Adreno 610", 23, 34);
        seedDataVariantAtribute("Không giới hạn", 25, 34);
        seedDataVariantAtribute("MicroSD", 26, 34);
        seedDataVariantAtribute("Standard", 28, 34);
        seedDataVariantAtribute("50.0 MP", 29, 34);
        seedDataVariantAtribute("Cảm biến vân tay,Cảm biến tiệm cận,Cảm biến ánh sáng,Cảm biến gia tốc,Cảm biến la bàn", 36, 34);
        seedDataVariantAtribute("Mở khóa bằng mật mãt,Mở khoá vân tay cạnh viền,Mật khẩu", 37, 34);
        seedDataVariantAtribute("2 Nano SIM", 38, 34);
        seedDataVariantAtribute("2", 39, 34);
        seedDataVariantAtribute("4G", 40, 34);
        seedDataVariantAtribute("Cổng sạc: Type C", 41, 34);
        seedDataVariantAtribute("802.11 a/b/g/n/ac", 42, 34);
        seedDataVariantAtribute("BEIDOU,GALILEO,GLONASS,GPS,QZSS", 43, 34);
        seedDataVariantAtribute("v5.0", 44, 34);
        seedDataVariantAtribute("OTG", 45, 34);
        seedDataVariantAtribute("Lithium polymer", 46, 34);
        seedDataVariantAtribute("5100 mAh", 47, 34);
        seedDataVariantAtribute("Sạc nhanh 45 W", 48, 34);
        seedDataVariantAtribute("Android", 49, 34);
        seedDataVariantAtribute("Android 14 (ColorOS 14)", 50, 34);
        seedDataVariantAtribute("Củ sạc, Cáp Type C, Ốp lưng,Sách HDSD,Que lấy SIM", 51, 34);

        // OPPO Reno12
        seedDataProduct("OPPO Reno12", "Điện thoại", 0.5, 4, 1, 1);

        // phiên bản OPPO Reno12 256 GB
        seedDataVariant("opporeno12", 12690000.0, 10, 16);

        // Thông số
        // điện thoại OPPO Reno12 dung lượng 256 GB có 3 màu Đen, Trắng, Xanh giá 12.690.000
        seedDataVariantAtribute("Đen", 3, 35);
        seedDataVariantAtribute("Trắng", 3, 35);
        seedDataVariantAtribute("Xanh", 3, 35);
        seedDataVariantAtribute("256GB", 24, 35);

        // thông số kĩ thuật
        seedDataVariantAtribute("Trung quốc", 1, 35);
        seedDataVariantAtribute("06/2024", 2, 35);
        seedDataVariantAtribute("12", 4, 35);
        seedDataVariantAtribute("161.4 x 74.1 x 7.6 mm", 5, 35);
        seedDataVariantAtribute("177 g", 6, 35);
        seedDataVariantAtribute("Khung máy: Kim loại,Mặt lưng máy: Kính cường lực", 7, 35);
        seedDataVariantAtribute("Dimensity 7300-Energy 5G", 9, 35);
        seedDataVariantAtribute("Octa-Core", 10, 35);
        seedDataVariantAtribute("8", 11, 35);
        seedDataVariantAtribute("2.5 GHz", 12, 35);
        seedDataVariantAtribute("12 GB", 13, 35);
        seedDataVariantAtribute("6.7 inch", 14, 35);
        seedDataVariantAtribute("AMOLED", 15, 35);
        seedDataVariantAtribute("FHD+", 16, 35);
        seedDataVariantAtribute("1080 x 2412  Pixels", 17, 35);
        seedDataVariantAtribute("Kính cường lực GG7", 18, 35);
        seedDataVariantAtribute("Điện dung đa điểm", 19, 35);
        seedDataVariantAtribute("1200 nits", 20, 35);
        seedDataVariantAtribute("120 Hz", 22, 35);
        seedDataVariantAtribute("Arm Mali-G615", 23, 35);
        seedDataVariantAtribute("Không giới hạn", 25, 35);
        seedDataVariantAtribute("MicroSD", 26, 35);
        seedDataVariantAtribute("Double rear camera", 27, 35);
        seedDataVariantAtribute("Standard,Macro lens", 28, 35);
        seedDataVariantAtribute("50.0 MP,2.0 MP", 29, 35);
        seedDataVariantAtribute("4K 2160p@30fps,1080p@60fps,1080p@30fps,720p@30fps", 30, 35);
        seedDataVariantAtribute("Chống rung quang học (OIS),Zoom kỹ thuật số,Quay chậm (Slow Motion)", 31, 35);
        seedDataVariantAtribute("Single selfie camera", 32, 35);
        seedDataVariantAtribute("32.0 MP", 33, 35);
        seedDataVariantAtribute("4K 2160p@30fps, 1080p@30fps, 720p@30fps", 34, 35);
        seedDataVariantAtribute("Tự động lấy nét (AF),Trôi nhanh thời gian (Time lapse)", 35, 35);
        seedDataVariantAtribute("Cảm biến vân tay,Cảm biến tiệm cận,Cảm biến ánh sáng,Cảm biến gia tốc,Cảm biến la bàn", 36, 35);
        seedDataVariantAtribute("Mở khóa khuôn mặt,Mở khóa vân tay,Mở khóa bằng mật khẩu", 37, 35);
        seedDataVariantAtribute("Nhiếp Ảnh Thời Thượng AI,Độ bền chuẩn quân đội Mỹ,Cảm ứng kháng nước", 59, 35);
        seedDataVariantAtribute("2 Nano SIM", 38, 35);
        seedDataVariantAtribute("2", 39, 35);
        seedDataVariantAtribute("5G", 40, 35);
        seedDataVariantAtribute("Cổng sạc: Type C", 41, 35);
        seedDataVariantAtribute("Wifi 6", 42, 35);
        seedDataVariantAtribute("BEIDOU,GALILEO,GLONASS,GPS,QZSS", 43, 35);
        seedDataVariantAtribute("v5.4", 44, 35);
        seedDataVariantAtribute("NFC,OTG", 45, 35);
        seedDataVariantAtribute("Lithium polymer", 46, 35);
        seedDataVariantAtribute("5000 mAh", 47, 35);
        seedDataVariantAtribute("Cục sạc kèm máy: SuperVOOC 80W", 48, 35);
        seedDataVariantAtribute("Android", 49, 35);
        seedDataVariantAtribute("Android 14", 50, 35);
        seedDataVariantAtribute("Cáp USB Type C, Củ sạc, Ốp lưng, Sách HDSD, Que lấy SIM", 51, 35);

        // Xiaomi POCO X6
        seedDataProduct("Xiaomi POCO X6", "Điện thoại", 0.5, 3, 1, 1);

        // phiên bản Xiaomi POCO X6 256 GB
        seedDataVariant("xiaomipocox6", 8990000.0, 10, 17);

        // Thông số
        // điện thoại Xiaomi POCO X6 dung lượng 256 GB có 3 màu Đen, Trắng, Xanh giá 8.990.000
        seedDataVariantAtribute("Đen", 3, 36);
        seedDataVariantAtribute("Trắng", 3, 36);
        seedDataVariantAtribute("Xanh", 3, 36);
        seedDataVariantAtribute("256GB", 24, 36);

        // thông số kĩ thuật
        seedDataVariantAtribute("Trung quốc", 1, 36);
        seedDataVariantAtribute("06/2024", 2, 36);
        seedDataVariantAtribute("12", 4, 36);
        seedDataVariantAtribute("161.15 x 74.24 x 7.98 mm", 5, 36);
        seedDataVariantAtribute("181 g", 6, 36);
        seedDataVariantAtribute("Vỏ thân máy: Nhựa, Mặt lưng máy: Nhựa", 7, 36);
        seedDataVariantAtribute("IP54", 8, 36);
        seedDataVariantAtribute("Snapdragon 7s Gen 2", 9, 36);
        seedDataVariantAtribute("8", 11, 36);
        seedDataVariantAtribute("2.4 GHz", 12, 36);
        seedDataVariantAtribute("12 GB", 13, 36);
        seedDataVariantAtribute("6.67 inch", 14, 36);
        seedDataVariantAtribute("AMOLED", 15, 36);
        seedDataVariantAtribute("1.5K", 16, 36);
        seedDataVariantAtribute("2712 x 1220 Pixels", 17, 36);
        seedDataVariantAtribute("Corning Gorilla Glass Victus", 18, 36);
        seedDataVariantAtribute("1800 nits", 20, 36);
        seedDataVariantAtribute("5.000.000 : 1", 21, 36);
        seedDataVariantAtribute("120 Hz", 22, 36);
        seedDataVariantAtribute("Adreno 710", 23, 36);
        seedDataVariantAtribute("Triple rear camera", 27, 36);
        seedDataVariantAtribute("Standard,Ultra Wide,Macro lens", 28, 36);
        seedDataVariantAtribute("64.0 MP,8.0 MP,2.0 MP", 29, 36);
        seedDataVariantAtribute("4K  4230p@30fps,1080p@60fps,1080p@30fps,720p@30fps", 30, 36);
        seedDataVariantAtribute("Zoom kỹ thuật số,Xóa phông,Trôi nhanh thời gian (Time Lapse),Siêu cận (Macro),Làm đẹp (Beautify),Ban đêm (Night Mode),Bộ lọc màu,Chống rung quang học (OIS)", 31, 36);
        seedDataVariantAtribute("Single selfie camera", 32, 36);
        seedDataVariantAtribute("16.0 MP", 33, 36);
        seedDataVariantAtribute("1080p@60fps,1080p@30fps,720p@30fps", 34, 36);
        seedDataVariantAtribute("Xóa phông, Làm đẹp (Beautify), HDR, Ban đêm (Night Mode), Bộ lọc màu", 35, 36);
        seedDataVariantAtribute("Cảm biến hồng ngoại", 36, 36);
        seedDataVariantAtribute("2 Nano SIM", 38, 36);
        seedDataVariantAtribute("2", 39, 36);
        seedDataVariantAtribute("5G", 40, 36);
        seedDataVariantAtribute("Cổng sạc: Type C", 41, 36);
        seedDataVariantAtribute("802.11 a/b/g/n/ac", 42, 36);
        seedDataVariantAtribute("v5.2", 44, 36);
        seedDataVariantAtribute("NFC", 45, 36);
        seedDataVariantAtribute("Lithium polymer", 46, 36);
        seedDataVariantAtribute("5100 mAh", 47, 36);
        seedDataVariantAtribute("Sạc nhanh 67 W", 48, 36);
        seedDataVariantAtribute("Android", 49, 36);
        seedDataVariantAtribute("Android 13", 50, 36);

        // Xiaomi Poco M6
        seedDataProduct("Xiaomi Poco M6", "Điện thoại", 0.5, 3, 1, 1);

        // phiên bản Xiaomi Poco M6 128 GB
        seedDataVariant("xiaomipocom6", 4290000.0, 10, 18);

        // Thông số
        // điện thoại Xiaomi Poco M6 dung lượng 128 GB có 3 màu Đen, Trắng, Xanh giá 4.290.000
        seedDataVariantAtribute("Đen", 3, 37);
        seedDataVariantAtribute("Trắng", 3, 37);
        seedDataVariantAtribute("Xanh", 3, 37);
        seedDataVariantAtribute("128GB", 24, 37);

        // thông số kĩ thuật
        seedDataVariantAtribute("Trung quốc", 1, 37);
        seedDataVariantAtribute("06/2024", 2, 37);
        seedDataVariantAtribute("12", 4, 37);
        seedDataVariantAtribute("168.6 x 76.28 x 8.3 mm", 5, 37);
        seedDataVariantAtribute("205 g", 6, 37);
        seedDataVariantAtribute("Vỏ thân máy: Nhựa, Mặt lưng máy: Kính", 7, 37);
        seedDataVariantAtribute("IP53", 8, 37);
        seedDataVariantAtribute("MediaTek Helio G91-Ultra", 9, 37);
        seedDataVariantAtribute("Octa-Core", 10, 37);
        seedDataVariantAtribute("8", 11, 37);
        seedDataVariantAtribute("6 GB", 13, 37);
        seedDataVariantAtribute("6.79 inch", 14, 37);
        seedDataVariantAtribute("IPS LCD", 15, 37);
        seedDataVariantAtribute("FHD+", 16, 37);
        seedDataVariantAtribute("1080 x 2460 Pixels", 17, 37);
        seedDataVariantAtribute("Corning Gorilla Glass ", 18, 37);
        seedDataVariantAtribute("550 nits", 20, 37);
        seedDataVariantAtribute("1500:1", 21, 37);
        seedDataVariantAtribute("90 Hz", 22, 37);
        seedDataVariantAtribute("Mali-G52 MC2", 23, 37);
        seedDataVariantAtribute("MicroSD", 26, 37);
        seedDataVariantAtribute("Double rear camera", 27, 37);
        seedDataVariantAtribute("Standard,Macro lens", 28, 37);
        seedDataVariantAtribute("108.0 MP,2.0 MP", 29, 37);
        seedDataVariantAtribute("1080p@30fps,720p@30fps", 30, 37);
        seedDataVariantAtribute("Zoom kỹ thuật số,Xóa phông, Trôi nhanh thời gian (Time Lapse), Siêu cận (Macro), Làm đẹp (Beautify), Ban đêm (Night Mode),Bộ lọc màu", 31, 37);
        seedDataVariantAtribute("Single selfie camera", 32, 37);
        seedDataVariantAtribute("13.0 MP", 33, 37);
        seedDataVariantAtribute("1080p@30fps,720p@30fps", 34, 37);
        seedDataVariantAtribute("Xóa phông, Làm đẹp (Beautify), HDR, Ban đêm (Night Mode), Bộ lọc màu", 35, 37);
        seedDataVariantAtribute("2 Nano SIM", 38, 37);
        seedDataVariantAtribute("2", 39, 37);
        seedDataVariantAtribute("4G", 40, 37);
        seedDataVariantAtribute("Cổng sạc: Type C", 41, 37);
        seedDataVariantAtribute("Wi-Fi Hotspot, Wi-Fi Direct, Dual-band (2.4 GHz/ 5 GHz)", 42, 37);
        seedDataVariantAtribute("v5.3", 44, 37);
        seedDataVariantAtribute("NFC", 45, 37);
        seedDataVariantAtribute("Lithium polymer", 46, 37);
        seedDataVariantAtribute("5030 mAh", 47, 37);
        seedDataVariantAtribute("Sạc nhanh 33 W", 48, 37);
        seedDataVariantAtribute("Android", 49, 37);
        seedDataVariantAtribute("Android 14 (Hyper OS)", 50, 37);

        // Xiaomi Redmi Note 13
        seedDataProduct("Xiaomi Redmi Note 13", "Điện thoại", 0.5, 3, 1, 1);

        // phiên bản Xiaomi Redmi Note 13 128 GB
        seedDataVariant("xiaomiredminote13", 4990000.0, 10, 19);

        // Thông số
        // điện thoại Xiaomi Redmi Note 13 dung lượng 128 GB có 3 màu Đen, Trắng, Xanh giá 4.990.000
        seedDataVariantAtribute("Đen", 3, 38);
        seedDataVariantAtribute("Trắng", 3, 38);
        seedDataVariantAtribute("Xanh", 3, 38);
        seedDataVariantAtribute("128GB", 24, 38);

        // thông số kĩ thuật
        seedDataVariantAtribute("Trung quốc", 1, 38);
        seedDataVariantAtribute("01/2024", 2, 38);
        seedDataVariantAtribute("18", 4, 38);
        seedDataVariantAtribute("162.24 x 75.55 x 7.97 mm", 5, 38);
        seedDataVariantAtribute("188.5 g", 6, 38);
        seedDataVariantAtribute("Khung máy: Nhựa, MMặt lưng máy: Nhựa", 7, 38);
        seedDataVariantAtribute("IP54", 8, 38);
        seedDataVariantAtribute("Snapdragon 685", 9, 38);
        seedDataVariantAtribute("6 GB", 13, 38);
        seedDataVariantAtribute("6.7 inch", 14, 38);
        seedDataVariantAtribute("AMOLED", 15, 38);
        seedDataVariantAtribute("FHD+", 16, 38);
        seedDataVariantAtribute("1080 x 2400 Pixels", 17, 38);
        seedDataVariantAtribute("120 Hz", 22, 38);
        seedDataVariantAtribute("Không giới hạn", 25, 38);
        seedDataVariantAtribute("MicroSD", 26, 38);
        seedDataVariantAtribute("Tripple rear camera", 27, 38);
        seedDataVariantAtribute("Standard, Ultra Wide, Macro lens", 28, 38);
        seedDataVariantAtribute("108.0 MP,8.0 MP,2.0 MP", 29, 38);
        seedDataVariantAtribute("1080p@60fps", 30, 38);
        seedDataVariantAtribute("Single selfie camera", 32, 38);
        seedDataVariantAtribute("16.0 MP", 33, 38);
        seedDataVariantAtribute("Quay phim FullHD", 34, 38);
        seedDataVariantAtribute("HDR", 35, 38);
        seedDataVariantAtribute("Cảm biến hồng ngoại", 36, 38);
        seedDataVariantAtribute("Mở khóa vân tay màn hình", 37, 38);
        seedDataVariantAtribute("2 Nano SIM", 38, 38);
        seedDataVariantAtribute("2", 39, 38);
        seedDataVariantAtribute("4G", 40, 38);
        seedDataVariantAtribute("Cổng sạc: Type C", 41, 38);
        seedDataVariantAtribute("802.11 a/b/g/n/ac", 42, 38);
        seedDataVariantAtribute("GLONASS,GPS", 43, 38);
        seedDataVariantAtribute("v5.1", 44, 38);
        seedDataVariantAtribute("Android", 49, 38);
        seedDataVariantAtribute("Android 13.0", 50, 38);
        seedDataVariantAtribute("Sạc, Cáp, Ốp lưng, Sách HDSD, Que lấy SIM", 51, 38);

        // Xiaomi Redmi Note 13 Pro+
        seedDataProduct("Xiaomi Redmi Note 13 Pro+", "Điện thoại", 0.5, 3, 1, 1);

        // phiên bản Xiaomi Redmi Note 13 Pro+ 256 GB
        seedDataVariant("xiaomiredminote13proplus", 8990000.0, 10, 20);

        // Thông số
        // điện thoại Xiaomi Redmi Note 13 Pro+ dung lượng 256 GB có 3 màu Đen, Trắng, Xanh giá 8.990.000
        seedDataVariantAtribute("Đen", 3, 39);
        seedDataVariantAtribute("Trắng", 3, 39);
        seedDataVariantAtribute("Xanh", 3, 39);
        seedDataVariantAtribute("256GB", 24, 39);

        // thông số kĩ thuật
        seedDataVariantAtribute("Trung quốc", 1, 39);
        seedDataVariantAtribute("01/2024", 2, 39);
        seedDataVariantAtribute("18", 4, 39);
        seedDataVariantAtribute("161.4 x 74.2 x 8.9 mm", 5, 39);
        seedDataVariantAtribute("204.5 g", 6, 39);
        seedDataVariantAtribute("Khung máy: Nhựa, Mặt lưng máy: Kính", 7, 39);
        seedDataVariantAtribute("IP68", 8, 39);
        seedDataVariantAtribute("Dimensity 7200 Ultra", 9, 39);
        seedDataVariantAtribute("8 GB", 13, 39);
        seedDataVariantAtribute("6.67 inch", 14, 39);
        seedDataVariantAtribute("AMOLED", 15, 39);
        seedDataVariantAtribute("1.5K", 16, 39);
        seedDataVariantAtribute("2712 x 1220 Pixels", 17, 39);
        seedDataVariantAtribute("120 Hz", 22, 39);
        seedDataVariantAtribute("Không giới hạn", 25, 39);
        seedDataVariantAtribute("Không", 26, 39);
        seedDataVariantAtribute("Tripple rear camera", 27, 39);
        seedDataVariantAtribute("Standard, Ultra Wide, Macro lens", 28, 39);
        seedDataVariantAtribute("200 MP,8.0 MP,2.0 MP", 29, 39);
        seedDataVariantAtribute("4K 2160p@30fps", 30, 39);
        seedDataVariantAtribute("Chống rung quang học (OIS)", 31, 39);
        seedDataVariantAtribute("Single selfie camera", 32, 39);
        seedDataVariantAtribute("16.0 MP", 33, 39);
        seedDataVariantAtribute("Quay phim FullHD", 34, 39);
        seedDataVariantAtribute("HDR", 35, 39);
        seedDataVariantAtribute("Cảm biến hồng ngoại", 36, 39);
        seedDataVariantAtribute("Mở khóa vân tay", 37, 39);
        seedDataVariantAtribute("2 Nano SIM", 38, 39);
        seedDataVariantAtribute("2", 39, 39);
        seedDataVariantAtribute("5G", 40, 39);
        seedDataVariantAtribute("Cổng sạc: Type C", 41, 39);
        seedDataVariantAtribute("802.11 a/b/g/n/ac/ax", 42, 39);
        seedDataVariantAtribute("GLONASS,GPS", 43, 39);
        seedDataVariantAtribute("v5.3", 44, 39);
        seedDataVariantAtribute("NFC", 45, 39);
        seedDataVariantAtribute("5000 mAh", 47, 39);
        seedDataVariantAtribute("Sạc nhanh 120 W", 48, 39);
        seedDataVariantAtribute("Android", 49, 39);
        seedDataVariantAtribute("Android 13.0", 50, 39);
        seedDataVariantAtribute("Sạc, Cáp, Ốp lưng, Sách HDSD, Que lấy SIM", 51, 39);

        //MacBook Air
        seedDataProduct("MacBook Air", "Laptop", 1.29, 6, 2, 2);

        // phiên bản  MacBook Air M2 13 2022 8CPU 10GPU 8GB 512GB
        seedDataVariant("MacbookAir13inchm220228CPU10GPU8GB512GB", 31990000.0, 10, 21);

        //MacBook Air 13 inch M2 2022 8CPU 8GPU 8GB/256GB
        seedDataVariant("MacBookAir13inchM220228CPU8GPU8GB256GB", 27990000.0, 10, 21);

        //MacBook Air 13 inch M1 2020 8CPU 7GPU 8GB/256GB
        seedDataVariant("MacBookAir13inchM120208CPU7GPU8GB256GB", 22990000.0, 10, 21);

        // MacBook Air 13 inch M1 2020 8CPU 7GPU 16GB/256GB
        seedDataVariant("MacBookAir13inchM120208CPU7GPU16GB256GB", 29990000.0, 10, 21);

        // Thông số
        // Laptop MacBook Air 13 inch M2 2022 8CPU 10GPU 8GB/512GB có 3 màu Đen, Trắng, Xám giá 31.990.000
        seedDataVariantAtribute("Đen", 3, 40);
        seedDataVariantAtribute("Trắng", 3, 40);
        seedDataVariantAtribute("Xám", 3, 40);
        seedDataVariantAtribute("512GB", 24, 40);

        // thông số kĩ thuật
        seedDataVariantAtribute("Apple", 60, 40);
        seedDataVariantAtribute("M2", 61, 40);
        seedDataVariantAtribute("8 - Core", 10, 40);
        seedDataVariantAtribute("2.3 Ghz", 62, 40);
        seedDataVariantAtribute("Apple", 63, 40);
        seedDataVariantAtribute("GPU 10 nhân", 64, 40);
        seedDataVariantAtribute(" Apple M2 GPU 10 nhân", 64, 40);
        seedDataVariantAtribute("8 GB", 13, 40);
        seedDataVariantAtribute("LPDDR4", 66, 40);
        seedDataVariantAtribute("3200 MHz", 67, 40);
        seedDataVariantAtribute("3200 MHz", 1, 40);
        seedDataVariantAtribute("8 GB", 69, 40);
        seedDataVariantAtribute("SSD", 70, 40);
        seedDataVariantAtribute("M2. PCIe", 71, 40);
        seedDataVariantAtribute("13.6 inch", 14, 40);
        seedDataVariantAtribute("Retina", 15, 40);
        seedDataVariantAtribute("2560 x 1644 Pixels", 17, 40);
        seedDataVariantAtribute("LED", 72, 40);
        seedDataVariantAtribute("60 Hz", 22, 40);
        seedDataVariantAtribute("IPS", 73, 40);
        seedDataVariantAtribute("500 nits", 74, 40);
        seedDataVariantAtribute("2 Type C,Audio Jack: Jack 3.5 mm,Cổng sạc: Magsafe Charger", 41, 40);
        seedDataVariantAtribute("802.11 ax", 42, 40);
        seedDataVariantAtribute("v5.0", 44, 40);
        seedDataVariantAtribute("Full HD Webcam (1080p Webcam)", 74, 40);
        seedDataVariantAtribute("MacOS", 49, 40);
        seedDataVariantAtribute("Ventura", 50, 40);
        seedDataVariantAtribute("Mở khóa vân tay", 37, 40);
        seedDataVariantAtribute("English International Backlit Keyboard", 52, 40);
        seedDataVariantAtribute("Không", 53, 40);
        seedDataVariantAtribute("LED", 54, 40);
        seedDataVariantAtribute("Trắng", 55, 40);
        seedDataVariantAtribute("Multi-touch touchpad", 56, 40);
        seedDataVariantAtribute("Lithium polymer", 46, 40);
        seedDataVariantAtribute("18 Giờ", 47, 40);
        seedDataVariantAtribute("35 W", 75, 40);
        seedDataVariantAtribute("Adapter,Dây cáp sạc", 51, 40);
        seedDataVariantAtribute("4", 57, 40);
        seedDataVariantAtribute("30.41 x 21.5 x 1.13 cm", 5, 40);
        seedDataVariantAtribute("1.24 kg", 6, 40);
        seedDataVariantAtribute("Kim loại", 7, 40);
        seedDataVariantAtribute("Trung quốc", 1, 40);
        seedDataVariantAtribute("2022", 2, 40);
        seedDataVariantAtribute("12", 4, 40);

        // Laptop MacBook Air 13 inch M2 2022 8CPU 10GPU 8GB/256GB có 3 màu Đen, Trắng, Ghi giá 27.990.000
        seedDataVariantAtribute("Đen", 3, 41);
        seedDataVariantAtribute("Trắng", 3, 41);
        seedDataVariantAtribute("Xám", 3, 41);
        seedDataVariantAtribute("256GB", 24, 41);
        seedDataVariantAtribute("GPU 8 nhân", 64, 41);
        seedDataVariantAtribute(" Apple M2 GPU 8 nhân", 64, 41);
        seedDataVariantAtribute("30 W", 75, 41);

        // Laptop MacBook Air 13 inch M1 2020 8CPU 7GPU 8GB/256GB có 3 màu Đen, Trắng, Ghi giá 22.990.000
        seedDataVariantAtribute("Đen", 3, 42);
        seedDataVariantAtribute("Trắng", 3, 42);
        seedDataVariantAtribute("Xám", 3, 42);
        seedDataVariantAtribute("256GB", 24, 42);
        seedDataVariantAtribute("M1", 61, 42);
        seedDataVariantAtribute("8", 11, 42);
        seedDataVariantAtribute("8", 76, 42);
        seedDataVariantAtribute("Share", 77, 42);
        seedDataVariantAtribute("GPU 7 nhân", 64, 42);
        seedDataVariantAtribute(" Apple M1 GPU 7 nhân", 64, 41);


        // endregion
        SeedDataCategoryAttribute(1L, 1L);
        SeedDataCategoryAttribute(1L, 2L);
        SeedDataCategoryAttribute(1L, 3L);
        SeedDataCategoryAttribute(1L, 4L);
        SeedDataCategoryAttribute(1L, 5L);
        SeedDataCategoryAttribute(1L, 6L);
        SeedDataCategoryAttribute(1L, 7L);
        SeedDataCategoryAttribute(1L, 8L);
        SeedDataCategoryAttribute(1L, 9L);
        SeedDataCategoryAttribute(1L, 10L);
        SeedDataCategoryAttribute(1L, 11L);
        SeedDataCategoryAttribute(1L, 12L);
        SeedDataCategoryAttribute(2L, 15L);
        SeedDataCategoryAttribute(2L, 16L);

    }
    public void SeedDataCategoryAttribute(Long category_id, Long attribute_id) {
        List<Category_Atrribute>  category_attribute = categoryAttributeRepository.findByCategoryIdAndAttributeId(category_id, attribute_id);
        if (category_attribute.isEmpty()) {
            Category_Atrribute categoryAttribute = new Category_Atrribute();
            categoryAttribute.setCategory(categoryRepository.findById(category_id).get());
            categoryAttribute.setAttribute(attributeRepository.findById(attribute_id).get());
            categoryAttributeRepository.save(categoryAttribute);
        }
    }

    public void seedDataVariant(String image, Double price, int quantity, int product_id) {
        List<Variant> variants = variantRepository.findByProductsIdAndPrice((long) product_id, price);
        if (variants.isEmpty()) {
            Variant variant = new Variant();
            variant.setImage(image);
            variant.setPrice(price);
            variant.setQuantity(quantity);
            variant.setProducts(productRepository.findById((long) product_id).get());
            variantRepository.save(variant);
        }
    }

    public void seedDataVariantAtribute(String value, int attribute_id, int variant_id) {
        List<Variant_Attribute> variantAttributes = variantValueRepository.findVariant_AttributesByVariant_IdAndAndAttribute_Id((long) variant_id, (long) attribute_id);
        if (variantAttributes.isEmpty()) {
            Variant_Attribute variant_attribute = new Variant_Attribute();
            variant_attribute.setValue(value);
            variant_attribute.setAttribute(attributeRepository.findById((long) attribute_id).get());
            variant_attribute.setVariant(variantRepository.findById((long) variant_id).get());
            variantValueRepository.save(variant_attribute);
        }
    }

    public void seedDataProduct(String name, String description, Double weight, int brand_id, int category_id, int warranty_id) {
        Optional<Product> products = productRepository.findProductByName(name);
        if (products.isEmpty()) {
            Product product = new Product();
            product.setName(name);
            product.setDescription(description);
            product.setWeight(weight);
            product.setBrand(brandRepository.findById((long) brand_id).get());
            product.setCategory(categoryRepository.findById((long) category_id).get());
            product.setWarranty(warrantyRepository.findById((long) warranty_id).get());
            productRepository.save(product);
        }
    }

    public void seedDataCustomer(String name, String phone, String address, String email, String district, String city) {
        Optional<Customer> customers = customerRepository.findCustomerByPhoneOrEmail(phone, email);
        if (customers.isEmpty()) {
            Customer customer = new Customer(name, email, phone, address, district, city);
            customerRepository.save(customer);
        }
    }

    public void seedDataAccount(String username, String password, String phone, Long role_id) {
        Optional<Account> accounts = accountRepository.findAccountByUsername(username);
        if (accounts.isEmpty()) {
            Account account = new Account();
            account.setUsername(username);
            account.setPassword(password);
            account.setPhone(phone);
            account.setRole(roleRepository.findById(role_id).get());
            accountRepository.save(account);
        }
    }



    public void seedDataAttribute(String name, String parent) {
        // Tìm kiếm tất cả các thuộc tính theo tên
        List<Attribute> existingAttributes = attributeRepository.findAttributesByName(name);

        // Kiểm tra nếu không có bản ghi nào hoặc tất cả đều có parent khác
        boolean isDuplicate = existingAttributes.stream()
                .anyMatch(attr -> attr.getParent().equals(parent));

        if (!isDuplicate) {
            Attribute attribute = new Attribute();
            attribute.setName(name);
            attribute.setParent(parent);
            attributeRepository.save(attribute);
        }
    }


    public void seedDataBrand(String name) {
        Optional<Brand> brands = brandRepository.findBrandByName(name);
        if (brands.isEmpty()) {
            Brand brand = new Brand();
            brand.setName(name);
            brandRepository.save(brand);
        }
    }

    public void seedDataCategory(String name) {
        Optional<Category> categories = categoryRepository.findCategoryByName(name);
        if (categories.isEmpty()) {
            Category category = new Category();
            category.setName(name);
            categoryRepository.save(category);
        }
    }

    public void seedDataSupplier(String name, String email, String phone, String address, String status) {
        Optional<Supplier> suppliers = supplierRepository.findSupplierByName(name);
        if (suppliers.isEmpty()) {
            Supplier supplier = new Supplier();
            supplier.setName(name);
            supplier.setEmail(email);
            supplier.setPhone(phone);
            supplier.setAddress(address);
            supplier.setStatus(status);
            supplierRepository.save(supplier);
        }
    }

    public void seedDataCarrier(String name) {
        Optional<Carrier> carriers = carrierRepository.findCarrierByName(name);
        if (carriers.isEmpty()) {
            Carrier carrier = new Carrier();
            carrier.setName(name);
            carrierRepository.save(carrier);
        }
    }

    public void seedDataWarranty(String name, String unit, int value) {
        Optional<Warranty> warranties = warrantyRepository.findWarrantyByName(name);
        if (warranties.isEmpty()) {
            Warranty warranty = new Warranty();
            warranty.setName(name);
            warranty.setUnit(unit);
            warranty.setValue(value);
            warrantyRepository.save(warranty);
        }
    }

    public void seedDataRole(String name) {
        Optional<Role> roles = roleRepository.findRoleByName(name);
        if (roles.isEmpty()) {
            Role role = new Role();
            role.setName(name);
            roleRepository.save(role);
        }
    }

    public void seedDataFunction(String name) {
        Optional<Function> functions = functionRepository.findFunctionByName(name);
        if (functions.isEmpty()) {
            Function function = new Function();
            function.setName(name);
            functionRepository.save(function);
        }
    }

    public void seedDataModule(String name) {
        Optional<Module> modules = moduleRepository.findModuleByName(name);
        if (modules.isEmpty()) {
            Module module = new Module();
            module.setName(name);
            moduleRepository.save(module);
        }
    }

    public void seedDataDecentralization(String role_name, String module_name, String function_name) {
        Decentralization decentralization = new Decentralization();
        Optional<Role> roleOptional = roleRepository.findRoleByName(role_name);
        if (roleOptional.isPresent()) {
            Role role = roleOptional.get();
            decentralization.setRole(role);
        }
        Optional<Module> moduleOptional = moduleRepository.findModuleByName(module_name);
        if (moduleOptional.isPresent()) {
            Module module = moduleOptional.get();
            decentralization.setModule(module);
        }
        Optional<Function> functionOptional = functionRepository.findFunctionByName(function_name);
        if (functionOptional.isPresent()) {
            Function function = functionOptional.get();
            decentralization.setFunction(function);
        }
        decentralizationRepository.save(decentralization);
    }

}
