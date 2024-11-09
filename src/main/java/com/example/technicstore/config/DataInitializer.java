package com.example.technicstore.config;

import com.example.technicstore.entity.*;
import com.example.technicstore.entity.Module;
import com.example.technicstore.repository.*;
import com.example.technicstore.repository.Variant_AttributeRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.Date;
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
    private final OrderRepository orderRepository;
    private final OrderDetailRepository orderDetailRepository;
    private final DecentralizationRepository decentralizationRepository;

    private final AccountRepository accountRepository;

    private final ProductRepository productRepository;


    private final VariantRepository variantRepository;

    private final Variant_AttributeRepository variantValueRepository;
    private final CategoryAttributeRepository categoryAttributeRepository;


    public DataInitializer(CustomerRepository customerRepository, AttributeRepository attributeRepository, BrandRepository brandRepository, CategoryRepository categoryRepository, SupplierRepository supplierRepository, CarrierRepository carrierRepository, WarrantyRepository warrantyRepository, RoleRepository roleRepository, FunctionRepository functionRepository, ModuleRepository moduleRepository, DecentralizationRepository decentralizationRepository, AccountRepository accountRepository, ProductRepository productRepository, ImeiRepository imeiRepository, VariantRepository variantRepository, Variant_AttributeRepository variantValueRepository1, CategoryAttributeRepository categoryAttributeRepository,OrderRepository orderRepository,OrderDetailRepository orderDetailRepository) {
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
        this.variantRepository = variantRepository;
        this.variantValueRepository = variantValueRepository1;
        this.categoryAttributeRepository = categoryAttributeRepository;
        this.orderDetailRepository = orderDetailRepository;
        this.orderRepository = orderRepository;
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
        //endregion

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
        seedDataAttribute("Độ phủ màu", "Đồ họa");
        seedDataAttribute("Dung lượng RAM", "RAM"); //79
        seedDataAttribute("Tỉ lệ màn hình", "Màn hình"); //80
        seedDataAttribute("Công nghệ âm thanh", "Âm Thanh"); //81
        seedDataAttribute("Quạt tản nhiệt ", "Thiết kế & Trọng lượng"); // 82
        seedDataAttribute("Hãng (Card rời ) ", "Đồ họa"); // 83
        seedDataAttribute("Model (Card rời ) ", "Đồ họa"); // 84
        seedDataAttribute("Bộ Nhớ Đệm ", "RAM"); // 85
        seedDataAttribute("Loại tai nghe ", "Âm Thanh"); // 86
        seedDataAttribute("Model ", "Thông tin hàng hóa"); // 87


        // region brand
        //   Thương hiệu điện thoại
        seedDataBrand("iPhone");
        seedDataBrand("Samsung");
        seedDataBrand("Xiaomi");
        seedDataBrand("Oppo");
        seedDataBrand("Realme");

        //   Thương hiệu laptop
        seedDataBrand("MacBook");
        seedDataBrand("Dell"); //7
        seedDataBrand("HP");
        seedDataBrand("Lenovo"); //9
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
        //iPhone 14
        seedDataProduct("iPhone 14", "Điện thoại", 0.5, 1, 1, 1, "iphone_14_48a46d1684.png");

        // phiên bản iphone 14
        seedDataVariant("iphone14", 21990000.0, 10, 1);
        seedDataVariant("iphone14", 24990000.0, 10, 1);
        seedDataVariant("iphone14", 27990000.0, 10, 1);

        // Thông số
        // điện thoại iphone 14 dung lượng 128 GB có 3 màu Đen, Trắng, Xanh giá 21.990.000
        seedDataVariantAtribute("Đen", 3, 1);
        seedDataVariantAtribute("128GB", 24, 1);

        // điện thoại iphone 14 dung lượng 256 GB có 3 màu Đen, Trắng, Xanh giá 24.990.000
        seedDataVariantAtribute("Xanh", 3, 2);
        seedDataVariantAtribute("256GB", 24, 2);

        // điện thoại iphone 14 dung lượng 512 GB có 3 màu Đen, Trắng, Xanh giá 27.990.000

        seedDataVariantAtribute("Trắng", 3, 3);
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
        seedDataProduct("iPhone 14 Plus", "Điện thoại", 0.5, 1, 1, 1, "iphone_14_48a46d1684.png");

        // phiên bản iphone 14 plus
        seedDataVariant("iphone14plus", 24990000.0, 10, 2);
        seedDataVariant("iphone14plus", 27990000.0, 10, 2);
        seedDataVariant("iphone14plus", 32990000.0, 10, 2);

        // Thông số
        // điện thoại iphone 14 plus dung lượng 128 GB có 3 màu Đen, Trắng, Xanh giá 24.990.000
        seedDataVariantAtribute("Đen", 3, 4);
        seedDataVariantAtribute("128GB", 24, 4);

        // điện thoại iphone 14 plus dung lượng 256 GB có 3 màu Đen, Trắng, Xanh giá 27.990.000
        seedDataVariantAtribute("Trắng", 3, 5);
        seedDataVariantAtribute("256GB", 24, 5);

        // điện thoại iphone 14 plus dung lượng 512 GB có 3 màu Đen, Trắng, Xanh giá 32.990.000
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
        seedDataVariantAtribute("Bluetooth v5.3", 44, 4);
        seedDataVariantAtribute("Lithium-ion", 46, 4);
        seedDataVariantAtribute("4352 mAh", 47, 4);
        seedDataVariantAtribute("iOS", 49, 4);
        seedDataVariantAtribute("iOS 16", 50, 4);
        seedDataVariantAtribute("Cáp sạc, Sách HDSD, Que lấy SIM", 51, 4);

        // iphone 15
        seedDataProduct("iPhone 15", "Điện thoại", 0.5, 1, 1, 1, "iphone_15_a9308b6994.png");

        // phiên bản iphone 15
        seedDataVariant("iphone15", 22990000.0, 10, 3);
        seedDataVariant("iphone15", 25990000.0, 10, 3);
        seedDataVariant("iphone15", 31990000.0, 10, 3);

        // Thông số
        // điện thoại iphone 15 dung lượng 128 GB có 3 màu Đen, Trắng, Xanh giá 22.990.000
        seedDataVariantAtribute("Đen", 3, 7);
        seedDataVariantAtribute("128GB", 24, 7);

        // điện thoại iphone 15 dung lượng 256 GB có 3 màu Đen, Trắng, Xanh giá 25.990.000
        seedDataVariantAtribute("Trắng", 3, 8);
        seedDataVariantAtribute("256GB", 24, 8);

        // điện thoại iphone 15 dung lượng 512 GB có 3 màu Đen, Trắng, Xanh giá 31.990.000
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
        seedDataVariantAtribute("Bluetooth v5.3", 44, 7);
        seedDataVariantAtribute("Lithium-ion", 46, 7);
        seedDataVariantAtribute("20 giờ", 47, 7);
        seedDataVariantAtribute("Hỗ trợ sạc không dây,Sạc pin nhanh,Sạc ngược cho thiết bị khác", 48, 7);
        seedDataVariantAtribute("iOS", 49, 7);
        seedDataVariantAtribute("iOS 17", 50, 7);
        seedDataVariantAtribute("Cáp USB-C to USB-C, Sách HDSD, Que lấy SIM", 51, 7);

        // iphone 15 plus
        seedDataProduct("iPhone 15 Plus", "Điện thoại", 0.5, 1, 1, 1, "iphone_15_a9308b6994.png");

        // phiên bản iphone 15 plus
        seedDataVariant("iphone15plus", 25990000.0, 10, 4);
        seedDataVariant("iphone15plus", 28990000.0, 10, 4);
        seedDataVariant("iphone15plus", 34990000.0, 10, 4);

        // Thông số
        // điện thoại iphone 15 plus dung lượng 128 GB có 3 màu Đen, Trắng, Xanh giá 25.990.000
        seedDataVariantAtribute("Đen", 3, 10);
        seedDataVariantAtribute("128GB", 24, 10);

        // điện thoại iphone 15 plus dung lượng 256 GB có 3 màu Đen, Trắng, Xanh giá 28.990.000

        seedDataVariantAtribute("Trắng", 3, 11);
        seedDataVariantAtribute("256GB", 24, 11);

        // điện thoại iphone 15 plus dung lượng 512 GB có 3 màu Đen, Trắng, Xanh giá 34.990.000
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
        seedDataVariantAtribute("Bluetooth v5.3", 44, 10);
        seedDataVariantAtribute("NFC", 45, 10);
        seedDataVariantAtribute("Lithium-ion", 46, 10);
        seedDataVariantAtribute("26 giờ", 47, 10);
        seedDataVariantAtribute("Hỗ trợ sạc không dây,Sạc pin nhanh,Sạc ngược cho thiết bị khác", 48, 10);
        seedDataVariantAtribute("iOS", 49, 10);
        seedDataVariantAtribute("iOS 17", 50, 10);
        seedDataVariantAtribute("Cáp USB-C to USB-C, Sách HDSD, Que lấy SIM", 51, 10);

        // iphone 15 pro
        seedDataProduct("iPhone 15 Pro", "Điện thoại", 0.5, 1, 1, 1, "iphone_15_pro_max_f589ed5358.png");

        // phiên bản iphone 15 pro
        seedDataVariant("iphone15pro", 28990000.0, 10, 5);
        seedDataVariant("iphone15pro", 31990000.0, 10, 5);
        seedDataVariant("iphone15pro", 37990000.0, 10, 5);
        seedDataVariant("iphone15pro", 43990000.0, 10, 5);

        // Thông số
        // điện thoại iphone 15 pro dung lượng 128 GB có 3 màu Đen, Trắng, Xanh giá 28.990.000
        seedDataVariantAtribute("Đen", 3, 13);
        seedDataVariantAtribute("128GB", 24, 13);

        // điện thoại iphone 15 pro dung lượng 256 GB có 3 màu Đen, Trắng, Xanh giá 31.990.000
        seedDataVariantAtribute("Trắng", 3, 14);
        seedDataVariantAtribute("256GB", 24, 14);

        // điện thoại iphone 15 pro dung lượng 512 GB có 3 màu Đen, Trắng, Xanh giá 37.990.000
        seedDataVariantAtribute("Xanh", 3, 15);
        seedDataVariantAtribute("512GB", 24, 15);

        // điện thoại iphone 15 pro dung lượng 1 TB có 3 màu Đen, Trắng, Xanh giá 43.990.000
        seedDataVariantAtribute("Đen", 3, 16);
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
        seedDataProduct("iPhone 15 Pro Max", "Điện thoại", 0.5, 1, 1, 1, "iphone_15_pro_max_f589ed5358.png");

        // phiên bản iphone 15 pro max
        seedDataVariant("iphone15promax", 34990000.0, 10, 6);
        seedDataVariant("iphone15promax", 40990000.0, 10, 6);
        seedDataVariant("iphone15promax", 46990000.0, 10, 6);

        // Thông số
        // điện thoại iphone 15 pro max dung lượng 256 GB có 3 màu Đen, Trắng, Xanh giá 34.990.000
        seedDataVariantAtribute("Đen", 3, 17);
        seedDataVariantAtribute("256GB", 24, 17);

        // điện thoại iphone 15 pro max dung lượng 512 GB có 3 màu Đen, Trắng, Xanh giá 40.990.000
        seedDataVariantAtribute("Trắng", 3, 18);
        seedDataVariantAtribute("512GB", 24, 18);

        // điện thoại iphone 15 pro max dung lượng 1 TB có 3 màu Đen, Trắng, Xanh giá 46.990.000
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
        seedDataProduct("iPhone 16", "Điện thoại", 0.5, 1, 1, 1, "iphone_16_f27848b783.png");

        // phiên bản iphone 16
        seedDataVariant("iphone16", 22990000.0, 10, 7);
        seedDataVariant("iphone16", 25990000.0, 10, 7);
        seedDataVariant("iphone16", 30990000.0, 10, 7);

        // Thông số
        // điện thoại iphone 16 dung lượng 128 GB có 3 màu Đen, Trắng, Xanh giá 22.990.000
        seedDataVariantAtribute("Đen", 3, 20);
        seedDataVariantAtribute("128GB", 24, 20);

        // điện thoại iphone 16 dung lượng 256 GB có 3 màu Đen, Trắng, Xanh giá 25.990.000
        seedDataVariantAtribute("Trắng", 3, 21);
        seedDataVariantAtribute("256GB", 24, 21);

        // điện thoại iphone 16 dung lượng 512 GB có 3 màu Đen, Trắng, Xanh giá 30.990.000
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
        seedDataProduct("iPhone 16 Pro", "Điện thoại", 0.5, 1, 1, 1, "iphone_16_f27848b783.png");

        // phiên bản iphone 16 pro
        seedDataVariant("iphone16pro", 28990000.0, 10, 8);
        seedDataVariant("iphone16pro", 31990000.0, 10, 8);
        seedDataVariant("iphone16pro", 37990000.0, 10, 8);
        seedDataVariant("iphone16pro", 43990000.0, 10, 8);

        // Thông số
        // điện thoại iphone 16 pro dung lượng 128 GB có 3 màu Đen, Trắng, Xanh giá 28.990.000
        seedDataVariantAtribute("Đen", 3, 23);
        seedDataVariantAtribute("128GB", 24, 23);

        // điện thoại iphone 16 pro dung lượng 256 GB có 3 màu Đen, Trắng, Xanh giá 31.990.000

        seedDataVariantAtribute("Trắng", 3, 24);
        seedDataVariantAtribute("256GB", 24, 24);

        // điện thoại iphone 16 pro dung lượng 512 GB có 3 màu Đen, Trắng, Xanh giá 37.990.000
        seedDataVariantAtribute("Xanh", 3, 25);
        seedDataVariantAtribute("512GB", 24, 25);

        // điện thoại iphone 16 pro dung lượng 1 TB có 3 màu Đen, Trắng, Xanh giá 43.990.000
        seedDataVariantAtribute("Đen", 3, 26);
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
        seedDataProduct("Samsung Galaxy S24 FE", "Điện thoại", 0.5, 2, 1, 2, "samssung_galaxy_s24_fe_xanh_723e4e6443.png");

        // phiên bản samsung galaxy s24 FE
        seedDataVariant("samsunggalaxys24fe", 16990000.0, 10, 9);

        // Thông số
        // điện thoại samsung galaxy s24 FE dung lượng 128 GB có 3 màu Đen, Trắng, Xanh giá 16.990.000
        seedDataVariantAtribute("Đen", 3, 27);
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
        seedDataProduct("Samsung Galaxy S23", "Điện thoại", 0.5, 2, 1, 2, "samsung_galaxy_s23_591dfc2c85.png");

        // phiên bản samsung galaxy s23
        seedDataVariant("samsunggalaxys23", 24990000.0, 10, 10);

        // Thông số
        // điện thoại samsung galaxy s23 dung lượng 256 GB có 3 màu Đen, Trắng, Xanh giá 24.990.000
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
        seedDataProduct("Samsung Galaxy S24 Ultra", "Điện thoại", 0.5, 2, 1, 2, "samsung_galaxy_s24_ultra_2f8a5ee174.png");

        // phiên bản Samsung Galaxy S24 Ultra
        seedDataVariant("samsunggalaxys24ultra", 33990000.0, 10, 11);
        seedDataVariant("samsunggalaxys24ultra", 37990000.0, 10, 11);

        // Thông số
        // điện thoại Samsung Galaxy S24 Ultra dung lượng 256 GB có 3 màu Đen, Trắng, Xanh giá 33.990.000
        seedDataVariantAtribute("Đen", 3, 29);
        seedDataVariantAtribute("256GB", 24, 29);

        // điện thoại Samsung Galaxy S24 Ultra dung lượng 512 GB có 3 màu Đen, Trắng, Xanh giá 37.990.000
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
        seedDataProduct("Samsung Galaxy Z Flip5", "Điện thoại", 0.5, 2, 1, 2, "2024_3_28_638472353992099331_samsung-galaxy-zflip-5-xanh-ai.jpg");

        // phiên bản Samsung Galaxy Z Flip5
        seedDataVariant("samsunggalaxyzflip5", 25990000.0, 10, 12);

        // Thông số
        // điện thoại Samsung Galaxy Z Flip5 dung lượng 256 GB có 3 màu Đen, Trắng, Xanh giá 25.990.000
        seedDataVariantAtribute("Đen", 3, 31);
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
        seedDataProduct("Samsung Galaxy A06", "Điện thoại", 0.5, 2, 1, 1, "samsung_galaxy_a06_blue_black_1_46d3694f11.png");

        // phiên bản Samsung Galaxy A06
        seedDataVariant("samsunggalaxya06", 3490000.0, 10, 13);

        // Thông số
        // điện thoại Samsung Galaxy A06 dung lượng128 GB có 3 màu Đen, Trắng, Xanh giá 3.490.000
        seedDataVariantAtribute("Đen", 3, 32);
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
        seedDataProduct("Samsung Galaxy A05", "Điện thoại", 0.5, 2, 1, 1, "2023_10_4_638320083060239206_samsung-galaxy-a05-xanh-3.jpg");

        // phiên bản Samsung Galaxy A05
        seedDataVariant("samsunggalaxya05", 2790000.0, 10, 14);

        // Thông số
        // điện thoại Samsung Galaxy A05 dung lượng 128 GB có 3 màu Đen, Trắng, Xanh giá 2.790.000
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
        seedDataProduct("OPPO A3", "Điện thoại", 0.5, 4, 1, 1, "oppo_a3_tim_5_a81a5f4bf7.jpg");

        // phiên bản OPPO A3
        seedDataVariant("oppoa3", 4990000.0, 10, 15);

        // Thông số
        // điện thoại OPPO A3 dung lượng 128 GB có 3 màu Đen, Trắng, Xanh giá 4.990.000
        seedDataVariantAtribute("Đen", 3, 34);
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
        seedDataProduct("OPPO Reno12", "Điện thoại", 0.5, 4, 1, 1, "oppo_reno_12_trang_d776379731.jpg");

        // phiên bản OPPO Reno12 256 GB
        seedDataVariant("opporeno12", 12690000.0, 10, 16);

        // Thông số
        // điện thoại OPPO Reno12 dung lượng 256 GB có 3 màu Đen, Trắng, Xanh giá 12.690.000
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
        seedDataProduct("Xiaomi POCO X6", "Điện thoại", 0.5, 3, 1, 1, "00909923_poco_x6_blue_5e570f66db.png");

        // phiên bản Xiaomi POCO X6 256 GB
        seedDataVariant("xiaomipocox6", 8990000.0, 10, 17);

        // Thông số
        // điện thoại Xiaomi POCO X6 dung lượng 256 GB có 3 màu Đen, Trắng, Xanh giá 8.990.000
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
        seedDataProduct("Xiaomi Poco M6", "Điện thoại", 0.5, 3, 1, 1, "poco_m6_cc5c059d02.png");

        // phiên bản Xiaomi Poco M6 128 GB
        seedDataVariant("xiaomipocom6", 4290000.0, 10, 18);

        // Thông số
        // điện thoại Xiaomi Poco M6 dung lượng 128 GB có 3 màu Đen, Trắng, Xanh giá 4.290.000
        seedDataVariantAtribute("Đen", 3, 37);
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
        seedDataProduct("Xiaomi Redmi Note 13", "Điện thoại", 0.5, 3, 1, 1, "2024_1_5_638400663079293145_xiaomi-redmi-note-13-xanh.png");

        // phiên bản Xiaomi Redmi Note 13 128 GB
        seedDataVariant("xiaomiredminote13", 4990000.0, 10, 19);

        // Thông số
        // điện thoại Xiaomi Redmi Note 13 dung lượng 128 GB có 3 màu Đen, Trắng, Xanh giá 4.990.000
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
        seedDataProduct("Xiaomi Redmi Note 13 Pro+", "Điện thoại", 0.5, 3, 1, 1, "2024_1_5_638400663079293145_xiaomi-redmi-note-13-xanh.png");

        // phiên bản Xiaomi Redmi Note 13 Pro+ 256 GB
        seedDataVariant("xiaomiredminote13proplus", 8990000.0, 10, 20);

        // Thông số
        // điện thoại Xiaomi Redmi Note 13 Pro+ dung lượng 256 GB có 3 màu Đen, Trắng, Xanh giá 8.990.000
        seedDataVariantAtribute("Trắng", 3, 39);
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
        seedDataProduct("MacBook Air", "Laptop", 1.29, 6, 2, 2, "2022_6_7_637901915720184032_macbook-air-m2-2022-den-dd.jpg");


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


        // Macbook pro
        // MacBook pro  14 inch
        seedDataProduct("MacBook Pro", "Laptop", 1.61, 6, 2, 1, "");

        // Phiên bản MacBook Pro 14 2023 M3 Pro 11 CPU/14GPU/18GB/512GB
        seedDataVariant("MacBookPro142023M3Pro11CPU14GPU36GB512GB", 48990000.0, 10, 22);
        seedDataVariantAtribute("Đen", 3, 44);
        seedDataVariantAtribute("Bạc", 3, 44);
        seedDataVariantAtribute("512GB", 24, 44);

        // Phiên bản MacBook Pro 14 2023 M3 Pro 11 CPU/14GPU/36GB/512GB giá 59990000.0
        seedDataVariant("MacBookPro142023M3Pro11CPU14GPU36GB512GB", 59990000.0, 10, 22);
        // Phiên bản MacBook Pro 14 2023 M3 Pro 11 CPU/14GPU/36GB/512GB 2 màu bạc - đen,  giá 59990000.0
        seedDataVariantAtribute("Đen", 3, 45);
        seedDataVariantAtribute("Bạc", 3, 45);
        seedDataVariantAtribute("512GB", 24, 45);

        // Phiên bản MacBook Pro 16 2023 M3 Pro 11 CPU/14GPU/18GB/512GB
        seedDataVariant("MacBookPro162023M3Pro11CPU14GPU36GB512GB", 64490000.0, 10, 22);
        // Phiên bản MacBook Pro 16 2023 M3 Pro 11 CPU/14GPU/18GB/512GB 2 màu bạc - đen,  giá 64490000.0
        seedDataVariantAtribute("Đen", 3, 46); // màu -
        seedDataVariantAtribute("Bạc", 3, 46); // màu -
        seedDataVariantAtribute("512GB", 24, 46); // bộ nhớ ( rom)

        // Phiên bản MacBook Pro 16 2023 M3 Pro 11 CPU/14GPU/36GB/512GB
        seedDataVariant("MacBookPro162023M3Pro11CPU14GPU36GB512GB", 74490000.0, 10, 22);
        seedDataVariantAtribute("Đen", 3, 47); // màu
        seedDataVariantAtribute("Bạc", 3, 47); // màu
        seedDataVariantAtribute("512GB", 24, 47); // bộ nhớ ( rom)

        // MacBook Pro 13" 2020 Touch Bar M1 8CPU 8GPU 8GB/256Gb
        seedDataVariant("MacBookPro 132020TouchBarM18CPU8GPU8GB256Gb", 20490000.0, 10, 22);
        seedDataVariantAtribute("Bạc", 3, 48); // màu bạc
        seedDataVariantAtribute("Xám", 3, 48); // màu bạc
        seedDataVariantAtribute("512GB", 24, 48); // bộ nhớ ( rom)


        // thông số kĩ thuật MacBook Pro 14 2023 M3 Pro 11 CPU/14GPU/18GB/512GB 2 màu bạc - đen,  giá 48990000.0
        seedDataVariantAtribute("Apple", 60, 44);  // Hãng
        seedDataVariantAtribute("M3 Pro", 61, 44); // CPU
        seedDataVariantAtribute("11 - Core", 10, 44); // Số nhân CPU
        seedDataVariantAtribute("2.3 GHz", 62, 44); // Tốc độ CPU
        seedDataVariantAtribute("Apple", 63, 44); // Hãng GPU
        seedDataVariantAtribute("GPU 14 nhân", 64, 44); // Số nhân GPU
        seedDataVariantAtribute("Apple M3 Pro GPU 14 nhân", 65, 44); // Mô tả GPU
        seedDataVariantAtribute("18 GB", 13, 44); // Dung lượng RAM
        seedDataVariantAtribute("6400 MHz", 67, 44); // Tốc độ RAM
        seedDataVariantAtribute("18 GB", 69, 44); // RAM (dung lượng khác)
        seedDataVariantAtribute("SSD", 70, 44); // Loại ổ cứng
        seedDataVariantAtribute("PCIe NVMe", 71, 44); // Chuẩn SSD
        seedDataVariantAtribute("14.2 inch", 14, 44); // Kích thước màn hình
        seedDataVariantAtribute("Liquid Retina XDR", 15, 44); // Loại công nghệ màn hình
        seedDataVariantAtribute("3024 x 1964 Pixels", 17, 44); // Độ phân giải
        seedDataVariantAtribute("120 Hz", 22, 44); // Tần số quét
        seedDataVariantAtribute("IPS", 73, 44); // Panel màn hình
        seedDataVariantAtribute("1600 nits ", 21, 44); // Độ sáng
        seedDataVariantAtribute("1 SD Card, 3 Type C, 1 HDMI,Cổng sạc: Magsafe Charger,Audio Jack: Jack 3.5 mm ", 41, 44); // Cổng kết nối
        seedDataVariantAtribute("Wi-Fi 6E", 42, 44); // Wi-Fi
        seedDataVariantAtribute("Bluetooth 5.3", 44, 44); // Bluetooth
        seedDataVariantAtribute("1080p FaceTime HD camera", 74, 44); // Webcam
        seedDataVariantAtribute("macOS", 49, 44); // Hệ điều hành
        seedDataVariantAtribute("Sonoma", 50, 44); // Phiên bản macOS
        seedDataVariantAtribute("Mở khóa bằng vân tay & mật mã", 37, 44); // Bảo mật
        seedDataVariantAtribute("English International Backlit Keyboard", 52, 44); // Bàn phím
        seedDataVariantAtribute("Trắng", 54, 44); // Đèn nền bàn phím
        seedDataVariantAtribute("Không", 53, 44); // Bàn phím số
        seedDataVariantAtribute("Multi-touch touchpad", 56, 44); // Touchpad
        seedDataVariantAtribute("Lithium polymer", 46, 44); // Loại pin
        seedDataVariantAtribute("22 Giờ", 47, 44); // Thời gian pin
        seedDataVariantAtribute("70 W", 75, 44); // Công suất sạc
        seedDataVariantAtribute("Củ sạc Macbook, Dây sạc, Sách HDSD ", 51, 44); // Phụ kiện đi kèm
        seedDataVariantAtribute("1,55 x 31,26 x 22,12 cm", 5, 44); // Kích thước
        seedDataVariantAtribute("1.61 kg", 6, 44); // Trọng lượng
        seedDataVariantAtribute("Khung máy: Nhôm nguyên khối", 7, 44); // Chất liệu vỏ
        seedDataVariantAtribute("Trung Quốc", 1, 44); // Nơi sản xuất
        seedDataVariantAtribute("10/2023", 2, 44); // Năm ra mắt


        seedDataVariantAtribute("Apple", 60, 45);  // Hãng
        seedDataVariantAtribute("M3 Pro", 61, 45); // CPU
        seedDataVariantAtribute("11 - Core", 10, 45); // Số nhân CPU
        seedDataVariantAtribute("2.3 GHz", 62, 45); // Tốc độ CPU
        seedDataVariantAtribute("Apple", 63, 45); // Hãng GPU
        seedDataVariantAtribute("GPU 14 nhân", 64, 45); // Số nhân GPU
        seedDataVariantAtribute("Apple M3 Pro GPU 14 nhân", 65, 45); // Mô tả GPU
        seedDataVariantAtribute("36 GB", 13, 45); // Dung lượng RAM
        seedDataVariantAtribute("6400 MHz", 67, 45); // Tốc độ RAM
        seedDataVariantAtribute("128 GB", 69, 45); // RAM (dung lượng khác)
        seedDataVariantAtribute("SSD", 70, 45); // Loại ổ cứng
        seedDataVariantAtribute("PCIe NVMe", 71, 45); // Chuẩn SSD
        seedDataVariantAtribute("14.2 inch", 14, 45); // Kích thước màn hình
        seedDataVariantAtribute("Liquid Retina XDR", 15, 45); // Loại công nghệ màn hình
        seedDataVariantAtribute("3024 x 1964 Pixels", 17, 45); // Độ phân giải
        seedDataVariantAtribute("120 Hz", 22, 45); // Tần số quét
        seedDataVariantAtribute("IPS", 73, 45); // Panel màn hình
        seedDataVariantAtribute("1600 nits", 21, 45); // Độ sáng
        seedDataVariantAtribute("1 SD Card, 3 Type C, 1 HDMI, Cổng sạc: Magsafe Charger, Audio Jack: Jack 3.5 mm", 41, 45); // Cổng kết nối
        seedDataVariantAtribute("Wi-Fi 6E", 42, 45); // Wi-Fi
        seedDataVariantAtribute("Bluetooth 5.3", 44, 45); // Bluetooth
        seedDataVariantAtribute("1080p FaceTime HD camera", 74, 45); // Webcam
        seedDataVariantAtribute("Dolby Atmost", 81, 45); // Công nghệ âm thanh
        seedDataVariantAtribute("macOS", 49, 45); // Hệ điều hành
        seedDataVariantAtribute("Sonoma", 50, 45); // Phiên bản macOS
        seedDataVariantAtribute("Mở khóa bằng vân tay & mật mã", 37, 45); // Bảo mật
        seedDataVariantAtribute("English International Backlit Keyboard", 52, 45); // Bàn phím
        seedDataVariantAtribute("Trắng", 54, 45); // Đèn nền bàn phím
        seedDataVariantAtribute("Không", 53, 45); // Bàn phím số
        seedDataVariantAtribute("Multi-touch touchpad", 56, 45); // Touchpad
        seedDataVariantAtribute("Lithium polymer", 46, 45); // Loại pin
        seedDataVariantAtribute("22 Giờ", 47, 45); // Thời gian pin
        seedDataVariantAtribute("70 W", 75, 45); // Công suất sạc
        seedDataVariantAtribute("Củ sạc Macbook, Dây sạc, Sách HDSD", 51, 45); // Phụ kiện đi kèm
        seedDataVariantAtribute("1,55 x 31,26 x 22,12 cm", 5, 45); // Kích thước
        seedDataVariantAtribute("1.61 kg", 6, 45); // Trọng lượng
        seedDataVariantAtribute("Khung máy: Nhôm nguyên khối", 7, 45); // Chất liệu vỏ
        seedDataVariantAtribute("Trung Quốc", 1, 45); // Nơi sản xuất
        seedDataVariantAtribute("10/2023", 2, 45); // Năm ra mắt


        // Thông số kĩ thuật MacBook Pro 16 2023 M3 Pro 11 CPU/14GPU/18GB/512GB
        seedDataVariantAtribute("Apple", 60, 46);  // Hãng
        seedDataVariantAtribute("M3 Pro", 61, 46); // CPU
        seedDataVariantAtribute("12 - Core", 10, 46); // Số nhân CPU
        seedDataVariantAtribute("2.3 GHz", 62, 46); // Tốc độ CPU
        seedDataVariantAtribute("Apple", 63, 46); // Hãng GPU
        seedDataVariantAtribute("GPU 18 nhân", 64, 46); // Số nhân GPU
        seedDataVariantAtribute("Apple M3 Pro GPU 18 nhân", 65, 46); // Mô tả GPU
        seedDataVariantAtribute("18 GB", 13, 46); // Dung lượng RAM
        seedDataVariantAtribute("6400 MHz", 67, 46); // Tốc độ RAM
        seedDataVariantAtribute("1", 68, 46); // RAM (dung lượng khác)
        seedDataVariantAtribute("128 GB", 69, 46); // RAM (dung lượng khác)
        seedDataVariantAtribute("SSD", 70, 46); // Loại ổ cứng
        seedDataVariantAtribute("PCIe NVMe", 71, 46); // Chuẩn SSD
        seedDataVariantAtribute("16.2 inch", 14, 46); // Kích thước màn hình
        seedDataVariantAtribute("Liquid Retina XDR", 15, 46); // Loại công nghệ màn hình
        seedDataVariantAtribute("3456 x 2234 Pixels", 17, 46); // Độ phân giải
        seedDataVariantAtribute("120 Hz", 22, 46); // Tần số quét
        seedDataVariantAtribute("IPS", 73, 46); // Panel màn hình
        seedDataVariantAtribute("1600 nits", 21, 46); // Độ sáng
        seedDataVariantAtribute("1 SD Card, 3 Type C, 1 HDMI, Cổng sạc: Magsafe Charger, Audio Jack: Jack 3.5 mm", 41, 44); // Cổng kết nối
        seedDataVariantAtribute("Wi-Fi 6E", 42, 46); // Wi-Fi
        seedDataVariantAtribute("Bluetooth 5.3v", 44, 46); // Bluetooth
        seedDataVariantAtribute("1080p FaceTime HD camera", 74, 46); // Webcam
        seedDataVariantAtribute("macOS", 49, 46); // Hệ điều hành
        seedDataVariantAtribute("Sonoma", 50, 46); // Phiên bản macOS
        seedDataVariantAtribute("Mở khóa bằng vân tay & mật mã", 37, 46); // Bảo mật
        seedDataVariantAtribute("English International Backlit Keyboard", 52, 46); // Bàn phím
        seedDataVariantAtribute("Trắng", 54, 46); // Đèn nền bàn phím
        seedDataVariantAtribute("Không", 53, 46); // Bàn phím số
        seedDataVariantAtribute("Multi-touch touchpad", 56, 46); // Touchpad
        seedDataVariantAtribute("Lithium polymer", 46, 46); // Loại pin
        seedDataVariantAtribute("22 Giờ", 47, 46); // Thời gian pin
        seedDataVariantAtribute("140 W", 75, 46); // Công suất sạc
        seedDataVariantAtribute("Củ sạc Macbook, Dây sạc, Sách HDSD", 51, 46); // Phụ kiện đi kèm
        seedDataVariantAtribute("1,68 x 35,57 x 24,81 cm", 5, 46); // Kích thước
        seedDataVariantAtribute("2.14 kg", 6, 46); // Trọng lượng
        seedDataVariantAtribute("Khung máy: Nhôm nguyên khối", 7, 46); // Chất liệu vỏ
        seedDataVariantAtribute("Trung Quốc", 1, 46); // Nơi sản xuất
        seedDataVariantAtribute("10/2023", 2, 46); // Năm ra mắt


        // Thống số kĩ thuật MacBook Pro 16 2023 M3 Pro 11 CPU/14GPU/36GB/512GB
        seedDataVariantAtribute("Apple", 60, 47);  // Hãng
        seedDataVariantAtribute("M3 Pro", 61, 47); // CPU
        seedDataVariantAtribute("12 - Core", 10, 47); // Số nhân CPU
        seedDataVariantAtribute("2.3 GHz", 62, 47); // Tốc độ CPU
        seedDataVariantAtribute("Apple", 63, 47); // Hãng GPU
        seedDataVariantAtribute("GPU 18 nhân", 64, 47); // Số nhân GPU
        seedDataVariantAtribute("Apple M3 Pro GPU 18 nhân", 65, 47); // Mô tả GPU
        seedDataVariantAtribute("36 GB", 13, 47); // Dung lượng RAM
        seedDataVariantAtribute("1", 68, 47); // Số RAM onboard
        seedDataVariantAtribute("128 GB", 69, 47); // RAM (dung lượng khác)
        seedDataVariantAtribute("SSD", 70, 47); // Loại ổ cứng
        seedDataVariantAtribute("PCIe NVMe", 71, 47); // Loại SSD
        seedDataVariantAtribute("16.2 inch", 14, 47); // Kích thước màn hình
        seedDataVariantAtribute("Liquid Retina XDR", 15, 47); // Loại công nghệ màn hình
        seedDataVariantAtribute("3456 x 2234 Pixels", 17, 47); // Độ phân giải
        seedDataVariantAtribute("120 Hz", 22, 47); // Tần số quét
        seedDataVariantAtribute("IPS", 73, 47); // Panel màn hình
        seedDataVariantAtribute("1600 nits", 21, 47); // Độ sáng
        seedDataVariantAtribute("1 SD Card, 3 Type C, 1 HDMI, Cổng sạc: Magsafe Charger, Audio Jack: Jack 3.5 mm", 41, 44); // Cổng kết nối
        seedDataVariantAtribute("Wi-Fi 6E", 42, 47); // Wi-Fi
        seedDataVariantAtribute("Bluetooth 5.3v", 44, 47); // Bluetooth
        seedDataVariantAtribute("1080p FaceTime HD camera", 74, 47); // Webcam
        seedDataVariantAtribute("Dolby Atmost", 81, 47); // Công nghệ âm thanh
        seedDataVariantAtribute("macOS", 49, 47); // Hệ điều hành
        seedDataVariantAtribute("Sonoma", 50, 47); // Phiên bản macOS
        seedDataVariantAtribute("Mở khóa bằng vân tay & mật mã", 37, 47); // Bảo mật
        seedDataVariantAtribute("English International Backlit Keyboard", 52, 47); // Bàn phím
        seedDataVariantAtribute("Trắng", 54, 47); // Đèn nền bàn phím
        seedDataVariantAtribute("Không", 53, 47); // Bàn phím số
        seedDataVariantAtribute("Multi-touch touchpad", 56, 47); // Touchpad
        seedDataVariantAtribute("Lithium polymer", 46, 47); // Loại pin
        seedDataVariantAtribute("22 Giờ", 47, 47); // Thời gian pin
        seedDataVariantAtribute("140 W", 75, 47); // Công suất sạc
        seedDataVariantAtribute("Củ sạc Macbook, Dây sạc, Sách HDSD", 51, 47); // Phụ kiện đi kèm
        seedDataVariantAtribute("1,68 x 35,57 x 24,81 cm", 5, 47); // Kích thước
        seedDataVariantAtribute("2.14 kg", 6, 47); // Trọng lượng
        seedDataVariantAtribute("Khung máy: Nhôm nguyên khối", 7, 47); // Chất liệu vỏ
        seedDataVariantAtribute("Trung Quốc", 1, 47); // Nơi sản xuất
        seedDataVariantAtribute("10/2023", 2, 47); // Năm ra mắt


        // Thông số kĩ thuật MacBook Pro 13 inch M1 2020 8CPU 8GPU 8GB/256GB
        seedDataVariantAtribute("Apple", 60, 48);  // Hãng
        seedDataVariantAtribute("M1", 61, 48); // CPU
        seedDataVariantAtribute("8 - Core", 10, 48); // Số nhân CPU
        seedDataVariantAtribute("8", 62, 48); // Tốc độ CPU
        seedDataVariantAtribute("Apple", 63, 48); // Hãng GPU
        seedDataVariantAtribute("GPU 8 nhân", 64, 48); // Số nhân GPU
        seedDataVariantAtribute("Apple M1 GPU 8 nhân", 65, 48); // Mô tả GPU
        seedDataVariantAtribute("8 GB", 13, 48); // Dung lượng RAM
        seedDataVariantAtribute("LPDDR4", 66, 48); // Loại Ram
        seedDataVariantAtribute("16 GB", 69, 48); // RAM (dung lượng khác)
        seedDataVariantAtribute("SSD", 70, 48); // Loại ổ cứng
        seedDataVariantAtribute("PCIe NVMe", 71, 48); // Chuẩn SSD
        seedDataVariantAtribute("13.3 inch", 14, 48); // Kích thước màn hình
        seedDataVariantAtribute("Retina", 15, 48); // Loại công nghệ màn hình
//        seedDataVariantAtribute("LED", 15, 48); // Loại màn hình
        seedDataVariantAtribute("2560 x 1600 Pixels", 17, 48); // Độ phân giải
        seedDataVariantAtribute("60 Hz", 22, 48); // Tần số quét
        seedDataVariantAtribute("IPS", 73, 48); // Panel màn hình
        seedDataVariantAtribute("99% sRGB", 21, 48); // Độ phủ màu ( độ sáng )
        seedDataVariantAtribute("2 Type C, Audio Jack: Jack 3.5 mm, 2 Thunderbolt", 41, 48); // Cổng kết nối
        seedDataVariantAtribute("Wi-Fi 802.11 ax", 42, 48); // Wi-Fi
        seedDataVariantAtribute("Bluetooth 5.0v", 44, 48); // Bluetooth
        seedDataVariantAtribute("720p FaceTime HD camera", 74, 48); // Webcam
        seedDataVariantAtribute("macOS", 49, 48); // Hệ điều hành
        seedDataVariantAtribute("Big Sur", 50, 48); // Phiên bản macOS
        seedDataVariantAtribute("Mở khóa bằng vân tay & mật mã", 37, 48); // Bảo mật
        seedDataVariantAtribute("English International Backlit Keyboard", 52, 48); // Bàn phím
        seedDataVariantAtribute("Trắng", 54, 48); // Đèn nền bàn phím
        seedDataVariantAtribute("Không", 53, 48); // Bàn phím số
        seedDataVariantAtribute("Multi-touch touchpad", 56, 48); // Touchpad
        seedDataVariantAtribute("Lithium polymer", 46, 48); // Loại pin
        seedDataVariantAtribute("20 Giờ", 47, 48); // Thời gian pin
        seedDataVariantAtribute("61 W", 75, 48); // Công suất sạc
        seedDataVariantAtribute("Củ sạc Macbook, Dây sạc", 51, 48); // Phụ kiện đi kèm
        seedDataVariantAtribute("2", 57, 48); // Số lượng loa
        seedDataVariantAtribute("1,56 x 30,41 x 21,24 cm", 5, 48); // Kích thước
        seedDataVariantAtribute("1.4 kg", 6, 48); // Trọng lượng
        seedDataVariantAtribute("Mặt bàn phím + kê tay: Nhôm, Mặt lưng máy: Nhôm, Mặt bên ngoài cùng: Nhôm, Khung màn hình: Nhựa", 7, 48); // Chất liệu vỏ
        seedDataVariantAtribute("Trung Quốc", 1, 48); // Nơi sản xuất
        seedDataVariantAtribute("11/2020", 2, 48); // Năm ra mắt

        // Laptop dell
        seedDataProduct("Laptop Dell Inspiron ", "Laptop", 1.54, 7, 2, 4, "");

        // Phiên bản Laptop Dell Inspiron 14 N5440 i5 1334U/16GB/512GB/14"FHD+/Win11/Office HS21
        seedDataVariant("Laptop Dell Inspiron 14N 5440 i5 1334U", 20190000.0, 10, 23);


        // Phiên bản Laptop Dell Inspiron 14 N5440 i5 1334U/16GB/512GB/14"FHD+/Win11/Office HS21
        seedDataVariantAtribute("Xanh", 3, 49); // màu
        seedDataVariantAtribute("512GB", 24, 49); // bộ nhớ ( rom)
        seedDataVariantAtribute("Dell", 60, 49);  // Hãng
        seedDataVariantAtribute("Intel Core i5", 61, 49); // CPU
        seedDataVariantAtribute("1334U", 10, 49); // Loại CPU
        seedDataVariantAtribute("4.6 GHz", 62, 49); // Tốc độ CPU tối đa
        seedDataVariantAtribute("Intel Iris Xe Graphics", 63, 49); // Hãng GPU
        seedDataVariantAtribute("16 GB ( 2 thanh 8 GB)", 13, 49); // Dung lượng RAM
        seedDataVariantAtribute("DDR5", 66, 49); // Loại RAM
        seedDataVariantAtribute("16 GB", 69, 49); // Hỗ trợ RAM tối đa
        seedDataVariantAtribute("SSD", 70, 49); // Loại ổ cứng
        seedDataVariantAtribute("M2. PCIe", 71, 49); // Chuẩn SSD
        seedDataVariantAtribute("512", 79, 49); // Dung lượng ram
        seedDataVariantAtribute("14 inch", 14, 49); // Kích thước màn hình
        seedDataVariantAtribute("FHD+", 15, 49); // Công nghệ màn hình
        seedDataVariantAtribute("1920 x 1200 Pixels", 17, 49); // Độ phân giải
        seedDataVariantAtribute("60 Hz", 22, 49); // Tần số quét
        seedDataVariantAtribute("WVA", 73, 49); // Panel màn hình
        seedDataVariantAtribute("250 nits", 21, 49); // Độ sáng
        seedDataVariantAtribute("45% NTSC", 78, 49); // Độ phủ màu
        seedDataVariantAtribute("1 HDMI, 2 USB Type-C, 1 USB 3.2, Audio Jack: Jack 3.5 mm", 41, 49); // Cổng kết nối
        seedDataVariantAtribute("Wi-Fi 802.11 ax", 42, 49); // Wi-Fi
        seedDataVariantAtribute("Bluetooth 5.3v", 44, 49); // Bluetooth
        seedDataVariantAtribute("720p HD camera", 74, 49); // Webcam
        seedDataVariantAtribute("Windows ", 49, 49); // Hệ điều hành
        seedDataVariantAtribute("Windows 11 Home Single Language", 50, 49); // Phiên bản OS
        seedDataVariantAtribute("Hỗ trợ bảo mật vân tay & Mật khẩu", 37, 49); // Bảo mật
        seedDataVariantAtribute("English International Keyboard", 52, 49); // Bàn phím
        seedDataVariantAtribute("Trắng", 54, 49); // Đèn nền bàn phím
        seedDataVariantAtribute("Không", 53, 49); // Bàn phím số
        seedDataVariantAtribute("Multi-touch touchpad", 56, 49); // Touchpad
        seedDataVariantAtribute("3 Cell", 46, 49); // Loại pin
        seedDataVariantAtribute("10 Giờ", 48, 49); // Thời gian pin ( thông tin thêm)
        seedDataVariantAtribute("41 W", 75, 49); // Công suất sạc
        seedDataVariantAtribute("Adapter sạc, Dây sạc, Sách hướng dẫn", 51, 49); // Phụ kiện đi kèm
        seedDataVariantAtribute("31.40 x 22.62 x 1.99 cm", 5, 49); // Kích thước
        seedDataVariantAtribute("1.54 kg", 6, 49); // Trọng lượng
        seedDataVariantAtribute("Vỏ nhựa", 7, 49); // Chất liệu vỏ
        seedDataVariantAtribute("Trung Quốc", 1, 49); // Nơi sản xuất
        seedDataVariantAtribute("1/2023", 2, 49); // Năm ra mắt


        // Laptop Dell Inspiron 15 N3530 i5 1335U/16GB/512GB/15.6"FHD/NVIDIA MX550 2GB/Win11/Office HS21

        // thông số kĩ thuật
        seedDataVariant("Laptop Dell Inspiron 15N 3530 i5 1355U", 21490000.0, 10, 23);
        seedDataVariantAtribute("Đen", 3, 50); // màu
        seedDataVariantAtribute("512GB", 24, 50); // bộ nhớ ( rom)
        seedDataVariantAtribute("Dell", 60, 50);  // Hãng
        seedDataVariantAtribute("Intel Core i5", 61, 50); // CPU
        seedDataVariantAtribute("1335U", 9, 50); // Phiên bản CPU
        seedDataVariantAtribute("8 Core", 10, 50); // Số nhân CPU
        seedDataVariantAtribute("8", 11, 50); // Số nhân CPU
        seedDataVariantAtribute("12 ", 76, 50); // Số luồng CPU
        seedDataVariantAtribute("4.6 GHz", 62, 50); // Tốc độ CPU tối đa
        seedDataVariantAtribute("NVIDIA", 63, 50); // Hãng GPU
        seedDataVariantAtribute("GeForce MX550", 64, 50); // Model GPU
        seedDataVariantAtribute("2 GB", 77, 50); // Độ phụ màu (VRAM)
        seedDataVariantAtribute("16 GB", 13, 50); // Dung lượng RAM
        seedDataVariantAtribute("DDR4", 66, 50); // Loại RAM
        seedDataVariantAtribute("2666 MHz", 67, 50); // Tốc độ RAM
        seedDataVariantAtribute("16 GB", 79, 50); // RAM (dung lượng khác)
        seedDataVariantAtribute("SSD", 70, 50); // Kiểu ổ cứng
        seedDataVariantAtribute("M.2 NVMe", 71, 50); // Loại SSD
        seedDataVariantAtribute("15.6 inch", 14, 50); // Kích thước màn hình
        seedDataVariantAtribute("Anti-Glare LED-Backlit Display", 15, 50); // Công nghệ màn hình
        seedDataVariantAtribute("FHD 1920 x 1080 Pixels", 17, 50); // Độ phân giải
        seedDataVariantAtribute("120 Hz", 22, 50); // Tần số quét
        seedDataVariantAtribute("WVA", 73, 50); // Panel màn hình
        seedDataVariantAtribute("250 nits", 21, 50); // Độ sáng
        seedDataVariantAtribute("45% NTSC", 78, 50); // Độ phủ màu
        seedDataVariantAtribute("16:09 ", 80, 50); // tỉ lệ màn hình
        seedDataVariantAtribute("600:1 ", 21, 50); // độ tương phản
        seedDataVariantAtribute("1 HDMI, 1 USB Type-C, 1 USB 3.2, Audio Jack: Jack 3.5 mm", 41, 50); // Cổng kết nối
        seedDataVariantAtribute("Wi-Fi 6, 802.11 ax", 42, 50); // Wi-Fi
        seedDataVariantAtribute("Bluetooth 5.3v", 44, 50); // Bluetooth
        seedDataVariantAtribute("720p HD camera", 74, 50); // Webcam
        seedDataVariantAtribute("Realtek ALC3204", 81, 50); // Công nghệ âm thanh
        seedDataVariantAtribute("Windows", 49, 50); // Hệ điều hành
        seedDataVariantAtribute("Windows 11 Office Home & Student", 50, 50); // Phiên bản OS
        seedDataVariantAtribute("Hỗ trợ bảo mật mật khẩu ", 37, 50); // Bảo mật
        seedDataVariantAtribute("English International Keyboard", 52, 50); // Bàn phím
        seedDataVariantAtribute("Có", 53, 50); // Bàn phím số
        seedDataVariantAtribute("Không", 54, 50); // Đèn nền bàn phím
        seedDataVariantAtribute("Multi-touch touchpad", 56, 50); // Touchpad
        seedDataVariantAtribute("Lithium polymer", 46, 50); // Loại pin
        seedDataVariantAtribute("65 W", 75, 50); // Công suất sạc
        seedDataVariantAtribute("Adapter sạc, Dây sạc, Sách hướng dẫn", 51, 50); // Phụ kiện đi kèm
        seedDataVariantAtribute("358 x 236 x 18 mm", 5, 50); // Kích thước
        seedDataVariantAtribute("1.66 kg", 6, 50); // Trọng lượng
        seedDataVariantAtribute("Vỏ nhôm và nhựa", 7, 50); // Chất liệu vỏ
        seedDataVariantAtribute("Trung Quốc", 1, 50); // Nơi sản xuất
        seedDataVariantAtribute("2023", 2, 50); // Năm ra mắt


        // Thông số kỹ thuật
        seedDataVariant("Laptop Dell Inspiron 15N 3530 i7 1335U", 20290000.0, 10, 23);
        // Laptop Dell Inspiron 15 N3530 i7 1355U/16GB/512GB/15.6"FHD/Win11/Office 365 Personal
        seedDataVariantAtribute("Đen", 3, 51); // Màu sắc
        seedDataVariantAtribute("512 GB", 24, 51); // Dung lượng ổ cứng
        seedDataVariantAtribute("Dell", 60, 51);  // Hãng
        seedDataVariantAtribute("Intel", 61, 51); // Hãng CPU
        seedDataVariantAtribute("Core i7", 12, 51); // Công nghệ CPU
        seedDataVariantAtribute("1355U", 9, 51); // Loại CPU
        seedDataVariantAtribute("0.4 GHz", 11, 51); // Tốc độ CPU tối thiểu
        seedDataVariantAtribute("5 GHz", 62, 51); // Tốc độ CPU tối đa
        seedDataVariantAtribute("12 MB", 58, 51); // Bộ nhớ đệm CPU
        seedDataVariantAtribute("Intel", 63, 51); // Hãng (Card onboard)
        seedDataVariantAtribute("Intel Iris Xe Graphics", 65, 51); // Tên đầy đủ (Card onboard)
        seedDataVariantAtribute("16 GB", 13, 51); // Dung lượng RAM
        seedDataVariantAtribute("DDR4", 66, 51); // Loại RAM
        seedDataVariantAtribute("2666 MHz", 67, 51); // Tốc độ RAM
        seedDataVariantAtribute("2", 76, 51); // Số khe cắm rời
        seedDataVariantAtribute("16 GB", 79, 51); // Hỗ trợ RAM tối đa
        seedDataVariantAtribute("SSD", 70, 51); // Kiểu ổ cứng
        seedDataVariantAtribute("1", 68, 51); // Tổng số khe cắm SSD/HDD
        seedDataVariantAtribute("M.2 PCIe NVMe", 71, 51); // Loại SSD
        seedDataVariantAtribute("2280", 77, 51); // Chuẩn M.2
        seedDataVariantAtribute("15.6 inch", 14, 51); // Kích thước màn hình
        seedDataVariantAtribute("Anti-Glare", 15, 51); // Công nghệ màn hình
        seedDataVariantAtribute("1920 x 1080 Pixels", 17, 51); // Độ phân giải
        seedDataVariantAtribute("LED", 72, 51); // Loại màn hình
        seedDataVariantAtribute("120 Hz", 22, 51); // Tần số quét
        seedDataVariantAtribute("WVA", 73, 51); // Tấm nền
        seedDataVariantAtribute("250 nits", 21, 51); // Độ sáng
        seedDataVariantAtribute("45% NTSC", 78, 51); // Độ phủ màu
        seedDataVariantAtribute("16:09", 80, 51); // Tỷ lệ màn hình
        seedDataVariantAtribute("1 USB 3.2, 1 HDMI 1.4, 1 USB 2.0, 1 Universal audio port, 1 USB 3.2 Gen 1 Type-C", 41, 51); // Cổng giao tiếp
        seedDataVariantAtribute("Wi-Fi 6", 42, 51); // Wi-Fi
        seedDataVariantAtribute("Bluetooth v5.3", 44, 51); // Bluetooth
        seedDataVariantAtribute("HD", 74, 51); // Webcam
        seedDataVariantAtribute("Realtek ALC3204", 81, 51); // Công nghệ âm thanh
        seedDataVariantAtribute("Windows", 49, 51); // Hệ điều hành
        seedDataVariantAtribute("Windows 11 Home + Office 365 Personal", 50, 51); // Phiên bản OS
        seedDataVariantAtribute("Mở khóa vân tay, Mật khẩu", 37, 51); // Bảo mật
        seedDataVariantAtribute("English International Non-backlit Keyboard", 52, 51); // Kiểu bàn phím
        seedDataVariantAtribute("Có", 53, 51); // Bàn phím số
        seedDataVariantAtribute("Không", 54, 51); // Đèn bàn phím
        seedDataVariantAtribute("Multi-touch touchpad", 56, 51); // Touchpad
        seedDataVariantAtribute("4 viên Lithium-ion", 46, 51); // Loại pin
        seedDataVariantAtribute("65 W", 75, 51); // Power Supply
        seedDataVariantAtribute("Adapter", 51, 51); // Phụ kiện trong hộp
        seedDataVariantAtribute("2", 57, 51); // Số lượng loa
        seedDataVariantAtribute("358.50 x 235.56 x 18.99 mm", 5, 51); // Kích thước
        seedDataVariantAtribute("1.7 kg", 6, 51); // Trọng lượng sản phẩm
        seedDataVariantAtribute("1 quạt", 82, 51); // Tản nhiệt
        seedDataVariantAtribute("Nhựa", 7, 51); // Chất liệu
        seedDataVariantAtribute("Trung Quốc", 1, 51); // Xuất xứ
        seedDataVariantAtribute("2024", 2, 51); // Thời điểm ra mắt
        seedDataVariantAtribute("12 tháng", 4, 51); // Thời gian bảo hành

        // Laptop Dell Vostro
        seedDataProduct("Laptop Dell Vostro", "Laptop", 1.49, 7, 2, 4, "");

        // Laptop Dell Vostro V3430 i5 1335U/16GB/512GB/14"FHD/Nvidia GeForce MX550 2GB/Win11/Office HS21
        seedDataVariant("Laptop Dell Vostro V3430 i5 1335U Nvidia GeForce", 19799000.0, 10, 24);
        seedDataVariantAtribute("Xám", 3, 52); // màu
        seedDataVariantAtribute("512 GB", 24, 52); // Dung lượng ổ cứng
        // Thông số kỹ thuật
        seedDataVariantAtribute("Dell", 60, 52);  // Hãng
        seedDataVariantAtribute("Intel Core i5", 61, 52); // CPU
        seedDataVariantAtribute("1335U", 9, 52); // Phiên bản CPU
        seedDataVariantAtribute("4.6 GHz", 62, 52); // Tốc độ CPU tối đa
        seedDataVariantAtribute("Intel", 63, 52); // Hãng GPU
        seedDataVariantAtribute("Iris Xe ", 64, 52); // Hãng model GPU
        seedDataVariantAtribute("Intel Iris Xe Graphics", 65, 52); // full name GPU
        seedDataVariantAtribute("NVIDIA", 83, 52); // Model GPU
        seedDataVariantAtribute("GeForce MX550", 84, 52); // Model GPU
        seedDataVariantAtribute("16 GB", 13, 52); // Dung lượng RAM
        seedDataVariantAtribute("DDR4", 66, 52); // Loại RAM
        seedDataVariantAtribute("3200 MHz", 67, 52); // Tốc độ RAM
        seedDataVariantAtribute("16 GB", 79, 52); // Hỗ trợ RAM tối đa
        seedDataVariantAtribute("SSD - Nâng cấp tối đa 512GB (SSD M2 PCIe) ", 70, 52); // Loại ổ cứng
        seedDataVariantAtribute("M.2 NVMe", 71, 52); // Chuẩn SSD
        seedDataVariantAtribute("14 inch", 14, 52); // Kích thước màn hình
        seedDataVariantAtribute("Anti-Glare", 15, 52); // Công nghệ màn hình
        seedDataVariantAtribute("1920 x 1080 Pixels", 17, 52); // Độ phân giải
        seedDataVariantAtribute("16:9", 80, 52); // Tỉ lệ màn hình
        seedDataVariantAtribute("120 Hz", 22, 52); // Tần số quét
        seedDataVariantAtribute("IPS", 73, 52); // Panel màn hình
        seedDataVariantAtribute("250 nits", 21, 52); // Độ sáng
        seedDataVariantAtribute("1 HDMI, 1 USB 2.0, 1 USB 3.2 Gen 1 Type-A, 1 USB 3.2 Gen 1 Type-C , 1 headphone/microphone combo, 1 RJ45 Gigabit Ethernet", 41, 52); // Cổng kết nối
        seedDataVariantAtribute("Wi-Fi 802.11 ac", 42, 52); // Wi-Fi
        seedDataVariantAtribute("Bluetooth 5.0v", 44, 52); // Bluetooth
        seedDataVariantAtribute("HD Webcam (720p Webcam)", 74, 52); // Webcam
        seedDataVariantAtribute("Windows 11", 49, 52); // Hệ điều hành
        seedDataVariantAtribute("Windows 11 Home", 50, 52); // Phiên bản OS
        seedDataVariantAtribute("Mật khẩu", 37, 52); // Bảo mật
        seedDataVariantAtribute("English International Keyboard", 52, 52); // Bàn phím
        seedDataVariantAtribute("Không", 53, 52); // Bàn phím số
        seedDataVariantAtribute("Không", 54, 52); // Đèn nền bàn phím
        seedDataVariantAtribute("Multi-touch touchpad", 56, 52); // Touchpad
        seedDataVariantAtribute("Pin Li-ion", 46, 52); // Loại pin
        seedDataVariantAtribute("Adapter sạc, Dây sạc, Sách hướng dẫn", 51, 52); // Phụ kiện đi kèm
        seedDataVariantAtribute("32.367 x 22.026 x 1.95 cm", 5, 52); // Kích thước
        seedDataVariantAtribute("1.49 kg", 6, 52); // Trọng lượng
        seedDataVariantAtribute("1 quạt", 82, 52); // Quạt tản nhiệt
        seedDataVariantAtribute("Vỏ nhựa", 7, 52); // Chất liệu vỏ
        seedDataVariantAtribute("Trung Quốc", 1, 52); // Nơi sản xuất
        seedDataVariantAtribute("2023", 2, 52); // Năm ra mắt


        // Thông số kỹ thuật
        // Laptop Dell Vostro V3520 i5 1235U/16GB/512GB/15.6"FHD/Win11/Office HS21
        seedDataVariant("Laptop Dell Vostro V3430 i5 1335U", 16399000.0, 10, 24);
        seedDataVariantAtribute("Xám", 3, 53); // màu
        seedDataVariantAtribute("512 GB", 24, 53); // Dung lượng
        seedDataVariantAtribute("Dell", 60, 53);  // Hãng
        seedDataVariantAtribute("Intel", 61, 53); // Hãng CPU
        seedDataVariantAtribute("Core i5", 61, 53); // Công nghệ CPU
        seedDataVariantAtribute("1235U", 9, 53); // Loại CPU
        seedDataVariantAtribute("4.4 GHz", 62, 53); // Tốc độ tối đa
        seedDataVariantAtribute("Intel Iris Xe Graphics", 65, 53); // Tên đầy đủ (Card onboard)
        seedDataVariantAtribute("16 GB", 13, 53); // Dung lượng RAM
        seedDataVariantAtribute("DDR4", 66, 53); // Loại RAM
        seedDataVariantAtribute("2", 68, 53); // Số RAM onboard
        seedDataVariantAtribute("16 GB", 79, 53); // Hỗ trợ RAM tối đa
        seedDataVariantAtribute("SSD", 70, 53); // Kiểu ổ cứng
        seedDataVariantAtribute("M.2 NVMe", 71, 53); // Loại SSD
        seedDataVariantAtribute("15.6 inch", 14, 53); // Kích thước màn hình
        seedDataVariantAtribute("Anti-Glare LED-Backlit Display", 15, 53); // Công nghệ màn hình
        seedDataVariantAtribute("FHD (1920 x 1080)", 17, 53); // Độ phân giải
        seedDataVariantAtribute("120 Hz", 22, 53); // Tần số quét
        seedDataVariantAtribute("WVA", 73, 53); // Tấm nền
        seedDataVariantAtribute("250 nits", 21, 53); // Độ sáng
        seedDataVariantAtribute("1 USB 2.0, 1 HDMI, 1 RJ45 Gigabit Ethernet, 1 Jack 3.5 mm, 2 USB 3.2", 41, 53); // Cổng giao tiếp
        seedDataVariantAtribute("Wife 802.11 ax", 42, 53); // Wifi
        seedDataVariantAtribute("Bluetooth v5.0", 44, 53); // Bluetooth
        seedDataVariantAtribute("HD Webcam (720p Webcam)", 74, 53); // Webcam
        seedDataVariantAtribute("Windows", 49, 53); // OS
        seedDataVariantAtribute("Windows 11 Home Single Language", 50, 53); // Phiên bản OS
        seedDataVariantAtribute("Mật khẩu", 37, 53); // Bảo mật
        seedDataVariantAtribute("English International Non-backlit Keyboard", 52, 53); // Kiểu bàn phím
        seedDataVariantAtribute("Có", 53, 53); // Bàn phím số
        seedDataVariantAtribute("Không", 54, 53); // Đèn bàn phím
        seedDataVariantAtribute("Touchpad supports four-finger gestures", 56, 53); // TouchPad
        seedDataVariantAtribute("Pin Li-ion", 46, 53); // Loại pin
        seedDataVariantAtribute("41 Wh", 47, 53); // Dung lượng pin
        seedDataVariantAtribute("Adapter, Dây nguồn", 51, 53); // Phụ kiện trong hộp
        seedDataVariantAtribute("35.85 x 23.49 x 1.75 cm", 5, 53); // Kích thước
        seedDataVariantAtribute("1.9 kg", 6, 53); // Trọng lượng sản phẩm
        seedDataVariantAtribute("Vỏ: Nhựa", 7, 53); // Chất liệu
        seedDataVariantAtribute("Trung Quốc", 1, 53); // Xuất xứ
        seedDataVariantAtribute("2022", 2, 53); // Thời điểm ra mắt
        seedDataVariantAtribute("12 tháng", 4, 53); // Thời gian bảo hành

        seedDataProduct("Laptop Dell Latitude", "Laptop", 1.49, 7, 2, 4, "");

        // Tạo biến seedDataVariant cho Laptop Dell Latitude L3540 i5 1335U
        seedDataVariant("Laptop Dell Latitude L3540 i5 1335U", 18790000.0, 10, 25);
        seedDataVariantAtribute("Xám", 3, 54); // màu
        seedDataVariantAtribute("512 GB", 24, 54); // Dung lượng

        // Tạo biến seedDataVariant cho Laptop Dell Latitude L3540 i5 1235U
        seedDataVariant("Laptop Dell Latitude L3540 i5 1235U", 16390000.0, 10, 25);
        seedDataVariantAtribute("Xám", 3, 55); // Màu sắc
        seedDataVariantAtribute("512 GB", 24, 55); // Dung lượng

        // Tạo biến seedDataVariant cho Laptop Dell Latitude 3440 i5 1235U
        seedDataVariant("Laptop Dell Latitude 3440 i5 1235U", 17990000.0, 10, 25);
        seedDataVariantAtribute("Đen", 3, 56); // Màu sắc
        seedDataVariantAtribute("512 GB", 24, 56); // Dung lượng


        // Tạo biến seedDataVariant cho Laptop Dell Latitude L3540 i5 1335U
        // Thông số kỹ thuật
        seedDataVariantAtribute("Dell", 60, 54);  // Hãng
        seedDataVariantAtribute("Intel", 61, 54); // Hãng CPU
        seedDataVariantAtribute("Core i5", 61, 54); // Công nghệ CPU
        seedDataVariantAtribute("1335U", 9, 54); // Loại CPU
        seedDataVariantAtribute("1.3 GHz", 11, 54); // Tốc độ CPU tối thiểu
        seedDataVariantAtribute("4.6 GHz", 62, 54); // Tốc độ CPU tối đa
        seedDataVariantAtribute("Intel", 63, 54); // Hãng (Card onboard)
        seedDataVariantAtribute("Iris Xe", 64, 54); // Model (Card onboard)
        seedDataVariantAtribute("Intel Iris Xe Graphics", 65, 54); // Tên đầy đủ (Card onboard)
        seedDataVariantAtribute("NVIDIA", 83, 54); // Hãng (Card rời)
        seedDataVariantAtribute("GeForce MX550", 84, 54); // Model (Card rời)
        seedDataVariantAtribute("16 GB", 13, 54); // Dung lượng RAM
        seedDataVariantAtribute("DDR4", 66, 54); // Loại RAM
        seedDataVariantAtribute("2", 68, 54); // Số khe cắm rời
        seedDataVariantAtribute("16 GB", 79, 54); // Hỗ trợ RAM tối đa
        seedDataVariantAtribute("SSD", 70, 54); // Kiểu ổ cứng
        seedDataVariantAtribute("0", 76, 54); // Số khe SSD/HDD còn lại
        seedDataVariantAtribute("Nâng cấp tối đa 512GB (SSD M2 PCIe)", 77, 54); // Dung lượng nâng cấp tối đa ổ cứng
        seedDataVariantAtribute("M.2 NVMe", 71, 54); // Loại SSD
        seedDataVariantAtribute("14 inch", 14, 54); // Kích thước màn hình
        seedDataVariantAtribute("Anti-Glare", 15, 54); // Công nghệ màn hình
        seedDataVariantAtribute("1920 x 1080 Pixels", 17, 54); // Độ phân giải
        seedDataVariantAtribute("120 Hz", 22, 54); // Tần số quét
        seedDataVariantAtribute("Đang cập nhật", 73, 54); // Tấm nền
        seedDataVariantAtribute("250 nits", 21, 54); // Độ sáng
        seedDataVariantAtribute("16:09", 80, 54); // Tỷ lệ màn hình
        seedDataVariantAtribute("1 USB 2.0, 1 USB 3.2 Gen 1 Type-A, 1 USB 3.2 Gen 1 Type-C, 1 HDMI, 1 RJ45 Gigabit Ethernet, 1 headphone/microphone combo", 41, 54); // Cổng giao tiếp
        seedDataVariantAtribute("802.11 ac", 42, 54); // Wifi
        seedDataVariantAtribute("Bluetooth v5.0", 44, 54); // Bluetooth
        seedDataVariantAtribute("HD Webcam (720p Webcam)", 74, 54); // Webcam
        seedDataVariantAtribute("Windows", 49, 54); // OS
        seedDataVariantAtribute("Windows 11 Home", 50, 54); // Phiên bản OS
        seedDataVariantAtribute("Mật khẩu", 37, 54); // Bảo mật
        seedDataVariantAtribute("English International Non-backlit Keyboard", 52, 54); // Kiểu bàn phím
        seedDataVariantAtribute("Không", 53, 54); // Bàn phím số
        seedDataVariantAtribute("Không", 54, 54); // Đèn bàn phím
        seedDataVariantAtribute("Multi-touch touchpad", 56, 54); // TouchPad
        seedDataVariantAtribute("Pin Li-ion", 46, 54); // Loại pin
        seedDataVariantAtribute("3 Cell", 47, 54); // Dung lượng pin
        seedDataVariantAtribute("Adapter, Dây nguồn", 51, 54); // Phụ kiện trong hộp
        seedDataVariantAtribute("32.367 x 22.026 x 1.95 cm", 5, 54); // Kích thước
        seedDataVariantAtribute("1.49 kg", 6, 54); // Trọng lượng sản phẩm
        seedDataVariantAtribute("Nhựa", 7, 54); // Chất liệu
        seedDataVariantAtribute("Trung Quốc", 1, 54); // Xuất xứ
        seedDataVariantAtribute("2023", 2, 54); // Thời điểm ra mắt
        seedDataVariantAtribute("12 tháng", 4, 54); // Thời gian bảo hành

        // Tạo biến seedDataVariant cho Laptop Dell Latitude L3540 i5 1235U
        // Thông số kỹ thuật
        seedDataVariantAtribute("Dell", 60, 55);  // Hãng
        seedDataVariantAtribute("Intel", 61, 55); // Hãng CPU
        seedDataVariantAtribute("Core i5", 61, 55); // Công nghệ CPU
        seedDataVariantAtribute("1235U", 9, 55); // Loại CPU
        seedDataVariantAtribute("3.3 GHz", 11, 55); // Tốc độ CPU tối thiểu
        seedDataVariantAtribute("Intel", 63, 55); // Hãng (Card onboard)
        seedDataVariantAtribute("Iris Xe", 64, 55); // Model (Card onboard)
        seedDataVariantAtribute("Intel Iris Xe Graphics", 65, 55); // Tên đầy đủ (Card onboard)
        seedDataVariantAtribute("16 GB", 13, 55); // Dung lượng RAM
        seedDataVariantAtribute("DDR5", 66, 55); // Loại RAM
        seedDataVariantAtribute("2", 76, 55); // Số khe RAM còn lại
        seedDataVariantAtribute("1", 68, 55); // Số RAM onboard
        seedDataVariantAtribute("16 GB", 79, 55); // Hỗ trợ RAM tối đa
        seedDataVariantAtribute("SSD", 70, 55); // Kiểu ổ cứng
        seedDataVariantAtribute("Nâng cấp tối đa 4TB (SSD M2 PCIe)", 77, 55); // Dung lượng nâng cấp tối đa ổ cứng
        seedDataVariantAtribute("NVMe PCIe", 71, 55); // Loại SSD
        seedDataVariantAtribute("15.6 inch", 14, 55); // Kích thước màn hình
        seedDataVariantAtribute("Anti-Glare", 15, 55); // Công nghệ màn hình
        seedDataVariantAtribute("1920 x 1080 Pixels", 17, 55); // Độ phân giải
        seedDataVariantAtribute("60 Hz", 22, 55); // Tần số quét
        seedDataVariantAtribute("WVA", 73, 55); // Tấm nền
        seedDataVariantAtribute("1 USB 3.2 Gen 2 Type-C, 3 USB 3.2 Gen 1, 1 HDMI 1.4, 1 RJ45 Gigabit Ethernet, 1 MicroSD card reader", 41, 55); // Cổng giao tiếp
        seedDataVariantAtribute("Wi-Fi 6E AX211, 802.11ax 2x2", 42, 55); // Wifi
        seedDataVariantAtribute("Bluetooth v5.1", 44, 55); // Bluetooth
        seedDataVariantAtribute("Full HD Webcam (1080p Webcam)", 74, 55); // Webcam
        seedDataVariantAtribute("Windows", 49, 55); // OS
        seedDataVariantAtribute("Windows 11 Home", 50, 55); // Phiên bản OS
        seedDataVariantAtribute("Mật khẩu", 37, 55); // Bảo mật
        seedDataVariantAtribute("English International Non-backlit Keyboard", 52, 55); // Kiểu bàn phím
        seedDataVariantAtribute("Có", 53, 55); // Bàn phím số
        seedDataVariantAtribute("Không", 54, 55); // Đèn bàn phím
        seedDataVariantAtribute("Multi-touch touchpad", 56, 55); // TouchPad
        seedDataVariantAtribute("Pin Li-ion", 46, 55); // Loại pin
        seedDataVariantAtribute("Adapter, Dây nguồn", 51, 55); // Phụ kiện trong hộp
        seedDataVariantAtribute("359 x 239.69 x 18.13 mm", 5, 55); // Kích thước
        seedDataVariantAtribute("1.81 kg", 6, 55); // Trọng lượng sản phẩm
        seedDataVariantAtribute("1 quạt", 82, 55); // Tản nhiệt
        seedDataVariantAtribute("Nhựa", 7, 55); // Chất liệu
        seedDataVariantAtribute("Trung Quốc", 1, 55); // Xuất xứ
        seedDataVariantAtribute("2024", 2, 55); // Thời điểm ra mắt
        seedDataVariantAtribute("12 tháng", 4, 55); // Thời gian bảo hành

        // Tạo biến seedDataVariant cho Laptop Dell Latitude 3440 i5 1235U
        // Thông số kỹ thuật
        seedDataVariantAtribute("Dell", 60, 56);  // Hãng
        seedDataVariantAtribute("Intel", 61, 56); // Hãng CPU
        seedDataVariantAtribute("Core i5", 61, 56); // Công nghệ CPU
        seedDataVariantAtribute("1235U", 9, 56); // Loại CPU
        seedDataVariantAtribute("0.4 GHz", 11, 56); // Tốc độ CPU tối thiểu
        seedDataVariantAtribute("Intel Iris Xe Graphics G7 80EUs", 65, 56); // Tên đầy đủ (Card onboard)
        seedDataVariantAtribute("16 GB", 13, 56); // Dung lượng RAM
        seedDataVariantAtribute("DDR4", 66, 56); // Loại RAM
        seedDataVariantAtribute("2", 76, 56); // Số khe cắm rời
        seedDataVariantAtribute("64 GB", 79, 56); // Hỗ trợ RAM tối đa
        seedDataVariantAtribute("SSD", 70, 56); // Kiểu ổ cứng
        seedDataVariantAtribute("M.2 NVMe", 71, 56); // Loại SSD
        seedDataVariantAtribute("14.1 inch", 14, 56); // Kích thước màn hình
        seedDataVariantAtribute("LCD", 15, 56); // Công nghệ màn hình
        seedDataVariantAtribute("FHD (1920 x 1080)", 17, 56); // Độ phân giải
        seedDataVariantAtribute("60 Hz", 22, 56); // Tần số quét
        seedDataVariantAtribute("IPS", 73, 56); // Tấm nền
        seedDataVariantAtribute("1 RJ45 Gigabit Ethernet, 1 USB 3.2 Gen 2 Type-C, 3 USB 3.2 Gen 1, 1 HDMI 1.4, 1 Jack 3.5 mm", 41, 56); // Cổng giao tiếp
        seedDataVariantAtribute("Wifi 6", 42, 56); // Wifi
        seedDataVariantAtribute("Bluetooth v5.0", 44, 56); // Bluetooth
        seedDataVariantAtribute("720P HD camera", 74, 56); // Webcam
        seedDataVariantAtribute("Windows", 49, 56); // OS
        seedDataVariantAtribute("Windows 11 Home", 50, 56); // Phiên bản OS
        seedDataVariantAtribute("Mật khẩu", 37, 56); // Bảo mật
        seedDataVariantAtribute("English International Backlit Keyboard", 52, 56); // Kiểu bàn phím
        seedDataVariantAtribute("Không", 53, 56); // Bàn phím số
        seedDataVariantAtribute("LED", 54, 56); // Đèn bàn phím
        seedDataVariantAtribute("Multi-touch touchpad", 56, 56); // TouchPad
        seedDataVariantAtribute("Adapter, Dây nguồn", 51, 56); // Phụ kiện trong hộp
        seedDataVariantAtribute("322.17 x 219.43 x 19.37 mm", 5, 56); // Kích thước
        seedDataVariantAtribute("1.54 kg", 6, 56); // Trọng lượng sản phẩm
        seedDataVariantAtribute("Nhựa", 7, 56); // Chất liệu
        seedDataVariantAtribute("Trung Quốc", 1, 56); // Xuất xứ
        seedDataVariantAtribute("01/2024", 2, 56); // Thời điểm ra mắt


        seedDataProduct("Laptop Dell XPS", "Laptop", 1.8, 7, 2, 4, "");

        // Tạo biến seedDataVariant cho Laptop Dell XPS 14 9440 U7 155H
        seedDataVariant("Laptop Dell XPS 14 9440 U7 155H 64GB", 79990000.0, 10, 26);
        seedDataVariantAtribute("Đen", 3, 57); // Màu sắc
        seedDataVariantAtribute("1 TB", 24, 57); // Dung lượng
        // Thông số kỹ thuật
        seedDataVariantAtribute("Dell", 60, 57);  // Hãng
        seedDataVariantAtribute("Intel", 61, 57); // Hãng CPU
        seedDataVariantAtribute("Ultra 7", 61, 57); // Công nghệ CPU
        seedDataVariantAtribute("155H", 9, 57); // Loại CPU
        seedDataVariantAtribute("1.4 GHz", 11, 57); // Tốc độ CPU tối thiểu
        seedDataVariantAtribute("4.8 GHz", 62, 57); // Tốc độ tối đa
        seedDataVariantAtribute("Hiệu suất xử lý AI của CPU : 10", 58, 57); // Hiệu suất xử lý AI của CPU
        seedDataVariantAtribute("Intel Arc Graphics", 65, 57); // Tên đầy đủ (Card onboard)
        seedDataVariantAtribute("64 GB (2 thanh 32 GB)", 13, 57); // Dung lượng RAM
        seedDataVariantAtribute("Đang cập nhật", 66, 57); // Loại RAM
        seedDataVariantAtribute("2", 68, 57); // Số RAM onboard
        seedDataVariantAtribute("64 GB", 79, 57); // Hỗ trợ RAM tối đa
        seedDataVariantAtribute("SSD", 70, 57); // Kiểu ổ cứng
        seedDataVariantAtribute("M.2 NVMe", 71, 57); // Loại SSD
        seedDataVariantAtribute("14.5 inch", 14, 57); // Kích thước màn hình
        seedDataVariantAtribute("Anti-Glare LED-Backlit Display", 15, 57); // Công nghệ màn hình
        seedDataVariantAtribute("3200 x 2000 Pixels", 17, 57); // Độ phân giải
        seedDataVariantAtribute("120 Hz", 22, 57); // Tần số quét
        seedDataVariantAtribute("AMOLED", 73, 57); // Tấm nền
        seedDataVariantAtribute("500 nits", 21, 57); // Độ sáng
        seedDataVariantAtribute("3 Thunderbolt 4, 1 USB Type-C, 1 DisplayPort", 41, 57); // Cổng giao tiếp
        seedDataVariantAtribute("802.11 ax", 42, 57); // Wifi
        seedDataVariantAtribute("Bluetooth v5.3", 44, 57); // Bluetooth
        seedDataVariantAtribute("Full HD Webcam (1080p Webcam)", 74, 57); // Webcam
        seedDataVariantAtribute("Windows", 49, 57); // OS
        seedDataVariantAtribute("Windows 11 Home", 50, 57); // Phiên bản OS
        seedDataVariantAtribute("Mở khóa vân tay, Mở khóa khuôn mặt", 37, 57); // Bảo mật
        seedDataVariantAtribute("Backlit Chiclet Keyboard", 52, 57); // Kiểu bàn phím
        seedDataVariantAtribute("Không", 53, 57); // Bàn phím số
        seedDataVariantAtribute("Có", 54, 57); // Đèn bàn phím
        seedDataVariantAtribute("Touchpad supports four-finger gestures", 56, 57); // TouchPad
        seedDataVariantAtribute("Adapter, Dây nguồn", 51, 57); // Phụ kiện trong hộp
        seedDataVariantAtribute("320 x 215.98 x 18.03 mm", 5, 57); // Kích thước
        seedDataVariantAtribute("1.8 kg", 6, 57); // Trọng lượng sản phẩm
        seedDataVariantAtribute("Nhôm Aluminium", 7, 57); // Chất liệu
        seedDataVariantAtribute("Trung Quốc", 1, 57); // Xuất xứ
        seedDataVariantAtribute("2024", 2, 57); // Thời điểm ra mắt
        seedDataVariantAtribute("12 tháng", 4, 57); // Thời gian bảo hành

        //  Laptop Asus
        seedDataProduct("Laptop Asus", "Laptop", 1.8, 10, 2, 2, "");

        //  Laptop Asus Vivobook 15 OLED A1505VA-MA466W i5-13500H/16GB/512GB/15.6'' 2.8K/Win11
        seedDataVariant("Laptop Asus Vivobook 15 OLED A1505VA-MA466W i5-13500H/16GB/512GB", 18590000.0, 10, 27);

        // Thông số kĩ thuật
        seedDataVariantAtribute("Bạc", 3, 58); // Màu sắc
        seedDataVariantAtribute("512 GB", 24, 58); // Dung lượng ổ cứng
        seedDataVariantAtribute("Intel", 60, 58);  // Hãng CPU
        seedDataVariantAtribute("Core i5", 61, 58); // Công nghệ CPU
        seedDataVariantAtribute("13500H", 10, 58); // Loại CPU
        seedDataVariantAtribute("2.6 GHz", 11, 58); // Tốc độ CPU tối thiểu
        seedDataVariantAtribute("4.7 GHz", 62, 58); // Tốc độ CPU tối đa
        seedDataVariantAtribute("Intel", 63, 58); // Hãng (Card onboard)
        seedDataVariantAtribute("ARC", 64, 58); // Model (Card onboard)
        seedDataVariantAtribute("Intel Arc Graphics", 65, 58); // Tên đầy đủ (Card onboard)
        seedDataVariantAtribute("16 GB (2 thanh 8 GB)", 13, 58); // Dung lượng RAM
        seedDataVariantAtribute("DDR4", 66, 58); // Loại RAM
        seedDataVariantAtribute("3200 MHz", 67, 58); // Tốc độ RAM
        seedDataVariantAtribute("1", 76, 58); // Số khe cắm rời
        seedDataVariantAtribute("1", 68, 58); // Số RAM onboard
        seedDataVariantAtribute("Không nâng cấp", 79, 58); // Hỗ trợ RAM tối đa
        seedDataVariantAtribute("SSD", 70, 58); // Kiểu ổ cứng
        seedDataVariantAtribute("1", 68, 58); // Tổng số khe cắm SSD/HDD
        seedDataVariantAtribute("0", 76, 58); // Số khe SSD/HDD còn lại
        seedDataVariantAtribute("Không hỗ trợ nâng cấp", 77, 58); // Dung lượng nâng cấp tối đa ổ cứng
        seedDataVariantAtribute("M.2 NVMe", 71, 58); // Loại SSD
        seedDataVariantAtribute("15.6 inch", 14, 58); // Kích thước màn hình
        seedDataVariantAtribute("OLED", 15, 58); // Công nghệ màn hình
        seedDataVariantAtribute("2880 x 1620 Pixels", 17, 58); // Độ phân giải
        seedDataVariantAtribute("OLED", 72, 58); // Loại màn hình
        seedDataVariantAtribute("120 Hz", 22, 58); // Tần số quét
        seedDataVariantAtribute("OLED", 73, 58); // Tấm nền
        seedDataVariantAtribute("600 nits", 21, 58); // Độ sáng
        seedDataVariantAtribute("100% DCI-P3 color gamut", 78, 58); // Độ phủ màu
        seedDataVariantAtribute("16:09", 80, 58); // Tỷ lệ màn hình
        seedDataVariantAtribute("1000:1", 20, 58); // Độ tương phản
        seedDataVariantAtribute("1 USB 2.0, 1 USB 3.2 Gen 1 Type-C, 2 USB 3.2 Gen 1 Type-A, 1 HDMI 1.4, 1 Jack 3.5 mm, 1 DC-in jack", 41, 58); // Cổng giao tiếp
        seedDataVariantAtribute("Wifi 6E", 42, 58); // Wi-Fi
        seedDataVariantAtribute("Bluetooth v5.3", 44, 58); // Bluetooth
        seedDataVariantAtribute("720P HD camera", 74, 58); // Webcam
        seedDataVariantAtribute("Asus SonicMaster stereo", 81, 58); // Công nghệ âm thanh
        seedDataVariantAtribute("Windows", 49, 58); // OS
        seedDataVariantAtribute("Windows 11 Home", 50, 58); // Phiên bản OS
        seedDataVariantAtribute("Mật khẩu", 37, 58); // Bảo mật
        seedDataVariantAtribute("Chiclet Keyboard", 52, 58); // Kiểu bàn phím
        seedDataVariantAtribute("Có", 53, 58); // Bàn phím số
        seedDataVariantAtribute("Không", 54, 58); // Đèn bàn phím
        seedDataVariantAtribute("Multi-touch touchpad", 56, 58); // Touchpad
        seedDataVariantAtribute("50 WHrs", 47, 58); // Dung lượng pin
        seedDataVariantAtribute("65 W", 75, 58); // Power Supply
        seedDataVariantAtribute("Dây cáp sạc", 51, 58); // Phụ kiện trong hộp
        seedDataVariantAtribute("35.68 x 22.76 x 1.99 ~ 1.99 cm", 5, 58); // Kích thước
        seedDataVariantAtribute("1.7 kg", 6, 58); // Trọng lượng sản phẩm
        seedDataVariantAtribute("Nhựa", 7, 58); // Chất liệu
        seedDataVariantAtribute("Trung Quốc", 1, 58); // Xuất xứ
        seedDataVariantAtribute("2024", 2, 58); // Thời điểm ra mắt
        seedDataVariantAtribute("24 tháng", 4, 58); // Thời gian bảo hành

        // Laptop Asus TUF Gaming FA507NUR-LP101W R7-7435HS/16GB/512GB/15.6"/GeForce RTX4050 6GB/Win11
        seedDataVariant("Laptop Asus TUF Gaming FA507NUR-LP101W R7-7435HS/16GB/512GB", 25590000.0, 10, 27);
        seedDataVariantAtribute("Xám", 3, 59); // Màu sắc
        seedDataVariantAtribute("512 GB", 24, 59); // Dung lượng ổ cứng
        seedDataVariantAtribute("AMD", 60, 59);  // Hãng CPU
        seedDataVariantAtribute("Ryzen 7", 61, 59); // Công nghệ CPU
        seedDataVariantAtribute("7435HS", 10, 59); // Loại CPU
        seedDataVariantAtribute("3.1 GHz", 11, 59); // Tốc độ CPU tối thiểu
        seedDataVariantAtribute("4.5 GHz", 62, 59); // Tốc độ CPU tối đa
        seedDataVariantAtribute("8", 10, 59); // Số nhân
        seedDataVariantAtribute("16", 83, 59); // Số luồng
        seedDataVariantAtribute("NVIDIA", 63, 59); // Hãng (Card rời)
        seedDataVariantAtribute("GeForce RTX 4050", 84, 59); // Model (Card rời)
        seedDataVariantAtribute("NVIDIA GeForce RTX 4050 6GB", 65, 59); // Tên đầy đủ (Card rời)
        seedDataVariantAtribute("8 GB", 81, 59); // Bộ nhớ Card rời
        seedDataVariantAtribute("194 TOPS", 58, 59); // Hiệu suất AI (TOPS)
        seedDataVariantAtribute("16 GB (1 thanh 16 GB)", 13, 59); // Dung lượng RAM
        seedDataVariantAtribute("DDR5", 66, 59); // Loại RAM
        seedDataVariantAtribute("4800 MHz", 67, 59); // Tốc độ RAM
        seedDataVariantAtribute("2", 76, 59); // Số khe cắm rời
        seedDataVariantAtribute("1", 76, 59); // Số khe RAM còn lại
        seedDataVariantAtribute("32 GB", 79, 59); // Hỗ trợ RAM tối đa
        seedDataVariantAtribute("SSD", 70, 59); // Kiểu ổ cứng
        seedDataVariantAtribute("2", 68, 59); // Tổng số khe cắm SSD/HDD
        seedDataVariantAtribute("1", 76, 59); // Số khe SSD/HDD còn lại
        seedDataVariantAtribute("Nâng cấp tối đa 1TB (SSD M2 PCIe)", 77, 59); // Dung lượng nâng cấp tối đa ổ cứng
        seedDataVariantAtribute("M.2 NVMe", 71, 59); // Loại SSD
        seedDataVariantAtribute("15.6 inch", 14, 59); // Kích thước màn hình
        seedDataVariantAtribute("Anti-Glare", 15, 59); // Công nghệ màn hình
        seedDataVariantAtribute("1920 x 1080 Pixels", 17, 59); // Độ phân giải
        seedDataVariantAtribute("LED", 72, 59); // Loại màn hình
        seedDataVariantAtribute("144 Hz", 22, 59); // Tần số quét
        seedDataVariantAtribute("IPS", 73, 59); // Tấm nền
        seedDataVariantAtribute("16:09", 80, 59); // Tỷ lệ màn hình
        seedDataVariantAtribute("1 RJ45 Gigabit Ethernet, 2 USB 3.2 Gen 2 Type-C, 2 USB 3.2 Gen 1 Type-A", 41, 59); // Cổng giao tiếp
        seedDataVariantAtribute("802.11 ax", 42, 59); // Wi-Fi
        seedDataVariantAtribute("Bluetooth v5.3", 44, 59); // Bluetooth
        seedDataVariantAtribute("HD Webcam (720p Webcam)", 74, 59); // Webcam
        seedDataVariantAtribute("Asus SonicMaster stereo", 81, 59); // Công nghệ âm thanh
        seedDataVariantAtribute("Windows", 49, 59); // OS
        seedDataVariantAtribute("Windows 11 Home", 50, 59); // Phiên bản OS
        seedDataVariantAtribute("Mật khẩu", 37, 59); // Bảo mật
        seedDataVariantAtribute("Backlit Chiclet Keyboard", 52, 59); // Kiểu bàn phím
        seedDataVariantAtribute("Có", 53, 59); // Bàn phím số
        seedDataVariantAtribute("LED", 54, 59); // Đèn nền bàn phím
        seedDataVariantAtribute("RGB 1 Zone", 55, 59); // Công nghệ đèn bàn phím
        seedDataVariantAtribute("Trắng", 55, 59); // Màu đèn LED
        seedDataVariantAtribute("Multi-touch touchpad", 56, 59); // Touchpad
        seedDataVariantAtribute("Lithium-ion", 46, 59); // Loại pin
        seedDataVariantAtribute("90 WHrs", 47, 59); // Dung lượng pin
        seedDataVariantAtribute("240 W", 75, 59); // Power Supply
        seedDataVariantAtribute("Dây cáp sạc", 51, 59); // Phụ kiện trong hộp
        seedDataVariantAtribute("35.97 x 23.25 x 1.79 ~ 1.79 cm", 5, 59); // Kích thước
        seedDataVariantAtribute("2.2 kg", 6, 59); // Trọng lượng sản phẩm
        seedDataVariantAtribute("Kim loại", 7, 59); // Chất liệu (Mặt lưng máy)
        seedDataVariantAtribute("Trung Quốc", 1, 59); // Xuất xứ
        seedDataVariantAtribute("2024", 2, 59); // Thời điểm ra mắt
        seedDataVariantAtribute("24 tháng", 4, 59); // Thời gian bảo hành

        //Laptop Asus Gaming Vivobook K3605ZC-RP564W i5-12500H/16GB/512GB/16"/Nvidia GeForce RTX3050 4GB/Win11
        seedDataVariant("Laptop Asus Gaming Vivobook K3605ZC-RP564W i5-12500H/16GB/512GB", 19190000.0, 10, 27);
        // Thông số kỹ thuật
        seedDataVariantAtribute("Đen", 3, 60); // Màu sắc
        seedDataVariantAtribute("512 GB", 24, 60); // Dung lượng ổ cứng
        seedDataVariantAtribute("Intel", 60, 60);  // Hãng CPU
        seedDataVariantAtribute("Core i5", 61, 60); // Công nghệ CPU
        seedDataVariantAtribute("12500", 10, 60); // Loại CPU
        seedDataVariantAtribute("2.5 GHz", 11, 60); // Tốc độ CPU tối thiểu
        seedDataVariantAtribute("4.5 GHz", 62, 60); // Tốc độ CPU tối đa
        seedDataVariantAtribute("Intel", 63, 60); // Hãng (Card onboard)
        seedDataVariantAtribute("UHD", 64, 60); // Model (Card onboard)
        seedDataVariantAtribute("Intel UHD Graphics", 65, 60); // Tên đầy đủ (Card onboard)
        seedDataVariantAtribute("NVIDIA", 83, 60); // Hãng (Card rời)
        seedDataVariantAtribute("GeForce RTX 3050", 84, 60); // Model (Card rời)
        seedDataVariantAtribute("NVIDIA GeForce RTX 3050 4GB GDDR6", 65, 60); // Tên đầy đủ (Card rời)
        seedDataVariantAtribute("16 GB (1 thanh 16 GB)", 13, 60); // Dung lượng RAM
        seedDataVariantAtribute("DDR4", 66, 60); // Loại RAM
        seedDataVariantAtribute("1", 76, 60); // Số khe cắm rời
        seedDataVariantAtribute("1", 68, 60); // Số RAM onboard
        seedDataVariantAtribute("24 GB", 79, 60); // Hỗ trợ RAM tối đa
        seedDataVariantAtribute("SSD", 70, 60); // Kiểu ổ cứng
        seedDataVariantAtribute("1", 68, 60); // Tổng số khe cắm SSD/HDD
        seedDataVariantAtribute("1 SSD", 76, 60); // Số khe SSD/HDD còn lại
        seedDataVariantAtribute("Không hỗ trợ nâng cấp", 77, 60); // Dung lượng nâng cấp tối đa ổ cứng
        seedDataVariantAtribute("M.2 NVMe", 71, 60); // Loại SSD
        seedDataVariantAtribute("16 inch", 14, 60); // Kích thước màn hình
        seedDataVariantAtribute("IPS LCD", 15, 60); // Công nghệ màn hình
        seedDataVariantAtribute("1920 x 1200 Pixels", 17, 60); // Độ phân giải
        seedDataVariantAtribute("Màn hình phẳng", 72, 60); // Loại màn hình
        seedDataVariantAtribute("144 Hz", 22, 60); // Tần số quét
        seedDataVariantAtribute("IPS", 73, 60); // Tấm nền
        seedDataVariantAtribute("300 nits", 21, 60); // Độ sáng
        seedDataVariantAtribute("45% NTSC", 78, 60); // Độ phủ màu
        seedDataVariantAtribute("16:10", 80, 60); // Tỷ lệ màn hình
        seedDataVariantAtribute("Cổng sạc, 2 USB 3.2 Gen 1 Type-A, 1 Thunderbolt 4, 1 HDMI 2.1, 1 Jack 3.5 mm, 1 DC-in jack, 1 Card reader", 41, 60); // Cổng giao tiếp
        seedDataVariantAtribute("Wifi 6E", 42, 60); // Wi-Fi
        seedDataVariantAtribute("Bluetooth v5.3", 44, 60); // Bluetooth
        seedDataVariantAtribute("HD Webcam (720p Webcam)", 74, 60); // Webcam
        seedDataVariantAtribute("Asus SonicMaster stereo", 81, 60); // Công nghệ âm thanh
        seedDataVariantAtribute("Windows", 49, 60); // OS
        seedDataVariantAtribute("Windows 11", 50, 60); // Phiên bản OS
        seedDataVariantAtribute("Mở khóa bằng mật mã", 37, 60); // Bảo mật
        seedDataVariantAtribute("Backlit Chiclet Keyboard", 52, 60); // Kiểu bàn phím
        seedDataVariantAtribute("Có", 53, 60); // Bàn phím số
        seedDataVariantAtribute("LED", 54, 60); // Đèn nền bàn phím
        seedDataVariantAtribute("RGB 1 Zone", 55, 60); // Công nghệ đèn bàn phím
        seedDataVariantAtribute("Trắng", 55, 60); // Màu đèn LED
        seedDataVariantAtribute("Multi-touch touchpad", 56, 60); // Touchpad
        seedDataVariantAtribute("50 Whr", 47, 60); // Dung lượng pin
        seedDataVariantAtribute("120 W", 75, 60); // Power Supply
        seedDataVariantAtribute("Dây cáp sạc", 51, 60); // Phụ kiện trong hộp
        seedDataVariantAtribute("35.86 x 24.91 x 1.89 ~ 1.89 cm", 5, 60); // Kích thước
        seedDataVariantAtribute("1.8 kg", 6, 60); // Trọng lượng sản phẩm
        seedDataVariantAtribute("Nhựa PP", 7, 60); // Chất liệu
        seedDataVariantAtribute("Trung Quốc", 1, 60); // Xuất xứ
        seedDataVariantAtribute("01/2024", 2, 60); // Thời điểm ra mắt
        seedDataVariantAtribute("24 tháng", 4, 60); // Thời gian bảo hành

        // Laptop ASUS Vivobook 15 OLED A1505VA-MA469W i9-13900H/16GB/512GB/15.6" 2.8K/Win11
        seedDataVariant("Laptop ASUS Vivobook 15 OLED A1505VA-MA469W i9-13900H/16GB/512GB", 23190000.0, 10, 27);
        // Thông số kỹ thuật
        seedDataVariantAtribute("Bạc", 3, 61); // Màu sắc
        seedDataVariantAtribute("512 GB", 24, 61); // Dung lượng ổ cứng
        seedDataVariantAtribute("Intel", 60, 61);  // Hãng CPU
        seedDataVariantAtribute("Core i9", 61, 61); // Công nghệ CPU
        seedDataVariantAtribute("13900H", 10, 61); // Loại CPU
        seedDataVariantAtribute("2.6 GHz", 11, 61); // Tốc độ CPU tối thiểu
        seedDataVariantAtribute("5.4 GHz", 62, 61); // Tốc độ CPU tối đa
        seedDataVariantAtribute("Intel", 63, 61); // Hãng (Card onboard)
        seedDataVariantAtribute("Iris Xe", 64, 61); // Model (Card onboard)
        seedDataVariantAtribute("Intel Iris Xe Graphics", 65, 61); // Tên đầy đủ (Card onboard)
        seedDataVariantAtribute("16 GB (2 thanh 8 GB)", 13, 61); // Dung lượng RAM
        seedDataVariantAtribute("DDR4", 66, 61); // Loại RAM
        seedDataVariantAtribute("1", 76, 61); // Số khe cắm rời
        seedDataVariantAtribute("1", 68, 61); // Số RAM onboard
        seedDataVariantAtribute("Không nâng cấp", 79, 61); // Hỗ trợ RAM tối đa
        seedDataVariantAtribute("SSD", 70, 61); // Kiểu ổ cứng
        seedDataVariantAtribute("1", 68, 61); // Tổng số khe cắm SSD/HDD
        seedDataVariantAtribute("1 SSD", 76, 61); // Số khe SSD/HDD còn lại
        seedDataVariantAtribute("Không hỗ trợ nâng cấp", 77, 61); // Dung lượng nâng cấp tối đa ổ cứng
        seedDataVariantAtribute("M2 PCIe", 71, 61); // Loại SSD
        seedDataVariantAtribute("15.6 inch", 14, 61); // Kích thước màn hình
        seedDataVariantAtribute("OLED", 15, 61); // Công nghệ màn hình
        seedDataVariantAtribute("2880 x 1620 Pixels", 17, 61); // Độ phân giải
        seedDataVariantAtribute("Màn hình phẳng", 72, 61); // Loại màn hình
        seedDataVariantAtribute("120 Hz", 22, 61); // Tần số quét
        seedDataVariantAtribute("OLED", 73, 61); // Tấm nền
        seedDataVariantAtribute("600 nits", 21, 61); // Độ sáng
        seedDataVariantAtribute("100% DCI-P3", 78, 61); // Độ phủ màu
        seedDataVariantAtribute("16:09", 80, 61); // Tỷ lệ màn hình
        seedDataVariantAtribute("1000:1", 20, 61); // Độ tương phản
        seedDataVariantAtribute("1 Jack 3.5 mm, 1 USB 3.2 Gen 1 Type-C, 2 USB 3.2 Gen 1 Type-A, 1 HDMI 1.4", 41, 61); // Cổng giao tiếp
        seedDataVariantAtribute("Wifi 6E", 42, 61); // Wi-Fi
        seedDataVariantAtribute("Bluetooth v5.3", 44, 61); // Bluetooth
        seedDataVariantAtribute("720P HD camera With privacy shutter", 74, 61); // Webcam
        seedDataVariantAtribute("Asus SonicMaster stereo", 81, 61); // Công nghệ âm thanh
        seedDataVariantAtribute("Windows", 49, 61); // OS
        seedDataVariantAtribute("Windows 11", 50, 61); // Phiên bản OS
        seedDataVariantAtribute("Mở khóa bằng mật mã", 37, 61); // Bảo mật
        seedDataVariantAtribute("Chiclet Keyboard", 52, 61); // Kiểu bàn phím
        seedDataVariantAtribute("Có", 53, 61); // Bàn phím số
        seedDataVariantAtribute("Không", 54, 61); // Đèn bàn phím
        seedDataVariantAtribute("Multi-touch touchpad", 56, 61); // Touchpad
        seedDataVariantAtribute("65 Wh", 47, 61); // Dung lượng pin
        seedDataVariantAtribute("50 W", 75, 61); // Power Supply
        seedDataVariantAtribute("Dây cáp sạc", 51, 61); // Phụ kiện trong hộp
        seedDataVariantAtribute("35.68 x 22.76 x 1.99 ~ 1.99 cm", 5, 61); // Kích thước
        seedDataVariantAtribute("1.7 kg", 6, 61); // Trọng lượng sản phẩm
        seedDataVariantAtribute("Nhựa", 7, 61); // Chất liệu
        seedDataVariantAtribute("Trung Quốc", 1, 61); // Xuất xứ
        seedDataVariantAtribute("2024", 2, 61); // Thời điểm ra mắt
        seedDataVariantAtribute("24 tháng", 4, 61); // Thời gian bảo hành

        // Laptop Asus Vivobook S14 S5406MA-PP161W Ultra 5 125H/AI/16GB/1TB/14" OLED 3K/Intel Arc Graphics/Win11
        seedDataVariant("Laptop Asus Vivobook S14 S5406MA-PP161W Ultra 5 125H/AI/16GB/1TB", 24290000.0, 10, 27);
        // Thông số kỹ thuật
        seedDataVariantAtribute("Đen", 3, 62); // Màu sắc
        seedDataVariantAtribute("1 TB", 24, 62); // Dung lượng ổ cứng
        seedDataVariantAtribute("Intel", 60, 62);  // Hãng CPU
        seedDataVariantAtribute("Core Ultra 5", 61, 62); // Công nghệ CPU
        seedDataVariantAtribute("125H", 10, 62); // Loại CPU
        seedDataVariantAtribute("1.2 GHz", 11, 62); // Tốc độ CPU tối thiểu
        seedDataVariantAtribute("4.5 GHz", 62, 62); // Tốc độ CPU tối đa
        seedDataVariantAtribute("10", 58, 62); // Hiệu suất xử lý AI của CPU
        seedDataVariantAtribute("Intel", 63, 62); // Hãng (Card onboard)
        seedDataVariantAtribute("ARC", 64, 62); // Model (Card onboard)
        seedDataVariantAtribute("Intel Arc Graphics", 65, 62); // Tên đầy đủ (Card onboard)
        seedDataVariantAtribute("16 GB (1 thanh 16 GB)", 13, 62); // Dung lượng RAM
        seedDataVariantAtribute("LPDDR5X", 66, 62); // Loại RAM
        seedDataVariantAtribute("1", 68, 62); // Số RAM onboard
        seedDataVariantAtribute("Không nâng cấp", 79, 62); // Hỗ trợ RAM tối đa
        seedDataVariantAtribute("SSD", 70, 62); // Kiểu ổ cứng
        seedDataVariantAtribute("1 SSD", 68, 62); // Tổng số khe cắm SSD/HDD
        seedDataVariantAtribute("Không hỗ trợ nâng cấp", 77, 62); // Dung lượng nâng cấp tối đa ổ cứng
        seedDataVariantAtribute("M.2 NVMe", 71, 62); // Loại SSD
        seedDataVariantAtribute("14 inch", 14, 62); // Kích thước màn hình
        seedDataVariantAtribute("OLED", 15, 62); // Công nghệ màn hình
        seedDataVariantAtribute("2880 x 1800 Pixels", 17, 62); // Độ phân giải
        seedDataVariantAtribute("OLED", 72, 62); // Loại màn hình
        seedDataVariantAtribute("120 Hz", 22, 62); // Tần số quét
        seedDataVariantAtribute("OLED", 73, 62); // Tấm nền
        seedDataVariantAtribute("100% DCI-P3", 78, 62); // Độ phủ màu
        seedDataVariantAtribute("16:10", 80, 62); // Tỷ lệ màn hình
        seedDataVariantAtribute("1.000.000:1", 20, 62); // Độ tương phản
        seedDataVariantAtribute("2 Thunderbolt 4, 2 USB 3.2 Gen 1 Type-A, 1 Jack 3.5 mm, 1 HDMI 2.1", 41, 62); // Cổng giao tiếp
        seedDataVariantAtribute("Wifi 6E", 42, 62); // Wi-Fi
        seedDataVariantAtribute("Bluetooth v5.3", 44, 62); // Bluetooth
        seedDataVariantAtribute("Full HD Webcam (1080p Webcam)", 74, 62); // Webcam
        seedDataVariantAtribute("Windows", 49, 62); // OS
        seedDataVariantAtribute("Windows 11 Home", 50, 62); // Phiên bản OS
        seedDataVariantAtribute("Mở khóa bằng mật mã", 37, 62); // Bảo mật
        seedDataVariantAtribute("Backlit Chiclet Keyboard", 52, 62); // Kiểu bàn phím
        seedDataVariantAtribute("Không", 53, 62); // Bàn phím số
        seedDataVariantAtribute("LED", 54, 62); // Đèn bàn phím
        seedDataVariantAtribute("Đơn sắc", 55, 62); // Công nghệ đèn bàn phím
        seedDataVariantAtribute("Trắng", 55, 62); // Màu đèn LED
        seedDataVariantAtribute("Multi-touch touchpad", 56, 62); // Touchpad
        seedDataVariantAtribute("75 Wh", 47, 62); // Dung lượng pin
        seedDataVariantAtribute("90 W", 75, 62); // Power Supply
        seedDataVariantAtribute("Dây cáp sạc", 51, 62); // Phụ kiện trong hộp
        seedDataVariantAtribute("31.05 x 22.19 x 1.39 ~ 1.59 cm", 5, 62); // Kích thước
        seedDataVariantAtribute("1.3 kg", 6, 62); // Trọng lượng sản phẩm
        seedDataVariantAtribute("Nhôm", 7, 62); // Chất liệu
        seedDataVariantAtribute("Trung Quốc", 1, 62); // Xuất xứ
        seedDataVariantAtribute("2024", 2, 62); // Thời điểm ra mắt
        seedDataVariantAtribute("24 tháng", 4, 62); // Thời gian bảo hành

        // Laptop Asus Zenbook 14 OLED UX3405MA-PP152W Intel Core Ultra 7-155H/AI/32GB/1TB/14'' 3K/Intel Arc/Win11
        seedDataVariant("Laptop Asus Zenbook 14 OLED UX3405MA-PP152W Intel Core Ultra 7-155H/AI/32GB/1TB", 30990000.0, 10, 27);
        // Thông số kỹ thuật
        seedDataVariantAtribute("Xanh", 3, 63); // Màu sắc
        seedDataVariantAtribute("1 TB", 24, 63); // Dung lượng ổ cứng
        seedDataVariantAtribute("Intel", 60, 63);  // Hãng CPU
        seedDataVariantAtribute("Core Ultra 7", 61, 63); // Công nghệ CPU
        seedDataVariantAtribute("155H", 10, 63); // Loại CPU
        seedDataVariantAtribute("1.4 GHz", 11, 63); // Tốc độ CPU tối thiểu
        seedDataVariantAtribute("10", 58, 63); // Hiệu suất xử lý AI của CPU
        seedDataVariantAtribute("Intel", 63, 63); // Hãng (Card onboard)
        seedDataVariantAtribute("Intel Arc Graphics", 65, 63); // Tên đầy đủ (Card onboard)
        seedDataVariantAtribute("32 GB", 13, 63); // Dung lượng RAM
        seedDataVariantAtribute("DDR5", 66, 63); // Loại RAM
        seedDataVariantAtribute("1", 68, 63); // Số RAM onboard
        seedDataVariantAtribute("Không nâng cấp", 79, 63); // Hỗ trợ RAM tối đa
        seedDataVariantAtribute("SSD", 70, 63); // Kiểu ổ cứng
        seedDataVariantAtribute("1", 68, 63); // Tổng số khe cắm SSD/HDD
        seedDataVariantAtribute("0", 76, 63); // Số khe SSD/HDD còn lại
        seedDataVariantAtribute("Không hỗ trợ nâng cấp", 77, 63); // Dung lượng nâng cấp tối đa ổ cứng
        seedDataVariantAtribute("Hãng không công bố", 71, 63); // Loại SSD
        seedDataVariantAtribute("14 inch", 14, 63); // Kích thước màn hình
        seedDataVariantAtribute("OLED", 15, 63); // Công nghệ màn hình
        seedDataVariantAtribute("2880 x 1800 Pixels", 17, 63); // Độ phân giải
        seedDataVariantAtribute("OLED", 72, 63); // Loại màn hình
        seedDataVariantAtribute("120 Hz", 22, 63); // Tần số quét
        seedDataVariantAtribute("OLED", 73, 63); // Tấm nền
        seedDataVariantAtribute("100% DCI-P3", 78, 63); // Độ phủ màu
        seedDataVariantAtribute("16:10", 80, 63); // Tỷ lệ màn hình
        seedDataVariantAtribute("Cổng sạc: USB 3.2 Gen 1", 41, 63); // Cổng giao tiếp
        seedDataVariantAtribute("Wifi 6E", 42, 63); // Wi-Fi
        seedDataVariantAtribute("Bluetooth v5.3", 44, 63); // Bluetooth
        seedDataVariantAtribute("Full HD Webcam (1080p Webcam)", 74, 63); // Webcam
        seedDataVariantAtribute("Windows", 49, 63); // OS
        seedDataVariantAtribute("Windows 11 Home", 50, 63); // Phiên bản OS
        seedDataVariantAtribute("Mở khóa bằng mật mã", 37, 63); // Bảo mật
        seedDataVariantAtribute("Backlit Chiclet Keyboard", 52, 63); // Kiểu bàn phím
        seedDataVariantAtribute("Không", 53, 63); // Bàn phím số
        seedDataVariantAtribute("LED", 54, 63); // Đèn bàn phím
        seedDataVariantAtribute("Đơn sắc", 55, 63); // Công nghệ đèn bàn phím
        seedDataVariantAtribute("Trắng", 55, 63); // Màu đèn LED
        seedDataVariantAtribute("Multi-touch touchpad", 56, 63); // Touchpad
        seedDataVariantAtribute("75 Wh", 47, 63); // Dung lượng pin
        seedDataVariantAtribute("Túi Sleeve, Sách HDSD, Bộ sạc điện", 51, 63); // Phụ kiện trong hộp
        seedDataVariantAtribute("31.24 x 22.01 x 1.49 cm", 5, 63); // Kích thước
        seedDataVariantAtribute("1.2 kg", 6, 63); // Trọng lượng sản phẩm
        seedDataVariantAtribute("Nhôm", 7, 63); // Chất liệu
        seedDataVariantAtribute("Trung Quốc", 1, 63); // Xuất xứ
        seedDataVariantAtribute("01/2023", 2, 63); // Thời điểm ra mắt
        seedDataVariantAtribute("24 tháng", 4, 63); // Thời gian bảo hành

        // Laptop Asus Vivobook S16 OLED S5606MA-MX051W Intel Core Ultra 7-155H/AI/16GB/512GB/16" 3.2K/Arc Graphics/Win11
        seedDataVariant("Laptop Asus Vivobook S16 OLED S5606MA-MX051W Intel Core Ultra 7-155H/AI/16GB/512GB", 25890000.0, 10, 27);
        seedDataVariantAtribute("Xanh", 3, 64); // Màu sắc
        seedDataVariantAtribute("512 GB", 24, 64); // Dung lượng ổ cứng
        seedDataVariantAtribute("Intel", 60, 64);  // Hãng CPU
        seedDataVariantAtribute("Ultra 7", 61, 64); // Công nghệ CPU
        seedDataVariantAtribute("155H", 10, 64); // Loại CPU
        seedDataVariantAtribute("1.4 GHz", 11, 64); // Tốc độ CPU tối thiểu
        seedDataVariantAtribute("4.8 GHz", 62, 64); // Tốc độ CPU tối đa
        seedDataVariantAtribute("10", 58, 64); // Hiệu suất xử lý AI của CPU
        seedDataVariantAtribute("Intel", 63, 64); // Hãng (Card onboard)
        seedDataVariantAtribute("ARC", 64, 64); // Model (Card onboard)
        seedDataVariantAtribute("Intel Arc Graphics", 65, 64); // Tên đầy đủ (Card onboard)
        seedDataVariantAtribute("16 GB (1 thanh 16 GB)", 13, 64); // Dung lượng RAM
        seedDataVariantAtribute("LPDDR5X", 66, 64); // Loại RAM
        seedDataVariantAtribute("1", 68, 64); // Số RAM onboard
        seedDataVariantAtribute("Không nâng cấp", 79, 64); // Hỗ trợ RAM tối đa
        seedDataVariantAtribute("SSD", 70, 64); // Kiểu ổ cứng
        seedDataVariantAtribute("1", 68, 64); // Tổng số khe cắm SSD/HDD
        seedDataVariantAtribute("0", 76, 64); // Số khe SSD/HDD còn lại
        seedDataVariantAtribute("Không hỗ trợ nâng cấp", 77, 64); // Dung lượng nâng cấp tối đa ổ cứng
        seedDataVariantAtribute("M.2 NVMe", 71, 64); // Loại SSD
        seedDataVariantAtribute("16 inch", 14, 64); // Kích thước màn hình
        seedDataVariantAtribute("OLED", 15, 64); // Công nghệ màn hình
        seedDataVariantAtribute("3201 x 2000 Pixels", 17, 64); // Độ phân giải
        seedDataVariantAtribute("OLED", 72, 64); // Loại màn hình
        seedDataVariantAtribute("120 Hz", 22, 64); // Tần số quét
        seedDataVariantAtribute("OLED", 73, 64); // Tấm nền
        seedDataVariantAtribute("100% DCI-P3", 78, 64); // Độ phủ màu
        seedDataVariantAtribute("16:10", 80, 64); // Tỷ lệ màn hình
        seedDataVariantAtribute("1.000.000:1", 20, 64); // Độ tương phản
        seedDataVariantAtribute("2 USB 3.2 Gen 1 Type-A, 2 Thunderbolt 4, 1 HDMI 2.1, 1 Jack 3.5 mm", 41, 64); // Cổng giao tiếp
        seedDataVariantAtribute("Wifi 6E", 42, 64); // Wi-Fi
        seedDataVariantAtribute("Bluetooth v5.3", 44, 64); // Bluetooth
        seedDataVariantAtribute("HD Webcam (720p Webcam)", 74, 64); // Webcam
        seedDataVariantAtribute("Windows", 49, 64); // OS
        seedDataVariantAtribute("Windows 11 Home", 50, 64); // Phiên bản OS
        seedDataVariantAtribute("Mở khóa bằng mật mã", 37, 64); // Bảo mật
        seedDataVariantAtribute("Backlit Chiclet Keyboard With Copilot key", 52, 64); // Kiểu bàn phím
        seedDataVariantAtribute("Không", 53, 64); // Bàn phím số
        seedDataVariantAtribute("LED", 54, 64); // Đèn bàn phím
        seedDataVariantAtribute("Đơn sắc", 55, 64); // Công nghệ đèn bàn phím
        seedDataVariantAtribute("Trắng", 55, 64); // Màu đèn LED
        seedDataVariantAtribute("Multi-touch touchpad", 56, 64); // Touchpad
        seedDataVariantAtribute("75 Wh", 47, 64); // Dung lượng pin
        seedDataVariantAtribute("90 W", 75, 64); // Power Supply
        seedDataVariantAtribute("Dây cáp sạc", 51, 64); // Phụ kiện trong hộp
        seedDataVariantAtribute("35.36 x 24.69 x 1.39 ~ 1.59 cm", 5, 64); // Kích thước
        seedDataVariantAtribute("1.5 kg", 6, 64); // Trọng lượng sản phẩm
        seedDataVariantAtribute("Nhôm", 7, 64); // Chất liệu
        seedDataVariantAtribute("Trung Quốc", 1, 64); // Xuất xứ
        seedDataVariantAtribute("2024", 2, 64); // Thời điểm ra mắt
        seedDataVariantAtribute("24 tháng", 4, 64); // Thời gian bảo hành

        // Laptop Asus Zenbook 14 OLED UX3405MA-PP151W Ultra 5 125H/AI/16GB/512GB/14" 3K/Intel Arc Graphics/Win11
        seedDataVariant("Laptop Asus Zenbook 14 OLED UX3405MA-PP151W Ultra 5 125H/AI/16GB/512GB", 26990000.0, 10, 27);
        seedDataVariantAtribute("Xanh", 3, 65); // Màu sắc
        seedDataVariantAtribute("512 GB", 24, 65); // Dung lượng ổ cứng
        seedDataVariantAtribute("Intel", 60, 65);  // Hãng CPU
        seedDataVariantAtribute("Core Ultra 5", 61, 65); // Công nghệ CPU
        seedDataVariantAtribute("125H", 10, 65); // Loại CPU
        seedDataVariantAtribute("1.2 GHz", 11, 65); // Tốc độ CPU tối thiểu
        seedDataVariantAtribute("4.5 GHz", 62, 65); // Tốc độ CPU tối đa
        seedDataVariantAtribute("10", 58, 65); // Hiệu suất xử lý AI của CPU
        seedDataVariantAtribute("Intel", 63, 65); // Hãng (Card onboard)
        seedDataVariantAtribute("ARC", 64, 65); // Model (Card onboard)
        seedDataVariantAtribute("Intel Arc Graphics", 65, 65); // Tên đầy đủ (Card onboard)
        seedDataVariantAtribute("16 GB (1 thanh 16 GB)", 13, 65); // Dung lượng RAM
        seedDataVariantAtribute("LPDDR5X", 66, 65); // Loại RAM
        seedDataVariantAtribute("1", 68, 65); // Số RAM onboard
        seedDataVariantAtribute("16 GB", 79, 65); // Hỗ trợ RAM tối đa
        seedDataVariantAtribute("SSD", 70, 65); // Kiểu ổ cứng
        seedDataVariantAtribute("1", 68, 65); // Tổng số khe cắm SSD/HDD
        seedDataVariantAtribute("0", 76, 65); // Số khe SSD/HDD còn lại
        seedDataVariantAtribute("Không hỗ trợ nâng cấp", 77, 65); // Dung lượng nâng cấp tối đa ổ cứng
        seedDataVariantAtribute("M.2 NVMe", 71, 65); // Loại SSD
        seedDataVariantAtribute("14 inch", 14, 65); // Kích thước màn hình
        seedDataVariantAtribute("OLED", 15, 65); // Công nghệ màn hình
        seedDataVariantAtribute("2880 x 1800 Pixels", 17, 65); // Độ phân giải
        seedDataVariantAtribute("OLED", 72, 65); // Loại màn hình
        seedDataVariantAtribute("120 Hz", 22, 65); // Tần số quét
        seedDataVariantAtribute("OLED", 73, 65); // Tấm nền
        seedDataVariantAtribute("100% DCI-P3", 78, 65); // Độ phủ màu
        seedDataVariantAtribute("16:10", 80, 65); // Tỷ lệ màn hình
        seedDataVariantAtribute("1.000.000:1", 20, 65); // Độ tương phản
        seedDataVariantAtribute("1 USB 3.2 Gen 1 Type-A, 2 Thunderbolt 4, 1 HDMI 2.1, 1 Jack 3.5 mm, 1 DC-in jack", 41, 65); // Cổng giao tiếp
        seedDataVariantAtribute("Wifi 6E", 42, 65); // Wi-Fi
        seedDataVariantAtribute("Bluetooth v5.3", 44, 65); // Bluetooth
        seedDataVariantAtribute("Full HD Webcam (1080p Webcam)", 74, 65); // Webcam
        seedDataVariantAtribute("Windows", 49, 65); // OS
        seedDataVariantAtribute("Windows 11 Home", 50, 65); // Phiên bản OS
        seedDataVariantAtribute("Mở khóa bằng mật mã", 37, 65); // Bảo mật
        seedDataVariantAtribute("Backlit Chiclet Keyboard", 52, 65); // Kiểu bàn phím
        seedDataVariantAtribute("Không", 53, 65); // Bàn phím số
        seedDataVariantAtribute("LED", 54, 65); // Đèn bàn phím
        seedDataVariantAtribute("Đơn sắc", 55, 65); // Công nghệ đèn bàn phím
        seedDataVariantAtribute("Trắng", 55, 65); // Màu đèn LED
        seedDataVariantAtribute("Multi-touch touchpad", 56, 65); // Touchpad
        seedDataVariantAtribute("75 Wh", 47, 65); // Dung lượng pin
        seedDataVariantAtribute("65 W", 75, 65); // Power Supply
        seedDataVariantAtribute("Bộ sạc điện, Sách HDSD", 51, 65); // Phụ kiện trong hộp
        seedDataVariantAtribute("31.24 x 22.01 x 1.49 ~ 1.49 cm", 5, 65); // Kích thước
        seedDataVariantAtribute("1.2 kg", 6, 65); // Trọng lượng sản phẩm
        seedDataVariantAtribute("Nhôm", 7, 65); // Chất liệu
        seedDataVariantAtribute("Trung Quốc", 1, 65); // Xuất xứ
        seedDataVariantAtribute("2023", 2, 65); // Thời điểm ra mắt
        seedDataVariantAtribute("24 tháng", 4, 65); // Thời gian bảo hành

        // Laptop Asus Gaming Vivobook K3605ZU-RP296W i5-12500H/16GB/512GB/16"/Nvidia GeForce RTX4050 6GB/Win11
        seedDataVariant("Laptop Asus Gaming Vivobook K3605ZU-RP296W i5-12500H/16GB/512GB", 23990000.0, 10, 27);

        seedDataVariantAtribute("Đen", 3, 66); // Màu sắc
        seedDataVariantAtribute("512 GB", 24, 66); // Dung lượng ổ cứng
        seedDataVariantAtribute("Intel", 60, 66);  // Hãng CPU
        seedDataVariantAtribute("Core i5", 61, 66); // Công nghệ CPU
        seedDataVariantAtribute("12500", 10, 66); // Loại CPU
        seedDataVariantAtribute("2.5 GHz", 11, 66); // Tốc độ CPU tối thiểu
        seedDataVariantAtribute("4.5 GHz", 62, 66); // Tốc độ CPU tối đa
        seedDataVariantAtribute("Intel", 63, 66); // Hãng (Card onboard)
        seedDataVariantAtribute("UHD", 64, 66); // Model (Card onboard)
        seedDataVariantAtribute("Intel UHD Graphics", 65, 66); // Tên đầy đủ (Card onboard)
        seedDataVariantAtribute("NVIDIA", 83, 66); // Hãng (Card rời)
        seedDataVariantAtribute("GeForce RTX 4050", 84, 66); // Model (Card rời)
        seedDataVariantAtribute("NVIDIA GeForce RTX 4050 6GB GDDR6", 65, 66); // Tên đầy đủ (Card rời)
        seedDataVariantAtribute("194 TOPS", 58, 66); // Hiệu suất AI (TOPS)
        seedDataVariantAtribute("16 GB (1 thanh 16 GB)", 13, 66); // Dung lượng RAM
        seedDataVariantAtribute("DDR4", 66, 66); // Loại RAM
        seedDataVariantAtribute("1", 76, 66); // Số khe cắm rời
        seedDataVariantAtribute("1", 68, 66); // Số RAM onboard
        seedDataVariantAtribute("24 GB", 79, 66); // Hỗ trợ RAM tối đa
        seedDataVariantAtribute("SSD", 70, 66); // Kiểu ổ cứng
        seedDataVariantAtribute("1", 68, 66); // Tổng số khe cắm SSD/HDD
        seedDataVariantAtribute("1 SSD", 76, 66); // Số khe SSD/HDD còn lại
        seedDataVariantAtribute("Không hỗ trợ nâng cấp", 77, 66); // Dung lượng nâng cấp tối đa ổ cứng
        seedDataVariantAtribute("M.2 NVMe", 71, 66); // Loại SSD
        seedDataVariantAtribute("16 inch", 14, 66); // Kích thước màn hình
        seedDataVariantAtribute("IPS LCD", 15, 66); // Công nghệ màn hình
        seedDataVariantAtribute("1920 x 1200 Pixels", 17, 66); // Độ phân giải
        seedDataVariantAtribute("Màn hình phẳng", 72, 66); // Loại màn hình
        seedDataVariantAtribute("144 Hz", 22, 66); // Tần số quét
        seedDataVariantAtribute("IPS", 73, 66); // Tấm nền
        seedDataVariantAtribute("300 nits", 21, 66); // Độ sáng
        seedDataVariantAtribute("45% NTSC", 78, 66); // Độ phủ màu
        seedDataVariantAtribute("16:10", 80, 66); // Tỷ lệ màn hình
        seedDataVariantAtribute("Cổng sạc, 2 USB 3.2 Gen 1 Type-A, 1 Thunderbolt 4, 1 HDMI 2.1, 1 Jack 3.5 mm, 1 DC-in jack, 1 Card reader", 41, 66); // Cổng giao tiếp
        seedDataVariantAtribute("Wifi 6E", 42, 66); // Wi-Fi
        seedDataVariantAtribute("Bluetooth v5.3", 44, 66); // Bluetooth
        seedDataVariantAtribute("HD Webcam (720p Webcam)", 74, 66); // Webcam
        seedDataVariantAtribute("Asus SonicMaster stereo", 81, 66); // Công nghệ âm thanh
        seedDataVariantAtribute("Windows", 49, 66); // OS
        seedDataVariantAtribute("Windows 11", 50, 66); // Phiên bản OS
        seedDataVariantAtribute("Mở khóa bằng mật mã", 37, 66); // Bảo mật
        seedDataVariantAtribute("Backlit Chiclet Keyboard", 52, 66); // Kiểu bàn phím
        seedDataVariantAtribute("Có", 53, 66); // Bàn phím số
        seedDataVariantAtribute("LED", 54, 66); // Đèn bàn phím
        seedDataVariantAtribute("RGB 1 Zone", 55, 66); // Công nghệ đèn bàn phím
        seedDataVariantAtribute("Trắng", 55, 66); // Màu đèn LED
        seedDataVariantAtribute("Multi-touch touchpad", 56, 66); // Touchpad
        seedDataVariantAtribute("70 Whr", 47, 66); // Dung lượng pin
        seedDataVariantAtribute("120 W", 75, 66); // Power Supply
        seedDataVariantAtribute("Dây cáp sạc", 51, 66); // Phụ kiện trong hộp
        seedDataVariantAtribute("35.86 x 24.91 x 1.89 ~ 1.89 cm", 5, 66); // Kích thước
        seedDataVariantAtribute("1.8 kg", 6, 66); // Trọng lượng sản phẩm
        seedDataVariantAtribute("Nhựa PP", 7, 66); // Chất liệu
        seedDataVariantAtribute("Trung Quốc", 1, 66); // Xuất xứ
        seedDataVariantAtribute("01/2024", 2, 66); // Thời điểm ra mắt
        seedDataVariantAtribute("24 tháng", 4, 66); // Thời gian bảo hành

        // Laptop Asus Gaming ROG Strix G16 G614JV-N4156W i7-13650HX/AI/16GB/512GB/16' 2.5K/Nvidia GeForce RTX4060 8GB/Win11
        seedDataVariant("Laptop Asus Gaming ROG Strix G16 G614JV-N4156W i7-13650HX/AI/16GB/512GB", 37990000.0, 10, 27);
        // Thông số kỹ thuật
        seedDataVariantAtribute("Xám", 3, 67); // Màu sắc
        seedDataVariantAtribute("512 GB", 24, 67); // Dung lượng ổ cứng
        seedDataVariantAtribute("Intel", 60, 67);  // Hãng CPU
        seedDataVariantAtribute("Core i7", 61, 67); // Công nghệ CPU
        seedDataVariantAtribute("13650HX", 10, 67); // Loại CPU
        seedDataVariantAtribute("2.6 GHz", 11, 67); // Tốc độ CPU tối thiểu
        seedDataVariantAtribute("4.9 GHz", 62, 67); // Tốc độ CPU tối đa
        seedDataVariantAtribute("Intel", 63, 67); // Hãng (Card onboard)
        seedDataVariantAtribute("UHD", 64, 67); // Model (Card onboard)
        seedDataVariantAtribute("Intel UHD Graphics", 65, 67); // Tên đầy đủ (Card onboard)
        seedDataVariantAtribute("NVIDIA", 83, 67); // Hãng (Card rời)
        seedDataVariantAtribute("GeForce RTX 4060", 84, 67); // Model (Card rời)
        seedDataVariantAtribute("NVIDIA GeForce RTX 4060 8GB", 65, 67); // Tên đầy đủ (Card rời)
        seedDataVariantAtribute("233 TOPS", 58, 67); // Hiệu suất AI (TOPS)
        seedDataVariantAtribute("16 GB (1 thanh 16 GB)", 13, 67); // Dung lượng RAM
        seedDataVariantAtribute("DDR5", 66, 67); // Loại RAM
        seedDataVariantAtribute("1", 68, 67); // Số RAM onboard
        seedDataVariantAtribute("32 GB", 79, 67); // Hỗ trợ RAM tối đa
        seedDataVariantAtribute("SSD", 70, 67); // Kiểu ổ cứng
        seedDataVariantAtribute("2 x SSD M2 PCIe", 68, 67); // Tổng số khe cắm SSD/HDD
        seedDataVariantAtribute("1 SSD", 76, 67); // Số khe SSD/HDD còn lại
        seedDataVariantAtribute("Nâng cấp tối đa 2TB (SSD M2 PCIe)", 77, 67); // Dung lượng nâng cấp tối đa ổ cứng
        seedDataVariantAtribute("M.2 NVMe", 71, 67); // Loại SSD
        seedDataVariantAtribute("16 inch", 14, 67); // Kích thước màn hình
        seedDataVariantAtribute("IPS", 15, 67); // Công nghệ màn hình
        seedDataVariantAtribute("2560 x 1600 Pixels", 17, 67); // Độ phân giải
        seedDataVariantAtribute("Màn hình phẳng", 72, 67); // Loại màn hình
        seedDataVariantAtribute("240 Hz", 22, 67); // Tần số quét
        seedDataVariantAtribute("IPS", 73, 67); // Tấm nền
        seedDataVariantAtribute("100% DCI-P3", 78, 67); // Độ phủ màu
        seedDataVariantAtribute("16:10", 80, 67); // Tỷ lệ màn hình
        seedDataVariantAtribute("1 RJ45 Gigabit Ethernet, 1 Thunderbolt 4, 1 USB 3.2 Gen 2 Type-C, 2 USB 3.2 Gen 2 Type-A", 41, 67); // Cổng giao tiếp
        seedDataVariantAtribute("Wifi 6E", 42, 67); // Wi-Fi
        seedDataVariantAtribute("Bluetooth v5.3", 44, 67); // Bluetooth
        seedDataVariantAtribute("HD Webcam (720p Webcam)", 74, 67); // Webcam
        seedDataVariantAtribute("Windows", 49, 67); // OS
        seedDataVariantAtribute("Windows 11 Home", 50, 67); // Phiên bản OS
        seedDataVariantAtribute("Mở khóa bằng mật mã", 37, 67); // Bảo mật
        seedDataVariantAtribute("Backlit Chiclet Keyboard", 52, 67); // Kiểu bàn phím
        seedDataVariantAtribute("Có", 53, 67); // Bàn phím số
        seedDataVariantAtribute("LED", 54, 67); // Đèn bàn phím
        seedDataVariantAtribute("RGB 4 Zone", 55, 67); // Công nghệ đèn bàn phím
        seedDataVariantAtribute("RGB", 55, 67); // Màu đèn LED
        seedDataVariantAtribute("Multi-touch touchpad", 56, 67); // Touchpad
        seedDataVariantAtribute("90 WHrs", 47, 67); // Dung lượng pin
        seedDataVariantAtribute("280 W", 75, 67); // Power Supply
        seedDataVariantAtribute("Sạc", 51, 67); // Phụ kiện trong hộp
        seedDataVariantAtribute("35.4 x 26.4 x 2.26 ~ 3.04 cm", 5, 67); // Kích thước
        seedDataVariantAtribute("2.5 kg", 6, 67); // Trọng lượng sản phẩm
        seedDataVariantAtribute("Kim loại", 7, 67); // Chất liệu
        seedDataVariantAtribute("Trung Quốc", 1, 67); // Xuất xứ
        seedDataVariantAtribute("2024", 2, 67); // Thời điểm ra mắt
        seedDataVariantAtribute("24 tháng", 4, 67); // Thời gian bảo hành

        //Laptop Acer
        seedDataProduct("Laptop Acer", "Laptop", 1.8, 11, 2, 2, "");
        //Laptop Acer Nitro 5 Tiger Gaming AN515-58-773Y i7 12700H/16GB/512GB/15.6 FHD/NVIDIA GeForce RTX3050Ti 4GB/Win11

        seedDataVariant("Laptop Acer Nitro 5 Tiger Gaming AN515-58-773Y i7 12700H/16GB/512GB", 22999000.0, 10, 28);
        // Thông số kỹ thuật
        seedDataVariantAtribute("Đen", 3, 68); // Màu sắc
        seedDataVariantAtribute("512 GB", 24, 68); // Dung lượng ổ cứng
        seedDataVariantAtribute("Intel", 60, 68);  // Hãng CPU
        seedDataVariantAtribute("Core i7", 61, 68); // Công nghệ CPU
        seedDataVariantAtribute("12700H", 10, 68); // Loại CPU
        seedDataVariantAtribute("3.5 GHz", 11, 68); // Tốc độ CPU tối thiểu
        seedDataVariantAtribute("4.7 GHz", 62, 68); // Tốc độ CPU tối đa
        seedDataVariantAtribute("Intel", 63, 68); // Hãng (Card onboard)
        seedDataVariantAtribute("Iris Xe", 64, 68); // Model (Card onboard)
        seedDataVariantAtribute("Intel Iris Xe Graphics", 65, 68); // Tên đầy đủ (Card onboard)
        seedDataVariantAtribute("NVIDIA", 83, 68); // Hãng (Card rời)
        seedDataVariantAtribute("NVIDIA GeForce RTX 3050 Ti 4 GB", 65, 68); // Tên đầy đủ (Card rời)
        seedDataVariantAtribute("16 GB", 13, 68); // Dung lượng RAM
        seedDataVariantAtribute("DDR4", 66, 68); // Loại RAM
        seedDataVariantAtribute("1", 76, 68); // Số khe cắm rời
        seedDataVariantAtribute("1", 68, 68); // Số RAM onboard
        seedDataVariantAtribute("32 GB", 79, 68); // Hỗ trợ RAM tối đa
        seedDataVariantAtribute("SSD", 70, 68); // Kiểu ổ cứng
        seedDataVariantAtribute("2", 68, 68); // Tổng số khe cắm SSD/HDD
        seedDataVariantAtribute("1", 76, 68); // Số khe SSD/HDD còn lại
        seedDataVariantAtribute("Nâng cấp tối đa 2TB (SSD M2 PCIe)", 77, 68); // Dung lượng nâng cấp tối đa ổ cứng
        seedDataVariantAtribute("NVMe PCIe", 71, 68); // Loại SSD
        seedDataVariantAtribute("15.6 inch", 14, 68); // Kích thước màn hình
        seedDataVariantAtribute("Acer ComfyView LED-backlit", 15, 68); // Công nghệ màn hình
        seedDataVariantAtribute("1920 x 1080 Pixels", 17, 68); // Độ phân giải
        seedDataVariantAtribute("144 Hz", 22, 68); // Tần số quét
        seedDataVariantAtribute("IPS", 73, 68); // Tấm nền
        seedDataVariantAtribute("250 nits", 21, 68); // Độ sáng
        seedDataVariantAtribute("45% NTSC", 78, 68); // Độ phủ màu
        seedDataVariantAtribute("16:09", 80, 68); // Tỷ lệ màn hình
        seedDataVariantAtribute("1 USB Type-C, 2 USB 3.2 Gen 2, 1 USB 3.2 Gen 1, 1 RJ45 Gigabit Ethernet, 1 HDMI 2.1, 1 Jack 3.5 mm, 1 DC-in jack", 41, 68); // Cổng giao tiếp
        seedDataVariantAtribute("Wifi 6", 42, 68); // Wi-Fi
        seedDataVariantAtribute("Bluetooth v5.1", 44, 68); // Bluetooth
        seedDataVariantAtribute("HD Webcam (720p Webcam)", 74, 68); // Webcam
        seedDataVariantAtribute("Windows", 49, 68); // OS
        seedDataVariantAtribute("Windows 11 Home", 50, 68); // Phiên bản OS
        seedDataVariantAtribute("Mở khóa bằng mật mã", 37, 68); // Bảo mật
        seedDataVariantAtribute("English International Backlit Keyboard", 52, 68); // Kiểu bàn phím
        seedDataVariantAtribute("Có", 53, 68); // Bàn phím số
        seedDataVariantAtribute("Có", 54, 68); // Đèn bàn phím
        seedDataVariantAtribute("Multi-touch touchpad", 56, 68); // Touchpad
        seedDataVariantAtribute("Pin Li-ion", 46, 68); // Loại pin
        seedDataVariantAtribute("4 Cell", 47, 68); // Dung lượng pin
        seedDataVariantAtribute("Cáp, Sạc", 51, 68); // Phụ kiện trong hộp
        seedDataVariantAtribute("360.4 x 271.09 x 25.9 mm", 5, 68); // Kích thước
        seedDataVariantAtribute("2.5 kg", 6, 68); // Trọng lượng sản phẩm
        seedDataVariantAtribute("Nhựa", 7, 68); // Chất liệu
        seedDataVariantAtribute("Trung Quốc", 1, 68); // Xuất xứ
        seedDataVariantAtribute("2022", 2, 68); // Thời điểm ra mắt
        seedDataVariantAtribute("12 tháng", 4, 68); // Thời gian bảo hành

        // Laptop Acer Aspire 7 Gaming A715-76G-73FM i7 12650H/16GB/512GB/15.6"FHD/RTX2050 4GB/Win11
        seedDataVariant("Laptop Acer Aspire 7 Gaming A715-76G-73FM i7 12650H/16GB/512GB", 1798900.0, 10, 28);
        // Thông số kỹ thuật
        seedDataVariantAtribute("Đen", 3, 69); // Màu sắc
        seedDataVariantAtribute("512 GB", 24, 69); // Dung lượng ổ cứng
        seedDataVariantAtribute("Intel", 60, 69);  // Hãng CPU
        seedDataVariantAtribute("Core i7", 61, 69); // Công nghệ CPU
        seedDataVariantAtribute("12650H", 10, 69); // Loại CPU
        seedDataVariantAtribute("2.3 GHz", 11, 69); // Tốc độ CPU tối thiểu
        seedDataVariantAtribute("4.3 GHz", 62, 69); // Tốc độ CPU tối đa
        seedDataVariantAtribute("Intel", 63, 69); // Hãng (Card onboard)
        seedDataVariantAtribute("UHD", 64, 69); // Model (Card onboard)
        seedDataVariantAtribute("Intel UHD Graphics", 65, 69); // Tên đầy đủ (Card onboard)
        seedDataVariantAtribute("NVIDIA Geforce RTX 2050 4GB", 65, 69); // Tên đầy đủ (Card rời)
        seedDataVariantAtribute("16 GB (2 thanh 8 GB)", 13, 69); // Dung lượng RAM
        seedDataVariantAtribute("DDR4", 66, 69); // Loại RAM
        seedDataVariantAtribute("3200 MHz", 67, 69); // Tốc độ RAM
        seedDataVariantAtribute("1", 76, 69); // Số khe cắm rời
        seedDataVariantAtribute("1", 68, 69); // Số RAM onboard
        seedDataVariantAtribute("32 GB", 79, 69); // Hỗ trợ RAM tối đa
        seedDataVariantAtribute("SSD", 70, 69); // Kiểu ổ cứng
        seedDataVariantAtribute("2 x SSD M2 PCIe", 68, 69); // Tổng số khe cắm SSD/HDD
        seedDataVariantAtribute("Nâng cấp tối đa 1TB (SSD M2 PCIe)", 77, 69); // Dung lượng nâng cấp tối đa ổ cứng
        seedDataVariantAtribute("NVMe PCIe", 71, 69); // Loại SSD
        seedDataVariantAtribute("15.6 inch", 14, 69); // Kích thước màn hình
        seedDataVariantAtribute("Acer ComfyView LED-backlit", 15, 69); // Công nghệ màn hình
        seedDataVariantAtribute("1920 x 1080 Pixels", 17, 69); // Độ phân giải
        seedDataVariantAtribute("144 Hz", 22, 69); // Tần số quét
        seedDataVariantAtribute("IPS", 73, 69); // Tấm nền
        seedDataVariantAtribute("250 nits", 21, 69); // Độ sáng
        seedDataVariantAtribute("45% NTSC", 78, 69); // Độ phủ màu
        seedDataVariantAtribute("1 USB Type-C, 3 USB Type-A, 1 HDMI 2.1, 1 DC-in jack, 1 RJ45 Gigabit Ethernet, 1 Jack 3.5 mm", 41, 69); // Cổng giao tiếp
        seedDataVariantAtribute("Wifi 6E", 42, 69); // Wi-Fi
        seedDataVariantAtribute("Bluetooth v5.1", 44, 69); // Bluetooth
        seedDataVariantAtribute("HD Webcam (720p Webcam)", 74, 69); // Webcam
        seedDataVariantAtribute("Windows", 49, 69); // OS
        seedDataVariantAtribute("Windows 11 Home", 50, 69); // Phiên bản OS
        seedDataVariantAtribute("Mở khóa vân tay", 37, 69); // Bảo mật
        seedDataVariantAtribute("Backlit Chiclet Keyboard", 52, 69); // Kiểu bàn phím
        seedDataVariantAtribute("Có", 53, 69); // Bàn phím số
        seedDataVariantAtribute("Có", 54, 69); // Đèn bàn phím
        seedDataVariantAtribute("Multi-touch touchpad", 56, 69); // Touchpad
        seedDataVariantAtribute("Adapter, Dây nguồn", 51, 69); // Phụ kiện trong hộp
        seedDataVariantAtribute("362.3 x 237.4 x 19.9 mm", 5, 69); // Kích thước
        seedDataVariantAtribute("2.1 kg", 6, 69); // Trọng lượng sản phẩm
        seedDataVariantAtribute("Nhựa", 7, 69); // Chất liệu
        seedDataVariantAtribute("Trung Quốc", 1, 69); // Xuất xứ
        seedDataVariantAtribute("2023", 2, 69); // Thời điểm ra mắt
        seedDataVariantAtribute("12 tháng", 4, 69); // Thời gian bảo hành


        // Laptop Acer Swift 3 SF314-512-741L i7 1260P/16GB/1T/14" QHD/Win11
        seedDataVariant("Laptop Acer Swift 3 SF314-512-741L i7 1260P/16GB/1T", 1898900.0, 10, 28);
        // Thông số kỹ thuật
        seedDataVariantAtribute("Vàng", 3, 70); // Màu sắc
        seedDataVariantAtribute("1 TB", 24, 70); // Dung lượng ổ cứng
        seedDataVariantAtribute("Intel", 60, 70);  // Hãng CPU
        seedDataVariantAtribute("Core i7", 61, 70); // Công nghệ CPU
        seedDataVariantAtribute("1260P", 10, 70); // Loại CPU
        seedDataVariantAtribute("3.30 GHz", 11, 70); // Tốc độ CPU tối thiểu
        seedDataVariantAtribute("4.70 GHz", 62, 70); // Tốc độ CPU tối đa
        seedDataVariantAtribute("12", 10, 70); // Số nhân
        seedDataVariantAtribute("16", 84, 70); // Số luồng
        seedDataVariantAtribute("18 MB", 85, 70); // Bộ nhớ đệm
        seedDataVariantAtribute("Intel", 63, 70); // Hãng (Card onboard)
        seedDataVariantAtribute("Iris Xe", 64, 70); // Model (Card onboard)
        seedDataVariantAtribute("Intel Iris Xe Graphics", 65, 70); // Tên đầy đủ (Card onboard)
        seedDataVariantAtribute("16 GB (1 thanh 16 GB)", 13, 70); // Dung lượng RAM
        seedDataVariantAtribute("LPDDR4", 66, 70); // Loại RAM
        seedDataVariantAtribute("1", 68, 70); // Số RAM onboard
        seedDataVariantAtribute("16 GB", 79, 70); // Hỗ trợ RAM tối đa
        seedDataVariantAtribute("SSD", 70, 70); // Kiểu ổ cứng
        seedDataVariantAtribute("1 x 1", 68, 70); // Tổng số khe cắm SSD/HDD
        seedDataVariantAtribute("0 SSD", 76, 70); // Số khe SSD/HDD còn lại
        seedDataVariantAtribute("M2. PCIe", 71, 70); // Loại SSD
        seedDataVariantAtribute("14.0 inch", 14, 70); // Kích thước màn hình
        seedDataVariantAtribute("Acer ComfyView LED-backlit", 15, 70); // Công nghệ màn hình
        seedDataVariantAtribute("2560 x 1440 Pixels", 17, 70); // Độ phân giải
        seedDataVariantAtribute("60 Hz", 22, 70); // Tần số quét
        seedDataVariantAtribute("IPS", 73, 70); // Tấm nền
        seedDataVariantAtribute("2 USB 3.2 Gen 2, 2 Type C, 1 HDMI 2.1, 1 Jack 3.5 mm", 41, 70); // Cổng giao tiếp
        seedDataVariantAtribute("802.11 a/b/g/n/ac/ax, Wifi 6", 42, 70); // Wi-Fi
        seedDataVariantAtribute("Bluetooth v5.2", 44, 70); // Bluetooth
        seedDataVariantAtribute("Full HD Webcam (1080p Webcam)", 74, 70); // Webcam
        seedDataVariantAtribute("Windows", 49, 70); // OS
        seedDataVariantAtribute("Windows 11 Home", 50, 70); // Phiên bản OS
        seedDataVariantAtribute("Mở khóa vân tay", 37, 70); // Bảo mật
        seedDataVariantAtribute("Bàn phím cứng", 52, 70); // Kiểu bàn phím
        seedDataVariantAtribute("Không", 53, 70); // Bàn phím số
        seedDataVariantAtribute("LED", 54, 70); // Đèn bàn phím
        seedDataVariantAtribute("Đơn sắc", 55, 70); // Công nghệ đèn bàn phím
        seedDataVariantAtribute("Trắng", 55, 70); // Màu đèn LED
        seedDataVariantAtribute("Multi-touch touchpad", 56, 70); // Touchpad
        seedDataVariantAtribute("Lithium-ion", 46, 70); // Loại pin
        seedDataVariantAtribute("56 Wh", 47, 70); // Dung lượng pin
        seedDataVariantAtribute("Sạc, Cáp", 51, 70); // Phụ kiện trong hộp
        seedDataVariantAtribute("321 x 210.8 x 15.9 mm", 5, 70); // Kích thước
        seedDataVariantAtribute("1.2 kg", 6, 70); // Trọng lượng sản phẩm
        seedDataVariantAtribute(" Mặt lưng Nhôm & Khung màn hình nhựa", 7, 70); // Chất liệu mặt lưng
        seedDataVariantAtribute("Trung Quốc", 1, 70); // Xuất xứ
        seedDataVariantAtribute("2022", 2, 70); // Thời điểm ra mắt
        seedDataVariantAtribute("12 tháng", 4, 70); // Thời gian bảo hành

        // Laptop Acer Nitro 16 Phoenix Gaming AN16-41-R50Z R5 7640HS/16GB/512GB/16"WUXGA//Nvidia Geforce RTX4050 6GB/Win11
        seedDataVariant("Laptop Acer Nitro 16 Phoenix Gaming AN16-41-R50Z R5 7640HS/16GB/512GB", 22798900.0, 10, 28);
        // Thông số kỹ thuật
        seedDataVariantAtribute("Đen", 3, 71); // Màu sắc
        seedDataVariantAtribute("512 GB", 24, 71); // Dung lượng ổ cứng
        seedDataVariantAtribute("AMD", 60, 71);  // Hãng CPU
        seedDataVariantAtribute("Ryzen 5", 61, 71); // Công nghệ CPU
        seedDataVariantAtribute("7640HS", 9, 71); // Loại CPU
        seedDataVariantAtribute("4.5 GHz", 62, 71); // Tốc độ CPU tối đa
        seedDataVariantAtribute("AMD", 63, 71); // Hãng (Card onboard)
        seedDataVariantAtribute("Radeon", 64, 71); // Model (Card onboard)
        seedDataVariantAtribute("AMD Radeon 760M Graphics", 65, 71); // Tên đầy đủ (Card onboard)
        seedDataVariantAtribute("NVIDIA", 83, 71); // Hãng (Card rời)
        seedDataVariantAtribute("NVIDIA GeForce RTX 4050 6GB", 65, 71); // Tên đầy đủ (Card rời)
        seedDataVariantAtribute("194 TOPS", 58, 71); // Hiệu suất AI (TOPS)
        seedDataVariantAtribute("16 GB", 13, 71); // Dung lượng RAM
        seedDataVariantAtribute("DDR5", 66, 71); // Loại RAM
        seedDataVariantAtribute("5600 MHz", 67, 71); // Tốc độ RAM
        seedDataVariantAtribute("1", 76, 71); // Số khe cắm rời
        seedDataVariantAtribute("1", 68, 71); // Số RAM onboard
        seedDataVariantAtribute("32 GB", 79, 71); // Hỗ trợ RAM tối đa
        seedDataVariantAtribute("SSD", 70, 71); // Kiểu ổ cứng
        seedDataVariantAtribute("2", 68, 71); // Tổng số khe cắm SSD/HDD
        seedDataVariantAtribute("1", 76, 71); // Số khe SSD/HDD còn lại
        seedDataVariantAtribute("Nâng cấp tối đa 2TB (SSD M2 PCIe)", 77, 71); // Dung lượng nâng cấp tối đa ổ cứng
        seedDataVariantAtribute("NVMe PCIe", 71, 71); // Loại SSD
        seedDataVariantAtribute("16 inch", 14, 71); // Kích thước màn hình
        seedDataVariantAtribute("Acer ComfyView LED-backlit", 15, 71); // Công nghệ màn hình
        seedDataVariantAtribute("1920 x 1200 Pixels", 17, 71); // Độ phân giải
        seedDataVariantAtribute("165 Hz", 22, 71); // Tần số quét
        seedDataVariantAtribute("IPS", 73, 71); // Tấm nền
        seedDataVariantAtribute("400 nits", 21, 71); // Độ sáng
        seedDataVariantAtribute("100% sRGB", 78, 71); // Độ phủ màu
        seedDataVariantAtribute("3 USB Type-A, 2 USB Type-C, 1 HDMI 2.1, 1 MicroSD card reader, 1 Jack 3.5 mm, 1 RJ45 Gigabit Ethernet, 1 DC-in jack", 41, 71); // Cổng giao tiếp
        seedDataVariantAtribute("802.11 a/b/g/n/ac/ax/be, Wifi 6E", 42, 71); // Wi-Fi
        seedDataVariantAtribute("Bluetooth v5.1", 44, 71); // Bluetooth
        seedDataVariantAtribute("HD Webcam (720p Webcam)", 74, 71); // Webcam
        seedDataVariantAtribute("Windows", 49, 71); // OS
        seedDataVariantAtribute("Windows 11 Home", 50, 71); // Phiên bản OS
        seedDataVariantAtribute("Mở khóa bằng mật mã", 37, 71); // Bảo mật
        seedDataVariantAtribute("English International Backlit Keyboard", 52, 71); // Kiểu bàn phím
        seedDataVariantAtribute("Có", 53, 71); // Bàn phím số
        seedDataVariantAtribute("Có", 54, 71); // Đèn bàn phím
        seedDataVariantAtribute("RGB 4 Zone", 55, 71); // Công nghệ đèn bàn phím
        seedDataVariantAtribute("Multi-touch touchpad", 56, 71); // Touchpad
        seedDataVariantAtribute("Pin Li-ion", 46, 71); // Loại pin
        seedDataVariantAtribute("4 Cell", 47, 71); // Dung lượng pin
        seedDataVariantAtribute("Cáp, Sạc", 51, 71); // Phụ kiện trong hộp
        seedDataVariantAtribute("360.1 x 279.9 x 25.9~27.9 mm", 5, 71); // Kích thước
        seedDataVariantAtribute("2.7 kg", 6, 71); // Trọng lượng sản phẩm
        seedDataVariantAtribute("Nhựa Polycarbonate", 7, 71); // Chất liệu
        seedDataVariantAtribute("Trung Quốc", 1, 71); // Xuất xứ
        seedDataVariantAtribute("2023", 2, 71); // Thời điểm ra mắt
        seedDataVariantAtribute("12 tháng", 4, 71); // Thời gian bảo hành

        // Laptop Acer Gaming Predator Helios Neo 14 PHN14-51-99Y8 Intel Core Ultra 9 185H/AI/32GB/1TB/14.5" WQXGA+/Nvidia RTX4060 8GB/Win11
        seedDataVariant("Laptop Acer Gaming Predator Helios Neo", 46798900.0, 8, 28);

        // Thông số kỹ thuật
        seedDataVariantAtribute("Đen", 3, 72); // Màu sắc
        seedDataVariantAtribute("1 TB", 24, 72); // Dung lượng ổ cứng
        seedDataVariantAtribute("Intel", 60, 72);  // Hãng CPU
        seedDataVariantAtribute("Core Ultra 9", 61, 72); // Công nghệ CPU
        seedDataVariantAtribute("185H", 9, 72); // Loại CPU
        seedDataVariantAtribute("2.3 GHz", 11, 72); // Tốc độ CPU tối thiểu
        seedDataVariantAtribute("5.1 GHz", 62, 72); // Tốc độ CPU tối đa
        seedDataVariantAtribute("10", 58, 72); // Hiệu suất xử lý AI của CPU
        seedDataVariantAtribute("Intel UHD Graphics", 65, 72); // Tên đầy đủ (Card onboard)
        seedDataVariantAtribute("NVIDIA Geforce RTX 4060 8GB GDDR6", 65, 72); // Tên đầy đủ (Card rời)
        seedDataVariantAtribute("233 TOPS", 58, 72); // Hiệu suất AI (TOPS)
        seedDataVariantAtribute("32 GB", 13, 72); // Dung lượng RAM
        seedDataVariantAtribute("LPDDR5X", 66, 72); // Loại RAM
        seedDataVariantAtribute("1", 68, 72); // Số RAM onboard
        seedDataVariantAtribute("32 GB", 79, 72); // Hỗ trợ RAM tối đa
        seedDataVariantAtribute("SSD", 70, 72); // Kiểu ổ cứng
        seedDataVariantAtribute("1 M.2 NVMe", 71, 72); // Loại SSD
        seedDataVariantAtribute("14.5 inch", 14, 72); // Kích thước màn hình
        seedDataVariantAtribute("Acer ComfyView LED-backlit", 15, 72); // Công nghệ màn hình
        seedDataVariantAtribute("3072 x 1920 Pixels", 17, 72); // Độ phân giải
        seedDataVariantAtribute("165 Hz", 22, 72); // Tần số quét
        seedDataVariantAtribute("IPS", 73, 72); // Tấm nền
        seedDataVariantAtribute("400 nits", 21, 72); // Độ sáng
        seedDataVariantAtribute("100% DCI-P3", 78, 72); // Độ phủ màu
        seedDataVariantAtribute("16:10", 80, 72); // Tỷ lệ màn hình
        seedDataVariantAtribute("2 USB Type-C, 3 USB Type-A, 1 HDMI 2.1, 1 MicroSD card reader, 1 Jack 3.5 mm, 1 DC-in jack", 41, 72); // Cổng giao tiếp
        seedDataVariantAtribute("Wifi 6E", 42, 72); // Wi-Fi
        seedDataVariantAtribute("Bluetooth v5.1", 44, 72); // Bluetooth
        seedDataVariantAtribute("HD Webcam (720p Webcam)", 74, 72); // Webcam
        seedDataVariantAtribute("Windows", 49, 72); // OS
        seedDataVariantAtribute("Windows 11 Home Single Language", 50, 72); // Phiên bản OS
        seedDataVariantAtribute("Mật khẩu", 37, 72); // Bảo mật
        seedDataVariantAtribute("English International Backlit Keyboard", 52, 72); // Kiểu bàn phím
        seedDataVariantAtribute("Không", 53, 72); // Bàn phím số
        seedDataVariantAtribute("Có", 54, 72); // Đèn bàn phím
        seedDataVariantAtribute("RGB 3 Zone", 55, 72); // Công nghệ đèn bàn phím
        seedDataVariantAtribute("Multi-touch touchpad", 56, 72); // Touchpad
        seedDataVariantAtribute("Cáp, Sạc", 51, 72); // Phụ kiện trong hộp
        seedDataVariantAtribute("324.12 x 255.35 x 19.52/20.90 mm", 5, 72); // Kích thước
        seedDataVariantAtribute("1.9 kg", 6, 72); // Trọng lượng sản phẩm
        seedDataVariantAtribute("Lưng Nhôm Aluminium & Màn hình Nhựa ABS", 7, 72); // Chất liệu mặt lưng
        seedDataVariantAtribute("Trung Quốc", 1, 72); // Xuất xứ
        seedDataVariantAtribute("01/2024", 2, 72); // Thời điểm ra mắt
        seedDataVariantAtribute("12 tháng", 4, 72); // Thời gian bảo hành


        // Laptop Acer Swift Go AI SFG14-73-53X7 Intel Core Ultra 5 125H/16GB/512GB/14" 2.8K/Intel Arc Graphics/Win11
        seedDataVariant("Laptop Acer Swift Go AI SFG14-73-53X7 Intel Core Ultra 5 125H/16GB/512GB", 23998900.0, 5, 28);

        // Thông số kỹ thuật
        seedDataVariantAtribute("Đen", 3, 73); // Màu sắc
        seedDataVariantAtribute("512 GB", 24, 73); // Dung lượng ổ cứng
        seedDataVariantAtribute("Intel", 60, 73);  // Hãng CPU
        seedDataVariantAtribute("Core i5", 61, 73); // Công nghệ CPU
        seedDataVariantAtribute("13420H", 9, 73); // Loại CPU
        seedDataVariantAtribute("4.6 GHz", 62, 73); // Tốc độ CPU tối đa
        seedDataVariantAtribute("Intel UHD Graphics", 65, 73); // Tên đầy đủ (Card onboard)
        seedDataVariantAtribute("NVIDIA Geforce RTX 2050 4GB", 65, 73); // Tên đầy đủ (Card rời)
        seedDataVariantAtribute("104 TOPS", 58, 73); // Hiệu suất AI (TOPS)
        seedDataVariantAtribute("16 GB", 13, 73); // Dung lượng RAM
        seedDataVariantAtribute("DDR5", 66, 73); // Loại RAM
        seedDataVariantAtribute("2", 76, 73); // Số khe cắm rời
        seedDataVariantAtribute("32 GB", 79, 73); // Hỗ trợ RAM tối đa
        seedDataVariantAtribute("SSD", 70, 73); // Kiểu ổ cứng
        seedDataVariantAtribute("Nâng cấp tối đa 2TB (SSD M2 PCIe)", 77, 73); // Dung lượng nâng cấp tối đa ổ cứng
        seedDataVariantAtribute("2 M.2 NVMe", 71, 73); // Loại SSD
        seedDataVariantAtribute("15.6 inch", 14, 73); // Kích thước màn hình
        seedDataVariantAtribute("FHD", 15, 73); // Công nghệ màn hình
        seedDataVariantAtribute("FHD (1920 x 1080)", 17, 73); // Độ phân giải
        seedDataVariantAtribute("144 Hz", 22, 73); // Tần số quét
        seedDataVariantAtribute("IPS", 73, 73); // Tấm nền
        seedDataVariantAtribute("250 nits", 21, 73); // Độ sáng
        seedDataVariantAtribute("45% NTSC", 78, 73); // Độ phủ màu
        seedDataVariantAtribute("1 USB Type-C, 3 USB Type-A, 1 Jack 3.5 mm, 1 HDMI 2.1, 1 RJ45 Gigabit Ethernet, 1 DC-in jack", 41, 73); // Cổng giao tiếp
        seedDataVariantAtribute("802.11 a/b/g/n/ac/ax", 42, 73); // Wi-Fi
        seedDataVariantAtribute("Bluetooth v5.1", 44, 73); // Bluetooth
        seedDataVariantAtribute("HD Webcam (720p Webcam)", 74, 73); // Webcam
        seedDataVariantAtribute("Windows", 49, 73); // OS
        seedDataVariantAtribute("Windows 11 Home Single Language", 50, 73); // Phiên bản OS
        seedDataVariantAtribute("Mật khẩu", 37, 73); // Bảo mật
        seedDataVariantAtribute("English International Backlit Keyboard", 52, 73); // Kiểu bàn phím
        seedDataVariantAtribute("Có", 53, 73); // Bàn phím số
        seedDataVariantAtribute("Trắng", 54, 73); // Đèn bàn phím
        seedDataVariantAtribute("Đơn sắc", 55, 73); // Công nghệ đèn bàn phím
        seedDataVariantAtribute("Multi-touch touchpad", 56, 73); // Touchpad
        seedDataVariantAtribute("Cáp, Sạc", 51, 73); // Phụ kiện trong hộp
        seedDataVariantAtribute("362.3 x 239.89 x 22.9/26.9 mm", 5, 73); // Kích thước
        seedDataVariantAtribute("2.1 kg", 6, 73); // Trọng lượng sản phẩm
        seedDataVariantAtribute("Nhựa Polycarbonate", 7, 73); // Chất liệu
        seedDataVariantAtribute("Trung Quốc", 1, 73); // Xuất xứ
        seedDataVariantAtribute("2023", 2, 73); // Thời điểm ra mắt
        seedDataVariantAtribute("12 tháng", 4, 73); // Thời gian bảo hành

        // Laptop Acer Nitro V 16 ProPanel Gaming ANV16-41-R36Y R7 8845HS/AI/16GB/512GB/16"WUXGA/NVIDIA GeForce RTX4050 6GB/Win11

        seedDataVariant("Laptop Acer Nitro V 16 ProPanel Gaming ANV16-41-R36Y R7 8845HS/AI/16GB/512GB", 29998900.0, 8, 28);

        // Thông số kỹ thuật
        seedDataVariantAtribute("Đen", 3, 74); // Màu sắc
        seedDataVariantAtribute("512 GB", 24, 74); // Dung lượng ổ cứng
        seedDataVariantAtribute("Intel", 60, 74);  // Hãng CPU
        seedDataVariantAtribute("AMD Ryzen", 61, 74); // Công nghệ CPU
        seedDataVariantAtribute("R7 8845HS", 9, 74); // Loại CPU
        seedDataVariantAtribute("3.8 GHz", 11, 74); // Tốc độ CPU tối thiểu
        seedDataVariantAtribute("5.1 GHz", 62, 74); // Tốc độ CPU tối đa
        seedDataVariantAtribute("Intel UHD Graphics", 65, 74); // Tên đầy đủ (Card onboard)
        seedDataVariantAtribute("NVIDIA GeForce RTX 4050 6GB GDDR6", 65, 74); // Tên đầy đủ (Card rời)
        seedDataVariantAtribute("16 GB", 13, 74); // Dung lượng RAM
        seedDataVariantAtribute("DDR5", 66, 74); // Loại RAM
        seedDataVariantAtribute("2", 76, 74); // Số khe cắm rời
        seedDataVariantAtribute("1", 76, 74); // Số khe RAM còn lại
        seedDataVariantAtribute("64 GB", 79, 74); // Hỗ trợ RAM tối đa
        seedDataVariantAtribute("SSD", 70, 74); // Kiểu ổ cứng
        seedDataVariantAtribute("Nâng cấp tối đa 4TB (SSD M2 PCle)", 77, 74); // Dung lượng nâng cấp tối đa ổ cứng
        seedDataVariantAtribute("2 M.2 NVMe", 71, 74); // Loại SSD
        seedDataVariantAtribute("16 inch", 14, 74); // Kích thước màn hình
        seedDataVariantAtribute("Acer ComfyView LED-backlit", 15, 74); // Công nghệ màn hình
        seedDataVariantAtribute("1920 x 1200 Pixels", 17, 74); // Độ phân giải
        seedDataVariantAtribute("165 Hz", 22, 74); // Tần số quét
        seedDataVariantAtribute("IPS", 73, 74); // Tấm nền
        seedDataVariantAtribute("300 nits", 21, 74); // Độ sáng
        seedDataVariantAtribute("100% sRGB", 78, 74); // Độ phủ màu
        seedDataVariantAtribute("1 USB Type-C, 2 USB Type-A, 1 Jack 3.5 mm, 1 RJ45 Gigabit Ethernet, 1 DC-in jack", 41, 74); // Cổng giao tiếp
        seedDataVariantAtribute("Wifi 6E", 42, 74); // Wi-Fi
        seedDataVariantAtribute("Bluetooth v5.3", 44, 74); // Bluetooth
        seedDataVariantAtribute("HD Webcam (720p Webcam)", 74, 74); // Webcam
        seedDataVariantAtribute("Windows", 49, 74); // OS
        seedDataVariantAtribute("Windows 11 Home Single Language", 50, 74); // Phiên bản OS
        seedDataVariantAtribute("Mật khẩu", 37, 74); // Bảo mật
        seedDataVariantAtribute("English International Backlit Keyboard", 52, 74); // Kiểu bàn phím
        seedDataVariantAtribute("Có", 53, 74); // Bàn phím số
        seedDataVariantAtribute("Amber", 54, 74); // Đèn bàn phím
        seedDataVariantAtribute("Multi-touch touchpad", 56, 74); // Touchpad
        seedDataVariantAtribute("Pin Li-ion", 46, 74); // Loại pin
        seedDataVariantAtribute("4 Cell", 47, 74); // Dung lượng pin
        seedDataVariantAtribute("Sạc, Cáp", 51, 74); // Phụ kiện trong hộp
        seedDataVariantAtribute("361.8 x 278.4 x 24.74/25.46 mm", 5, 74); // Kích thước
        seedDataVariantAtribute("2.5 kg", 6, 74); // Trọng lượng sản phẩm
        seedDataVariantAtribute("Plastic", 7, 74); // Chất liệu
        seedDataVariantAtribute("Trung Quốc", 1, 74); // Xuất xứ
        seedDataVariantAtribute("2024", 2, 74); // Thời điểm ra mắt
        seedDataVariantAtribute("12 tháng", 4, 74); // Thời gian bảo hành

        //Laptop HP
        seedDataProduct("Laptop HP", "Laptop", 1.8, 8, 2, 2, "");
        //Laptop HP Gaming Victus 16-s0173AX R5-7640HS/16GB/512GB/16" 144Hz/GeForce RTX3050 6GB/Win11_A9LG9PA

        seedDataVariant("Laptop HP Gaming Victus 16-s0173AX R5-7640HS/16GB/512GB", 20998900.0, 5, 29);

        // Thông số kỹ thuật
        seedDataVariantAtribute("Đen", 3, 75); // Màu sắc
        seedDataVariantAtribute("512 GB", 24, 75); // Dung lượng ổ cứng
        seedDataVariantAtribute("AMD", 60, 75);  // Hãng CPU
        seedDataVariantAtribute("Ryzen 5", 61, 75); // Công nghệ CPU
        seedDataVariantAtribute("7640HS", 10, 75); // Loại CPU
        seedDataVariantAtribute("4.3 GHz", 11, 75); // Tốc độ CPU tối thiểu
        seedDataVariantAtribute("AMD Radeon Graphics", 65, 75); // Tên đầy đủ (Card onboard)
        seedDataVariantAtribute("NVIDIA GeForce RTX 3050 6GB", 65, 75); // Tên đầy đủ (Card rời)
        seedDataVariantAtribute("16 GB", 13, 75); // Dung lượng RAM
        seedDataVariantAtribute("DDR5", 66, 75); // Loại RAM
        seedDataVariantAtribute("4800 MHz", 67, 75); // Tốc độ RAM
        seedDataVariantAtribute("2", 76, 75); // Số khe cắm rời
        seedDataVariantAtribute("64 GB", 79, 75); // Hỗ trợ RAM tối đa
        seedDataVariantAtribute("SSD", 70, 75); // Kiểu ổ cứng
        seedDataVariantAtribute("Nâng cấp tối đa 2TB (SSD M2 PCIe)", 77, 75); // Dung lượng nâng cấp tối đa ổ cứng
        seedDataVariantAtribute("1 M.2 NVMe", 71, 75); // Loại SSD
        seedDataVariantAtribute("16.1 inch", 14, 75); // Kích thước màn hình
        seedDataVariantAtribute("Anti-Glare", 15, 75); // Công nghệ màn hình
        seedDataVariantAtribute("1920 x 1080 Pixels", 17, 75); // Độ phân giải
        seedDataVariantAtribute("LED", 72, 75); // Loại màn hình
        seedDataVariantAtribute("144 Hz", 22, 75); // Tần số quét
        seedDataVariantAtribute("IPS", 73, 75); // Tấm nền
        seedDataVariantAtribute("45% NTSC", 78, 75); // Độ phủ màu
        seedDataVariantAtribute("16:09", 80, 75); // Tỷ lệ màn hình
        seedDataVariantAtribute("Cổng sạc:, 3 USB Type-A, 1 USB Type-C, 1 HDMI 2.1, 1 RJ45 Gigabit Ethernet, 1 AC, 1 headphone/microphone combo", 41, 75); // Cổng giao tiếp
        seedDataVariantAtribute("802.11 a/b/g/n/ac/ax", 42, 75); // Wi-Fi
        seedDataVariantAtribute("Bluetooth v5.3", 44, 75); // Bluetooth
        seedDataVariantAtribute("Full HD Webcam (1080p Webcam)", 74, 75); // Webcam
        seedDataVariantAtribute("Windows", 49, 75); // OS
        seedDataVariantAtribute("Windows 11 Home Single Language", 50, 75); // Phiên bản OS
        seedDataVariantAtribute("Mật khẩu", 37, 75); // Bảo mật
        seedDataVariantAtribute("6-row, multimedia Fn keys, numeric keypad", 52, 75); // Kiểu bàn phím
        seedDataVariantAtribute("Có", 53, 75); // Bàn phím số
        seedDataVariantAtribute("LED", 54, 75); // Đèn bàn phím
        seedDataVariantAtribute("RGB 1 Zone", 55, 75); // Công nghệ đèn bàn phím
        seedDataVariantAtribute("RGB", 81, 75); // Màu đèn LED
        seedDataVariantAtribute("Multi-touch touchpad", 56, 75); // Touchpad
        seedDataVariantAtribute("70 WHrs", 47, 75); // Dung lượng pin
        seedDataVariantAtribute("200 W", 75, 75); // Power Supply
        seedDataVariantAtribute("Dây cáp sạc", 51, 75); // Phụ kiện trong hộp
        seedDataVariantAtribute("36.9 x 25.94 x 2.29 cm", 5, 75); // Kích thước
        seedDataVariantAtribute("2.33 kg", 6, 75); // Trọng lượng sản phẩm
        seedDataVariantAtribute("Nhựa", 7, 75); // Chất liệu
        seedDataVariantAtribute("Trung Quốc", 1, 75); // Xuất xứ
        seedDataVariantAtribute("2024", 2, 75); // Thời điểm ra mắt
        seedDataVariantAtribute("12 tháng", 4, 75); // Thời gian bảo hành

        // Laptop HP Gaming Victus 16-r0127TX i7-13700H/AI/16GB/512GB/16.1" 144Hz/GeForce RTX4060 8GB/Win11_8C5N2PA
        seedDataVariant("Laptop HP Gaming Victus 16-r0127TX i7-13700H/AI/16GB/512GB", 32998900.0, 5, 29);
        // Thông số kỹ thuật
        seedDataVariantAtribute("Đen", 3, 76); // Màu sắc
        seedDataVariantAtribute("512 GB", 24, 76); // Dung lượng ổ cứng
        seedDataVariantAtribute("Intel", 60, 76);  // Hãng CPU
        seedDataVariantAtribute("Core i7", 61, 76); // Công nghệ CPU
        seedDataVariantAtribute("13700H", 9, 76); // Loại CPU
        seedDataVariantAtribute("5 GHz", 11, 76); // Tốc độ CPU tối thiểu
        seedDataVariantAtribute("Intel Iris Xe Graphics", 65, 76); // Tên đầy đủ (Card onboard)
        seedDataVariantAtribute("NVIDIA GeForce RTX 4060 8GB", 65, 76); // Tên đầy đủ (Card rời)
        seedDataVariantAtribute("16 GB", 13, 76); // Dung lượng RAM
        seedDataVariantAtribute("DDR5", 66, 76); // Loại RAM
        seedDataVariantAtribute("2", 76, 76); // Số khe cắm rời
        seedDataVariantAtribute("64 GB", 79, 76); // Hỗ trợ RAM tối đa
        seedDataVariantAtribute("SSD", 70, 76); // Kiểu ổ cứng
        seedDataVariantAtribute("Nâng cấp tối đa 2TB (SSD M2 PCIe)", 77, 76); // Dung lượng nâng cấp tối đa ổ cứng
        seedDataVariantAtribute("1 M.2 NVMe", 71, 76); // Loại SSD
        seedDataVariantAtribute("16.1 inch", 14, 76); // Kích thước màn hình
        seedDataVariantAtribute("LED anti-glare", 15, 76); // Công nghệ màn hình
        seedDataVariantAtribute("1920 x 1080 Pixels", 17, 76); // Độ phân giải
        seedDataVariantAtribute("144 Hz", 22, 76); // Tần số quét
        seedDataVariantAtribute("IPS", 73, 76); // Tấm nền
        seedDataVariantAtribute("45% NTSC", 78, 76); // Độ phủ màu
        seedDataVariantAtribute("16:09", 80, 76); // Tỷ lệ màn hình
        seedDataVariantAtribute("Cổng sạc:, 1 USB Type-C, 3 USB Type-A, 1 AC, 1 HDMI 2.1, 1 Jack 3.5 mm, 1 RJ45 Gigabit Ethernet", 41, 76); // Cổng giao tiếp
        seedDataVariantAtribute("802.11 ax", 42, 76); // Wi-Fi
        seedDataVariantAtribute("Bluetooth v5.3", 44, 76); // Bluetooth
        seedDataVariantAtribute("Full HD Webcam (1080p Webcam)", 74, 76); // Webcam
        seedDataVariantAtribute("Windows", 49, 76); // OS
        seedDataVariantAtribute("Windows 11 Home Single Language", 50, 76); // Phiên bản OS
        seedDataVariantAtribute("Mật khẩu", 37, 76); // Bảo mật
        seedDataVariantAtribute("6-row, multimedia Fn keys, numeric keypad", 52, 76); // Kiểu bàn phím
        seedDataVariantAtribute("Có", 53, 76); // Bàn phím số
        seedDataVariantAtribute("LED", 54, 76); // Đèn bàn phím
        seedDataVariantAtribute("RGB 1 Zone", 55, 76); // Công nghệ đèn bàn phím
        seedDataVariantAtribute("RGB", 81, 76); // Màu đèn LED
        seedDataVariantAtribute("Multi-touch touchpad", 56, 76); // Touchpad
        seedDataVariantAtribute("70 Wh", 47, 76); // Dung lượng pin
        seedDataVariantAtribute("230 W", 75, 76); // Power Supply
        seedDataVariantAtribute("Dây cáp sạc", 51, 76); // Phụ kiện trong hộp
        seedDataVariantAtribute("36.9 x 25.94 x 2.39 cm", 5, 76); // Kích thước
        seedDataVariantAtribute("2.33 kg", 6, 76); // Trọng lượng sản phẩm
        seedDataVariantAtribute("Nhựa", 7, 76); // Chất liệu
        seedDataVariantAtribute("Trung Quốc", 1, 76); // Xuất xứ
        seedDataVariantAtribute("01/2024", 2, 76); // Thời điểm ra mắt
        seedDataVariantAtribute("12 tháng", 4, 76); // Thời gian bảo hành

        //Laptop HP 245 G10 R7- 7730U/16GB/512GB/14" FHD/Win11_8F157PA
        seedDataVariant("Laptop HP 245 G10 R7- 7730U/16GB/512GB", 15998900.0, 5, 29);
        // Thông số kỹ thuật
        seedDataVariantAtribute("Bạc", 3, 77); // Màu sắc
        seedDataVariantAtribute("512 GB", 24, 77); // Dung lượng ổ cứng
        seedDataVariantAtribute("AMD", 60, 77);  // Hãng CPU
        seedDataVariantAtribute("Ryzen 7", 61, 77); // Công nghệ CPU
        seedDataVariantAtribute("7730U", 9, 77); // Loại CPU
        seedDataVariantAtribute("2.8 GHz", 11, 77); // Tốc độ CPU tối thiểu
        seedDataVariantAtribute("AMD Radeon Graphics", 65, 77); // Tên đầy đủ (Card onboard)
        seedDataVariantAtribute("16 GB", 13, 77); // Dung lượng RAM
        seedDataVariantAtribute("DDR4", 66, 77); // Loại RAM
        seedDataVariantAtribute("Không nâng cấp", 79, 77); // Hỗ trợ RAM tối đa
        seedDataVariantAtribute("SSD", 70, 77); // Kiểu ổ cứng
        seedDataVariantAtribute("Nâng cấp tối đa 1TB (SSD M2 PCIe)", 77, 77); // Dung lượng nâng cấp tối đa ổ cứng
        seedDataVariantAtribute("1 M.2 NVMe", 71, 77); // Loại SSD
        seedDataVariantAtribute("14 inch", 14, 77); // Kích thước màn hình
        seedDataVariantAtribute("Anti-Glare", 15, 77); // Công nghệ màn hình
        seedDataVariantAtribute("1920 x 1080 Pixels", 17, 77); // Độ phân giải
        seedDataVariantAtribute("60 Hz", 22, 77); // Tần số quét
        seedDataVariantAtribute("IPS", 73, 77); // Tấm nền
        seedDataVariantAtribute("16:09", 80, 77); // Tỷ lệ màn hình
        seedDataVariantAtribute("1 USB Type-C, Jack 3.5 mm, 1 HDMI, 2 USB 3.2", 41, 77); // Cổng giao tiếp
        seedDataVariantAtribute("Wifi 6", 42, 77); // Wi-Fi
        seedDataVariantAtribute("Bluetooth v5.3", 44, 77); // Bluetooth
        seedDataVariantAtribute("HD 720p DualAryMic", 74, 77); // Webcam
        seedDataVariantAtribute("Windows", 49, 77); // OS
        seedDataVariantAtribute("Windows 11 Home Single Language", 50, 77); // Phiên bản OS
        seedDataVariantAtribute("Mật khẩu", 37, 77); // Bảo mật
        seedDataVariantAtribute("6-row, multimedia Fn keys", 52, 77); // Kiểu bàn phím
        seedDataVariantAtribute("Không", 53, 77); // Bàn phím số
        seedDataVariantAtribute("Không", 54, 77); // Đèn bàn phím
        seedDataVariantAtribute("Multi-touch touchpad", 56, 77); // Touchpad
        seedDataVariantAtribute("41 Wh", 47, 77); // Dung lượng pin
        seedDataVariantAtribute("45 W", 75, 77); // Power Supply
        seedDataVariantAtribute("Dây cáp sạc", 51, 77); // Phụ kiện trong hộp
        seedDataVariantAtribute("32.4 x 21.5 x 1.79 cm", 5, 77); // Kích thước
        seedDataVariantAtribute("1.36 kg", 6, 77); // Trọng lượng sản phẩm
        seedDataVariantAtribute("Nhựa", 7, 77); // Chất liệu
        seedDataVariantAtribute("Trung Quốc", 1, 77); // Xuất xứ
        seedDataVariantAtribute("2024", 2, 77); // Thời điểm ra mắt
        seedDataVariantAtribute("12 tháng", 4, 77); // Thời gian bảo hành


        // Laptop HP Envy X360 14-fc0089TU Ultra 7-155U/AI/16GB/512GB/14'' 2.8K Touch/Pen/Win11
        seedDataVariant("Laptop HP Envy X360 14-fc0089TU Ultra 7-155U/AI/16GB/512GB", 30998900.0, 7, 29);

        seedDataVariantAtribute("Intel", 9, 78); // Bộ xử lý - Hãng CPU
        seedDataVariantAtribute("Core Ultra 7", 61, 78); // Bộ xử lý - Công nghệ CPU
        seedDataVariantAtribute("155U", 10, 78); // Bộ xử lý - Loại CPU
        seedDataVariantAtribute("1.7", 12, 78); // Bộ xử lý - Tốc độ CPU tối thiểu
        seedDataVariantAtribute("10", 85, 78); // Bộ xử lý - Hiệu suất xử lý AI của CPU
        seedDataVariantAtribute("Intel", 63, 78); // Đồ họa - Hãng (Card Oboard)
        seedDataVariantAtribute("UHD", 64, 78); // Đồ họa - Model (Card Oboard)
        seedDataVariantAtribute("Intel UHD Graphics", 65, 78); // Đồ họa - Tên đầy đủ (Card onboard)
        seedDataVariantAtribute("16 GB (2 thanh 8 GB)", 79, 78); // RAM - Dung lượng RAM
        seedDataVariantAtribute("LPDDR5", 66, 78); // RAM - Loại RAM
        seedDataVariantAtribute("2", 67, 78); // RAM - Số RAM onboard
        seedDataVariantAtribute("Không nâng cấp", 68, 78); // RAM - Hỗ trợ RAM tối đa
        seedDataVariantAtribute("SSD", 70, 78); // Lưu trữ - Kiểu ổ cứng
        seedDataVariantAtribute("1", 71, 78); // Lưu trữ - Tổng số khe cắm SSD/HDD
        seedDataVariantAtribute("0", 72, 78); // Lưu trữ - Số khe SSD/HDD còn lại
        seedDataVariantAtribute("Nâng cấp tối đa 2TB (SSD M2 PCIe)", 73, 78); // Lưu trữ - Dung lượng nâng cấp tối đa ổ cứng
        seedDataVariantAtribute("1 M.2 NVMe", 73, 78); // Lưu trữ - Loại SSD
        seedDataVariantAtribute("512", 23, 78); // Lưu trữ - Dung lượng
        seedDataVariantAtribute("14 inch", 14, 78); // Màn hình - Kích thước màn hình
        seedDataVariantAtribute("OLED", 15, 78); // Màn hình - Công nghệ màn hình
        seedDataVariantAtribute("2880 x 1800 Pixels", 17, 78); // Màn hình - Độ phân giải
        seedDataVariantAtribute("OLED", 19, 78); // Màn hình - Loại màn hình
        seedDataVariantAtribute("120", 22, 78); // Màn hình - Tần số quét
        seedDataVariantAtribute("OLED", 73, 78); // Màn hình - Tấm nền
        seedDataVariantAtribute("100% DCI-P3", 78, 78); // Màn hình - Độ phủ màu
        seedDataVariantAtribute("16:10", 81, 78); // Màn hình - Tỷ lệ màn hình
        seedDataVariantAtribute("2 USB Type-A", 41, 78); // Giao tiếp và kết nối - Cổng giao tiếp
        seedDataVariantAtribute("802.11 a/b/g/n/ac/ax", 42, 78); // Giao tiếp và kết nối - Wifi
        seedDataVariantAtribute("v5.3", 44, 78); // Giao tiếp và kết nối - Bluetooth
        seedDataVariantAtribute("5.0 MP", 74, 78); // Giao tiếp và kết nối - Webcam
        seedDataVariantAtribute("Windows", 49, 78); // Hệ điều hành - OS
        seedDataVariantAtribute("Windows 11 Home Single Language", 50, 78); // Hệ điều hành - Version
        seedDataVariantAtribute("Mở khóa khuôn mặt", 37, 78); // Bảo mật - Bảo mật
        seedDataVariantAtribute("6-row, multimedia Fn keys, numeric keypad", 51, 78); // Bàn phím & TouchPad - Kiểu bàn phím
        seedDataVariantAtribute("Không", 52, 78); // Bàn phím & TouchPad - Bàn phím số
        seedDataVariantAtribute("LED", 53, 78); // Bàn phím & TouchPad - Đèn bàn phím
        seedDataVariantAtribute("Đơn sắc", 54, 78); // Bàn phím & TouchPad - Công nghệ đèn bàn phím
        seedDataVariantAtribute("Trắng", 55, 78); // Bàn phím & TouchPad - Màu đèn LED
        seedDataVariantAtribute("Multi-touch touchpad", 56, 78); // Bàn phím & TouchPad - TouchPad
        seedDataVariantAtribute("59 Wh", 47, 78); // Thông tin pin & sạc - Dung lượng pin
        seedDataVariantAtribute("65 W", 75, 78); // Thông tin pin & sạc - Power Supply
        seedDataVariantAtribute("Dây cáp sạc", 57, 78); // Phụ kiện trong hộp
        seedDataVariantAtribute("Bút cảm ứng", 57, 78); // Phụ kiện trong hộp
        seedDataVariantAtribute("31.33 x 21.89 x 1.69 cm", 5, 78); // Thiết kế & Trọng lượng - Kích thước
        seedDataVariantAtribute("1.39 kg", 6, 78); // Thiết kế & Trọng lượng - Trọng lượng sản phẩm
        seedDataVariantAtribute("Vỏ máy: Nhôm", 7, 78); // Thiết kế & Trọng lượng - Chất liệu
        seedDataVariantAtribute("Trung Quốc", 1, 78); // Thông tin hàng hóa - Xuất xứ
        seedDataVariantAtribute("06/2024", 2, 78); // Thông tin hàng hóa - Thời điểm ra mắt
        seedDataVariantAtribute("12", 4, 78); // Thông tin hàng hóa - Thời gian bảo hành (tháng)
        seedDataVariantAtribute("Xanh", 3, 78); // Thông tin hàng hóa - Màu sắc

        // Laptop HP Gaming Victus 16-s0078AX R5-7640HS/16GB/512GB/16.1"FHD/Nvidia RTX3050 6GB/Win11

        seedDataVariant("Laptop HP Gaming Victus 16-s0078AX R5-7640HS/16GB/512GB", 20999900.0, 7, 29);
        seedDataVariantAtribute("AMD", 9, 79); // Bộ xử lý - Hãng CPU
        seedDataVariantAtribute("Ryzen 5", 61, 79); // Bộ xử lý - Công nghệ CPU
        seedDataVariantAtribute("7640HS", 10, 79); // Bộ xử lý - Loại CPU
        seedDataVariantAtribute("4.30 GHz", 12, 79); // Bộ xử lý - Tốc độ CPU tối thiểu
        seedDataVariantAtribute("NVIDIA", 83, 79); // Đồ họa - Hãng (Card rời)
        seedDataVariantAtribute("GeForce RTX 3050", 84, 79); // Đồ họa - Model (Card rời)
        seedDataVariantAtribute("6 GB", 77, 79); // Đồ họa - Bộ nhớ
        seedDataVariantAtribute("143", 85, 79); // Đồ họa - Hiệu suất AI (TOPS)
        seedDataVariantAtribute("16 GB", 79, 79); // RAM - Dung lượng RAM
        seedDataVariantAtribute("DDR5", 66, 79); // RAM - Loại RAM
        seedDataVariantAtribute("2", 67, 79); // RAM - Số khe cắm rời
        seedDataVariantAtribute("1", 72, 79); // RAM - Số khe RAM còn lại
        seedDataVariantAtribute("32 GB", 68, 79); // RAM - Hỗ trợ RAM tối đa
        seedDataVariantAtribute("SSD", 70, 79); // Lưu trữ - Kiểu ổ cứng
        seedDataVariantAtribute("M.2 NVMe", 73, 79); // Lưu trữ - Loại SSD
        seedDataVariantAtribute("512 GB", 23, 79); // Lưu trữ - Dung lượng
        seedDataVariantAtribute("16.0 inch", 14, 79); // Màn hình - Kích thước màn hình
        seedDataVariantAtribute("Anti-glare LED UWVA", 15, 79); // Màn hình - Công nghệ màn hình
        seedDataVariantAtribute("1920 x 1080 Pixels", 17, 79); // Màn hình - Độ phân giải
        seedDataVariantAtribute("LCD", 19, 79); // Màn hình - Loại màn hình
        seedDataVariantAtribute("144 Hz", 22, 79); // Màn hình - Tần số quét
        seedDataVariantAtribute("WVA", 73, 79); // Màn hình - Tấm nền
        seedDataVariantAtribute("USB", 41, 79); // Giao tiếp và kết nối - Cổng giao tiếp
        seedDataVariantAtribute("Wifi 6E", 42, 79); // Giao tiếp và kết nối - Wifi
        seedDataVariantAtribute("v5.3", 44, 79); // Giao tiếp và kết nối - Bluetooth
        seedDataVariantAtribute("Full HD Webcam (1080p Webcam)", 74, 79); // Giao tiếp và kết nối - Webcam
        seedDataVariantAtribute("Windows", 49, 79); // Hệ điều hành - OS
        seedDataVariantAtribute("Windows 11 Home", 50, 79); // Hệ điều hành - Version
        seedDataVariantAtribute("Mở khóa bằng mật mã", 37, 79); // Bảo mật - Bảo mật
        seedDataVariantAtribute("Chiclet Keyboard", 51, 79); // Bàn phím & TouchPad - Kiểu bàn phím
        seedDataVariantAtribute("Có", 52, 79); // Bàn phím & TouchPad - Bàn phím số
        seedDataVariantAtribute("Không", 53, 79); // Bàn phím & TouchPad - Đèn bàn phím
        seedDataVariantAtribute("Multi-touch touchpad", 56, 79); // Bàn phím & TouchPad - TouchPad
        seedDataVariantAtribute("4 Cell", 47, 79); // Thông tin pin & sạc - Dung lượng pin
        seedDataVariantAtribute("Sạc", 57, 79); // Phụ kiện trong hộp
        seedDataVariantAtribute("36.9 x 25.94 x 2.29 cm", 5, 79); // Thiết kế & Trọng lượng - Kích thước
        seedDataVariantAtribute("2.31 kg", 6, 79); // Thiết kế & Trọng lượng - Trọng lượng sản phẩm
        seedDataVariantAtribute("Nhựa", 7, 79); // Thiết kế & Trọng lượng - Chất liệu
        seedDataVariantAtribute("Trung Quốc", 1, 79); // Thông tin hàng hóa - Xuất xứ
        seedDataVariantAtribute("2023", 2, 79); // Thông tin hàng hóa - Thời điểm ra mắt
        seedDataVariantAtribute("12", 4, 79); // Thông tin hàng hóa - Thời gian bảo hành (tháng)
        seedDataVariantAtribute("Để nơi khô ráo, nhẹ tay, dễ vỡ. & Xem trong sách hướng dẫn sử dụng", 48, 79); // Thông tin Pin và Sạc - Hướng dẫn bảo quản
        seedDataVariantAtribute("Đen", 3, 79); // Thông tin hàng hóa - Màu sắc

        // Laptop HP ProBook 440 G10 i7-1360P/16GB/512GB/14" FHD Touch/Intel Graphics/Win11_Bạc_9H8V2PT
        seedDataVariant("Laptop HP ProBook 440 G10 i7-1360P/16GB/512GB", 25999900.0, 8, 29);
        seedDataVariantAtribute("Intel", 9, 80); // Bộ xử lý - Hãng CPU
        seedDataVariantAtribute("Core i7", 61, 80); // Bộ xử lý - Công nghệ CPU
        seedDataVariantAtribute("1360P", 10, 80); // Bộ xử lý - Loại CPU
        seedDataVariantAtribute("2.2", 12, 80); // Bộ xử lý - Tốc độ CPU tối thiểu
        seedDataVariantAtribute("Intel", 63, 80); // Đồ họa - Hãng (Card Oboard)
        seedDataVariantAtribute("Iris Xe", 64, 80); // Đồ họa - Model (Card Oboard)
        seedDataVariantAtribute("Intel Iris Xe Graphics", 65, 80); // Đồ họa - Tên đầy đủ (Card onboard)
        seedDataVariantAtribute("16 GB (1 thanh 16 GB)", 79, 80); // RAM - Dung lượng RAM
        seedDataVariantAtribute("DDR4", 66, 80); // RAM - Loại RAM
        seedDataVariantAtribute("2", 67, 80); // RAM - Số khe cắm rời
        seedDataVariantAtribute("1", 72, 80); // RAM - Số khe RAM còn lại
        seedDataVariantAtribute("64 GB", 68, 80); // RAM - Hỗ trợ RAM tối đa
        seedDataVariantAtribute("SSD", 70, 80); // Lưu trữ - Kiểu ổ cứng
        seedDataVariantAtribute("1", 71, 80); // Lưu trữ - Tổng số khe cắm SSD/HDD
        seedDataVariantAtribute("0", 72, 80); // Lưu trữ - Số khe SSD/HDD còn lại
        seedDataVariantAtribute("Nâng cấp tối đa 2TB (SSD M2 PCIe)", 73, 80); // Lưu trữ - Dung lượng nâng cấp tối đa ổ cứng
        seedDataVariantAtribute("1 M.2 NVMe", 73, 80); // Lưu trữ - Loại SSD
        seedDataVariantAtribute("512", 23, 80); // Lưu trữ - Dung lượng
        seedDataVariantAtribute("14 inch", 14, 80); // Màn hình - Kích thước màn hình
        seedDataVariantAtribute("Anti-Glare", 15, 80); // Màn hình - Công nghệ màn hình
        seedDataVariantAtribute("1920 x 1080 Pixels", 17, 80); // Màn hình - Độ phân giải
        seedDataVariantAtribute("LED", 19, 80); // Màn hình - Loại màn hình
        seedDataVariantAtribute("60", 22, 80); // Màn hình - Tần số quét
        seedDataVariantAtribute("IPS", 73, 80); // Màn hình - Tấm nền
        seedDataVariantAtribute("45% NTSC", 78, 80); // Màn hình - Độ phủ màu
        seedDataVariantAtribute("16:09", 81, 80); // Màn hình - Tỷ lệ màn hình
        seedDataVariantAtribute("Cổng sạc, 2 USB Type-A, 2 USB Type-C, 1 HDMI 2.1, 1 RJ45 Gigabit Ethernet, 1 AC, 1 headphone/microphone combo", 41, 80); // Giao tiếp và kết nối - Cổng giao tiếp
        seedDataVariantAtribute("802.11 ax", 42, 80); // Giao tiếp và kết nối - Wifi
        seedDataVariantAtribute("v5.3", 44, 80); // Giao tiếp và kết nối - Bluetooth
        seedDataVariantAtribute("720P HD camera", 74, 80); // Giao tiếp và kết nối - Webcam
        seedDataVariantAtribute("Windows", 49, 80); // Hệ điều hành - OS
        seedDataVariantAtribute("Windows 11 Home Single Language", 50, 80); // Hệ điều hành - Version
        seedDataVariantAtribute("Mật khẩu", 37, 80); // Bảo mật - Bảo mật
        seedDataVariantAtribute("6-row, multimedia Fn keys, numeric keypad", 51, 80); // Bàn phím & TouchPad - Kiểu bàn phím
        seedDataVariantAtribute("Không", 52, 80); // Bàn phím & TouchPad - Bàn phím số
        seedDataVariantAtribute("LED", 53, 80); // Bàn phím & TouchPad - Đèn bàn phím
        seedDataVariantAtribute("Đơn sắc", 54, 80); // Bàn phím & TouchPad - Công nghệ đèn bàn phím
        seedDataVariantAtribute("Trắng", 55, 80); // Bàn phím & TouchPad - Màu đèn LED
        seedDataVariantAtribute("Multi-touch touchpad", 56, 80); // Bàn phím & TouchPad - TouchPad
        seedDataVariantAtribute("51 WHrs", 47, 80); // Thông tin pin & sạc - Dung lượng pin
        seedDataVariantAtribute("65 W", 75, 80); // Thông tin pin & sạc - Power Supply
        seedDataVariantAtribute("Dây cáp sạc", 57, 80); // Phụ kiện trong hộp
        seedDataVariantAtribute("32.19 x 21.39 x 1.99 cm", 5, 80); // Thiết kế & Trọng lượng - Kích thước
        seedDataVariantAtribute("1.38 kg", 6, 80); // Thiết kế & Trọng lượng - Trọng lượng sản phẩm
        seedDataVariantAtribute("Vỏ máy: Nhôm", 7, 80); // Thiết kế & Trọng lượng - Chất liệu
        seedDataVariantAtribute("Trung Quốc", 1, 80); // Thông tin hàng hóa - Xuất xứ
        seedDataVariantAtribute("2024", 2, 80); // Thông tin hàng hóa - Thời điểm ra mắt
        seedDataVariantAtribute("12", 4, 80); // Thông tin hàng hóa - Thời gian bảo hành (tháng)
        seedDataVariantAtribute("Bạc", 3, 80); // Thông tin hàng hóa - Màu sắc

        // Laptop MSI
        seedDataProduct("Laptop MSI", "Laptop", 1.8, 12, 2, 2, "");
        // Laptop MSI Gaming Katana 15 B13UDXK-2213VN i5 13500H/16GB/1TB/15.6FHD/RTX3050 6GB/Win11_Balo

        seedDataVariant("Laptop MSI Gaming Katana 15 B13UDXK-2213VN i5 13500H/16GB/1TB", 21999900.0, 8, 30);
        seedDataVariantAtribute("Intel", 9, 81); // Bộ xử lý - Hãng CPU
        seedDataVariantAtribute("Core i5", 61, 81); // Bộ xử lý - Công nghệ CPU
        seedDataVariantAtribute("13500H", 10, 81); // Bộ xử lý - Loại CPU
        seedDataVariantAtribute("4.7 GHz", 12, 81); // Bộ xử lý - Tốc độ tối đa
        seedDataVariantAtribute("12", 11, 81); // Bộ xử lý - Số nhân
        seedDataVariantAtribute("16", 12, 81); // Bộ xử lý - Số luồng
        seedDataVariantAtribute("18 MB", 85, 81); // Bộ xử lý - Bộ nhớ đệm
        seedDataVariantAtribute("NVIDIA", 83, 81); // Đồ họa - Hãng (Card rời)
        seedDataVariantAtribute("GeForce RTX 3050", 84, 81); // Đồ họa - Model (Card rời)
        seedDataVariantAtribute("NVIDIA GeForce RTX 3050 6GB", 65, 81); // Đồ họa - Tên đầy đủ (Card rời)
        seedDataVariantAtribute("6 GB GDDR6", 77, 81); // Đồ họa - Bộ nhớ
        seedDataVariantAtribute("143", 85, 81); // Đồ họa - Hiệu suất AI (TOPS)
        seedDataVariantAtribute("16 GB (2 thanh 8 GB)", 79, 81); // RAM - Dung lượng RAM
        seedDataVariantAtribute("DDR5", 66, 81); // RAM - Loại RAM
        seedDataVariantAtribute("5600 MHz", 67, 81); // RAM - Tốc độ RAM
        seedDataVariantAtribute("2", 67, 81); // RAM - Số khe cắm rời
        seedDataVariantAtribute("64 GB", 68, 81); // RAM - Hỗ trợ RAM tối đa
        seedDataVariantAtribute("SSD", 70, 81); // Lưu trữ - Kiểu ổ cứng
        seedDataVariantAtribute("2", 71, 81); // Lưu trữ - Tổng số khe cắm SSD/HDD
        seedDataVariantAtribute("1 SSD", 72, 81); // Lưu trữ - Số khe SSD/HDD còn lại
        seedDataVariantAtribute("1 M2. PCIe", 73, 81); // Lưu trữ - Loại SSD
        seedDataVariantAtribute("1", 23, 81); // Lưu trữ - Dung lượng
        seedDataVariantAtribute("15.6 inch", 14, 81); // Màn hình - Kích thước màn hình
        seedDataVariantAtribute("Anti-Glare LED-Backlit Display", 15, 81); // Màn hình - Công nghệ màn hình
        seedDataVariantAtribute("1920 x 1080 Pixels", 17, 81); // Màn hình - Độ phân giải
        seedDataVariantAtribute("144", 22, 81); // Màn hình - Tần số quét
        seedDataVariantAtribute("IPS", 73, 81); // Màn hình - Tấm nền
        seedDataVariantAtribute("45% NTSC", 78, 81); // Màn hình - Độ phủ màu
        seedDataVariantAtribute("16:09", 81, 81); // Màn hình - Tỷ lệ màn hình
        seedDataVariantAtribute("1 USB 3.2 Gen 1 Type-C, 2 USB 3.2 Gen 1 Type-A, 1 HDMI 2.1, 1 RJ45 Gigabit Ethernet, 1 USB 2.0", 41, 81); // Giao tiếp và kết nối - Cổng giao tiếp
        seedDataVariantAtribute("Wifi 6E", 42, 81); // Giao tiếp và kết nối - Wifi
        seedDataVariantAtribute("v5.2", 44, 81); // Giao tiếp và kết nối - Bluetooth
        seedDataVariantAtribute("HD Webcam (720p Webcam)", 74, 81); // Giao tiếp và kết nối - Webcam
        seedDataVariantAtribute("Windows", 49, 81); // Hệ điều hành - OS
        seedDataVariantAtribute("Windows 11 Home Single Language", 50, 81); // Hệ điều hành - Version
        seedDataVariantAtribute("Mật khẩu", 37, 81); // Bảo mật - Bảo mật
        seedDataVariantAtribute("Per-Key RGB Gaming Keyboard", 51, 81); // Bàn phím & TouchPad - Kiểu bàn phím
        seedDataVariantAtribute("Có", 52, 81); // Bàn phím & TouchPad - Bàn phím số
        seedDataVariantAtribute("LED", 53, 81); // Bàn phím & TouchPad - Đèn bàn phím
        seedDataVariantAtribute("RGB 4 Zone", 54, 81); // Bàn phím & TouchPad - Công nghệ đèn bàn phím
        seedDataVariantAtribute("Multi-touch touchpad", 56, 81); // Bàn phím & TouchPad - TouchPad
        seedDataVariantAtribute("Lithium polymer", 46, 81); // Thông tin pin & sạc - Loại PIN
        seedDataVariantAtribute("53.5 Whr", 47, 81); // Thông tin pin & sạc - Dung lượng pin
        seedDataVariantAtribute("180 W", 75, 81); // Thông tin pin & sạc - Power Supply
        seedDataVariantAtribute("Bộ sạc điện, Balo", 57, 81); // Phụ kiện trong hộp
        seedDataVariantAtribute("359 x 259 x 24.9 mm", 5, 81); // Thiết kế & Trọng lượng - Kích thước
        seedDataVariantAtribute("2.3 kg", 6, 81); // Thiết kế & Trọng lượng - Trọng lượng sản phẩm
        seedDataVariantAtribute("2 quạt", 82, 81); // Thiết kế & Trọng lượng - Tản nhiệt
        seedDataVariantAtribute("Hợp chất nhựa", 7, 81); // Thiết kế & Trọng lượng - Chất liệu
        seedDataVariantAtribute("Trung Quốc", 1, 81); // Thông tin hàng hóa - Xuất xứ
        seedDataVariantAtribute("01/2024", 2, 81); // Thông tin hàng hóa - Thời điểm ra mắt
        seedDataVariantAtribute("24", 4, 81); // Thông tin hàng hóa - Thời gian bảo hành (tháng)
        seedDataVariantAtribute("Để nơi khô ráo, nhẹ tay, dễ vỡ. Xem trong sách hướng dẫn sử dụng", 48, 81); // Thông tin Pin và Sạc - Hướng dẫn bảo quản và sử dụng
        seedDataVariantAtribute("Đen", 3, 81); // Thông tin hàng hóa - Màu sắc

        // Laptop MSI Gaming Cyborg 14 A13UDX-099VN i7-13620H/16GB/512GB/14" FHD/RTX3050 6GB/W11_Balo
        seedDataVariant("Laptop MSI Gaming Cyborg 14 A13UDX-099VN i7-13620H/16GB/512GB", 25599900.0, 8, 30);
        seedDataVariantAtribute("Intel", 9, 82); // Bộ xử lý - Hãng CPU
        seedDataVariantAtribute("Core i7", 61, 82); // Bộ xử lý - Công nghệ CPU
        seedDataVariantAtribute("13620H", 10, 82); // Bộ xử lý - Loại CPU
        seedDataVariantAtribute("1.8", 12, 82); // Bộ xử lý - Tốc độ CPU tối thiểu
        seedDataVariantAtribute("4.9 GHz", 12, 82); // Bộ xử lý - Tốc độ tối đa
        seedDataVariantAtribute("10", 11, 82); // Bộ xử lý - Số nhân
        seedDataVariantAtribute("16", 12, 82); // Bộ xử lý - Số luồng
        seedDataVariantAtribute("NVIDIA", 83, 82); // Đồ họa - Hãng (Card rời)
        seedDataVariantAtribute("GeForce RTX 3050", 84, 82); // Đồ họa - Model (Card rời)
        seedDataVariantAtribute("NVIDIA GeForce RTX 3050 6GB", 65, 82); // Đồ họa - Tên đầy đủ (Card rời)
        seedDataVariantAtribute("6 GB GDDR6", 77, 82); // Đồ họa - Bộ nhớ
        seedDataVariantAtribute("143", 85, 82); // Đồ họa - Hiệu suất AI (TOPS)
        seedDataVariantAtribute("16 GB (2 thanh 8 GB)", 79, 82); // RAM - Dung lượng RAM
        seedDataVariantAtribute("DDR5", 66, 82); // RAM - Loại RAM
        seedDataVariantAtribute("5600 MHz", 67, 82); // RAM - Tốc độ RAM
        seedDataVariantAtribute("2", 67, 82); // RAM - Số khe cắm rời
        seedDataVariantAtribute("96 GB", 68, 82); // RAM - Hỗ trợ RAM tối đa
        seedDataVariantAtribute("SSD", 70, 82); // Lưu trữ - Kiểu ổ cứng
        seedDataVariantAtribute("1", 71, 82); // Lưu trữ - Tổng số khe cắm SSD/HDD
        seedDataVariantAtribute("1 M2. PCIe", 73, 82); // Lưu trữ - Loại SSD
        seedDataVariantAtribute("512", 23, 82); // Lưu trữ - Dung lượng
        seedDataVariantAtribute("14 inch", 14, 82); // Màn hình - Kích thước màn hình
        seedDataVariantAtribute("Anti-Glare LED-Backlit Display", 15, 82); // Màn hình - Công nghệ màn hình
        seedDataVariantAtribute("1920 x 1200 Pixels", 17, 82); // Màn hình - Độ phân giải
        seedDataVariantAtribute("LED", 19, 82); // Màn hình - Loại màn hình
        seedDataVariantAtribute("144", 22, 82); // Màn hình - Tần số quét
        seedDataVariantAtribute("IPS", 73, 82); // Màn hình - Tấm nền
        seedDataVariantAtribute("100% sRGB", 78, 82); // Màn hình - Độ phủ màu
        seedDataVariantAtribute("16:10", 81, 82); // Màn hình - Tỷ lệ màn hình
        seedDataVariantAtribute("1 Type C, 2 USB 3.2 Gen 1 Type-A, 1 HDMI 2.1, 1 RJ45 Gigabit Ethernet", 41, 82); // Giao tiếp và kết nối - Cổng giao tiếp
        seedDataVariantAtribute("Wifi 6E", 42, 82); // Giao tiếp và kết nối - Wifi
        seedDataVariantAtribute("v5.2", 44, 82); // Giao tiếp và kết nối - Bluetooth
        seedDataVariantAtribute("HD Webcam (720p Webcam)", 74, 82); // Giao tiếp và kết nối - Webcam
        seedDataVariantAtribute("Nahimic Audio", 82, 82); // Âm Thanh - Công nghệ âm thanh
        seedDataVariantAtribute("Windows", 49, 82); // Hệ điều hành - OS
        seedDataVariantAtribute("Windows 11 Home Single Language", 50, 82); // Hệ điều hành - Version
        seedDataVariantAtribute("Mật khẩu", 37, 82); // Bảo mật - Bảo mật
        seedDataVariantAtribute("6-row, multimedia Fn keys", 51, 82); // Bàn phím & TouchPad - Kiểu bàn phím
        seedDataVariantAtribute("Không", 52, 82); // Bàn phím & TouchPad - Bàn phím số
        seedDataVariantAtribute("LED", 53, 82); // Bàn phím & TouchPad - Đèn bàn phím
        seedDataVariantAtribute("Đơn sắc", 54, 82); // Bàn phím & TouchPad - Công nghệ đèn bàn phím
        seedDataVariantAtribute("Xanh", 55, 82); // Bàn phím & TouchPad - Màu đèn LED
        seedDataVariantAtribute("Multi-touch touchpad", 56, 82); // Bàn phím & TouchPad - TouchPad
        seedDataVariantAtribute("53.5 Wh", 47, 82); // Thông tin pin & sạc - Dung lượng pin
        seedDataVariantAtribute("120 W", 75, 82); // Thông tin pin & sạc - Power Supply
        seedDataVariantAtribute("Bộ sạc điện, Balo", 57, 82); // Phụ kiện trong hộp
        seedDataVariantAtribute("2", 57, 82); // Thông số cơ bản - Số lượng loa
        seedDataVariantAtribute("314.7 x 233.5 x 18.6-22.3 mm", 5, 82); // Thiết kế & Trọng lượng - Kích thước
        seedDataVariantAtribute("1.6 kg", 6, 82); // Thiết kế & Trọng lượng - Trọng lượng sản phẩm
        seedDataVariantAtribute("Hợp chất nhựa", 7, 82); // Thiết kế & Trọng lượng - Chất liệu
        seedDataVariantAtribute("Trung Quốc", 1, 82); // Thông tin hàng hóa - Xuất xứ
        seedDataVariantAtribute("01/2024", 2, 82); // Thông tin hàng hóa - Thời điểm ra mắt
        seedDataVariantAtribute("24", 4, 82); // Thông tin hàng hóa - Thời gian bảo hành (tháng)
        seedDataVariantAtribute("Để nơi khô ráo, nhẹ tay, dễ vỡ. Xem trong sách hướng dẫn sử dụng", 48, 82); // Thông tin Pin và Sạc - Hướng dẫn bảo quản và sử dụng
        seedDataVariantAtribute("Đen", 3, 82); // Thông tin hàng hóa - Màu sắc


        // Laptop MSI Gaming Katana 15 B13VFK-676VN i7 13620H/AI/16GB/1TB/Geforce RTX 4060 8GB/15.6"FHD/Win11_Balo
        seedDataVariant("Laptop MSI Gaming Katana 15 B13VFK-676VN i7 13620H/AI/16GB/1TB", 29999900.0, 8, 30);
        seedDataVariantAtribute("Intel", 9, 83); // Bộ xử lý - Hãng CPU
        seedDataVariantAtribute("Core i7", 61, 83); // Bộ xử lý - Công nghệ CPU
        seedDataVariantAtribute("13620H", 10, 83); // Bộ xử lý - Loại CPU
        seedDataVariantAtribute("4.9 GHz", 12, 83); // Bộ xử lý - Tốc độ tối đa
        seedDataVariantAtribute("10", 11, 83); // Bộ xử lý - Số nhân
        seedDataVariantAtribute("16", 12, 83); // Bộ xử lý - Số luồng
        seedDataVariantAtribute("24 MB", 85, 83); // Bộ xử lý - Bộ nhớ đệm
        seedDataVariantAtribute("Intel", 63, 83); // Đồ họa - Hãng (Card Oboard)
        seedDataVariantAtribute("Intel UHD Graphics", 65, 83); // Đồ họa - Tên đầy đủ (Card onboard)
        seedDataVariantAtribute("NVIDIA", 83, 83); // Đồ họa - Hãng (Card rời)
        seedDataVariantAtribute("GeForce RTX 4060", 84, 83); // Đồ họa - Model (Card rời)
        seedDataVariantAtribute("NVIDIA GeForce RTX 4060 8GB", 65, 83); // Đồ họa - Tên đầy đủ (Card rời)
        seedDataVariantAtribute("8 GB GDDR6", 77, 83); // Đồ họa - Bộ nhớ
        seedDataVariantAtribute("233", 85, 83); // Đồ họa - Hiệu suất AI (TOPS)
        seedDataVariantAtribute("16 GB (2 thanh 8 GB)", 79, 83); // RAM - Dung lượng RAM
        seedDataVariantAtribute("DDR5", 66, 83); // RAM - Loại RAM
        seedDataVariantAtribute("5200 MHz", 67, 83); // RAM - Tốc độ RAM
        seedDataVariantAtribute("2", 67, 83); // RAM - Số khe cắm rời
        seedDataVariantAtribute("64 GB", 68, 83); // RAM - Hỗ trợ RAM tối đa
        seedDataVariantAtribute("SSD", 70, 83); // Lưu trữ - Kiểu ổ cứng
        seedDataVariantAtribute("2 x SSD M2 PCIe", 71, 83); // Lưu trữ - Tổng số khe cắm SSD/HDD
        seedDataVariantAtribute("1 SSD", 72, 83); // Lưu trữ - Số khe SSD/HDD còn lại
        seedDataVariantAtribute("M2. PCIe", 73, 83); // Lưu trữ - Loại SSD
        seedDataVariantAtribute("1 TB", 23, 83); // Lưu trữ - Dung lượng
        seedDataVariantAtribute("15.6 inch", 14, 83); // Màn hình - Kích thước màn hình
        seedDataVariantAtribute("IPS", 15, 83); // Màn hình - Công nghệ màn hình
        seedDataVariantAtribute("1920 x 1080 Pixels", 17, 83); // Màn hình - Độ phân giải
        seedDataVariantAtribute("Màn hình phẳng", 19, 83); // Màn hình - Loại màn hình
        seedDataVariantAtribute("144 Hz", 22, 83); // Màn hình - Tần số quét
        seedDataVariantAtribute("IPS", 73, 83); // Màn hình - Tấm nền
        seedDataVariantAtribute("60 - 65% sRGB", 78, 83); // Màn hình - Độ phủ màu
        seedDataVariantAtribute("1 LAN, 1 HDMI 2.1, 2 USB 3.2 Gen 1, 1 Type C, 1 USB 2.0", 41, 83); // Giao tiếp và kết nối - Cổng giao tiếp
        seedDataVariantAtribute("Wifi 6 AX201", 42, 83); // Giao tiếp và kết nối - Wifi
        seedDataVariantAtribute("v5.2", 44, 83); // Giao tiếp và kết nối - Bluetooth
        seedDataVariantAtribute("HD Webcam (720p Webcam)", 74, 83); // Giao tiếp và kết nối - Webcam
        seedDataVariantAtribute("Windows", 49, 83); // Hệ điều hành - OS
        seedDataVariantAtribute("Windows 11 Home", 50, 83); // Hệ điều hành - Version
        seedDataVariantAtribute("64 bit", 50, 83); // Hệ điều hành - Type
        seedDataVariantAtribute("Mật khẩu", 37, 83); // Bảo mật - Bảo mật
        seedDataVariantAtribute("English International Backlit Keyboard", 51, 83); // Bàn phím & TouchPad - Kiểu bàn phím
        seedDataVariantAtribute("Có", 52, 83); // Bàn phím & TouchPad - Bàn phím số
        seedDataVariantAtribute("LED", 53, 83); // Bàn phím & TouchPad - Đèn bàn phím
        seedDataVariantAtribute("RGB 4 Zone", 54, 83); // Bàn phím & TouchPad - Công nghệ đèn bàn phím
        seedDataVariantAtribute("RGB 4 Zone", 55, 83); // Bàn phím & TouchPad - Màu đèn LED
        seedDataVariantAtribute("Multi-touch touchpad", 56, 83); // Bàn phím & TouchPad - TouchPad
        seedDataVariantAtribute("53.5 Wh", 47, 83); // Thông tin pin & sạc - Dung lượng pin
        seedDataVariantAtribute("200 W", 75, 83); // Thông tin pin & sạc - Power Supply
        seedDataVariantAtribute("Sách HDSD, Bộ sạc điện, Balo", 57, 83); // Phụ kiện trong hộp
        seedDataVariantAtribute("2", 57, 83); // Thông số cơ bản - Số lượng loa
        seedDataVariantAtribute("359 x 259 x 24.9 mm", 5, 83); // Thiết kế & Trọng lượng - Kích thước
        seedDataVariantAtribute("2.25 kg", 6, 83); // Thiết kế & Trọng lượng - Trọng lượng sản phẩm
        seedDataVariantAtribute("Hợp chất nhựa", 7, 83); // Thiết kế & Trọng lượng - Chất liệu
        seedDataVariantAtribute("Trung Quốc", 1, 83); // Thông tin hàng hóa - Xuất xứ
        seedDataVariantAtribute("2023", 2, 83); // Thông tin hàng hóa - Thời điểm ra mắt
        seedDataVariantAtribute("24", 4, 83); // Thông tin hàng hóa - Thời gian bảo hành (tháng)
        seedDataVariantAtribute("Để nơi khô ráo, nhẹ tay, dễ vỡ. Xem trong sách hướng dẫn sử dụng", 48, 83); // Thông tin Pin và Sạc - Hướng dẫn bảo quản và sử dụng
        seedDataVariantAtribute("Đen", 3, 83); // Thông tin hàng hóa - Màu sắc


        // Laptop MSI Gaming Thin 15 B13UCX-2080VN i5 13420H/16GB/512GB/15.6" FHD/RTX 2050 4GB/Win 11_Balo
        seedDataVariant("Laptop MSI Gaming Thin 15 B13UCX-2080VN i5 13420H/16GB/512GB", 18699900.0, 8, 30);
        seedDataVariantAtribute("Intel", 9, 84); // Bộ xử lý - Hãng CPU
        seedDataVariantAtribute("Core i5", 61, 84); // Bộ xử lý - Công nghệ CPU
        seedDataVariantAtribute("13420H", 10, 84); // Bộ xử lý - Loại CPU
        seedDataVariantAtribute("1.5", 11, 84); // Bộ xử lý - Tốc độ CPU tối thiểu
        seedDataVariantAtribute("4.6 GHz", 12, 84); // Bộ xử lý - Tốc độ tối đa
        seedDataVariantAtribute("8", 11, 84); // Bộ xử lý - Số nhân
        seedDataVariantAtribute("12", 11, 84); // Bộ xử lý - Số luồng
        seedDataVariantAtribute("12 MB", 85, 84); // Bộ xử lý - Bộ nhớ đệm
        seedDataVariantAtribute("NVIDIA", 83, 84); // Đồ họa - Hãng (Card rời)
        seedDataVariantAtribute("Geforce RTX 2050", 84, 84); // Đồ họa - Model (Card rời)
        seedDataVariantAtribute("NVIDIA Geforce RTX 2050 4GB", 65, 84); // Đồ họa - Tên đầy đủ (Card rời)
        seedDataVariantAtribute("4 GB GDDR6", 77, 84); // Đồ họa - Bộ nhớ
        seedDataVariantAtribute("104", 85, 84); // Đồ họa - Hiệu suất AI (TOPS)
        seedDataVariantAtribute("16 GB (2 thanh 8 GB)", 79, 84); // RAM - Dung lượng RAM
        seedDataVariantAtribute("DDR4", 66, 84); // RAM - Loại RAM
        seedDataVariantAtribute("2", 67, 84); // RAM - Số khe cắm rời
        seedDataVariantAtribute("64 GB", 68, 84); // RAM - Hỗ trợ RAM tối đa
        seedDataVariantAtribute("SSD", 70, 84); // Lưu trữ - Kiểu ổ cứng
        seedDataVariantAtribute("1 M.2 NVMe", 73, 84); // Lưu trữ - Loại SSD
        seedDataVariantAtribute("512", 23, 84); // Lưu trữ - Dung lượng
        seedDataVariantAtribute("15.6 inch", 14, 84); // Màn hình - Kích thước màn hình
        seedDataVariantAtribute("Anti-Glare LED-Backlit Display", 15, 84); // Màn hình - Công nghệ màn hình
        seedDataVariantAtribute("1920 x 1080 Pixels", 17, 84); // Màn hình - Độ phân giải
        seedDataVariantAtribute("LED", 19, 84); // Màn hình - Loại màn hình
        seedDataVariantAtribute("144", 22, 84); // Màn hình - Tần số quét
        seedDataVariantAtribute("IPS", 73, 84); // Màn hình - Tấm nền
        seedDataVariantAtribute("45% NTSC", 78, 84); // Màn hình - Độ phủ màu
        seedDataVariantAtribute("1 USB 3.2 Gen 1 Type-C, 3 USB 3.2 Gen 1 Type-A, 1 HDMI, 1 RJ45 Gigabit Ethernet", 41, 84); // Giao tiếp và kết nối - Cổng giao tiếp
        seedDataVariantAtribute("Wifi 6E", 42, 84); // Giao tiếp và kết nối - Wifi
        seedDataVariantAtribute("v5.3", 44, 84); // Giao tiếp và kết nối - Bluetooth
        seedDataVariantAtribute("HD Webcam (720p Webcam)", 74, 84); // Giao tiếp và kết nối - Webcam
        seedDataVariantAtribute("Windows", 49, 84); // Hệ điều hành - OS
        seedDataVariantAtribute("Windows 11 Home", 50, 84); // Hệ điều hành - Version
        seedDataVariantAtribute("Mật khẩu", 37, 84); // Bảo mật - Bảo mật
        seedDataVariantAtribute("Single Backlit Keyboard", 51, 84); // Bàn phím & TouchPad - Kiểu bàn phím
        seedDataVariantAtribute("Không", 52, 84); // Bàn phím & TouchPad - Bàn phím số
        seedDataVariantAtribute("LED", 53, 84); // Bàn phím & TouchPad - Đèn bàn phím
        seedDataVariantAtribute("Xanh", 55, 84); // Bàn phím & TouchPad - Màu đèn LED
        seedDataVariantAtribute("Multi-touch touchpad", 56, 84); // Bàn phím & TouchPad - TouchPad
        seedDataVariantAtribute("Lithium-ion", 46, 84); // Thông tin pin & sạc - Loại PIN
        seedDataVariantAtribute("52.4 Wh", 47, 84); // Thông tin pin & sạc - Dung lượng pin
        seedDataVariantAtribute("120 W", 75, 84); // Thông tin pin & sạc - Power Supply
        seedDataVariantAtribute("Bộ sạc điện, Balo", 57, 84); // Phụ kiện trong hộp
        seedDataVariantAtribute("2", 57, 84); // Thông số cơ bản - Số lượng loa
        seedDataVariantAtribute("359 x 254 x 21.7 mm", 5, 84); // Thiết kế & Trọng lượng - Kích thước
        seedDataVariantAtribute("1.86 kg", 6, 84); // Thiết kế & Trọng lượng - Trọng lượng sản phẩm
        seedDataVariantAtribute("Kim loại, Nhựa", 7, 84); // Thiết kế & Trọng lượng - Chất liệu
        seedDataVariantAtribute("Trung Quốc", 1, 84); // Thông tin hàng hóa - Xuất xứ
        seedDataVariantAtribute("01/2024", 2, 84); // Thông tin hàng hóa - Thời điểm ra mắt
        seedDataVariantAtribute("24", 4, 84); // Thông tin hàng hóa - Thời gian bảo hành (tháng)
        seedDataVariantAtribute("Để nơi khô ráo, nhẹ tay, dễ vỡ. Xem trong sách hướng dẫn sử dụng", 48, 84); // Thông tin Pin và Sạc - Hướng dẫn bảo quản và sử dụng
        seedDataVariantAtribute("Xám", 3, 84); // Thông tin hàng hóa - Màu sắc

        // Laptop MSI Gaming Katana15 B13VFK-2099VN i7 13620H/AI/32GB/1TB/15.6"FHD/RTX4060 8GB/W11_Balo
        seedDataVariant("Laptop MSI Gaming Katana15 B13VFK-2099VN i7 13620H/AI/32GB/1TB", 29699900.0, 5, 30);
        seedDataVariantAtribute("Intel", 9, 85); // Bộ xử lý - Hãng CPU
        seedDataVariantAtribute("Core i7", 61, 85); // Bộ xử lý - Công nghệ CPU
        seedDataVariantAtribute("13620H", 10, 85); // Bộ xử lý - Loại CPU
        seedDataVariantAtribute("1.8", 12, 85); // Bộ xử lý - Tốc độ CPU tối thiểu
        seedDataVariantAtribute("4.9 GHz", 12, 85); // Bộ xử lý - Tốc độ tối đa
        seedDataVariantAtribute("10", 11, 85); // Bộ xử lý - Số nhân
        seedDataVariantAtribute("16", 11, 85); // Bộ xử lý - Số luồng
        seedDataVariantAtribute("NVIDIA", 83, 85); // Đồ họa - Hãng (Card rời)
        seedDataVariantAtribute("GeForce RTX 4060", 84, 85); // Đồ họa - Model (Card rời)
        seedDataVariantAtribute("NVIDIA GeForce RTX 4060 8GB", 65, 85); // Đồ họa - Tên đầy đủ (Card rời)
        seedDataVariantAtribute("8 GB GDDR6", 77, 85); // Đồ họa - Bộ nhớ
        seedDataVariantAtribute("233", 85, 85); // Đồ họa - Hiệu suất AI (TOPS)
        seedDataVariantAtribute("32 GB (2 thanh 16 GB)", 79, 85); // RAM - Dung lượng RAM
        seedDataVariantAtribute("DDR5", 66, 85); // RAM - Loại RAM
        seedDataVariantAtribute("5600 MHz", 67, 85); // RAM - Tốc độ RAM
        seedDataVariantAtribute("2", 67, 85); // RAM - Số khe cắm rời
        seedDataVariantAtribute("64 GB", 68, 85); // RAM - Hỗ trợ RAM tối đa
        seedDataVariantAtribute("SSD", 70, 85); // Lưu trữ - Kiểu ổ cứng
        seedDataVariantAtribute("1", 71, 85); // Lưu trữ - Tổng số khe cắm SSD/HDD
        seedDataVariantAtribute("1 M2. PCIe", 73, 85); // Lưu trữ - Loại SSD
        seedDataVariantAtribute("1", 23, 85); // Lưu trữ - Dung lượng
        seedDataVariantAtribute("15.6 inch", 14, 85); // Màn hình - Kích thước màn hình
        seedDataVariantAtribute("Anti-Glare LED-Backlit Display", 15, 85); // Màn hình - Công nghệ màn hình
        seedDataVariantAtribute("1920 x 1080 Pixels", 17, 85); // Màn hình - Độ phân giải
        seedDataVariantAtribute("LED", 19, 85); // Màn hình - Loại màn hình
        seedDataVariantAtribute("144", 22, 85); // Màn hình - Tần số quét
        seedDataVariantAtribute("IPS", 73, 85); // Màn hình - Tấm nền
        seedDataVariantAtribute("45% NTSC", 78, 85); // Màn hình - Độ phủ màu
        seedDataVariantAtribute("1 Type C, 2 USB 3.2 Gen 1 Type-A, 1 USB 2.0, 1 HDMI 2.1, 1 RJ45 Gigabit Ethernet", 41, 85); // Giao tiếp và kết nối - Cổng giao tiếp
        seedDataVariantAtribute("Wifi 6E", 42, 85); // Giao tiếp và kết nối - Wifi
        seedDataVariantAtribute("Bluetooth v5.2", 44, 85); // Giao tiếp và kết nối - Bluetooth
        seedDataVariantAtribute("HD Webcam (720p Webcam)", 74, 85); // Giao tiếp và kết nối - Webcam
        seedDataVariantAtribute("Windows", 49, 85); // Hệ điều hành - OS
        seedDataVariantAtribute("Windows 11 Home Single Language", 50, 85); // Hệ điều hành - Version
        seedDataVariantAtribute("Mật khẩu", 37, 85); // Bảo mật - Bảo mật
        seedDataVariantAtribute("Per-Key RGB Gaming Keyboard", 51, 85); // Bàn phím & TouchPad - Kiểu bàn phím
        seedDataVariantAtribute("Có", 52, 85); // Bàn phím & TouchPad - Bàn phím số
        seedDataVariantAtribute("LED", 53, 85); // Bàn phím & TouchPad - Đèn bàn phím
        seedDataVariantAtribute("RGB 4 Zone", 54, 85); // Bàn phím & TouchPad - Công nghệ đèn bàn phím
        seedDataVariantAtribute("Multi-touch touchpad", 56, 85); // Bàn phím & TouchPad - TouchPad
        seedDataVariantAtribute("53.5 Wh", 47, 85); // Thông tin pin & sạc - Dung lượng pin
        seedDataVariantAtribute("200 W", 75, 85); // Thông tin pin & sạc - Power Supply
        seedDataVariantAtribute("Bộ sạc điện, Balo", 57, 85); // Phụ kiện trong hộp
        seedDataVariantAtribute("2", 57, 85); // Thông số cơ bản - Số lượng loa
        seedDataVariantAtribute("359 x 259 x 24.9 mm", 5, 85); // Thiết kế & Trọng lượng - Kích thước
        seedDataVariantAtribute("2.25 kg", 6, 85); // Thiết kế & Trọng lượng - Trọng lượng sản phẩm
        seedDataVariantAtribute("Hợp chất nhựa", 7, 85); // Thiết kế & Trọng lượng - Chất liệu
        seedDataVariantAtribute("Katana15 B13VFK-2099VN", 1, 85); // Thông tin hàng hóa - P/N
        seedDataVariantAtribute("Trung Quốc", 1, 85); // Thông tin hàng hóa - Xuất xứ
        seedDataVariantAtribute("01/2024", 2, 85); // Thông tin hàng hóa - Thời điểm ra mắt
        seedDataVariantAtribute("24", 4, 85); // Thông tin hàng hóa - Thời gian bảo hành (tháng)
        seedDataVariantAtribute("Để nơi khô ráo, nhẹ tay, dễ vỡ. Xem trong sách hướng dẫn sử dụng", 48, 85); // Thông tin Pin và Sạc - Hướng dẫn bảo quản và sử dụng
        seedDataVariantAtribute("Đen", 3, 85); // Thông tin hàng hóa - Màu sắc

        // Laptop MSI Gaming Katana A15 AI B8VE-402VN R7 8845HS/16GB/512GB/15.6"FHD/RTX4050 6GB/Win 11_Balo
        seedDataVariant("Laptop MSI Gaming Katana A15 AI B8VE-402VN R7 8845HS/16GB/512GB", 26699900.0, 8, 30);
        seedDataVariantAtribute("AMD", 9, 86); // Bộ xử lý - Hãng CPU
        seedDataVariantAtribute("Ryzen 7", 61, 86); // Bộ xử lý - Công nghệ CPU
        seedDataVariantAtribute("8845HS", 10, 86); // Bộ xử lý - Loại CPU
        seedDataVariantAtribute("3.8", 12, 86); // Bộ xử lý - Tốc độ CPU tối thiểu
        seedDataVariantAtribute("5.1 GHz", 12, 86); // Bộ xử lý - Tốc độ tối đa
        seedDataVariantAtribute("8", 11, 86); // Bộ xử lý - Số nhân
        seedDataVariantAtribute("16", 11, 86); // Bộ xử lý - Số luồng
        seedDataVariantAtribute("16 MB", 85, 86); // Bộ xử lý - Bộ nhớ đệm
        seedDataVariantAtribute("NVIDIA", 83, 86); // Đồ họa - Hãng (Card rời)
        seedDataVariantAtribute("GeForce RTX 4050", 84, 86); // Đồ họa - Model (Card rời)
        seedDataVariantAtribute("NVIDIA GeForce RTX 4050 6GB GDDR6", 65, 86); // Đồ họa - Tên đầy đủ (Card rời)
        seedDataVariantAtribute("6 GB GDDR6", 77, 86); // Đồ họa - Bộ nhớ
        seedDataVariantAtribute("16 GB (2 thanh 8 GB)", 79, 86); // RAM - Dung lượng RAM
        seedDataVariantAtribute("DDR5", 66, 86); // RAM - Loại RAM
        seedDataVariantAtribute("5600 MHz", 67, 86); // RAM - Tốc độ RAM
        seedDataVariantAtribute("2", 67, 86); // RAM - Số khe cắm rời
        seedDataVariantAtribute("64 GB", 68, 86); // RAM - Hỗ trợ RAM tối đa
        seedDataVariantAtribute("SSD", 70, 86); // Lưu trữ - Kiểu ổ cứng
        seedDataVariantAtribute("1", 71, 86); // Lưu trữ - Tổng số khe cắm SSD/HDD
        seedDataVariantAtribute("1 M2. PCIe", 73, 86); // Lưu trữ - Loại SSD
        seedDataVariantAtribute("512", 23, 86); // Lưu trữ - Dung lượng
        seedDataVariantAtribute("15.6 inch", 14, 86); // Màn hình - Kích thước màn hình
        seedDataVariantAtribute("Anti-Glare LED-Backlit Display", 15, 86); // Màn hình - Công nghệ màn hình
        seedDataVariantAtribute("1920 x 1080 Pixels", 17, 86); // Màn hình - Độ phân giải
        seedDataVariantAtribute("LED", 19, 86); // Màn hình - Loại màn hình
        seedDataVariantAtribute("144", 22, 86); // Màn hình - Tần số quét
        seedDataVariantAtribute("IPS", 73, 86); // Màn hình - Tấm nền
        seedDataVariantAtribute("16:09", 81, 86); // Màn hình - Tỷ lệ màn hình
        seedDataVariantAtribute("USB 3.2 Gen 2 Type-C, USB 3.2 Gen 1 Type-A, HDMI 2.1, RJ45 Gigabit Ethernet, Jack 3.5 mm", 41, 86); // Giao tiếp và kết nối - Cổng giao tiếp
        seedDataVariantAtribute("Wifi 6E", 42, 86); // Giao tiếp và kết nối - Wifi
        seedDataVariantAtribute("Bluetooth v5.2", 44, 86); // Giao tiếp và kết nối - Bluetooth
        seedDataVariantAtribute("HD Webcam (720p Webcam)", 74, 86); // Giao tiếp và kết nối - Webcam
        seedDataVariantAtribute("Windows", 49, 86); // Hệ điều hành - OS
        seedDataVariantAtribute("Windows 11 Home Single Language", 50, 86); // Hệ điều hành - Version
        seedDataVariantAtribute("64 bit", 50, 86); // Hệ điều hành - Type
        seedDataVariantAtribute("Mật khẩu", 37, 86); // Bảo mật - Bảo mật
        seedDataVariantAtribute("6-row, multimedia Fn keys", 51, 86); // Bàn phím & TouchPad - Kiểu bàn phím
        seedDataVariantAtribute("Có", 52, 86); // Bàn phím & TouchPad - Bàn phím số
        seedDataVariantAtribute("LED", 53, 86); // Bàn phím & TouchPad - Đèn bàn phím
        seedDataVariantAtribute("RGB 4 Zone", 54, 86); // Bàn phím & TouchPad - Công nghệ đèn bàn phím
        seedDataVariantAtribute("RGB", 55, 86); // Bàn phím & TouchPad - Màu đèn LED
        seedDataVariantAtribute("Multi-touch touchpad", 56, 86); // Bàn phím & TouchPad - TouchPad
        seedDataVariantAtribute("Lithium polymer", 46, 86); // Thông tin pin & sạc - Loại PIN
        seedDataVariantAtribute("53.5 Whr", 47, 86); // Thông tin pin & sạc - Dung lượng pin
        seedDataVariantAtribute("200 W", 75, 86); // Thông tin pin & sạc - Power Supply
        seedDataVariantAtribute("Dây nguồn, Balo", 57, 86); // Phụ kiện trong hộp
        seedDataVariantAtribute("2", 57, 86); // Thông số cơ bản - Số lượng loa
        seedDataVariantAtribute("359 x 259 x 24.9 mm", 5, 86); // Thiết kế & Trọng lượng - Kích thước
        seedDataVariantAtribute("2.25 kg", 6, 86); // Thiết kế & Trọng lượng - Trọng lượng sản phẩm
        seedDataVariantAtribute("Hợp chất nhựa", 7, 86); // Thiết kế & Trọng lượng - Chất liệu
        seedDataVariantAtribute("MSI Katana A15 AI B8VE-402VN", 1, 86); // Thông tin hàng hóa - P/N
        seedDataVariantAtribute("Trung Quốc", 1, 86); // Thông tin hàng hóa - Xuất xứ
        seedDataVariantAtribute("01/2024", 2, 86); // Thông tin hàng hóa - Thời điểm ra mắt
        seedDataVariantAtribute("24", 4, 86); // Thông tin hàng hóa - Thời gian bảo hành (tháng)
        seedDataVariantAtribute("Để nơi khô ráo, nhẹ tay, dễ vỡ. Xem trong sách hướng dẫn sử dụng", 48, 86); // Thông tin Pin và Sạc - Hướng dẫn bảo quản và sử dụng
        seedDataVariantAtribute("Đen", 3, 86); // Thông tin hàng hóa - Màu sắc


        seedDataVariant("Laptop MSI Gaming Katana A15 AI B8VE-402VN R7 8845HS/16GB/512GB", 26899900.0, 8, 30);
        seedDataVariantAtribute("AMD", 9, 87); // Bộ xử lý - Hãng CPU
        seedDataVariantAtribute("Ryzen 7", 61, 87); // Bộ xử lý - Công nghệ CPU
        seedDataVariantAtribute("8845HS", 10, 87); // Bộ xử lý - Loại CPU
        seedDataVariantAtribute("3.8", 12, 87); // Bộ xử lý - Tốc độ CPU tối thiểu
        seedDataVariantAtribute("5.1 GHz", 12, 87); // Bộ xử lý - Tốc độ tối đa
        seedDataVariantAtribute("8", 11, 87); // Bộ xử lý - Số nhân
        seedDataVariantAtribute("16", 11, 87); // Bộ xử lý - Số luồng
        seedDataVariantAtribute("16 MB", 85, 87); // Bộ xử lý - Bộ nhớ đệm
        seedDataVariantAtribute("NVIDIA", 83, 87); // Đồ họa - Hãng (Card rời)
        seedDataVariantAtribute("GeForce RTX 4050", 84, 87); // Đồ họa - Model (Card rời)
        seedDataVariantAtribute("NVIDIA GeForce RTX 4050 6GB GDDR6", 65, 87); // Đồ họa - Tên đầy đủ (Card rời)
        seedDataVariantAtribute("6 GB GDDR6", 77, 87); // Đồ họa - Bộ nhớ
        seedDataVariantAtribute("194", 85, 87); // Đồ họa - Hiệu suất AI (TOPS)
        seedDataVariantAtribute("16 GB (2 thanh 8 GB)", 79, 87); // RAM - Dung lượng RAM
        seedDataVariantAtribute("DDR5", 66, 87); // RAM - Loại RAM
        seedDataVariantAtribute("5600 MHz", 67, 87); // RAM - Tốc độ RAM
        seedDataVariantAtribute("2", 67, 87); // RAM - Số khe cắm rời
        seedDataVariantAtribute("64 GB", 68, 87); // RAM - Hỗ trợ RAM tối đa
        seedDataVariantAtribute("SSD", 70, 87); // Lưu trữ - Kiểu ổ cứng
        seedDataVariantAtribute("1", 71, 87); // Lưu trữ - Tổng số khe cắm SSD/HDD
        seedDataVariantAtribute("1 M2. PCIe", 73, 87); // Lưu trữ - Loại SSD
        seedDataVariantAtribute("512", 23, 87); // Lưu trữ - Dung lượng
        seedDataVariantAtribute("15.6 inch", 14, 87); // Màn hình - Kích thước màn hình
        seedDataVariantAtribute("Anti-Glare LED-Backlit Display", 15, 87); // Màn hình - Công nghệ màn hình
        seedDataVariantAtribute("1920 x 1080 Pixels", 17, 87); // Màn hình - Độ phân giải
        seedDataVariantAtribute("LED", 19, 87); // Màn hình - Loại màn hình
        seedDataVariantAtribute("144", 22, 87); // Màn hình - Tần số quét
        seedDataVariantAtribute("IPS", 73, 87); // Màn hình - Tấm nền
        seedDataVariantAtribute("16:09", 81, 87); // Màn hình - Tỷ lệ màn hình
        seedDataVariantAtribute("USB 3.2 Gen 2 Type-C, USB 3.2 Gen 1 Type-A, HDMI 2.1, RJ45 Gigabit Ethernet, Jack 3.5 mm", 41, 87); // Giao tiếp và kết nối - Cổng giao tiếp
        seedDataVariantAtribute("Wifi 6E", 42, 87); // Giao tiếp và kết nối - Wifi
        seedDataVariantAtribute("v5.2", 44, 87); // Giao tiếp và kết nối - Bluetooth
        seedDataVariantAtribute("HD Webcam (720p Webcam)", 74, 87); // Giao tiếp và kết nối - Webcam
        seedDataVariantAtribute("Windows", 49, 87); // Hệ điều hành - OS
        seedDataVariantAtribute("Windows 11 Home Single Language", 50, 87); // Hệ điều hành - Version
        seedDataVariantAtribute("64 bit", 50, 87); // Hệ điều hành - Type
        seedDataVariantAtribute("Mật khẩu", 37, 87); // Bảo mật - Bảo mật
        seedDataVariantAtribute("6-row, multimedia Fn keys", 51, 87); // Bàn phím & TouchPad - Kiểu bàn phím
        seedDataVariantAtribute("Có", 52, 87); // Bàn phím & TouchPad - Bàn phím số
        seedDataVariantAtribute("LED", 53, 87); // Bàn phím & TouchPad - Đèn bàn phím
        seedDataVariantAtribute("RGB 4 Zone", 54, 87); // Bàn phím & TouchPad - Công nghệ đèn bàn phím
        seedDataVariantAtribute("RGB", 55, 87); // Bàn phím & TouchPad - Màu đèn LED
        seedDataVariantAtribute("Multi-touch touchpad", 56, 87); // Bàn phím & TouchPad - TouchPad
        seedDataVariantAtribute("Lithium polymer", 46, 87); // Thông tin pin & sạc - Loại PIN
        seedDataVariantAtribute("53.5 Whr", 47, 87); // Thông tin pin & sạc - Dung lượng pin
        seedDataVariantAtribute("200 W", 75, 87); // Thông tin pin & sạc - Power Supply
        seedDataVariantAtribute("Dây nguồn, Balo", 57, 87); // Phụ kiện trong hộp
        seedDataVariantAtribute("2", 57, 87); // Thông số cơ bản - Số lượng loa
        seedDataVariantAtribute("359 x 259 x 24.9 mm", 5, 87); // Thiết kế & Trọng lượng - Kích thước
        seedDataVariantAtribute("2.25 kg", 6, 87); // Thiết kế & Trọng lượng - Trọng lượng sản phẩ


        seedDataProduct("Laptop Lenovo", "Laptop", 1.8, 9, 2, 2, "");
        // Laptop Lenovo ThinkPad E14 G5 I5 13420H/16GB/512GB/14"WUXGA/Win 11
        seedDataVariant("Laptop Lenovo ThinkPad E14 G5 I5 13420H/16GB/512GB", 20799900.0, 8, 31);
        seedDataVariantAtribute("Intel", 9, 88); // Bộ xử lý - Hãng CPU
        seedDataVariantAtribute("Core i5", 61, 88); // Bộ xử lý - Công nghệ CPU
        seedDataVariantAtribute("13420H", 10, 88); // Bộ xử lý - Loại CPU
        seedDataVariantAtribute("2.1", 12, 88); // Bộ xử lý - Tốc độ CPU tối thiểu
        seedDataVariantAtribute("4.6 GHz", 12, 88); // Bộ xử lý - Tốc độ tối đa
        seedDataVariantAtribute("8", 11, 88); // Bộ xử lý - Số nhân
        seedDataVariantAtribute("12", 11, 88); // Bộ xử lý - Số luồng
        seedDataVariantAtribute("12 MB", 85, 88); // Bộ xử lý - Bộ nhớ đệm
        seedDataVariantAtribute("Intel", 63, 88); // Đồ họa - Hãng (Card Oboard)
        seedDataVariantAtribute("UHD", 64, 88); // Đồ họa - Model (Card Oboard)
        seedDataVariantAtribute("Intel UHD Graphics", 65, 88); // Đồ họa - Tên đầy đủ (Card onboard)
        seedDataVariantAtribute("16 GB (2 thanh 8 GB)", 79, 88); // RAM - Dung lượng RAM
        seedDataVariantAtribute("DDR4", 66, 88); // RAM - Loại RAM
        seedDataVariantAtribute("3200 MHz", 67, 88); // RAM - Tốc độ RAM
        seedDataVariantAtribute("1", 67, 88); // RAM - Số khe cắm rời
        seedDataVariantAtribute("40 GB", 68, 88); // RAM - Hỗ trợ RAM tối đa
        seedDataVariantAtribute("SSD", 70, 88); // Lưu trữ - Kiểu ổ cứng
        seedDataVariantAtribute("M.2 2242", 71, 88); // Lưu trữ - Loại SSD
        seedDataVariantAtribute("512", 23, 88); // Lưu trữ - Dung lượng
        seedDataVariantAtribute("2242", 73, 88); // Lưu trữ - Chuẩn M2
        seedDataVariantAtribute("14 inch", 14, 88); // Màn hình - Kích thước màn hình
        seedDataVariantAtribute("Anti-Glare", 15, 88); // Màn hình - Công nghệ màn hình
        seedDataVariantAtribute("1920 x 1200 Pixels", 17, 88); // Màn hình - Độ phân giải
        seedDataVariantAtribute("Màn hình phẳng", 19, 88); // Màn hình - Loại màn hình
        seedDataVariantAtribute("60", 22, 88); // Màn hình - Tần số quét
        seedDataVariantAtribute("IPS", 73, 88); // Màn hình - Tấm nền
        seedDataVariantAtribute("16:10", 81, 88); // Màn hình - Tỷ lệ màn hình
        seedDataVariantAtribute("USB 3.2 Gen 2 Type-C, USB 3.2 Gen 1 Type-A, HDMI 2.1, RJ45 Gigabit Ethernet, Jack 3.5 mm", 41, 88); // Giao tiếp và kết nối - Cổng giao tiếp
        seedDataVariantAtribute("Wifi 6", 42, 88); // Giao tiếp và kết nối - Wifi
        seedDataVariantAtribute("v5.1", 44, 88); // Giao tiếp và kết nối - Bluetooth
        seedDataVariantAtribute("Full HD Webcam (1080p Webcam)", 74, 88); // Giao tiếp và kết nối - Webcam
        seedDataVariantAtribute("High Definition (HD) Audio", 82, 88); // Âm Thanh - Công nghệ âm thanh
        seedDataVariantAtribute("Windows", 49, 88); // Hệ điều hành - OS
        seedDataVariantAtribute("Windows 11 Home", 50, 88); // Hệ điều hành - Version
        seedDataVariantAtribute("64 bit", 50, 88); // Hệ điều hành - Type
        seedDataVariantAtribute("Mở khóa vân tay", 37, 88); // Bảo mật - Bảo mật
        seedDataVariantAtribute("English International Backlit Keyboard", 51, 88); // Bàn phím & TouchPad - Kiểu bàn phím
        seedDataVariantAtribute("Không", 52, 88); // Bàn phím & TouchPad - Bàn phím số
        seedDataVariantAtribute("LED", 53, 88); // Bàn phím & TouchPad - Đèn bàn phím
        seedDataVariantAtribute("RGB 4 Zone", 54, 88); // Bàn phím & TouchPad - Công nghệ đèn bàn phím
        seedDataVariantAtribute("RGB", 55, 88); // Bàn phím & TouchPad - Màu đèn LED
        seedDataVariantAtribute("Multi-touch touchpad", 56, 88); // Bàn phím & TouchPad - TouchPad
        seedDataVariantAtribute("Lithium polymer", 46, 88); // Thông tin pin & sạc - Loại PIN
        seedDataVariantAtribute("53.5 Wh", 47, 88); // Thông tin pin & sạc - Dung lượng pin
        seedDataVariantAtribute("65 W", 75, 88); // Thông tin pin & sạc - Power Supply
        seedDataVariantAtribute("Bộ sạc điện, Balo", 57, 88); // Phụ kiện trong hộp
        seedDataVariantAtribute("2", 57, 88); // Thông số cơ bản - Số lượng loa
        seedDataVariantAtribute("313 x 219.3 x 17.99 mm", 5, 88); // Thiết kế & Trọng lượng - Kích thước
        seedDataVariantAtribute("1.43 kg", 6, 88); // Thiết kế & Trọng lượng - Trọng lượng sản phẩm
        seedDataVariantAtribute("Nhôm", 7, 88); // Thiết kế & Trọng lượng - Chất liệu
        seedDataVariantAtribute("Trung Quốc", 1, 88); // Thông tin hàng hóa - Xuất xứ
        seedDataVariantAtribute("01/2024", 2, 88); // Thông tin hàng hóa - Thời điểm ra mắt
        seedDataVariantAtribute("24", 4, 88); // Thông tin hàng hóa - Thời gian bảo hành (tháng)
        seedDataVariantAtribute("Để nơi khô ráo, nhẹ tay, dễ vỡ. Xem trong sách hướng dẫn sử dụng", 48, 88); // Thông tin Pin và Sạc - Hướng dẫn bảo quản và sử dụng
        seedDataVariantAtribute("Đen", 3, 88); // Thông tin hàng hóa - Màu sắc


        // Laptop Lenovo Ideapad Slim 5 15IRU9 CORE 5_120U/32GB/512G/15.3"WUXGA/Win11
        seedDataVariant("Laptop Lenovo Ideapad Slim 5 15IRU9 CORE 5_120U/32GB/512G", 20699900.0, 5, 31);
        seedDataVariantAtribute("Intel", 9, 89); // Bộ xử lý - Hãng CPU
        seedDataVariantAtribute("Core 5", 61, 89); // Bộ xử lý - Công nghệ CPU
        seedDataVariantAtribute("120U", 10, 89); // Bộ xử lý - Loại CPU
        seedDataVariantAtribute("1.4", 12, 89); // Bộ xử lý - Tốc độ CPU tối thiểu
        seedDataVariantAtribute("5 GHz", 12, 89); // Bộ xử lý - Tốc độ tối đa
        seedDataVariantAtribute("10", 11, 89); // Bộ xử lý - Số nhân
        seedDataVariantAtribute("12", 11, 89); // Bộ xử lý - Số luồng
        seedDataVariantAtribute("12 MB", 85, 89); // Bộ xử lý - Bộ nhớ đệm
        seedDataVariantAtribute("Intel", 63, 89); // Đồ họa - Hãng (Card Oboard)
        seedDataVariantAtribute("Intel Graphics", 65, 89); // Đồ họa - Tên đầy đủ (Card onboard)
        seedDataVariantAtribute("32 GB (1 thanh 32 GB)", 79, 89); // RAM - Dung lượng RAM
        seedDataVariantAtribute("LPDDR5", 66, 89); // RAM - Loại RAM
        seedDataVariantAtribute("5200 MHz", 67, 89); // RAM - Tốc độ RAM
        seedDataVariantAtribute("1", 67, 89); // RAM - Số RAM onboard
        seedDataVariantAtribute("Không nâng cấp", 68, 89); // RAM - Hỗ trợ RAM tối đa
        seedDataVariantAtribute("SSD", 70, 89); // Lưu trữ - Kiểu ổ cứng
        seedDataVariantAtribute("M2. PCIe", 73, 89); // Lưu trữ - Loại SSD
        seedDataVariantAtribute("512", 23, 89); // Lưu trữ - Dung lượng
        seedDataVariantAtribute("15.3 inch", 14, 89); // Màn hình - Kích thước màn hình
        seedDataVariantAtribute("Anti - Glare", 15, 89); // Màn hình - Công nghệ màn hình
        seedDataVariantAtribute("1920 x 1200 Pixels", 17, 89); // Màn hình - Độ phân giải
        seedDataVariantAtribute("Màn hình phẳng", 19, 89); // Màn hình - Loại màn hình
        seedDataVariantAtribute("60", 22, 89); // Màn hình - Tần số quét
        seedDataVariantAtribute("IPS", 73, 89); // Màn hình - Tấm nền
        seedDataVariantAtribute("100% sRGB", 78, 89); // Màn hình - Độ phủ màu
        seedDataVariantAtribute("2 USB Type-A, 2 USB Type-C, 1 HDMI 1.4, 1 Jack 3.5 mm, 1 MicroSD card reader", 41, 89); // Giao tiếp và kết nối - Cổng giao tiếp
        seedDataVariantAtribute("Wifi 6", 42, 89); // Giao tiếp và kết nối - Wifi
        seedDataVariantAtribute("v5.2", 44, 89); // Giao tiếp và kết nối - Bluetooth
        seedDataVariantAtribute("Full HD Webcam (1080p Webcam)", 74, 89); // Giao tiếp và kết nối - Webcam
        seedDataVariantAtribute("Windows", 49, 89); // Hệ điều hành - OS
        seedDataVariantAtribute("Windows 11 Home Single Language", 50, 89); // Hệ điều hành - Version
        seedDataVariantAtribute("64 bit", 50, 89); // Hệ điều hành - Type
        seedDataVariantAtribute("Mật khẩu", 37, 89); // Bảo mật - Bảo mật
        seedDataVariantAtribute("English International Non-backlit Keyboard", 51, 89); // Bàn phím & TouchPad - Kiểu bàn phím
        seedDataVariantAtribute("Có", 52, 89); // Bàn phím & TouchPad - Bàn phím số
        seedDataVariantAtribute("Không", 53, 89); // Bàn phím & TouchPad - Đèn bàn phím
        seedDataVariantAtribute("Multi-touch touchpad", 56, 89); // Bàn phím & TouchPad - TouchPad
        seedDataVariantAtribute("Lithium polymer", 46, 89); // Thông tin pin & sạc - Loại PIN
        seedDataVariantAtribute("57 Wh", 47, 89); // Thông tin pin & sạc - Dung lượng pin
        seedDataVariantAtribute("65 W", 75, 89); // Thông tin pin & sạc - Power Supply
        seedDataVariantAtribute("Bộ sạc điện, Balo", 57, 89); // Phụ kiện trong hộp
        seedDataVariantAtribute("2", 57, 89); // Thông số cơ bản - Số lượng loa
        seedDataVariantAtribute("343.5 x 238.21 x 17.42 mm", 5, 89); // Thiết kế & Trọng lượng - Kích thước
        seedDataVariantAtribute("1.79 kg", 6, 89); // Thiết kế & Trọng lượng - Trọng lượng sản phẩm
        seedDataVariantAtribute("Hợp kim nhôm", 7, 89); // Thiết kế & Trọng lượng - Chất liệu
        seedDataVariantAtribute("Trung Quốc", 1, 89); // Thông tin hàng hóa - Xuất xứ
        seedDataVariantAtribute("01/2024", 2, 89); // Thông tin hàng hóa - Thời điểm ra mắt
        seedDataVariantAtribute("24", 4, 89); // Thông tin hàng hóa - Thời gian bảo hành (tháng)
        seedDataVariantAtribute("Để nơi khô ráo, nhẹ tay, dễ vỡ. Xem trong sách hướng dẫn sử dụng", 48, 89); // Thông tin Pin và Sạc - Hướng dẫn bảo quản và sử dụng
        seedDataVariantAtribute("Xám", 3, 89); // Thông tin hàng hóa - Màu sắc


        // Laptop Lenovo ThinkPad E14 Gen 5 i7-1355U/16GB/512GB/14.0"WUXGA/Win 11
        seedDataVariant("Laptop Lenovo ThinkPad E14 Gen 5 i7-1355U/16GB/512GB", 22699900.0, 5, 31);
        seedDataVariantAtribute("Intel", 9, 90); // Bộ xử lý - Hãng CPU
        seedDataVariantAtribute("Core i7", 61, 90); // Bộ xử lý - Công nghệ CPU
        seedDataVariantAtribute("1355U", 10, 90); // Bộ xử lý - Loại CPU
        seedDataVariantAtribute("1.7", 12, 90); // Bộ xử lý - Tốc độ CPU tối thiểu
        seedDataVariantAtribute("5 GHz", 12, 90); // Bộ xử lý - Tốc độ tối đa
        seedDataVariantAtribute("10", 11, 90); // Bộ xử lý - Số nhân
        seedDataVariantAtribute("12", 12, 90); // Bộ xử lý - Số luồng
        seedDataVariantAtribute("12 MB", 85, 90); // Bộ xử lý - Bộ nhớ đệm
        seedDataVariantAtribute("Intel", 63, 90); // Đồ họa - Hãng (Card Oboard)
        seedDataVariantAtribute("Iris Xe", 64, 90); // Đồ họa - Model (Card Oboard)
        seedDataVariantAtribute("Intel Iris Xe Graphics", 65, 90); // Đồ họa - Tên đầy đủ (Card onboard)
        seedDataVariantAtribute("16 GB (2 thanh 8 GB)", 79, 90); // RAM - Dung lượng RAM
        seedDataVariantAtribute("DDR4", 66, 90); // RAM - Loại RAM
        seedDataVariantAtribute("3200 MHz", 67, 90); // RAM - Tốc độ RAM
        seedDataVariantAtribute("1", 67, 90); // RAM - Số khe cắm rời
        seedDataVariantAtribute("1", 67, 90); // RAM - Số RAM onboard
        seedDataVariantAtribute("40 GB", 68, 90); // RAM - Hỗ trợ RAM tối đa
        seedDataVariantAtribute("SSD", 70, 90); // Lưu trữ - Kiểu ổ cứng
        seedDataVariantAtribute("M2. PCIe", 73, 90); // Lưu trữ - Loại SSD
        seedDataVariantAtribute("512", 23, 90); // Lưu trữ - Dung lượng
        seedDataVariantAtribute("14 inch", 14, 90); // Màn hình - Kích thước màn hình
        seedDataVariantAtribute("Anti-glare LED Backlit Ultra Slim", 15, 90); // Màn hình - Công nghệ màn hình
        seedDataVariantAtribute("1920 x 1080 Pixels", 17, 90); // Màn hình - Độ phân giải
        seedDataVariantAtribute("Màn hình phẳng", 19, 90); // Màn hình - Loại màn hình
        seedDataVariantAtribute("60", 22, 90); // Màn hình - Tần số quét
        seedDataVariantAtribute("IPS", 73, 90); // Màn hình - Tấm nền
        seedDataVariantAtribute("300 nits", 20, 90); // Màn hình - Độ sáng
        seedDataVariantAtribute("45% NTSC", 78, 90); // Màn hình - Độ phủ màu
        seedDataVariantAtribute("1 HDMI 2.1, 1 Jack 3.5 mm, 1 RJ45 Gigabit Ethernet, 1 USB 2.0, 1 USB 3.2 Gen 1, 1 USB 3.2 Gen 2, 1 Thunderbolt 4", 41, 90); // Giao tiếp và kết nối - Cổng giao tiếp
        seedDataVariantAtribute("Wifi 6", 42, 90); // Giao tiếp và kết nối - Wifi
        seedDataVariantAtribute("v5.1", 44, 90); // Giao tiếp và kết nối - Bluetooth
        seedDataVariantAtribute("Full HD Webcam (1080p Webcam)", 74, 90); // Giao tiếp và kết nối - Webcam
        seedDataVariantAtribute("Windows", 49, 90); // Hệ điều hành - OS
        seedDataVariantAtribute("Windows 11 Home Single Language", 50, 90); // Hệ điều hành - Version
        seedDataVariantAtribute("Mật khẩu", 37, 90); // Bảo mật - Bảo mật
        seedDataVariantAtribute("Backlit Chiclet Keyboard", 51, 90); // Bàn phím & TouchPad - Kiểu bàn phím
        seedDataVariantAtribute("Không", 52, 90); // Bàn phím & TouchPad - Bàn phím số
        seedDataVariantAtribute("LED", 53, 90); // Bàn phím & TouchPad - Đèn bàn phím
        seedDataVariantAtribute("Multi-touch touchpad", 56, 90); // Bàn phím & TouchPad - TouchPad
        seedDataVariantAtribute("3 Cell", 46, 90); // Thông tin pin & sạc - Dung lượng pin
        seedDataVariantAtribute("45 W", 75, 90); // Thông tin pin & sạc - Power Supply
        seedDataVariantAtribute("Bộ sạc điện, Balo", 57, 90); // Phụ kiện trong hộp
        seedDataVariantAtribute("343.5 x 238.21 x 17.42 mm", 5, 90); // Thiết kế & Trọng lượng - Kích thước
        seedDataVariantAtribute("1.59 kg", 6, 90); // Thiết kế & Trọng lượng - Trọng lượng sản phẩm
        seedDataVariantAtribute("Hợp kim nhôm", 7, 90); // Thiết kế & Trọng lượng - Chất liệu
        seedDataVariantAtribute("Trung Quốc", 1, 90); // Thông tin hàng hóa - Xuất xứ
        seedDataVariantAtribute("01/2024", 2, 90); // Thông tin hàng hóa - Thời điểm ra mắt
        seedDataVariantAtribute("24", 4, 90); // Thông tin hàng hóa - Thời gian bảo hành (tháng)
        seedDataVariantAtribute("Để nơi khô ráo, nhẹ tay, dễ vỡ. Xem trong sách hướng dẫn sử dụng", 48, 90); // Thông tin Pin và Sạc - Hướng dẫn bảo quản và sử dụng
        seedDataVariantAtribute("Xám", 3, 90); // Thông tin hàng hóa - Màu sắc


        // Laptop Lenovo V15 G4 IRU i5 13420H/16GB/512GB/15.6"FHD/Win 11
        seedDataVariant("Laptop Lenovo V15 G4 IRU i5 13420H/16GB/512GB", 15699900.0, 7, 31);
        seedDataVariantAtribute("Intel", 9, 91); // Bộ xử lý - Hãng CPU
        seedDataVariantAtribute("Core i5", 61, 91); // Bộ xử lý - Công nghệ CPU
        seedDataVariantAtribute("13420H", 10, 91); // Bộ xử lý - Loại CPU
        seedDataVariantAtribute("2.1", 12, 91); // Bộ xử lý - Tốc độ CPU tối thiểu
        seedDataVariantAtribute("4.6 GHz", 12, 91); // Bộ xử lý - Tốc độ tối đa
        seedDataVariantAtribute("8", 11, 91); // Bộ xử lý - Số nhân
        seedDataVariantAtribute("12", 12, 91); // Bộ xử lý - Số luồng
        seedDataVariantAtribute("12 MB", 85, 91); // Bộ xử lý - Bộ nhớ đệm
        seedDataVariantAtribute("Intel", 63, 91); // Đồ họa - Hãng (Card Oboard)
        seedDataVariantAtribute("UHD", 64, 91); // Đồ họa - Model (Card Oboard)
        seedDataVariantAtribute("Intel UHD Graphics", 65, 91); // Đồ họa - Tên đầy đủ (Card onboard)
        seedDataVariantAtribute("16 GB (2 thanh 8 GB)", 79, 91); // RAM - Dung lượng RAM
        seedDataVariantAtribute("DDR4", 66, 91); // RAM - Loại RAM
        seedDataVariantAtribute("3200 MHz", 67, 91); // RAM - Tốc độ RAM
        seedDataVariantAtribute("1", 67, 91); // RAM - Số khe cắm rời
        seedDataVariantAtribute("16 GB", 68, 91); // RAM - Hỗ trợ RAM tối đa
        seedDataVariantAtribute("SSD", 70, 91); // Lưu trữ - Kiểu ổ cứng
        seedDataVariantAtribute("M.2 2242", 73, 91); // Lưu trữ - Loại SSD
        seedDataVariantAtribute("512", 23, 91); // Lưu trữ - Dung lượng
        seedDataVariantAtribute("15.6 inch", 14, 91); // Màn hình - Kích thước màn hình
        seedDataVariantAtribute("Anti-Glare", 15, 91); // Màn hình - Công nghệ màn hình
        seedDataVariantAtribute("1920 x 1080 Pixels", 17, 91); // Màn hình - Độ phân giải
        seedDataVariantAtribute("Màn hình phẳng", 19, 91); // Màn hình - Loại màn hình
        seedDataVariantAtribute("60", 22, 91); // Màn hình - Tần số quét
        seedDataVariantAtribute("IPS", 73, 91); // Màn hình - Tấm nền
        seedDataVariantAtribute("300 nits", 20, 91); // Màn hình - Độ sáng
        seedDataVariantAtribute("45% NTSC", 78, 91); // Màn hình - Độ phủ màu
        seedDataVariantAtribute("1 USB 2.0, 1 USB 3.2 Gen 1, 1 USB 3.2 Gen 1 Type-C, 1 HDMI 1.4, 1 Jack 3.5 mm, 1 RJ45 Gigabit Ethernet, 1 Power connector", 41, 91); // Giao tiếp và kết nối - Cổng giao tiếp
        seedDataVariantAtribute("Wifi 6E", 42, 91); // Giao tiếp và kết nối - Wifi
        seedDataVariantAtribute("v5.1", 44, 91); // Giao tiếp và kết nối - Bluetooth
        seedDataVariantAtribute("Full HD Webcam (1080p Webcam)", 74, 91); // Giao tiếp và kết nối - Webcam
        seedDataVariantAtribute("Windows", 49, 91); // Hệ điều hành - OS
        seedDataVariantAtribute("Windows 11 Home Single Language", 50, 91); // Hệ điều hành - Version
        seedDataVariantAtribute("Mật khẩu", 37, 91); // Bảo mật - Bảo mật
        seedDataVariantAtribute("English International Non-backlit Keyboard", 51, 91); // Bàn phím & TouchPad - Kiểu bàn phím
        seedDataVariantAtribute("Không", 52, 91); // Bàn phím & TouchPad - Bàn phím số
        seedDataVariantAtribute("Không", 53, 91); // Bàn phím & TouchPad - Đèn bàn phím
        seedDataVariantAtribute("Multi-touch touchpad", 56, 91); // Bàn phím & TouchPad - TouchPad
        seedDataVariantAtribute("38 Wh", 47, 91); // Thông tin pin & sạc - Dung lượng pin
        seedDataVariantAtribute("65 W", 75, 91); // Thông tin pin & sạc - Power Supply
        seedDataVariantAtribute("Bộ sạc điện, Balo", 57, 91); // Phụ kiện trong hộp
        seedDataVariantAtribute("359.2 x 235.8 x 19.9 mm", 5, 91); // Thiết kế & Trọng lượng - Kích thước
        seedDataVariantAtribute("1.65 kg", 6, 91); // Thiết kế & Trọng lượng - Trọng lượng sản phẩm
        seedDataVariantAtribute("Nhựa", 7, 91); // Thiết kế & Trọng lượng - Chất liệu
        seedDataVariantAtribute("Trung Quốc", 1, 91); // Thông tin hàng hóa - Xuất xứ
        seedDataVariantAtribute("01/2024", 2, 91); // Thông tin hàng hóa - Thời điểm ra mắt
        seedDataVariantAtribute("24", 4, 91); // Thông tin hàng hóa - Thời gian bảo hành (tháng)
        seedDataVariantAtribute("Để nơi khô ráo, nhẹ tay, dễ vỡ. Xem trong sách hướng dẫn sử dụng", 48, 91); // Thông tin Pin và Sạc - Hướng dẫn bảo quản và sử dụng
        seedDataVariantAtribute("Xám", 3, 91); // Thông tin hàng hóa - Màu sắc


        //Laptop Lenovo Gaming LOQ 15ARP9 R7 7435HS/AI/24GB/512GB/15.6"FHD/RTX4060 8GB/Win11
        seedDataVariant("Laptop Lenovo Gaming LOQ 15ARP9 R7 7435HS/AI/24GB/512GB", 30699900.0, 7, 31);
        seedDataVariantAtribute("AMD", 9, 92); // Bộ xử lý - Hãng CPU
        seedDataVariantAtribute("Ryzen 7", 61, 92); // Bộ xử lý - Công nghệ CPU
        seedDataVariantAtribute("7435HS", 10, 92); // Bộ xử lý - Loại CPU
        seedDataVariantAtribute("3.1", 12, 92); // Bộ xử lý - Tốc độ CPU tối thiểu
        seedDataVariantAtribute("4.5 GHz", 12, 92); // Bộ xử lý - Tốc độ tối đa
        seedDataVariantAtribute("8", 11, 92); // Bộ xử lý - Số nhân
        seedDataVariantAtribute("16", 12, 92); // Bộ xử lý - Số luồng
        seedDataVariantAtribute("NVIDIA", 83, 92); // Đồ họa - Hãng (Card rời)
        seedDataVariantAtribute("GeForce RTX 4060", 84, 92); // Đồ họa - Model (Card rời)
        seedDataVariantAtribute("NVIDIA Geforce RTX 4060 8GB GDDR6", 65, 92); // Đồ họa - Tên đầy đủ (Card rời)
        seedDataVariantAtribute("8 GB", 77, 92); // Đồ họa - Bộ nhớ
        seedDataVariantAtribute("233", 85, 92); // Đồ họa - Hiệu suất AI (TOPS)
        seedDataVariantAtribute("24 GB (2 thanh 12GB)", 79, 92); // RAM - Dung lượng RAM
        seedDataVariantAtribute("DDR5", 66, 92); // RAM - Loại RAM
        seedDataVariantAtribute("4800 MHz", 67, 92); // RAM - Tốc độ RAM
        seedDataVariantAtribute("2", 67, 92); // RAM - Số khe cắm rời
        seedDataVariantAtribute("32 GB", 68, 92); // RAM - Hỗ trợ RAM tối đa
        seedDataVariantAtribute("SSD", 70, 92); // Lưu trữ - Kiểu ổ cứng
        seedDataVariantAtribute("1 M2. PCIe", 73, 92); // Lưu trữ - Loại SSD
        seedDataVariantAtribute("512", 23, 92); // Lưu trữ - Dung lượng
        seedDataVariantAtribute("2242", 73, 92); // Lưu trữ - Chuẩn M2
        seedDataVariantAtribute("15.6 inch", 14, 92); // Màn hình - Kích thước màn hình
        seedDataVariantAtribute("FHD", 15, 92); // Màn hình - Công nghệ màn hình
        seedDataVariantAtribute("1920 x 1080 Pixels", 17, 92); // Màn hình - Độ phân giải
        seedDataVariantAtribute("Màn hình phẳng", 19, 92); // Màn hình - Loại màn hình
        seedDataVariantAtribute("144", 22, 92); // Màn hình - Tần số quét
        seedDataVariantAtribute("IPS", 73, 92); // Màn hình - Tấm nền
        seedDataVariantAtribute("300 nits", 20, 92); // Màn hình - Độ sáng
        seedDataVariantAtribute("100% sRGB", 78, 92); // Màn hình - Độ phủ màu
        seedDataVariantAtribute("3 USB 3.2 Gen 1 Type-A, 1 USB 3.2 Gen 2 Type-C, 1 HDMI 2.1, 1 Jack 3.5 mm, 1 RJ45 Gigabit Ethernet, 1 Power connector", 41, 92); // Giao tiếp và kết nối - Cổng giao tiếp
        seedDataVariantAtribute("Wifi 6", 42, 92); // Giao tiếp và kết nối - Wifi
        seedDataVariantAtribute("v5.2", 44, 92); // Giao tiếp và kết nối - Bluetooth
        seedDataVariantAtribute("HD 720p DualAryMic", 74, 92); // Giao tiếp và kết nối - Webcam
        seedDataVariantAtribute("Windows", 49, 92); // Hệ điều hành - OS
        seedDataVariantAtribute("Windows 11 Home Single Language", 50, 92); // Hệ điều hành - Version
        seedDataVariantAtribute("Mật khẩu", 37, 92); // Bảo mật - Bảo mật
        seedDataVariantAtribute("English International Backlit Keyboard", 51, 92); // Bàn phím & TouchPad - Kiểu bàn phím
        seedDataVariantAtribute("Có", 52, 92); // Bàn phím & TouchPad - Bàn phím số
        seedDataVariantAtribute("LED", 53, 92); // Bàn phím & TouchPad - Đèn bàn phím
        seedDataVariantAtribute("Trắng", 55, 92); // Bàn phím & TouchPad - Màu đèn LED
        seedDataVariantAtribute("Multi-touch touchpad", 56, 92); // Bàn phím & TouchPad - TouchPad
        seedDataVariantAtribute("60 Wh", 47, 92); // Thông tin pin & sạc - Dung lượng pin
        seedDataVariantAtribute("170 W", 75, 92); // Thông tin pin & sạc - Power Supply
        seedDataVariantAtribute("Bộ sạc điện, Balo", 57, 92); // Phụ kiện trong hộp
        seedDataVariantAtribute("359.86 x 258.7 x 21.9-23.9 mm", 5, 92); // Thiết kế & Trọng lượng - Kích thước
        seedDataVariantAtribute("2.38 kg", 6, 92); // Thiết kế & Trọng lượng - Trọng lượng sản phẩm
        seedDataVariantAtribute("Nhựa ABS", 7, 92); // Thiết kế & Trọng lượng - Chất liệu
        seedDataVariantAtribute("Trung Quốc", 1, 92); // Thông tin hàng hóa - Xuất xứ
        seedDataVariantAtribute("04/2024", 2, 92); // Thông tin hàng hóa - Thời điểm ra mắt
        seedDataVariantAtribute("24", 4, 92); // Thông tin hàng hóa - Thời gian bảo hành (tháng)
        seedDataVariantAtribute("Để nơi khô ráo, nhẹ tay, dễ vỡ. Xem trong sách hướng dẫn sử dụng", 48, 92); // Thông tin Pin và Sạc - Hướng dẫn bảo quản và sử dụng
        seedDataVariantAtribute("Xám", 3, 92); // Thông tin hàng hóa - Màu sắc


        // Laptop Lenovo Gaming LOQ 15IAX9 i5 12450HX/AI/12GB/512GB/15.6"FHD/RTX4050_6GB/W11_83GS001QVN
        seedDataVariant("Laptop Lenovo Gaming LOQ 15IAX9 i5 12450HX/AI/12GB/512GB", 25699900.0, 7, 31);
        seedDataVariantAtribute("Intel", 9, 93); // Bộ xử lý - Hãng CPU
        seedDataVariantAtribute("Core i5", 61, 93); // Bộ xử lý - Công nghệ CPU
        seedDataVariantAtribute("12450HX", 10, 93); // Bộ xử lý - Loại CPU
        seedDataVariantAtribute("2.4", 12, 93); // Bộ xử lý - Tốc độ CPU tối thiểu
        seedDataVariantAtribute("4.4 GHz", 12, 93); // Bộ xử lý - Tốc độ tối đa
        seedDataVariantAtribute("8", 11, 93); // Bộ xử lý - Số nhân
        seedDataVariantAtribute("12", 12, 93); // Bộ xử lý - Số luồng
        seedDataVariantAtribute("12 MB", 85, 93); // Bộ xử lý - Bộ nhớ đệm
        seedDataVariantAtribute("NVIDIA", 83, 93); // Đồ họa - Hãng (Card rời)
        seedDataVariantAtribute("GeForce RTX 4050", 84, 93); // Đồ họa - Model (Card rời)
        seedDataVariantAtribute("NVIDIA GeForce RTX 4050 6GB GDDR6", 65, 93); // Đồ họa - Tên đầy đủ (Card rời)
        seedDataVariantAtribute("12 GB (1 thanh 12GB)", 79, 93); // RAM - Dung lượng RAM
        seedDataVariantAtribute("DDR5", 66, 93); // RAM - Loại RAM
        seedDataVariantAtribute("4800 MHz", 67, 93); // RAM - Tốc độ RAM
        seedDataVariantAtribute("1", 67, 93); // RAM - Số khe cắm rời
        seedDataVariantAtribute("1", 67, 93); // RAM - Số khe RAM còn lại
        seedDataVariantAtribute("32 GB", 68, 93); // RAM - Hỗ trợ RAM tối đa
        seedDataVariantAtribute("SSD", 70, 93); // Lưu trữ - Kiểu ổ cứng
        seedDataVariantAtribute("M2. PCIe", 73, 93); // Lưu trữ - Loại SSD
        seedDataVariantAtribute("512", 23, 93); // Lưu trữ - Dung lượng
        seedDataVariantAtribute("2242", 73, 93); // Lưu trữ - Chuẩn M2
        seedDataVariantAtribute("15.6 inch", 14, 93); // Màn hình - Kích thước màn hình
        seedDataVariantAtribute("Anti-glare LED-Backlit Display", 15, 93); // Màn hình - Công nghệ màn hình
        seedDataVariantAtribute("1920 x 1080 Pixels", 17, 93); // Màn hình - Độ phân giải
        seedDataVariantAtribute("Màn hình phẳng", 19, 93); // Màn hình - Loại màn hình
        seedDataVariantAtribute("144", 22, 93); // Màn hình - Tần số quét
        seedDataVariantAtribute("IPS", 73, 93); // Màn hình - Tấm nền
        seedDataVariantAtribute("300 nits", 20, 93); // Màn hình - Độ sáng
        seedDataVariantAtribute("100% sRGB", 78, 93); // Màn hình - Độ phủ màu
        seedDataVariantAtribute("3 USB 3.2 Gen 1 Type-A, 1 USB Type-C, 1 HDMI 2.1, 1 Jack 3.5 mm, 1 RJ45 Gigabit Ethernet, 1 Power connector", 41, 93); // Giao tiếp và kết nối - Cổng giao tiếp
        seedDataVariantAtribute("Wifi 6E", 42, 93); // Giao tiếp và kết nối - Wifi
        seedDataVariantAtribute("v5.2", 44, 93); // Giao tiếp và kết nối - Bluetooth
        seedDataVariantAtribute("Full HD Webcam (1080p Webcam)", 74, 93); // Giao tiếp và kết nối - Webcam
        seedDataVariantAtribute("Windows", 49, 93); // Hệ điều hành - OS
        seedDataVariantAtribute("Windows 11 Home Single Language", 50, 93); // Hệ điều hành - Version
        seedDataVariantAtribute("Mật khẩu", 37, 93); // Bảo mật - Bảo mật
        seedDataVariantAtribute("English International Backlit Keyboard", 51, 93); // Bàn phím & TouchPad - Kiểu bàn phím
        seedDataVariantAtribute("Có", 52, 93); // Bàn phím & TouchPad - Bàn phím số
        seedDataVariantAtribute("LED", 53, 93); // Bàn phím & TouchPad - Đèn bàn phím
        seedDataVariantAtribute("Trắng", 55, 93); // Bàn phím & TouchPad - Màu đèn LED
        seedDataVariantAtribute("Multi-touch touchpad", 56, 93); // Bàn phím & TouchPad - TouchPad
        seedDataVariantAtribute("60 Wh", 47, 93); // Thông tin pin & sạc - Dung lượng pin
        seedDataVariantAtribute("170 W", 75, 93); // Thông tin pin & sạc - Power Supply
        seedDataVariantAtribute("Bộ sạc điện, Balo", 57, 93); // Phụ kiện trong hộp
        seedDataVariantAtribute("359.86 x 258.7 x 21.9-23.9 mm", 5, 93); // Thiết kế & Trọng lượng - Kích thước
        seedDataVariantAtribute("2.38 kg", 6, 93); // Thiết kế & Trọng lượng - Trọng lượng sản phẩm
        seedDataVariantAtribute("Nhựa PC, Nhựa ABS", 7, 93); // Thiết kế & Trọng lượng - Chất liệu
        seedDataVariantAtribute("Trung Quốc", 1, 93); // Thông tin hàng hóa - Xuất xứ
        seedDataVariantAtribute("04/2024", 2, 93); // Thông tin hàng hóa - Thời điểm ra mắt
        seedDataVariantAtribute("24", 4, 93); // Thông tin hàng hóa - Thời gian bảo hành (tháng)
        seedDataVariantAtribute("Để nơi khô ráo, nhẹ tay, dễ vỡ. Xem trong sách hướng dẫn sử dụng", 48, 93); // Thông tin Pin và Sạc - Hướng dẫn bảo quản và sử dụng
        seedDataVariantAtribute("Xám", 3, 93); // Thông tin hàng hóa - Màu sắc


        // Laptop Lenovo Gaming Legion 9 16IRX8 i9 13980HX/AI/64GB/2TB/16"3.2K Mini LED/RTX4090 16GB/Win11
        seedDataVariant("Laptop Lenovo Gaming Legion 9 16IRX8 i9 13980HX/AI/64GB/2TB", 128699900.0, 7, 31);
        seedDataVariantAtribute("Intel", 9, 94); // Bộ xử lý - Hãng CPU
        seedDataVariantAtribute("Core i9", 61, 94); // Bộ xử lý - Công nghệ CPU
        seedDataVariantAtribute("13980HX", 10, 94); // Bộ xử lý - Loại CPU
        seedDataVariantAtribute("2.2", 12, 94); // Bộ xử lý - Tốc độ CPU tối thiểu
        seedDataVariantAtribute("5.6 GHz", 12, 94); // Bộ xử lý - Tốc độ tối đa
        seedDataVariantAtribute("24", 11, 94); // Bộ xử lý - Số nhân
        seedDataVariantAtribute("32", 12, 94); // Bộ xử lý - Số luồng
        seedDataVariantAtribute("36 MB", 85, 94); // Bộ xử lý - Bộ nhớ đệm
        seedDataVariantAtribute("NVIDIA", 83, 94); // Đồ họa - Hãng (Card rời)
        seedDataVariantAtribute("GeForce RTX 4090", 84, 94); // Đồ họa - Model (Card rời)
        seedDataVariantAtribute("NVIDIA GeForce RTX 4090 16GB GDDR6", 65, 94); // Đồ họa - Tên đầy đủ (Card rời)
        seedDataVariantAtribute("16 GB", 77, 94); // Đồ họa - Bộ nhớ
        seedDataVariantAtribute("686", 85, 94); // Đồ họa - Hiệu suất AI (TOPS)
        seedDataVariantAtribute("64 GB (2 thanh 32 GB)", 79, 94); // RAM - Dung lượng RAM
        seedDataVariantAtribute("DDR5", 66, 94); // RAM - Loại RAM
        seedDataVariantAtribute("5600 MHz", 67, 94); // RAM - Tốc độ RAM
        seedDataVariantAtribute("2", 67, 94); // RAM - Số khe cắm rời
        seedDataVariantAtribute("32 GB", 68, 94); // RAM - Hỗ trợ RAM tối đa
        seedDataVariantAtribute("SSD", 70, 94); // Lưu trữ - Kiểu ổ cứng
        seedDataVariantAtribute("2", 71, 94); // Lưu trữ - Tổng số khe cắm SSD/HDD
        seedDataVariantAtribute("2 M2. PCIe", 73, 94); // Lưu trữ - Loại SSD
        seedDataVariantAtribute("2", 23, 94); // Lưu trữ - Dung lượng
        seedDataVariantAtribute("2280", 73, 94); // Lưu trữ - Chuẩn M2
        seedDataVariantAtribute("16 inch", 14, 94); // Màn hình - Kích thước màn hình
        seedDataVariantAtribute("Anti -glare", 15, 94); // Màn hình - Công nghệ màn hình
        seedDataVariantAtribute("3200 x 2000 Pixels", 17, 94); // Màn hình - Độ phân giải
        seedDataVariantAtribute("Màn hình phẳng", 19, 94); // Màn hình - Loại màn hình
        seedDataVariantAtribute("165", 22, 94); // Màn hình - Tần số quét
        seedDataVariantAtribute("Mini LED", 73, 94); // Màn hình - Tấm nền
        seedDataVariantAtribute("1200 nits", 20, 94); // Màn hình - Độ sáng
        seedDataVariantAtribute("100% sRGB", 78, 94); // Màn hình - Độ phủ màu
        seedDataVariantAtribute("3 USB 3.2 Gen 1, 1 USB 3.2 Gen 1 Type-C, 1 Thunderbolt 4, 1 HDMI 2.1, 1 Jack 3.5 mm, 1 RJ45 Gigabit Ethernet, 1 Card reader, 1 Power connector", 41, 94); // Giao tiếp và kết nối - Cổng giao tiếp
        seedDataVariantAtribute("Wifi 6E", 42, 94); // Giao tiếp và kết nối - Wifi
        seedDataVariantAtribute("v5.3", 44, 94); // Giao tiếp và kết nối - Bluetooth
        seedDataVariantAtribute("Full HD Webcam (1080p Webcam)", 74, 94); // Giao tiếp và kết nối - Webcam
        seedDataVariantAtribute("Windows", 49, 94); // Hệ điều hành - OS
        seedDataVariantAtribute("Windows 11 Home Single Language", 50, 94); // Hệ điều hành - Version
        seedDataVariantAtribute("Mật khẩu", 37, 94); // Bảo mật - Bảo mật
        seedDataVariantAtribute("Per-Key RGB Gaming Keyboard", 51, 94); // Bàn phím & TouchPad - Kiểu bàn phím
        seedDataVariantAtribute("Có", 52, 94); // Bàn phím & TouchPad - Bàn phím số
        seedDataVariantAtribute("LED", 53, 94); // Bàn phím & TouchPad - Đèn bàn phím
        seedDataVariantAtribute("Trắng", 55, 94); // Bàn phím & TouchPad - Màu đèn LED
        seedDataVariantAtribute("Multi-touch touchpad", 56, 94); // Bàn phím & TouchPad - TouchPad
        seedDataVariantAtribute("60 Wh", 47, 94); // Thông tin pin & sạc - Dung lượng pin
        seedDataVariantAtribute("330 W", 75, 94); // Thông tin pin & sạc - Power Supply
        seedDataVariantAtribute("Bộ sạc điện, Balo", 57, 94); // Phụ kiện trong hộp
        seedDataVariantAtribute("357.7 x 277.7 x 18.9 mm", 5, 94); // Thiết kế & Trọng lượng - Kích thước
        seedDataVariantAtribute("2.56 kg", 6, 94); // Thiết kế & Trọng lượng - Trọng lượng sản phẩm
        seedDataVariantAtribute("Kim loại", 7, 94); // Thiết kế & Trọng lượng - Chất liệu
        seedDataVariantAtribute("Trung Quốc", 1, 94); // Thông tin hàng hóa - Xuất xứ
        seedDataVariantAtribute("04/2024", 2, 94); // Thông tin hàng hóa - Thời điểm ra mắt
        seedDataVariantAtribute("36", 4, 94); // Thông tin hàng hóa - Thời gian bảo hành (tháng)
        seedDataVariantAtribute("Để nơi khô ráo, nhẹ tay, dễ vỡ. Xem trong sách hướng dẫn sử dụng", 48, 94); // Thông tin Pin và Sạc - Hướng dẫn bảo quản và sử dụng
        seedDataVariantAtribute("Đen", 3, 94); // Thông tin hàng hóa - Màu sắc

        // Ipad
        // iPad Air 11 inch M2 2024
        seedDataProduct("iPad Air", "Ipad", 0.462, 13, 3, 3, "");

        //iPad Air 11 inch M2 2024 Wifi 128GB
        // màu tím
        seedDataVariant("iPad Air 11 inch M2 2024 Wifi 128GB", 22999000.0, 8, 32);

        seedDataVariantAtribute("Tím", 3, 95); // Thông tin hàng hóa - Màu sắc
        seedDataVariantAtribute("128 GB", 24, 95); // Dung lượng
        seedDataVariantAtribute("Việt Nam / Trung Quốc", 1, 95); // Xuất xứ
        seedDataVariantAtribute("05/2024", 2, 95); // Thời điểm ra mắt
        seedDataVariantAtribute("12", 4, 95); // Thời gian bảo hành (tháng)
        seedDataVariantAtribute("Để nơi khô ráo, nhẹ tay, dễ vỡ. Xem trong sách hướng dẫn sử dụng", 48, 95); // Hướng dẫn bảo quản và sử dụng
        seedDataVariantAtribute("247.6 x 178.5 x 6.1 mm", 5, 95); // Kích thước
        seedDataVariantAtribute("462 g", 6, 95); // Trọng lượng sản phẩm
        seedDataVariantAtribute("Vỏ máy: Nhôm tái chế", 7, 95); // Chất liệu
        seedDataVariantAtribute("Apple M2", 9, 95); // CPU Model
        seedDataVariantAtribute("8 - Core", 10, 95); // Loại CPU
        seedDataVariantAtribute("8", 11, 95); // Số nhân
        seedDataVariantAtribute("8 GB", 79, 95); // Dung lượng RAM
        seedDataVariantAtribute("11 inch", 14, 95); // Kích thước màn hình
        seedDataVariantAtribute("Liquid Retina", 15, 95); // Công nghệ màn hình
        seedDataVariantAtribute("2360 x 1640 Pixels", 17, 95); // Độ phân giải
        seedDataVariantAtribute("Liquid Retina", 16, 95); // Chuẩn màn hình
        seedDataVariantAtribute("500 nits", 20, 95); // Độ sáng
        seedDataVariantAtribute("Apple GPU 9 Nhân", 24, 95); // Chip đồ hoạ (GPU)
        seedDataVariantAtribute("Ultra Wide", 27, 95); // Camera Type 1
        seedDataVariantAtribute("12.0 MP", 28, 95); // Resolution (Camera 1)
        seedDataVariantAtribute("ƒ/1.8", 29, 95); // Aperture (Camera 1)
        seedDataVariantAtribute("FullHD 1080p@120fps, FullHD 1080p@30fps, FullHD 1080p@240fps, 4K 2160p@60fps, 4K 2160p@25fps, 4K 2160p@24fps, 4K 2160p@30fps, HD 720p@30fps, FullHD 1080p@25fps, FullHD 1080p@60fps", 30, 95); // Quay phim camera sau
        seedDataVariantAtribute("Single selfie camera", 32, 95); // Số Camera Selfie
        seedDataVariantAtribute("12.0 MP", 33, 95); // Resolution (Camera Selfie 1)
        seedDataVariantAtribute("ƒ/2.4", 34, 95); // Aperture (Camera Selfie 1)
        seedDataVariantAtribute("Quay phim FullHD", 34, 95); // Quay phim camera selfie
        seedDataVariantAtribute("Trôi nhanh thời gian (Time lapse), Chụp góc rộng (Wide)", 35, 95); // Tính năng camera selfie
        seedDataVariantAtribute("Cảm biến vân tay, Con quay hồi chuyển, Cảm biến gia tốc kế, Cảm biến khí áp kế, Cảm biến ánh sáng", 36, 95); // Cảm biến
        seedDataVariantAtribute("Mật khẩu", 37, 95); // Bảo mật
        seedDataVariantAtribute("5G", 39, 95); // Hỗ trợ mạng
        seedDataVariantAtribute("Cổng sạc: Type C", 41, 95); // Cổng giao tiếp
        seedDataVariantAtribute("Wifi 6E", 42, 95); // Wifi
        seedDataVariantAtribute("v5.3", 44, 95); // Bluetooth
        seedDataVariantAtribute("Lithium polymer", 47, 95); // Loại PIN
        seedDataVariantAtribute("28.93 Wh", 48, 95); // Dung lượng pin
        seedDataVariantAtribute("iPadOS", 49, 95); // OS
        seedDataVariantAtribute("iPadOS 17", 50, 95); // Version
        seedDataVariantAtribute("Dây cáp sạc, Củ sạc iPad", 57, 95); // Phụ kiện trong hộp

        // màu đen
        seedDataVariant("iPad Air 11 inch M2 2024 Wifi 128GB", 22999990.0, 8, 32);

        seedDataVariantAtribute("Đen", 3, 96); // Thông tin hàng hóa - Màu sắc
        seedDataVariantAtribute("128 GB", 24, 96); // Dung lượng
        seedDataVariantAtribute("Việt Nam / Trung Quốc", 1, 96); // Xuất xứ
        seedDataVariantAtribute("05/2024", 2, 96); // Thời điểm ra mắt
        seedDataVariantAtribute("12", 4, 96); // Thời gian bảo hành (tháng)
        seedDataVariantAtribute("Để nơi khô ráo, nhẹ tay, dễ vỡ. Xem trong sách hướng dẫn sử dụng", 48, 96); // Hướng dẫn bảo quản và sử dụng
        seedDataVariantAtribute("247.6 x 178.5 x 6.1 mm", 5, 96); // Kích thước
        seedDataVariantAtribute("462 g", 6, 96); // Trọng lượng sản phẩm
        seedDataVariantAtribute("Vỏ máy: Nhôm tái chế", 7, 96); // Chất liệu
        seedDataVariantAtribute("Apple M2", 9, 96); // CPU Model
        seedDataVariantAtribute("8 - Core", 10, 96); // Loại CPU
        seedDataVariantAtribute("8", 11, 96); // Số nhân
        seedDataVariantAtribute("8 GB", 79, 96); // Dung lượng RAM
        seedDataVariantAtribute("11 inch", 14, 96); // Kích thước màn hình
        seedDataVariantAtribute("Liquid Retina", 15, 96); // Công nghệ màn hình
        seedDataVariantAtribute("2360 x 1640 Pixels", 17, 96); // Độ phân giải
        seedDataVariantAtribute("Liquid Retina", 16, 96); // Chuẩn màn hình
        seedDataVariantAtribute("500 nits", 20, 96); // Độ sáng
        seedDataVariantAtribute("Apple GPU 9 Nhân", 24, 96); // Chip đồ hoạ (GPU)
        seedDataVariantAtribute("Ultra Wide", 27, 96); // Camera Type 1
        seedDataVariantAtribute("12.0 MP", 28, 96); // Resolution (Camera 1)
        seedDataVariantAtribute("ƒ/1.8", 29, 96); // Aperture (Camera 1)
        seedDataVariantAtribute("FullHD 1080p@120fps, FullHD 1080p@30fps, FullHD 1080p@240fps, 4K 2160p@60fps, 4K 2160p@25fps, 4K 2160p@24fps, 4K 2160p@30fps, HD 720p@30fps, FullHD 1080p@25fps, FullHD 1080p@60fps", 30, 96); // Quay phim camera sau
        seedDataVariantAtribute("Single selfie camera", 32, 96); // Số Camera Selfie
        seedDataVariantAtribute("12.0 MP", 33, 96); // Resolution (Camera Selfie 1)
        seedDataVariantAtribute("ƒ/2.4", 34, 96); // Aperture (Camera Selfie 1)
        seedDataVariantAtribute("Quay phim FullHD", 34, 96); // Quay phim camera selfie
        seedDataVariantAtribute("Trôi nhanh thời gian (Time lapse), Chụp góc rộng (Wide)", 35, 96); // Tính năng camera selfie
        seedDataVariantAtribute("Cảm biến vân tay, Con quay hồi chuyển, Cảm biến gia tốc kế, Cảm biến khí áp kế, Cảm biến ánh sáng", 36, 96); // Cảm biến
        seedDataVariantAtribute("Mật khẩu", 37, 96); // Bảo mật
        seedDataVariantAtribute("5G", 39, 96); // Hỗ trợ mạng
        seedDataVariantAtribute("Cổng sạc: Type C", 41, 96); // Cổng giao tiếp
        seedDataVariantAtribute("Wifi 6E", 42, 96); // Wifi
        seedDataVariantAtribute("v5.3", 44, 96); // Bluetooth
        seedDataVariantAtribute("Lithium polymer", 47, 96); // Loại PIN
        seedDataVariantAtribute("28.93 Wh", 48, 96); // Dung lượng pin
        seedDataVariantAtribute("iPadOS", 49, 96); // OS
        seedDataVariantAtribute("iPadOS 17", 50, 96); // Version
        seedDataVariantAtribute("Dây cáp sạc, Củ sạc iPad", 57, 96); // Phụ kiện trong hộp


        // màu trắng
        seedDataVariant("iPad Air 11 inch M2 2024 Wifi 128GB", 22999001.0, 8, 32);
        seedDataVariantAtribute("Trắng", 3, 97); // Thông tin hàng hóa - Màu sắc
        seedDataVariantAtribute("128 GB", 24, 97); // Dung lượng
        seedDataVariantAtribute("Việt Nam / Trung Quốc", 1, 97); // Xuất xứ
        seedDataVariantAtribute("05/2024", 2, 97); // Thời điểm ra mắt
        seedDataVariantAtribute("12", 4, 97); // Thời gian bảo hành (tháng)
        seedDataVariantAtribute("Để nơi khô ráo, nhẹ tay, dễ vỡ. Xem trong sách hướng dẫn sử dụng", 48, 97); // Hướng dẫn bảo quản và sử dụng
        seedDataVariantAtribute("247.6 x 178.5 x 6.1 mm", 5, 97); // Kích thước
        seedDataVariantAtribute("462 g", 6, 97); // Trọng lượng sản phẩm
        seedDataVariantAtribute("Vỏ máy: Nhôm tái chế", 7, 97); // Chất liệu
        seedDataVariantAtribute("Apple M2", 9, 97); // CPU Model
        seedDataVariantAtribute("8 - Core", 10, 97); // Loại CPU
        seedDataVariantAtribute("8", 11, 97); // Số nhân
        seedDataVariantAtribute("8 GB", 79, 97); // Dung lượng RAM
        seedDataVariantAtribute("11 inch", 14, 97); // Kích thước màn hình
        seedDataVariantAtribute("Liquid Retina", 15, 97); // Công nghệ màn hình
        seedDataVariantAtribute("2360 x 1640 Pixels", 17, 97); // Độ phân giải
        seedDataVariantAtribute("Liquid Retina", 16, 97); // Chuẩn màn hình
        seedDataVariantAtribute("500 nits", 20, 97); // Độ sáng
        seedDataVariantAtribute("Apple GPU 9 Nhân", 24, 97); // Chip đồ hoạ (GPU)
        seedDataVariantAtribute("Ultra Wide", 27, 97); // Camera Type 1
        seedDataVariantAtribute("12.0 MP", 28, 97); // Resolution (Camera 1)
        seedDataVariantAtribute("ƒ/1.8", 29, 97); // Aperture (Camera 1)
        seedDataVariantAtribute("FullHD 1080p@120fps, FullHD 1080p@30fps, FullHD 1080p@240fps, 4K 2160p@60fps, 4K 2160p@25fps, 4K 2160p@24fps, 4K 2160p@30fps, HD 720p@30fps, FullHD 1080p@25fps, FullHD 1080p@60fps", 30, 97); // Quay phim camera sau
        seedDataVariantAtribute("Single selfie camera", 32, 97); // Số Camera Selfie
        seedDataVariantAtribute("12.0 MP", 33, 97); // Resolution (Camera Selfie 1)
        seedDataVariantAtribute("ƒ/2.4", 34, 97); // Aperture (Camera Selfie 1)
        seedDataVariantAtribute("Quay phim FullHD", 34, 97); // Quay phim camera selfie
        seedDataVariantAtribute("Trôi nhanh thời gian (Time lapse), Chụp góc rộng (Wide)", 35, 97); // Tính năng camera selfie
        seedDataVariantAtribute("Cảm biến vân tay, Con quay hồi chuyển, Cảm biến gia tốc kế, Cảm biến khí áp kế, Cảm biến ánh sáng", 36, 97); // Cảm biến
        seedDataVariantAtribute("Mật khẩu", 37, 97); // Bảo mật
        seedDataVariantAtribute("5G", 39, 97); // Hỗ trợ mạng
        seedDataVariantAtribute("Cổng sạc: Type C", 41, 97); // Cổng giao tiếp
        seedDataVariantAtribute("Wifi 6E", 42, 97); // Wifi
        seedDataVariantAtribute("v5.3", 44, 97); // Bluetooth
        seedDataVariantAtribute("Lithium polymer", 47, 97); // Loại PIN
        seedDataVariantAtribute("28.93 Wh", 48, 97); // Dung lượng pin
        seedDataVariantAtribute("iPadOS", 49, 97); // OS
        seedDataVariantAtribute("iPadOS 17", 50, 97); // Version
        seedDataVariantAtribute("Dây cáp sạc, Củ sạc iPad", 57, 97); // Phụ kiện trong hộp

        //
        // màu tím
        seedDataVariant("iPad Air 11 inch M2 2024 Wifi 512GB", 26999002.0, 8, 32);

        seedDataVariantAtribute("Tím", 3, 98); // Thông tin hàng hóa - Màu sắc
        seedDataVariantAtribute("Việt Nam / Trung Quốc", 1, 98); // Xuất xứ
        seedDataVariantAtribute("05/2024", 2, 98); // Thời điểm ra mắt
        seedDataVariantAtribute("12", 4, 98); // Thời gian bảo hành (tháng)
        seedDataVariantAtribute("Để nơi khô ráo, nhẹ tay, dễ vỡ. Xem trong sách hướng dẫn sử dụng", 48, 98); // Hướng dẫn bảo quản và sử dụng
        seedDataVariantAtribute("247.6 x 178.5 x 6.1 mm", 5, 98); // Kích thước
        seedDataVariantAtribute("462 g", 6, 98); // Trọng lượng sản phẩm
        seedDataVariantAtribute("Vỏ máy: Nhôm tái chế", 7, 98); // Chất liệu
        seedDataVariantAtribute("Apple M2", 9, 98); // CPU Model
        seedDataVariantAtribute("8 - Core", 10, 98); // Loại CPU
        seedDataVariantAtribute("8", 11, 98); // Số nhân
        seedDataVariantAtribute("8 GB", 79, 98); // Dung lượng RAM
        seedDataVariantAtribute("11 inch", 14, 98); // Kích thước màn hình
        seedDataVariantAtribute("Liquid Retina", 15, 98); // Công nghệ màn hình
        seedDataVariantAtribute("2360 x 1640 Pixels", 17, 98); // Độ phân giải
        seedDataVariantAtribute("Liquid Retina", 16, 98); // Chuẩn màn hình
        seedDataVariantAtribute("500 nits", 20, 98); // Độ sáng
        seedDataVariantAtribute("Apple GPU 9 Nhân", 24, 98); // Chip đồ hoạ (GPU)
        seedDataVariantAtribute("Ultra Wide", 27, 98); // Camera Type 1
        seedDataVariantAtribute("12.0 MP", 28, 98); // Resolution (Camera 1)
        seedDataVariantAtribute("ƒ/1.8", 29, 98); // Aperture (Camera 1)
        seedDataVariantAtribute("FullHD 1080p@120fps, FullHD 1080p@30fps, FullHD 1080p@240fps, 4K 2160p@60fps, 4K 2160p@25fps, 4K 2160p@24fps, 4K 2160p@30fps, HD 720p@30fps, FullHD 1080p@25fps, FullHD 1080p@60fps", 30, 98); // Quay phim camera sau
        seedDataVariantAtribute("Single selfie camera", 32, 98); // Số Camera Selfie
        seedDataVariantAtribute("12.0 MP", 33, 98); // Resolution (Camera Selfie 1)
        seedDataVariantAtribute("ƒ/2.4", 34, 98); // Aperture (Camera Selfie 1)
        seedDataVariantAtribute("Quay phim FullHD", 34, 98); // Quay phim camera selfie
        seedDataVariantAtribute("Trôi nhanh thời gian (Time lapse), Chụp góc rộng (Wide)", 35, 98); // Tính năng camera selfie
        seedDataVariantAtribute("Cảm biến vân tay, Con quay hồi chuyển, Cảm biến gia tốc kế, Cảm biến khí áp kế, Cảm biến ánh sáng", 36, 98); // Cảm biến
        seedDataVariantAtribute("Mật khẩu", 37, 98); // Bảo mật
        seedDataVariantAtribute("5G", 39, 98); // Hỗ trợ mạng
        seedDataVariantAtribute("Cổng sạc: Type C", 41, 98); // Cổng giao tiếp
        seedDataVariantAtribute("Wifi 6E", 42, 98); // Wifi
        seedDataVariantAtribute("v5.3", 44, 98); // Bluetooth
        seedDataVariantAtribute("Lithium polymer", 47, 98); // Loại PIN
        seedDataVariantAtribute("28.93 Wh", 48, 98); // Dung lượng pin
        seedDataVariantAtribute("iPadOS", 49, 98); // OS
        seedDataVariantAtribute("iPadOS 17", 50, 98); // Version
        seedDataVariantAtribute("Dây cáp sạc, Củ sạc iPad", 57, 98); // Phụ kiện trong hộp

        // màu đen
        seedDataVariant("iPad Air 11 inch M2 2024 Wifi 512GB", 26999993.0, 8, 32);

        seedDataVariantAtribute("Đen", 3, 99); // Thông tin hàng hóa - Màu sắc
        seedDataVariantAtribute("512 GB", 24, 99); // Dung lượng
        seedDataVariantAtribute("Việt Nam / Trung Quốc", 1, 99); // Xuất xứ
        seedDataVariantAtribute("05/2024", 2, 99); // Thời điểm ra mắt
        seedDataVariantAtribute("12", 4, 99); // Thời gian bảo hành (tháng)
        seedDataVariantAtribute("Để nơi khô ráo, nhẹ tay, dễ vỡ. Xem trong sách hướng dẫn sử dụng", 48, 99); // Hướng dẫn bảo quản và sử dụng
        seedDataVariantAtribute("247.6 x 178.5 x 6.1 mm", 5, 99); // Kích thước
        seedDataVariantAtribute("462 g", 6, 99); // Trọng lượng sản phẩm
        seedDataVariantAtribute("Vỏ máy: Nhôm tái chế", 7, 99); // Chất liệu
        seedDataVariantAtribute("Apple M2", 9, 99); // CPU Model
        seedDataVariantAtribute("8 - Core", 10, 99); // Loại CPU
        seedDataVariantAtribute("8", 11, 99); // Số nhân
        seedDataVariantAtribute("8 GB", 79, 99); // Dung lượng RAM
        seedDataVariantAtribute("11 inch", 14, 99); // Kích thước màn hình
        seedDataVariantAtribute("Liquid Retina", 15, 99); // Công nghệ màn hình
        seedDataVariantAtribute("2360 x 1640 Pixels", 17, 99); // Độ phân giải
        seedDataVariantAtribute("Liquid Retina", 16, 99); // Chuẩn màn hình
        seedDataVariantAtribute("500 nits", 20, 98); // Độ sáng
        seedDataVariantAtribute("Apple GPU 9 Nhân", 24, 99); // Chip đồ hoạ (GPU)
        seedDataVariantAtribute("Ultra Wide", 27, 99); // Camera Type 1
        seedDataVariantAtribute("12.0 MP", 28, 99); // Resolution (Camera 1)
        seedDataVariantAtribute("ƒ/1.8", 29, 99); // Aperture (Camera 1)
        seedDataVariantAtribute("FullHD 1080p@120fps, FullHD 1080p@30fps, FullHD 1080p@240fps, 4K 2160p@60fps, 4K 2160p@25fps, 4K 2160p@24fps, 4K 2160p@30fps, HD 720p@30fps, FullHD 1080p@25fps, FullHD 1080p@60fps", 30, 99); // Quay phim camera sau
        seedDataVariantAtribute("Single selfie camera", 32, 99); // Số Camera Selfie
        seedDataVariantAtribute("12.0 MP", 33, 99); // Resolution (Camera Selfie 1)
        seedDataVariantAtribute("ƒ/2.4", 34, 99); // Aperture (Camera Selfie 1)
        seedDataVariantAtribute("Quay phim FullHD", 34, 99); // Quay phim camera selfie
        seedDataVariantAtribute("Trôi nhanh thời gian (Time lapse), Chụp góc rộng (Wide)", 35, 99); // Tính năng camera selfie
        seedDataVariantAtribute("Cảm biến vân tay, Con quay hồi chuyển, Cảm biến gia tốc kế, Cảm biến khí áp kế, Cảm biến ánh sáng", 36, 99); // Cảm biến
        seedDataVariantAtribute("Mật khẩu", 37, 99); // Bảo mật
        seedDataVariantAtribute("5G", 39, 99); // Hỗ trợ mạng
        seedDataVariantAtribute("Cổng sạc: Type C", 41, 99); // Cổng giao tiếp
        seedDataVariantAtribute("Wifi 6E", 42, 99); // Wifi
        seedDataVariantAtribute("v5.3", 44, 99); // Bluetooth
        seedDataVariantAtribute("Lithium polymer", 47, 99); // Loại PIN
        seedDataVariantAtribute("28.93 Wh", 48, 99); // Dung lượng pin
        seedDataVariantAtribute("iPadOS", 49, 99); // OS
        seedDataVariantAtribute("iPadOS 17", 50, 99); // Version
        seedDataVariantAtribute("Dây cáp sạc, Củ sạc iPad", 57, 99); // Phụ kiện trong hộp


        // màu trắng
        seedDataVariant("iPad Air 11 inch M2 2024 Wifi 512GB", 26999004.0, 8, 32);
        seedDataVariantAtribute("Trắng", 3, 100); // Thông tin hàng hóa - Màu sắc
        seedDataVariantAtribute("512 GB", 24, 100); // Dung lượng
        seedDataVariantAtribute("Việt Nam / Trung Quốc", 1, 100); // Xuất xứ
        seedDataVariantAtribute("05/2024", 2, 100); // Thời điểm ra mắt
        seedDataVariantAtribute("12", 4, 100); // Thời gian bảo hành (tháng)
        seedDataVariantAtribute("Để nơi khô ráo, nhẹ tay, dễ vỡ. Xem trong sách hướng dẫn sử dụng", 48, 100); // Hướng dẫn bảo quản và sử dụng
        seedDataVariantAtribute("247.6 x 178.5 x 6.1 mm", 5, 100); // Kích thước
        seedDataVariantAtribute("462 g", 6, 100); // Trọng lượng sản phẩm
        seedDataVariantAtribute("Vỏ máy: Nhôm tái chế", 7, 100); // Chất liệu
        seedDataVariantAtribute("Apple M2", 9, 100); // CPU Model
        seedDataVariantAtribute("8 - Core", 10, 100); // Loại CPU
        seedDataVariantAtribute("8", 11, 100); // Số nhân
        seedDataVariantAtribute("8 GB", 79, 100); // Dung lượng RAM
        seedDataVariantAtribute("11 inch", 14, 100); // Kích thước màn hình
        seedDataVariantAtribute("Liquid Retina", 15, 100); // Công nghệ màn hình
        seedDataVariantAtribute("2360 x 1640 Pixels", 17, 100); // Độ phân giải
        seedDataVariantAtribute("Liquid Retina", 16, 100); // Chuẩn màn hình
        seedDataVariantAtribute("500 nits", 20, 100); // Độ sáng
        seedDataVariantAtribute("Apple GPU 9 Nhân", 24, 100); // Chip đồ hoạ (GPU)
        seedDataVariantAtribute("Ultra Wide", 27, 100); // Camera Type 1
        seedDataVariantAtribute("12.0 MP", 28, 100); // Resolution (Camera 1)
        seedDataVariantAtribute("ƒ/1.8", 29, 100); // Aperture (Camera 1)
        seedDataVariantAtribute("FullHD 1080p@120fps, FullHD 1080p@30fps, FullHD 1080p@240fps, 4K 2160p@60fps, 4K 2160p@25fps, 4K 2160p@24fps, 4K 2160p@30fps, HD 720p@30fps, FullHD 1080p@25fps, FullHD 1080p@60fps", 30, 100); // Quay phim camera sau
        seedDataVariantAtribute("Single selfie camera", 32, 100); // Số Camera Selfie
        seedDataVariantAtribute("12.0 MP", 33, 100); // Resolution (Camera Selfie 1)
        seedDataVariantAtribute("ƒ/2.4", 34, 100); // Aperture (Camera Selfie 1)
        seedDataVariantAtribute("Quay phim FullHD", 34, 100); // Quay phim camera selfie
        seedDataVariantAtribute("Trôi nhanh thời gian (Time lapse), Chụp góc rộng (Wide)", 35, 100); // Tính năng camera selfie
        seedDataVariantAtribute("Cảm biến vân tay, Con quay hồi chuyển, Cảm biến gia tốc kế, Cảm biến khí áp kế, Cảm biến ánh sáng", 36, 100); // Cảm biến
        seedDataVariantAtribute("Mật khẩu", 37, 100); // Bảo mật
        seedDataVariantAtribute("5G", 39, 100); // Hỗ trợ mạng
        seedDataVariantAtribute("Cổng sạc: Type C", 41, 100); // Cổng giao tiếp
        seedDataVariantAtribute("Wifi 6E", 42, 100); // Wifi
        seedDataVariantAtribute("v5.3", 44, 100); // Bluetooth
        seedDataVariantAtribute("Lithium polymer", 47, 100); // Loại PIN
        seedDataVariantAtribute("28.93 Wh", 48, 100); // Dung lượng pin
        seedDataVariantAtribute("iPadOS", 49, 100); // OS
        seedDataVariantAtribute("iPadOS 17", 50, 100); // Version
        seedDataVariantAtribute("Dây cáp sạc, Củ sạc iPad", 57, 100); // Phụ kiện trong hộp

        // màu tím
        seedDataVariant("iPad Air 11 inch M2 2024 Wifi 1TB", 28999002.0, 8, 32);

        seedDataVariantAtribute("Tím", 3, 101); // Thông tin hàng hóa - Màu sắc
        seedDataVariantAtribute("1TB", 24, 101); // Dung lượng
        seedDataVariantAtribute("Việt Nam / Trung Quốc", 1, 101); // Xuất xứ
        seedDataVariantAtribute("05/2024", 2, 101); // Thời điểm ra mắt
        seedDataVariantAtribute("12", 4, 101); // Thời gian bảo hành (tháng)
        seedDataVariantAtribute("Để nơi khô ráo, nhẹ tay, dễ vỡ. Xem trong sách hướng dẫn sử dụng", 48, 101); // Hướng dẫn bảo quản và sử dụng
        seedDataVariantAtribute("247.6 x 178.5 x 6.1 mm", 5, 101); // Kích thước
        seedDataVariantAtribute("462 g", 6, 101); // Trọng lượng sản phẩm
        seedDataVariantAtribute("Vỏ máy: Nhôm tái chế", 7, 101); // Chất liệu
        seedDataVariantAtribute("Apple M2", 9, 101); // CPU Model
        seedDataVariantAtribute("8 - Core", 10, 101); // Loại CPU
        seedDataVariantAtribute("8", 11, 101); // Số nhân
        seedDataVariantAtribute("8 GB", 79, 101); // Dung lượng RAM
        seedDataVariantAtribute("11 inch", 14, 101); // Kích thước màn hình
        seedDataVariantAtribute("Liquid Retina", 15, 101); // Công nghệ màn hình
        seedDataVariantAtribute("2360 x 1640 Pixels", 17, 101); // Độ phân giải
        seedDataVariantAtribute("Liquid Retina", 16, 101); // Chuẩn màn hình
        seedDataVariantAtribute("500 nits", 20, 101); // Độ sáng
        seedDataVariantAtribute("Apple GPU 9 Nhân", 24, 101); // Chip đồ hoạ (GPU)
        seedDataVariantAtribute("Ultra Wide", 27, 101); // Camera Type 1
        seedDataVariantAtribute("12.0 MP", 28, 101); // Resolution (Camera 1)
        seedDataVariantAtribute("ƒ/1.8", 29, 101); // Aperture (Camera 1)
        seedDataVariantAtribute("FullHD 1080p@120fps, FullHD 1080p@30fps, FullHD 1080p@240fps, 4K 2160p@60fps, 4K 2160p@25fps, 4K 2160p@24fps, 4K 2160p@30fps, HD 720p@30fps, FullHD 1080p@25fps, FullHD 1080p@60fps", 30, 101); // Quay phim camera sau
        seedDataVariantAtribute("Single selfie camera", 32, 101); // Số Camera Selfie
        seedDataVariantAtribute("12.0 MP", 33, 101); // Resolution (Camera Selfie 1)
        seedDataVariantAtribute("ƒ/2.4", 34, 101); // Aperture (Camera Selfie 1)
        seedDataVariantAtribute("Quay phim FullHD", 34, 101); // Quay phim camera selfie
        seedDataVariantAtribute("Trôi nhanh thời gian (Time lapse), Chụp góc rộng (Wide)", 35, 101); // Tính năng camera selfie
        seedDataVariantAtribute("Cảm biến vân tay, Con quay hồi chuyển, Cảm biến gia tốc kế, Cảm biến khí áp kế, Cảm biến ánh sáng", 36, 101); // Cảm biến
        seedDataVariantAtribute("Mật khẩu", 37, 101); // Bảo mật
        seedDataVariantAtribute("5G", 39, 101); // Hỗ trợ mạng
        seedDataVariantAtribute("Cổng sạc: Type C", 41, 101); // Cổng giao tiếp
        seedDataVariantAtribute("Wifi 6E", 42, 101); // Wifi
        seedDataVariantAtribute("v5.3", 44, 101); // Bluetooth
        seedDataVariantAtribute("Lithium polymer", 47, 101); // Loại PIN
        seedDataVariantAtribute("28.93 Wh", 48, 101); // Dung lượng pin
        seedDataVariantAtribute("iPadOS", 49, 101); // OS
        seedDataVariantAtribute("iPadOS 17", 50, 101); // Version
        seedDataVariantAtribute("Dây cáp sạc, Củ sạc iPad", 57, 101); // Phụ kiện trong hộp

        // màu đen
        seedDataVariant("iPad Air 11 inch M2 2024 Wifi 1TB", 28999993.0, 8, 32);

        seedDataVariantAtribute("Đen", 3, 102); // Thông tin hàng hóa - Màu sắc
        seedDataVariantAtribute("1TB", 24, 102); // Dung lượng
        seedDataVariantAtribute("Việt Nam / Trung Quốc", 1, 102); // Xuất xứ
        seedDataVariantAtribute("05/2024", 2, 102); // Thời điểm ra mắt
        seedDataVariantAtribute("12", 4, 102); // Thời gian bảo hành (tháng)
        seedDataVariantAtribute("Để nơi khô ráo, nhẹ tay, dễ vỡ. Xem trong sách hướng dẫn sử dụng", 48, 102); // Hướng dẫn bảo quản và sử dụng
        seedDataVariantAtribute("247.6 x 178.5 x 6.1 mm", 5, 102); // Kích thước
        seedDataVariantAtribute("462 g", 6, 102); // Trọng lượng sản phẩm
        seedDataVariantAtribute("Vỏ máy: Nhôm tái chế", 7, 102); // Chất liệu
        seedDataVariantAtribute("Apple M2", 9, 102); // CPU Model
        seedDataVariantAtribute("8 - Core", 10, 102); // Loại CPU
        seedDataVariantAtribute("8", 11, 102); // Số nhân
        seedDataVariantAtribute("8 GB", 79, 102); // Dung lượng RAM
        seedDataVariantAtribute("11 inch", 14, 102); // Kích thước màn hình
        seedDataVariantAtribute("Liquid Retina", 15, 102); // Công nghệ màn hình
        seedDataVariantAtribute("2360 x 1640 Pixels", 17, 102); // Độ phân giải
        seedDataVariantAtribute("Liquid Retina", 16, 102); // Chuẩn màn hình
        seedDataVariantAtribute("500 nits", 20, 102); // Độ sáng
        seedDataVariantAtribute("Apple GPU 9 Nhân", 24, 102); // Chip đồ hoạ (GPU)
        seedDataVariantAtribute("Ultra Wide", 27, 102); // Camera Type 1
        seedDataVariantAtribute("12.0 MP", 28, 102); // Resolution (Camera 1)
        seedDataVariantAtribute("ƒ/1.8", 29, 102); // Aperture (Camera 1)
        seedDataVariantAtribute("FullHD 1080p@120fps, FullHD 1080p@30fps, FullHD 1080p@240fps, 4K 2160p@60fps, 4K 2160p@25fps, 4K 2160p@24fps, 4K 2160p@30fps, HD 720p@30fps, FullHD 1080p@25fps, FullHD 1080p@60fps", 30, 102); // Quay phim camera sau
        seedDataVariantAtribute("Single selfie camera", 32, 102); // Số Camera Selfie
        seedDataVariantAtribute("12.0 MP", 33, 102); // Resolution (Camera Selfie 1)
        seedDataVariantAtribute("ƒ/2.4", 34, 102); // Aperture (Camera Selfie 1)
        seedDataVariantAtribute("Quay phim FullHD", 34, 102); // Quay phim camera selfie
        seedDataVariantAtribute("Trôi nhanh thời gian (Time lapse), Chụp góc rộng (Wide)", 35, 102); // Tính năng camera selfie
        seedDataVariantAtribute("Cảm biến vân tay, Con quay hồi chuyển, Cảm biến gia tốc kế, Cảm biến khí áp kế, Cảm biến ánh sáng", 36, 102); // Cảm biến
        seedDataVariantAtribute("Mật khẩu", 37, 102); // Bảo mật
        seedDataVariantAtribute("5G", 39, 102); // Hỗ trợ mạng
        seedDataVariantAtribute("Cổng sạc: Type C", 41, 102); // Cổng giao tiếp
        seedDataVariantAtribute("Wifi 6E", 42, 102); // Wifi
        seedDataVariantAtribute("v5.3", 44, 102); // Bluetooth
        seedDataVariantAtribute("Lithium polymer", 47, 102); // Loại PIN
        seedDataVariantAtribute("28.93 Wh", 48, 102); // Dung lượng pin
        seedDataVariantAtribute("iPadOS", 49, 102); // OS
        seedDataVariantAtribute("iPadOS 17", 50, 102); // Version
        seedDataVariantAtribute("Dây cáp sạc, Củ sạc iPad", 57, 102); // Phụ kiện trong hộp

        // màu trắng
        seedDataVariant("iPad Air 11 inch M2 2024 Wifi 1TB", 28999004.0, 8, 32);
        seedDataVariantAtribute("Trắng", 3, 103); // Thông tin hàng hóa - Màu sắc
        seedDataVariantAtribute("1TB", 24, 103); // Dung lượng
        seedDataVariantAtribute("Việt Nam / Trung Quốc", 1, 103); // Xuất xứ
        seedDataVariantAtribute("05/2024", 2, 103); // Thời điểm ra mắt
        seedDataVariantAtribute("12", 4, 103); // Thời gian bảo hành (tháng)
        seedDataVariantAtribute("Để nơi khô ráo, nhẹ tay, dễ vỡ. Xem trong sách hướng dẫn sử dụng", 48, 103); // Hướng dẫn bảo quản và sử dụng
        seedDataVariantAtribute("247.6 x 178.5 x 6.1 mm", 5, 103); // Kích thước
        seedDataVariantAtribute("462 g", 6, 103); // Trọng lượng sản phẩm
        seedDataVariantAtribute("Vỏ máy: Nhôm tái chế", 7, 103); // Chất liệu
        seedDataVariantAtribute("Apple M2", 9, 103); // CPU Model
        seedDataVariantAtribute("8 - Core", 10, 103); // Loại CPU
        seedDataVariantAtribute("8", 11, 103); // Số nhân
        seedDataVariantAtribute("8 GB", 79, 103); // Dung lượng RAM
        seedDataVariantAtribute("11 inch", 14, 103); // Kích thước màn hình
        seedDataVariantAtribute("Liquid Retina", 15, 103); // Công nghệ màn hình
        seedDataVariantAtribute("2360 x 1640 Pixels", 17, 103); // Độ phân giải
        seedDataVariantAtribute("Liquid Retina", 16, 103); // Chuẩn màn hình
        seedDataVariantAtribute("500 nits", 20, 103); // Độ sáng
        seedDataVariantAtribute("Apple GPU 9 Nhân", 24, 103); // Chip đồ hoạ (GPU)
        seedDataVariantAtribute("Ultra Wide", 27, 103); // Camera Type 1
        seedDataVariantAtribute("12.0 MP", 28, 103); // Resolution (Camera 1)
        seedDataVariantAtribute("ƒ/1.8", 29, 103); // Aperture (Camera 1)
        seedDataVariantAtribute("FullHD 1080p@120fps, FullHD 1080p@30fps, FullHD 1080p@240fps, 4K 2160p@60fps, 4K 2160p@25fps, 4K 2160p@24fps, 4K 2160p@30fps, HD 720p@30fps, FullHD 1080p@25fps, FullHD 1080p@60fps", 30, 103); // Quay phim camera sau
        seedDataVariantAtribute("Single selfie camera", 32, 103); // Số Camera Selfie
        seedDataVariantAtribute("12.0 MP", 33, 103); // Resolution (Camera Selfie 1)
        seedDataVariantAtribute("ƒ/2.4", 34, 103); // Aperture (Camera Selfie 1)
        seedDataVariantAtribute("Quay phim FullHD", 34, 103); // Quay phim camera selfie
        seedDataVariantAtribute("Trôi nhanh thời gian (Time lapse), Chụp góc rộng (Wide)", 35, 103); // Tính năng camera selfie
        seedDataVariantAtribute("Cảm biến vân tay, Con quay hồi chuyển, Cảm biến gia tốc kế, Cảm biến khí áp kế, Cảm biến ánh sáng", 36, 103); // Cảm biến
        seedDataVariantAtribute("Mật khẩu", 37, 103); // Bảo mật
        seedDataVariantAtribute("5G", 39, 103); // Hỗ trợ mạng
        seedDataVariantAtribute("Cổng sạc: Type C", 41, 103); // Cổng giao tiếp
        seedDataVariantAtribute("Wifi 6E", 42, 103); // Wifi
        seedDataVariantAtribute("v5.3", 44, 103); // Bluetooth
        seedDataVariantAtribute("Lithium polymer", 47, 103); // Loại PIN
        seedDataVariantAtribute("28.93 Wh", 48, 103); // Dung lượng pin
        seedDataVariantAtribute("iPadOS", 49, 103); // OS
        seedDataVariantAtribute("iPadOS 17", 50, 103); // Version
        seedDataVariantAtribute("Dây cáp sạc, Củ sạc iPad", 57, 103); // Phụ kiện trong hộp

        // màu trắng
        // iPad Air 13 inch M2 2024 Wifi 128GB

        seedDataVariant("iPad Air 13 inch M2 2024 Wifi 128GB", 22999005.0, 8, 32);
        seedDataVariantAtribute("Trắng", 3, 104); // Thông tin hàng hóa - Màu sắc
        seedDataVariantAtribute("1TB", 24, 104); // Dung lượng
        seedDataVariantAtribute("Việt Nam / Trung Quốc", 1, 104); // Xuất xứ
        seedDataVariantAtribute("05/2024", 2, 104); // Thời điểm ra mắt
        seedDataVariantAtribute("12", 4, 104); // Thời gian bảo hành (tháng)
        seedDataVariantAtribute("Để nơi khô ráo, nhẹ tay, dễ vỡ. Xem trong sách hướng dẫn sử dụng", 48, 104); // Hướng dẫn bảo quản và sử dụng
        seedDataVariantAtribute("280.6 x 214.9 x 6.1 mm", 5, 104); // Kích thước
        seedDataVariantAtribute("617 g", 6, 104); // Trọng lượng sản phẩm
        seedDataVariantAtribute("Vỏ máy: Nhôm tái chế", 7, 104); // Chất liệu
        seedDataVariantAtribute("Apple M2", 9, 104); // CPU Model
        seedDataVariantAtribute("8 - Core", 10, 104); // Loại CPU
        seedDataVariantAtribute("Apple M2 8 nhân", 10, 104); // CPU
        seedDataVariantAtribute("8", 11, 104); // Số nhân
        seedDataVariantAtribute("8 GB", 79, 104); // Dung lượng RAM
        seedDataVariantAtribute("13 inch", 14, 104); // Kích thước màn hình
        seedDataVariantAtribute("2732 x 2048 Pixels", 17, 104); // Độ phân giải
        seedDataVariantAtribute("Liquid Retina", 16, 104); // Chuẩn màn hình
        seedDataVariantAtribute("600 nits", 20, 104); // Độ sáng
        seedDataVariantAtribute("Apple GPU 9 Nhân", 24, 104); // Chip đồ hoạ (GPU)
        seedDataVariantAtribute("Single rear camera", 27, 104); // Số camera sau
        seedDataVariantAtribute("Ultra Wide", 27, 104); // Camera Type 1
        seedDataVariantAtribute("12.0 MP", 28, 104); // Resolution (Camera 1)
        seedDataVariantAtribute("ƒ/2.4", 29, 104); // Aperture (Camera 1)
        seedDataVariantAtribute("4K 2160p@30fps, HD 720p@30fps, FullHD 1080p@60fps, FullHD 1080p@30fps, FullHD 1080p@25fps, FullHD 1080p@240fps, FullHD 1080p@120fps, 4K 2160p@60fps, 4K 2160p@25fps, 4K 2160p@24fps", 30, 104); // Quay phim camera sau
        seedDataVariantAtribute("Single selfie camera", 32, 104); // Số Camera Selfie
        seedDataVariantAtribute("12.0 MP", 33, 104); // Resolution (Camera Selfie 1)
        seedDataVariantAtribute("ƒ/2.4", 34, 104); // Aperture (Camera Selfie 1)
        seedDataVariantAtribute("Quay phim FullHD", 34, 104); // Quay phim camera selfie
        seedDataVariantAtribute("Trôi nhanh thời gian (Time lapse), Chụp góc rộng (Wide)", 35, 104); // Tính năng camera selfie
        seedDataVariantAtribute("Cảm biến vân tay, Con quay hồi chuyển, Cảm biến gia tốc kế, Cảm biến khí áp kế, Cảm biến ánh sáng", 36, 104); // Cảm biến
        seedDataVariantAtribute("Mật khẩu", 37, 104); // Bảo mật
        seedDataVariantAtribute("5G", 39, 104); // Hỗ trợ mạng
        seedDataVariantAtribute("Type C", 41, 104); // Cổng giao tiếp
        seedDataVariantAtribute("Wifi 6E", 42, 104); // Wifi
        seedDataVariantAtribute("v5.3", 44, 104); // Bluetooth
        seedDataVariantAtribute("Lithium polymer", 47, 104); // Loại PIN
        seedDataVariantAtribute("36.59 Wh", 48, 104); // Dung lượng pin
        seedDataVariantAtribute("iPadOS", 49, 104); // OS
        seedDataVariantAtribute("iPadOS 17", 50, 104); // Version
        seedDataVariantAtribute("Dây cáp sạc, Củ sạc iPad", 57, 104); // Phụ kiện trong hộp

        // màu xám
        seedDataVariant("iPad Air 13 inch M2 2024 Wifi 128GB", 22999006.0, 8, 32);
        seedDataVariantAtribute("Xám", 3, 105); // Thông tin hàng hóa - Màu sắc
        seedDataVariantAtribute("Việt Nam / Trung Quốc", 1, 105); // Xuất xứ
        seedDataVariantAtribute("05/2024", 2, 105); // Thời điểm ra mắt
        seedDataVariantAtribute("12", 4, 105); // Thời gian bảo hành (tháng)
        seedDataVariantAtribute("Để nơi khô ráo, nhẹ tay, dễ vỡ. Xem trong sách hướng dẫn sử dụng", 48, 105); // Hướng dẫn bảo quản và sử dụng
        seedDataVariantAtribute("280.6 x 214.9 x 6.1 mm", 5, 105); // Kích thước
        seedDataVariantAtribute("617 g", 6, 105); // Trọng lượng sản phẩm
        seedDataVariantAtribute("Vỏ máy: Nhôm tái chế", 7, 105); // Chất liệu
        seedDataVariantAtribute("Apple M2", 9, 105); // CPU Model
        seedDataVariantAtribute("8 - Core", 10, 105); // Loại CPU
        seedDataVariantAtribute("Apple M2 8 nhân", 10, 105); // CPU
        seedDataVariantAtribute("8", 11, 105); // Số nhân
        seedDataVariantAtribute("8 GB", 79, 105); // Dung lượng RAM
        seedDataVariantAtribute("13 inch", 14, 105); // Kích thước màn hình
        seedDataVariantAtribute("2732 x 2048 Pixels", 17, 105); // Độ phân giải
        seedDataVariantAtribute("Liquid Retina", 16, 105); // Chuẩn màn hình
        seedDataVariantAtribute("600 nits", 20, 105); // Độ sáng
        seedDataVariantAtribute("Apple GPU 9 Nhân", 24, 105); // Chip đồ hoạ (GPU)
        seedDataVariantAtribute("Single rear camera", 27, 105); // Số camera sau
        seedDataVariantAtribute("Ultra Wide", 27, 105); // Camera Type 1
        seedDataVariantAtribute("12.0 MP", 28, 105); // Resolution (Camera 1)
        seedDataVariantAtribute("ƒ/2.4", 29, 105); // Aperture (Camera 1)
        seedDataVariantAtribute("4K 2160p@30fps, HD 720p@30fps, FullHD 1080p@60fps, FullHD 1080p@30fps, FullHD 1080p@25fps, FullHD 1080p@240fps, FullHD 1080p@120fps, 4K 2160p@60fps, 4K 2160p@25fps, 4K 2160p@24fps", 30, 105); // Quay phim camera sau
        seedDataVariantAtribute("Single selfie camera", 32, 105); // Số Camera Selfie
        seedDataVariantAtribute("12.0 MP", 33, 105); // Resolution (Camera Selfie 1)
        seedDataVariantAtribute("ƒ/2.4", 34, 105); // Aperture (Camera Selfie 1)
        seedDataVariantAtribute("Quay phim FullHD", 34, 105); // Quay phim camera selfie
        seedDataVariantAtribute("Trôi nhanh thời gian (Time lapse), Chụp góc rộng (Wide)", 35, 105); // Tính năng camera selfie
        seedDataVariantAtribute("Cảm biến vân tay, Con quay hồi chuyển, Cảm biến gia tốc kế, Cảm biến khí áp kế, Cảm biến ánh sáng", 36, 105); // Cảm biến
        seedDataVariantAtribute("Mật khẩu", 37, 105); // Bảo mật
        seedDataVariantAtribute("5G", 39, 105); // Hỗ trợ mạng
        seedDataVariantAtribute("Type C", 41, 105); // Cổng giao tiếp
        seedDataVariantAtribute("Wifi 6E", 42, 105); // Wifi
        seedDataVariantAtribute("v5.3", 44, 105); // Bluetooth
        seedDataVariantAtribute("Lithium polymer", 47, 105); // Loại PIN
        seedDataVariantAtribute("36.59 Wh", 48, 105); // Dung lượng pin
        seedDataVariantAtribute("iPadOS", 49, 105); // OS
        seedDataVariantAtribute("iPadOS 17", 50, 105); // Version
        seedDataVariantAtribute("Dây cáp sạc, Củ sạc iPad", 57, 105); // Phụ kiện trong hộp

        // màu trắng
        seedDataVariant("iPad Air 13 inch M2 2024 Wifi 512GB", 26999007.0, 8, 32);
        seedDataVariantAtribute("Trắng", 3, 106); // Thông tin hàng hóa - Màu sắc
        seedDataVariantAtribute("Việt Nam / Trung Quốc", 1, 106); // Xuất xứ
        seedDataVariantAtribute("05/2024", 2, 106); // Thời điểm ra mắt
        seedDataVariantAtribute("12", 4, 106); // Thời gian bảo hành (tháng)
        seedDataVariantAtribute("Để nơi khô ráo, nhẹ tay, dễ vỡ. Xem trong sách hướng dẫn sử dụng", 48, 106); // Hướng dẫn bảo quản và sử dụng
        seedDataVariantAtribute("280.6 x 214.9 x 6.1 mm", 5, 106); // Kích thước
        seedDataVariantAtribute("617 g", 6, 106); // Trọng lượng sản phẩm
        seedDataVariantAtribute("Vỏ máy: Nhôm tái chế", 7, 106); // Chất liệu
        seedDataVariantAtribute("Apple M2", 9, 106); // CPU Model
        seedDataVariantAtribute("8 - Core", 10, 106); // Loại CPU
        seedDataVariantAtribute("Apple M2 8 nhân", 10, 106); // CPU
        seedDataVariantAtribute("8", 11, 106); // Số nhân
        seedDataVariantAtribute("8 GB", 79, 106); // Dung lượng RAM
        seedDataVariantAtribute("13 inch", 14, 106); // Kích thước màn hình
        seedDataVariantAtribute("2732 x 2048 Pixels", 17, 106); // Độ phân giải
        seedDataVariantAtribute("Liquid Retina", 16, 106); // Chuẩn màn hình
        seedDataVariantAtribute("600 nits", 20, 106); // Độ sáng
        seedDataVariantAtribute("Apple GPU 9 Nhân", 24, 106); // Chip đồ hoạ (GPU)
        seedDataVariantAtribute("Single rear camera", 27, 106); // Số camera sau
        seedDataVariantAtribute("Ultra Wide", 27, 106); // Camera Type 1
        seedDataVariantAtribute("12.0 MP", 28, 106); // Resolution (Camera 1)
        seedDataVariantAtribute("ƒ/2.4", 29, 106); // Aperture (Camera 1)
        seedDataVariantAtribute("4K 2160p@30fps, HD 720p@30fps, FullHD 1080p@60fps, FullHD 1080p@30fps, FullHD 1080p@25fps, FullHD 1080p@240fps, FullHD 1080p@120fps, 4K 2160p@60fps, 4K 2160p@25fps, 4K 2160p@24fps", 30, 106); // Quay phim camera sau
        seedDataVariantAtribute("Single selfie camera", 32, 106); // Số Camera Selfie
        seedDataVariantAtribute("12.0 MP", 33, 106); // Resolution (Camera Selfie 1)
        seedDataVariantAtribute("ƒ/2.4", 34, 106); // Aperture (Camera Selfie 1)
        seedDataVariantAtribute("Quay phim FullHD", 34, 106); // Quay phim camera selfie
        seedDataVariantAtribute("Trôi nhanh thời gian (Time lapse), Chụp góc rộng (Wide)", 35, 106); // Tính năng camera selfie
        seedDataVariantAtribute("Cảm biến vân tay, Con quay hồi chuyển, Cảm biến gia tốc kế, Cảm biến khí áp kế, Cảm biến ánh sáng", 36, 106); // Cảm biến
        seedDataVariantAtribute("Mật khẩu", 37, 106); // Bảo mật
        seedDataVariantAtribute("5G", 39, 106); // Hỗ trợ mạng
        seedDataVariantAtribute("Type C", 41, 106); // Cổng giao tiếp
        seedDataVariantAtribute("Wifi 6E", 42, 106); // Wifi
        seedDataVariantAtribute("v5.3", 44, 106); // Bluetooth
        seedDataVariantAtribute("Lithium polymer", 47, 106); // Loại PIN
        seedDataVariantAtribute("36.59 Wh", 48, 106); // Dung lượng pin
        seedDataVariantAtribute("iPadOS", 49, 106); // OS
        seedDataVariantAtribute("iPadOS 17", 50, 106); // Version
        seedDataVariantAtribute("Dây cáp sạc, Củ sạc iPad", 57, 106); // Phụ kiện trong hộp

        // màu xám
        seedDataVariant("iPad Air 13 inch M2 2024 Wifi 512GB", 26999008.0, 8, 32);
        seedDataVariantAtribute("Xám", 3, 107); // Thông tin hàng hóa - Màu sắc
        seedDataVariantAtribute("Việt Nam / Trung Quốc", 1, 107); // Xuất xứ
        seedDataVariantAtribute("05/2024", 2, 107); // Thời điểm ra mắt
        seedDataVariantAtribute("12", 4, 107); // Thời gian bảo hành (tháng)
        seedDataVariantAtribute("Để nơi khô ráo, nhẹ tay, dễ vỡ. Xem trong sách hướng dẫn sử dụng", 48, 107); // Hướng dẫn bảo quản và sử dụng
        seedDataVariantAtribute("280.6 x 214.9 x 6.1 mm", 5, 107); // Kích thước
        seedDataVariantAtribute("617 g", 6, 107); // Trọng lượng sản phẩm
        seedDataVariantAtribute("Vỏ máy: Nhôm tái chế", 7, 107); // Chất liệu
        seedDataVariantAtribute("Apple M2", 9, 107); // CPU Model
        seedDataVariantAtribute("8 - Core", 10, 107); // Loại CPU
        seedDataVariantAtribute("Apple M2 8 nhân", 10, 107); // CPU
        seedDataVariantAtribute("8", 11, 107); // Số nhân
        seedDataVariantAtribute("8 GB", 79, 107); // Dung lượng RAM
        seedDataVariantAtribute("13 inch", 14, 107); // Kích thước màn hình
        seedDataVariantAtribute("2732 x 2048 Pixels", 17, 107); // Độ phân giải
        seedDataVariantAtribute("Liquid Retina", 16, 107); // Chuẩn màn hình
        seedDataVariantAtribute("600 nits", 20, 107); // Độ sáng
        seedDataVariantAtribute("Apple GPU 9 Nhân", 24, 107); // Chip đồ hoạ (GPU)
        seedDataVariantAtribute("Single rear camera", 27, 107); // Số camera sau
        seedDataVariantAtribute("Ultra Wide", 27, 107); // Camera Type 1
        seedDataVariantAtribute("12.0 MP", 28, 107); // Resolution (Camera 1)
        seedDataVariantAtribute("ƒ/2.4", 29, 107); // Aperture (Camera 1)
        seedDataVariantAtribute("4K 2160p@30fps, HD 720p@30fps, FullHD 1080p@60fps, FullHD 1080p@30fps, FullHD 1080p@25fps, FullHD 1080p@240fps, FullHD 1080p@120fps, 4K 2160p@60fps, 4K 2160p@25fps, 4K 2160p@24fps", 30, 107); // Quay phim camera sau
        seedDataVariantAtribute("Single selfie camera", 32, 107); // Số Camera Selfie
        seedDataVariantAtribute("12.0 MP", 33, 107); // Resolution (Camera Selfie 1)
        seedDataVariantAtribute("ƒ/2.4", 34, 107); // Aperture (Camera Selfie 1)
        seedDataVariantAtribute("Quay phim FullHD", 34, 107); // Quay phim camera selfie
        seedDataVariantAtribute("Trôi nhanh thời gian (Time lapse), Chụp góc rộng (Wide)", 35, 107); // Tính năng camera selfie
        seedDataVariantAtribute("Cảm biến vân tay, Con quay hồi chuyển, Cảm biến gia tốc kế, Cảm biến khí áp kế, Cảm biến ánh sáng", 36, 107); // Cảm biến
        seedDataVariantAtribute("Mật khẩu", 37, 107); // Bảo mật
        seedDataVariantAtribute("5G", 39, 107); // Hỗ trợ mạng
        seedDataVariantAtribute("Type C", 41, 107); // Cổng giao tiếp
        seedDataVariantAtribute("Wifi 6E", 42, 107); // Wifi
        seedDataVariantAtribute("v5.3", 44, 107); // Bluetooth
        seedDataVariantAtribute("Lithium polymer", 47, 107); // Loại PIN
        seedDataVariantAtribute("36.59 Wh", 48, 107); // Dung lượng pin
        seedDataVariantAtribute("iPadOS", 49, 107); // OS
        seedDataVariantAtribute("iPadOS 17", 50, 107); // Version
        seedDataVariantAtribute("Dây cáp sạc, Củ sạc iPad", 57, 107); // Phụ kiện trong hộp

        // màu trắng
        seedDataVariant("iPad Air 13 inch M2 2024 Wifi 1TB", 28999009.0, 8, 32);
        seedDataVariantAtribute("Trắng", 3, 108); // Thông tin hàng hóa - Màu sắc
        seedDataVariantAtribute("Việt Nam / Trung Quốc", 1, 108); // Xuất xứ
        seedDataVariantAtribute("05/2024", 2, 108); // Thời điểm ra mắt
        seedDataVariantAtribute("12", 4, 108); // Thời gian bảo hành (tháng)
        seedDataVariantAtribute("Để nơi khô ráo, nhẹ tay, dễ vỡ. Xem trong sách hướng dẫn sử dụng", 48, 108); // Hướng dẫn bảo quản và sử dụng
        seedDataVariantAtribute("280.6 x 214.9 x 6.1 mm", 5, 108); // Kích thước
        seedDataVariantAtribute("617 g", 6, 108); // Trọng lượng sản phẩm
        seedDataVariantAtribute("Vỏ máy: Nhôm tái chế", 7, 108); // Chất liệu
        seedDataVariantAtribute("Apple M2", 9, 108); // CPU Model
        seedDataVariantAtribute("8 - Core", 10, 108); // Loại CPU
        seedDataVariantAtribute("Apple M2 8 nhân", 10, 108); // CPU
        seedDataVariantAtribute("8", 11, 108); // Số nhân
        seedDataVariantAtribute("8 GB", 79, 108); // Dung lượng RAM
        seedDataVariantAtribute("13 inch", 14, 108); // Kích thước màn hình
        seedDataVariantAtribute("2732 x 2048 Pixels", 17, 108); // Độ phân giải
        seedDataVariantAtribute("Liquid Retina", 16, 108); // Chuẩn màn hình
        seedDataVariantAtribute("600 nits", 20, 108); // Độ sáng
        seedDataVariantAtribute("Apple GPU 9 Nhân", 24, 108); // Chip đồ hoạ (GPU)
        seedDataVariantAtribute("Single rear camera", 27, 108); // Số camera sau
        seedDataVariantAtribute("Ultra Wide", 27, 108); // Camera Type 1
        seedDataVariantAtribute("12.0 MP", 28, 108); // Resolution (Camera 1)
        seedDataVariantAtribute("ƒ/2.4", 29, 108); // Aperture (Camera 1)
        seedDataVariantAtribute("4K 2160p@30fps, HD 720p@30fps, FullHD 1080p@60fps, FullHD 1080p@30fps, FullHD 1080p@25fps, FullHD 1080p@240fps, FullHD 1080p@120fps, 4K 2160p@60fps, 4K 2160p@25fps, 4K 2160p@24fps", 30, 108); // Quay phim camera sau
        seedDataVariantAtribute("Single selfie camera", 32, 108); // Số Camera Selfie
        seedDataVariantAtribute("12.0 MP", 33, 108); // Resolution (Camera Selfie 1)
        seedDataVariantAtribute("ƒ/2.4", 34, 108); // Aperture (Camera Selfie 1)
        seedDataVariantAtribute("Quay phim FullHD", 34, 108); // Quay phim camera selfie
        seedDataVariantAtribute("Trôi nhanh thời gian (Time lapse), Chụp góc rộng (Wide)", 35, 108); // Tính năng camera selfie
        seedDataVariantAtribute("Cảm biến vân tay, Con quay hồi chuyển, Cảm biến gia tốc kế, Cảm biến khí áp kế, Cảm biến ánh sáng", 36, 108); // Cảm biến
        seedDataVariantAtribute("Mật khẩu", 37, 108); // Bảo mật
        seedDataVariantAtribute("5G", 39, 108); // Hỗ trợ mạng
        seedDataVariantAtribute("Type C", 41, 108); // Cổng giao tiếp
        seedDataVariantAtribute("Wifi 6E", 42, 108); // Wifi
        seedDataVariantAtribute("v5.3", 44, 108); // Bluetooth
        seedDataVariantAtribute("Lithium polymer", 47, 108); // Loại PIN
        seedDataVariantAtribute("36.59 Wh", 48, 108); // Dung lượng pin
        seedDataVariantAtribute("iPadOS", 49, 108); // OS
        seedDataVariantAtribute("iPadOS 17", 50, 108); // Version
        seedDataVariantAtribute("Dây cáp sạc, Củ sạc iPad", 57, 108); // Phụ kiện trong hộp

        // màu xám
        seedDataVariant("iPad Air 13 inch M2 2024 Wifi 1TB", 28999010.0, 8, 32);
        seedDataVariantAtribute("Xám", 3, 109); // Thông tin hàng hóa - Màu sắc
        seedDataVariantAtribute("Việt Nam / Trung Quốc", 1, 109); // Xuất xứ
        seedDataVariantAtribute("05/2024", 2, 109); // Thời điểm ra mắt
        seedDataVariantAtribute("12", 4, 109); // Thời gian bảo hành (tháng)
        seedDataVariantAtribute("Để nơi khô ráo, nhẹ tay, dễ vỡ. Xem trong sách hướng dẫn sử dụng", 48, 109); // Hướng dẫn bảo quản và sử dụng
        seedDataVariantAtribute("280.6 x 214.9 x 6.1 mm", 5, 109); // Kích thước
        seedDataVariantAtribute("617 g", 6, 109); // Trọng lượng sản phẩm
        seedDataVariantAtribute("Vỏ máy: Nhôm tái chế", 7, 109); // Chất liệu
        seedDataVariantAtribute("Apple M2", 9, 109); // CPU Model
        seedDataVariantAtribute("8 - Core", 10, 109); // Loại CPU
        seedDataVariantAtribute("Apple M2 8 nhân", 10, 109); // CPU
        seedDataVariantAtribute("8", 11, 109); // Số nhân
        seedDataVariantAtribute("8 GB", 79, 109); // Dung lượng RAM
        seedDataVariantAtribute("13 inch", 14, 109); // Kích thước màn hình
        seedDataVariantAtribute("2732 x 2048 Pixels", 17, 109); // Độ phân giải
        seedDataVariantAtribute("Liquid Retina", 16, 109); // Chuẩn màn hình
        seedDataVariantAtribute("600 nits", 20, 109); // Độ sáng
        seedDataVariantAtribute("Apple GPU 9 Nhân", 24, 109); // Chip đồ hoạ (GPU)
        seedDataVariantAtribute("Single rear camera", 27, 109); // Số camera sau
        seedDataVariantAtribute("Ultra Wide", 27, 109); // Camera Type 1
        seedDataVariantAtribute("12.0 MP", 28, 109); // Resolution (Camera 1)
        seedDataVariantAtribute("ƒ/2.4", 29, 109); // Aperture (Camera 1)
        seedDataVariantAtribute("4K 2160p@30fps, HD 720p@30fps, FullHD 1080p@60fps, FullHD 1080p@30fps, FullHD 1080p@25fps, FullHD 1080p@240fps, FullHD 1080p@120fps, 4K 2160p@60fps, 4K 2160p@25fps, 4K 2160p@24fps", 30, 109); // Quay phim camera sau
        seedDataVariantAtribute("Single selfie camera", 32, 109); // Số Camera Selfie
        seedDataVariantAtribute("12.0 MP", 33, 109); // Resolution (Camera Selfie 1)
        seedDataVariantAtribute("ƒ/2.4", 34, 109); // Aperture (Camera Selfie 1)
        seedDataVariantAtribute("Quay phim FullHD", 34, 109); // Quay phim camera selfie
        seedDataVariantAtribute("Trôi nhanh thời gian (Time lapse), Chụp góc rộng (Wide)", 35, 109); // Tính năng camera selfie
        seedDataVariantAtribute("Cảm biến vân tay, Con quay hồi chuyển, Cảm biến gia tốc kế, Cảm biến khí áp kế, Cảm biến ánh sáng", 36, 109); // Cảm biến
        seedDataVariantAtribute("Mật khẩu", 37, 109); // Bảo mật
        seedDataVariantAtribute("5G", 39, 109); // Hỗ trợ mạng
        seedDataVariantAtribute("Type C", 41, 109); // Cổng giao tiếp
        seedDataVariantAtribute("Wifi 6E", 42, 109); // Wifi
        seedDataVariantAtribute("v5.3", 44, 109); // Bluetooth
        seedDataVariantAtribute("Lithium polymer", 47, 109); // Loại PIN
        seedDataVariantAtribute("36.59 Wh", 48, 109); // Dung lượng pin
        seedDataVariantAtribute("iPadOS", 49, 109); // OS
        seedDataVariantAtribute("iPadOS 17", 50, 109); // Version
        seedDataVariantAtribute("Dây cáp sạc, Củ sạc iPad", 57, 109); // Phụ kiện trong hộp


        // iPad Pro 11 inch M4 2024 Wifi + Cellular 256GB
        // iPad Air 11 inch M2 2024
        seedDataProduct("iPad Pro", "Ipad", 0.466, 13, 3, 3, "");

        // màu đen
        seedDataVariant("iPad Pro 11 inch M4 2024 Wifi + Cellular 256GB", 33999011.0, 8, 33);

        seedDataVariantAtribute("Đen", 3, 110); // Thông tin hàng hóa - Màu sắc
        seedDataVariantAtribute("Việt Nam / Trung Quốc", 1, 110); // Xuất xứ
        seedDataVariantAtribute("05/2024", 2, 110); // Thời điểm ra mắt
        seedDataVariantAtribute("12", 4, 110); // Thời gian bảo hành (tháng)
        seedDataVariantAtribute("Để nơi khô ráo, nhẹ tay, dễ vỡ. Xem trong sách hướng dẫn sử dụng", 48, 110); // Hướng dẫn bảo quản và sử dụng
        seedDataVariantAtribute("249.7 x 177.5 x 5.3 mm", 5, 110); // Kích thước
        seedDataVariantAtribute("446 g", 6, 110); // Trọng lượng sản phẩm
        seedDataVariantAtribute("Vỏ máy: Nhôm tái chế", 7, 110); // Chất liệu
        seedDataVariantAtribute("Apple M4", 9, 110); // CPU Model
        seedDataVariantAtribute("10 - Core, Apple M4 10 nhân", 10, 110); // Loại CPU & CPU
        seedDataVariantAtribute("10", 11, 110); // Số nhân
        seedDataVariantAtribute("8 GB", 79, 110); // Dung lượng RAM
        seedDataVariantAtribute("11 inch", 14, 110); // Kích thước màn hình
        seedDataVariantAtribute("OLED", 15, 110); // Công nghệ màn hình
        seedDataVariantAtribute("2752 x 2064 pixel", 17, 110); // Độ phân giải
        seedDataVariantAtribute("Ultra Liquid Retina XDR", 16, 110); // Chuẩn màn hình
        seedDataVariantAtribute("1000 nits", 20, 110); // Độ sáng
        seedDataVariantAtribute("2.000.000:1", 21, 110); // Độ tương phản
        seedDataVariantAtribute("Apple GPU 10 nhân", 24, 110); // Chip đồ hoạ (GPU)
        seedDataVariantAtribute("Double rear camera, Camera Type 1: Ultra Wide, Camera Type 2: Wide", 27, 110); // Số camera sau và Camera Type
        seedDataVariantAtribute("Resolution (Camera 1): 12.0 MP, Resolution (Camera 2): 12.0 MP", 28, 110); // Độ phân giải Camera
        seedDataVariantAtribute("Aperture (Camera 1): ƒ/2.4, Aperture (Camera 2): ƒ/1.8", 29, 110); // Độ mở Camera
        seedDataVariantAtribute("4K 2160p@30fps, HD 720p@30fps, FullHD 1080p@60fps, FullHD 1080p@30fps, FullHD 1080p@25fps, 4K 2160p@60fps, 4K 2160p@25fps, 4K 2160p@24fps", 30, 110); // Quay phim camera sau
        seedDataVariantAtribute("Single selfie camera", 32, 110); // Số Camera Selfie
        seedDataVariantAtribute("Quay phim FullHD", 34, 110); // Quay phim camera selfie
        seedDataVariantAtribute("Trôi nhanh thời gian (Time lapse), Chụp góc rộng (Wide), Xóa phông", 35, 110); // Tính năng camera selfie
        seedDataVariantAtribute("Face ID, LiDAR Scanner, Con quay hồi chuyển, Cảm biến gia tốc kế, Cảm biến khí áp kế, Cảm biến ánh sáng", 36, 110); // Cảm biến
        seedDataVariantAtribute("Mật khẩu", 37, 110); // Bảo mật
        seedDataVariantAtribute("1 eSim", 38, 110); // Thẻ SIM
        seedDataVariantAtribute("5G", 39, 110); // Hỗ trợ mạng
        seedDataVariantAtribute("Type C", 41, 110); // Cổng giao tiếp
        seedDataVariantAtribute("Wifi 6E", 42, 110); // Wifi
        seedDataVariantAtribute("v5.3", 44, 110); // Bluetooth
        seedDataVariantAtribute("Lithium polymer", 47, 110); // Loại PIN
        seedDataVariantAtribute("28.93 Wh", 48, 110); // Dung lượng pin
        seedDataVariantAtribute("iPadOS", 49, 110); // OS
        seedDataVariantAtribute("iPadOS 17", 50, 110); // Version
        seedDataVariantAtribute("Dây cáp sạc, Củ sạc iPad, Khăn lau", 57, 110); // Phụ kiện trong hộp

        // màu xám 256
        seedDataVariant("iPad Pro 11 inch M4 2024 Wifi + Cellular 256GB", 33999012.0, 8, 33);
        seedDataVariantAtribute("Xám", 3, 111); // Thông tin hàng hóa - Màu sắc
        seedDataVariantAtribute("1 TB", 24, 111); // Dung lượng
        seedDataVariantAtribute("Việt Nam / Trung Quốc", 1, 111); // Xuất xứ
        seedDataVariantAtribute("05/2024", 2, 111); // Thời điểm ra mắt
        seedDataVariantAtribute("12", 4, 111); // Thời gian bảo hành (tháng)
        seedDataVariantAtribute("Để nơi khô ráo, nhẹ tay, dễ vỡ. Xem trong sách hướng dẫn sử dụng", 48, 111); // Hướng dẫn bảo quản và sử dụng
        seedDataVariantAtribute("249.7 x 177.5 x 5.3 mm", 5, 111); // Kích thước
        seedDataVariantAtribute("446 g", 6, 111); // Trọng lượng sản phẩm
        seedDataVariantAtribute("Vỏ máy: Nhôm tái chế", 7, 111); // Chất liệu
        seedDataVariantAtribute("Apple M4", 9, 111); // CPU Model
        seedDataVariantAtribute("10 - Core, Apple M4 10 nhân", 10, 111); // Loại CPU & CPU
        seedDataVariantAtribute("10", 11, 111); // Số nhân
        seedDataVariantAtribute("8 GB", 79, 111); // Dung lượng RAM
        seedDataVariantAtribute("11 inch", 14, 111); // Kích thước màn hình
        seedDataVariantAtribute("OLED", 15, 111); // Công nghệ màn hình
        seedDataVariantAtribute("2752 x 2064 pixel", 17, 111); // Độ phân giải
        seedDataVariantAtribute("Ultra Liquid Retina XDR", 16, 111); // Chuẩn màn hình
        seedDataVariantAtribute("1000 nits", 20, 111); // Độ sáng
        seedDataVariantAtribute("2.000.000:1", 21, 111); // Độ tương phản
        seedDataVariantAtribute("Apple GPU 10 nhân", 24, 111); // Chip đồ hoạ (GPU)
        seedDataVariantAtribute("Double rear camera, Camera Type 1: Ultra Wide, Camera Type 2: Wide", 27, 111); // Số camera sau và Camera Type
        seedDataVariantAtribute("Resolution (Camera 1): 12.0 MP, Resolution (Camera 2): 12.0 MP", 28, 111); // Độ phân giải Camera
        seedDataVariantAtribute("Aperture (Camera 1): ƒ/2.4, Aperture (Camera 2): ƒ/1.8", 29, 111); // Độ mở Camera
        seedDataVariantAtribute("4K 2160p@30fps, HD 720p@30fps, FullHD 1080p@60fps, FullHD 1080p@30fps, FullHD 1080p@25fps, 4K 2160p@60fps, 4K 2160p@25fps, 4K 2160p@24fps", 30, 111); // Quay phim camera sau
        seedDataVariantAtribute("Single selfie camera", 32, 111); // Số Camera Selfie
        seedDataVariantAtribute("Quay phim FullHD", 34, 111); // Quay phim camera selfie
        seedDataVariantAtribute("Trôi nhanh thời gian (Time lapse), Chụp góc rộng (Wide), Xóa phông", 35, 111); // Tính năng camera selfie
        seedDataVariantAtribute("Face ID, LiDAR Scanner, Con quay hồi chuyển, Cảm biến gia tốc kế, Cảm biến khí áp kế, Cảm biến ánh sáng", 36, 111); // Cảm biến
        seedDataVariantAtribute("Mật khẩu", 37, 111); // Bảo mật
        seedDataVariantAtribute("1 eSim", 38, 111); // Thẻ SIM
        seedDataVariantAtribute("5G", 39, 111); // Hỗ trợ mạng
        seedDataVariantAtribute("Type C", 41, 111); // Cổng giao tiếp
        seedDataVariantAtribute("Wifi 6E", 42, 111); // Wifi
        seedDataVariantAtribute("v5.3", 44, 111); // Bluetooth
        seedDataVariantAtribute("Lithium polymer", 47, 111); // Loại PIN
        seedDataVariantAtribute("28.93 Wh", 48, 111); // Dung lượng pin
        seedDataVariantAtribute("iPadOS", 49, 111); // OS
        seedDataVariantAtribute("iPadOS 17", 50, 111); // Version
        seedDataVariantAtribute("Dây cáp sạc, Củ sạc iPad, Khăn lau", 57, 111); // Phụ kiện trong hộp

        // màu đen
        seedDataVariant("iPad Pro 11 inch M4 2024 Wifi + Cellular 512GB", 36999013.0, 8, 33);

        seedDataVariantAtribute("Đen", 3, 112); // Thông tin hàng hóa - Màu sắc
        seedDataVariantAtribute("512GB", 24, 112); // Dung lượng
        seedDataVariantAtribute("Việt Nam / Trung Quốc", 1, 112); // Xuất xứ
        seedDataVariantAtribute("05/2024", 2, 112); // Thời điểm ra mắt
        seedDataVariantAtribute("12", 4, 112); // Thời gian bảo hành (tháng)
        seedDataVariantAtribute("Để nơi khô ráo, nhẹ tay, dễ vỡ. Xem trong sách hướng dẫn sử dụng", 48, 112); // Hướng dẫn bảo quản và sử dụng
        seedDataVariantAtribute("249.7 x 177.5 x 5.3 mm", 5, 112); // Kích thước
        seedDataVariantAtribute("446 g", 6, 112); // Trọng lượng sản phẩm
        seedDataVariantAtribute("Vỏ máy: Nhôm tái chế", 7, 112); // Chất liệu
        seedDataVariantAtribute("Apple M4", 9, 112); // CPU Model
        seedDataVariantAtribute("10 - Core, Apple M4 10 nhân", 10, 112); // Loại CPU & CPU
        seedDataVariantAtribute("10", 11, 112); // Số nhân
        seedDataVariantAtribute("8 GB", 79, 112); // Dung lượng RAM
        seedDataVariantAtribute("11 inch", 14, 112); // Kích thước màn hình
        seedDataVariantAtribute("OLED", 15, 112); // Công nghệ màn hình
        seedDataVariantAtribute("2752 x 2064 pixel", 17, 112); // Độ phân giải
        seedDataVariantAtribute("Ultra Liquid Retina XDR", 16, 112); // Chuẩn màn hình
        seedDataVariantAtribute("1000 nits", 20, 112); // Độ sáng
        seedDataVariantAtribute("2.000.000:1", 21, 112); // Độ tương phản
        seedDataVariantAtribute("Apple GPU 10 nhân", 24, 112); // Chip đồ hoạ (GPU)
        seedDataVariantAtribute("Double rear camera, Camera Type 1: Ultra Wide, Camera Type 2: Wide", 27, 112); // Số camera sau và Camera Type
        seedDataVariantAtribute("Resolution (Camera 1): 12.0 MP, Resolution (Camera 2): 12.0 MP", 28, 112); // Độ phân giải Camera
        seedDataVariantAtribute("Aperture (Camera 1): ƒ/2.4, Aperture (Camera 2): ƒ/1.8", 29, 112); // Độ mở Camera
        seedDataVariantAtribute("4K 2160p@30fps, HD 720p@30fps, FullHD 1080p@60fps, FullHD 1080p@30fps, FullHD 1080p@25fps, 4K 2160p@60fps, 4K 2160p@25fps, 4K 2160p@24fps", 30, 112); // Quay phim camera sau
        seedDataVariantAtribute("Single selfie camera", 32, 112); // Số Camera Selfie
        seedDataVariantAtribute("Quay phim FullHD", 34, 112); // Quay phim camera selfie
        seedDataVariantAtribute("Trôi nhanh thời gian (Time lapse), Chụp góc rộng (Wide), Xóa phông", 35, 112); // Tính năng camera selfie
        seedDataVariantAtribute("Face ID, LiDAR Scanner, Con quay hồi chuyển, Cảm biến gia tốc kế, Cảm biến khí áp kế, Cảm biến ánh sáng", 36, 112); // Cảm biến
        seedDataVariantAtribute("Mật khẩu", 37, 112); // Bảo mật
        seedDataVariantAtribute("1 eSim", 38, 112); // Thẻ SIM
        seedDataVariantAtribute("5G", 39, 112); // Hỗ trợ mạng
        seedDataVariantAtribute("Type C", 41, 112); // Cổng giao tiếp
        seedDataVariantAtribute("Wifi 6E", 42, 112); // Wifi
        seedDataVariantAtribute("v5.3", 44, 112); // Bluetooth
        seedDataVariantAtribute("Lithium polymer", 47, 112); // Loại PIN
        seedDataVariantAtribute("28.93 Wh", 48, 112); // Dung lượng pin
        seedDataVariantAtribute("iPadOS", 49, 112); // OS
        seedDataVariantAtribute("iPadOS 17", 50, 112); // Version
        seedDataVariantAtribute("Dây cáp sạc, Củ sạc iPad, Khăn lau", 57, 112); // Phụ kiện trong hộp

        // màu xám
        seedDataVariant("iPad Pro 11 inch M4 2024 Wifi + Cellular 512GB", 36999014.0, 8, 33);
        seedDataVariantAtribute("512GB", 24, 113); // Dung lượng
        seedDataVariantAtribute("Xám", 3, 113); // Thông tin hàng hóa - Màu sắc
        seedDataVariantAtribute("Việt Nam / Trung Quốc", 1, 113); // Xuất xứ
        seedDataVariantAtribute("05/2024", 2, 113); // Thời điểm ra mắt
        seedDataVariantAtribute("12", 4, 113); // Thời gian bảo hành (tháng)
        seedDataVariantAtribute("Để nơi khô ráo, nhẹ tay, dễ vỡ. Xem trong sách hướng dẫn sử dụng", 48, 113); // Hướng dẫn bảo quản và sử dụng
        seedDataVariantAtribute("249.7 x 177.5 x 5.3 mm", 5, 113); // Kích thước
        seedDataVariantAtribute("446 g", 6, 113); // Trọng lượng sản phẩm
        seedDataVariantAtribute("Vỏ máy: Nhôm tái chế", 7, 113); // Chất liệu
        seedDataVariantAtribute("Apple M4", 9, 113); // CPU Model
        seedDataVariantAtribute("10 - Core, Apple M4 10 nhân", 10, 113); // Loại CPU & CPU
        seedDataVariantAtribute("10", 11, 113); // Số nhân
        seedDataVariantAtribute("8 GB", 79, 113); // Dung lượng RAM
        seedDataVariantAtribute("11 inch", 14, 113); // Kích thước màn hình
        seedDataVariantAtribute("OLED", 15, 113); // Công nghệ màn hình
        seedDataVariantAtribute("2752 x 2064 pixel", 17, 113); // Độ phân giải
        seedDataVariantAtribute("Ultra Liquid Retina XDR", 16, 113); // Chuẩn màn hình
        seedDataVariantAtribute("1000 nits", 20, 113); // Độ sáng
        seedDataVariantAtribute("2.000.000:1", 21, 113); // Độ tương phản
        seedDataVariantAtribute("Apple GPU 10 nhân", 24, 113); // Chip đồ hoạ (GPU)
        seedDataVariantAtribute("Double rear camera, Camera Type 1: Ultra Wide, Camera Type 2: Wide", 27, 113); // Số camera sau và Camera Type
        seedDataVariantAtribute("Resolution (Camera 1): 12.0 MP, Resolution (Camera 2): 12.0 MP", 28, 113); // Độ phân giải Camera
        seedDataVariantAtribute("Aperture (Camera 1): ƒ/2.4, Aperture (Camera 2): ƒ/1.8", 29, 113); // Độ mở Camera
        seedDataVariantAtribute("4K 2160p@30fps, HD 720p@30fps, FullHD 1080p@60fps, FullHD 1080p@30fps, FullHD 1080p@25fps, 4K 2160p@60fps, 4K 2160p@25fps, 4K 2160p@24fps", 30, 113); // Quay phim camera sau
        seedDataVariantAtribute("Single selfie camera", 32, 113); // Số Camera Selfie
        seedDataVariantAtribute("Quay phim FullHD", 34, 113); // Quay phim camera selfie
        seedDataVariantAtribute("Trôi nhanh thời gian (Time lapse), Chụp góc rộng (Wide), Xóa phông", 35, 113); // Tính năng camera selfie
        seedDataVariantAtribute("Face ID, LiDAR Scanner, Con quay hồi chuyển, Cảm biến gia tốc kế, Cảm biến khí áp kế, Cảm biến ánh sáng", 36, 113); // Cảm biến
        seedDataVariantAtribute("Mật khẩu", 37, 113); // Bảo mật
        seedDataVariantAtribute("1 eSim", 38, 113); // Thẻ SIM
        seedDataVariantAtribute("5G", 39, 113); // Hỗ trợ mạng
        seedDataVariantAtribute("Type C", 41, 113); // Cổng giao tiếp
        seedDataVariantAtribute("Wifi 6E", 42, 113); // Wifi
        seedDataVariantAtribute("v5.3", 44, 113); // Bluetooth
        seedDataVariantAtribute("Lithium polymer", 47, 113); // Loại PIN
        seedDataVariantAtribute("28.93 Wh", 48, 113); // Dung lượng pin
        seedDataVariantAtribute("iPadOS", 49, 113); // OS
        seedDataVariantAtribute("iPadOS 17", 50, 113); // Version
        seedDataVariantAtribute("Dây cáp sạc, Củ sạc iPad, Khăn lau", 57, 113); // Phụ kiện trong hộp

        // màu đen
        seedDataVariant("iPad Pro 11 inch M4 2024 Wifi + Cellular 1TB", 45999014.0, 8, 33);

        seedDataVariantAtribute("Đen", 3, 114); // Thông tin hàng hóa - Màu sắc
        seedDataVariantAtribute("1TB", 24, 114); // Dung lượng
        seedDataVariantAtribute("Việt Nam / Trung Quốc", 1, 114); // Xuất xứ
        seedDataVariantAtribute("05/2024", 2, 114); // Thời điểm ra mắt
        seedDataVariantAtribute("12", 4, 114); // Thời gian bảo hành (tháng)
        seedDataVariantAtribute("Để nơi khô ráo, nhẹ tay, dễ vỡ. Xem trong sách hướng dẫn sử dụng", 48, 114); // Hướng dẫn bảo quản và sử dụng
        seedDataVariantAtribute("249.7 x 177.5 x 5.3 mm", 5, 114); // Kích thước
        seedDataVariantAtribute("446 g", 6, 114); // Trọng lượng sản phẩm
        seedDataVariantAtribute("Vỏ máy: Nhôm tái chế", 7, 114); // Chất liệu
        seedDataVariantAtribute("Apple M4", 9, 114); // CPU Model
        seedDataVariantAtribute("10 - Core, Apple M4 10 nhân", 10, 114); // Loại CPU & CPU
        seedDataVariantAtribute("10", 11, 114); // Số nhân
        seedDataVariantAtribute("8 GB", 79, 114); // Dung lượng RAM
        seedDataVariantAtribute("11 inch", 14, 114); // Kích thước màn hình
        seedDataVariantAtribute("OLED", 15, 114); // Công nghệ màn hình
        seedDataVariantAtribute("2752 x 2064 pixel", 17, 114); // Độ phân giải
        seedDataVariantAtribute("Ultra Liquid Retina XDR", 16, 114); // Chuẩn màn hình
        seedDataVariantAtribute("1000 nits", 20, 114); // Độ sáng
        seedDataVariantAtribute("2.000.000:1", 21, 114); // Độ tương phản
        seedDataVariantAtribute("Apple GPU 10 nhân", 24, 114); // Chip đồ hoạ (GPU)
        seedDataVariantAtribute("Double rear camera, Camera Type 1: Ultra Wide, Camera Type 2: Wide", 27, 114); // Số camera sau và Camera Type
        seedDataVariantAtribute("Resolution (Camera 1): 12.0 MP, Resolution (Camera 2): 12.0 MP", 28, 114); // Độ phân giải Camera
        seedDataVariantAtribute("Aperture (Camera 1): ƒ/2.4, Aperture (Camera 2): ƒ/1.8", 29, 114); // Độ mở Camera
        seedDataVariantAtribute("4K 2160p@30fps, HD 720p@30fps, FullHD 1080p@60fps, FullHD 1080p@30fps, FullHD 1080p@25fps, 4K 2160p@60fps, 4K 2160p@25fps, 4K 2160p@24fps", 30, 114); // Quay phim camera sau
        seedDataVariantAtribute("Single selfie camera", 32, 114); // Số Camera Selfie
        seedDataVariantAtribute("Quay phim FullHD", 34, 114); // Quay phim camera selfie
        seedDataVariantAtribute("Trôi nhanh thời gian (Time lapse), Chụp góc rộng (Wide), Xóa phông", 35, 114); // Tính năng camera selfie
        seedDataVariantAtribute("Face ID, LiDAR Scanner, Con quay hồi chuyển, Cảm biến gia tốc kế, Cảm biến khí áp kế, Cảm biến ánh sáng", 36, 114); // Cảm biến
        seedDataVariantAtribute("Mật khẩu", 37, 114); // Bảo mật
        seedDataVariantAtribute("1 eSim", 38, 114); // Thẻ SIM
        seedDataVariantAtribute("5G", 39, 114); // Hỗ trợ mạng
        seedDataVariantAtribute("Type C", 41, 114); // Cổng giao tiếp
        seedDataVariantAtribute("Wifi 6E", 42, 114); // Wifi
        seedDataVariantAtribute("v5.3", 44, 114); // Bluetooth
        seedDataVariantAtribute("Lithium polymer", 47, 114); // Loại PIN
        seedDataVariantAtribute("28.93 Wh", 48, 114); // Dung lượng pin
        seedDataVariantAtribute("iPadOS", 49, 114); // OS
        seedDataVariantAtribute("iPadOS 17", 50, 114); // Version
        seedDataVariantAtribute("Dây cáp sạc, Củ sạc iPad, Khăn lau", 57, 114); // Phụ kiện trong hộp

        // màu xám
        seedDataVariant("iPad Pro 11 inch M4 2024 Wifi + Cellular 1TB", 45999015.0, 8, 33);
        seedDataVariantAtribute("1TB", 24, 115); // Dung lượng
        seedDataVariantAtribute("Xám", 3, 115); // Thông tin hàng hóa - Màu sắc
        seedDataVariantAtribute("Việt Nam / Trung Quốc", 1, 115); // Xuất xứ
        seedDataVariantAtribute("05/2024", 2, 115); // Thời điểm ra mắt
        seedDataVariantAtribute("12", 4, 115); // Thời gian bảo hành (tháng)
        seedDataVariantAtribute("Để nơi khô ráo, nhẹ tay, dễ vỡ. Xem trong sách hướng dẫn sử dụng", 48, 115); // Hướng dẫn bảo quản và sử dụng
        seedDataVariantAtribute("249.7 x 177.5 x 5.3 mm", 5, 115); // Kích thước
        seedDataVariantAtribute("446 g", 6, 115); // Trọng lượng sản phẩm
        seedDataVariantAtribute("Vỏ máy: Nhôm tái chế", 7, 115); // Chất liệu
        seedDataVariantAtribute("Apple M4", 9, 115); // CPU Model
        seedDataVariantAtribute("10 - Core, Apple M4 10 nhân", 10, 115); // Loại CPU & CPU
        seedDataVariantAtribute("10", 11, 115); // Số nhân
        seedDataVariantAtribute("8 GB", 79, 115); // Dung lượng RAM
        seedDataVariantAtribute("11 inch", 14, 115); // Kích thước màn hình
        seedDataVariantAtribute("OLED", 15, 115); // Công nghệ màn hình
        seedDataVariantAtribute("2752 x 2064 pixel", 17, 115); // Độ phân giải
        seedDataVariantAtribute("Ultra Liquid Retina XDR", 16, 115); // Chuẩn màn hình
        seedDataVariantAtribute("1000 nits", 20, 115); // Độ sáng
        seedDataVariantAtribute("2.000.000:1", 21, 115); // Độ tương phản
        seedDataVariantAtribute("Apple GPU 10 nhân", 24, 115); // Chip đồ hoạ (GPU)
        seedDataVariantAtribute("Double rear camera, Camera Type 1: Ultra Wide, Camera Type 2: Wide", 27, 115); // Số camera sau và Camera Type
        seedDataVariantAtribute("Resolution (Camera 1): 12.0 MP, Resolution (Camera 2): 12.0 MP", 28, 115); // Độ phân giải Camera
        seedDataVariantAtribute("Aperture (Camera 1): ƒ/2.4, Aperture (Camera 2): ƒ/1.8", 29, 115); // Độ mở Camera
        seedDataVariantAtribute("4K 2160p@30fps, HD 720p@30fps, FullHD 1080p@60fps, FullHD 1080p@30fps, FullHD 1080p@25fps, 4K 2160p@60fps, 4K 2160p@25fps, 4K 2160p@24fps", 30, 115); // Quay phim camera sau
        seedDataVariantAtribute("Single selfie camera", 32, 115); // Số Camera Selfie
        seedDataVariantAtribute("Quay phim FullHD", 34, 115); // Quay phim camera selfie
        seedDataVariantAtribute("Trôi nhanh thời gian (Time lapse), Chụp góc rộng (Wide), Xóa phông", 35, 115); // Tính năng camera selfie
        seedDataVariantAtribute("Face ID, LiDAR Scanner, Con quay hồi chuyển, Cảm biến gia tốc kế, Cảm biến khí áp kế, Cảm biến ánh sáng", 36, 115); // Cảm biến
        seedDataVariantAtribute("Mật khẩu", 37, 115); // Bảo mật
        seedDataVariantAtribute("1 eSim", 38, 115); // Thẻ SIM
        seedDataVariantAtribute("5G", 39, 115); // Hỗ trợ mạng
        seedDataVariantAtribute("Type C", 41, 115); // Cổng giao tiếp
        seedDataVariantAtribute("Wifi 6E", 42, 115); // Wifi
        seedDataVariantAtribute("v5.3", 44, 115); // Bluetooth
        seedDataVariantAtribute("Lithium polymer", 47, 115); // Loại PIN
        seedDataVariantAtribute("28.93 Wh", 48, 115); // Dung lượng pin
        seedDataVariantAtribute("iPadOS", 49, 115); // OS
        seedDataVariantAtribute("iPadOS 17", 50, 115); // Version
        seedDataVariantAtribute("Dây cáp sạc, Củ sạc iPad, Khăn lau", 57, 115); // Phụ kiện trong hộp

        // iPad Pro 11 inch M4 2024 Wifi 256GB
        seedDataVariant("iPad Pro 11 inch M4 2024 256GB", 33999016.0, 8, 33);
        seedDataVariantAtribute("256GB", 24, 116); // Dung lượng
        seedDataVariantAtribute("Đen", 3, 116); // Thông tin hàng hóa - Màu sắc
        seedDataVariantAtribute("Việt Nam / Trung Quốc", 1, 116); // Xuất xứ
        seedDataVariantAtribute("05/2024", 2, 116); // Thời điểm ra mắt
        seedDataVariantAtribute("12", 4, 116); // Thời gian bảo hành (tháng)
        seedDataVariantAtribute("Để nơi khô ráo, nhẹ tay, dễ vỡ. Xem trong sách hướng dẫn sử dụng", 48, 116); // Hướng dẫn bảo quản và sử dụng
        seedDataVariantAtribute("249.7 x 177.5 x 5.3 mm", 5, 116); // Kích thước
        seedDataVariantAtribute("444 g", 6, 116); // Trọng lượng sản phẩm
        seedDataVariantAtribute("Vỏ máy: Nhôm tái chế", 7, 116); // Chất liệu
        seedDataVariantAtribute("Apple M4", 9, 116); // CPU Model
        seedDataVariantAtribute("10 - Core, Apple M4 10 nhân", 10, 116); // Loại CPU & CPU
        seedDataVariantAtribute("10", 11, 116); // Số nhân
        seedDataVariantAtribute("8 GB", 79, 116); // Dung lượng RAM
        seedDataVariantAtribute("11 inch", 14, 116); // Kích thước màn hình
        seedDataVariantAtribute("OLED", 15, 116); // Công nghệ màn hình
        seedDataVariantAtribute("2420 x 1668 Pixel", 17, 116); // Độ phân giải
        seedDataVariantAtribute("Ultra Liquid Retina XDR", 16, 116); // Chuẩn màn hình
        seedDataVariantAtribute("1000 nits", 20, 116); // Độ sáng
        seedDataVariantAtribute("2.000.000:1", 21, 116); // Độ tương phản
        seedDataVariantAtribute("Apple GPU 10 nhân", 24, 116); // Chip đồ hoạ (GPU)
        seedDataVariantAtribute("Double rear camera, Camera Type 1: Ultra Wide, Camera Type 2: Wide", 27, 116); // Số camera sau và Camera Type
        seedDataVariantAtribute("Resolution (Camera 1): 12.0 MP, Resolution (Camera 2): 12.0 MP", 28, 116); // Độ phân giải Camera
        seedDataVariantAtribute("Aperture (Camera 1): ƒ/2.4, Aperture (Camera 2): ƒ/1.8", 29, 116); // Độ mở Camera
        seedDataVariantAtribute("4K 2160p@30fps, HD 720p@30fps, FullHD 1080p@60fps, FullHD 1080p@30fps, FullHD 1080p@25fps, 4K 2160p@60fps, 4K 2160p@25fps, 4K 2160p@24fps", 30, 116); // Quay phim camera sau
        seedDataVariantAtribute("Single selfie camera", 32, 116); // Số Camera Selfie
        seedDataVariantAtribute("Quay phim FullHD", 34, 116); // Quay phim camera selfie
        seedDataVariantAtribute("Trôi nhanh thời gian (Time lapse), Chụp góc rộng (Wide), Xóa phông", 35, 116); // Tính năng camera selfie
        seedDataVariantAtribute("Face ID, LiDAR Scanner, Con quay hồi chuyển, Cảm biến gia tốc kế, Cảm biến khí áp kế, Cảm biến ánh sáng", 36, 116); // Cảm biến
        seedDataVariantAtribute("Mật khẩu", 37, 116); // Bảo mật
        seedDataVariantAtribute("5G", 39, 116); // Hỗ trợ mạng
        seedDataVariantAtribute("Type C", 41, 116); // Cổng giao tiếp
        seedDataVariantAtribute("Wifi 6E", 42, 116); // Wifi
        seedDataVariantAtribute("v5.3", 44, 116); // Bluetooth
        seedDataVariantAtribute("Lithium polymer", 47, 116); // Loại PIN
        seedDataVariantAtribute("36.59 Wh", 48, 116); // Dung lượng pin
        seedDataVariantAtribute("iPadOS", 49, 116); // OS
        seedDataVariantAtribute("iPadOS 17", 50, 116); // Version
        seedDataVariantAtribute("Dây cáp sạc, Củ sạc iPad, Khăn lau", 57, 116); // Phụ kiện trong hộp

        seedDataVariant("iPad Pro 11 inch M4 2024 256GB ", 33999017.0, 8, 33);
        seedDataVariantAtribute("256GB", 24, 117); // Dung lượng
        seedDataVariantAtribute("Bạc", 3, 117); // Thông tin hàng hóa - Màu sắc
        seedDataVariantAtribute("Việt Nam / Trung Quốc", 1, 117); // Xuất xứ
        seedDataVariantAtribute("05/2024", 2, 117); // Thời điểm ra mắt
        seedDataVariantAtribute("12", 4, 117); // Thời gian bảo hành (tháng)
        seedDataVariantAtribute("Để nơi khô ráo, nhẹ tay, dễ vỡ. Xem trong sách hướng dẫn sử dụng", 48, 117); // Hướng dẫn bảo quản và sử dụng
        seedDataVariantAtribute("249.7 x 177.5 x 5.3 mm", 5, 117); // Kích thước
        seedDataVariantAtribute("444 g", 6, 117); // Trọng lượng sản phẩm
        seedDataVariantAtribute("Vỏ máy: Nhôm tái chế", 7, 117); // Chất liệu
        seedDataVariantAtribute("Apple M4", 9, 117); // CPU Model
        seedDataVariantAtribute("10 - Core, Apple M4 10 nhân", 10, 117); // Loại CPU & CPU
        seedDataVariantAtribute("10", 11, 117); // Số nhân
        seedDataVariantAtribute("8 GB", 79, 117); // Dung lượng RAM
        seedDataVariantAtribute("11 inch", 14, 117); // Kích thước màn hình
        seedDataVariantAtribute("OLED", 15, 117); // Công nghệ màn hình
        seedDataVariantAtribute("2420 x 1668 Pixel", 17, 117); // Độ phân giải
        seedDataVariantAtribute("Ultra Liquid Retina XDR", 16, 117); // Chuẩn màn hình
        seedDataVariantAtribute("1000 nits", 20, 117); // Độ sáng
        seedDataVariantAtribute("2.000.000:1", 21, 117); // Độ tương phản
        seedDataVariantAtribute("Apple GPU 10 nhân", 24, 117); // Chip đồ hoạ (GPU)
        seedDataVariantAtribute("Double rear camera, Camera Type 1: Ultra Wide, Camera Type 2: Wide", 27, 117); // Số camera sau và Camera Type
        seedDataVariantAtribute("Resolution (Camera 1): 12.0 MP, Resolution (Camera 2): 12.0 MP", 28, 117); // Độ phân giải Camera
        seedDataVariantAtribute("Aperture (Camera 1): ƒ/2.4, Aperture (Camera 2): ƒ/1.8", 29, 117); // Độ mở Camera
        seedDataVariantAtribute("4K 2160p@30fps, HD 720p@30fps, FullHD 1080p@60fps, FullHD 1080p@30fps, FullHD 1080p@25fps, 4K 2160p@60fps, 4K 2160p@25fps, 4K 2160p@24fps", 30, 117); // Quay phim camera sau
        seedDataVariantAtribute("Single selfie camera", 32, 117); // Số Camera Selfie
        seedDataVariantAtribute("Quay phim FullHD", 34, 117); // Quay phim camera selfie
        seedDataVariantAtribute("Trôi nhanh thời gian (Time lapse), Chụp góc rộng (Wide), Xóa phông", 35, 117); // Tính năng camera selfie
        seedDataVariantAtribute("Face ID, LiDAR Scanner, Con quay hồi chuyển, Cảm biến gia tốc kế, Cảm biến khí áp kế, Cảm biến ánh sáng", 36, 117); // Cảm biến
        seedDataVariantAtribute("Mật khẩu", 37, 117); // Bảo mật
        seedDataVariantAtribute("5G", 39, 117); // Hỗ trợ mạng
        seedDataVariantAtribute("Type C", 41, 117); // Cổng giao tiếp
        seedDataVariantAtribute("Wifi 6E", 42, 117); // Wifi
        seedDataVariantAtribute("v5.3", 44, 117); // Bluetooth
        seedDataVariantAtribute("Lithium polymer", 47, 117); // Loại PIN
        seedDataVariantAtribute("36.59 Wh", 48, 117); // Dung lượng pin
        seedDataVariantAtribute("iPadOS", 49, 117); // OS
        seedDataVariantAtribute("iPadOS 17", 50, 117); // Version
        seedDataVariantAtribute("Dây cáp sạc, Củ sạc iPad, Khăn lau", 57, 117); // Phụ kiện trong hộp

        // iPad Pro 11 inch M4 2024 Wifi 512GB
        seedDataVariant("iPad Pro 11 inch M4 2024 512GB", 36999018.0, 8, 33);
        seedDataVariantAtribute("Đen", 3, 118); // Thông tin hàng hóa - Màu sắc
        seedDataVariantAtribute("512GB", 24, 118); // Dung lượng
        seedDataVariantAtribute("Việt Nam / Trung Quốc", 1, 118); // Xuất xứ
        seedDataVariantAtribute("05/2024", 2, 118); // Thời điểm ra mắt
        seedDataVariantAtribute("12", 4, 118); // Thời gian bảo hành (tháng)
        seedDataVariantAtribute("Để nơi khô ráo, nhẹ tay, dễ vỡ. Xem trong sách hướng dẫn sử dụng", 48, 118); // Hướng dẫn bảo quản và sử dụng
        seedDataVariantAtribute("249.7 x 177.5 x 5.3 mm", 5, 118); // Kích thước
        seedDataVariantAtribute("444 g", 6, 118); // Trọng lượng sản phẩm
        seedDataVariantAtribute("Vỏ máy: Nhôm tái chế", 7, 118); // Chất liệu
        seedDataVariantAtribute("Apple M4", 9, 118); // CPU Model
        seedDataVariantAtribute("10 - Core, Apple M4 10 nhân", 10, 118); // Loại CPU & CPU
        seedDataVariantAtribute("10", 11, 118); // Số nhân
        seedDataVariantAtribute("8 GB", 79, 118); // Dung lượng RAM
        seedDataVariantAtribute("11 inch", 14, 118); // Kích thước màn hình
        seedDataVariantAtribute("OLED", 15, 118); // Công nghệ màn hình
        seedDataVariantAtribute("2420 x 1668 Pixel", 17, 118); // Độ phân giải
        seedDataVariantAtribute("Ultra Liquid Retina XDR", 16, 118); // Chuẩn màn hình
        seedDataVariantAtribute("1000 nits", 20, 118); // Độ sáng
        seedDataVariantAtribute("2.000.000:1", 21, 118); // Độ tương phản
        seedDataVariantAtribute("Apple GPU 10 nhân", 24, 118); // Chip đồ hoạ (GPU)
        seedDataVariantAtribute("Double rear camera, Camera Type 1: Ultra Wide, Camera Type 2: Wide", 27, 118); // Số camera sau và Camera Type
        seedDataVariantAtribute("Resolution (Camera 1): 12.0 MP, Resolution (Camera 2): 12.0 MP", 28, 118); // Độ phân giải Camera
        seedDataVariantAtribute("Aperture (Camera 1): ƒ/2.4, Aperture (Camera 2): ƒ/1.8", 29, 118); // Độ mở Camera
        seedDataVariantAtribute("4K 2160p@30fps, HD 720p@30fps, FullHD 1080p@60fps, FullHD 1080p@30fps, FullHD 1080p@25fps, 4K 2160p@60fps, 4K 2160p@25fps, 4K 2160p@24fps", 30, 118); // Quay phim camera sau
        seedDataVariantAtribute("Single selfie camera", 32, 118); // Số Camera Selfie
        seedDataVariantAtribute("Quay phim FullHD", 34, 118); // Quay phim camera selfie
        seedDataVariantAtribute("Trôi nhanh thời gian (Time lapse), Chụp góc rộng (Wide), Xóa phông", 35, 118); // Tính năng camera selfie
        seedDataVariantAtribute("Face ID, LiDAR Scanner, Con quay hồi chuyển, Cảm biến gia tốc kế, Cảm biến khí áp kế, Cảm biến ánh sáng", 36, 118); // Cảm biến
        seedDataVariantAtribute("Mật khẩu", 37, 118); // Bảo mật
        seedDataVariantAtribute("5G", 39, 118); // Hỗ trợ mạng
        seedDataVariantAtribute("Type C", 41, 118); // Cổng giao tiếp
        seedDataVariantAtribute("Wifi 6E", 42, 118); // Wifi
        seedDataVariantAtribute("v5.3", 44, 118); // Bluetooth
        seedDataVariantAtribute("Lithium polymer", 47, 118); // Loại PIN
        seedDataVariantAtribute("36.59 Wh", 48, 118); // Dung lượng pin
        seedDataVariantAtribute("iPadOS", 49, 118); // OS
        seedDataVariantAtribute("iPadOS 17", 50, 118); // Version
        seedDataVariantAtribute("Dây cáp sạc, Củ sạc iPad, Khăn lau", 57, 118); // Phụ kiện trong hộp

        seedDataVariant("iPad Pro 11 inch M4 2024 512GB ", 36999118.0, 8, 33);
        seedDataVariantAtribute("512GB", 24, 119); // Dung lượng
        seedDataVariantAtribute("Bạc", 3, 119); // Thông tin hàng hóa - Màu sắc
        seedDataVariantAtribute("Việt Nam / Trung Quốc", 1, 119); // Xuất xứ
        seedDataVariantAtribute("05/2024", 2, 119); // Thời điểm ra mắt
        seedDataVariantAtribute("12", 4, 119); // Thời gian bảo hành (tháng)
        seedDataVariantAtribute("Để nơi khô ráo, nhẹ tay, dễ vỡ. Xem trong sách hướng dẫn sử dụng", 48, 119); // Hướng dẫn bảo quản và sử dụng
        seedDataVariantAtribute("249.7 x 177.5 x 5.3 mm", 5, 119); // Kích thước
        seedDataVariantAtribute("444 g", 6, 119); // Trọng lượng sản phẩm
        seedDataVariantAtribute("Vỏ máy: Nhôm tái chế", 7, 119); // Chất liệu
        seedDataVariantAtribute("Apple M4", 9, 119); // CPU Model
        seedDataVariantAtribute("10 - Core, Apple M4 10 nhân", 10, 119); // Loại CPU & CPU
        seedDataVariantAtribute("10", 11, 119); // Số nhân
        seedDataVariantAtribute("8 GB", 79, 119); // Dung lượng RAM
        seedDataVariantAtribute("11 inch", 14, 119); // Kích thước màn hình
        seedDataVariantAtribute("OLED", 15, 119); // Công nghệ màn hình
        seedDataVariantAtribute("2420 x 1668 Pixel", 17, 119); // Độ phân giải
        seedDataVariantAtribute("Ultra Liquid Retina XDR", 16, 119); // Chuẩn màn hình
        seedDataVariantAtribute("1000 nits", 20, 119); // Độ sáng
        seedDataVariantAtribute("2.000.000:1", 21, 119); // Độ tương phản
        seedDataVariantAtribute("Apple GPU 10 nhân", 24, 119); // Chip đồ hoạ (GPU)
        seedDataVariantAtribute("Double rear camera, Camera Type 1: Ultra Wide, Camera Type 2: Wide", 27, 119); // Số camera sau và Camera Type
        seedDataVariantAtribute("Resolution (Camera 1): 12.0 MP, Resolution (Camera 2): 12.0 MP", 28, 119); // Độ phân giải Camera
        seedDataVariantAtribute("Aperture (Camera 1): ƒ/2.4, Aperture (Camera 2): ƒ/1.8", 29, 119); // Độ mở Camera
        seedDataVariantAtribute("4K 2160p@30fps, HD 720p@30fps, FullHD 1080p@60fps, FullHD 1080p@30fps, FullHD 1080p@25fps, 4K 2160p@60fps, 4K 2160p@25fps, 4K 2160p@24fps", 30, 119); // Quay phim camera sau
        seedDataVariantAtribute("Single selfie camera", 32, 119); // Số Camera Selfie
        seedDataVariantAtribute("Quay phim FullHD", 34, 119); // Quay phim camera selfie
        seedDataVariantAtribute("Trôi nhanh thời gian (Time lapse), Chụp góc rộng (Wide), Xóa phông", 35, 119); // Tính năng camera selfie
        seedDataVariantAtribute("Face ID, LiDAR Scanner, Con quay hồi chuyển, Cảm biến gia tốc kế, Cảm biến khí áp kế, Cảm biến ánh sáng", 36, 119); // Cảm biến
        seedDataVariantAtribute("Mật khẩu", 37, 119); // Bảo mật
        seedDataVariantAtribute("5G", 39, 119); // Hỗ trợ mạng
        seedDataVariantAtribute("Type C", 41, 119); // Cổng giao tiếp
        seedDataVariantAtribute("Wifi 6E", 42, 119); // Wifi
        seedDataVariantAtribute("v5.3", 44, 119); // Bluetooth
        seedDataVariantAtribute("Lithium polymer", 47, 119); // Loại PIN
        seedDataVariantAtribute("36.59 Wh", 48, 119); // Dung lượng pin
        seedDataVariantAtribute("iPadOS", 49, 119); // OS
        seedDataVariantAtribute("iPadOS 17", 50, 119); // Version
        seedDataVariantAtribute("Dây cáp sạc, Củ sạc iPad, Khăn lau", 57, 119); // Phụ kiện trong hộp

        // iPad Pro 11 inch M4 2024 Wifi 1TB
        seedDataVariant("iPad Pro 11 inch M4 2024 1TB", 36999019.0, 8, 33);
        seedDataVariantAtribute("1TB", 24, 120); // Dung lượng
        seedDataVariantAtribute("Đen", 3, 120); // Thông tin hàng hóa - Màu sắc
        seedDataVariantAtribute("Việt Nam / Trung Quốc", 1, 120); // Xuất xứ
        seedDataVariantAtribute("05/2024", 2, 120); // Thời điểm ra mắt
        seedDataVariantAtribute("12", 4, 120); // Thời gian bảo hành (tháng)
        seedDataVariantAtribute("Để nơi khô ráo, nhẹ tay, dễ vỡ. Xem trong sách hướng dẫn sử dụng", 48, 120); // Hướng dẫn bảo quản và sử dụng
        seedDataVariantAtribute("249.7 x 177.5 x 5.3 mm", 5, 120); // Kích thước
        seedDataVariantAtribute("444 g", 6, 120); // Trọng lượng sản phẩm
        seedDataVariantAtribute("Vỏ máy: Nhôm tái chế", 7, 120); // Chất liệu
        seedDataVariantAtribute("Apple M4", 9, 120); // CPU Model
        seedDataVariantAtribute("10 - Core, Apple M4 10 nhân", 10, 120); // Loại CPU & CPU
        seedDataVariantAtribute("10", 11, 120); // Số nhân
        seedDataVariantAtribute("8 GB", 79, 120); // Dung lượng RAM
        seedDataVariantAtribute("11 inch", 14, 120); // Kích thước màn hình
        seedDataVariantAtribute("OLED", 15, 120); // Công nghệ màn hình
        seedDataVariantAtribute("2420 x 1668 Pixel", 17, 120); // Độ phân giải
        seedDataVariantAtribute("Ultra Liquid Retina XDR", 16, 120); // Chuẩn màn hình
        seedDataVariantAtribute("1000 nits", 20, 120); // Độ sáng
        seedDataVariantAtribute("2.000.000:1", 21, 120); // Độ tương phản
        seedDataVariantAtribute("Apple GPU 10 nhân", 24, 120); // Chip đồ hoạ (GPU)
        seedDataVariantAtribute("Double rear camera, Camera Type 1: Ultra Wide, Camera Type 2: Wide", 27, 120); // Số camera sau và Camera Type
        seedDataVariantAtribute("Resolution (Camera 1): 12.0 MP, Resolution (Camera 2): 12.0 MP", 28, 120); // Độ phân giải Camera
        seedDataVariantAtribute("Aperture (Camera 1): ƒ/2.4, Aperture (Camera 2): ƒ/1.8", 29, 120); // Độ mở Camera
        seedDataVariantAtribute("4K 2160p@30fps, HD 720p@30fps, FullHD 1080p@60fps, FullHD 1080p@30fps, FullHD 1080p@25fps, 4K 2160p@60fps, 4K 2160p@25fps, 4K 2160p@24fps", 30, 120); // Quay phim camera sau
        seedDataVariantAtribute("Single selfie camera", 32, 120); // Số Camera Selfie
        seedDataVariantAtribute("Quay phim FullHD", 34, 120); // Quay phim camera selfie
        seedDataVariantAtribute("Trôi nhanh thời gian (Time lapse), Chụp góc rộng (Wide), Xóa phông", 35, 120); // Tính năng camera selfie
        seedDataVariantAtribute("Face ID, LiDAR Scanner, Con quay hồi chuyển, Cảm biến gia tốc kế, Cảm biến khí áp kế, Cảm biến ánh sáng", 36, 120); // Cảm biến
        seedDataVariantAtribute("Mật khẩu", 37, 120); // Bảo mật
        seedDataVariantAtribute("5G", 39, 120); // Hỗ trợ mạng
        seedDataVariantAtribute("Type C", 41, 120); // Cổng giao tiếp
        seedDataVariantAtribute("Wifi 6E", 42, 120); // Wifi
        seedDataVariantAtribute("v5.3", 44, 120); // Bluetooth
        seedDataVariantAtribute("Lithium polymer", 47, 120); // Loại PIN
        seedDataVariantAtribute("36.59 Wh", 48, 120); // Dung lượng pin
        seedDataVariantAtribute("iPadOS", 49, 120); // OS
        seedDataVariantAtribute("iPadOS 17", 50, 120); // Version
        seedDataVariantAtribute("Dây cáp sạc, Củ sạc iPad, Khăn lau", 57, 120); // Phụ kiện trong hộp

        seedDataVariant("iPad Pro 11 inch M4 2024 1TB ", 36999020.0, 8, 33);
        seedDataVariantAtribute("1TB", 24, 121); // Dung lượng
        seedDataVariantAtribute("Bạc", 3, 121); // Thông tin hàng hóa - Màu sắc
        seedDataVariantAtribute("Việt Nam / Trung Quốc", 1, 121); // Xuất xứ
        seedDataVariantAtribute("05/2024", 2, 121); // Thời điểm ra mắt
        seedDataVariantAtribute("12", 4, 121); // Thời gian bảo hành (tháng)
        seedDataVariantAtribute("Để nơi khô ráo, nhẹ tay, dễ vỡ. Xem trong sách hướng dẫn sử dụng", 48, 121); // Hướng dẫn bảo quản và sử dụng
        seedDataVariantAtribute("249.7 x 177.5 x 5.3 mm", 5, 121); // Kích thước
        seedDataVariantAtribute("444 g", 6, 121); // Trọng lượng sản phẩm
        seedDataVariantAtribute("Vỏ máy: Nhôm tái chế", 7, 121); // Chất liệu
        seedDataVariantAtribute("Apple M4", 9, 121); // CPU Model
        seedDataVariantAtribute("10 - Core, Apple M4 10 nhân", 10, 121); // Loại CPU & CPU
        seedDataVariantAtribute("10", 11, 121); // Số nhân
        seedDataVariantAtribute("8 GB", 79, 121); // Dung lượng RAM
        seedDataVariantAtribute("11 inch", 14, 121); // Kích thước màn hình
        seedDataVariantAtribute("OLED", 15, 121); // Công nghệ màn hình
        seedDataVariantAtribute("2420 x 1668 Pixel", 17, 121); // Độ phân giải
        seedDataVariantAtribute("Ultra Liquid Retina XDR", 16, 121); // Chuẩn màn hình
        seedDataVariantAtribute("1000 nits", 20, 121); // Độ sáng
        seedDataVariantAtribute("2.000.000:1", 21, 121); // Độ tương phản
        seedDataVariantAtribute("Apple GPU 10 nhân", 24, 121); // Chip đồ hoạ (GPU)
        seedDataVariantAtribute("Double rear camera, Camera Type 1: Ultra Wide, Camera Type 2: Wide", 27, 121); // Số camera sau và Camera Type
        seedDataVariantAtribute("Resolution (Camera 1): 12.0 MP, Resolution (Camera 2): 12.0 MP", 28, 121); // Độ phân giải Camera
        seedDataVariantAtribute("Aperture (Camera 1): ƒ/2.4, Aperture (Camera 2): ƒ/1.8", 29, 121); // Độ mở Camera
        seedDataVariantAtribute("4K 2160p@30fps, HD 720p@30fps, FullHD 1080p@60fps, FullHD 1080p@30fps, FullHD 1080p@25fps, 4K 2160p@60fps, 4K 2160p@25fps, 4K 2160p@24fps", 30, 121); // Quay phim camera sau
        seedDataVariantAtribute("Single selfie camera", 32, 121); // Số Camera Selfie
        seedDataVariantAtribute("Quay phim FullHD", 34, 121); // Quay phim camera selfie
        seedDataVariantAtribute("Trôi nhanh thời gian (Time lapse), Chụp góc rộng (Wide), Xóa phông", 35, 121); // Tính năng camera selfie
        seedDataVariantAtribute("Face ID, LiDAR Scanner, Con quay hồi chuyển, Cảm biến gia tốc kế, Cảm biến khí áp kế, Cảm biến ánh sáng", 36, 121); // Cảm biến
        seedDataVariantAtribute("Mật khẩu", 37, 121); // Bảo mật
        seedDataVariantAtribute("5G", 39, 121); // Hỗ trợ mạng
        seedDataVariantAtribute("Type C", 41, 121); // Cổng giao tiếp
        seedDataVariantAtribute("Wifi 6E", 42, 121); // Wifi
        seedDataVariantAtribute("v5.3", 44, 121); // Bluetooth
        seedDataVariantAtribute("Lithium polymer", 47, 121); // Loại PIN
        seedDataVariantAtribute("36.59 Wh", 48, 121); // Dung lượng pin
        seedDataVariantAtribute("iPadOS", 49, 121); // OS
        seedDataVariantAtribute("iPadOS 17", 50, 121); // Version
        seedDataVariantAtribute("Dây cáp sạc, Củ sạc iPad, Khăn lau", 57, 121); // Phụ kiện trong hộp

        // iPad mini 6 2021 8.3 inch WiFi 64GB
        seedDataProduct("iPad Mini", "Ipad", 0.462, 13, 3, 3, "");
        seedDataVariant("iPad mini 6 2021 8.3 inch WiFi 64GB ", 12999018.0, 8, 34);

        seedDataVariantAtribute("Xám", 3, 122); // Thông tin hàng hóa - Màu sắc
        seedDataVariantAtribute("64GB", 24, 122); // Dung lượng
        seedDataVariantAtribute("Trung Quốc", 1, 122); // Xuất xứ
        seedDataVariantAtribute("09/2021", 2, 122); // Thời điểm ra mắt
        seedDataVariantAtribute("12", 4, 122); // Thời gian bảo hành (tháng)
        seedDataVariantAtribute("134.8 x 6.3 x 195.4 mm", 5, 122); // Kích thước
        seedDataVariantAtribute("293 g", 6, 122); // Trọng lượng sản phẩm
        seedDataVariantAtribute("70%", 13, 122); // Tỷ lệ diện tích sử dụng màn hình
        seedDataVariantAtribute("Không", 18, 122); // Chuẩn kháng nước / Bụi bẩn
        seedDataVariantAtribute("Nhôm nguyên khối", 7, 122); // Chất liệu
        seedDataVariantAtribute("Apple A15 Bionic", 9, 122); // CPU Model
        seedDataVariantAtribute("Hexa-Core, 2 x 2.5 GHz Vortex + 4 x 1.6 GHz Tempest", 10, 122); // Loại CPU & CPU
        seedDataVariantAtribute("6", 11, 122); // Số nhân
        seedDataVariantAtribute("2.5 GHz", 12, 122); // Tốc độ tối đa
        seedDataVariantAtribute("4 GB", 79, 122); // Dung lượng RAM
        seedDataVariantAtribute("LPDDR4X", 66, 122); // Loại RAM
        seedDataVariantAtribute("8.3 inch", 14, 122); // Kích thước màn hình
        seedDataVariantAtribute("IPS LCD", 15, 122); // Công nghệ màn hình
        seedDataVariantAtribute("2048 x 1536 Pixels", 17, 122); // Độ phân giải
        seedDataVariantAtribute("Liquid Retina HD", 16, 122); // Chuẩn màn hình
        seedDataVariantAtribute("16 Triệu", 78, 122); // Màu màn hình
        seedDataVariantAtribute("Kính cường lực Oleophobic", 62, 122); // Chất liệu mặt kính
        seedDataVariantAtribute("Điện dung đa điểm", 63, 122); // Loại cảm ứng
        seedDataVariantAtribute("324 ppi", 22, 122); // Mật độ điểm ảnh
        seedDataVariantAtribute("4:3", 26, 122); // Tỷ lệ màn hình
        seedDataVariantAtribute("Apple GPU 5 nhân", 24, 122); // Chip đồ hoạ (GPU)
        seedDataVariantAtribute("467.478", 80, 122); // ANTUTU
        seedDataVariantAtribute("Tùy bộ nhớ", 82, 122); // Danh bạ lưu trữ
        seedDataVariantAtribute("Không", 83, 122); // Thẻ nhớ ngoài
        seedDataVariantAtribute("Standard", 27, 122); // Camera Type 1
        seedDataVariantAtribute("12.0 MP", 28, 122); // Resolution (Camera 1)
        seedDataVariantAtribute("ƒ/1.8", 29, 122); // Aperture (Camera 1)
        seedDataVariantAtribute("Tự động lấy nét (AF), ISO Setting, Nhận diện khuôn mặt, Trôi nhanh thời gian (Time Lapse), Gắn thẻ ảnh địa lý, Zoom kỹ thuật số, Cài đặt cân bằng trắng, Toàn cảnh (Panorama), HDR, Quay chậm (Slow Motion)", 35, 122); // Tính năng camera sau
        seedDataVariantAtribute("Single selfie camera", 32, 122); // Số Camera Selfie
        seedDataVariantAtribute("12.0 MP", 33, 122); // Resolution (Camera Selfie 1)
        seedDataVariantAtribute("Quay phim HD", 34, 122); // Quay phim camera selfie
        seedDataVariantAtribute("Tự động lấy nét (AF)", 35, 122); // Tính năng camera selfie
        seedDataVariantAtribute("Cảm biến ánh sáng, Con quay hồi chuyển, Cảm biến tiệm cận, Cảm biến la bàn, Cảm biến trọng lực, Cảm biến vân tay", 36, 122); // Cảm biến
        seedDataVariantAtribute("Mở khóa bằng mật mã", 37, 122); // Bảo mật
        seedDataVariantAtribute("802.11 b/g/n/ac, Dual-band (2.4 GHz/ 5 GHz)", 42, 122); // Wifi
        seedDataVariantAtribute("Computer sync", 43, 122); // Kết nối khác
        seedDataVariantAtribute("Lithium polymer", 47, 122); // Loại PIN
        seedDataVariantAtribute("10 Giờ", 48, 122); // Dung lượng pin
        seedDataVariantAtribute("iPadOS", 49, 122); // OS
        seedDataVariantAtribute("Sạc, Sách HDSD, Cáp", 57, 122); // Phụ kiện trong hộp

        seedDataVariant("iPad mini 6 2021 8.3 inch WiFi 64GB ", 12999019.0, 8, 34);

        seedDataVariantAtribute("Tím", 3, 123); // Thông tin hàng hóa - Màu sắc
        seedDataVariantAtribute("64GB", 24, 123); // Dung lượng
        seedDataVariantAtribute("Trung Quốc", 1, 123); // Xuất xứ
        seedDataVariantAtribute("09/2021", 2, 123); // Thời điểm ra mắt
        seedDataVariantAtribute("12", 4, 123); // Thời gian bảo hành (tháng)
        seedDataVariantAtribute("134.8 x 6.3 x 195.4 mm", 5, 123); // Kích thước
        seedDataVariantAtribute("293 g", 6, 123); // Trọng lượng sản phẩm
        seedDataVariantAtribute("70%", 13, 123); // Tỷ lệ diện tích sử dụng màn hình
        seedDataVariantAtribute("Không", 18, 123); // Chuẩn kháng nước / Bụi bẩn
        seedDataVariantAtribute("Nhôm nguyên khối", 7, 123); // Chất liệu
        seedDataVariantAtribute("Apple A15 Bionic", 9, 123); // CPU Model
        seedDataVariantAtribute("Hexa-Core, 2 x 2.5 GHz Vortex + 4 x 1.6 GHz Tempest", 10, 123); // Loại CPU & CPU
        seedDataVariantAtribute("6", 11, 123); // Số nhân
        seedDataVariantAtribute("2.5 GHz", 12, 123); // Tốc độ tối đa
        seedDataVariantAtribute("4 GB", 79, 123); // Dung lượng RAM
        seedDataVariantAtribute("LPDDR4X", 66, 123); // Loại RAM
        seedDataVariantAtribute("8.3 inch", 14, 123); // Kích thước màn hình
        seedDataVariantAtribute("IPS LCD", 15, 123); // Công nghệ màn hình
        seedDataVariantAtribute("2048 x 1536 Pixels", 17, 123); // Độ phân giải
        seedDataVariantAtribute("Liquid Retina HD", 16, 123); // Chuẩn màn hình
        seedDataVariantAtribute("16 Triệu", 78, 123); // Màu màn hình
        seedDataVariantAtribute("Kính cường lực Oleophobic", 62, 123); // Chất liệu mặt kính
        seedDataVariantAtribute("Điện dung đa điểm", 63, 123); // Loại cảm ứng
        seedDataVariantAtribute("324 ppi", 22, 123); // Mật độ điểm ảnh
        seedDataVariantAtribute("4:3", 26, 123); // Tỷ lệ màn hình
        seedDataVariantAtribute("Apple GPU 5 nhân", 24, 123); // Chip đồ hoạ (GPU)
        seedDataVariantAtribute("467.478", 80, 123); // ANTUTU
        seedDataVariantAtribute("Tùy bộ nhớ", 82, 123); // Danh bạ lưu trữ
        seedDataVariantAtribute("Không", 83, 123); // Thẻ nhớ ngoài
        seedDataVariantAtribute("Standard", 27, 123); // Camera Type 1
        seedDataVariantAtribute("12.0 MP", 28, 123); // Resolution (Camera 1)
        seedDataVariantAtribute("ƒ/1.8", 29, 123); // Aperture (Camera 1)
        seedDataVariantAtribute("Tự động lấy nét (AF), ISO Setting, Nhận diện khuôn mặt, Trôi nhanh thời gian (Time Lapse), Gắn thẻ ảnh địa lý, Zoom kỹ thuật số, Cài đặt cân bằng trắng, Toàn cảnh (Panorama), HDR, Quay chậm (Slow Motion)", 35, 123); // Tính năng camera sau
        seedDataVariantAtribute("Single selfie camera", 32, 123); // Số Camera Selfie
        seedDataVariantAtribute("12.0 MP", 33, 123); // Resolution (Camera Selfie 1)
        seedDataVariantAtribute("Quay phim HD", 34, 123); // Quay phim camera selfie
        seedDataVariantAtribute("Tự động lấy nét (AF)", 35, 123); // Tính năng camera selfie
        seedDataVariantAtribute("Cảm biến ánh sáng, Con quay hồi chuyển, Cảm biến tiệm cận, Cảm biến la bàn, Cảm biến trọng lực, Cảm biến vân tay", 36, 123); // Cảm biến
        seedDataVariantAtribute("Mở khóa bằng mật mã", 37, 123); // Bảo mật
        seedDataVariantAtribute("802.11 b/g/n/ac, Dual-band (2.4 GHz/ 5 GHz)", 42, 123); // Wifi
        seedDataVariantAtribute("Computer sync", 43, 123); // Kết nối khác
        seedDataVariantAtribute("Lithium polymer", 47, 123); // Loại PIN
        seedDataVariantAtribute("10 Giờ", 48, 123); // Dung lượng pin
        seedDataVariantAtribute("iPadOS", 49, 123); // OS
        seedDataVariantAtribute("Sạc, Sách HDSD, Cáp", 57, 123); // Phụ kiện trong hộp


        seedDataVariant("iPad mini 6 2021 8.3 inch WiFi 256GB ", 16999018.0, 8, 34);

        seedDataVariantAtribute("Xám", 3, 124); // Thông tin hàng hóa - Màu sắc
        seedDataVariantAtribute("256GB", 24, 124); // Dung lượng
        seedDataVariantAtribute("Trung Quốc", 1, 124); // Xuất xứ
        seedDataVariantAtribute("09/2021", 2, 124); // Thời điểm ra mắt
        seedDataVariantAtribute("12", 4, 124); // Thời gian bảo hành (tháng)
        seedDataVariantAtribute("134.8 x 6.3 x 195.4 mm", 5, 124); // Kích thước
        seedDataVariantAtribute("293 g", 6, 124); // Trọng lượng sản phẩm
        seedDataVariantAtribute("70%", 13, 124); // Tỷ lệ diện tích sử dụng màn hình
        seedDataVariantAtribute("Không", 18, 124); // Chuẩn kháng nước / Bụi bẩn
        seedDataVariantAtribute("Nhôm nguyên khối", 7, 124); // Chất liệu
        seedDataVariantAtribute("Apple A15 Bionic", 9, 124); // CPU Model
        seedDataVariantAtribute("Hexa-Core, 2 x 2.5 GHz Vortex + 4 x 1.6 GHz Tempest", 10, 124); // Loại CPU & CPU
        seedDataVariantAtribute("6", 11, 124); // Số nhân
        seedDataVariantAtribute("2.5 GHz", 12, 124); // Tốc độ tối đa
        seedDataVariantAtribute("4 GB", 79, 124); // Dung lượng RAM
        seedDataVariantAtribute("LPDDR4X", 66, 124); // Loại RAM
        seedDataVariantAtribute("8.3 inch", 14, 124); // Kích thước màn hình
        seedDataVariantAtribute("IPS LCD", 15, 124); // Công nghệ màn hình
        seedDataVariantAtribute("2048 x 1536 Pixels", 17, 124); // Độ phân giải
        seedDataVariantAtribute("Liquid Retina HD", 16, 124); // Chuẩn màn hình
        seedDataVariantAtribute("16 Triệu", 78, 124); // Màu màn hình
        seedDataVariantAtribute("Kính cường lực Oleophobic", 62, 124); // Chất liệu mặt kính
        seedDataVariantAtribute("Điện dung đa điểm", 63, 124); // Loại cảm ứng
        seedDataVariantAtribute("324 ppi", 22, 124); // Mật độ điểm ảnh
        seedDataVariantAtribute("4:3", 26, 124); // Tỷ lệ màn hình
        seedDataVariantAtribute("Apple GPU 5 nhân", 24, 124); // Chip đồ hoạ (GPU)
        seedDataVariantAtribute("467.478", 80, 124); // ANTUTU
        seedDataVariantAtribute("Tùy bộ nhớ", 82, 124); // Danh bạ lưu trữ
        seedDataVariantAtribute("Không", 83, 124); // Thẻ nhớ ngoài
        seedDataVariantAtribute("Standard", 27, 124); // Camera Type 1
        seedDataVariantAtribute("12.0 MP", 28, 124); // Resolution (Camera 1)
        seedDataVariantAtribute("ƒ/1.8", 29, 124); // Aperture (Camera 1)
        seedDataVariantAtribute("Tự động lấy nét (AF), ISO Setting, Nhận diện khuôn mặt, Trôi nhanh thời gian (Time Lapse), Gắn thẻ ảnh địa lý, Zoom kỹ thuật số, Cài đặt cân bằng trắng, Toàn cảnh (Panorama), HDR, Quay chậm (Slow Motion)", 35, 124); // Tính năng camera sau
        seedDataVariantAtribute("Single selfie camera", 32, 124); // Số Camera Selfie
        seedDataVariantAtribute("12.0 MP", 33, 124); // Resolution (Camera Selfie 1)
        seedDataVariantAtribute("Quay phim HD", 34, 124); // Quay phim camera selfie
        seedDataVariantAtribute("Tự động lấy nét (AF)", 35, 124); // Tính năng camera selfie
        seedDataVariantAtribute("Cảm biến ánh sáng, Con quay hồi chuyển, Cảm biến tiệm cận, Cảm biến la bàn, Cảm biến trọng lực, Cảm biến vân tay", 36, 124); // Cảm biến
        seedDataVariantAtribute("Mở khóa bằng mật mã", 37, 124); // Bảo mật
        seedDataVariantAtribute("802.11 b/g/n/ac, Dual-band (2.4 GHz/ 5 GHz)", 42, 124); // Wifi
        seedDataVariantAtribute("Computer sync", 43, 124); // Kết nối khác
        seedDataVariantAtribute("Lithium polymer", 47, 124); // Loại PIN
        seedDataVariantAtribute("10 Giờ", 48, 124); // Dung lượng pin
        seedDataVariantAtribute("iPadOS", 49, 124); // OS
        seedDataVariantAtribute("Sạc, Sách HDSD, Cáp", 57, 124); // Phụ kiện trong hộp

        seedDataVariant("iPad mini 6 2021 8.3 inch WiFi 256GB ", 16999019.0, 8, 34);

        seedDataVariantAtribute("Tím", 3, 125); // Thông tin hàng hóa - Màu sắc
        seedDataVariantAtribute("256GB", 24, 125); // Dung lượng
        seedDataVariantAtribute("Trung Quốc", 1, 125); // Xuất xứ
        seedDataVariantAtribute("09/2021", 2, 125); // Thời điểm ra mắt
        seedDataVariantAtribute("12", 4, 125); // Thời gian bảo hành (tháng)
        seedDataVariantAtribute("134.8 x 6.3 x 195.4 mm", 5, 125); // Kích thước
        seedDataVariantAtribute("293 g", 6, 125); // Trọng lượng sản phẩm
        seedDataVariantAtribute("70%", 13, 125); // Tỷ lệ diện tích sử dụng màn hình
        seedDataVariantAtribute("Không", 18, 125); // Chuẩn kháng nước / Bụi bẩn
        seedDataVariantAtribute("Nhôm nguyên khối", 7, 125); // Chất liệu
        seedDataVariantAtribute("Apple A15 Bionic", 9, 125); // CPU Model
        seedDataVariantAtribute("Hexa-Core, 2 x 2.5 GHz Vortex + 4 x 1.6 GHz Tempest", 10, 125); // Loại CPU & CPU
        seedDataVariantAtribute("6", 11, 125); // Số nhân
        seedDataVariantAtribute("2.5 GHz", 12, 125); // Tốc độ tối đa
        seedDataVariantAtribute("4 GB", 79, 125); // Dung lượng RAM
        seedDataVariantAtribute("LPDDR4X", 66, 125); // Loại RAM
        seedDataVariantAtribute("8.3 inch", 14, 125); // Kích thước màn hình
        seedDataVariantAtribute("IPS LCD", 15, 125); // Công nghệ màn hình
        seedDataVariantAtribute("2048 x 1536 Pixels", 17, 125); // Độ phân giải
        seedDataVariantAtribute("Liquid Retina HD", 16, 125); // Chuẩn màn hình
        seedDataVariantAtribute("16 Triệu", 78, 125); // Màu màn hình
        seedDataVariantAtribute("Kính cường lực Oleophobic", 62, 125); // Chất liệu mặt kính
        seedDataVariantAtribute("Điện dung đa điểm", 63, 125); // Loại cảm ứng
        seedDataVariantAtribute("324 ppi", 22, 125); // Mật độ điểm ảnh
        seedDataVariantAtribute("4:3", 26, 125); // Tỷ lệ màn hình
        seedDataVariantAtribute("Apple GPU 5 nhân", 24, 125); // Chip đồ hoạ (GPU)
        seedDataVariantAtribute("467.478", 80, 125); // ANTUTU
        seedDataVariantAtribute("Tùy bộ nhớ", 82, 125); // Danh bạ lưu trữ
        seedDataVariantAtribute("Không", 83, 125); // Thẻ nhớ ngoài
        seedDataVariantAtribute("Standard", 27, 125); // Camera Type 1
        seedDataVariantAtribute("12.0 MP", 28, 125); // Resolution (Camera 1)
        seedDataVariantAtribute("ƒ/1.8", 29, 125); // Aperture (Camera 1)
        seedDataVariantAtribute("Tự động lấy nét (AF), ISO Setting, Nhận diện khuôn mặt, Trôi nhanh thời gian (Time Lapse), Gắn thẻ ảnh địa lý, Zoom kỹ thuật số, Cài đặt cân bằng trắng, Toàn cảnh (Panorama), HDR, Quay chậm (Slow Motion)", 35, 125); // Tính năng camera sau
        seedDataVariantAtribute("Single selfie camera", 32, 125); // Số Camera Selfie
        seedDataVariantAtribute("12.0 MP", 33, 125); // Resolution (Camera Selfie 1)
        seedDataVariantAtribute("Quay phim HD", 34, 125); // Quay phim camera selfie
        seedDataVariantAtribute("Tự động lấy nét (AF)", 35, 125); // Tính năng camera selfie
        seedDataVariantAtribute("Cảm biến ánh sáng, Con quay hồi chuyển, Cảm biến tiệm cận, Cảm biến la bàn, Cảm biến trọng lực, Cảm biến vân tay", 36, 125); // Cảm biến
        seedDataVariantAtribute("Mở khóa bằng mật mã", 37, 125); // Bảo mật
        seedDataVariantAtribute("802.11 b/g/n/ac, Dual-band (2.4 GHz/ 5 GHz)", 42, 125); // Wifi
        seedDataVariantAtribute("Computer sync", 43, 125); // Kết nối khác
        seedDataVariantAtribute("Lithium polymer", 47, 125); // Loại PIN
        seedDataVariantAtribute("10 Giờ", 48, 125); // Dung lượng pin
        seedDataVariantAtribute("iPadOS", 49, 125); // OS
        seedDataVariantAtribute("Sạc, Sách HDSD, Cáp", 57, 125); // Phụ kiện trong hộp

        // Samsung Galaxy Tab S10 Plus Wifi 12GB 256GB

        seedDataProduct("Samsung Galaxy Tab", "Ipad", 0.571, 13, 3, 3, "");

        seedDataVariant("Samsung Galaxy Tab S10 Plus Wifi 12GB 256GB ", 25999018.0, 8, 35);
        seedDataVariantAtribute("256 GB", 24, 126); // Dung lượng
        seedDataVariantAtribute("Xám", 3, 126); // Thông tin hàng hóa - Màu sắc
        seedDataVariantAtribute("Việt Nam / Trung Quốc", 1, 126); // Xuất xứ
        seedDataVariantAtribute("10/2024", 2, 126); // Thời điểm ra mắt
        seedDataVariantAtribute("12", 4, 126); // Thời gian bảo hành (tháng)
        seedDataVariantAtribute("Để nơi khô ráo, nhẹ tay, dễ vỡ. Xem trong sách hướng dẫn sử dụng", 48, 126); // Hướng dẫn bảo quản và sử dụng
        seedDataVariantAtribute("Dài 285.4 mm - Ngang 185.4 mm - Dày 5.7 mm", 5, 126); // Kích thước
        seedDataVariantAtribute("571 g", 6, 126); // Trọng lượng sản phẩm
        seedDataVariantAtribute("IP68", 18, 126); // Chuẩn kháng nước / Bụi bẩn
        seedDataVariantAtribute("Khung viền: Armor aluminum, Mặt lưng máy: Armor aluminum", 7, 126); // Chất liệu
        seedDataVariantAtribute("Dimensity 9300+", 9, 126); // CPU Model
        seedDataVariantAtribute("8", 11, 126); // Số nhân
        seedDataVariantAtribute("12 GB", 79, 126); // Dung lượng RAM
        seedDataVariantAtribute("12.4 inch", 14, 126); // Kích thước màn hình
        seedDataVariantAtribute("Dynamic AMOLED 2X", 15, 126); // Công nghệ màn hình
        seedDataVariantAtribute("1752 x 2800 Pixels", 17, 126); // Độ phân giải
        seedDataVariantAtribute("Dynamic AMOLED 2X", 16, 126); // Chuẩn màn hình
        seedDataVariantAtribute("16 Triệu", 78, 126); // Màu màn hình
        seedDataVariantAtribute("120", 22, 126); // Tần số quét
        seedDataVariantAtribute("ARM Immortalis G720", 24, 126); // Chip đồ hoạ (GPU)
        seedDataVariantAtribute("Không giới hạn", 82, 126); // Danh bạ lưu trữ
        seedDataVariantAtribute("MicroSD", 83, 126); // Thẻ nhớ ngoài
        seedDataVariantAtribute("1.5 TB", 84, 126); // Hỗ trợ thẻ nhớ tối đa
        seedDataVariantAtribute("Double rear camera", 27, 126); // Số camera sau
        seedDataVariantAtribute("Resolution (Camera 1): 13.0 MP, Resolution (Camera 2): 8.0 MP", 28, 126); // Độ phân giải Camera
        seedDataVariantAtribute("4K 2160p@30fps", 30, 126); // Quay phim
        seedDataVariantAtribute("Tự động lấy nét (AF), Quét tài liệu, Xóa phông, Chụp góc siêu rộng (Ultrawide), Trôi nhanh thời gian (Time Lapse), Toàn cảnh (Panorama), Chuyên nghiệp (Pro), HDR", 35, 126); // Tính năng camera sau
        seedDataVariantAtribute("Single selfie camera", 32, 126); // Số Camera Selfie
        seedDataVariantAtribute("12.0 MP", 33, 126); // Resolution (Camera Selfie)
        seedDataVariantAtribute("Xóa phông, Chế độ chân dung, Trôi nhanh thời gian (Time lapse), Làm đẹp (Beautify), Chụp góc rộng (Wide), Bộ lọc màu, Hẹn giờ chụp tự động", 35, 126); // Tính năng camera selfie
        seedDataVariantAtribute("Mở khóa vân tay dưới màn hình", 37, 126); // Bảo mật
        seedDataVariantAtribute("Cổng sạc: Type C", 41, 126); // Cổng giao tiếp
        seedDataVariantAtribute("Wifi 6E, 802.11 a/b/g/n, MIMO, Wi-Fi Direct", 42, 126); // Wifi
        seedDataVariantAtribute("GPS, GLONASS, BEIDOU, GALILEO, QZSS", 46, 126); // GPS
        seedDataVariantAtribute("v5.3", 44, 126); // Bluetooth
        seedDataVariantAtribute("Bluetooth", 43, 126); // Kết nối khác
        seedDataVariantAtribute("Pin Li-ion", 47, 126); // Loại PIN
        seedDataVariantAtribute("10090 mAh", 48, 126); // Dung lượng pin
        seedDataVariantAtribute("Android", 49, 126); // OS
        seedDataVariantAtribute("Android 14", 50, 126); // Version
        seedDataVariantAtribute("Dây cáp sạc, Sách HDSD, Bút cảm ứng", 57, 126); // Phụ kiện trong hộp

        // Samsung Galaxy Tab S10 Ultra 5G 12GB 256GB
        seedDataVariant("Samsung Galaxy Tab S10 Ultra 5G 12GB 256GB", 33999018.0, 8, 35);
        seedDataVariantAtribute("256 GB", 24, 127); // Dung lượng
        seedDataVariantAtribute("Xám", 3, 127); // Thông tin hàng hóa - Màu sắc
        seedDataVariantAtribute("Việt Nam / Trung Quốc", 1, 127); // Xuất xứ
        seedDataVariantAtribute("10/2024", 2, 127); // Thời điểm ra mắt
        seedDataVariantAtribute("12", 4, 127); // Thời gian bảo hành (tháng)
        seedDataVariantAtribute("Để nơi khô ráo, nhẹ tay, dễ vỡ.", 48, 127); // Hướng dẫn bảo quản
        seedDataVariantAtribute("Dài 326.4 mm - Ngang 208.6 mm - Dày 5.4 mm", 5, 127); // Kích thước
        seedDataVariantAtribute("723 g", 6, 127); // Trọng lượng sản phẩm
        seedDataVariantAtribute("IP68", 18, 127); // Chuẩn kháng nước / Bụi bẩn
        seedDataVariantAtribute("Khung màn hình: Armor aluminum, Mặt lưng máy: Armor aluminum", 7, 127); // Chất liệu
        seedDataVariantAtribute("Dimensity 9300+", 9, 127); // CPU Model
        seedDataVariantAtribute("8", 11, 127); // Số nhân
        seedDataVariantAtribute("12 GB", 79, 127); // Dung lượng RAM
        seedDataVariantAtribute("14.6 inch", 14, 127); // Kích thước màn hình
        seedDataVariantAtribute("2960 x 1848 Pixels", 17, 127); // Độ phân giải
        seedDataVariantAtribute("Dynamic AMOLED 2X", 16, 127); // Chuẩn màn hình
        seedDataVariantAtribute("16 Triệu", 78, 127); // Màu màn hình
        seedDataVariantAtribute("Corning Gorilla Glass", 62, 127); // Chất liệu mặt kính
        seedDataVariantAtribute("ARM Immortalis G720", 24, 127); // Chip đồ hoạ (GPU)
        seedDataVariantAtribute("Không giới hạn", 82, 127); // Danh bạ lưu trữ
        seedDataVariantAtribute("MicroSD", 83, 127); // Thẻ nhớ ngoài
        seedDataVariantAtribute("1.5 TB", 84, 127); // Hỗ trợ thẻ nhớ tối đa
        seedDataVariantAtribute("Double rear camera", 27, 127); // Số camera sau
        seedDataVariantAtribute("Resolution (Camera 1): 13.0 MP, Resolution (Camera 2): 8.0 MP", 28, 127); // Độ phân giải Camera
        seedDataVariantAtribute("4K 2160p@30fps", 30, 127); // Quay phim
        seedDataVariantAtribute("Tự động lấy nét (AF), Zoom quang học, Zoom kỹ thuật số, Xóa phông, Chụp góc siêu rộng (Ultrawide), Trôi nhanh thời gian (Time Lapse), Toàn cảnh (Panorama), Chuyên nghiệp (Pro), HDR, Quét tài liệu", 35, 127); // Tính năng camera sau
        seedDataVariantAtribute("Single selfie camera", 32, 127); // Số Camera Selfie
        seedDataVariantAtribute("12.0 MP", 33, 127); // Resolution (Camera Selfie)
        seedDataVariantAtribute("Chế độ chân dung, Xóa phông, Làm đẹp (Beautify), Chụp góc rộng (Wide), Bộ lọc màu, Hẹn giờ chụp tự động", 35, 127); // Tính năng camera selfie
        seedDataVariantAtribute("Mở khóa vân tay dưới màn hình", 37, 127); // Bảo mật
        seedDataVariantAtribute("1", 38, 127); // Số khe SIM
        seedDataVariantAtribute("1 eSIM, 1 Nano SIM", 39, 127); // Thẻ SIM
        seedDataVariantAtribute("5G", 40, 127); // Hỗ trợ mạng
        seedDataVariantAtribute("Cổng sạc: Type C", 41, 127); // Cổng giao tiếp
        seedDataVariantAtribute("Wifi 7, MIMO, 802.11 a/b/g/n", 42, 127); // Wifi
        seedDataVariantAtribute("GPS, GLONASS, BEIDOU, GALILEO, QZSS", 46, 127); // GPS
        seedDataVariantAtribute("v5.3", 44, 127); // Bluetooth
        seedDataVariantAtribute("Pin Li-ion", 47, 127); // Loại PIN
        seedDataVariantAtribute("11200 mAh", 48, 127); // Dung lượng pin
        seedDataVariantAtribute("Sạc pin nhanh", 85, 127); // Thông tin thêm
        seedDataVariantAtribute("Android", 49, 127); // OS
        seedDataVariantAtribute("Android 14", 50, 127); // Version
        seedDataVariantAtribute("Dây cáp sạc, Que lấy SIM, Sách HDSD, Bút cảm ứng", 57, 127); // Phụ kiện trong hộp


        // Samsung Galaxy Tab S9 FE WiFi 6GB 128GB
        seedDataVariant("Samsung Galaxy Tab S9 FE WiFi 6GB 128GB", 9999018.0, 8, 35);
        seedDataVariantAtribute("128 GB", 24, 128); // Dung lượng
        seedDataVariantAtribute("Xám", 3, 128); // Thông tin hàng hóa - Màu sắc
        seedDataVariantAtribute("Việt Nam / Trung Quốc", 1, 128); // Xuất xứ
        seedDataVariantAtribute("10/2023", 2, 128); // Thời điểm ra mắt
        seedDataVariantAtribute("12", 4, 128); // Thời gian bảo hành (tháng)
        seedDataVariantAtribute("Để nơi khô ráo, nhẹ tay, dễ vỡ. Xem trong sách hướng dẫn sử dụng", 48, 128); // Hướng dẫn bảo quản và sử dụng
        seedDataVariantAtribute("254.3 x 165.8 x 6.5 mm", 5, 128); // Kích thước
        seedDataVariantAtribute("520 g", 6, 128); // Trọng lượng sản phẩm
        seedDataVariantAtribute("IP68", 18, 128); // Chuẩn kháng nước / Bụi bẩn
        seedDataVariantAtribute("Mặt lưng máy: Kim loại", 7, 128); // Chất liệu
        seedDataVariantAtribute("Exynos 1380", 9, 128); // CPU Model
        seedDataVariantAtribute("8 x 2.4 GHz", 10, 128); // CPU
        seedDataVariantAtribute("8", 11, 128); // Số nhân
        seedDataVariantAtribute("2.4 GHz", 12, 128); // Tốc độ tối đa
        seedDataVariantAtribute("6 GB", 79, 128); // Dung lượng RAM
        seedDataVariantAtribute("10.9 inch", 14, 128); // Kích thước màn hình
        seedDataVariantAtribute("LCD", 15, 128); // Công nghệ màn hình
        seedDataVariantAtribute("2304 x 1440 Pixels", 17, 128); // Độ phân giải
        seedDataVariantAtribute("WUXGA", 16, 128); // Chuẩn màn hình
        seedDataVariantAtribute("16 Triệu", 78, 128); // Màu màn hình
        seedDataVariantAtribute("Điện dung đa điểm", 63, 128); // Loại cảm ứng
        seedDataVariantAtribute("90 Hz", 22, 128); // Tần số quét
        seedDataVariantAtribute("HDR10+", 73, 128); // Độ phủ màu
        seedDataVariantAtribute("16:10", 26, 128); // Tỷ lệ màn hình
        seedDataVariantAtribute("Mali-G68", 24, 128); // Chip đồ hoạ (GPU)
        seedDataVariantAtribute("Không giới hạn", 82, 128); // Danh bạ lưu trữ
        seedDataVariantAtribute("1 TB", 84, 128); // Hỗ trợ thẻ nhớ tối đa
        seedDataVariantAtribute("Double rear camera", 27, 128); // Số camera sau
        seedDataVariantAtribute("Resolution (Camera 1): 8.0 MP, Resolution (Camera 2): 8.0 MP", 28, 128); // Độ phân giải Camera
        seedDataVariantAtribute("4K 2160p@30fps", 30, 128); // Quay phim
        seedDataVariantAtribute("Tự động lấy nét (AF), HDR, Chuyên nghiệp (Pro), Xóa phông, Toàn cảnh (Panorama), Chụp chuyển động, Chạm lấy nét, Làm đẹp (Beautify), Chụp góc siêu rộng (Ultrawide), Zoom kỹ thuật số", 35, 128); // Tính năng camera sau
        seedDataVariantAtribute("Single selfie camera", 32, 128); // Số Camera Selfie
        seedDataVariantAtribute("12.0 MP", 33, 128); // Resolution (Camera Selfie)
        seedDataVariantAtribute("Chụp góc rộng (Wide), HDR, Xoá phông, Bộ lọc màu, Flash màn hình", 35, 128); // Tính năng camera selfie
        seedDataVariantAtribute("Cảm biến gia tốc, Cảm biến ánh sáng", 36, 128); // Cảm biến
        seedDataVariantAtribute("Mở khóa vân tay", 37, 128); // Bảo mật
        seedDataVariantAtribute("Cổng sạc: Type C, Audio Jack: Type C", 41, 128); // Cổng giao tiếp
        seedDataVariantAtribute("802.11 ac, Dual-band (2.4 GHz/ 5 GHz), Wi-Fi Direct", 42, 128); // Wifi
        seedDataVariantAtribute("v5.3", 44, 128); // Bluetooth
        seedDataVariantAtribute("Bluetooth", 43, 128); // Kết nối khác
        seedDataVariantAtribute("Lithium polymer", 47, 128); // Loại PIN
        seedDataVariantAtribute("8000 mAh", 48, 128); // Dung lượng pin
        seedDataVariantAtribute("Sạc pin nhanh", 85, 128); // Thông tin thêm
        seedDataVariantAtribute("Android", 49, 128); // OS
        seedDataVariantAtribute("Android 13.0", 50, 128); // Version
        seedDataVariantAtribute("Sách HDSD, Bút cảm ứng", 57, 128); // Phụ kiện trong hộp

        // Samsung Galaxy Tab A9 Plus WiFi 4GB 64GB
        seedDataVariant("Samsung Galaxy Tab A9 Plus WiFi 4GB 64GB", 8999018.0, 8, 35);
        seedDataVariantAtribute("64 GB", 24, 129); // Dung lượng
        seedDataVariantAtribute("Xám", 3, 129); // Thông tin hàng hóa - Màu sắc
        seedDataVariantAtribute("Việt Nam / Trung Quốc", 1, 129); // Xuất xứ
        seedDataVariantAtribute("10/2023", 2, 129); // Thời điểm ra mắt
        seedDataVariantAtribute("12", 4, 129); // Thời gian bảo hành (tháng)
        seedDataVariantAtribute("Để nơi khô ráo, nhẹ tay, dễ vỡ. Xem trong sách hướng dẫn sử dụng", 48, 129); // Hướng dẫn bảo quản và sử dụng
        seedDataVariantAtribute("257.1 x 168.7 x 6.9 mm", 5, 129); // Kích thước
        seedDataVariantAtribute("510 g", 6, 129); // Trọng lượng sản phẩm
        seedDataVariantAtribute("Mặt lưng máy: Kim loại", 7, 129); // Chất liệu
        seedDataVariantAtribute("Snapdragon 695 5G", 9, 129); // CPU Model
        seedDataVariantAtribute("2 x 2.2 GHz + 6 x 1.7 GHz", 10, 129); // CPU
        seedDataVariantAtribute("8", 11, 129); // Số nhân
        seedDataVariantAtribute("4 GB", 79, 129); // Dung lượng RAM
        seedDataVariantAtribute("11 inch", 14, 129); // Kích thước màn hình
        seedDataVariantAtribute("LCD Chính:", 15, 129); // Công nghệ màn hình
        seedDataVariantAtribute("1200 x 1920 Pixels", 17, 129); // Độ phân giải
        seedDataVariantAtribute("WUXGA", 16, 129); // Chuẩn màn hình
        seedDataVariantAtribute("16 Triệu", 78, 129); // Màu màn hình
        seedDataVariantAtribute("Điện dung đa điểm", 63, 129); // Loại cảm ứng
        seedDataVariantAtribute("90 Hz", 22, 129); // Tần số quét
        seedDataVariantAtribute("570 nits", 20, 129); // Độ sáng
        seedDataVariantAtribute("16:10", 26, 129); // Tỷ lệ màn hình
        seedDataVariantAtribute("Không giới hạn", 82, 129); // Danh bạ lưu trữ
        seedDataVariantAtribute("MicroSD", 83, 129); // Thẻ nhớ ngoài
        seedDataVariantAtribute("1 TB", 84, 129); // Hỗ trợ thẻ nhớ tối đa
        seedDataVariantAtribute("Single rear camera", 27, 129); // Số camera sau
        seedDataVariantAtribute("Wide", 27, 129); // Camera
        seedDataVariantAtribute("8.0 MP", 28, 129); // Resolution (Camera)
        seedDataVariantAtribute("ƒ/2.0", 29, 129); // Aperture (Camera)
        seedDataVariantAtribute("Single selfie camera", 32, 129); // Số Camera Selfie
        seedDataVariantAtribute("5.0 MP", 33, 129); // Resolution (Camera Selfie)
        seedDataVariantAtribute("ƒ/2.2", 34, 129); // Aperture (Camera Selfie)
        seedDataVariantAtribute("Cảm biến gia tốc, Cảm biến ánh sáng", 36, 129); // Cảm biến
        seedDataVariantAtribute("Mở khóa khuôn mặt", 37, 129); // Bảo mật
        seedDataVariantAtribute("Cổng sạc: Type C, Audio Jack: Type C", 41, 129); // Cổng giao tiếp
        seedDataVariantAtribute("802.11 ac", 42, 129); // Wifi
        seedDataVariantAtribute("v5.3", 44, 129); // Bluetooth
        seedDataVariantAtribute("Bluetooth", 43, 129); // Kết nối khác
        seedDataVariantAtribute("Lithium polymer", 47, 129); // Loại PIN
        seedDataVariantAtribute("7040 mAh", 48, 129); // Dung lượng pin
        seedDataVariantAtribute("Android", 49, 129); // OS
        seedDataVariantAtribute("Android 13.0", 50, 129); // Version
        seedDataVariantAtribute("Sách HDSD", 57, 129); // Phụ kiện trong hộp


        // Samsung Galaxy Tab S9 FE Plus WiFi 8GB 128GB
        seedDataVariant("Samsung Galaxy Tab S9 FE Plus WiFi 8GB 128GB", 13999019.0, 8, 35);
        seedDataVariantAtribute("128 GB", 24, 130); // Dung lượng
        seedDataVariantAtribute("Bạc", 3, 130); // Thông tin hàng hóa - Màu sắc
        seedDataVariantAtribute("Việt Nam / Trung Quốc", 1, 130); // Xuất xứ
        seedDataVariantAtribute("10/2023", 2, 130); // Thời điểm ra mắt
        seedDataVariantAtribute("12", 4, 130); // Thời gian bảo hành (tháng)
        seedDataVariantAtribute("Để nơi khô ráo, nhẹ tay, dễ vỡ. Xem trong sách hướng dẫn sử dụng", 48, 130); // Hướng dẫn bảo quản và sử dụng
        seedDataVariantAtribute("285.4 x 185.4 x 6.5 mm", 5, 130); // Kích thước
        seedDataVariantAtribute("627 g", 6, 130); // Trọng lượng sản phẩm
        seedDataVariantAtribute("IP68", 18, 130); // Chuẩn kháng nước / Bụi bẩn
        seedDataVariantAtribute("Mặt lưng máy: Kim loại", 7, 130); // Chất liệu
        seedDataVariantAtribute("Exynos 1380", 9, 130); // CPU Model
        seedDataVariantAtribute("8 x 2.4 GHz", 10, 130); // CPU
        seedDataVariantAtribute("8", 11, 130); // Số nhân
        seedDataVariantAtribute("2.4 GHz", 12, 130); // Tốc độ tối đa
        seedDataVariantAtribute("8 GB", 79, 130); // Dung lượng RAM
        seedDataVariantAtribute("12.4 inch", 14, 130); // Kích thước màn hình
        seedDataVariantAtribute("PLS LCD", 15, 130); // Công nghệ màn hình
        seedDataVariantAtribute("2560 x 1600 Pixels", 17, 130); // Độ phân giải
        seedDataVariantAtribute("WQXGA", 16, 130); // Chuẩn màn hình
        seedDataVariantAtribute("16 Triệu", 78, 130); // Màu màn hình
        seedDataVariantAtribute("Điện dung đa điểm", 63, 130); // Loại cảm ứng
        seedDataVariantAtribute("90 Hz", 22, 130); // Tần số quét
        seedDataVariantAtribute("16:10", 26, 130); // Tỷ lệ màn hình
        seedDataVariantAtribute("Mali-G68", 24, 130); // Chip đồ hoạ (GPU)
        seedDataVariantAtribute("MicroSD", 83, 130); // Thẻ nhớ ngoài
        seedDataVariantAtribute("1 TB", 84, 130); // Hỗ trợ thẻ nhớ tối đa
        seedDataVariantAtribute("Double rear camera", 27, 130); // Số camera sau
        seedDataVariantAtribute("Wide", 27, 130); // Camera
        seedDataVariantAtribute("Resolution (Camera 1): 8.0 MP, Resolution (Camera 2): 8.0 MP", 28, 130); // Độ phân giải Camera
        seedDataVariantAtribute("4K 2160p@30fps", 30, 130); // Quay phim
        seedDataVariantAtribute("HDR, Bộ lọc màu, Chuyên nghiệp (Pro), Xóa phông, Toàn cảnh (Panorama), Trôi nhanh thời gian (Time Lapse), Chụp chuyển động, Chạm lấy nét, Làm đẹp (Beautify), Zoom kỹ thuật số, Tự động lấy nét (AF), Ban đêm (Night Mode)", 35, 130); // Tính năng camera sau
        seedDataVariantAtribute("Single selfie camera", 32, 130); // Số Camera Selfie
        seedDataVariantAtribute("12.0 MP", 33, 130); // Resolution (Camera Selfie)
        seedDataVariantAtribute("Tự động lấy nét (AF), Xoá phông, HDR, Chuyên nghiệp (Pro), Chụp góc rộng (Wide)", 35, 130); // Tính năng camera selfie
        seedDataVariantAtribute("Cảm biến gia tốc, Cảm biến ánh sáng", 36, 130); // Cảm biến
        seedDataVariantAtribute("Mở khóa vân tay", 37, 130); // Bảo mật
        seedDataVariantAtribute("Cổng sạc: Type C, Audio Jack: Type C", 41, 130); // Cổng giao tiếp
        seedDataVariantAtribute("802.11 ac", 42, 130); // Wifi
        seedDataVariantAtribute("v5.3", 44, 130); // Bluetooth
        seedDataVariantAtribute("Bluetooth", 43, 130); // Kết nối khác
        seedDataVariantAtribute("Lithium polymer", 47, 130); // Loại PIN
        seedDataVariantAtribute("10090 mAh", 48, 130); // Dung lượng pin
        seedDataVariantAtribute("Sạc pin nhanh", 85, 130); // Thông tin thêm
        seedDataVariantAtribute("Android", 49, 130); // OS
        seedDataVariantAtribute("Android 13.0", 50, 130); // Version
        seedDataVariantAtribute("Sách HDSD, Bút cảm ứng", 57, 130); // Phụ kiện trong hộp

        // Xiaomi Pad 6S Pro WiFi 8GB 256GB


        seedDataProduct("Xiaomi Pad", "Ipad", 0.571, 13, 3, 3, "");
        seedDataVariant("Xiaomi Pad 6S Pro WiFi 8GB 256GB ", 12999118.0, 8, 36);
        seedDataVariantAtribute("256GB", 24, 131); // Dung lượng
        seedDataVariantAtribute("Xám", 3, 131); // Thông tin hàng hóa - Màu sắc
        seedDataVariantAtribute("Việt Nam", 1, 131); // Xuất xứ
        seedDataVariantAtribute("09/2024", 2, 131); // Thời điểm ra mắt
        seedDataVariantAtribute("18", 4, 131); // Thời gian bảo hành (tháng)
        seedDataVariantAtribute("278.7 x 191.58 x 6.26 mm", 5, 131); // Kích thước
        seedDataVariantAtribute("590 g", 6, 131); // Trọng lượng sản phẩm
        seedDataVariantAtribute("88.5%", 13, 131); // Tỷ lệ diện tích sử dụng màn hình
        seedDataVariantAtribute("Hợp kim nhôm", 7, 131); // Chất liệu
        seedDataVariantAtribute("Snapdragon 8 Gen 2", 9, 131); // CPU Model
        seedDataVariantAtribute("8", 11, 131); // Số nhân
        seedDataVariantAtribute("8 GB", 79, 131); // Dung lượng RAM
        seedDataVariantAtribute("12.4 inch", 14, 131); // Kích thước màn hình
        seedDataVariantAtribute("2032 x 3048 Pixels", 17, 131); // Độ phân giải
        seedDataVariantAtribute("3K", 16, 131); // Chuẩn màn hình
        seedDataVariantAtribute("Hơn 68 tỷ màu", 78, 131); // Màu màn hình
        seedDataVariantAtribute("Corning Gorilla Glass", 62, 131); // Chất liệu mặt kính
        seedDataVariantAtribute("294 ppi", 22, 131); // Mật độ điểm ảnh
        seedDataVariantAtribute("144", 23, 131); // Tần số quét
        seedDataVariantAtribute("900 nits", 20, 131); // Độ sáng
        seedDataVariantAtribute("100% DCI-P3", 73, 131); // Độ phủ màu
        seedDataVariantAtribute("3:2", 26, 131); // Tỷ lệ màn hình
        seedDataVariantAtribute("1400:1", 21, 131); // Độ tương phản
        seedDataVariantAtribute("Double rear camera", 27, 131); // Số camera sau
        seedDataVariantAtribute("Resolution (Camera 1): 50 MP, Aperture (Camera 1): ƒ/1.8, Pixel size (Camera 1): 0.64 µm", 28, 131); // Camera 1
        seedDataVariantAtribute("Resolution (Camera 2): 2.0 MP, Aperture (Camera 2): ƒ/2.4, Pixel size (Camera 2): 1.75 µm", 28, 131); // Camera 2
        seedDataVariantAtribute("1080p@60fps, 1080p@30fps, 720p@30fps", 30, 131); // Quay phim camera sau
        seedDataVariantAtribute("32.0 MP", 33, 131); // Resolution (Camera Selfie)
        seedDataVariantAtribute("ƒ/2.2", 34, 131); // Aperture (Camera Selfie)
        seedDataVariantAtribute("720p@30fps, 1080p@30fps", 30, 131); // Quay phim camera selfie
        seedDataVariantAtribute("Làm đẹp (Beautify), Xóa phông", 35, 131); // Tính năng camera selfie
        seedDataVariantAtribute("Mở khoá vân tay cạnh viền", 37, 131); // Bảo mật
        seedDataVariantAtribute("Type C", 41, 131); // Cổng giao tiếp
        seedDataVariantAtribute("Wifi 7", 42, 131); // Wifi
        seedDataVariantAtribute("v5.3", 44, 131); // Bluetooth
        seedDataVariantAtribute("Bluetooth", 43, 131); // Kết nối khác
        seedDataVariantAtribute("Lithium polymer", 47, 131); // Loại PIN
        seedDataVariantAtribute("10000 mAh", 48, 131); // Dung lượng pin
        seedDataVariantAtribute("Android", 49, 131); // OS
        seedDataVariantAtribute("Android 14", 50, 131); // Version

        // Xiaomi Pad 6 WiFi 8GB 256GB
        seedDataVariant("Xiaomi Pad 6 WiFi 8GB 256GB", 9299019.0, 8, 36);
        seedDataVariantAtribute("256GB", 24, 132); // Dung lượng
        seedDataVariantAtribute("Xám", 3, 132); // Thông tin hàng hóa - Màu sắc
        seedDataVariantAtribute("Trung Quốc", 1, 132); // Xuất xứ
        seedDataVariantAtribute("08/2023", 2, 132); // Thời điểm ra mắt
        seedDataVariantAtribute("18", 4, 132); // Thời gian bảo hành (tháng)
        seedDataVariantAtribute("Để nơi khô ráo, nhẹ tay, dễ vỡ. Xem trong sách hướng dẫn sử dụng", 48, 132); // Hướng dẫn bảo quản và sử dụng
        seedDataVariantAtribute("253.95 x 165.18 x 6.51 mm", 5, 132); // Kích thước
        seedDataVariantAtribute("490 g", 6, 132); // Trọng lượng sản phẩm
        seedDataVariantAtribute("Khung máy: Kim loại", 7, 132); // Chất liệu
        seedDataVariantAtribute("Snapdragon 870", 9, 132); // CPU Model
        seedDataVariantAtribute("8", 11, 132); // Số nhân
        seedDataVariantAtribute("3.20 GHz", 12, 132); // Tốc độ tối đa
        seedDataVariantAtribute("8 GB", 79, 132); // Dung lượng RAM
        seedDataVariantAtribute("LPDDR4X", 66, 132); // Loại RAM
        seedDataVariantAtribute("11.0 inch", 14, 132); // Kích thước màn hình
        seedDataVariantAtribute("IPS LCD", 15, 132); // Công nghệ màn hình
        seedDataVariantAtribute("2880 x 1800 Pixels", 17, 132); // Độ phân giải
        seedDataVariantAtribute("WQHD+", 16, 132); // Chuẩn màn hình
        seedDataVariantAtribute("144 Hz", 23, 132); // Tần số quét
        seedDataVariantAtribute("Adreno 650", 24, 132); // Chip đồ hoạ (GPU)
        seedDataVariantAtribute("Không", 83, 132); // Thẻ nhớ ngoài
        seedDataVariantAtribute("Single rear camera", 27, 132); // Số camera sau
        seedDataVariantAtribute("Standard", 27, 132); // Camera
        seedDataVariantAtribute("13.0 MP", 28, 132); // Resolution (Camera)
        seedDataVariantAtribute("ƒ/1.9", 29, 132); // Aperture (Camera)
        seedDataVariantAtribute("1080p@30fps, 720p@30fps", 30, 132); // Quay phim camera sau
        seedDataVariantAtribute("8.0 MP", 33, 132); // Resolution (Camera Selfie)
        seedDataVariantAtribute("ƒ/2.1", 34, 132); // Aperture (Camera Selfie)
        seedDataVariantAtribute("Quay phim HD, Quay phim FullHD", 30, 132); // Quay phim camera selfie
        seedDataVariantAtribute("Bộ lọc màu, HDR, Tự động lấy nét (AF)", 35, 132); // Tính năng camera selfie
        seedDataVariantAtribute("Cổng sạc: Type C, Audio Jack: Jack 3.5 mm", 41, 132); // Cổng giao tiếp
        seedDataVariantAtribute("802.11 a/b/g/n/ac, Dual-band (2.4 GHz/ 5 GHz), Wifi 6", 42, 132); // Wifi
        seedDataVariantAtribute("v5.2", 44, 132); // Bluetooth
        seedDataVariantAtribute("OTG", 43, 132); // Kết nối khác
        seedDataVariantAtribute("Lithium polymer", 47, 132); // Loại PIN
        seedDataVariantAtribute("8840 mAh", 48, 132); // Dung lượng pin
        seedDataVariantAtribute("Android", 49, 132); // OS
        seedDataVariantAtribute("Android 13.0", 50, 132); // Version
        seedDataVariantAtribute("Sách HDSD, Cáp USB-A to USB-C, Sạc", 57, 132); // Phụ kiện trong hộp

        // màu đen
        seedDataVariant("Xiaomi Pad 6 WiFi 8GB 256GB", 9299020.0, 8, 36);
        seedDataVariantAtribute("256GB", 24, 133); // Dung lượng
        seedDataVariantAtribute("Đen", 3, 133); // Thông tin hàng hóa - Màu sắc
        seedDataVariantAtribute("Trung Quốc", 1, 133); // Xuất xứ
        seedDataVariantAtribute("08/2023", 2, 133); // Thời điểm ra mắt
        seedDataVariantAtribute("18", 4, 133); // Thời gian bảo hành (tháng)
        seedDataVariantAtribute("Để nơi khô ráo, nhẹ tay, dễ vỡ. Xem trong sách hướng dẫn sử dụng", 48, 133); // Hướng dẫn bảo quản và sử dụng
        seedDataVariantAtribute("253.95 x 165.18 x 6.51 mm", 5, 133); // Kích thước
        seedDataVariantAtribute("490 g", 6, 133); // Trọng lượng sản phẩm
        seedDataVariantAtribute("Khung máy: Kim loại", 7, 133); // Chất liệu
        seedDataVariantAtribute("Snapdragon 870", 9, 133); // CPU Model
        seedDataVariantAtribute("8", 11, 133); // Số nhân
        seedDataVariantAtribute("3.20 GHz", 12, 133); // Tốc độ tối đa
        seedDataVariantAtribute("8 GB", 79, 133); // Dung lượng RAM
        seedDataVariantAtribute("LPDDR4X", 66, 133); // Loại RAM
        seedDataVariantAtribute("11.0 inch", 14, 133); // Kích thước màn hình
        seedDataVariantAtribute("IPS LCD", 15, 133); // Công nghệ màn hình
        seedDataVariantAtribute("2880 x 1800 Pixels", 17, 133); // Độ phân giải
        seedDataVariantAtribute("WQHD+", 16, 133); // Chuẩn màn hình
        seedDataVariantAtribute("144 Hz", 23, 133); // Tần số quét
        seedDataVariantAtribute("Adreno 650", 24, 133); // Chip đồ hoạ (GPU)
        seedDataVariantAtribute("Không", 83, 133); // Thẻ nhớ ngoài
        seedDataVariantAtribute("Single rear camera", 27, 133); // Số camera sau
        seedDataVariantAtribute("Standard", 27, 133); // Camera
        seedDataVariantAtribute("13.0 MP", 28, 133); // Resolution (Camera)
        seedDataVariantAtribute("ƒ/1.9", 29, 133); // Aperture (Camera)
        seedDataVariantAtribute("1080p@30fps, 720p@30fps", 30, 133); // Quay phim camera sau
        seedDataVariantAtribute("8.0 MP", 33, 133); // Resolution (Camera Selfie)
        seedDataVariantAtribute("ƒ/2.1", 34, 133); // Aperture (Camera Selfie)
        seedDataVariantAtribute("Quay phim HD, Quay phim FullHD", 30, 133); // Quay phim camera selfie
        seedDataVariantAtribute("Bộ lọc màu, HDR, Tự động lấy nét (AF)", 35, 133); // Tính năng camera selfie
        seedDataVariantAtribute("Cổng sạc: Type C, Audio Jack: Jack 3.5 mm", 41, 133); // Cổng giao tiếp
        seedDataVariantAtribute("802.11 a/b/g/n/ac, Dual-band (2.4 GHz/ 5 GHz), Wifi 6", 42, 133); // Wifi
        seedDataVariantAtribute("v5.2", 44, 133); // Bluetooth
        seedDataVariantAtribute("OTG", 43, 133); // Kết nối khác
        seedDataVariantAtribute("Lithium polymer", 47, 133); // Loại PIN
        seedDataVariantAtribute("8840 mAh", 48, 133); // Dung lượng pin
        seedDataVariantAtribute("Android", 49, 133); // OS
        seedDataVariantAtribute("Android 13.0", 50, 133); // Version
        seedDataVariantAtribute("Sách HDSD, Cáp USB-A to USB-C, Sạc", 57, 133); // Phụ kiện trong hộp

        //Xiaomi Redmi Pad Pro WiFi 8GB 128GB
        seedDataProduct("Xiaomi Redmi Pad", "Ipad", 0.571, 13, 3, 3, "");

        seedDataVariant("Xiaomi Redmi Pad Pro WiFi 8GB 128GB", 9299021.0, 8, 37);
        seedDataVariantAtribute("128GB", 24, 134); // Dung lượng
        seedDataVariantAtribute("Xám", 3, 134); // Thông tin hàng hóa - Màu sắc
        seedDataVariantAtribute("Trung Quốc", 1, 134); // Xuất xứ
        seedDataVariantAtribute("06/2024", 2, 134); // Thời điểm ra mắt
        seedDataVariantAtribute("18", 4, 134); // Thời gian bảo hành (tháng)
        seedDataVariantAtribute("280 x 181.85 x 7.52 mm", 5, 134); // Kích thước
        seedDataVariantAtribute("571 g", 6, 134); // Trọng lượng sản phẩm
        seedDataVariantAtribute("83.60%", 13, 134); // Tỷ lệ diện tích sử dụng màn hình
        seedDataVariantAtribute("Khung máy: Kim loại", 7, 134); // Chất liệu
        seedDataVariantAtribute("Snapdragon 7s Gen 2", 9, 134); // CPU Model
        seedDataVariantAtribute("Octa-Core", 10, 134); // Loại CPU
        seedDataVariantAtribute("8", 11, 134); // Số nhân
        seedDataVariantAtribute("2.4 GHz", 12, 134); // Tốc độ tối đa
        seedDataVariantAtribute("8 GB", 79, 134); // Dung lượng RAM
        seedDataVariantAtribute("LPDDR4X", 66, 134); // Loại RAM
        seedDataVariantAtribute("12.1 inch", 14, 134); // Kích thước màn hình
        seedDataVariantAtribute("LCD", 15, 134); // Công nghệ màn hình
        seedDataVariantAtribute("1600 x 2560 Pixels", 17, 134); // Độ phân giải
        seedDataVariantAtribute("2.5K", 16, 134); // Chuẩn màn hình
        seedDataVariantAtribute("Hơn 68 tỷ màu", 78, 134); // Màu màn hình
        seedDataVariantAtribute("Gorilla Glass 3", 62, 134); // Chất liệu mặt kính
        seedDataVariantAtribute("249PPI", 22, 134); // Mật độ điểm ảnh
        seedDataVariantAtribute("120", 23, 134); // Tần số quét
        seedDataVariantAtribute("600 nits", 20, 134); // Độ sáng
        seedDataVariantAtribute("16:10", 26, 134); // Tỷ lệ màn hình
        seedDataVariantAtribute("1500:1", 21, 134); // Độ tương phản
        seedDataVariantAtribute("Qualcomm Adreno", 24, 134); // Chip đồ hoạ (GPU)
        seedDataVariantAtribute("Khoảng 105 GB", 85, 134); // Bộ nhớ còn lại
        seedDataVariantAtribute("MicroSD", 83, 134); // Thẻ nhớ ngoài
        seedDataVariantAtribute("1.5 TB", 84, 134); // Hỗ trợ thẻ nhớ tối đa
        seedDataVariantAtribute("Single rear camera", 27, 134); // Số camera sau
        seedDataVariantAtribute("Standard", 27, 134); // Camera
        seedDataVariantAtribute("8.0 MP", 28, 134); // Resolution (Camera)
        seedDataVariantAtribute("ƒ/2.0", 29, 134); // Aperture (Camera)
        seedDataVariantAtribute("1.12 µm", 85, 134); // Pixel size (Camera)
        seedDataVariantAtribute("1080p@30fps, 720p@30fps", 30, 134); // Quay phim camera sau
        seedDataVariantAtribute("Single selfie camera", 32, 134); // Số Camera Selfie
        seedDataVariantAtribute("8.0 MP", 33, 134); // Resolution (Camera Selfie)
        seedDataVariantAtribute("ƒ/2.28", 34, 134); // Aperture (Camera Selfie)
        seedDataVariantAtribute("1.12 µm", 85, 134); // Pixel size (Camera Selfie)
        seedDataVariantAtribute("1080p@30fps, 720p@30fps", 30, 134); // Quay phim camera selfie
        seedDataVariantAtribute("Cảm biến gia tốc, Con quay hồi chuyển, Cảm biến ánh sáng, Cảm biến nhiệt độ, Cảm biến la bàn, Cảm biến từ trường", 36, 134); // Cảm biến
        seedDataVariantAtribute("Type C", 41, 134); // Cổng giao tiếp
        seedDataVariantAtribute("802.11 a/b/g, Wifi 6, Dual-band (2.4 GHz/ 5 GHz), MIMO, Wi-Fi Direct", 42, 134); // Wifi
        seedDataVariantAtribute("v5.2", 44, 134); // Bluetooth
        seedDataVariantAtribute("1 viên Lithium polymer", 47, 134); // Loại PIN
        seedDataVariantAtribute("10000 mAh", 48, 134); // Dung lượng pin
        seedDataVariantAtribute("Android", 49, 134); // OS
        seedDataVariantAtribute("Android U (Hyper OS)", 50, 134); // Version
        seedDataVariantAtribute("Sạc, Cáp, Sách HDSD, Que lấy thẻ nhớ", 57, 134); // Phụ kiện trong hộp


        // xanh duương
        seedDataVariant("Xiaomi Redmi Pad Pro WiFi 8GB 128GB", 9299022.0, 8, 37);
        seedDataVariantAtribute("128GB", 24, 135); // Dung lượng
        seedDataVariantAtribute("Xám", 3, 135); // Thông tin hàng hóa - Màu sắc
        seedDataVariantAtribute("Trung Quốc", 1, 135); // Xuất xứ
        seedDataVariantAtribute("06/2024", 2, 135); // Thời điểm ra mắt
        seedDataVariantAtribute("18", 4, 135); // Thời gian bảo hành (tháng)
        seedDataVariantAtribute("280 x 181.85 x 7.52 mm", 5, 135); // Kích thước
        seedDataVariantAtribute("571 g", 6, 135); // Trọng lượng sản phẩm
        seedDataVariantAtribute("83.60%", 13, 135); // Tỷ lệ diện tích sử dụng màn hình
        seedDataVariantAtribute("Khung máy: Kim loại", 7, 135); // Chất liệu
        seedDataVariantAtribute("Snapdragon 7s Gen 2", 9, 135); // CPU Model
        seedDataVariantAtribute("Octa-Core", 10, 135); // Loại CPU
        seedDataVariantAtribute("8", 11, 135); // Số nhân
        seedDataVariantAtribute("2.4 GHz", 12, 135); // Tốc độ tối đa
        seedDataVariantAtribute("8 GB", 79, 135); // Dung lượng RAM
        seedDataVariantAtribute("LPDDR4X", 66, 135); // Loại RAM
        seedDataVariantAtribute("12.1 inch", 14, 135); // Kích thước màn hình
        seedDataVariantAtribute("LCD", 15, 135); // Công nghệ màn hình
        seedDataVariantAtribute("1600 x 2560 Pixels", 17, 135); // Độ phân giải
        seedDataVariantAtribute("2.5K", 16, 135); // Chuẩn màn hình
        seedDataVariantAtribute("Hơn 68 tỷ màu", 78, 135); // Màu màn hình
        seedDataVariantAtribute("Gorilla Glass 3", 62, 135); // Chất liệu mặt kính
        seedDataVariantAtribute("249PPI", 22, 135); // Mật độ điểm ảnh
        seedDataVariantAtribute("120", 23, 135); // Tần số quét
        seedDataVariantAtribute("600 nits", 20, 135); // Độ sáng
        seedDataVariantAtribute("16:10", 26, 135); // Tỷ lệ màn hình
        seedDataVariantAtribute("1500:1", 21, 135); // Độ tương phản
        seedDataVariantAtribute("Qualcomm Adreno", 24, 135); // Chip đồ hoạ (GPU)
        seedDataVariantAtribute("Khoảng 105 GB", 85, 135); // Bộ nhớ còn lại
        seedDataVariantAtribute("MicroSD", 83, 135); // Thẻ nhớ ngoài
        seedDataVariantAtribute("1.5 TB", 84, 135); // Hỗ trợ thẻ nhớ tối đa
        seedDataVariantAtribute("Single rear camera", 27, 135); // Số camera sau
        seedDataVariantAtribute("Standard", 27, 135); // Camera
        seedDataVariantAtribute("8.0 MP", 28, 135); // Resolution (Camera)
        seedDataVariantAtribute("ƒ/2.0", 29, 135); // Aperture (Camera)
        seedDataVariantAtribute("1.12 µm", 85, 135); // Pixel size (Camera)
        seedDataVariantAtribute("1080p@30fps, 720p@30fps", 30, 135); // Quay phim camera sau
        seedDataVariantAtribute("Single selfie camera", 32, 135); // Số Camera Selfie
        seedDataVariantAtribute("8.0 MP", 33, 135); // Resolution (Camera Selfie)
        seedDataVariantAtribute("ƒ/2.28", 34, 135); // Aperture (Camera Selfie)
        seedDataVariantAtribute("1.12 µm", 85, 135); // Pixel size (Camera Selfie)
        seedDataVariantAtribute("1080p@30fps, 720p@30fps", 30, 135); // Quay phim camera selfie
        seedDataVariantAtribute("Cảm biến gia tốc, Con quay hồi chuyển, Cảm biến ánh sáng, Cảm biến nhiệt độ, Cảm biến la bàn, Cảm biến từ trường", 36, 135); // Cảm biến
        seedDataVariantAtribute("Type C", 41, 135); // Cổng giao tiếp
        seedDataVariantAtribute("802.11 a/b/g, Wifi 6, Dual-band (2.4 GHz/ 5 GHz), MIMO, Wi-Fi Direct", 42, 135); // Wifi
        seedDataVariantAtribute("v5.2", 44, 135); // Bluetooth
        seedDataVariantAtribute("1 viên Lithium polymer", 47, 135); // Loại PIN
        seedDataVariantAtribute("10000 mAh", 48, 135); // Dung lượng pin
        seedDataVariantAtribute("Android", 49, 135); // OS
        seedDataVariantAtribute("Android U (Hyper OS)", 50, 135); // Version
        seedDataVariantAtribute("Sạc, Cáp, Sách HDSD, Que lấy thẻ nhớ", 57, 135); // Phụ kiện trong hộp


        // Xiaomi Poco Pad WiFi 8GB 256GB
        seedDataVariant("Xiaomi Poco Pad WiFi 8GB 256GB", 7299021.0, 8, 37);
        seedDataVariantAtribute("256GB", 24, 136); // Dung lượng
        seedDataVariantAtribute("Xám", 3, 136); // Thông tin hàng hóa - Màu sắc
        seedDataVariantAtribute("Trung Quốc", 1, 136); // Xuất xứ
        seedDataVariantAtribute("06/2024", 2, 136); // Thời điểm ra mắt
        seedDataVariantAtribute("18", 4, 136); // Thời gian bảo hành (tháng)
        seedDataVariantAtribute("280 x 181.85 x 7.52 mm", 5, 136); // Kích thước
        seedDataVariantAtribute("571 g", 6, 136); // Trọng lượng sản phẩm
        seedDataVariantAtribute("83.60%", 13, 136); // Tỷ lệ diện tích sử dụng màn hình
        seedDataVariantAtribute("Khung máy: Kim loại", 7, 136); // Chất liệu
        seedDataVariantAtribute("Snapdragon 7s Gen 2", 9, 136); // CPU Model
        seedDataVariantAtribute("Octa-Core", 10, 136); // Loại CPU
        seedDataVariantAtribute("8", 11, 136); // Số nhân
        seedDataVariantAtribute("2.4 GHz", 12, 136); // Tốc độ tối đa
        seedDataVariantAtribute("8 GB", 79, 136); // Dung lượng RAM
        seedDataVariantAtribute("LPDDR4X", 66, 136); // Loại RAM
        seedDataVariantAtribute("12.1 inch", 14, 136); // Kích thước màn hình
        seedDataVariantAtribute("LCD", 15, 136); // Công nghệ màn hình
        seedDataVariantAtribute("1600 x 2560 Pixels", 17, 136); // Độ phân giải
        seedDataVariantAtribute("2.5K", 16, 136); // Chuẩn màn hình
        seedDataVariantAtribute("Hơn 68 tỷ màu", 78, 136); // Màu màn hình
        seedDataVariantAtribute("Gorilla Glass 3", 62, 136); // Chất liệu mặt kính
        seedDataVariantAtribute("249PPI", 22, 136); // Mật độ điểm ảnh
        seedDataVariantAtribute("120", 23, 136); // Tần số quét
        seedDataVariantAtribute("600 nits", 20, 136); // Độ sáng
        seedDataVariantAtribute("16:10", 26, 136); // Tỷ lệ màn hình
        seedDataVariantAtribute("1500:1", 21, 136); // Độ tương phản
        seedDataVariantAtribute("Qualcomm Adreno", 24, 136); // Chip đồ hoạ (GPU)
        seedDataVariantAtribute("Khoảng 230 GB", 85, 136); // Bộ nhớ còn lại
        seedDataVariantAtribute("MicroSD", 83, 136); // Thẻ nhớ ngoài
        seedDataVariantAtribute("1.5 TB", 84, 136); // Hỗ trợ thẻ nhớ tối đa
        seedDataVariantAtribute("Single rear camera", 27, 136); // Số camera sau
        seedDataVariantAtribute("Standard", 27, 136); // Camera
        seedDataVariantAtribute("8.0 MP", 28, 136); // Resolution (Camera)
        seedDataVariantAtribute("ƒ/2.0", 29, 136); // Aperture (Camera)
        seedDataVariantAtribute("1.12 µm", 85, 136); // Pixel size (Camera)
        seedDataVariantAtribute("1080p@30fps, 720p@30fps", 30, 136); // Quay phim camera sau
        seedDataVariantAtribute("Single selfie camera", 32, 136); // Số Camera Selfie
        seedDataVariantAtribute("8.0 MP", 33, 136); // Resolution (Camera Selfie)
        seedDataVariantAtribute("ƒ/2.28", 34, 136); // Aperture (Camera Selfie)
        seedDataVariantAtribute("1.12 µm", 85, 136); // Pixel size (Camera Selfie)
        seedDataVariantAtribute("1080p@30fps, 720p@30fps", 30, 136); // Quay phim camera selfie
        seedDataVariantAtribute("Cảm biến gia tốc, Con quay hồi chuyển, Cảm biến ánh sáng, Cảm biến nhiệt độ, Cảm biến la bàn, Cảm biến từ trường", 36, 136); // Cảm biến
        seedDataVariantAtribute("Type C", 41, 136); // Cổng giao tiếp
        seedDataVariantAtribute("802.11 a/b/g, Wifi 6, Dual-band (2.4 GHz/ 5 GHz), MIMO, Wi-Fi Direct", 42, 136); // Wifi
        seedDataVariantAtribute("v5.2", 44, 136); // Bluetooth
        seedDataVariantAtribute("1 viên Lithium polymer", 47, 136); // Loại PIN
        seedDataVariantAtribute("10000 mAh", 48, 136); // Dung lượng pin
        seedDataVariantAtribute("Android", 49, 136); // OS
        seedDataVariantAtribute("Android U (Hyper OS)", 50, 136); // Version
        seedDataVariantAtribute("Sạc, Cáp, Sách HDSD, Que lấy thẻ nhớ", 57, 136); // Phụ kiện trong hộp


        // Tai nghe AirPods Pro 2022
        seedDataProduct("Tai nghe AirPods", "Apple", 0.571, 14, 8, 3, "");


        seedDataVariant("Tai nghe AirPods Pro 2022", 5299021.0, 8, 38);
        seedDataVariantAtribute("AirPods Pro 2", 87, 137); // Model
        seedDataVariantAtribute("Trung Quốc", 1, 137); // Xuất xứ
        seedDataVariantAtribute("12", 4, 137); // Thời gian bảo hành (tháng)
        seedDataVariantAtribute("Để nơi khô ráo, nhẹ tay, dễ vỡ. Xem trong sách hướng dẫn sử dụng", 48, 137); // Hướng dẫn bảo quản và sử dụng
        seedDataVariantAtribute("Trắng", 3, 137); // Màu sắc
        seedDataVariantAtribute("50.8 g", 6, 137); // Trọng lượng sản phẩm
        seedDataVariantAtribute("Tai nghe không dây : Bluetooth", 86, 137); // Loại tai nghe
        seedDataVariantAtribute("v5.3", 44, 137); // Bluetooth
        seedDataVariantAtribute("Chống ồn, Sạc không dây", 35, 137); // Tính năng
        seedDataVariantAtribute("macOS", 49, 137); // Hệ điều hành tương thích
        seedDataVariantAtribute("Dây cáp sạc", 57, 137); // Phụ kiện đi kèm

        // Tai nghe AirPods 3 2022 Hộp sạc dây
        seedDataVariant("Tai nghe AirPods Pro 2022", 4099021.0, 8, 38);
        seedDataVariantAtribute("AirPods 3", 87, 138); // Model
        seedDataVariantAtribute("Trung Quốc", 1, 138); // Xuất xứ
        seedDataVariantAtribute("12", 4, 138); // Thời gian bảo hành (tháng)
        seedDataVariantAtribute("Để nơi khô ráo, nhẹ tay, dễ vỡ. Xem trong sách hướng dẫn sử dụng", 48, 138); // Hướng dẫn bảo quản và sử dụng
        seedDataVariantAtribute("Trắng", 3, 138); // Màu sắc
        seedDataVariantAtribute("54.4 x 21.38 x 46.40 mm", 5, 138); // Kích thước
        seedDataVariantAtribute("37.91 g", 6, 138); // Trọng lượng sản phẩm
        seedDataVariantAtribute("Tai nghe không dây : Bluetooth", 86, 138); // Loại tai nghe
        seedDataVariantAtribute("3 - 5 giờ", 48, 138); // Thời gian sử dụng/1 lần sạc
        seedDataVariantAtribute("6 Giờ", 47, 138); // Dung lượng pin
        seedDataVariantAtribute("v5.0", 44, 138); // Bluetooth
        seedDataVariantAtribute("Cổng sạc: Lightning", 41, 138); // Cổng giao tiếp
        seedDataVariantAtribute("Nghe nhạc, Chống nước", 35, 138); // Tính năng
        seedDataVariantAtribute("iOS", 49, 138); // Hệ điều hành tương thích
        seedDataVariantAtribute("Sách HDSD, Cáp", 57, 138); // Phụ kiện đi kèm

        // Tai nghe AirPods Pro 2023 USB-C
        seedDataVariant("Tai nghe AirPods Pro 2023 USB-C", 5799021.0, 10, 38);
        seedDataVariantAtribute("AirPods Pro", 87, 139); // Model
        seedDataVariantAtribute("Trung Quốc", 1, 139); // Xuất xứ
        seedDataVariantAtribute("12", 4, 139); // Thời gian bảo hành (tháng)
        seedDataVariantAtribute("Trắng", 3, 139); // Màu sắc
        seedDataVariantAtribute("Tai nghe không dây", 86, 139); // Loại tai nghe
        seedDataVariantAtribute("Chống ồn, Sạc không dây", 35, 139); // Tính năng
        seedDataVariantAtribute("Dây cáp sạc", 57, 139); // Phụ kiện đi kèm

        // Tai nghe AirPods 4 - Chủ Động Khử Tiếng Ồn
        seedDataVariant("Tai nghe AirPods 4", 4799021.0, 10, 38);
        seedDataVariantAtribute("AirPods 4", 87, 140); // Model
        seedDataVariantAtribute("Trung Quốc", 1, 140); // Xuất xứ
        seedDataVariantAtribute("12", 4, 140); // Thời gian bảo hành (tháng)
        seedDataVariantAtribute("Trắng", 3, 140); // Màu sắc
        seedDataVariantAtribute("240 g", 6, 140); // Trọng lượng sản phẩm
        seedDataVariantAtribute("Tai nghe không dây : Bluetooth", 86, 140); // Loại tai nghe
        seedDataVariantAtribute("5 Giờ", 47, 140); // Dung lượng pin
        seedDataVariantAtribute("Cổng sạc: USB Type-C", 41, 140); // Cổng giao tiếp
        seedDataVariantAtribute("Chế độ xuyên âm, Sạc không dây, Chống ồn, Nghe nhạc, Kháng nước IP54", 35, 140); // Tính năng
        seedDataVariantAtribute("Sách HDSD, Hộp sạc không dây", 57, 140); // Phụ kiện đi kèm

        // Tai nghe Apple EarPods 2023 USB-C
        seedDataProduct("Tai nghe Apple EarPods USB-C", "Apple", 0.031, 14, 8, 3, "");

        seedDataVariant("Tai nghe Apple EarPods USB-C", 599000.0, 10, 39);
        seedDataVariantAtribute("EarPods (USB-C)", 87, 141); // Model
        seedDataVariantAtribute("Trung Quốc", 1, 141); // Xuất xứ
        seedDataVariantAtribute("12", 4, 141); // Thời gian bảo hành (tháng)
        seedDataVariantAtribute("Xem trong sách hướng dẫn sử dụng", 48, 141); // Hướng dẫn sử dụng
        seedDataVariantAtribute("Trắng", 3, 141); // Màu sắc
        seedDataVariantAtribute("31 g", 6, 141); // Trọng lượng sản phẩm
        seedDataVariantAtribute("Tai nghe nhét tai", 86, 141); // Loại tai nghe
        seedDataVariantAtribute("Điều khiển cuộc gọi, Điều khiển nhạc, Chống ồn", 45, 141); // Tính năng

        // Tai nghe Beats Studio Buds
        seedDataProduct("Tai nghe Beats Studio Buds", "Apple", 0.058, 14, 8, 3, "");

        seedDataVariant("Tai nghe Beats Studio Buds", 3199001.0, 10, 40);
        seedDataVariantAtribute("Beats Studio Buds", 87, 142); // Model
        seedDataVariantAtribute("Trung Quốc", 1, 142); // Xuất xứ
        seedDataVariantAtribute("12", 4, 142); // Thời gian bảo hành (tháng)
        seedDataVariantAtribute("Để nơi khô ráo, nhẹ tay, dễ vỡ. Xem trong sách hướng dẫn sử dụng", 48, 142); // Hướng dẫn bảo quản và sử dụng
        seedDataVariantAtribute("Hồng", 3, 142); // Màu sắc
        seedDataVariantAtribute("58 g", 6, 142); // Trọng lượng sản phẩm
        seedDataVariantAtribute("Tai nghe không dây : Bluetooth", 86, 142); // Loại tai nghe
        seedDataVariantAtribute("Chống nước, Chống ồn", 35, 142); // Tính năng
        seedDataVariantAtribute("TVOS", 49, 142); // Hệ điều hành tương thích
        seedDataVariantAtribute("Cáp USB-C to USB-C", 48, 142); // Phụ kiện đi kèm

        seedDataVariant("Tai nghe Beats Studio Buds", 3199000.0, 10, 40);
        seedDataVariantAtribute("Beats Studio Buds", 87, 143); // Model
        seedDataVariantAtribute("Trung Quốc", 1, 143); // Xuất xứ
        seedDataVariantAtribute("12", 4, 143); // Thời gian bảo hành (tháng)
        seedDataVariantAtribute("Để nơi khô ráo, nhẹ tay, dễ vỡ. Xem trong sách hướng dẫn sử dụng", 48, 143); // Hướng dẫn bảo quản và sử dụng
        seedDataVariantAtribute("Đen", 3, 143); // Màu sắc
        seedDataVariantAtribute("58 g", 6, 143); // Trọng lượng sản phẩm
        seedDataVariantAtribute("Tai nghe không dây : Bluetooth", 86, 143); // Loại tai nghe
        seedDataVariantAtribute("Chống nước, Chống ồn", 35, 143); // Tính năng
        seedDataVariantAtribute("TVOS", 49, 143); // Hệ điều hành tương thích
        seedDataVariantAtribute("Cáp USB-C to USB-C", 48, 143); // Phụ kiện đi kèm


        seedDataVariant("Tai nghe Beats Studio Buds", 3199003.0, 10, 40);
        seedDataVariantAtribute("Beats Studio Buds", 87, 144); // Model
        seedDataVariantAtribute("Trung Quốc", 1, 144); // Xuất xứ
        seedDataVariantAtribute("12", 4, 144); // Thời gian bảo hành (tháng)
        seedDataVariantAtribute("Để nơi khô ráo, nhẹ tay, dễ vỡ. Xem trong sách hướng dẫn sử dụng", 48, 144); // Hướng dẫn bảo quản và sử dụng
        seedDataVariantAtribute("Xanh", 3, 144); // Màu sắc
        seedDataVariantAtribute("58 g", 6, 144); // Trọng lượng sản phẩm
        seedDataVariantAtribute("Tai nghe không dây : Bluetooth", 86, 144); // Loại tai nghe
        seedDataVariantAtribute("Chống nước, Chống ồn", 35, 144); // Tính năng
        seedDataVariantAtribute("TVOS", 49, 144); // Hệ điều hành tương thích
        seedDataVariantAtribute("Cáp USB-C to USB-C", 48, 144); // Phụ kiện đi kèm


        seedDataVariant("Tai nghe Beats Studio Buds", 3199005.0, 10, 40);
        seedDataVariantAtribute("Beats Studio Buds", 87, 145); // Model
        seedDataVariantAtribute("Trung Quốc", 1, 145); // Xuất xứ
        seedDataVariantAtribute("12", 4, 145); // Thời gian bảo hành (tháng)
        seedDataVariantAtribute("Để nơi khô ráo, nhẹ tay, dễ vỡ. Xem trong sách hướng dẫn sử dụng", 48, 145); // Hướng dẫn bảo quản và sử dụng
        seedDataVariantAtribute("Đỏ", 3, 145); // Màu sắc
        seedDataVariantAtribute("58 g", 6, 145); // Trọng lượng sản phẩm
        seedDataVariantAtribute("Tai nghe không dây : Bluetooth", 86, 145); // Loại tai nghe
        seedDataVariantAtribute("Chống nước, Chống ồn", 35, 145); // Tính năng
        seedDataVariantAtribute("TVOS", 49, 145); // Hệ điều hành tương thích
        seedDataVariantAtribute("Cáp USB-C to USB-C", 48, 145); // Phụ kiện đi kèm

        // Tai nghe AirPods Max
        seedDataProduct("Tai nghe AirPods Max", "Apple", 0.1, 14, 8, 3, "");

        seedDataVariant("Tai nghe Beats Studio Buds", 12199005.0, 10, 41);
        seedDataVariantAtribute("Tai nghe AirPods Max", 87, 146); // Model
        seedDataVariantAtribute("Trung Quốc", 1, 146); // Xuất xứ
        seedDataVariantAtribute("12", 4, 146); // Thời gian bảo hành (tháng)
        seedDataVariantAtribute("Xanh lá", 3, 146); // Màu sắc
        seedDataVariantAtribute("187.3 x 168.6 x 83.4 mm", 5, 146); // Kích thước
        seedDataVariantAtribute("Vải, Khung máy: Kim loại", 7, 146); // Chất liệu
        seedDataVariantAtribute("Tai nghe chụp tai : Bluetooth", 86, 146); // Loại tai nghe
        seedDataVariantAtribute("20 Giờ", 47, 146); // Dung lượng pin
        seedDataVariantAtribute("Nghe nhạc, Chống ồn", 35, 146); // Tính năng
        seedDataVariantAtribute("TVOS", 49, 146); // Hệ điều hành tương thích
        seedDataVariantAtribute("Cáp USB to Lighting, Smart Case, Sách HDSD", 48, 146); // Phụ kiện đi kèm

        seedDataVariant("Tai nghe Beats Studio Buds", 12199006.0, 10, 41);
        seedDataVariantAtribute("Tai nghe AirPods Max", 87, 147); // Model
        seedDataVariantAtribute("Trung Quốc", 1, 147); // Xuất xứ
        seedDataVariantAtribute("12", 4, 147); // Thời gian bảo hành (tháng)
        seedDataVariantAtribute("Trắng", 3, 147); // Màu sắc
        seedDataVariantAtribute("187.3 x 168.6 x 83.4 mm", 5, 147); // Kích thước
        seedDataVariantAtribute("Vải, Khung máy: Kim loại", 7, 147); // Chất liệu
        seedDataVariantAtribute("Tai nghe chụp tai : Bluetooth", 86, 147); // Loại tai nghe
        seedDataVariantAtribute("20 Giờ", 47, 147); // Dung lượng pin
        seedDataVariantAtribute("Nghe nhạc, Chống ồn", 35, 147); // Tính năng
        seedDataVariantAtribute("TVOS", 49, 147); // Hệ điều hành tương thích
        seedDataVariantAtribute("Cáp USB to Lighting, Smart Case, Sách HDSD", 48, 147); // Phụ kiện đi kèm

        seedDataVariant("Tai nghe Beats Studio Buds", 12199055.0, 10, 41);
        seedDataVariantAtribute("Tai nghe AirPods Max", 87, 148); // Model
        seedDataVariantAtribute("Trung Quốc", 1, 148); // Xuất xứ
        seedDataVariantAtribute("12", 4, 148); // Thời gian bảo hành (tháng)
        seedDataVariantAtribute("Hồng", 3, 148); // Màu sắc
        seedDataVariantAtribute("187.3 x 168.6 x 83.4 mm", 5, 148); // Kích thước
        seedDataVariantAtribute("Vải, Khung máy: Kim loại", 7, 148); // Chất liệu
        seedDataVariantAtribute("Tai nghe chụp tai : Bluetooth", 86, 148); // Loại tai nghe
        seedDataVariantAtribute("20 Giờ", 47, 148); // Dung lượng pin
        seedDataVariantAtribute("Nghe nhạc, Chống ồn", 35, 148); // Tính năng
        seedDataVariantAtribute("TVOS", 49, 148); // Hệ điều hành tương thích
        seedDataVariantAtribute("Cáp USB to Lighting, Smart Case, Sách HDSD", 48, 148); // Phụ kiện đi kèm


        seedDataVariant("Tai nghe Beats Studio Buds", 12199045.0, 10, 41);
        seedDataVariantAtribute("Tai nghe AirPods Max", 87, 149); // Model
        seedDataVariantAtribute("Trung Quốc", 1, 149); // Xuất xứ
        seedDataVariantAtribute("12", 4, 149); // Thời gian bảo hành (tháng)
        seedDataVariantAtribute("Xám", 3, 149); // Màu sắc
        seedDataVariantAtribute("187.3 x 168.6 x 83.4 mm", 5, 149); // Kích thước
        seedDataVariantAtribute("Vải, Khung máy: Kim loại", 7, 149); // Chất liệu
        seedDataVariantAtribute("Tai nghe chụp tai : Bluetooth", 86, 149); // Loại tai nghe
        seedDataVariantAtribute("20 Giờ", 47, 149); // Dung lượng pin
        seedDataVariantAtribute("Nghe nhạc, Chống ồn", 35, 149); // Tính năng
        seedDataVariantAtribute("TVOS", 49, 149); // Hệ điều hành tương thích
        seedDataVariantAtribute("Cáp USB to Lighting, Smart Case, Sách HDSD", 48, 149); // Phụ kiện đi kèm

        // Tai nghe Beats Fit Pro True Wireless Earbuds

        seedDataProduct("Tai nghe Beats Fit Pro True Wireless Earbuds", "Apple", 0.005, 14, 8, 3, "");

        seedDataVariant("Tai nghe Beats Fit Pro True Wireless Earbuds", 4199005.0, 10, 41);
        seedDataVariantAtribute("Beats Fit Pro True Wireless Earbuds", 87, 150); // Model
        seedDataVariantAtribute("Trung Quốc", 1, 150); // Xuất xứ
        seedDataVariantAtribute("12", 4, 150); // Thời gian bảo hành (tháng)
        seedDataVariantAtribute("Đen", 3, 150); // Màu sắc
        seedDataVariantAtribute("190 g", 6, 150); // Trọng lượng sản phẩm
        seedDataVariantAtribute("Tai nghe nhét tai, Tai nghe không dây : Bluetooth", 86, 150); // Loại tai nghe
        seedDataVariantAtribute("6 giờ", 48, 150); // Thời gian sử dụng/1 lần sạc
        seedDataVariantAtribute("Điện thoại", 11, 150); // Sử dụng cho thiết bị
        seedDataVariantAtribute("v5.0", 44, 150); // Bluetooth
        seedDataVariantAtribute("Chống ồn, Nghe nhạc", 35, 150); // Tính năng
        seedDataVariantAtribute("Sách HDSD", 48, 150); // Phụ kiện đi kèm


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
        SeedDataCategoryAttribute(1L, 13L);
        SeedDataCategoryAttribute(1L, 14L);
        SeedDataCategoryAttribute(1L, 15L);
        SeedDataCategoryAttribute(1L, 16L);
        SeedDataCategoryAttribute(1L, 17L);
        SeedDataCategoryAttribute(1L, 18L);
        SeedDataCategoryAttribute(1L, 19L);
        SeedDataCategoryAttribute(1L, 20L);
        SeedDataCategoryAttribute(1L, 21L);
        SeedDataCategoryAttribute(1L, 22L);
        SeedDataCategoryAttribute(1L, 23L);
        SeedDataCategoryAttribute(1L, 24L);
        SeedDataCategoryAttribute(1L, 25L);
        SeedDataCategoryAttribute(1L, 26L);
        SeedDataCategoryAttribute(1L, 27L);
        SeedDataCategoryAttribute(1L, 28L);
        SeedDataCategoryAttribute(1L, 29L);
        SeedDataCategoryAttribute(1L, 30L);
        SeedDataCategoryAttribute(1L, 31L);
        SeedDataCategoryAttribute(1L, 32L);
        SeedDataCategoryAttribute(1L, 33L);
        SeedDataCategoryAttribute(1L, 34L);
        SeedDataCategoryAttribute(1L, 35L);
        SeedDataCategoryAttribute(1L, 36L);
        SeedDataCategoryAttribute(1L, 37L);
        SeedDataCategoryAttribute(1L, 38L);
        SeedDataCategoryAttribute(1L, 39L);
        SeedDataCategoryAttribute(1L, 40L);
        SeedDataCategoryAttribute(1L, 41L);
        SeedDataCategoryAttribute(1L, 42L);
        SeedDataCategoryAttribute(1L, 43L);
        SeedDataCategoryAttribute(1L, 44L);
        SeedDataCategoryAttribute(1L, 45L);
        SeedDataCategoryAttribute(1L, 46L);
        SeedDataCategoryAttribute(2L, 47L);
        SeedDataCategoryAttribute(2L, 48L);
        SeedDataCategoryAttribute(2L, 49L);
        SeedDataCategoryAttribute(2L, 50L);

        SeedDataCategoryAttribute(2L, 15L);
        SeedDataCategoryAttribute(2L, 16L);

        // order
//        seedDataOrder("abc", "Đang xử lý", "Thanh toán khi nhận hàng", "Chưa thanh toán", 3199000.0, 1L, LocalDateTime.now());

    }

    public void SeedDataCategoryAttribute(Long category_id, Long attribute_id) {
        List<Category_Atrribute> category_attribute = categoryAttributeRepository.findByCategoryIdAndAttributeId(category_id, attribute_id);
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
        List<Variant_Attribute> variantAttributes = variantValueRepository.findVariant_AttributesByVariant_IdAndAndAttribute_IdAndAndValue((long) variant_id, (long) attribute_id, value);
        if (variantAttributes.isEmpty()) {
            Variant_Attribute variant_attribute = new Variant_Attribute();
            variant_attribute.setValue(value);
            variant_attribute.setAttribute(attributeRepository.findById((long) attribute_id).get());
            variant_attribute.setVariant(variantRepository.findById((long) variant_id).get());
            variantValueRepository.save(variant_attribute);
        }
    }

    public void seedDataProduct(String name, String description, Double weight, int brand_id, int category_id, int warranty_id, String image) {
        Optional<Product> products = productRepository.findProductByName(name);
        if (products.isEmpty()) {
            Product product = new Product();
            product.setName(name);
            product.setDescription(description);
            product.setWeight(weight + "kg");
            product.setBrand(brandRepository.findById((long) brand_id).get());
            product.setCategory(categoryRepository.findById((long) category_id).get());
            product.setWarranty(warrantyRepository.findById((long) warranty_id).get());
            product.setImage("/src/assets/products/" + image);
            product.setStatus("active");
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

    public void seedDataOrder(String note, String order_status, String payment_method,String payment_status, double total, Long customerId, LocalDateTime order_date) {
        List<Order> orders = orderRepository.findOrdersByCustomerId(customerId);
        if (orders.isEmpty()) {
            Order order = new Order();
            order.setNote(note);
            order.setOrderStatus(order_status);
            order.setPayment_status(payment_status);

            // Chuyển đổi chuỗi thành enum PaymentMethod
            try {
                Order.PaymentMethod method = Order.PaymentMethod.valueOf(payment_method);
                order.setPayment_method(method);
            } catch (IllegalArgumentException e) {
                throw new RuntimeException("Phương thức thanh toán không hợp lệ: " + payment_method);
            }
            order.setCustomer(customerRepository.findById(customerId).orElseThrow(() -> new RuntimeException("Customer not found")));
            order.setOrderDate(order_date);
            order.setTotal_amount(total);
            orderRepository.save(order);
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
