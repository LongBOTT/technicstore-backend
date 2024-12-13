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

    private final ImeiRepository imeiRepository;
    private final VariantRepository variantRepository;

    private final Variant_AttributeRepository variantValueRepository;
    private final CategoryAttributeRepository categoryAttributeRepository;

    private final StockReceiveRepository stockReceiveRepository;
    private final StockReceiveDetailRepository stockReceiveDetailRepository;

    public DataInitializer(StockReceiveRepository stockReceiveRepository, StockReceiveDetailRepository stockReceiveDetailRepository, CustomerRepository customerRepository, AttributeRepository attributeRepository, BrandRepository brandRepository, CategoryRepository categoryRepository, SupplierRepository supplierRepository, CarrierRepository carrierRepository, WarrantyRepository warrantyRepository, RoleRepository roleRepository, FunctionRepository functionRepository, ModuleRepository moduleRepository, DecentralizationRepository decentralizationRepository, AccountRepository accountRepository, ProductRepository productRepository, ImeiRepository imeiRepository, VariantRepository variantRepository, Variant_AttributeRepository variantValueRepository1, CategoryAttributeRepository categoryAttributeRepository, OrderRepository orderRepository, OrderDetailRepository orderDetailRepository) {

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
        this.imeiRepository = imeiRepository;
        this.stockReceiveRepository = stockReceiveRepository;
        this.stockReceiveDetailRepository = stockReceiveDetailRepository;
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
        seedDataBrand("iPhone"); //1
        seedDataBrand("Samsung"); // 2
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
        seedDataBrand("Fujihome"); //18
        seedDataBrand("Logitech"); // 19
        seedDataBrand("Sunhouse");
        seedDataBrand("Philips");
        seedDataBrand("Samsung Galaxy Tab"); //22
        seedDataBrand("Xiaomi Pad"); //23
        seedDataBrand("Xiaomi Band"); //24
        seedDataBrand("Apple Watch"); //25
        seedDataBrand("Samsung Galaxy Watch"); //26
        seedDataBrand("Hotwell"); //27
        seedDataBrand("UmeTravel"); //28
        seedDataBrand("Ugreen"); //29

        // endregion

        // region category
        seedDataCategory("ĐIỆN THOẠI"); // 1
        seedDataCategory("LAPTOP"); // 2
        seedDataCategory("MÁY TÍNH BẢNG");
        seedDataCategory("ĐỒNG HỒ THÔNG MINH");


        seedDataCategory("PHỤ KIỆN");
        seedDataCategory("ĐIỆN MÁY"); //6

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
        seedDataSupplier("Dell", "dell@gmail.com", "0108233445", "789 Đường C, Quận 3, TP HCM", "Đang giao dịch");
        seedDataSupplier("HP", "hp@gmail.com", "0223344556", "101 Đường D, Quận 4, TP HCM", "Đang giao dịch");
        seedDataSupplier("Lenovo", "lenovo@gmail.com", "0334455667", "202 Đường E, Quận 5, TP HCM", "Ngưng giao dịch");
        seedDataSupplier("Xiaomi", "xiaomi@gmail.com", "0445566778", "303 Đường F, Quận 6, TP HCM", "Đang giao dịch");
        seedDataSupplier("Asus", "asus@gmail.com", "0556677889", "404 Đường G, Quận 7, TP HCM", "Ngưng giao dịch");
        seedDataSupplier("Sony", "sony@gmail.com", "0667788990", "505 Đường H, Quận 8, TP HCM", "Đang giao dịch");
        seedDataSupplier("Microsoft", "microsoft@gmail.com", "0778899001", "606 Đường I, Quận 9, TP HCM", "Ngưng giao dịch");
        seedDataSupplier("Huawei", "huawei@gmail.com", "0889900108", "707 Đường K, Quận 10, TP HCM", "Đang giao dịch");
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
        seedDataAccount("carrier", "carrier", "0108233445", 3L);
        // endregion


        // Điện thoại
        //iPhone 14
        seedDataProduct("iPhone 14", "Điện thoại", 0.5, 1, 1, 1, "iphone_14_48a46d1684.png");

        // phiên bản iphone 14  String image , String name, Double price, int quantity, int product_id
        seedDataVariant("/src/assets/products/iphone14-Den-128GB.jpg", "iphone14 Đen 128GB", 21990000.0, 10, 1);
        seedDataVariant("/src/assets/products/iphone14-Xanh-256GB.jpg", "iphone14 Xanh 256GB",  24990001.0, 10, 1);
        seedDataVariant("/src/assets/products/iphone14-Trang-512GB.jpg","iphone14 Trắng 512GB", 27990021.0, 10, 1);

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
        seedDataVariantAtribute("4K 4230p@30fps,FullHD 1060p@25fps,4K 4320p@24fps,FullHD 1060p@30fps,4K 4230p@60fps,HD 720p@30fps,FullHD 1060p@60fps", 30, 1);
        seedDataVariantAtribute("Single selfie camera", 32, 1);
        seedDataVariantAtribute("12.0", 33, 1);
        seedDataVariantAtribute("Cảm biến tiệm cận", 36, 1);
        seedDataVariantAtribute("Mở khóa khuôn mặt,Mở khóa bằng mật mã", 37, 1);
        seedDataVariantAtribute("1 eSIM, 1 Nano SIM", 38, 1);
        seedDataVariantAtribute("1", 39, 1);
        seedDataVariantAtribute("5G", 40, 1);
        seedDataVariantAtribute("1 Lightning", 41, 1);


        seedDataVariantAtribute("Trung quốc", 1, 2);
        seedDataVariantAtribute("09/2022", 2, 2);
        seedDataVariantAtribute("12", 4, 2);
        seedDataVariantAtribute("146.7 x 71.5 x 7.8 mm", 5, 2);
        seedDataVariantAtribute("172g", 6, 2);
        seedDataVariantAtribute("IP168", 8, 2);
        seedDataVariantAtribute("Apple A15 Bionic", 9, 2);
        seedDataVariantAtribute("6", 11, 2);
        seedDataVariantAtribute("3.22 GHz", 12, 2);
        seedDataVariantAtribute("6GB", 13, 2);
        seedDataVariantAtribute("6.1 inch", 14, 2);
        seedDataVariantAtribute("OLED", 15, 2);
        seedDataVariantAtribute("Super Retina XDR", 16, 2);
        seedDataVariantAtribute("1170 x 2532 pixels", 17, 2);
        seedDataVariantAtribute("60 Hz", 22, 2);
        seedDataVariantAtribute("Điện dung đa điểm", 19, 2);
        seedDataVariantAtribute("1200 nits", 20, 2);
        seedDataVariantAtribute("Apple GPU 5 nhân", 23, 2);
        seedDataVariantAtribute("Không", 26, 2);
        seedDataVariantAtribute("Double rear camera", 27, 2);
        seedDataVariantAtribute("Wide", 28, 2);
        seedDataVariantAtribute("12.0 MP", 29, 2);
        seedDataVariantAtribute("4K 4230p@30fps,FullHD 1060p@25fps,4K 4320p@24fps,FullHD 1060p@30fps,4K 4230p@60fps,HD 720p@30fps,FullHD 1060p@60fps", 30, 2);
        seedDataVariantAtribute("Single selfie camera", 32, 2);
        seedDataVariantAtribute("12.0", 33, 2);
        seedDataVariantAtribute("Cảm biến tiệm cận", 36, 2);
        seedDataVariantAtribute("Mở khóa khuôn mặt,Mở khóa bằng mật mã", 37, 2);
        seedDataVariantAtribute("1 eSIM, 1 Nano SIM", 38, 2);
        seedDataVariantAtribute("1", 39, 2);
        seedDataVariantAtribute("5G", 40, 2);


        seedDataVariantAtribute("Trung quốc", 1, 3);
        seedDataVariantAtribute("09/2022", 2, 3);
        seedDataVariantAtribute("12", 4, 3);
        seedDataVariantAtribute("146.7 x 71.5 x 7.8 mm", 5, 3);
        seedDataVariantAtribute("172g", 6, 3);
        seedDataVariantAtribute("IP168", 8, 3);
        seedDataVariantAtribute("Apple A15 Bionic", 9, 3);
        seedDataVariantAtribute("6", 11, 3);
        seedDataVariantAtribute("3.22 GHz", 12, 3);
        seedDataVariantAtribute("6GB", 13, 3);
        seedDataVariantAtribute("6.1 inch", 14, 3);
        seedDataVariantAtribute("OLED", 15, 3);
        seedDataVariantAtribute("Super Retina XDR", 16, 3);
        seedDataVariantAtribute("1170 x 2532 pixels", 17, 3);
        seedDataVariantAtribute("60 Hz", 22, 3);
        seedDataVariantAtribute("Điện dung đa điểm", 19, 3);
        seedDataVariantAtribute("1200 nits", 20, 3);
        seedDataVariantAtribute("Apple GPU 5 nhân", 23, 3);
        seedDataVariantAtribute("Không", 26, 3);
        seedDataVariantAtribute("Double rear camera", 27, 3);
        seedDataVariantAtribute("Wide", 28, 3);
        seedDataVariantAtribute("12.0 MP", 29, 3);
        seedDataVariantAtribute("4K 4230p@30fps,FullHD 1060p@25fps,4K 4320p@24fps,FullHD 1060p@30fps,4K 4230p@60fps,HD 720p@30fps,FullHD 1060p@60fps", 30, 3);
        seedDataVariantAtribute("Single selfie camera", 32, 3);


        // iphone 14 plus
        seedDataProduct("iPhone 14 Plus", "Điện thoại", 0.5, 1, 1, 1, "iphone_14_48a46d1684.png");

        // phiên bản iphone 14 plus
        seedDataVariant("/src/assets/products/iphone14plus-Den-128GB.jpg", "iphone14plus-Đen-128GB " ,24990002.0, 10, 2);
        seedDataVariant("/src/assets/products/iphone14plus-Trang-256GB.jpg", "iphone14plus-Vàng-256GB ", 27990001.0, 10, 2);
        seedDataVariant("/src/assets/products/iphone14plus-Xanh-512GB.jpg", "iphone14plus-Xanh-512GB ",32990000.0, 10, 2);

        // Thông số
        // điện thoại iphone 14 plus dung lượng 128 GB có 3 màu Đen, Trắng, Xanh giá 24.990.000
        seedDataVariantAtribute("Đen", 3, 4);
        seedDataVariantAtribute("128GB", 24, 4);

        // điện thoại iphone 14 plus dung lượng 256 GB có 3 màu Đen, Trắng, Xanh giá 27.990.000
        seedDataVariantAtribute("Vàng", 3, 5);
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
        seedDataVariantAtribute("4K 4230p@30fps,FullHD 1060p@60fps,FullHD 1060p@25fps,HD 720p@30fps,4K 4320p@24fps,4K 4230p@60fps,FullHD 1060p@30fps", 30, 4);
        seedDataVariantAtribute("Single selfie camera", 32, 4);
        seedDataVariantAtribute("12.0 MP", 33, 4);

        seedDataVariantAtribute("Trung quốc", 1, 5);
        seedDataVariantAtribute("09/2022", 2, 5);
        seedDataVariantAtribute("12", 4, 5);
        seedDataVariantAtribute("160.8 x 78.1 x 7.8 mm", 5, 5);
        seedDataVariantAtribute("203g", 6, 5);
        seedDataVariantAtribute("IP168", 8, 5);
        seedDataVariantAtribute("Apple A15 Bionic", 9, 5);
        seedDataVariantAtribute("6", 11, 5);
        seedDataVariantAtribute("3.22 GHz", 12, 5);
        seedDataVariantAtribute("6GB", 13, 5);
        seedDataVariantAtribute("6.7 inch", 14, 5);
        seedDataVariantAtribute("OLED", 15, 5);
        seedDataVariantAtribute("Super Retina XDR", 16, 5);
        seedDataVariantAtribute("1284 x 2778 pixels", 17, 5);
        seedDataVariantAtribute("60 Hz", 22, 5);
        seedDataVariantAtribute("Điện dung đa điểm", 19, 5);
        seedDataVariantAtribute("2000 nits", 20, 5);
        seedDataVariantAtribute("Apple GPU 5 nhân", 23, 5);
        seedDataVariantAtribute("Không", 26, 5);
        seedDataVariantAtribute("Double rear camera", 27, 5);
        seedDataVariantAtribute("Ultra Wide", 28, 5);
        seedDataVariantAtribute("4K 4230p@30fps,FullHD 1060p@60fps,FullHD 1060p@25fps,HD 720p@30fps,4K 4320p@24fps,4K 4230p@60fps,FullHD 1060p@30fps", 30, 5);
        seedDataVariantAtribute("Single selfie camera", 32, 5);
        seedDataVariantAtribute("12.0 MP", 33, 5);
        seedDataVariantAtribute("Cảm biến tiệm cận", 36, 5);
        seedDataVariantAtribute("Mở khóa khuôn mặt,Mở khóa bằng mật mã", 37, 5);
        seedDataVariantAtribute("1 eSIM, 1 Nano SIM", 38, 5);
        seedDataVariantAtribute("1", 39, 5);
        seedDataVariantAtribute("5G", 40, 5);
        seedDataVariantAtribute("1 Lightning", 41, 5);
        seedDataVariantAtribute("802.11 a/b/g/n/ac/ax", 42, 5);
        seedDataVariantAtribute("BEIDOU,GALILEO,GLONASS", 43, 5);
        seedDataVariantAtribute("Bluetooth v5.3", 44, 5);
        seedDataVariantAtribute("Lithium-ion", 46, 5);
        seedDataVariantAtribute("4352 mAh", 47, 5);
        seedDataVariantAtribute("iOS", 49, 5);
        seedDataVariantAtribute("iOS 16", 50, 5);
        seedDataVariantAtribute("Cáp sạc, Sách HDSD, Que lấy SIM", 51, 5);

        seedDataVariantAtribute("Trung quốc", 1, 6);
        seedDataVariantAtribute("09/2022", 2, 6);
        seedDataVariantAtribute("12", 4, 6);
        seedDataVariantAtribute("160.8 x 78.1 x 7.8 mm", 5, 6);
        seedDataVariantAtribute("203g", 6, 6);
        seedDataVariantAtribute("IP168", 8, 6);
        seedDataVariantAtribute("Apple A15 Bionic", 9, 6);
        seedDataVariantAtribute("6", 11, 6);
        seedDataVariantAtribute("3.22 GHz", 12, 6);
        seedDataVariantAtribute("6GB", 13, 6);
        seedDataVariantAtribute("6.7 inch", 14, 6);
        seedDataVariantAtribute("OLED", 15, 6);
        seedDataVariantAtribute("Super Retina XDR", 16, 6);
        seedDataVariantAtribute("1284 x 2778 pixels", 17, 6);
        seedDataVariantAtribute("60 Hz", 22, 6);
        seedDataVariantAtribute("Điện dung đa điểm", 19, 6);
        seedDataVariantAtribute("2000 nits", 20, 6);
        seedDataVariantAtribute("Apple GPU 5 nhân", 23, 6);
        seedDataVariantAtribute("Không", 26, 6);
        seedDataVariantAtribute("Double rear camera", 27, 6);
        seedDataVariantAtribute("Ultra Wide", 28, 6);


        // iphone 15


        seedDataProduct("iPhone 15", "Điện thoại", 0.5, 1, 1, 1, "iphone_15_a9308b6994.png");

        // phiên bản iphone 15
        seedDataVariant("/src/assets/products/iphone15-Den-128GB.jpg", "iphone15 Đen 128GB", 22990040.0, 10, 3);
        seedDataVariant("/src/assets/products/iphone15-Vang-256GB.jpg", "iphone15 Vàng 256GB", 25990001.0, 10, 3);
        seedDataVariant("/src/assets/products/iphone15-Xanh-512GB.jpg", "iphone15 Xanh 512GB", 31990022.0, 10, 3);

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
        seedDataVariantAtribute("6 Core", 10, 7);
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
        seedDataVariantAtribute("4K 4320p@24fps,4K 2160p@25fps,4K 4230p@30fps,4K 4230p@60fps,HD 720p@30fps,FullHD 1060p@25fps,FullHD 1060p@60fps,FullHD 1060p@30fps", 30, 7);
        seedDataVariantAtribute("Quay chậm (Slow Motion),Chụp chân dung,Chụp góc rộng (Wide),HDR,Chống rung quang học (OIS),Tự động lấy nét (AF),Chạm lấy nét,Flash LED", 31, 7);
        seedDataVariantAtribute("Single selfie camera", 32, 7);
        seedDataVariantAtribute("12.0 MP", 33, 7);
        seedDataVariantAtribute("Quay phim 4K,Quay phim FullHD,Quay phim Slow Motion", 34, 7);
        seedDataVariantAtribute("Tự động lấy nét (AF),HDR,Nhận diện khuôn mặt,Chế độ chân dung,Ổn định hình ảnh quang học,Flash màn hình", 35, 7);
        seedDataVariantAtribute("Cảm biến khí áp kế,Con quay hồi chuyển,Cảm biến ánh sáng,Cảm biến gia tốc,Cảm biến tiệm cận", 36, 7);
        seedDataVariantAtribute("Mở khóa khuôn mặt,Mở khóa bằng mật mã", 37, 7);
        seedDataVariantAtribute("1 eSIM, 1 Nano SIM", 38, 7);
        seedDataVariantAtribute("1", 39, 7);


        seedDataVariantAtribute("Trung quốc", 1, 8);
        seedDataVariantAtribute("09/2023", 2, 8);
        seedDataVariantAtribute("12", 4, 8);
        seedDataVariantAtribute("146.7 x 71.5 x 7.8 mm", 5, 8);
        seedDataVariantAtribute("171g", 6, 8);
        seedDataVariantAtribute("IP168", 8, 8);
        seedDataVariantAtribute("Khung máy: Nhôm nguyên khối,Mặt lưng máy: Kính", 7, 8);
        seedDataVariantAtribute("Apple A16 Bionic", 9, 8);
        seedDataVariantAtribute("6 Core", 10, 8);
        seedDataVariantAtribute("6", 11, 8);
        seedDataVariantAtribute("6GB", 13, 8);
        seedDataVariantAtribute("6.1 inch", 14, 8);
        seedDataVariantAtribute("OLED", 15, 8);
        seedDataVariantAtribute("Super Retina XDR", 16, 8);
        seedDataVariantAtribute("1179 x 2556 pixels", 17, 8);
        seedDataVariantAtribute("Phủ ceramic", 18, 8);
        seedDataVariantAtribute("Điện dung đa điểm", 19, 8);
        seedDataVariantAtribute("2000 nits", 20, 8);
        seedDataVariantAtribute("2.000.000:1", 21, 8);
        seedDataVariantAtribute("Apple GPU 5 nhân", 23, 8);
        seedDataVariantAtribute("Không giới hạn", 25, 8);
        seedDataVariantAtribute("Không", 26, 8);
        seedDataVariantAtribute("Double rear camera", 27, 8);
        seedDataVariantAtribute("Standard", 28, 8);
        seedDataVariantAtribute("12.0 MP", 29, 8);
        seedDataVariantAtribute("4K 4320p@24fps,4K 2160p@25fps,4K 4230p@30fps,4K 4230p@60fps,HD 720p@30fps,FullHD 1060p@25fps,FullHD 1060p@60fps,FullHD 1060p@30fps", 30, 8);
        seedDataVariantAtribute("Quay chậm (Slow Motion),Chụp chân dung,Chụp góc rộng (Wide),HDR,Chống rung quang học (OIS),Tự động lấy nét (AF),Chạm lấy nét,Flash LED", 31, 8);
        seedDataVariantAtribute("Single selfie camera", 32, 8);
        seedDataVariantAtribute("12.0 MP", 33, 8);
        seedDataVariantAtribute("Quay phim 4K,Quay phim FullHD,Quay phim Slow Motion", 34, 8);
        seedDataVariantAtribute("Tự động lấy nét (AF),HDR,Nhận diện khuôn mặt,Chế độ chân dung,Ổn định hình ảnh quang học,Flash màn hình", 35, 8);
        seedDataVariantAtribute("Cảm biến khí áp kế,Con quay hồi chuyển,Cảm biến ánh sáng,Cảm biến gia tốc,Cảm biến tiệm cận", 36, 8);
        seedDataVariantAtribute("Mở khóa khuôn mặt,Mở khóa bằng mật mã", 37, 8);


        seedDataVariantAtribute("Trung quốc", 1, 9);
        seedDataVariantAtribute("09/2023", 2, 9);
        seedDataVariantAtribute("12", 4, 9);
        seedDataVariantAtribute("146.7 x 71.5 x 7.8 mm", 5, 9);
        seedDataVariantAtribute("171g", 6, 9);
        seedDataVariantAtribute("IP168", 8, 9);
        seedDataVariantAtribute("Khung máy: Nhôm nguyên khối,Mặt lưng máy: Kính", 7, 9);
        seedDataVariantAtribute("Apple A16 Bionic", 9, 9);
        seedDataVariantAtribute("6-Core", 10, 9);
        seedDataVariantAtribute("6", 11, 9);
        seedDataVariantAtribute("6GB", 13, 9);
        seedDataVariantAtribute("6.1 inch", 14, 9);
        seedDataVariantAtribute("OLED", 15, 9);
        seedDataVariantAtribute("Super Retina XDR", 16, 9);
        seedDataVariantAtribute("1179 x 2556 pixels", 17, 9);
        seedDataVariantAtribute("Phủ ceramic", 18, 9);
        seedDataVariantAtribute("Điện dung đa điểm", 19, 9);
        seedDataVariantAtribute("2000 nits", 20, 9);
        seedDataVariantAtribute("2.000.000:1", 21, 9);
        seedDataVariantAtribute("Apple GPU 5 nhân", 23, 9);
        seedDataVariantAtribute("Không giới hạn", 25, 9);
        seedDataVariantAtribute("Không", 26, 9);
        seedDataVariantAtribute("Double rear camera", 27, 9);
        seedDataVariantAtribute("Standard", 28, 9);
        seedDataVariantAtribute("12.0 MP", 29, 9);
        seedDataVariantAtribute("4K 4320p@24fps,4K 2160p@25fps,4K 4230p@30fps,4K 4230p@60fps,HD 720p@30fps,FullHD 1060p@25fps,FullHD 1060p@60fps,FullHD 1060p@30fps", 30, 9);
        seedDataVariantAtribute("Quay chậm (Slow Motion),Chụp chân dung,Chụp góc rộng (Wide),HDR,Chống rung quang học (OIS),Tự động lấy nét (AF),Chạm lấy nét,Flash LED", 31, 9);
        seedDataVariantAtribute("Single selfie camera", 32, 9);
        seedDataVariantAtribute("12.0 MP", 33, 9);
        seedDataVariantAtribute("Quay phim 4K,Quay phim FullHD,Quay phim Slow Motion", 34, 9);


        // iphone 15 plus
        seedDataProduct("iPhone 15 Plus", "Điện thoại", 0.5, 1, 1, 1, "iphone_15_a9308b6994.png");

        // phiên bản iphone 15 plus

        seedDataVariant("/src/assets/products/iphone15plus-Den-128GB.jpg", "iphone15plus Đen 128GB", 25990020.0, 10, 4);
        seedDataVariant("/src/assets/products/iphone15plus-Vang-256GB.jpg", "iphone15plus Vàng 256GB", 28990230.0, 10, 4);
        seedDataVariant("/src/assets/products/iphone15plus-Xanh-512GB.jpg", "iphone15plus Xanh 512GB", 34990000.0, 10, 4);

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
        seedDataVariantAtribute("4K 2160p@25fps,4K 2160p@24fps,4K 2160p@60fps,4K 2160p@30fps,FullHD 1060p@25fps,FullHD 1060p@60fps,FullHD 1060p@30fps,HD 720p@30fps", 29, 10);
        seedDataVariantAtribute("Chụp chân dung,Quay chậm (Slow Motion),HDR,Chụp góc rộng (Wide),Chống rung quang học (OIS),Ổn định hình ảnh quang học,Trôi nhanh thời gian (Time Lapse),Toàn cảnh (Panorama),Nhận diện khuôn mặt,Tự động lấy nét (AF),Chạm lấy nét,Live Photo,Ban đêm (Night Mode),Chuyên nghiệp (Pro)", 31, 10);
        seedDataVariantAtribute("Single selfie camera", 32, 10);
        seedDataVariantAtribute("12.0 MP", 33, 10);
        seedDataVariantAtribute("Quay phim 4K,Quay phim FullHD", 34, 10);
        seedDataVariantAtribute("Tự động lấy nét (AF),Ban đêm (Night Mode),HDR,Live Photo,Flash màn hình,Nhận diện khuôn mặt,Ổn định hình ảnh quang học,Chế độ chân dung", 35, 10);
        seedDataVariantAtribute("Cảm biến khí áp kế,Con quay hồi chuyển,Cảm biến ánh sáng,Cảm biến la bàn,Cảm biến gia tốc,Cảm biến tiệm cận", 36, 10);


        seedDataVariantAtribute("Trung quốc", 1, 11);
        seedDataVariantAtribute("09/2023", 2, 11);
        seedDataVariantAtribute("12", 4, 11);
        seedDataVariantAtribute("160.8 x 78.1 x 7.8 mm", 5, 11);
        seedDataVariantAtribute("201g", 6, 11);
        seedDataVariantAtribute("IP68", 8, 11);
        seedDataVariantAtribute("Khung máy: Nhôm nguyên khối,Mặt lưng máy: Kính", 7, 11);
        seedDataVariantAtribute("Apple A16 Bionic", 9, 11);
        seedDataVariantAtribute("6-Core", 10, 11);
        seedDataVariantAtribute("6 GB", 13, 11);
        seedDataVariantAtribute("6.7 inch", 14, 11);
        seedDataVariantAtribute("OLED", 15, 11);
        seedDataVariantAtribute("Super Retina XDR", 16, 11);
        seedDataVariantAtribute("1290 x 2796 pixels", 17, 11);
        seedDataVariantAtribute("Phủ ceramic", 18, 11);
        seedDataVariantAtribute("Điện dung đa điểm", 19, 11);
        seedDataVariantAtribute("2000 nits", 20, 11);
        seedDataVariantAtribute("2.000.000:1", 21, 11);
        seedDataVariantAtribute("Apple GPU 5 nhân", 23, 11);
        seedDataVariantAtribute("Không giới hạn", 25, 11);
        seedDataVariantAtribute("Không", 26, 11);
        seedDataVariantAtribute("Double rear camera", 27, 11);
        seedDataVariantAtribute("Standard", 28, 11);
        seedDataVariantAtribute("12.0 MP", 29, 11);
        seedDataVariantAtribute("4K 2160p@25fps,4K 2160p@24fps,4K 2160p@60fps,4K 2160p@30fps,FullHD 1060p@25fps,FullHD 1060p@60fps,FullHD 1060p@30fps,HD 720p@30fps", 29, 11);
        seedDataVariantAtribute("Chụp chân dung,Quay chậm (Slow Motion),HDR,Chụp góc rộng (Wide),Chống rung quang học (OIS),Ổn định hình ảnh quang học,Trôi nhanh thời gian (Time Lapse),Toàn cảnh (Panorama),Nhận diện khuôn mặt,Tự động lấy nét (AF),Chạm lấy nét,Live Photo,Ban đêm (Night Mode),Chuyên nghiệp (Pro)", 31, 11);
        seedDataVariantAtribute("Single selfie camera", 32, 11);


        seedDataVariantAtribute("Trung quốc", 1, 12);
        seedDataVariantAtribute("09/2023", 2, 12);
        seedDataVariantAtribute("12", 4, 12);
        seedDataVariantAtribute("160.8 x 78.1 x 7.8 mm", 5, 12);
        seedDataVariantAtribute("201g", 6, 12);
        seedDataVariantAtribute("IP68", 8, 12);
        seedDataVariantAtribute("Khung máy: Nhôm nguyên khối,Mặt lưng máy: Kính", 7, 12);
        seedDataVariantAtribute("Apple A16 Bionic", 9, 12);
        seedDataVariantAtribute("6-Core", 10, 12);
        seedDataVariantAtribute("6 GB", 13, 12);
        seedDataVariantAtribute("6.7 inch", 14, 12);
        seedDataVariantAtribute("OLED", 15, 12);
        seedDataVariantAtribute("Super Retina XDR", 16, 12);
        seedDataVariantAtribute("1290 x 2796 pixels", 17, 12);
        seedDataVariantAtribute("Phủ ceramic", 18, 12);
        seedDataVariantAtribute("Điện dung đa điểm", 19, 12);
        seedDataVariantAtribute("2000 nits", 20, 12);
        seedDataVariantAtribute("2.000.000:1", 21, 12);
        seedDataVariantAtribute("Apple GPU 5 nhân", 23, 12);
        seedDataVariantAtribute("Không giới hạn", 25, 12);
        seedDataVariantAtribute("Không", 26, 12);
        seedDataVariantAtribute("Double rear camera", 27, 12);
        seedDataVariantAtribute("Standard", 28, 12);
        seedDataVariantAtribute("12.0 MP", 29, 12);
        seedDataVariantAtribute("4K 2160p@25fps,4K 2160p@24fps,4K 2160p@60fps,4K 2160p@30fps,FullHD 1060p@25fps,FullHD 1060p@60fps,FullHD 1060p@30fps,HD 720p@30fps", 29, 12);
        seedDataVariantAtribute("Chụp chân dung,Quay chậm (Slow Motion),HDR,Chụp góc rộng (Wide),Chống rung quang học (OIS),Ổn định hình ảnh quang học,Trôi nhanh thời gian (Time Lapse),Toàn cảnh (Panorama),Nhận diện khuôn mặt,Tự động lấy nét (AF),Chạm lấy nét,Live Photo,Ban đêm (Night Mode),Chuyên nghiệp (Pro)", 31, 12);
        seedDataVariantAtribute("Single selfie camera", 32, 12);
        seedDataVariantAtribute("12.0 MP", 33, 12);


        // iphone 15 pro
        seedDataProduct("iPhone 15 Pro", "Điện thoại", 0.5, 1, 1, 1, "iphone_15_pro_max_f589ed5358.png");

        // phiên bản iphone 15 pro
        seedDataVariant("/src/assets/products/iphone15pro-Den-128GB.jpg", "iphone15pro Đen 128GB", 28990200.0, 10, 5);
        seedDataVariant("/src/assets/products/iphone15pro-Trang-256GB.jpg", "iphone15pro Trắng 256GB", 31990009.0, 10, 5);
        seedDataVariant("/src/assets/products/iphone15pro-Xanh-512GB.jpg", "iphone15pro Xanh 512GB", 37990900.0, 10, 5);
        seedDataVariant("/src/assets/products/iphone15pro-Den-1TB.jpg", "iphone15pro Đen 1TB", 43990000.0, 10, 5);


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
        seedDataVariantAtribute("4K 2160p@25fps,4K 2160p@24fps,4K 2160p@30fps,4K 2160p@60fps,FullHD 1060p@25fps,FullHD 1060p@60fps,FullHD 1060p@30fps,HD 720p@30fps", 30, 13);
        seedDataVariantAtribute("Chụp chân dung,Quay chậm (Slow Motion),HDR,Chụp góc rộng (Wide),Chống rung quang học (OIS),Ổn định hình ảnh quang học,Trôi nhanh thời gian (Time Lapse),Toàn cảnh (Panorama),Nhận diện khuôn mặt,Tự động lấy nét (AF),Chạm lấy nét,Flash LED,Ban đêm (Night Mode),Chuyên nghiệp (Pro),Chụp góc siêu rộng (Ultrawide)", 31, 13);
        seedDataVariantAtribute("Single selfie camera", 32, 13);
        seedDataVariantAtribute("12.0 MP", 33, 13);
        seedDataVariantAtribute("Quay phim 4K,Quay phim FullHD", 34, 13);
        seedDataVariantAtribute("Chụp góc rộng (Wide),Ban đêm (Night Mode),HDR,Live Photo,Flash màn hình,Nhận diện khuôn mặt,Ổn định hình ảnh quang học,Chế độ chân dung", 35, 13);
        seedDataVariantAtribute("Cảm biến khí áp kế,Con quay hồi chuyển,Cảm biến ánh sáng,Cảm biến la bàn,Cảm biến gia tốc,Cảm biến tiệm cận", 36, 13);
        seedDataVariantAtribute("Mở khóa khuôn mặt,Mở khóa bằng mật mã", 37, 13);
        seedDataVariantAtribute("1 eSIM, 1 Nano SIM", 38, 13);
        seedDataVariantAtribute("1", 39, 13);


        seedDataVariantAtribute("Trung quốc", 1, 14);
        seedDataVariantAtribute("09/2023", 2, 14);
        seedDataVariantAtribute("12", 4, 14);
        seedDataVariantAtribute("146.6 x 70.6 x 8.25 mm", 5, 14);
        seedDataVariantAtribute("187g", 6, 14);
        seedDataVariantAtribute("IP68", 8, 14);
        seedDataVariantAtribute("Khung máy: Titanium", 7, 14);
        seedDataVariantAtribute("Apple A17 Pro", 9, 14);
        seedDataVariantAtribute("6-Core", 10, 14);
        seedDataVariantAtribute("6", 11, 14);
        seedDataVariantAtribute("8 GB", 13, 14);
        seedDataVariantAtribute("6.1 inch", 14, 14);
        seedDataVariantAtribute("OLED", 15, 14);
        seedDataVariantAtribute("Super Retina XDR", 16, 14);
        seedDataVariantAtribute("1179 x 2556 pixels", 17, 14);
        seedDataVariantAtribute("Phủ ceramic", 18, 14);
        seedDataVariantAtribute("Điện dung đa điểm", 19, 14);
        seedDataVariantAtribute("2000 nits", 20, 14);
        seedDataVariantAtribute("2.000.000:1", 21, 14);
        seedDataVariantAtribute("Triple rear camera", 27, 14);
        seedDataVariantAtribute("Standard", 28, 14);
        seedDataVariantAtribute("12.0 MP", 29, 14);
        seedDataVariantAtribute("4K 2160p@25fps,4K 2160p@24fps,4K 2160p@30fps,4K 2160p@60fps,FullHD 1060p@25fps,FullHD 1060p@60fps,FullHD 1060p@30fps,HD 720p@30fps", 30, 14);
        seedDataVariantAtribute("Chụp chân dung,Quay chậm (Slow Motion),HDR,Chụp góc rộng (Wide),Chống rung quang học (OIS),Ổn định hình ảnh quang học,Trôi nhanh thời gian (Time Lapse),Toàn cảnh (Panorama),Nhận diện khuôn mặt,Tự động lấy nét (AF),Chạm lấy nét,Flash LED,Ban đêm (Night Mode),Chuyên nghiệp (Pro),Chụp góc siêu rộng (Ultrawide)", 31, 14);


        seedDataVariantAtribute("Trung quốc", 1, 15);
        seedDataVariantAtribute("09/2023", 2, 15);
        seedDataVariantAtribute("12", 4, 15);
        seedDataVariantAtribute("146.6 x 70.6 x 8.25 mm", 5, 15);
        seedDataVariantAtribute("187g", 6, 15);
        seedDataVariantAtribute("IP68", 8, 15);
        seedDataVariantAtribute("Khung máy: Titanium", 7, 15);
        seedDataVariantAtribute("Apple A17 Pro", 9, 15);
        seedDataVariantAtribute("6-Core", 10, 15);
        seedDataVariantAtribute("6", 11, 15);
        seedDataVariantAtribute("8 GB", 13, 15);
        seedDataVariantAtribute("6.1 inch", 14, 15);
        seedDataVariantAtribute("OLED", 15, 15);
        seedDataVariantAtribute("Super Retina XDR", 16, 15);
        seedDataVariantAtribute("1179 x 2556 pixels", 17, 15);
        seedDataVariantAtribute("Phủ ceramic", 18, 15);
        seedDataVariantAtribute("Điện dung đa điểm", 19, 15);
        seedDataVariantAtribute("2000 nits", 20, 15);
        seedDataVariantAtribute("2.000.000:1", 21, 15);
        seedDataVariantAtribute("Triple rear camera", 27, 15);
        seedDataVariantAtribute("Standard", 28, 15);
        seedDataVariantAtribute("12.0 MP", 29, 15);
        seedDataVariantAtribute("4K 2160p@25fps,4K 2160p@24fps,4K 2160p@30fps,4K 2160p@60fps,FullHD 1060p@25fps,FullHD 1060p@60fps,FullHD 1060p@30fps,HD 720p@30fps", 30, 15);
        seedDataVariantAtribute("Chụp chân dung,Quay chậm (Slow Motion),HDR,Chụp góc rộng (Wide),Chống rung quang học (OIS),Ổn định hình ảnh quang học,Trôi nhanh thời gian (Time Lapse),Toàn cảnh (Panorama),Nhận diện khuôn mặt,Tự động lấy nét (AF),Chạm lấy nét,Flash LED,Ban đêm (Night Mode),Chuyên nghiệp (Pro),Chụp góc siêu rộng (Ultrawide)", 31, 15);
        seedDataVariantAtribute("Single selfie camera", 32, 15);
        seedDataVariantAtribute("12.0 MP", 33, 15);
        seedDataVariantAtribute("Quay phim 4K,Quay phim FullHD", 34, 15);
        seedDataVariantAtribute("Chụp góc rộng (Wide),Ban đêm (Night Mode),HDR,Live Photo,Flash màn hình,Nhận diện khuôn mặt,Ổn định hình ảnh quang học,Chế độ chân dung", 35, 15);
        seedDataVariantAtribute("Cảm biến khí áp kế,Con quay hồi chuyển,Cảm biến ánh sáng,Cảm biến la bàn,Cảm biến gia tốc,Cảm biến tiệm cận", 36, 15);
        seedDataVariantAtribute("Mở khóa khuôn mặt,Mở khóa bằng mật mã", 37, 15);
        seedDataVariantAtribute("1 eSIM, 1 Nano SIM", 38, 15);
        seedDataVariantAtribute("1", 39, 15);
        seedDataVariantAtribute("5G", 40, 15);
        seedDataVariantAtribute("Cổng sạc: Type C,Audio Jack: Type C", 41, 15);




        seedDataVariantAtribute("Trung quốc", 1, 16);
        seedDataVariantAtribute("09/2023", 2, 16);
        seedDataVariantAtribute("12", 4, 16);
        seedDataVariantAtribute("146.6 x 70.6 x 8.25 mm", 5, 16);
        seedDataVariantAtribute("187g", 6, 16);
        seedDataVariantAtribute("IP68", 8, 16);
        seedDataVariantAtribute("Khung máy: Titanium", 7, 16);
        seedDataVariantAtribute("Apple A17 Pro", 9, 16);
        seedDataVariantAtribute("6-Core", 10, 16);
        seedDataVariantAtribute("6", 11, 16);
        seedDataVariantAtribute("8 GB", 13, 16);
        seedDataVariantAtribute("6.1 inch", 14, 16);
        seedDataVariantAtribute("OLED", 15, 16);
        seedDataVariantAtribute("Super Retina XDR", 16, 16);
        seedDataVariantAtribute("1179 x 2556 pixels", 17, 16);
        seedDataVariantAtribute("Phủ ceramic", 18, 16);
        seedDataVariantAtribute("Điện dung đa điểm", 19, 16);
        seedDataVariantAtribute("2000 nits", 20, 16);
        seedDataVariantAtribute("2.000.000:1", 21, 16);
        seedDataVariantAtribute("Triple rear camera", 27, 16);
        seedDataVariantAtribute("Standard", 28, 16);
        seedDataVariantAtribute("12.0 MP", 29, 16);
        seedDataVariantAtribute("4K 2160p@25fps,4K 2160p@24fps,4K 2160p@30fps,4K 2160p@60fps,FullHD 1060p@25fps,FullHD 1060p@60fps,FullHD 1060p@30fps,HD 720p@30fps", 30, 16);
        seedDataVariantAtribute("Chụp chân dung,Quay chậm (Slow Motion),HDR,Chụp góc rộng (Wide),Chống rung quang học (OIS),Ổn định hình ảnh quang học,Trôi nhanh thời gian (Time Lapse),Toàn cảnh (Panorama),Nhận diện khuôn mặt,Tự động lấy nét (AF),Chạm lấy nét,Flash LED,Ban đêm (Night Mode),Chuyên nghiệp (Pro),Chụp góc siêu rộng (Ultrawide)", 31, 16);
        seedDataVariantAtribute("Single selfie camera", 32, 16);
        seedDataVariantAtribute("12.0 MP", 33, 16);
        seedDataVariantAtribute("Quay phim 4K,Quay phim FullHD", 34, 16);
        seedDataVariantAtribute("Chụp góc rộng (Wide),Ban đêm (Night Mode),HDR,Live Photo,Flash màn hình,Nhận diện khuôn mặt,Ổn định hình ảnh quang học,Chế độ chân dung", 35, 16);


        // iphone 15 pro max
        seedDataProduct("iPhone 15 Pro Max", "Điện thoại", 0.5, 1, 1, 1, "iphone_15_pro_max_f589ed5358.png");

        // phiên bản iphone 15 pro max
        seedDataVariant("/src/assets/products/iphone15promax-Den-256GB.jpg", "iphone15promax Đen 256GB", 34990020.0, 10, 6);
        seedDataVariant("/src/assets/products/iphone15promax-Trang-512GB.jpg", "iphone15promax Trắng 512GB", 40990000.0, 10, 6);
        seedDataVariant("/src/assets/products/iphone15promax-Xanh-1TB.jpg", "iphone15promax Xanh 1TB", 46990000.0, 10, 6);

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
        seedDataVariantAtribute("4K 2160p@25fps,4K 2160p@24fps,4K 2160p@60fps,4K 2160p@30fps,FullHD 1060p@25fps,FullHD 1060p@60fps,FullHD 1060p@30fps,HD 720p@30fps", 30, 17);
        seedDataVariantAtribute("Chụp chân dung,Quay chậm (Slow Motion),HDR,Chụp góc rộng (Wide),Chống rung quang học (OIS),Ổn định hình ảnh quang học,Trôi nhanh thời gian (Time Lapse),Toàn cảnh (Panorama),Tự động lấy nét (AF),Chạm lấy nét,Flash LED,Ban đêm (Night Mode),Chuyên nghiệp (Pro),Chụp góc siêu rộng (Ultrawide),Chụp chuyển động", 31, 17);
        seedDataVariantAtribute("Single selfie camera", 32, 17);
        seedDataVariantAtribute("12.0 MP", 33, 17);
        seedDataVariantAtribute("Quay phim 4K,Quay phim FullHD", 34, 17);


        seedDataVariantAtribute("Trung quốc", 1, 18);
        seedDataVariantAtribute("09/2023", 2, 18);
        seedDataVariantAtribute("12", 4, 18);
        seedDataVariantAtribute("159.9 x 76.7 x 8.25 mm", 5, 18);
        seedDataVariantAtribute("221g", 6, 18);
        seedDataVariantAtribute("IP68", 8, 18);
        seedDataVariantAtribute("Khung máy: Titanium", 7, 18);
        seedDataVariantAtribute("Apple A17 Pro", 9, 18);
        seedDataVariantAtribute("6-Core", 10, 18);
        seedDataVariantAtribute("8 GB", 13, 18);
        seedDataVariantAtribute("6.7 inch", 14, 18);
        seedDataVariantAtribute("OLED", 15, 18);
        seedDataVariantAtribute("Super Retina XDR", 16, 18);
        seedDataVariantAtribute("1290 x 2796 pixels", 17, 18);
        seedDataVariantAtribute("Phủ ceramic", 18, 18);
        seedDataVariantAtribute("Điện dung đa điểm", 19, 18);
        seedDataVariantAtribute("2000 nits", 20, 18);
        seedDataVariantAtribute("2.000.000:1", 21, 18);
        seedDataVariantAtribute("Triple rear camera", 27, 18);
        seedDataVariantAtribute("Standard", 28, 18);
        seedDataVariantAtribute("12.0 MP", 29, 18);
        seedDataVariantAtribute("4K 2160p@25fps,4K 2160p@24fps,4K 2160p@60fps,4K 2160p@30fps,FullHD 1060p@25fps,FullHD 1060p@60fps,FullHD 1060p@30fps,HD 720p@30fps", 30, 18);
        seedDataVariantAtribute("Chụp chân dung,Quay chậm (Slow Motion),HDR,Chụp góc rộng (Wide),Chống rung quang học (OIS),Ổn định hình ảnh quang học,Trôi nhanh thời gian (Time Lapse),Toàn cảnh (Panorama),Tự động lấy nét (AF),Chạm lấy nét,Flash LED,Ban đêm (Night Mode),Chuyên nghiệp (Pro),Chụp góc siêu rộng (Ultrawide),Chụp chuyển động", 31, 18);
        seedDataVariantAtribute("Single selfie camera", 32, 18);
        seedDataVariantAtribute("12.0 MP", 33, 18);
        seedDataVariantAtribute("Quay phim 4K,Quay phim FullHD", 34, 18);
        seedDataVariantAtribute("Chụp góc rộng (Wide),Tự động lấy nét (AF),Ban đêm (Night Mode),HDR,Flash màn hình,Ổn định hình ảnh quang học,Chế độ chân dung", 35, 18);
        seedDataVariantAtribute("Cảm biến khí áp kế,Con quay hồi chuyển,Cảm biến ánh sáng,Cảm biến la bàn,Cảm biến gia tốc,Cảm biến tiệm cận", 36, 18);
        seedDataVariantAtribute("Mở khóa khuôn mặt,Mở khóa bằng mật mã", 37, 18);
        seedDataVariantAtribute("1 eSIM, 1 Nano SIM", 38, 18);
        seedDataVariantAtribute("1", 39, 18);
        seedDataVariantAtribute("5G", 40, 18);
        seedDataVariantAtribute("Cổng sạc: Type C,Audio Jack: Type C", 41, 18);
        seedDataVariantAtribute("Wifi 6", 42, 18);
        seedDataVariantAtribute("BEIDOU,GALILEO,GLONASS,GPS,QZSS", 43, 18);
        seedDataVariantAtribute("v5.3", 44, 18);
        seedDataVariantAtribute("NFC", 45, 18);
        seedDataVariantAtribute("Lithium-ion", 46, 18);
        seedDataVariantAtribute("29 giờ", 47, 18);
        seedDataVariantAtribute("Hỗ trợ sạc không dây,Sạc pin nhanh,Sạc ngược cho thiết bị khác", 48, 18);
        seedDataVariantAtribute("iOS", 49, 18);
        seedDataVariantAtribute("iOS 17", 50, 18);
        seedDataVariantAtribute("Cáp USB-C to USB-C, Sách HDSD, Que lấy SIM", 51, 18);

        seedDataVariantAtribute("Trung quốc", 1, 19);
        seedDataVariantAtribute("09/2023", 2, 19);
        seedDataVariantAtribute("12", 4, 19);
        seedDataVariantAtribute("159.9 x 76.7 x 8.25 mm", 5, 19);
        seedDataVariantAtribute("221g", 6, 19);
        seedDataVariantAtribute("IP68", 8, 19);
        seedDataVariantAtribute("Khung máy: Titanium", 7, 19);
        seedDataVariantAtribute("Apple A17 Pro", 9, 19);
        seedDataVariantAtribute("6-Core", 10, 19);
        seedDataVariantAtribute("8 GB", 13, 19);
        seedDataVariantAtribute("6.7 inch", 14, 19);
        seedDataVariantAtribute("OLED", 15, 19);
        seedDataVariantAtribute("Super Retina XDR", 16, 19);
        seedDataVariantAtribute("1290 x 2796 pixels", 17, 19);
        seedDataVariantAtribute("Phủ ceramic", 18, 19);
        seedDataVariantAtribute("Điện dung đa điểm", 19, 19);
        seedDataVariantAtribute("2000 nits", 20, 19);
        seedDataVariantAtribute("2.000.000:1", 21, 19);
        seedDataVariantAtribute("Triple rear camera", 27, 19);
        seedDataVariantAtribute("Standard", 28, 19);
        seedDataVariantAtribute("12.0 MP", 29, 19);
        seedDataVariantAtribute("4K 2160p@25fps,4K 2160p@24fps,4K 2160p@60fps,4K 2160p@30fps,FullHD 1060p@25fps,FullHD 1060p@60fps,FullHD 1060p@30fps,HD 720p@30fps", 30, 19);
        seedDataVariantAtribute("Chụp chân dung,Quay chậm (Slow Motion),HDR,Chụp góc rộng (Wide),Chống rung quang học (OIS),Ổn định hình ảnh quang học,Trôi nhanh thời gian (Time Lapse),Toàn cảnh (Panorama),Tự động lấy nét (AF),Chạm lấy nét,Flash LED,Ban đêm (Night Mode),Chuyên nghiệp (Pro),Chụp góc siêu rộng (Ultrawide),Chụp chuyển động", 31, 19);


        // iphone 16
        seedDataProduct("iPhone 16", "Điện thoại", 0.5, 1, 1, 1, "iphone_16_f27848b783.png");

        // phiên bản iphone 16
        seedDataVariant("/src/assets/products/iphone16-Den-128GB.png", "iphone16 Đen 128GB", 22990020.0, 10, 7);
        seedDataVariant("/src/assets/products/iphone16-Trang-256GB.png", "iphone16 Trắng 256GB", 25990200.0, 10, 7);
        seedDataVariant("/src/assets/products/iphone16-Xanh-512GB.png", "iphone16 Xanh 512GB", 30990000.0, 10, 7);


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
        seedDataVariantAtribute("4K 2160p@25fps,4K 2160p@24fps,4K 4230p@30fps,4K 4230p@60fps,FullHD 1060p@25fps,FullHD 1060p@60fps,FullHD 1060p@30fps,HD 720p@30fps", 30, 20);
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

        seedDataVariantAtribute("Trung quốc", 1, 21);
        seedDataVariantAtribute("09/2024", 2, 21);
        seedDataVariantAtribute("12", 4, 21);
        seedDataVariantAtribute("146.6 x 71.6 x 7.8 mm", 5, 21);
        seedDataVariantAtribute("170", 6, 21);
        seedDataVariantAtribute("IP68", 8, 21);
        seedDataVariantAtribute("Khung máy: Nhôm nguyên khối,Mặt lưng máy: Kính", 7, 21);
        seedDataVariantAtribute("Apple A18", 9, 21);
        seedDataVariantAtribute("6-Core", 10, 21);
        seedDataVariantAtribute("6 GB", 13, 21);
        seedDataVariantAtribute("6.1 inch", 14, 21);
        seedDataVariantAtribute("OLED", 15, 21);
        seedDataVariantAtribute("Super Retina XDR", 16, 21);
        seedDataVariantAtribute("1179 x 2556 pixels", 17, 21);
        seedDataVariantAtribute("Phủ ceramic", 18, 21);
        seedDataVariantAtribute("Điện dung đa điểm", 19, 21);
        seedDataVariantAtribute("2000 nits", 20, 21);
        seedDataVariantAtribute("2.000.000:1", 21, 21);
        seedDataVariantAtribute("Apple GPU 5 nhân", 23, 21);
        seedDataVariantAtribute("Không giới hạn", 25, 21);
        seedDataVariantAtribute("Không", 26, 21);
        seedDataVariantAtribute("Double rear camera", 27, 21);
        seedDataVariantAtribute("Standard", 28, 21);
        seedDataVariantAtribute("12.0 MP", 29, 21);
        seedDataVariantAtribute("4K 2160p@25fps,4K 2160p@24fps,4K 4230p@30fps,4K 4230p@60fps,FullHD 1060p@25fps,FullHD 1060p@60fps,FullHD 1060p@30fps,HD 720p@30fps", 30, 21);
        seedDataVariantAtribute("Chụp chân dung,Quay chậm (Slow Motion),HDR,Chụp góc rộng (Wide),Chống rung quang học (OIS),Tự động lấy nét (AF), Chạm lấy nét, Flash LED,", 31, 21);
        seedDataVariantAtribute("Single selfie camera", 32, 21);
        seedDataVariantAtribute("12.0 MP", 33, 21);
        seedDataVariantAtribute("Quay phim 4K,Quay phim FullHD,Quay phim Slow Motion", 34, 21);


        seedDataVariantAtribute("Trung quốc", 1, 22);
        seedDataVariantAtribute("09/2024", 2, 22);
        seedDataVariantAtribute("12", 4, 22);
        seedDataVariantAtribute("146.6 x 71.6 x 7.8 mm", 5, 22);
        seedDataVariantAtribute("170", 6, 22);
        seedDataVariantAtribute("IP68", 8, 22);
        seedDataVariantAtribute("Khung máy: Nhôm nguyên khối,Mặt lưng máy: Kính", 7, 22);
        seedDataVariantAtribute("Apple A18", 9, 22);
        seedDataVariantAtribute("6-Core", 10, 22);
        seedDataVariantAtribute("6 GB", 13, 22);
        seedDataVariantAtribute("6.1 inch", 14, 22);
        seedDataVariantAtribute("OLED", 15, 22);
        seedDataVariantAtribute("Super Retina XDR", 16, 22);
        seedDataVariantAtribute("1179 x 2556 pixels", 17, 22);
        seedDataVariantAtribute("Phủ ceramic", 18, 22);
        seedDataVariantAtribute("Điện dung đa điểm", 19, 22);
        seedDataVariantAtribute("2000 nits", 20, 22);
        seedDataVariantAtribute("2.000.000:1", 21, 22);
        seedDataVariantAtribute("Apple GPU 5 nhân", 23, 22);
        seedDataVariantAtribute("Không giới hạn", 25, 22);
        seedDataVariantAtribute("Không", 26, 22);
        seedDataVariantAtribute("Double rear camera", 27, 22);
        seedDataVariantAtribute("Standard", 28, 22);
        seedDataVariantAtribute("12.0 MP", 29, 22);
        seedDataVariantAtribute("4K 2160p@25fps,4K 2160p@24fps,4K 4230p@30fps,4K 4230p@60fps,FullHD 1060p@25fps,FullHD 1060p@60fps,FullHD 1060p@30fps,HD 720p@30fps", 30, 22);
        seedDataVariantAtribute("Chụp chân dung,Quay chậm (Slow Motion),HDR,Chụp góc rộng (Wide),Chống rung quang học (OIS),Tự động lấy nét (AF), Chạm lấy nét, Flash LED,", 31, 22);
        seedDataVariantAtribute("Single selfie camera", 32, 22);
        seedDataVariantAtribute("12.0 MP", 33, 22);


        // iphone 16 pro
        seedDataProduct("iPhone 16 Pro", "Điện thoại", 0.5, 1, 1, 1, "iphone_16_f27848b783.png");

        // phiên bản iphone 16 pro
        seedDataVariant("/src/assets/products/iphone16pro-Den-128GB.png", "iphone16pro Đen 128GB", 28990040.0, 10, 8);
        seedDataVariant("/src/assets/products/iphone16pro-Trang-256GB.png", "iphone16pro Trắng 256GB", 31990020.0, 10, 8);
        seedDataVariant("/src/assets/products/iphone16pro-Xanh-512GB.png", "iphone16pro Xanh 512GB", 37990200.0, 10, 8);
        seedDataVariant("/src/assets/products/iphone16pro-Den-1TB.png", "iphone16pro Đen 1TB", 43990090.0, 10, 8);


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
        seedDataVariantAtribute("4K 2160p@25fps,4K 2160p@24fps,4K 2160p@30fps,4K 2160p@60fps,FullHD 1060p@25fps,FullHD 1060p@60fps,FullHD 1060p@30fps,HD 720p@30fps", 30, 23);
        seedDataVariantAtribute("Chụp chân dung,Quay chậm (Slow Motion),HDR,Chụp góc rộng (Wide),Chống rung quang học (OIS),Ổn định hình ảnh quang học,Trôi nhanh thời gian (Time Lapse),Toàn cảnh (Panorama),Nhận diện khuôn mặt,Tự động lấy nét (AF),Chạm lấy nét,Flash LED,Ban đêm (Night Mode),Chuyên nghiệp (Pro),Chụp góc siêu rộng (Ultrawide)", 31, 23);
        seedDataVariantAtribute("Single selfie camera", 32, 23);
        seedDataVariantAtribute("12.0 MP", 33, 23);
        seedDataVariantAtribute("Quay phim 4K,Quay phim FullHD", 34, 23);


        seedDataVariantAtribute("Trung quốc", 1, 24);
        seedDataVariantAtribute("09/2024", 2, 24);
        seedDataVariantAtribute("12", 4, 24);
        seedDataVariantAtribute("149.6 x 71.5 x 8.25 mm", 5, 24);
        seedDataVariantAtribute("199 g", 6, 24);
        seedDataVariantAtribute("IP68", 8, 24);
        seedDataVariantAtribute("Khung máy: Titanium", 7, 24);
        seedDataVariantAtribute("Apple A18 Pro", 9, 24);
        seedDataVariantAtribute("6-Core", 10, 24);
        seedDataVariantAtribute("6", 11, 24);
        seedDataVariantAtribute("8 GB", 13, 24);
        seedDataVariantAtribute("6.3 inch", 14, 24);
        seedDataVariantAtribute("OLED", 15, 24);
        seedDataVariantAtribute("Super Retina XDR", 16, 24);
        seedDataVariantAtribute("1206  x 2622  pixels", 17, 24);
        seedDataVariantAtribute("Phủ ceramic", 18, 24);
        seedDataVariantAtribute("Điện dung đa điểm", 19, 24);
        seedDataVariantAtribute("2000 nits", 20, 24);
        seedDataVariantAtribute("2.000.000:1", 21, 24);
        seedDataVariantAtribute("Apple GPU 6 nhân", 23, 24);
        seedDataVariantAtribute("Không giới hạn", 25, 24);
        seedDataVariantAtribute("Không", 26, 24);
        seedDataVariantAtribute("Triple rear camera", 27, 24);
        seedDataVariantAtribute("Standard", 28, 24);
        seedDataVariantAtribute("12.0 MP", 29, 24);
        seedDataVariantAtribute("4K 2160p@25fps,4K 2160p@24fps,4K 2160p@30fps,4K 2160p@60fps,FullHD 1060p@25fps,FullHD 1060p@60fps,FullHD 1060p@30fps,HD 720p@30fps", 30, 24);
        seedDataVariantAtribute("Chụp chân dung,Quay chậm (Slow Motion),HDR,Chụp góc rộng (Wide),Chống rung quang học (OIS),Ổn định hình ảnh quang học,Trôi nhanh thời gian (Time Lapse),Toàn cảnh (Panorama),Nhận diện khuôn mặt,Tự động lấy nét (AF),Chạm lấy nét,Flash LED,Ban đêm (Night Mode),Chuyên nghiệp (Pro),Chụp góc siêu rộng (Ultrawide)", 31, 24);
        seedDataVariantAtribute("Single selfie camera", 32, 24);
        seedDataVariantAtribute("12.0 MP", 33, 24);
        seedDataVariantAtribute("Quay phim 4K,Quay phim FullHD", 34, 24);
        seedDataVariantAtribute("Chụp góc rộng (Wide),Ban đêm (Night Mode),HDR,Live Photo,Flash màn hình,Flash màn hình,Nhận diện khuôn mặt,Ổn định hình ảnh quang học,Chế độ chân dung", 35, 24);
        seedDataVariantAtribute("Cảm biến khí áp kế,Con quay hồi chuyển,Cảm biến ánh sáng,Cảm biến la bàn,Cảm biến gia tốc,Cảm biến tiệm cận", 36, 24);
        seedDataVariantAtribute("Mở khóa khuôn mặt,Mở khóa bằng mật mã", 37, 24);
        seedDataVariantAtribute("1 eSIM, 1 Nano SIM", 38, 24);
        seedDataVariantAtribute("1", 39, 24);
        seedDataVariantAtribute("5G", 40, 24);
        seedDataVariantAtribute("Cổng sạc: Type C,Audio Jack: Type C", 41, 24);
        seedDataVariantAtribute("Wifi 7", 42, 24);
        seedDataVariantAtribute("BEIDOU,GALILEO,GLONASS,QZSS,GPS", 43, 24);
        seedDataVariantAtribute("v5.3", 44, 24);
        seedDataVariantAtribute("NFC", 45, 24);
        seedDataVariantAtribute("Lithium-ion", 46, 24);
        seedDataVariantAtribute("27 giờ", 47, 24);
        seedDataVariantAtribute("Hỗ trợ sạc không dây,Sạc pin nhanh,Sạc ngược cho thiết bị khác", 48, 24);
        seedDataVariantAtribute("iOS", 49, 24);
        seedDataVariantAtribute("iOS 18", 50, 24);
        seedDataVariantAtribute("Cáp USB-C to USB-C, Sách HDSD, Que lấy SIM", 51, 24);

        seedDataVariantAtribute("Trung quốc", 1, 25);
        seedDataVariantAtribute("09/2024", 2, 25);
        seedDataVariantAtribute("12", 4, 25);
        seedDataVariantAtribute("149.6 x 71.5 x 8.25 mm", 5, 25);
        seedDataVariantAtribute("199 g", 6, 25);
        seedDataVariantAtribute("IP68", 8, 25);
        seedDataVariantAtribute("Khung máy: Titanium", 7, 25);
        seedDataVariantAtribute("Apple A18 Pro", 9, 25);
        seedDataVariantAtribute("6-Core", 10, 25);
        seedDataVariantAtribute("6", 11, 25);
        seedDataVariantAtribute("8 GB", 13, 25);
        seedDataVariantAtribute("6.3 inch", 14, 25);
        seedDataVariantAtribute("OLED", 15, 25);
        seedDataVariantAtribute("Super Retina XDR", 16, 25);
        seedDataVariantAtribute("1206  x 2622  pixels", 17, 25);
        seedDataVariantAtribute("Phủ ceramic", 18, 25);
        seedDataVariantAtribute("Điện dung đa điểm", 19, 25);
        seedDataVariantAtribute("2000 nits", 20, 25);
        seedDataVariantAtribute("2.000.000:1", 21, 25);
        seedDataVariantAtribute("Apple GPU 6 nhân", 23, 25);
        seedDataVariantAtribute("Không giới hạn", 25, 25);
        seedDataVariantAtribute("Không", 26, 25);
        seedDataVariantAtribute("Triple rear camera", 27, 25);
        seedDataVariantAtribute("Standard", 28, 25);
        seedDataVariantAtribute("12.0 MP", 29, 25);
        seedDataVariantAtribute("4K 2160p@25fps,4K 2160p@24fps,4K 2160p@30fps,4K 2160p@60fps,FullHD 1060p@25fps,FullHD 1060p@60fps,FullHD 1060p@30fps,HD 720p@30fps", 30, 25);
        seedDataVariantAtribute("Chụp chân dung,Quay chậm (Slow Motion),HDR,Chụp góc rộng (Wide),Chống rung quang học (OIS),Ổn định hình ảnh quang học,Trôi nhanh thời gian (Time Lapse),Toàn cảnh (Panorama),Nhận diện khuôn mặt,Tự động lấy nét (AF),Chạm lấy nét,Flash LED,Ban đêm (Night Mode),Chuyên nghiệp (Pro),Chụp góc siêu rộng (Ultrawide)", 31, 25);

        // sam sung galaxy s24 FE
        seedDataProduct("Samsung Galaxy S24 FE", "Điện thoại", 0.5, 2, 1, 2, "samssung_galaxy_s24_fe_xanh_723e4e6443.png");

        // phiên bản samsung galaxy s24 FE
        seedDataVariant("/src/assets/products/SamsungGalaxys24fe-Den-128GB.png", "SamsungGalaxys24fe Đen 128GB", 16990000.0, 10, 9);

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
        seedDataVariantAtribute("1060 x 2340 Pixels", 17, 27);
        seedDataVariantAtribute("Xclipse 940", 23, 27);
        seedDataVariantAtribute("Không giới hạn", 25, 27);
        seedDataVariantAtribute("Không", 26, 27);
        seedDataVariantAtribute("Triple rear camera", 27, 27);


        // sam sung galaxy s23
        seedDataProduct("Samsung Galaxy S23", "Điện thoại", 0.5, 2, 1, 2, "samsung_galaxy_s23_591dfc2c85.png");

        // phiên bản samsung galaxy s23
        seedDataVariant("/src/assets/products/Samsunggalaxys23 Xanh 256GB.jpg", "samsunggalaxys23 Xanh 256GB", 24990300.0, 10, 10);

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
        seedDataVariantAtribute("1060 x 2340 Pixels", 17, 28);
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
        seedDataVariantAtribute("4K 2160p@30fps,4K 2160p@60fps,4230p@30fps,8K 4230p@30fps,HD 720p@30fps,8K 4320p@24fps,FullHD 1060p@240fps,FullHD 1060p@30fps,FullHD 1060p@60fps", 30, 28);
        seedDataVariantAtribute("A.I Camera,Chống rung quang học (OIS)", 31, 28);


        //Samsung Galaxy S24 Ultra
        seedDataProduct("Samsung Galaxy S24 Ultra", "Điện thoại", 0.5, 2, 1, 2, "samsung_galaxy_s24_ultra_2f8a5ee174.png");

        // phiên bản Samsung Galaxy S24 Ultra
        seedDataVariant("/src/assets/products/Samsunggalaxys24ultra-Den-256GB.png", "samsunggalaxys24ultra Đen 256GB", 33997000.0, 10, 11);
        seedDataVariant("/src/assets/products/Samsunggalaxys24ultra-Tim-512GB.png", "samsunggalaxys24ultra Tím 512GB", 37990800.0, 10, 11);

        // Thông số
        // điện thoại Samsung Galaxy S24 Ultra dung lượng 256 GB có 3 màu Đen, Trắng, Xanh giá 33.990.000
        seedDataVariantAtribute("Đen", 3, 29);
        seedDataVariantAtribute("256GB", 24, 29);

        // điện thoại Samsung Galaxy S24 Ultra dung lượng 512 GB có 3 màu Đen, Trắng, Xanh giá 37.990.000
        seedDataVariantAtribute("Tím", 3, 30);
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


        seedDataVariantAtribute("Việt Nam / Trung quốc", 1, 30);
        seedDataVariantAtribute("01/2024", 2, 30);
        seedDataVariantAtribute("12", 4, 30);
        seedDataVariantAtribute("79 x 162.3 x 8.6 mm", 5, 30);
        seedDataVariantAtribute("232 g", 6, 30);
        seedDataVariantAtribute("IP68", 8, 30);
        seedDataVariantAtribute("KKhung máy: Titan", 7, 30);
        seedDataVariantAtribute("Snapdragon 8 Gen 3", 9, 30);
        seedDataVariantAtribute("1 x 3.39 GHz + 2 x 3.1 GHz + 3 x 2.9 GHz + 2 x 2.2 GHz", 10, 30);
        seedDataVariantAtribute("8", 11, 30);
        seedDataVariantAtribute("3.39 GHz", 12, 30);
        seedDataVariantAtribute("12 GB", 13, 30);
        seedDataVariantAtribute("6.8 inch", 14, 30);
        seedDataVariantAtribute("QHD+", 15, 30);
        seedDataVariantAtribute("Dynamic AMOLED 2X", 16, 30);
        seedDataVariantAtribute("3120 x 1440 Pixels ", 17, 30);
        seedDataVariantAtribute("Corning Gorilla Glass Victus", 18, 30);
        seedDataVariantAtribute("2600 nits", 20, 30);
        seedDataVariantAtribute("120 Hz", 22, 30);
        seedDataVariantAtribute("Adreno 750", 23, 30);
        seedDataVariantAtribute("Không giới hạn", 25, 30);
        seedDataVariantAtribute("Không", 26, 30);
        seedDataVariantAtribute("Quad rear camera", 27, 30);
        seedDataVariantAtribute("Wide,Telephoto,Telephoto,Ultra Wide", 28, 30);
        seedDataVariantAtribute("200.0 MP,50.0 MP,10.0 MP,12.0 MP", 29, 30);
        seedDataVariantAtribute("UHD 8K (7680 x 4320)@30fps", 30, 30);
        seedDataVariantAtribute("Zoom quang học 3x,Zoom kĩ thuật số 30x,Chống rung kỹ thuật số AI VDIS và quang học OIS,Chụp hình & quay phim với Portrait AI,Chế độ Super HDR,Trợ lí Chỉnh ảnh (Gợi ý chỉnh sửa, Hậu kì sáng tạo),Chụp chân dung,Chụp góc rộng (Wide),HDR,Trôi nhanh thời gian (Time Lapse),Tự động lấy nét (AF),Ban đêm (Night Mode),Chụp góc siêu rộng (Ultrawide),Chống rung quang học (OIS),Zoom kĩ thuật số 100x,Zoom quang học 10x,Toàn cảnh (Panorama),Xóa phông,Quay siêu chậm (Super Slow Motion)", 31, 30);
        seedDataVariantAtribute("Single selfie camera", 32, 30);
        seedDataVariantAtribute("12.0 MP", 33, 30);
        seedDataVariantAtribute("Quay film chân dung", 34, 30);
        seedDataVariantAtribute("Chụp góc rộng (Wide),Ban đêm (Night Mode),HDR,Làm đẹp (Beautify),Chế độ chân dung", 35, 30);


        //Samsung Galaxy Z Flip5
        seedDataProduct("Samsung Galaxy Z Flip5", "Điện thoại", 0.5, 2, 1, 2, "2024_3_28_638472353992099331_samsung-galaxy-zflip-5-xanh-ai.jpg");

        // phiên bản Samsung Galaxy Z Flip5
        seedDataVariant("/src/assets/products/Samsunggalaxyzflip5-Xam-256GB.jpg", "samsunggalaxyzflip5 Xám 256GB", 25990000.0, 10, 12);

        // Thông số
        // điện thoại Samsung Galaxy Z Flip5 dung lượng 256 GB có 3 màu Đen, Trắng, Xanh giá 25.990.000
        seedDataVariantAtribute("Xám", 3, 31);
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
        seedDataVariantAtribute("1060 x 2636 Pixels", 17, 31);
        seedDataVariantAtribute("Diện dung đa điểm", 19, 31);
        seedDataVariantAtribute("1000 nits", 20, 31);
        seedDataVariantAtribute("120 Hz", 22, 31);
        seedDataVariantAtribute("Adreno 740", 23, 31);
        seedDataVariantAtribute("Không giới hạn", 25, 31);
        seedDataVariantAtribute("Không", 26, 31);



        // Samsung Galaxy A06
        seedDataProduct("Samsung Galaxy A06", "Điện thoại", 0.5, 2, 1, 1, "samsung_galaxy_a06_blue_black_1_46d3694f11.png");

        // phiên bản Samsung Galaxy A06
        seedDataVariant("/src/assets/products/Samsunggalaxya06-Den-128GB.png", "samsunggalaxya06 Đen 128GB", 3490000.0, 10, 13);

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
        seedDataVariantAtribute("FullHD 1060p@60fps,HD 720p@120fps", 30, 32);
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
        seedDataProduct("Samsung Galaxy A05", "Điện thoại", 0.5, 2, 1, 1, "Samsunggalaxya05Xanh128GB.jpg");

        // phiên bản Samsung Galaxy A05
        seedDataVariant("/src/assets/products/Samsunggalaxya05Xanh128GB.jpg", "samsunggalaxya05 Xanh 128GB", 2790010.0, 10, 14);


        // Thông số
        // điện thoại Samsung Galaxy A05 dung lượng 128 GB có 3 màu Đen, Trắng, Xanh giá 2.790.000
        seedDataVariantAtribute("Xanh lá", 3, 33);
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


        // OPPO A3
        seedDataProduct("OPPO A3", "Điện thoại", 0.5, 4, 1, 1, "oppo_a3_tim_5_a81a5f4bf7.jpg");

        // phiên bản OPPO A3
        seedDataVariant("/src/assets/products/Oppoa3-Đen-128GB.jpg", "oppoa3 Đen 128GB", 4993020.0, 10, 15);

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
        seedDataVariant("/src/assets/products/Opporeno12-Den-256GB.jpg", "opporeno12 Đen 256GB", 12690000.0, 10, 16);

        // Thông số
        // điện thoại OPPO Reno12 dung lượng 256 GB có 3 màu Đen, Trắng, Đen giá 12.690.000
        seedDataVariantAtribute("Đen", 3, 35);
        seedDataVariantAtribute("256GB", 24, 35);

        // thông số kĩ thuật
        seedDataVariantAtribute("Trung quốc", 1, 35);
        seedDataVariantAtribute("06/2024", 2, 35);
        seedDataVariantAtribute("12", 4, 35);
        seedDataVariantAtribute("161.4 x 74.1 x 7.6 mm", 5, 35);
        seedDataVariantAtribute("177 g", 6, 35);
        seedDataVariantAtribute("Khung máy: Kim loại,Mặt lưng máy: Kính cường lực", 7, 35);
        seedDataVariantAtribute("Dimensity 7300 Energy 5G", 9, 35);
        seedDataVariantAtribute("Octa-Core", 10, 35);
        seedDataVariantAtribute("8", 11, 35);
        seedDataVariantAtribute("2.5 GHz", 12, 35);
        seedDataVariantAtribute("12 GB", 13, 35);
        seedDataVariantAtribute("6.7 inch", 14, 35);
        seedDataVariantAtribute("AMOLED", 15, 35);
        seedDataVariantAtribute("FHD+", 16, 35);
        seedDataVariantAtribute("1060 x 2412  Pixels", 17, 35);
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
        seedDataVariantAtribute("4K 2160p@30fps,1060p@60fps,1060p@30fps,720p@30fps", 30, 35);
        seedDataVariantAtribute("Chống rung quang học (OIS),Zoom kỹ thuật số,Quay chậm (Slow Motion)", 31, 35);
        seedDataVariantAtribute("Single selfie camera", 32, 35);
        seedDataVariantAtribute("32.0 MP", 33, 35);
        seedDataVariantAtribute("4K 2160p@30fps, 1060p@30fps, 720p@30fps", 34, 35);
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
        seedDataVariant("/src/assets/products/Xiaomipocox6-Xanh-256GB.png", "xiaomipocox6 Xanh 256GB", 8990002.0, 10, 17);

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
        seedDataVariantAtribute("4K  4230p@30fps,1060p@60fps,1060p@30fps,720p@30fps", 30, 36);
        seedDataVariantAtribute("Zoom kỹ thuật số,Xóa phông,Trôi nhanh thời gian (Time Lapse),Siêu cận (Macro),Làm đẹp (Beautify),Ban đêm (Night Mode),Bộ lọc màu,Chống rung quang học (OIS)", 31, 36);
        seedDataVariantAtribute("Single selfie camera", 32, 36);


        // Xiaomi Poco M6
        seedDataProduct("Xiaomi Poco M6", "Điện thoại", 0.5, 3, 1, 1, "poco_m6_cc5c059d02.png");

        // phiên bản Xiaomi Poco M6 128 GB
        seedDataVariant("/src/assets/products/Xiaomipocom6-Den-128GB.jpg", "xiaomipocom6 Đen 128GB", 4290020.0, 10, 18);


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
        seedDataVariantAtribute("1060 x 2460 Pixels", 17, 37);
        seedDataVariantAtribute("Corning Gorilla Glass ", 18, 37);
        seedDataVariantAtribute("550 nits", 20, 37);
        seedDataVariantAtribute("1500:1", 21, 37);
        seedDataVariantAtribute("90 Hz", 22, 37);
        seedDataVariantAtribute("Mali-G52 MC2", 23, 37);
        seedDataVariantAtribute("MicroSD", 26, 37);
        seedDataVariantAtribute("Double rear camera", 27, 37);
        seedDataVariantAtribute("Standard,Macro lens", 28, 37);
        seedDataVariantAtribute("106.0 MP,2.0 MP", 29, 37);
        seedDataVariantAtribute("1060p@30fps,720p@30fps", 30, 37);
        seedDataVariantAtribute("Zoom kỹ thuật số,Xóa phông, Trôi nhanh thời gian (Time Lapse), Siêu cận (Macro), Làm đẹp (Beautify), Ban đêm (Night Mode),Bộ lọc màu", 31, 37);
        seedDataVariantAtribute("Single selfie camera", 32, 37);
        seedDataVariantAtribute("13.0 MP", 33, 37);
        seedDataVariantAtribute("1060p@30fps,720p@30fps", 34, 37);
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
        seedDataVariant("/src/assets/products/Xiaomiredminote13-Xanh-128GB.jpg", "xiaomiredminote13 Xanh- 128GB", 4990301.0, 10, 19);

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
        seedDataVariantAtribute("1060 x 2400 Pixels", 17, 38);
        seedDataVariantAtribute("120 Hz", 22, 38);
        seedDataVariantAtribute("Không giới hạn", 25, 38);
        seedDataVariantAtribute("MicroSD", 26, 38);
        seedDataVariantAtribute("Tripple rear camera", 27, 38);
        seedDataVariantAtribute("Standard, Ultra Wide, Macro lens", 28, 38);
        seedDataVariantAtribute("106.0 MP,8.0 MP,2.0 MP", 29, 38);
        seedDataVariantAtribute("1060p@60fps", 30, 38);
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
        seedDataVariant("/src/assets/products/Xiaomiredminote13proplus-Trang-256GB.png", "Xiaomiredminote13proplus-Trắng-256GB", 8990010.0, 10, 20);

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


        //MacBook Air
        // phiên bản  MacBook Air M2 13 2022 8CPU 10GPU 8GB 512GB
        seedDataProduct("MacBook Air M2 13 2022 8CPU 10GPU 8GB 512GB", "Laptop", 1.29, 6, 2, 2, "2022_6_7_637901915720184032_macbook-air-m2-2022-den-dd.jpg");
        seedDataVariant("/src/assets/products/MacbookAir13inchm220228CPU10GPU8GB512GBden.png", "MacbookAir 13inch m2 2022 8CPU \n 10GPU 8GB 512GB Đen 512GB",31990040.0, 10, 21);

        //MacBook Air 13 inch M2 2022 8CPU 8GPU 8GB/256GB
        seedDataProduct("MacBook Air 13 inch M2 2022 8CPU 8GPU 8GB/256GB", "Laptop", 1.29, 6, 2, 2, "2022_6_7_637901915720184032_macbook-air-m2-2022-den-dd.jpg");
        seedDataVariant("/src/assets/products/MacbookAir13inchm220228CPU10GPU8GB512GBxam.png", "MacBookAir 13inch M2 2022 8CPU \n 8GPU 8GB 256GB Xám 256GB",27990020.0, 10, 22);

        //MacBook Air 13 inch M1 2020 8CPU 7GPU 8GB/256GB
        seedDataProduct("MacBook Air 13 inch M1 2020 8CPU 7GPU 8GB/256GB", "Laptop", 1.29, 6, 2, 2, "2022_6_7_637901915720184032_macbook-air-m2-2022-den-dd.jpg");
        seedDataVariant("/src/assets/products/MacbookAir13inchm220228CPU10GPU8GB512GBtrang.png", "MacBookAir 13inchM1 2020 8CPU \n  7GPU 8GB 256GB Trắng 256GB",22990400.0, 10, 23);

        // MacBook Air 13 inch M1 2020 8CPU 7GPU 16GB/256GB
        seedDataProduct("MacBook Air 13 inch M1 2020 8CPU 7GPU 16GB/256GB", "Laptop", 1.29, 6, 2, 2, "2022_6_7_637901915720184032_macbook-air-m2-2022-den-dd.jpg");
        seedDataVariant("/src/assets/products/MacbookAir13inchm220228CPU10GPU8GB512GBden.png", "MacBookAir 13inch M1 2020 8CPU 7GPU \n 16GB 256GB Đen 256GB ",29990000.0, 10, 24);

        // Thông số
        // Laptop MacBook Air 13 inch M2 2022 8CPU 10GPU 8GB/512GB có 3 màu Đen, Trắng, Xám giá 31.990.000
        seedDataVariantAtribute("Đen", 3, 40);
        seedDataVariantAtribute("512GB", 24, 40);
        seedDataVariantAtribute("Apple", 60, 40);
        seedDataVariantAtribute("M2", 61, 40);
        seedDataVariantAtribute("8 - Core", 10, 40);
        seedDataVariantAtribute("2.3 Ghz", 62, 40);
        seedDataVariantAtribute("Apple", 63, 40);
        seedDataVariantAtribute("Apple M2 GPU 10 nhân", 64, 40);
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
        seedDataVariantAtribute("Full HD Webcam (1060p Webcam)", 74, 40);
        seedDataVariantAtribute("MacOS", 49, 40);
        seedDataVariantAtribute("Ventura", 50, 40);
        seedDataVariantAtribute("Mở khóa vân tay", 37, 40);
        seedDataVariantAtribute("English International Backlit Keyboard", 52, 40);
        seedDataVariantAtribute("Không", 53, 40);
        seedDataVariantAtribute("LED", 54, 40);


        // Laptop MacBook Air 13 inch M2 2022 8CPU 10GPU 8GB/256GB có 3 màu Đen, Trắng, Ghi giá 27.990.000
        seedDataVariantAtribute("Xám", 3, 41);
        seedDataVariantAtribute("256GB", 24, 41);
        seedDataVariantAtribute("Apple M2 GPU 8 nhân", 64, 41);
        seedDataVariantAtribute("30 W", 75, 41);
        seedDataVariantAtribute("Apple", 60, 41);
        seedDataVariantAtribute("M2", 61, 41);
        seedDataVariantAtribute("8 - Core", 10, 41);
        seedDataVariantAtribute("2.3 Ghz", 62, 41);
        seedDataVariantAtribute("Apple", 63, 41);
        seedDataVariantAtribute("Apple M2 GPU 10 nhân", 64, 41);
        seedDataVariantAtribute("8 GB", 13, 41);
        seedDataVariantAtribute("LPDDR4", 66, 41);
        seedDataVariantAtribute("3200 MHz", 67, 41);
        seedDataVariantAtribute("3200 MHz", 1, 41);
        seedDataVariantAtribute("8 GB", 69, 41);
        seedDataVariantAtribute("SSD", 70, 41);
        seedDataVariantAtribute("M2. PCIe", 71, 41);
        seedDataVariantAtribute("13.6 inch", 14, 41);
        seedDataVariantAtribute("Retina", 15, 41);
        seedDataVariantAtribute("2560 x 1644 Pixels", 17, 41);
        seedDataVariantAtribute("LED", 72, 41);
        seedDataVariantAtribute("60 Hz", 22, 41);
        seedDataVariantAtribute("IPS", 73, 41);
        seedDataVariantAtribute("500 nits", 74, 41);
        seedDataVariantAtribute("2 Type C,Audio Jack: Jack 3.5 mm,Cổng sạc: Magsafe Charger", 41, 41);
        seedDataVariantAtribute("802.11 ax", 42, 41);
        seedDataVariantAtribute("v5.0", 44, 41);
        seedDataVariantAtribute("Full HD Webcam (1060p Webcam)", 74, 41);
        seedDataVariantAtribute("MacOS", 49, 41);

        // Laptop MacBook Air 13 inch M1 2020 8CPU 7GPU 8GB/256GB có 3 màu Đen, Trắng, Ghi giá 22.990.000
        seedDataVariantAtribute("Trắng", 3, 42);
        seedDataVariantAtribute("256GB", 24, 42);
        seedDataVariantAtribute("M1", 61, 42);
        seedDataVariantAtribute("8", 11, 42);
        seedDataVariantAtribute("8", 76, 42);
        seedDataVariantAtribute("Share", 77, 42);
        seedDataVariantAtribute("Apple M1 GPU 7 nhân", 64, 42);
        seedDataVariantAtribute("Apple", 60, 42);
        seedDataVariantAtribute("8 - Core", 10, 42);
        seedDataVariantAtribute("2.3 Ghz", 62, 42);
        seedDataVariantAtribute("Apple", 63, 42);
        seedDataVariantAtribute("GPU 10 nhân", 64, 42);
        seedDataVariantAtribute(" Apple M2 GPU 10 nhân", 64, 42);
        seedDataVariantAtribute("8 GB", 13, 42);
        seedDataVariantAtribute("LPDDR4", 66, 42);
        seedDataVariantAtribute("3200 MHz", 67, 42);
        seedDataVariantAtribute("3200 MHz", 1, 42);
        seedDataVariantAtribute("8 GB", 69, 42);
        seedDataVariantAtribute("SSD", 70, 42);
        seedDataVariantAtribute("M2. PCIe", 71, 42);
        seedDataVariantAtribute("13.6 inch", 14, 42);
        seedDataVariantAtribute("Retina", 15, 42);
        seedDataVariantAtribute("2560 x 1644 Pixels", 17, 42);
        seedDataVariantAtribute("LED", 72, 42);
        seedDataVariantAtribute("60 Hz", 22, 42);
        seedDataVariantAtribute("IPS", 73, 42);
        seedDataVariantAtribute("500 nits", 74, 42);
        seedDataVariantAtribute("2 Type C,Audio Jack: Jack 3.5 mm,Cổng sạc: Magsafe Charger", 41, 42);
        seedDataVariantAtribute("802.11 ax", 42, 42);
        seedDataVariantAtribute("v5.0", 44, 42);
        seedDataVariantAtribute("Full HD Webcam (1060p Webcam)", 74, 42);
        seedDataVariantAtribute("MacOS", 49, 42);
        seedDataVariantAtribute("Ventura", 50, 42);
        seedDataVariantAtribute("Mở khóa vân tay", 37, 42);
        seedDataVariantAtribute("English International Backlit Keyboard", 52, 42);
        seedDataVariantAtribute("Không", 53, 42);
        seedDataVariantAtribute("LED", 54, 42);
        seedDataVariantAtribute("Trắng", 55, 42);
        seedDataVariantAtribute("Multi-touch touchpad", 56, 42);
        seedDataVariantAtribute("Lithium polymer", 46, 42);
        seedDataVariantAtribute("18 Giờ", 47, 42);
        seedDataVariantAtribute("35 W", 75, 42);
        seedDataVariantAtribute("Adapter,Dây cáp sạc", 51, 42);
        seedDataVariantAtribute("4", 57, 42);
        seedDataVariantAtribute("30.41 x 21.5 x 1.13 cm", 5, 42);
        seedDataVariantAtribute("1.24 kg", 6, 42);
        seedDataVariantAtribute("Kim loại", 7, 42);
        seedDataVariantAtribute("Trung quốc", 1, 42);
        seedDataVariantAtribute("2022", 2, 42);
        seedDataVariantAtribute("12", 4, 42);

        seedDataVariantAtribute("Đen", 3, 43);
        seedDataVariantAtribute("256GB", 24, 43);
        seedDataVariantAtribute("M1", 61, 43);
        seedDataVariantAtribute("8", 11, 43);
        seedDataVariantAtribute("8", 76, 43);
        seedDataVariantAtribute("Share", 77, 43);
        seedDataVariantAtribute("Apple M1 GPU 7 nhân", 64, 43);
        seedDataVariantAtribute("Apple", 60, 43);
        seedDataVariantAtribute("8 - Core", 10, 43);
        seedDataVariantAtribute("2.3 Ghz", 62, 43);
        seedDataVariantAtribute("Apple", 63, 43);
        seedDataVariantAtribute("GPU 10 nhân", 64, 43);
        seedDataVariantAtribute(" Apple M2 GPU 10 nhân", 64, 43);
        seedDataVariantAtribute("8 GB", 13, 43);
        seedDataVariantAtribute("LPDDR4", 66, 43);
        seedDataVariantAtribute("3200 MHz", 67, 43);
        seedDataVariantAtribute("3200 MHz", 1, 43);
        seedDataVariantAtribute("16 GB", 69, 43);
        seedDataVariantAtribute("SSD", 70, 43);
        seedDataVariantAtribute("M2. PCIe", 71, 43);
        seedDataVariantAtribute("13.6 inch", 14, 43);
        seedDataVariantAtribute("Retina", 15, 43);
        seedDataVariantAtribute("2560 x 1644 Pixels", 17, 43);
        seedDataVariantAtribute("LED", 72, 43);
        seedDataVariantAtribute("60 Hz", 22, 43);
        seedDataVariantAtribute("IPS", 73, 43);
        seedDataVariantAtribute("500 nits", 74, 43);
        seedDataVariantAtribute("2 Type C,Audio Jack: Jack 3.5 mm,Cổng sạc: Magsafe Charger", 41, 43);
        seedDataVariantAtribute("802.11 ax", 43, 43);
        seedDataVariantAtribute("v5.0", 44, 43);
        seedDataVariantAtribute("Full HD Webcam (1060p Webcam)", 74, 43);
        seedDataVariantAtribute("MacOS", 49, 43);
        seedDataVariantAtribute("Ventura", 50, 43);
        seedDataVariantAtribute("Mở khóa vân tay", 37, 43);
        seedDataVariantAtribute("English International Backlit Keyboard", 52, 43);


        // Macbook pro
        // MacBook pro  14 inch
        seedDataProduct("MacBook Pro 14 2023 M3 Pro 11 CPU/14GPU/18GB/512GB", "Laptop", 1.61, 6, 2, 1, "MacBookPro142023.png");

        // Phiên bản MacBook Pro 14 2023 M3 Pro 11 CPU/14GPU/18GB/512GB
        seedDataVariant("/src/assets/products/MacBookPro142023.png", "MacBook Pro 14 2023 ", 48990020.0, 10, 25);
        seedDataVariantAtribute("Đen", 3, 44);
        seedDataVariantAtribute("512GB", 24, 44);


        // Phiên bản MacBook Pro 14 2023 M3 Pro 11 CPU/14GPU/36GB/512GB giá 59990000.0
        seedDataProduct("MacBook Pro 14 2023 M3 Pro 11 CPU/14GPU/36GB/512GB", "Laptop", 1.61, 6, 2, 1, "MacBookPro142023.png");
        seedDataVariant("/src/assets/products/MacBookPro142023.png", "MacBook Pro 14 2023 ", 59992000.0, 10, 26);

        // Phiên bản MacBook Pro 14 2023 M3 Pro 11 CPU/14GPU/36GB/512GB 2 màu bạc   đen,  giá 59990000.0
        seedDataVariantAtribute("Đen", 3, 45);
        seedDataVariantAtribute("512GB", 24, 45);

        // Phiên bản MacBook Pro 16 2023 M3 Pro 11 CPU/14GPU/18GB/512GB

        seedDataProduct("MacBook Pro 16 2023 M3 Pro 11 CPU/14GPU/18GB/512GB", "Laptop", 1.61, 6, 2, 1, "MacBookPro142023.png");
        seedDataVariant("/src/assets/products/MacBookPro142023.png", "MacBook Pro 16 2023 ", 64490500.0, 10, 27);
        // Phiên bản MacBook Pro 16 2023 M3 Pro 11 CPU/14GPU/18GB/512GB 2 màu bạc   đen,  giá 64490000.0
        seedDataVariantAtribute("Đen", 3, 46); // màu
        seedDataVariantAtribute("512GB", 24, 46); // bộ nhớ ( rom)

        // Phiên bản MacBook Pro 16 2023 M3 Pro 11 CPU/14GPU/36GB/512GB
        seedDataProduct("MacBook Pro 16 2023 M3 Pro 11 CPU/14GPU/36GB/512GB", "Laptop", 1.61, 6, 2, 1, "MacBookPro162023den.png");
        seedDataVariant("/src/assets/products/MacBookPro162023den.png", "MacBook Pro 16 2023 ", 74490000.0, 10, 28);
        seedDataVariantAtribute("Đen", 3, 47); // màu
        seedDataVariantAtribute("512GB", 24, 47); // bộ nhớ ( rom)

        // MacBook Pro 13" 2020 Touch Bar M1 8CPU 8GPU 8GB/256Gb
        seedDataProduct("MacBook Pro 13 2020 Touch Bar M1 8CPU 8GPU 8GB/256Gb", "Laptop", 1.61, 6, 2, 1, "MacBookPro162023bac.png");
        seedDataVariant("/src/assets/products/MacBookPro162023bac.png", "MacBook Pro 11 2023 ", 20490000.0, 10, 29);
        seedDataVariantAtribute("Bạc", 3, 48); // màu bạc
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
        seedDataVariantAtribute("1060p FaceTime HD camera", 74, 44); // Webcam
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
        seedDataVariantAtribute("1060p FaceTime HD camera", 74, 45); // Webcam
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
        seedDataVariantAtribute("1060p FaceTime HD camera", 74, 47); // Webcam
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


//        // Laptop dell
        seedDataProduct("Laptop Dell Inspiron 14 N5440 i5 1174U/16GB/512GB", "Laptop", 1.54, 7, 2, 4, "LaptopDellInspiron14.png");
//
//        // Phiên bản Laptop Dell Inspiron 14 N5440 i5 1174U/16GB/512GB/14"FHD+/Win11/Office HS21
        seedDataVariant("/src/assets/products/LaptopDellInspiron14.png", "Laptop Dell Inspiron 14 ", 20190000.0, 10, 30);

//
//
//        // Phiên bản Laptop Dell Inspiron 14 N5440 i5 1174U/16GB/512GB/14"FHD+/Win11/Office HS21
        seedDataVariantAtribute("Xanh", 3, 49); // màu
        seedDataVariantAtribute("512GB", 24, 49); // bộ nhớ ( rom)
        seedDataVariantAtribute("Dell", 60, 49);  // Hãng
        seedDataVariantAtribute("Intel Core i5", 61, 49); // CPU
        seedDataVariantAtribute("1174U", 10, 49); // Loại CPU
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



//        // Laptop Dell Inspiron 15 N3530 i5 1175U/16GB/512GB/15.6"FHD/NVIDIA MX550 2GB/Win11/Office HS21
//
//        // thông số kĩ thuật
        seedDataProduct("Laptop Dell Inspiron 15 N3530 i5 1175U/16GB/512GB", "Laptop", 1.54, 7, 2, 4, "LaptopDellInspiron15.jpg");
        seedDataVariant("/src/assets/products/LaptopDellInspiron15.jpg", "Laptop Dell Inspiron15 ", 21490000.0, 10, 31);

        seedDataVariantAtribute("Bạc", 3, 50); // màu
        seedDataVariantAtribute("512GB", 24, 50); // bộ nhớ ( rom)
        seedDataVariantAtribute("Dell", 60, 50);  // Hãng
        seedDataVariantAtribute("Intel Core i5", 61, 50); // CPU
        seedDataVariantAtribute("1175U", 9, 50); // Phiên bản CPU
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
        seedDataVariantAtribute("FHD 1920 x 1060 Pixels", 17, 50); // Độ phân giải
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


//        // Thông số kỹ thuật

        seedDataProduct("Laptop Dell Inspiron 15N 3530 i7 1175U/16GB/512GB", "Laptop", 1.54, 7, 2, 4, "LaptopDellInspiron15den.png");
        seedDataVariant("/src/assets/products/LaptopDellInspiron15den.png", "Laptop Dell Inspiron15 ", 20290000.0, 10, 32);

//        // Laptop Dell Inspiron 15 N3530 i7 1355U/16GB/512GB/15.6"FHD/Win11/Office 365 Personal
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
        seedDataVariantAtribute("1920 x 1060 Pixels", 17, 51); // Độ phân giải
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
//
//        // Laptop Dell Vostro
        seedDataProduct("Laptop Dell Vostro V3430 i5 1175U/16GB/512GB", "Laptop", 1.49, 7, 2, 4, "LaptopDellVostroV3430.png");
//
//        // Laptop Dell Vostro V3430 i5 1175U/16GB/512GB/14"FHD/Nvidia GeForce MX550 2GB/Win11/Office HS21
        seedDataVariant("/src/assets/products/LaptopDellVostroV3430.png", "Laptop Dell VostroV3430 Xám 512GB", 19799000.0, 10, 33);

        seedDataVariantAtribute("Xám", 3, 52); // màu
        seedDataVariantAtribute("512 GB", 24, 52); // Dung lượng ổ cứng
//        // Thông số kỹ thuật
        seedDataVariantAtribute("Dell", 60, 52);  // Hãng
        seedDataVariantAtribute("Intel Core i5", 61, 52); // CPU
        seedDataVariantAtribute("1175U", 9, 52); // Phiên bản CPU
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
        seedDataVariantAtribute("1920 x 1060 Pixels", 17, 52); // Độ phân giải
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

//
//        // Thông số kỹ thuật
//        // Laptop Dell Vostro V3520 i5 1235U/16GB/512GB/15.6"FHD/Win11/Office HS21
        seedDataProduct("Laptop Dell Vostro V3520 i5 1235U/16GB/512GB", "Laptop", 1.49, 7, 2, 4, "LaptopDellVostroV3430.png");
//
        seedDataVariant("/src/assets/products/LaptopDellVostroV3430.png", "Laptop Dell Vostro V3430 Xám 512GB", 16399000.0, 10, 34);

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
        seedDataVariantAtribute("FHD (1920 x 1060)", 17, 53); // Độ phân giải
        seedDataVariantAtribute("120 Hz", 22, 53); // Tần số quét
        seedDataVariantAtribute("WVA", 73, 53); // Tấm nền
        seedDataVariantAtribute("250 nits", 21, 53); // Độ sáng
        seedDataVariantAtribute("1 USB 2.0, 1 HDMI, 1 RJ45 Gigabit Ethernet, 1 Jack 3.5 mm, 2 USB 3.2", 41, 53); // Cổng giao tiếp
        seedDataVariantAtribute("Wife 802.11 ax", 42, 53); // Wifi
        seedDataVariantAtribute("Bluetooth v5.0", 44, 53); // Bluetooth
        seedDataVariantAtribute("HD Webcam (720p Webcam)", 74, 53); // Webcam
        seedDataVariantAtribute("Windows", 49, 53); // OS
        seedDataVariantAtribute("Windows 11 Home Single Language", 50, 53); // Phiên bản OS

//
        seedDataProduct("Laptop Dell Latitude L3540 i5 1175U", "Laptop", 1.49, 7, 2, 4, "dell_inspiron_n3520_i5_1235u_71045026_5_f86c7b12fe.jpg");
//
//        // Tạo biến seedDataVariant cho Laptop Dell Latitude L3540 i5 1175U
        seedDataVariant("/src/assets/products/dell_inspiron_n3520_i5_1235u_71045026_5_f86c7b12fe (1).jpg", "Laptop Dell LatitudeL 3540 Xám 512GB", 18790000.0, 10, 35);

        seedDataVariantAtribute("Xám", 3, 54); // màu
        seedDataVariantAtribute("512 GB", 24, 54); // Dung lượng
//
//        // Tạo biến seedDataVariant cho Laptop Dell Latitude L3540 i5 1235U
        seedDataProduct("Laptop Dell Latitude L3540 i5 1235U", "Laptop", 1.49, 7, 2, 4, "dell_inspiron_n3520_i5_1235u_71045026_5_f86c7b12fe.jpg");
        seedDataVariant("/src/assets/products/dell_inspiron_n3520_i5_1235u_71045026_5_f86c7b12fe (1).jpg", "LaptopDellLatitudeL3540 Xám 512GB", 18790700.0, 10, 36);

        seedDataVariantAtribute("Xám", 3, 55); // Màu sắc
        seedDataVariantAtribute("512 GB", 24, 55); // Dung lượng
//
//        // Tạo biến seedDataVariant cho Laptop Dell Latitude 3440 i5 1235U
        seedDataProduct("Laptop Dell Latitude 3440 i5 1235U", "Laptop", 1.49, 7, 2, 4, "dell_inspiron_n3520_i5_1235u_71045026_5_f86c7b12fe.jpg");
        seedDataVariant("/src/assets/products/dell_inspiron_n3520_i5_1235u_71045026_5_f86c7b12fe (1).jpg", "LaptopDellLatitude3440 Đen 512GB", 17990000.0, 10, 37);

        seedDataVariantAtribute("Đen", 3, 56); // Màu sắc
        seedDataVariantAtribute("512 GB", 24, 56); // Dung lượng
//
//
//        // Tạo biến seedDataVariant cho Laptop Dell Latitude L3540 i5 1175U
//        // Thông số kỹ thuật
        seedDataVariantAtribute("Dell", 60, 54);  // Hãng
        seedDataVariantAtribute("Intel", 61, 54); // Hãng CPU
        seedDataVariantAtribute("Core i5", 61, 54); // Công nghệ CPU
        seedDataVariantAtribute("1175U", 9, 54); // Loại CPU
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
        seedDataVariantAtribute("1920 x 1060 Pixels", 17, 54); // Độ phân giải
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
//
//        // Tạo biến seedDataVariant cho Laptop Dell Latitude L3540 i5 1235U
//        // Thông số kỹ thuật
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
        seedDataVariantAtribute("1920 x 1060 Pixels", 17, 55); // Độ phân giải
        seedDataVariantAtribute("60 Hz", 22, 55); // Tần số quét
        seedDataVariantAtribute("WVA", 73, 55); // Tấm nền
        seedDataVariantAtribute("1 USB 3.2 Gen 2 Type-C, 3 USB 3.2 Gen 1, 1 HDMI 1.4, 1 RJ45 Gigabit Ethernet, 1 MicroSD card reader", 41, 55); // Cổng giao tiếp
        seedDataVariantAtribute("Wi-Fi 6E AX211, 802.11ax 2x2", 42, 55); // Wifi
        seedDataVariantAtribute("Bluetooth v5.1", 44, 55); // Bluetooth
        seedDataVariantAtribute("Full HD Webcam (1060p Webcam)", 74, 55); // Webcam
        seedDataVariantAtribute("Windows", 49, 55); // OS
        seedDataVariantAtribute("Windows 11 Home", 50, 55); // Phiên bản OS
        seedDataVariantAtribute("Mật khẩu", 37, 55); // Bảo mật

//
//        // Tạo biến seedDataVariant cho Laptop Dell Latitude 3440 i5 1235U
//        // Thông số kỹ thuật
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
        seedDataVariantAtribute("FHD (1920 x 1060)", 17, 56); // Độ phân giải
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

        seedDataProduct("Laptop Dell XPS 14 9440 U7 155H 64GB", "Laptop", 1.8, 7, 2, 4, "LaptopDellXPS.jpg");
//
//        // Tạo biến seedDataVariant cho Laptop Dell XPS 14 9440 U7 155H
        seedDataVariant("/src/assets/products/LaptopDellXPS.jpg", "LaptopDellXPS Đen 1TB", 79990000.0, 10, 38);

        seedDataVariantAtribute("Đen", 3, 57); // Màu sắc
        seedDataVariantAtribute("1 TB", 24, 57); // Dung lượng
//        // Thông số kỹ thuật
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
        seedDataVariantAtribute("Full HD Webcam (1060p Webcam)", 74, 57); // Webcam
        seedDataVariantAtribute("Windows", 49, 57); // OS
        seedDataVariantAtribute("Windows 11 Home", 50, 57); // Phiên bản OS


        //  Laptop Asus
        seedDataProduct("Laptop Asus Vivobook 15 OLED A1505VA-MA466W i5-13500H/16GB/512GB", "Laptop", 1.8, 10, 2, 2, "LaptopAsusVivobook.png");

        //  Laptop Asus Vivobook 15 OLED A1505VA-MA466W i5-13500H/16GB/512GB/15.6'' 2.8K/Win11
        seedDataVariant("/src/assets/products/LaptopAsusVivobook.png", "Laptop Asus Vivobook ", 18590000.0, 10, 39);


//        // Thông số kĩ thuật
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
//
//        // Laptop Asus TUF Gaming FA507NUR LP101W R7 7435HS/16GB/512GB/15.6"/GeForce RTX4050 6GB/Win11
        seedDataProduct("Laptop Asus TUF Gaming FA507NUR-LP101W R7-7435HS/16GB/512GB", "Laptop", 1.8, 10, 2, 2, "LaptopAsusTUF.jpg");
        seedDataVariant("/src/assets/products/LaptopAsusTUF.jpg", "Laptop Asus TUF ", 25590000.0, 10, 40);

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
        seedDataVariantAtribute("1920 x 1060 Pixels", 17, 59); // Độ phân giải
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
//
//        //Laptop Asus Gaming Vivobook K3605ZC-RP564W i5-12500H/16GB/512GB/16"/Nvidia GeForce RTX3050 4GB/Win11
        seedDataProduct("Laptop Asus Gaming Vivobook K3605ZC-RP564W i5-12500H/16GB/512GB", "Laptop", 1.8, 10, 2, 2, "LaptopAsusVivobook.png");
        seedDataVariant("/src/assets/products/LaptopAsusVivobook.png", "Laptop Asus Vivobook", 19190000.0, 10, 41);

//        // Thông số kỹ thuật
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


        // Laptop ASUS Vivobook 15 OLED A1505VA-MA469W i9-13900H/16GB/512GB/15.6" 2.8K/Win11
        seedDataProduct("Laptop ASUS Vivobook 15 OLED A1505VA-MA469W i9-13900H/16GB/512GB", "Laptop", 1.8, 10, 2, 2, "LaptopAsusVivobookbac.png");
        seedDataVariant("/src/assets/products/LaptopAsusVivobookbac.png", "Laptop ASUS Vivobook ", 23190000.0, 10, 42);

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
        seedDataProduct("Laptop Asus Vivobook S14 S5406MA-PP161W Ultra 5 125H/AI/16GB/1TB", "Laptop", 1.8, 10, 2, 2, "LaptopAsusVivobookden.jpg");
        seedDataVariant("/src/assets/products/LaptopAsusVivobookden.jpg", "Laptop Asus Vivobook ", 24290000.0, 10, 43);

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


        // Laptop Asus Zenbook 14 OLED UX3405MA-PP152W Intel Core Ultra 7-155H/AI/32GB/1TB/14'' 3K/Intel Arc/Win11
        seedDataProduct("Laptop Asus Zenbook 14 OLED UX3405MA-PP152W Intel Core Ultra 7-155H/AI/32GB/1TB", "Laptop", 1.8, 10, 2, 2, "LaptopAsusZenbookxanh.jpg");
        seedDataVariant("/src/assets/products/LaptopAsusZenbookxanh.jpg", "Laptop Asus Zenbook ", 30990200.0, 10, 44);

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
        seedDataVariantAtribute("Full HD Webcam (1060p Webcam)", 74, 63); // Webcam
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
        seedDataProduct("Laptop Asus Vivobook S16 OLED S5606MA-MX051W Intel Core Ultra 7-155H/AI/16GB/512GB", "Laptop", 1.8, 10, 2, 2, "LaptopAsusVivobook.png");
        seedDataVariant("/src/assets/products/LaptopAsusVivobook.png", "Laptop Asus Vivobook ", 25890000.0, 10, 45);

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


        // Laptop Asus Zenbook 14 OLED UX3405MA-PP151W Ultra 5 125H/AI/16GB/512GB/14" 3K/Intel Arc Graphics/Win11
        seedDataProduct("Laptop Asus Zenbook 14 OLED UX3405MA-PP151W Ultra 5 125H/AI/16GB/512GB", "Laptop", 1.8, 10, 2, 2, "LaptopAsusVivobookbac.png");
        seedDataVariant("/src/assets/products/LaptopAsusVivobookbac.png", "Laptop Asus Zenbook ", 26990000.0, 10, 46);

        seedDataVariantAtribute("Bạc", 3, 65); // Màu sắc
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
        seedDataVariantAtribute("Full HD Webcam (1060p Webcam)", 74, 65); // Webcam
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
        seedDataProduct("Laptop Asus Gaming Vivobook K3605ZU-RP296W i5-12500H/16GB/512GB", "Laptop", 1.8, 10, 2, 2, "LaptopAsusVivobookden.jpg");
        seedDataVariant("/src/assets/products/LaptopAsusVivobookden.jpg", "Laptop Asus Vivobook", 23990000.0, 10, 47);


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



        // Laptop Asus Gaming ROG Strix G16 G614JV-N4156W i7-11950HX/AI/16GB/512GB/16' 2.5K/Nvidia GeForce RTX4060 8GB/Win11
        seedDataProduct("Laptop Asus Gaming ROG Strix G16 G614JV-N4156W i7-13650HX/AI/16GB/512GB", "Laptop", 1.8, 10, 2, 2, "LaptopAsusROGStrix.jpg");
        seedDataVariant("/src/assets/products/LaptopAsusROGStrix.jpg", "Laptop Asus ROGStrix ", 37990000.0, 10, 48);

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

        //Laptop Acer
        seedDataProduct("Laptop Acer Nitro 5 Tiger Gaming AN515-58-773Y i7 12700H/16GB/512GB", "Laptop", 1.8, 11, 2, 2, "LaptopAcerNitro5Tiger.png");
        //Laptop Acer Nitro 5 Tiger Gaming AN515-58-773Y i7 12700H/16GB/512GB/15.6 FHD/NVIDIA GeForce RTX3050Ti 4GB/Win11
//
        seedDataVariant("/src/assets/products/LaptopAcerNitro5Tiger.png", "LaptopAcerNitro Đen 512GB", 22999000.0, 10, 49);

//        // Thông số kỹ thuật
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
        seedDataVariantAtribute("1920 x 1060 Pixels", 17, 68); // Độ phân giải
        seedDataVariantAtribute("144 Hz", 22, 68); // Tần số quét
        seedDataVariantAtribute("IPS", 73, 68); // Tấm nền
        seedDataVariantAtribute("250 nits", 21, 68); // Độ sáng
        seedDataVariantAtribute("45% NTSC", 78, 68); // Độ phủ màu
        seedDataVariantAtribute("16:09", 80, 68); // Tỷ lệ màn hình
        seedDataVariantAtribute("1 USB Type-C, 2 USB 3.2 Gen 2, 1 USB 3.2 Gen 1, 1 RJ45 Gigabit Ethernet, 1 HDMI 2.1, 1 Jack 3.5 mm, 1 DC-in jack", 41, 68); // Cổng giao tiếp
        seedDataVariantAtribute("Wifi 6", 42, 68); // Wi-Fi


        // Laptop Acer Aspire 7 Gaming A715-76G-73FM i7 12650H/16GB/512GB/15.6"FHD/RTX2050 4GB/Win11
        seedDataProduct("Laptop Acer Aspire 7 Gaming A715-76G-73FM i7 12650H/16GB/512GB", "Laptop", 1.8, 11, 2, 2, "LaptopAcerAspire7.png");
        seedDataVariant("/src/assets/products/LaptopAcerAspire7.png", "LaptopAcerAspire Đen 512GB", 1798900.0, 10, 50);

//        // Thông số kỹ thuật
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
        seedDataVariantAtribute("1920 x 1060 Pixels", 17, 69); // Độ phân giải
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
//
//        // Laptop Acer Swift 3 SF314-512-741L i7 1260P/16GB/1T/14" QHD/Win11
        seedDataProduct("Laptop Acer Swift 3 SF314-512-741L i7 1260P/16GB/1T", "Laptop", 1.8, 11, 2, 2, "LaptopAcerSwift3.jpg");
        seedDataVariant("/src/assets/products/LaptopAcerSwift3.jpg", "LaptopAcerSwift Vàng 1TB", 1898900.0, 10, 51);

//        // Thông số kỹ thuật
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
        seedDataVariantAtribute("Full HD Webcam (1060p Webcam)", 74, 70); // Webcam
        seedDataVariantAtribute("Windows", 49, 70); // OS


        // Laptop Acer Nitro 16 Phoenix Gaming AN16-41-R50Z R5 7640HS/16GB/512GB/16"WUXGA//Nvidia Geforce RTX4050 6GB/Win11
        seedDataProduct("Laptop Acer Nitro 16 Phoenix Gaming AN16-41-R50Z R5 7640HS/16GB/512GB", "Laptop", 1.8, 11, 2, 2, "LaptopAcerNitro16.png");
        seedDataVariant("/src/assets/products/LaptopAcerNitro16.png", "LaptopAcerNitro Đen 512GB", 22798900.0, 10, 52);

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

        // Laptop Acer Gaming Predator Helios Neo 14 PHN14-51-99Y8 Intel Core Ultra 9 185H/AI/32GB/1TB/14.5" WQXGA+/Nvidia RTX4060 8GB/Win11
        seedDataProduct("Laptop Acer Gaming Predator Helios Neo", "Laptop", 1.8, 11, 2, 2, "LaptopAcerGamingPredator.png");
        seedDataVariant("/src/assets/products/LaptopAcerGamingPredator.png", "LaptopAcerPredator Đen 1TB", 46798900.0, 8, 53);

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

        //Laptop HP
        seedDataProduct("Laptop HP Gaming Victus 16-s0173AX R5-7640HS/16GB/512GB", "Laptop", 1.8, 8, 2, 2, "LaptopHPGamingVictus.png");
        //Laptop HP Gaming Victus 16-s0173AX R5-7640HS/16GB/512GB/16" 144Hz/GeForce RTX3050 6GB/Win11_A9LG9PA

        seedDataVariant("/src/assets/products/LaptopHPGamingVictus.png", "Laptop HP Gaming Victus 16-s0173AX R5-7640HS/16GB/512GB", 20998900.0, 5, 54);

        // Thông số kỹ thuật
        seedDataVariantAtribute("Đen", 3, 73); // Màu sắc
        seedDataVariantAtribute("512 GB", 24, 73); // Dung lượng ổ cứng
        seedDataVariantAtribute("AMD", 60, 73);  // Hãng CPU
        seedDataVariantAtribute("Ryzen 5", 61, 73); // Công nghệ CPU
        seedDataVariantAtribute("7640HS", 10, 73); // Loại CPU
        seedDataVariantAtribute("4.3 GHz", 11, 73); // Tốc độ CPU tối thiểu
        seedDataVariantAtribute("AMD Radeon Graphics", 65, 73); // Tên đầy đủ (Card onboard)
        seedDataVariantAtribute("NVIDIA GeForce RTX 3050 6GB", 65, 73); // Tên đầy đủ (Card rời)
        seedDataVariantAtribute("16 GB", 13, 73); // Dung lượng RAM
        seedDataVariantAtribute("DDR5", 66, 73); // Loại RAM
        seedDataVariantAtribute("4800 MHz", 67, 73); // Tốc độ RAM
        seedDataVariantAtribute("2", 76, 73); // Số khe cắm rời
        seedDataVariantAtribute("64 GB", 79, 73); // Hỗ trợ RAM tối đa
        seedDataVariantAtribute("SSD", 70, 73); // Kiểu ổ cứng
        seedDataVariantAtribute("Nâng cấp tối đa 2TB (SSD M2 PCIe)", 77, 73); // Dung lượng nâng cấp tối đa ổ cứng
        seedDataVariantAtribute("1 M.2 NVMe", 71, 73); // Loại SSD
        seedDataVariantAtribute("16.1 inch", 14, 73); // Kích thước màn hình
        seedDataVariantAtribute("Anti-Glare", 15, 73); // Công nghệ màn hình
        seedDataVariantAtribute("1920 x 1060 Pixels", 17, 73); // Độ phân giải
        seedDataVariantAtribute("LED", 72, 73); // Loại màn hình
        seedDataVariantAtribute("144 Hz", 22, 73); // Tần số quét
        seedDataVariantAtribute("IPS", 73, 73); // Tấm nền
        seedDataVariantAtribute("45% NTSC", 78, 73); // Độ phủ màu
        seedDataVariantAtribute("16:09", 80, 73); // Tỷ lệ màn hình
        seedDataVariantAtribute("Cổng sạc:, 3 USB Type-A, 1 USB Type-C, 1 HDMI 2.1, 1 RJ45 Gigabit Ethernet, 1 AC, 1 headphone/microphone combo", 41, 73); // Cổng giao tiếp
        seedDataVariantAtribute("802.11 a/b/g/n/ac/ax", 42, 73); // Wi-Fi
        seedDataVariantAtribute("Bluetooth v5.3", 44, 73); // Bluetooth
        seedDataVariantAtribute("Full HD Webcam (1060p Webcam)", 74, 73); // Webcam
        seedDataVariantAtribute("Windows", 49, 73); // OS
        seedDataVariantAtribute("Windows 11 Home Single Language", 50, 73); // Phiên bản OS
        seedDataVariantAtribute("Mật khẩu", 37, 73); // Bảo mật
        seedDataVariantAtribute("6-row, multimedia Fn keys, numeric keypad", 52, 73); // Kiểu bàn phím
        seedDataVariantAtribute("Có", 53, 73); // Bàn phím số
        seedDataVariantAtribute("LED", 54, 73); // Đèn bàn phím
        seedDataVariantAtribute("RGB 1 Zone", 55, 73); // Công nghệ đèn bàn phím
        seedDataVariantAtribute("RGB", 81, 73); // Màu đèn LED


        // Laptop HP Gaming Victus 16-r0127TX i7-13700H/AI/16GB/512GB/16.1" 144Hz/GeForce RTX4060 8GB/Win11_8C5N2PA
        seedDataProduct("Laptop HP Gaming Victus 16-r0127TX i7-13700H/AI/16GB/512GB", "Laptop", 1.8, 8, 2, 2, "LaptopHPGamingVictus16.png");
        seedDataVariant("/src/assets/products/LaptopHPGamingVictus16.png", "Laptop HP Gaming Victus 16-r0127TX i7-13700H/AI/16GB/512GB", 32998900.0, 5, 55);

        // Thông số kỹ thuật
        seedDataVariantAtribute("Đen", 3, 74); // Màu sắc
        seedDataVariantAtribute("512 GB", 24, 74); // Dung lượng ổ cứng
        seedDataVariantAtribute("Intel", 60, 74);  // Hãng CPU
        seedDataVariantAtribute("Core i7", 61, 74); // Công nghệ CPU
        seedDataVariantAtribute("13700H", 9, 74); // Loại CPU
        seedDataVariantAtribute("5 GHz", 11, 74); // Tốc độ CPU tối thiểu
        seedDataVariantAtribute("Intel Iris Xe Graphics", 65, 74); // Tên đầy đủ (Card onboard)
        seedDataVariantAtribute("NVIDIA GeForce RTX 4060 8GB", 65, 74); // Tên đầy đủ (Card rời)
        seedDataVariantAtribute("16 GB", 13, 74); // Dung lượng RAM
        seedDataVariantAtribute("DDR5", 66, 74); // Loại RAM
        seedDataVariantAtribute("2", 76, 74); // Số khe cắm rời
        seedDataVariantAtribute("64 GB", 79, 74); // Hỗ trợ RAM tối đa
        seedDataVariantAtribute("SSD", 70, 74); // Kiểu ổ cứng
        seedDataVariantAtribute("Nâng cấp tối đa 2TB (SSD M2 PCIe)", 77, 74); // Dung lượng nâng cấp tối đa ổ cứng
        seedDataVariantAtribute("1 M.2 NVMe", 71, 74); // Loại SSD
        seedDataVariantAtribute("16.1 inch", 14, 74); // Kích thước màn hình
        seedDataVariantAtribute("LED anti-glare", 15, 74); // Công nghệ màn hình
        seedDataVariantAtribute("1920 x 1060 Pixels", 17, 74); // Độ phân giải
        seedDataVariantAtribute("144 Hz", 22, 74); // Tần số quét
        seedDataVariantAtribute("IPS", 73, 74); // Tấm nền
        seedDataVariantAtribute("45% NTSC", 78, 74); // Độ phủ màu
        seedDataVariantAtribute("16:09", 80, 74); // Tỷ lệ màn hình
        seedDataVariantAtribute("Cổng sạc:, 1 USB Type-C, 3 USB Type-A, 1 AC, 1 HDMI 2.1, 1 Jack 3.5 mm, 1 RJ45 Gigabit Ethernet", 41, 74); // Cổng giao tiếp
        seedDataVariantAtribute("802.11 ax", 42, 74); // Wi-Fi
        seedDataVariantAtribute("Bluetooth v5.3", 44, 74); // Bluetooth
        seedDataVariantAtribute("Full HD Webcam (1060p Webcam)", 74, 74); // Webcam
        seedDataVariantAtribute("Windows", 49, 74); // OS


        // Laptop HP Envy X360 14-fc0089TU Ultra 7-155U/AI/16GB/512GB/14'' 2.8K Touch/Pen/Win11
        seedDataProduct("Laptop HP Envy X360 14-fc0089TU Ultra 7-155U/AI/16GB/512GB", "Laptop", 1.8, 8, 2, 2, "LaptopHPEnvyX360.png");
        seedDataVariant("/src/assets/products/LaptopHPEnvyX360.png", "LaptopHPEnvy Xanh 512GB", 30998900.0, 7, 56);

        seedDataVariantAtribute("Xanh", 3, 75); // Màu sắc
        seedDataVariantAtribute("512 GB", 24, 75); // Dung lượng ổ cứng
        seedDataVariantAtribute("Intel", 9, 75); // Bộ xử lý - Hãng CPU
        seedDataVariantAtribute("Core Ultra 7", 61, 75); // Bộ xử lý - Công nghệ CPU
        seedDataVariantAtribute("155U", 10, 75); // Bộ xử lý - Loại CPU
        seedDataVariantAtribute("1.7", 12, 75); // Bộ xử lý - Tốc độ CPU tối thiểu
        seedDataVariantAtribute("10", 85, 75); // Bộ xử lý - Hiệu suất xử lý AI của CPU
        seedDataVariantAtribute("Intel", 63, 75); // Đồ họa - Hãng (Card Oboard)
        seedDataVariantAtribute("UHD", 64, 75); // Đồ họa - Model (Card Oboard)
        seedDataVariantAtribute("Intel UHD Graphics", 65, 75); // Đồ họa - Tên đầy đủ (Card onboard)
        seedDataVariantAtribute("16 GB (2 thanh 8 GB)", 79, 75); // RAM - Dung lượng RAM
        seedDataVariantAtribute("LPDDR5", 66, 75); // RAM - Loại RAM
        seedDataVariantAtribute("2", 67, 75); // RAM - Số RAM onboard
        seedDataVariantAtribute("Không nâng cấp", 68, 75); // RAM - Hỗ trợ RAM tối đa
        seedDataVariantAtribute("SSD", 70, 75); // Lưu trữ - Kiểu ổ cứng
        seedDataVariantAtribute("1", 71, 75); // Lưu trữ - Tổng số khe cắm SSD/HDD
        seedDataVariantAtribute("0", 72, 75); // Lưu trữ - Số khe SSD/HDD còn lại
        seedDataVariantAtribute("Nâng cấp tối đa 2TB (SSD M2 PCIe)", 73, 75); // Lưu trữ - Dung lượng nâng cấp tối đa ổ cứng
        seedDataVariantAtribute("1 M.2 NVMe", 73, 75); // Lưu trữ - Loại SSD
        seedDataVariantAtribute("512", 23, 75); // Lưu trữ - Dung lượng
        seedDataVariantAtribute("14 inch", 14, 75); // Màn hình - Kích thước màn hình
        seedDataVariantAtribute("OLED", 15, 75); // Màn hình - Công nghệ màn hình
        seedDataVariantAtribute("2880 x 1800 Pixels", 17, 75); // Màn hình - Độ phân giải
        seedDataVariantAtribute("OLED", 19, 75); // Màn hình - Loại màn hình
        seedDataVariantAtribute("120", 22, 75); // Màn hình - Tần số quét
        seedDataVariantAtribute("OLED", 73, 75); // Màn hình - Tấm nền
        seedDataVariantAtribute("100% DCI-P3", 78, 75); // Màn hình - Độ phủ màu
        seedDataVariantAtribute("16:10", 81, 75); // Màn hình - Tỷ lệ màn hình
        seedDataVariantAtribute("2 USB Type-A", 41, 75); // Giao tiếp và kết nối - Cổng giao tiếp
        seedDataVariantAtribute("802.11 a/b/g/n/ac/ax", 42, 75); // Giao tiếp và kết nối - Wifi
        seedDataVariantAtribute("v5.3", 44, 75); // Giao tiếp và kết nối - Bluetooth
        seedDataVariantAtribute("5.0 MP", 74, 75); // Giao tiếp và kết nối - Webcam


        // Laptop HP Gaming Victus 16-s0078AX R5-7640HS/16GB/512GB/16.1"FHD/Nvidia RTX3050 6GB/Win11
        seedDataProduct("Laptop HP Gaming Victus 16-s0078AX R5-7640HS/16GB/512GB", "Laptop", 1.8, 8, 2, 2, "LaptopHPGamingVictus.png");
        seedDataVariant("/src/assets/products/LaptopHPGamingVictus.png", "Laptop HP Gaming Victus 16-s0078AX R5-7640HS/16GB/512GB", 20999900.0, 7, 57);

        seedDataVariantAtribute("Đen", 3, 76); // Thông tin hàng hóa - Màu sắc
        seedDataVariantAtribute("AMD", 9, 76); // Bộ xử lý - Hãng CPU
        seedDataVariantAtribute("Ryzen 5", 61, 76); // Bộ xử lý - Công nghệ CPU
        seedDataVariantAtribute("7640HS", 10, 76); // Bộ xử lý - Loại CPU
        seedDataVariantAtribute("4.30 GHz", 12, 76); // Bộ xử lý - Tốc độ CPU tối thiểu
        seedDataVariantAtribute("NVIDIA", 83, 76); // Đồ họa - Hãng (Card rời)
        seedDataVariantAtribute("GeForce RTX 3050", 84, 76); // Đồ họa - Model (Card rời)
        seedDataVariantAtribute("6 GB", 77, 76); // Đồ họa - Bộ nhớ
        seedDataVariantAtribute("143", 85, 76); // Đồ họa - Hiệu suất AI (TOPS)
        seedDataVariantAtribute("16 GB", 79, 76); // RAM - Dung lượng RAM
        seedDataVariantAtribute("DDR5", 66, 76); // RAM - Loại RAM
        seedDataVariantAtribute("2", 67, 76); // RAM - Số khe cắm rời
        seedDataVariantAtribute("1", 72, 76); // RAM - Số khe RAM còn lại
        seedDataVariantAtribute("32 GB", 68, 76); // RAM - Hỗ trợ RAM tối đa
        seedDataVariantAtribute("SSD", 70, 76); // Lưu trữ - Kiểu ổ cứng
        seedDataVariantAtribute("M.2 NVMe", 73, 76); // Lưu trữ - Loại SSD
        seedDataVariantAtribute("512 GB", 23, 76); // Lưu trữ - Dung lượng
        seedDataVariantAtribute("16.0 inch", 14, 76); // Màn hình - Kích thước màn hình
        seedDataVariantAtribute("Anti-glare LED UWVA", 15, 76); // Màn hình - Công nghệ màn hình
        seedDataVariantAtribute("1920 x 1060 Pixels", 17, 76); // Màn hình - Độ phân giải
        seedDataVariantAtribute("LCD", 19, 76); // Màn hình - Loại màn hình
        seedDataVariantAtribute("144 Hz", 22, 76); // Màn hình - Tần số quét
        seedDataVariantAtribute("WVA", 73, 76); // Màn hình - Tấm nền
        seedDataVariantAtribute("USB", 41, 76); // Giao tiếp và kết nối - Cổng giao tiếp
        seedDataVariantAtribute("Wifi 6E", 42, 76); // Giao tiếp và kết nối - Wifi
        seedDataVariantAtribute("v5.3", 44, 76); // Giao tiếp và kết nối - Bluetooth
        seedDataVariantAtribute("Full HD Webcam (1060p Webcam)", 74, 76); // Giao tiếp và kết nối - Webcam
        seedDataVariantAtribute("Windows", 49, 76); // Hệ điều hành - OS
        seedDataVariantAtribute("Windows 11 Home", 50, 76); // Hệ điều hành - Version
        seedDataVariantAtribute("Mở khóa bằng mật mã", 37, 76); // Bảo mật - Bảo mật
        seedDataVariantAtribute("Chiclet Keyboard", 51, 76); // Bàn phím & TouchPad - Kiểu bàn phím
        seedDataVariantAtribute("Có", 52, 76); // Bàn phím & TouchPad - Bàn phím số
        seedDataVariantAtribute("Không", 53, 76); // Bàn phím & TouchPad - Đèn bàn phím
        seedDataVariantAtribute("Multi-touch touchpad", 56, 76); // Bàn phím & TouchPad - TouchPad
        seedDataVariantAtribute("4 Cell", 47, 76); // Thông tin pin & sạc - Dung lượng pin
        seedDataVariantAtribute("Sạc", 57, 76); // Phụ kiện trong hộp
        seedDataVariantAtribute("36.9 x 25.94 x 2.29 cm", 5, 76); // Thiết kế & Trọng lượng - Kích thước
        seedDataVariantAtribute("2.31 kg", 6, 76); // Thiết kế & Trọng lượng - Trọng lượng sản phẩm
        seedDataVariantAtribute("Nhựa", 7, 76); // Thiết kế & Trọng lượng - Chất liệu
        seedDataVariantAtribute("Trung Quốc", 1, 76); // Thông tin hàng hóa - Xuất xứ
        seedDataVariantAtribute("2023", 2, 76); // Thông tin hàng hóa - Thời điểm ra mắt
        seedDataVariantAtribute("12", 4, 76); // Thông tin hàng hóa - Thời gian bảo hành (tháng)
        seedDataVariantAtribute("Để nơi khô ráo, nhẹ tay, dễ vỡ. & Xem trong sách hướng dẫn sử dụng", 48, 76); // Thông tin Pin và Sạc - Hướng dẫn bảo quản

        // Laptop HP ProBook 440 G10 i7-1360P/16GB/512GB/14" FHD Touch/Intel Graphics/Win11_Bạc_9H8V2PT
        seedDataProduct("Laptop HP ProBook 440 G10 i7-1360P/16GB/512GB", "Laptop", 1.8, 8, 2, 2, "LaptopHPProBook.png");
        seedDataVariant("/src/assets/products/LaptopHPProBook.png", "LaptopHPProBook Bạc 512GB", 25999900.0, 8, 58);

        seedDataVariantAtribute("Bạc", 3, 77); // Thông tin hàng hóa - Màu sắc
        seedDataVariantAtribute("Intel", 9, 77); // Bộ xử lý - Hãng CPU
        seedDataVariantAtribute("Core i7", 61, 77); // Bộ xử lý - Công nghệ CPU
        seedDataVariantAtribute("1360P", 10, 77); // Bộ xử lý - Loại CPU
        seedDataVariantAtribute("2.2", 12, 77); // Bộ xử lý - Tốc độ CPU tối thiểu
        seedDataVariantAtribute("Intel", 63, 77); // Đồ họa - Hãng (Card Oboard)
        seedDataVariantAtribute("Iris Xe", 64, 77); // Đồ họa - Model (Card Oboard)
        seedDataVariantAtribute("Intel Iris Xe Graphics", 65, 77); // Đồ họa - Tên đầy đủ (Card onboard)
        seedDataVariantAtribute("16 GB (1 thanh 16 GB)", 79, 77); // RAM - Dung lượng RAM
        seedDataVariantAtribute("DDR4", 66, 77); // RAM - Loại RAM
        seedDataVariantAtribute("2", 67, 77); // RAM - Số khe cắm rời
        seedDataVariantAtribute("1", 72, 77); // RAM - Số khe RAM còn lại
        seedDataVariantAtribute("64 GB", 68, 77); // RAM - Hỗ trợ RAM tối đa
        seedDataVariantAtribute("SSD", 70, 77); // Lưu trữ - Kiểu ổ cứng
        seedDataVariantAtribute("1", 71, 77); // Lưu trữ - Tổng số khe cắm SSD/HDD
        seedDataVariantAtribute("0", 72, 77); // Lưu trữ - Số khe SSD/HDD còn lại
        seedDataVariantAtribute("Nâng cấp tối đa 2TB (SSD M2 PCIe)", 73, 77); // Lưu trữ - Dung lượng nâng cấp tối đa ổ cứng
        seedDataVariantAtribute("1 M.2 NVMe", 73, 77); // Lưu trữ - Loại SSD
        seedDataVariantAtribute("512", 23, 77); // Lưu trữ - Dung lượng
        seedDataVariantAtribute("14 inch", 14, 77); // Màn hình - Kích thước màn hình
        seedDataVariantAtribute("Anti-Glare", 15, 77); // Màn hình - Công nghệ màn hình
        seedDataVariantAtribute("1920 x 1060 Pixels", 17, 77); // Màn hình - Độ phân giải
        seedDataVariantAtribute("LED", 19, 77); // Màn hình - Loại màn hình
        seedDataVariantAtribute("60", 22, 77); // Màn hình - Tần số quét
        seedDataVariantAtribute("IPS", 73, 77); // Màn hình - Tấm nền
        seedDataVariantAtribute("45% NTSC", 78, 77); // Màn hình - Độ phủ màu
        seedDataVariantAtribute("16:09", 81, 77); // Màn hình - Tỷ lệ màn hình

        // Laptop MSI
        seedDataProduct("Laptop MSI Gaming Katana 15 B13UDXK-2213VN i5 13500H/16GB/1TB", "Laptop", 1.8, 12, 2, 2, "LaptopMSIGamingKatana15.png");
        // Laptop MSI Gaming Katana 15 B13UDXK-2213VN i5 13500H/16GB/1TB/15.6FHD/RTX3050 6GB/Win11_Balo

        seedDataVariant("/src/assets/products/LaptopMSIGamingKatana15.png", "LaptopMSIKatana Đen 1TB", 21999900.0, 8, 59);

        seedDataVariantAtribute("Đen", 3, 78); // Thông tin hàng hóa - Màu sắc
        seedDataVariantAtribute("Intel", 9, 78); // Bộ xử lý - Hãng CPU
        seedDataVariantAtribute("Core i5", 61, 78); // Bộ xử lý - Công nghệ CPU
        seedDataVariantAtribute("13500H", 10, 78); // Bộ xử lý - Loại CPU
        seedDataVariantAtribute("4.7 GHz", 12, 78); // Bộ xử lý - Tốc độ tối đa
        seedDataVariantAtribute("12", 11, 78); // Bộ xử lý - Số nhân
        seedDataVariantAtribute("16", 12, 78); // Bộ xử lý - Số luồng
        seedDataVariantAtribute("18 MB", 85, 78); // Bộ xử lý - Bộ nhớ đệm
        seedDataVariantAtribute("NVIDIA", 83, 78); // Đồ họa - Hãng (Card rời)
        seedDataVariantAtribute("GeForce RTX 3050", 84, 78); // Đồ họa - Model (Card rời)
        seedDataVariantAtribute("NVIDIA GeForce RTX 3050 6GB", 65, 78); // Đồ họa - Tên đầy đủ (Card rời)
        seedDataVariantAtribute("6 GB GDDR6", 77, 78); // Đồ họa - Bộ nhớ
        seedDataVariantAtribute("143", 85, 78); // Đồ họa - Hiệu suất AI (TOPS)
        seedDataVariantAtribute("16 GB (2 thanh 8 GB)", 79, 78); // RAM - Dung lượng RAM
        seedDataVariantAtribute("DDR5", 66, 78); // RAM - Loại RAM
        seedDataVariantAtribute("5600 MHz", 67, 78); // RAM - Tốc độ RAM
        seedDataVariantAtribute("2", 67, 78); // RAM - Số khe cắm rời
        seedDataVariantAtribute("64 GB", 68, 78); // RAM - Hỗ trợ RAM tối đa
        seedDataVariantAtribute("SSD", 70, 78); // Lưu trữ - Kiểu ổ cứng
        seedDataVariantAtribute("2", 71, 78); // Lưu trữ - Tổng số khe cắm SSD/HDD
        seedDataVariantAtribute("1 SSD", 72, 78); // Lưu trữ - Số khe SSD/HDD còn lại
        seedDataVariantAtribute("1 M2. PCIe", 73, 78); // Lưu trữ - Loại SSD
        seedDataVariantAtribute("1", 23, 78); // Lưu trữ - Dung lượng
        seedDataVariantAtribute("15.6 inch", 14, 78); // Màn hình - Kích thước màn hình
        seedDataVariantAtribute("Anti-Glare LED-Backlit Display", 15, 78); // Màn hình - Công nghệ màn hình
        seedDataVariantAtribute("1920 x 1060 Pixels", 17, 78); // Màn hình - Độ phân giải
        seedDataVariantAtribute("144", 22, 78); // Màn hình - Tần số quét
        seedDataVariantAtribute("IPS", 73, 78); // Màn hình - Tấm nền
        seedDataVariantAtribute("45% NTSC", 78, 78); // Màn hình - Độ phủ màu
        seedDataVariantAtribute("16:09", 81, 78); // Màn hình - Tỷ lệ màn hình
        seedDataVariantAtribute("1 USB 3.2 Gen 1 Type-C, 2 USB 3.2 Gen 1 Type-A, 1 HDMI 2.1, 1 RJ45 Gigabit Ethernet, 1 USB 2.0", 41, 78); // Giao tiếp và kết nối - Cổng giao tiếp
        seedDataVariantAtribute("Wifi 6E", 42, 78); // Giao tiếp và kết nối - Wifi
        seedDataVariantAtribute("v5.2", 44, 78); // Giao tiếp và kết nối - Bluetooth
        seedDataVariantAtribute("HD Webcam (720p Webcam)", 74, 78); // Giao tiếp và kết nối - Webcam
        seedDataVariantAtribute("Windows", 49, 78); // Hệ điều hành - OS

        // Laptop MSI Gaming Cyborg 14 A13UDX-099VN i7-13620H/16GB/512GB/14" FHD/RTX3050 6GB/W11_Balo
        seedDataProduct("Laptop MSI Gaming Cyborg 14 A13UDX-099VN i7-13620H/16GB/512GB", "Laptop", 1.8, 12, 2, 2, "LaptopMSIGamingCyborg14.png");
        seedDataVariant("/src/assets/products/LaptopMSIGamingCyborg14.png", "LaptopMSICyborg Đen 512GB", 25599900.0, 8, 60);

        seedDataVariantAtribute("Đen", 3, 79); // Thông tin hàng hóa - Màu sắc
        seedDataVariantAtribute("Intel", 9, 79); // Bộ xử lý - Hãng CPU
        seedDataVariantAtribute("Core i7", 61, 79); // Bộ xử lý - Công nghệ CPU
        seedDataVariantAtribute("13620H", 10, 79); // Bộ xử lý - Loại CPU
        seedDataVariantAtribute("1.8", 12, 79); // Bộ xử lý - Tốc độ CPU tối thiểu
        seedDataVariantAtribute("4.9 GHz", 12, 79); // Bộ xử lý - Tốc độ tối đa
        seedDataVariantAtribute("10", 11, 79); // Bộ xử lý - Số nhân
        seedDataVariantAtribute("16", 12, 79); // Bộ xử lý - Số luồng
        seedDataVariantAtribute("NVIDIA", 83, 79); // Đồ họa - Hãng (Card rời)
        seedDataVariantAtribute("GeForce RTX 3050", 84, 79); // Đồ họa - Model (Card rời)
        seedDataVariantAtribute("NVIDIA GeForce RTX 3050 6GB", 65, 79); // Đồ họa - Tên đầy đủ (Card rời)
        seedDataVariantAtribute("6 GB GDDR6", 77, 79); // Đồ họa - Bộ nhớ
        seedDataVariantAtribute("143", 85, 79); // Đồ họa - Hiệu suất AI (TOPS)
        seedDataVariantAtribute("16 GB (2 thanh 8 GB)", 79, 79); // RAM - Dung lượng RAM
        seedDataVariantAtribute("DDR5", 66, 79); // RAM - Loại RAM
        seedDataVariantAtribute("5600 MHz", 67, 79); // RAM - Tốc độ RAM
        seedDataVariantAtribute("2", 67, 79); // RAM - Số khe cắm rời
        seedDataVariantAtribute("96 GB", 68, 79); // RAM - Hỗ trợ RAM tối đa
        seedDataVariantAtribute("SSD", 70, 79); // Lưu trữ - Kiểu ổ cứng
        seedDataVariantAtribute("1", 71, 79); // Lưu trữ - Tổng số khe cắm SSD/HDD
        seedDataVariantAtribute("1 M2. PCIe", 73, 79); // Lưu trữ - Loại SSD
        seedDataVariantAtribute("512", 23, 79); // Lưu trữ - Dung lượng
        seedDataVariantAtribute("14 inch", 14, 79); // Màn hình - Kích thước màn hình
        seedDataVariantAtribute("Anti-Glare LED-Backlit Display", 15, 79); // Màn hình - Công nghệ màn hình
        seedDataVariantAtribute("1920 x 1200 Pixels", 17, 79); // Màn hình - Độ phân giải
        seedDataVariantAtribute("LED", 19, 79); // Màn hình - Loại màn hình
        seedDataVariantAtribute("144", 22, 79); // Màn hình - Tần số quét
        seedDataVariantAtribute("IPS", 73, 79); // Màn hình - Tấm nền
        seedDataVariantAtribute("100% sRGB", 78, 79); // Màn hình - Độ phủ màu
        seedDataVariantAtribute("16:10", 81, 79); // Màn hình - Tỷ lệ màn hình
        seedDataVariantAtribute("1 Type C, 2 USB 3.2 Gen 1 Type-A, 1 HDMI 2.1, 1 RJ45 Gigabit Ethernet", 41, 79); // Giao tiếp và kết nối - Cổng giao tiếp
        seedDataVariantAtribute("Wifi 6E", 42, 79); // Giao tiếp và kết nối - Wifi
        seedDataVariantAtribute("v5.2", 44, 79); // Giao tiếp và kết nối - Bluetooth
        seedDataVariantAtribute("HD Webcam (720p Webcam)", 74, 79); // Giao tiếp và kết nối - Webcam
        seedDataVariantAtribute("Nahimic Audio", 82, 79); // Âm Thanh - Công nghệ âm thanh
        seedDataVariantAtribute("Windows", 49, 79); // Hệ điều hành - OS
        seedDataVariantAtribute("Windows 11 Home Single Language", 50, 79); // Hệ điều hành - Version
        seedDataVariantAtribute("Mật khẩu", 37, 79); // Bảo mật - Bảo mật
        seedDataVariantAtribute("6-row, multimedia Fn keys", 51, 79); // Bàn phím & TouchPad - Kiểu bàn phím
        seedDataVariantAtribute("Không", 52, 79); // Bàn phím & TouchPad - Bàn phím số
        seedDataVariantAtribute("LED", 53, 79); // Bàn phím & TouchPad - Đèn bàn phím


        seedDataProduct("Laptop MSI Gaming Katana A15 AI B8VE-402VN R7 8845HS/64GB/512GB", "Laptop", 1.8, 12, 2, 2, "LaptopMSIGamingKatanaA15.jpg");
        seedDataVariant("/src/assets/products/LaptopMSIGamingKatanaA15.jpg", "LaptopMSIKatana Đen 512GB", 26699990.0, 8, 61);

        seedDataVariantAtribute("Đen", 3, 80); // Thông tin hàng hóa - Màu sắc
        seedDataVariantAtribute("AMD", 9, 80); // Bộ xử lý - Hãng CPU
        seedDataVariantAtribute("Ryzen 7", 61, 80); // Bộ xử lý - Công nghệ CPU
        seedDataVariantAtribute("8845HS", 10, 80); // Bộ xử lý - Loại CPU
        seedDataVariantAtribute("3.8", 12, 80); // Bộ xử lý - Tốc độ CPU tối thiểu
        seedDataVariantAtribute("5.1 GHz", 12, 80); // Bộ xử lý - Tốc độ tối đa
        seedDataVariantAtribute("8", 11, 80); // Bộ xử lý - Số nhân
        seedDataVariantAtribute("16", 11, 80); // Bộ xử lý - Số luồng
        seedDataVariantAtribute("16 MB", 85, 80); // Bộ xử lý - Bộ nhớ đệm
        seedDataVariantAtribute("NVIDIA", 83, 80); // Đồ họa - Hãng (Card rời)
        seedDataVariantAtribute("GeForce RTX 4050", 84, 80); // Đồ họa - Model (Card rời)
        seedDataVariantAtribute("NVIDIA GeForce RTX 4050 6GB GDDR6", 65, 80); // Đồ họa - Tên đầy đủ (Card rời)
        seedDataVariantAtribute("6 GB GDDR6", 77, 80); // Đồ họa - Bộ nhớ
        seedDataVariantAtribute("194", 85, 80); // Đồ họa - Hiệu suất AI (TOPS)
        seedDataVariantAtribute("16 GB (2 thanh 8 GB)", 79, 80); // RAM - Dung lượng RAM
        seedDataVariantAtribute("DDR5", 66, 80); // RAM - Loại RAM
        seedDataVariantAtribute("5600 MHz", 67, 80); // RAM - Tốc độ RAM
        seedDataVariantAtribute("2", 67, 80); // RAM - Số khe cắm rời
        seedDataVariantAtribute("64 GB", 68, 80); // RAM - Hỗ trợ RAM tối đa
        seedDataVariantAtribute("SSD", 70, 80); // Lưu trữ - Kiểu ổ cứng
        seedDataVariantAtribute("1", 71, 80); // Lưu trữ - Tổng số khe cắm SSD/HDD
        seedDataVariantAtribute("1 M2. PCIe", 73, 80); // Lưu trữ - Loại SSD
        seedDataVariantAtribute("512", 23, 80); // Lưu trữ - Dung lượng
        seedDataVariantAtribute("15.6 inch", 14, 80); // Màn hình - Kích thước màn hình
        seedDataVariantAtribute("Anti-Glare LED-Backlit Display", 15, 80); // Màn hình - Công nghệ màn hình
        seedDataVariantAtribute("1920 x 1060 Pixels", 17, 80); // Màn hình - Độ phân giải
        seedDataVariantAtribute("LED", 19, 80); // Màn hình - Loại màn hình
        seedDataVariantAtribute("144", 22, 80); // Màn hình - Tần số quét
        seedDataVariantAtribute("IPS", 73, 80); // Màn hình - Tấm nền
        seedDataVariantAtribute("16:09", 81, 80); // Màn hình - Tỷ lệ màn hình
        seedDataVariantAtribute("USB 3.2 Gen 2 Type-C, USB 3.2 Gen 1 Type-A, HDMI 2.1, RJ45 Gigabit Ethernet, Jack 3.5 mm", 41, 80); // Giao tiếp và kết nối - Cổng giao tiếp
        seedDataVariantAtribute("Wifi 6E", 42, 80); // Giao tiếp và kết nối - Wifi
        seedDataVariantAtribute("v5.2", 44, 80); // Giao tiếp và kết nối - Bluetooth

        seedDataProduct("Laptop Lenovo ThinkPad E14 G5 I5 13420H/16GB/512GB", "Laptop", 1.8, 9, 2, 2, "LaptopLenovoThinkPad.jpg");
        // Laptop Lenovo ThinkPad E14 G5 I5 13420H/16GB/512GB/14"WUXGA/Win 11
        seedDataVariant("/src/assets/products/LaptopLenovoThinkPad.jpg", "LaptopLenovoThinkPad Đen 512GB", 20799900.0, 8, 62);
        seedDataVariantAtribute("Đen", 3, 81); // Thông tin hàng hóa - Màu sắc
        seedDataVariantAtribute("Intel", 9, 81); // Bộ xử lý - Hãng CPU
        seedDataVariantAtribute("Core i5", 61, 81); // Bộ xử lý - Công nghệ CPU
        seedDataVariantAtribute("13420H", 10, 81); // Bộ xử lý - Loại CPU
        seedDataVariantAtribute("2.1", 12, 81); // Bộ xử lý - Tốc độ CPU tối thiểu
        seedDataVariantAtribute("4.6 GHz", 12, 81); // Bộ xử lý - Tốc độ tối đa
        seedDataVariantAtribute("8", 11, 81); // Bộ xử lý - Số nhân
        seedDataVariantAtribute("12", 11, 81); // Bộ xử lý - Số luồng
        seedDataVariantAtribute("12 MB", 85, 81); // Bộ xử lý - Bộ nhớ đệm
        seedDataVariantAtribute("Intel", 63, 81); // Đồ họa - Hãng (Card Oboard)
        seedDataVariantAtribute("UHD", 64, 81); // Đồ họa - Model (Card Oboard)
        seedDataVariantAtribute("Intel UHD Graphics", 65, 81); // Đồ họa - Tên đầy đủ (Card onboard)
        seedDataVariantAtribute("16 GB (2 thanh 8 GB)", 79, 81); // RAM - Dung lượng RAM
        seedDataVariantAtribute("DDR4", 66, 81); // RAM - Loại RAM
        seedDataVariantAtribute("3200 MHz", 67, 81); // RAM - Tốc độ RAM
        seedDataVariantAtribute("1", 67, 81); // RAM - Số khe cắm rời
        seedDataVariantAtribute("40 GB", 68, 81); // RAM - Hỗ trợ RAM tối đa
        seedDataVariantAtribute("SSD", 70, 81); // Lưu trữ - Kiểu ổ cứng
        seedDataVariantAtribute("M.2 2242", 71, 81); // Lưu trữ - Loại SSD
        seedDataVariantAtribute("512", 23, 81); // Lưu trữ - Dung lượng
        seedDataVariantAtribute("2242", 73, 81); // Lưu trữ - Chuẩn M2
        seedDataVariantAtribute("14 inch", 14, 81); // Màn hình - Kích thước màn hình
        seedDataVariantAtribute("Anti-Glare", 15, 81); // Màn hình - Công nghệ màn hình
        seedDataVariantAtribute("1920 x 1200 Pixels", 17, 81); // Màn hình - Độ phân giải
        seedDataVariantAtribute("Màn hình phẳng", 19, 81); // Màn hình - Loại màn hình
        seedDataVariantAtribute("60", 22, 81); // Màn hình - Tần số quét
        seedDataVariantAtribute("IPS", 73, 81); // Màn hình - Tấm nền
        seedDataVariantAtribute("16:10", 81, 81); // Màn hình - Tỷ lệ màn hình
        seedDataVariantAtribute("USB 3.2 Gen 2 Type-C, USB 3.2 Gen 1 Type-A, HDMI 2.1, RJ45 Gigabit Ethernet, Jack 3.5 mm", 41, 81); // Giao tiếp và kết nối - Cổng giao tiếp
        seedDataVariantAtribute("Wifi 6", 42, 81); // Giao tiếp và kết nối - Wifi
        seedDataVariantAtribute("v5.1", 44, 81); // Giao tiếp và kết nối - Bluetooth
        seedDataVariantAtribute("Full HD Webcam (1060p Webcam)", 74, 81); // Giao tiếp và kết nối - Webcam
        seedDataVariantAtribute("High Definition (HD) Audio", 82, 81); // Âm Thanh - Công nghệ âm thanh
        seedDataVariantAtribute("Windows", 49, 81); // Hệ điều hành - OS
        seedDataVariantAtribute("Windows 11 Home", 50, 81); // Hệ điều hành - Version
        seedDataVariantAtribute("64 bit", 50, 81); // Hệ điều hành - Type
        seedDataVariantAtribute("Mở khóa vân tay", 37, 81); // Bảo mật - Bảo mật
        seedDataVariantAtribute("English International Backlit Keyboard", 51, 81); // Bàn phím & TouchPad - Kiểu bàn phím
        seedDataVariantAtribute("Không", 52, 81); // Bàn phím & TouchPad - Bàn phím số
        seedDataVariantAtribute("LED", 53, 81); // Bàn phím & TouchPad - Đèn bàn phím
        seedDataVariantAtribute("RGB 4 Zone", 54, 81); // Bàn phím & TouchPad - Công nghệ đèn bàn phím
        seedDataVariantAtribute("RGB", 55, 81); // Bàn phím & TouchPad - Màu đèn LED


        // Laptop Lenovo ThinkPad E14 Gen 5 i7-1355U/16GB/512GB/14.0"WUXGA/Win 11
        seedDataProduct("Laptop Lenovo ThinkPad E14 Gen 5 i7-1355U/16GB/512GB", "Laptop", 1.8, 9, 2, 2, "LaptopLenovoThinkPad.jpg");
        seedDataVariant("/src/assets/products/LaptopLenovoThinkPad.jpg", "LaptopLenovoThinkPad Xám 512GB", 22699900.0, 5, 63);

        seedDataVariantAtribute("Xám", 3, 82); // Thông tin hàng hóa - Màu sắc
        seedDataVariantAtribute("Intel", 9, 82); // Bộ xử lý - Hãng CPU
        seedDataVariantAtribute("Core i7", 61, 82); // Bộ xử lý - Công nghệ CPU
        seedDataVariantAtribute("1355U", 10, 82); // Bộ xử lý - Loại CPU
        seedDataVariantAtribute("1.7", 12, 82); // Bộ xử lý - Tốc độ CPU tối thiểu
        seedDataVariantAtribute("5 GHz", 12, 82); // Bộ xử lý - Tốc độ tối đa
        seedDataVariantAtribute("10", 11, 82); // Bộ xử lý - Số nhân
        seedDataVariantAtribute("12", 12, 82); // Bộ xử lý - Số luồng
        seedDataVariantAtribute("12 MB", 85, 82); // Bộ xử lý - Bộ nhớ đệm
        seedDataVariantAtribute("Intel", 63, 82); // Đồ họa - Hãng (Card Oboard)
        seedDataVariantAtribute("Iris Xe", 64, 82); // Đồ họa - Model (Card Oboard)
        seedDataVariantAtribute("Intel Iris Xe Graphics", 65, 82); // Đồ họa - Tên đầy đủ (Card onboard)
        seedDataVariantAtribute("16 GB (2 thanh 8 GB)", 79, 82); // RAM - Dung lượng RAM
        seedDataVariantAtribute("DDR4", 66, 82); // RAM - Loại RAM
        seedDataVariantAtribute("3200 MHz", 67, 82); // RAM - Tốc độ RAM
        seedDataVariantAtribute("1", 67, 82); // RAM - Số khe cắm rời
        seedDataVariantAtribute("1", 67, 82); // RAM - Số RAM onboard
        seedDataVariantAtribute("40 GB", 68, 82); // RAM - Hỗ trợ RAM tối đa
        seedDataVariantAtribute("SSD", 70, 82); // Lưu trữ - Kiểu ổ cứng
        seedDataVariantAtribute("M2. PCIe", 73, 82); // Lưu trữ - Loại SSD
        seedDataVariantAtribute("512", 23, 82); // Lưu trữ - Dung lượng
        seedDataVariantAtribute("14 inch", 14, 82); // Màn hình - Kích thước màn hình
        seedDataVariantAtribute("Anti-glare LED Backlit Ultra Slim", 15, 82); // Màn hình - Công nghệ màn hình
        seedDataVariantAtribute("1920 x 1060 Pixels", 17, 82); // Màn hình - Độ phân giải
        seedDataVariantAtribute("Màn hình phẳng", 19, 82); // Màn hình - Loại màn hình
        seedDataVariantAtribute("60", 22, 82); // Màn hình - Tần số quét
        seedDataVariantAtribute("IPS", 73, 82); // Màn hình - Tấm nền
        seedDataVariantAtribute("300 nits", 20, 82); // Màn hình - Độ sáng
        seedDataVariantAtribute("45% NTSC", 78, 82); // Màn hình - Độ phủ màu
        seedDataVariantAtribute("1 HDMI 2.1, 1 Jack 3.5 mm, 1 RJ45 Gigabit Ethernet, 1 USB 2.0, 1 USB 3.2 Gen 1, 1 USB 3.2 Gen 2, 1 Thunderbolt 4", 41, 82); // Giao tiếp và kết nối - Cổng giao tiếp
        seedDataVariantAtribute("Wifi 6", 42, 82); // Giao tiếp và kết nối - Wifi
        seedDataVariantAtribute("v5.1", 44, 82); // Giao tiếp và kết nối - Bluetooth
        seedDataVariantAtribute("Full HD Webcam (1060p Webcam)", 74, 82); // Giao tiếp và kết nối - Webcam
        seedDataVariantAtribute("Windows", 49, 82); // Hệ điều hành - OS
        seedDataVariantAtribute("Windows 11 Home Single Language", 50, 82); // Hệ điều hành - Version
        seedDataVariantAtribute("Mật khẩu", 37, 82); // Bảo mật - Bảo mật
        seedDataVariantAtribute("Backlit Chiclet Keyboard", 51, 82); // Bàn phím & TouchPad - Kiểu bàn phím

        // Laptop Lenovo V15 G4 IRU i5 13420H/16GB/512GB/15.6"FHD/Win 11
        seedDataProduct("Laptop Lenovo V15 G4 IRU i5 13420H/16GB/512GB", "Laptop", 1.8, 9, 2, 2, "LaptopLenovoV15.jpg");
        seedDataVariant("/src/assets/products/LaptopLenovoV15.jpg", "LaptopLenovoV15 Đen 512GB", 15699900.0, 7, 64);

        seedDataVariantAtribute("Đen", 3, 83); // Thông tin hàng hóa - Màu sắc
        seedDataVariantAtribute("Intel", 9, 83); // Bộ xử lý - Hãng CPU
        seedDataVariantAtribute("Core i5", 61, 83); // Bộ xử lý - Công nghệ CPU
        seedDataVariantAtribute("13420H", 10, 83); // Bộ xử lý - Loại CPU
        seedDataVariantAtribute("2.1", 12, 83); // Bộ xử lý - Tốc độ CPU tối thiểu
        seedDataVariantAtribute("4.6 GHz", 12, 83); // Bộ xử lý - Tốc độ tối đa
        seedDataVariantAtribute("8", 11, 83); // Bộ xử lý - Số nhân
        seedDataVariantAtribute("12", 12, 83); // Bộ xử lý - Số luồng
        seedDataVariantAtribute("12 MB", 85, 83); // Bộ xử lý - Bộ nhớ đệm
        seedDataVariantAtribute("Intel", 63, 83); // Đồ họa - Hãng (Card Oboard)
        seedDataVariantAtribute("UHD", 64, 83); // Đồ họa - Model (Card Oboard)
        seedDataVariantAtribute("Intel UHD Graphics", 65, 83); // Đồ họa - Tên đầy đủ (Card onboard)
        seedDataVariantAtribute("16 GB (2 thanh 8 GB)", 79, 83); // RAM - Dung lượng RAM
        seedDataVariantAtribute("DDR4", 66, 83); // RAM - Loại RAM
        seedDataVariantAtribute("3200 MHz", 67, 83); // RAM - Tốc độ RAM
        seedDataVariantAtribute("1", 67, 83); // RAM - Số khe cắm rời
        seedDataVariantAtribute("16 GB", 68, 83); // RAM - Hỗ trợ RAM tối đa
        seedDataVariantAtribute("SSD", 70, 83); // Lưu trữ - Kiểu ổ cứng
        seedDataVariantAtribute("M.2 2242", 73, 83); // Lưu trữ - Loại SSD
        seedDataVariantAtribute("512", 23, 83); // Lưu trữ - Dung lượng
        seedDataVariantAtribute("15.6 inch", 14, 83); // Màn hình - Kích thước màn hình
        seedDataVariantAtribute("Anti-Glare", 15, 83); // Màn hình - Công nghệ màn hình
        seedDataVariantAtribute("1920 x 1060 Pixels", 17, 83); // Màn hình - Độ phân giải
        seedDataVariantAtribute("Màn hình phẳng", 19, 83); // Màn hình - Loại màn hình
        seedDataVariantAtribute("60", 22, 83); // Màn hình - Tần số quét
        seedDataVariantAtribute("IPS", 73, 83); // Màn hình - Tấm nền
        seedDataVariantAtribute("300 nits", 20, 83); // Màn hình - Độ sáng
        seedDataVariantAtribute("45% NTSC", 78, 83); // Màn hình - Độ phủ màu
        seedDataVariantAtribute("1 USB 2.0, 1 USB 3.2 Gen 1, 1 USB 3.2 Gen 1 Type-C, 1 HDMI 1.4, 1 Jack 3.5 mm, 1 RJ45 Gigabit Ethernet, 1 Power connector", 41, 83); // Giao tiếp và kết nối - Cổng giao tiếp
        seedDataVariantAtribute("Wifi 6E", 42, 83); // Giao tiếp và kết nối - Wifi
        seedDataVariantAtribute("v5.1", 44, 83); // Giao tiếp và kết nối - Bluetooth
        seedDataVariantAtribute("Full HD Webcam (1060p Webcam)", 74, 83); // Giao tiếp và kết nối - Webcam
        seedDataVariantAtribute("Windows", 49, 83); // Hệ điều hành - OS
        seedDataVariantAtribute("Windows 11 Home Single Language", 50, 83); // Hệ điều hành - Version
        seedDataVariantAtribute("Mật khẩu", 37, 83); // Bảo mật - Bảo mật
        seedDataVariantAtribute("English International Non-backlit Keyboard", 51, 83); // Bàn phím & TouchPad - Kiểu bàn phím
        seedDataVariantAtribute("Không", 52, 83); // Bàn phím & TouchPad - Bàn phím số


        // Ipad
        // iPad Air 11 inch M2 2024
        seedDataProduct("iPad Air 11 inch M2 2024 Wifi Tím 128GB", "Ipad", 0.462, 13, 3, 3, "iPadAir11inchM22024Wifi128GBtim.jpg");

        //iPad Air 11 inch M2 2024 Wifi 128GB
        // màu tím
        seedDataVariant("/src/assets/products/iPadAir11inchM22024Wifi128GBtim.jpg", " iPad Air 11 inch M2 2024 Wifi Tím 128GB" ,22299900.0 , 8, 65);
        seedDataVariantAtribute("Tím", 3, 84); // Thông tin hàng hóa - Màu sắc
        seedDataVariantAtribute("128 GB", 24, 84); // Dung lượng
        seedDataVariantAtribute("Việt Nam / Trung Quốc", 1, 84); // Xuất xứ
        seedDataVariantAtribute("05/2024", 2, 84); // Thời điểm ra mắt
        seedDataVariantAtribute("12", 4, 84); // Thời gian bảo hành (tháng)
        seedDataVariantAtribute("Để nơi khô ráo, nhẹ tay, dễ vỡ. Xem trong sách hướng dẫn sử dụng", 48, 84); // Hướng dẫn bảo quản và sử dụng
        seedDataVariantAtribute("247.6 x 178.5 x 6.1 mm", 5, 84); // Kích thước
        seedDataVariantAtribute("462 g", 6, 84); // Trọng lượng sản phẩm
        seedDataVariantAtribute("Vỏ máy: Nhôm tái chế", 7, 84); // Chất liệu
        seedDataVariantAtribute("Apple M2", 9, 84); // CPU Model
        seedDataVariantAtribute("8 - Core", 10, 84); // Loại CPU
        seedDataVariantAtribute("8", 11, 84); // Số nhân
        seedDataVariantAtribute("8 GB", 79, 84); // Dung lượng RAM
        seedDataVariantAtribute("11 inch", 14, 84); // Kích thước màn hình
        seedDataVariantAtribute("Liquid Retina", 15, 84); // Công nghệ màn hình
        seedDataVariantAtribute("2360 x 1640 Pixels", 17, 84); // Độ phân giải
        seedDataVariantAtribute("Liquid Retina", 16, 84); // Chuẩn màn hình
        seedDataVariantAtribute("500 nits", 20, 84); // Độ sáng
        seedDataVariantAtribute("Ultra Wide", 27, 84); // Camera Type 1
        seedDataVariantAtribute("12.0 MP", 28, 84); // Resolution (Camera 1)
        seedDataVariantAtribute("ƒ/1.8", 29, 84); // Aperture (Camera 1)
        seedDataVariantAtribute("FullHD 1060p@120fps, FullHD 1060p@30fps, FullHD 1060p@240fps, 4K 2160p@60fps, 4K 2160p@25fps, 4K 2160p@24fps, 4K 2160p@30fps, HD 720p@30fps, FullHD 1060p@25fps, FullHD 1060p@60fps", 30, 84); // Quay phim camera sau
        seedDataVariantAtribute("Single selfie camera", 32, 84); // Số Camera Selfie
        seedDataVariantAtribute("12.0 MP", 33, 84); // Resolution (Camera Selfie 1)
        seedDataVariantAtribute("ƒ/2.4", 34, 84); // Aperture (Camera Selfie 1)
        seedDataVariantAtribute("Quay phim FullHD", 34, 84); // Quay phim camera selfie
        seedDataVariantAtribute("Trôi nhanh thời gian (Time lapse), Chụp góc rộng (Wide)", 35, 84); // Tính năng camera selfie
        seedDataVariantAtribute("Cảm biến vân tay, Con quay hồi chuyển, Cảm biến gia tốc kế, Cảm biến khí áp kế, Cảm biến ánh sáng", 36, 84); // Cảm biến
        seedDataVariantAtribute("Mật khẩu", 37, 84); // Bảo mật
        seedDataVariantAtribute("5G", 39, 84); // Hỗ trợ mạng


        // màu đen
        seedDataProduct("iPad Air 11 inch M2 2024 Wifi Xám 128GB", "Ipad", 0.462, 13, 3, 3, "iPadAir11inchM22024Wifi128GBxam.jpg");
        seedDataVariant("/src/assets/products/iPadAir11inchM22024Wifi128GBxam.jpg", " iPad Air 11 inch M2 2024 Wifi Xám 128GB" ,22299901.0 , 8, 66);
        seedDataVariantAtribute("Xám", 3, 85); // Thông tin hàng hóa - Màu sắc
        seedDataVariantAtribute("128 GB", 24, 85); // Dung lượng
        seedDataVariantAtribute("Việt Nam / Trung Quốc", 1, 85); // Xuất xứ
        seedDataVariantAtribute("05/2024", 2, 85); // Thời điểm ra mắt
        seedDataVariantAtribute("12", 4, 85); // Thời gian bảo hành (tháng)
        seedDataVariantAtribute("Để nơi khô ráo, nhẹ tay, dễ vỡ. Xem trong sách hướng dẫn sử dụng", 48, 85); // Hướng dẫn bảo quản và sử dụng
        seedDataVariantAtribute("247.6 x 178.5 x 6.1 mm", 5, 85); // Kích thước
        seedDataVariantAtribute("462 g", 6, 85); // Trọng lượng sản phẩm
        seedDataVariantAtribute("Vỏ máy: Nhôm tái chế", 7, 85); // Chất liệu
        seedDataVariantAtribute("Apple M2", 9, 85); // CPU Model
        seedDataVariantAtribute("8 - Core", 10, 85); // Loại CPU
        seedDataVariantAtribute("8", 11, 85); // Số nhân
        seedDataVariantAtribute("8 GB", 79, 85); // Dung lượng RAM
        seedDataVariantAtribute("11 inch", 14, 85); // Kích thước màn hình
        seedDataVariantAtribute("Liquid Retina", 15, 85); // Công nghệ màn hình
        seedDataVariantAtribute("2360 x 1640 Pixels", 17, 85); // Độ phân giải
        seedDataVariantAtribute("Liquid Retina", 16, 85); // Chuẩn màn hình
        seedDataVariantAtribute("500 nits", 20, 85); // Độ sáng
        seedDataVariantAtribute("Ultra Wide", 27, 85); // Camera Type 1
        seedDataVariantAtribute("12.0 MP", 28, 85); // Resolution (Camera 1)
        seedDataVariantAtribute("ƒ/1.8", 29, 85); // Aperture (Camera 1)
        seedDataVariantAtribute("FullHD 1060p@120fps, FullHD 1060p@30fps, FullHD 1060p@240fps, 4K 2160p@60fps, 4K 2160p@25fps, 4K 2160p@24fps, 4K 2160p@30fps, HD 720p@30fps, FullHD 1060p@25fps, FullHD 1060p@60fps", 30, 85); // Quay phim camera sau
        seedDataVariantAtribute("Single selfie camera", 32, 85); // Số Camera Selfie
        seedDataVariantAtribute("12.0 MP", 33, 85); // Resolution (Camera Selfie 1)
        seedDataVariantAtribute("ƒ/2.4", 34, 85); // Aperture (Camera Selfie 1)
        seedDataVariantAtribute("Quay phim FullHD", 34, 85); // Quay phim camera selfie

        // màu trắng
        seedDataProduct("iPad Air 11 inch M2 2024 Wifi Trắng 128GB", "Ipad", 0.462, 13, 3, 3, "iPadAir11inchM22024Wifi128GBtrang.jpg");
        seedDataVariant("/src/assets/products/iPadAir11inchM22024Wifi128GBtrang.jpg", " iPad Air 11 inch M2 2024 Wifi Trắng 128GB" ,22999001.0 , 8, 67);
        seedDataVariantAtribute("Trắng", 3, 86); // Thông tin hàng hóa - Màu sắc
        seedDataVariantAtribute("128 GB", 24, 86); // Dung lượng
        seedDataVariantAtribute("Việt Nam / Trung Quốc", 1, 86); // Xuất xứ
        seedDataVariantAtribute("05/2024", 2, 86); // Thời điểm ra mắt
        seedDataVariantAtribute("12", 4, 86); // Thời gian bảo hành (tháng)
        seedDataVariantAtribute("Để nơi khô ráo, nhẹ tay, dễ vỡ. Xem trong sách hướng dẫn sử dụng", 48, 86); // Hướng dẫn bảo quản và sử dụng
        seedDataVariantAtribute("247.6 x 178.5 x 6.1 mm", 5, 86); // Kích thước
        seedDataVariantAtribute("462 g", 6, 86); // Trọng lượng sản phẩm
        seedDataVariantAtribute("Vỏ máy: Nhôm tái chế", 7, 86); // Chất liệu
        seedDataVariantAtribute("Apple M2", 9, 86); // CPU Model
        seedDataVariantAtribute("8 - Core", 10, 86); // Loại CPU
        seedDataVariantAtribute("8", 11, 86); // Số nhân
        seedDataVariantAtribute("8 GB", 79, 86); // Dung lượng RAM
        seedDataVariantAtribute("11 inch", 14, 86); // Kích thước màn hình
        seedDataVariantAtribute("Liquid Retina", 15, 86); // Công nghệ màn hình
        seedDataVariantAtribute("2360 x 1640 Pixels", 17, 86); // Độ phân giải
        seedDataVariantAtribute("Liquid Retina", 16, 86); // Chuẩn màn hình
        seedDataVariantAtribute("500 nits", 20, 86); // Độ sáng
        seedDataVariantAtribute("Ultra Wide", 27, 86); // Camera Type 1
        seedDataVariantAtribute("12.0 MP", 28, 86); // Resolution (Camera 1)
        seedDataVariantAtribute("ƒ/1.8", 29, 86); // Aperture (Camera 1)
        seedDataVariantAtribute("FullHD 1060p@120fps, FullHD 1060p@30fps, FullHD 1060p@240fps, 4K 2160p@60fps, 4K 2160p@25fps, 4K 2160p@24fps, 4K 2160p@30fps, HD 720p@30fps, FullHD 1060p@25fps, FullHD 1060p@60fps", 30, 86); // Quay phim camera sau
        seedDataVariantAtribute("Single selfie camera", 32, 86); // Số Camera Selfie
        seedDataVariantAtribute("12.0 MP", 33, 86); // Resolution (Camera Selfie 1)
        seedDataVariantAtribute("ƒ/2.4", 34, 86); // Aperture (Camera Selfie 1)
        seedDataVariantAtribute("Quay phim FullHD", 34, 86); // Quay phim camera selfie
        seedDataVariantAtribute("Trôi nhanh thời gian (Time lapse), Chụp góc rộng (Wide)", 35, 86); // Tính năng camera selfie
        seedDataVariantAtribute("Cảm biến vân tay, Con quay hồi chuyển, Cảm biến gia tốc kế, Cảm biến khí áp kế, Cảm biến ánh sáng", 36, 86); // Cảm biến
        seedDataVariantAtribute("Mật khẩu", 37, 86); // Bảo mật
        seedDataVariantAtribute("5G", 39, 86); // Hỗ trợ mạng
        seedDataVariantAtribute("Cổng sạc: Type C", 41, 86); // Cổng giao tiếp
        seedDataVariantAtribute("Wifi 6E", 42, 86); // Wifi
        seedDataVariantAtribute("v5.3", 44, 86); // Bluetooth
        seedDataVariantAtribute("Lithium polymer", 47, 86); // Loại PIN
        seedDataVariantAtribute("28.93 Wh", 48, 86); // Dung lượng pin
        seedDataVariantAtribute("iPadOS", 49, 86); // OS
        seedDataVariantAtribute("iPadOS 17", 50, 86); // Version
        seedDataVariantAtribute("Dây cáp sạc, Củ sạc iPad", 57, 86); // Phụ kiện trong hộp

        //
        seedDataProduct("iPad Air 11 inch M2 2024 Wifi Xám 512 GB", "Ipad", 0.462, 13, 3, 3, "iPadAir11inchM22024Wifi128GBxam.jpg");
        seedDataVariant("/src/assets/products/iPadAir11inchM22024Wifi128GBxam.jpg", "iPad Air 11 inch M2 2024 Wifi Xám 512GB" ,26999993.0 , 8, 68);
        // màu đen
        seedDataVariantAtribute("Xám", 3, 87); // Thông tin hàng hóa - Màu sắc
        seedDataVariantAtribute("512 GB", 24, 87); // Dung lượng
        seedDataVariantAtribute("Việt Nam / Trung Quốc", 1, 87); // Xuất xứ
        seedDataVariantAtribute("05/2024", 2, 87); // Thời điểm ra mắt
        seedDataVariantAtribute("12", 4, 87); // Thời gian bảo hành (tháng)
        seedDataVariantAtribute("Để nơi khô ráo, nhẹ tay, dễ vỡ. Xem trong sách hướng dẫn sử dụng", 48, 87); // Hướng dẫn bảo quản và sử dụng
        seedDataVariantAtribute("247.6 x 178.5 x 6.1 mm", 5, 87); // Kích thước
        seedDataVariantAtribute("462 g", 6, 87); // Trọng lượng sản phẩm
        seedDataVariantAtribute("Vỏ máy: Nhôm tái chế", 7, 87); // Chất liệu
        seedDataVariantAtribute("Apple M2", 9, 87); // CPU Model
        seedDataVariantAtribute("8 - Core", 10, 87); // Loại CPU
        seedDataVariantAtribute("8", 11, 87); // Số nhân
        seedDataVariantAtribute("8 GB", 79, 87); // Dung lượng RAM
        seedDataVariantAtribute("11 inch", 14, 87); // Kích thước màn hình
        seedDataVariantAtribute("Liquid Retina", 15, 87); // Công nghệ màn hình
        seedDataVariantAtribute("2360 x 1640 Pixels", 17, 87); // Độ phân giải
        seedDataVariantAtribute("Liquid Retina", 16, 87); // Chuẩn màn hình
        seedDataVariantAtribute("500 nits", 20, 87); // Độ sáng
        seedDataVariantAtribute("Ultra Wide", 27, 87); // Camera Type 1
        seedDataVariantAtribute("12.0 MP", 28, 87); // Resolution (Camera 1)
        seedDataVariantAtribute("ƒ/1.8", 29, 87); // Aperture (Camera 1)
        seedDataVariantAtribute("FullHD 1060p@120fps, FullHD 1060p@30fps, FullHD 1060p@240fps, 4K 2160p@60fps, 4K 2160p@25fps, 4K 2160p@24fps, 4K 2160p@30fps, HD 720p@30fps, FullHD 1060p@25fps, FullHD 1060p@60fps", 30, 87); // Quay phim camera sau
        seedDataVariantAtribute("Single selfie camera", 32, 87); // Số Camera Selfie
        seedDataVariantAtribute("12.0 MP", 33, 87); // Resolution (Camera Selfie 1)
        seedDataVariantAtribute("ƒ/2.4", 34, 87); // Aperture (Camera Selfie 1)
        seedDataVariantAtribute("Quay phim FullHD", 34, 87); // Quay phim camera selfie
        seedDataVariantAtribute("Trôi nhanh thời gian (Time lapse), Chụp góc rộng (Wide)", 35, 87); // Tính năng camera selfie

        // màu trắng
        seedDataProduct("iPad Air 11 inch M2 2024 Wifi Trắng 512GB", "Ipad", 0.462, 13, 3, 3, "iPadAir11inchM22024Wifi128GBtrang.jpg");
        seedDataVariant("/src/assets/products/iPadAir11inchM22024Wifi128GBtrang.jpg", " iPad Air 11 inch M2 2024 Wifi Trắng 512GB" ,26999995.0 , 8, 69);
        seedDataVariantAtribute("Trắng", 3, 88); // Thông tin hàng hóa - Màu sắc
        seedDataVariantAtribute("512 GB", 24, 88); // Dung lượng
        seedDataVariantAtribute("Việt Nam / Trung Quốc", 1, 88); // Xuất xứ
        seedDataVariantAtribute("05/2024", 2, 88); // Thời điểm ra mắt
        seedDataVariantAtribute("12", 4, 88); // Thời gian bảo hành (tháng)
        seedDataVariantAtribute("Để nơi khô ráo, nhẹ tay, dễ vỡ. Xem trong sách hướng dẫn sử dụng", 48, 88); // Hướng dẫn bảo quản và sử dụng
        seedDataVariantAtribute("247.6 x 178.5 x 6.1 mm", 5, 88); // Kích thước
        seedDataVariantAtribute("462 g", 6, 88); // Trọng lượng sản phẩm
        seedDataVariantAtribute("Vỏ máy: Nhôm tái chế", 7, 88); // Chất liệu
        seedDataVariantAtribute("Apple M2", 9, 88); // CPU Model
        seedDataVariantAtribute("8 - Core", 10, 88); // Loại CPU
        seedDataVariantAtribute("8", 11, 88); // Số nhân
        seedDataVariantAtribute("8 GB", 79, 88); // Dung lượng RAM
        seedDataVariantAtribute("11 inch", 14, 88); // Kích thước màn hình
        seedDataVariantAtribute("Liquid Retina", 15, 88); // Công nghệ màn hình
        seedDataVariantAtribute("2360 x 1640 Pixels", 17, 88); // Độ phân giải
        seedDataVariantAtribute("Liquid Retina", 16, 88); // Chuẩn màn hình
        seedDataVariantAtribute("500 nits", 20, 88); // Độ sáng
        seedDataVariantAtribute("Ultra Wide", 27, 88); // Camera Type 1
        seedDataVariantAtribute("12.0 MP", 28, 88); // Resolution (Camera 1)
        seedDataVariantAtribute("ƒ/1.8", 29, 88); // Aperture (Camera 1)
        seedDataVariantAtribute("FullHD 1060p@120fps, FullHD 1060p@30fps, FullHD 1060p@240fps, 4K 2160p@60fps, 4K 2160p@25fps, 4K 2160p@24fps, 4K 2160p@30fps, HD 720p@30fps, FullHD 1060p@25fps, FullHD 1060p@60fps", 30, 88); // Quay phim camera sau
        seedDataVariantAtribute("Single selfie camera", 32, 88); // Số Camera Selfie
        seedDataVariantAtribute("12.0 MP", 33, 88); // Resolution (Camera Selfie 1)
        seedDataVariantAtribute("ƒ/2.4", 34, 88); // Aperture (Camera Selfie 1)
        seedDataVariantAtribute("Quay phim FullHD", 34, 88); // Quay phim camera selfie

        // màu đen
        seedDataProduct("iPad Air 11 inch M2 2024 Wifi Xám 1TB", "Ipad", 0.462, 13, 3, 3, "iPadAir11inchM22024Wifi128GBxam.jpg");
        seedDataVariant("/src/assets/products/iPadAir11inchM22024Wifi128GBxam.jpg", " iPad Air 11 inch M2 2024 Wifi Xám 1TB" ,28999995.0 , 8, 70);
        seedDataVariantAtribute("Xám", 3, 89); // Thông tin hàng hóa - Màu sắc
        seedDataVariantAtribute("1TB", 24, 89); // Dung lượng
        seedDataVariantAtribute("Việt Nam / Trung Quốc", 1, 89); // Xuất xứ
        seedDataVariantAtribute("05/2024", 2, 89); // Thời điểm ra mắt
        seedDataVariantAtribute("12", 4, 89); // Thời gian bảo hành (tháng)
        seedDataVariantAtribute("Để nơi khô ráo, nhẹ tay, dễ vỡ. Xem trong sách hướng dẫn sử dụng", 48, 89); // Hướng dẫn bảo quản và sử dụng
        seedDataVariantAtribute("247.6 x 178.5 x 6.1 mm", 5, 89); // Kích thước
        seedDataVariantAtribute("462 g", 6, 89); // Trọng lượng sản phẩm
        seedDataVariantAtribute("Vỏ máy: Nhôm tái chế", 7, 89); // Chất liệu
        seedDataVariantAtribute("Apple M2", 9, 89); // CPU Model
        seedDataVariantAtribute("8 - Core", 10, 89); // Loại CPU
        seedDataVariantAtribute("8", 11, 89); // Số nhân
        seedDataVariantAtribute("8 GB", 79, 89); // Dung lượng RAM
        seedDataVariantAtribute("11 inch", 14, 89); // Kích thước màn hình
        seedDataVariantAtribute("Liquid Retina", 15, 89); // Công nghệ màn hình
        seedDataVariantAtribute("2360 x 1640 Pixels", 17, 89); // Độ phân giải
        seedDataVariantAtribute("Liquid Retina", 16, 89); // Chuẩn màn hình
        seedDataVariantAtribute("500 nits", 20, 89); // Độ sán
        seedDataVariantAtribute("Ultra Wide", 27, 89); // Camera Type 1
        seedDataVariantAtribute("12.0 MP", 28, 89); // Resolution (Camera 1)
        seedDataVariantAtribute("ƒ/1.8", 29, 89); // Aperture (Camera 1)
        seedDataVariantAtribute("FullHD 1060p@120fps, FullHD 1060p@30fps, FullHD 1060p@240fps, 4K 2160p@60fps, 4K 2160p@25fps, 4K 2160p@24fps, 4K 2160p@30fps, HD 720p@30fps, FullHD 1060p@25fps, FullHD 1060p@60fps", 30, 89); // Quay phim camera sau
        seedDataVariantAtribute("Single selfie camera", 32, 89); // Số Camera Selfie
        seedDataVariantAtribute("12.0 MP", 33, 89); // Resolution (Camera Selfie 1)
        seedDataVariantAtribute("ƒ/2.4", 34, 89); // Aperture (Camera Selfie 1)
        seedDataVariantAtribute("Quay phim FullHD", 34, 89); // Quay phim camera selfie
        seedDataVariantAtribute("Trôi nhanh thời gian (Time lapse), Chụp góc rộng (Wide)", 35, 89); // Tính năng camera selfie
        seedDataVariantAtribute("Cảm biến vân tay, Con quay hồi chuyển, Cảm biến gia tốc kế, Cảm biến khí áp kế, Cảm biến ánh sáng", 36, 89); // Cảm biến

        // màu trắng
        seedDataProduct("iPad Air 11 inch M2 2024 Wifi Trắng 1TB ", "Ipad", 0.462, 13, 3, 3, "iPadAir11inchM22024Wifi128GBtrang.jpg");
        seedDataVariant("/src/assets/products/iPadAir11inchM22024Wifi128GBtrang.jpg", "iPad Air 11 inch M2 2024 Wifi Trắng 1TB" ,28999994.0 , 8, 71);
        seedDataVariantAtribute("Trắng", 3, 90); // Thông tin hàng hóa - Màu sắc
        seedDataVariantAtribute("1TB", 24, 90); // Dung lượng
        seedDataVariantAtribute("Việt Nam / Trung Quốc", 1, 90); // Xuất xứ
        seedDataVariantAtribute("05/2024", 2, 90); // Thời điểm ra mắt
        seedDataVariantAtribute("12", 4, 90); // Thời gian bảo hành (tháng)
        seedDataVariantAtribute("Để nơi khô ráo, nhẹ tay, dễ vỡ. Xem trong sách hướng dẫn sử dụng", 48, 90); // Hướng dẫn bảo quản và sử dụng
        seedDataVariantAtribute("247.6 x 178.5 x 6.1 mm", 5, 90); // Kích thước
        seedDataVariantAtribute("462 g", 6, 90); // Trọng lượng sản phẩm
        seedDataVariantAtribute("Vỏ máy: Nhôm tái chế", 7, 90); // Chất liệu
        seedDataVariantAtribute("Apple M2", 9, 90); // CPU Model
        seedDataVariantAtribute("8 - Core", 10, 90); // Loại CPU
        seedDataVariantAtribute("8", 11, 90); // Số nhân
        seedDataVariantAtribute("8 GB", 79, 90); // Dung lượng RAM
        seedDataVariantAtribute("11 inch", 14, 90); // Kích thước màn hình
        seedDataVariantAtribute("Liquid Retina", 15, 90); // Công nghệ màn hình
        seedDataVariantAtribute("2360 x 1640 Pixels", 17, 90); // Độ phân giải
        seedDataVariantAtribute("Liquid Retina", 16, 90); // Chuẩn màn hình
        seedDataVariantAtribute("500 nits", 20, 90); // Độ sáng
        seedDataVariantAtribute("Ultra Wide", 27, 90); // Camera Type 1
        seedDataVariantAtribute("12.0 MP", 28, 90); // Resolution (Camera 1)
        seedDataVariantAtribute("ƒ/1.8", 29, 90); // Aperture (Camera 1)
        seedDataVariantAtribute("FullHD 1060p@120fps, FullHD 1060p@30fps, FullHD 1060p@240fps, 4K 2160p@60fps, 4K 2160p@25fps, 4K 2160p@24fps, 4K 2160p@30fps, HD 720p@30fps, FullHD 1060p@25fps, FullHD 1060p@60fps", 30, 90); // Quay phim camera sau
        seedDataVariantAtribute("Single selfie camera", 32, 90); // Số Camera Selfie
        seedDataVariantAtribute("12.0 MP", 33, 90); // Resolution (Camera Selfie 1)
        seedDataVariantAtribute("ƒ/2.4", 34, 90); // Aperture (Camera Selfie 1)
        seedDataVariantAtribute("Quay phim FullHD", 34, 90); // Quay phim camera selfie
        seedDataVariantAtribute("Trôi nhanh thời gian (Time lapse), Chụp góc rộng (Wide)", 35, 90); // Tính năng camera selfie
        seedDataVariantAtribute("Cảm biến vân tay, Con quay hồi chuyển, Cảm biến gia tốc kế, Cảm biến khí áp kế, Cảm biến ánh sáng", 36, 90); // Cảm biến
        seedDataVariantAtribute("Mật khẩu", 37, 90); // Bảo mật
        seedDataVariantAtribute("5G", 39, 90); // Hỗ trợ mạng
        seedDataVariantAtribute("Cổng sạc: Type C", 41, 90); // Cổng giao tiếp
        seedDataVariantAtribute("Wifi 6E", 42, 90); // Wifi
        seedDataVariantAtribute("v5.3", 44, 90); // Bluetooth
        seedDataVariantAtribute("Lithium polymer", 47, 90); // Loại PIN
        seedDataVariantAtribute("28.93 Wh", 48, 90); // Dung lượng pin
        seedDataVariantAtribute("iPadOS", 49, 90); // OS
        seedDataVariantAtribute("iPadOS 17", 50, 90); // Version
        seedDataVariantAtribute("Dây cáp sạc, Củ sạc iPad", 57, 90); // Phụ kiện trong hộp

        // màu trắng
        // iPad Air 13 inch M2 2024 Wifi 128GB

        seedDataProduct("iPad Air 13 inch M2 2024 Wifi Trắng 512GB", "Ipad", 0.462, 13, 3, 3, "iPadAir13inchM22024Wifi128GBtrang.jpg");
        seedDataVariant("/src/assets/products/iPadAir13inchM22024Wifi128GBtrang.jpg", "iPad Air 13 inch M2 2024 Wifi Trắng 512GB" ,26999005.0 , 8, 72);
        seedDataVariantAtribute("Trắng", 3, 91); // Thông tin hàng hóa - Màu sắc
        seedDataVariantAtribute("Việt Nam / Trung Quốc", 1, 91); // Xuất xứ
        seedDataVariantAtribute("05/2024", 2, 91); // Thời điểm ra mắt
        seedDataVariantAtribute("12", 4, 91); // Thời gian bảo hành (tháng)
        seedDataVariantAtribute("Để nơi khô ráo, nhẹ tay, dễ vỡ. Xem trong sách hướng dẫn sử dụng", 48, 91); // Hướng dẫn bảo quản và sử dụng
        seedDataVariantAtribute("280.6 x 214.9 x 6.1 mm", 5, 91); // Kích thước
        seedDataVariantAtribute("617 g", 6, 91); // Trọng lượng sản phẩm
        seedDataVariantAtribute("Vỏ máy: Nhôm tái chế", 7, 91); // Chất liệu
        seedDataVariantAtribute("Apple M2", 9, 91); // CPU Model
        seedDataVariantAtribute("8 - Core", 10, 91); // Loại CPU
        seedDataVariantAtribute("Apple M2 8 nhân", 10, 91); // CPU
        seedDataVariantAtribute("8", 11, 91); // Số nhân
        seedDataVariantAtribute("8 GB", 79, 91); // Dung lượng RAM
        seedDataVariantAtribute("13 inch", 14, 91); // Kích thước màn hình
        seedDataVariantAtribute("2732 x 2048 Pixels", 17, 91); // Độ phân giải
        seedDataVariantAtribute("Liquid Retina", 16, 91); // Chuẩn màn hình
        seedDataVariantAtribute("600 nits", 20, 91); // Độ sáng
        seedDataVariantAtribute("Single rear camera", 27, 91); // Số camera sau
        seedDataVariantAtribute("Ultra Wide", 27, 91); // Camera Type 1
        seedDataVariantAtribute("12.0 MP", 28, 91); // Resolution (Camera 1)
        seedDataVariantAtribute("ƒ/2.4", 29, 91); // Aperture (Camera 1)
        seedDataVariantAtribute("4K 2160p@30fps, HD 720p@30fps, FullHD 1060p@60fps, FullHD 1060p@30fps, FullHD 1060p@25fps, FullHD 1060p@240fps, FullHD 1060p@120fps, 4K 2160p@60fps, 4K 2160p@25fps, 4K 2160p@24fps", 30, 91); // Quay phim camera sau
        seedDataVariantAtribute("Single selfie camera", 32, 91); // Số Camera Selfie
        seedDataVariantAtribute("12.0 MP", 33, 91); // Resolution (Camera Selfie 1)
        seedDataVariantAtribute("ƒ/2.4", 34, 91); // Aperture (Camera Selfie 1)
        seedDataVariantAtribute("Quay phim FullHD", 34, 91); // Quay phim camera selfie

        // màu trắng
        seedDataProduct("iPad Air 13 inch M2 2024 Wifi Trắng 1TB", "Ipad", 0.462, 13, 3, 3, "iPadAir13inchM22024Wifi128GBtrang.jpg");
        seedDataVariant("/src/assets/products/iPadAir13inchM22024Wifi128GBtrang.jpg", "iPad Air 13 inch M2 2024 Wifi Trắng 1TB" ,28999009.0 , 8, 73);
        seedDataVariantAtribute("1TB", 24, 92); // Dung lượng
        seedDataVariantAtribute("Trắng", 3, 92); // Thông tin hàng hóa - Màu sắc
        seedDataVariantAtribute("Việt Nam / Trung Quốc", 1, 92); // Xuất xứ
        seedDataVariantAtribute("05/2024", 2, 92); // Thời điểm ra mắt
        seedDataVariantAtribute("12", 4, 92); // Thời gian bảo hành (tháng)
        seedDataVariantAtribute("Để nơi khô ráo, nhẹ tay, dễ vỡ. Xem trong sách hướng dẫn sử dụng", 48, 92); // Hướng dẫn bảo quản và sử dụng
        seedDataVariantAtribute("280.6 x 214.9 x 6.1 mm", 5, 92); // Kích thước
        seedDataVariantAtribute("617 g", 6, 92); // Trọng lượng sản phẩm
        seedDataVariantAtribute("Vỏ máy: Nhôm tái chế", 7, 92); // Chất liệu
        seedDataVariantAtribute("Apple M2", 9, 92); // CPU Model
        seedDataVariantAtribute("8 - Core", 10, 92); // Loại CPU
        seedDataVariantAtribute("Apple M2 8 nhân", 10, 92); // CPU
        seedDataVariantAtribute("8", 11, 92); // Số nhân
        seedDataVariantAtribute("8 GB", 79, 92); // Dung lượng RAM
        seedDataVariantAtribute("13 inch", 14, 92); // Kích thước màn hình
        seedDataVariantAtribute("2732 x 2048 Pixels", 17, 92); // Độ phân giải
        seedDataVariantAtribute("Liquid Retina", 16, 92); // Chuẩn màn hình
        seedDataVariantAtribute("600 nits", 20, 92); // Độ sáng

        seedDataVariantAtribute("Single rear camera", 27, 92); // Số camera sau
        seedDataVariantAtribute("Ultra Wide", 27, 92); // Camera Type 1
        seedDataVariantAtribute("12.0 MP", 28, 92); // Resolution (Camera 1)
        seedDataVariantAtribute("ƒ/2.4", 29, 92); // Aperture (Camera 1)
        seedDataVariantAtribute("4K 2160p@30fps, HD 720p@30fps, FullHD 1060p@60fps, FullHD 1060p@30fps, FullHD 1060p@25fps, FullHD 1060p@240fps, FullHD 1060p@120fps, 4K 2160p@60fps, 4K 2160p@25fps, 4K 2160p@24fps", 30, 92); // Quay phim camera sau
        seedDataVariantAtribute("Single selfie camera", 32, 92); // Số Camera Selfie
        seedDataVariantAtribute("12.0 MP", 33, 92); // Resolution (Camera Selfie 1)
        seedDataVariantAtribute("ƒ/2.4", 34, 92); // Aperture (Camera Selfie 1)
        seedDataVariantAtribute("Quay phim FullHD", 34, 92); // Quay phim camera selfie
        seedDataVariantAtribute("Trôi nhanh thời gian (Time lapse), Chụp góc rộng (Wide)", 35, 92); // Tính năng camera selfie
        seedDataVariantAtribute("Cảm biến vân tay, Con quay hồi chuyển, Cảm biến gia tốc kế, Cảm biến khí áp kế, Cảm biến ánh sáng", 36, 92); // Cảm biến
        seedDataVariantAtribute("Mật khẩu", 37, 92); // Bảo mật
        seedDataVariantAtribute("5G", 39, 92); // Hỗ trợ mạng
        seedDataVariantAtribute("Type C", 41, 92); // Cổng giao tiếp
        seedDataVariantAtribute("Wifi 6E", 42, 92); // Wifi
        seedDataVariantAtribute("v5.3", 44, 92); // Bluetooth
        seedDataVariantAtribute("Lithium polymer", 47, 92); // Loại PIN
        seedDataVariantAtribute("36.59 Wh", 48, 92); // Dung lượng pin
        seedDataVariantAtribute("iPadOS", 49, 92); // OS
        seedDataVariantAtribute("iPadOS 17", 50, 92); // Version
        seedDataVariantAtribute("Dây cáp sạc, Củ sạc iPad", 57, 92); // Phụ kiện trong hộp

//
        // iPad Pro 11 inch M4 2024 Wifi + Cellular 256GB
        // iPad Air 11 inch M2 2024
        seedDataProduct("iPad Pro 11 inch M4 2024 Wifi Đen 256GB", "Ipad", 0.466, 13, 3, 3, "iPadPro11inchM42024Wifi256GBĐen.jpg");
        seedDataVariant("/src/assets/products/iPadPro11inchM42024Wifi256GBĐen.jpg", "iPad Pro 11 inch M4 2024 Wifi Đen 256GB" ,33999011.0 , 8, 74);
        // màu đen
        seedDataVariantAtribute("256GB", 24, 93); // Dung lượng
        seedDataVariantAtribute("Đen", 3, 93); // Thông tin hàng hóa - Màu sắc
        seedDataVariantAtribute("Việt Nam / Trung Quốc", 1, 93); // Xuất xứ
        seedDataVariantAtribute("05/2024", 2, 93); // Thời điểm ra mắt
        seedDataVariantAtribute("12", 4, 93); // Thời gian bảo hành (tháng)
        seedDataVariantAtribute("Để nơi khô ráo, nhẹ tay, dễ vỡ. Xem trong sách hướng dẫn sử dụng", 48, 93); // Hướng dẫn bảo quản và sử dụng
        seedDataVariantAtribute("249.7 x 177.5 x 5.3 mm", 5, 93); // Kích thước
        seedDataVariantAtribute("446 g", 6, 93); // Trọng lượng sản phẩm
        seedDataVariantAtribute("Vỏ máy: Nhôm tái chế", 7, 93); // Chất liệu
        seedDataVariantAtribute("Apple M4", 9, 93); // CPU Model
        seedDataVariantAtribute("10 - Core, Apple M4 10 nhân", 10, 93); // Loại CPU & CPU
        seedDataVariantAtribute("10", 11, 93); // Số nhân
        seedDataVariantAtribute("8 GB", 79, 93); // Dung lượng RAM
        seedDataVariantAtribute("11 inch", 14, 93); // Kích thước màn hình
        seedDataVariantAtribute("OLED", 15, 93); // Công nghệ màn hình
        seedDataVariantAtribute("2752 x 2064 pixel", 17, 93); // Độ phân giải
        seedDataVariantAtribute("Ultra Liquid Retina XDR", 16, 93); // Chuẩn màn hình
        seedDataVariantAtribute("1000 nits", 20, 93); // Độ sáng
        seedDataVariantAtribute("2.000.000:1", 21, 93); // Độ tương phản
        seedDataVariantAtribute("Double rear camera, Camera Type 1: Ultra Wide, Camera Type 2: Wide", 27, 93); // Số camera sau và Camera Type
        seedDataVariantAtribute("Resolution (Camera 1): 12.0 MP, Resolution (Camera 2): 12.0 MP", 28, 93); // Độ phân giải Camera
        seedDataVariantAtribute("Aperture (Camera 1): ƒ/2.4, Aperture (Camera 2): ƒ/1.8", 29, 93); // Độ mở Camera
        seedDataVariantAtribute("4K 2160p@30fps, HD 720p@30fps, FullHD 1060p@60fps, FullHD 1060p@30fps, FullHD 1060p@25fps, 4K 2160p@60fps, 4K 2160p@25fps, 4K 2160p@24fps", 30, 93); // Quay phim camera sau
        seedDataVariantAtribute("Single selfie camera", 32, 93); // Số Camera Selfie

//        // màu đen
        seedDataProduct("iPad Pro 11 inch M4 2024 Wifi Đen 512GB", "Ipad", 0.466, 13, 3, 3, "iPadPro11inchM42024Wifi256GBĐen.jpg");
        seedDataVariant("/src/assets/products/iPadPro11inchM42024Wifi256GBĐen.jpg", " iPad Pro 11 inch M4 2024 Wifi Đen 512GB" ,33999012.0 , 8, 75);
        seedDataVariantAtribute("Đen", 3, 94); // Thông tin hàng hóa - Màu sắc
        seedDataVariantAtribute("512GB", 24, 94); // Dung lượng
        seedDataVariantAtribute("Việt Nam / Trung Quốc", 1, 94); // Xuất xứ
        seedDataVariantAtribute("05/2024", 2, 94); // Thời điểm ra mắt
        seedDataVariantAtribute("12", 4, 94); // Thời gian bảo hành (tháng)
        seedDataVariantAtribute("Để nơi khô ráo, nhẹ tay, dễ vỡ. Xem trong sách hướng dẫn sử dụng", 48, 94); // Hướng dẫn bảo quản và sử dụng
        seedDataVariantAtribute("249.7 x 177.5 x 5.3 mm", 5, 94); // Kích thước
        seedDataVariantAtribute("446 g", 6, 94); // Trọng lượng sản phẩm
        seedDataVariantAtribute("Vỏ máy: Nhôm tái chế", 7, 94); // Chất liệu
        seedDataVariantAtribute("Apple M4", 9, 94); // CPU Model
        seedDataVariantAtribute("10 - Core, Apple M4 10 nhân", 10, 94); // Loại CPU & CPU
        seedDataVariantAtribute("10", 11, 94); // Số nhân
        seedDataVariantAtribute("8 GB", 79, 94); // Dung lượng RAM
        seedDataVariantAtribute("11 inch", 14, 94); // Kích thước màn hình
        seedDataVariantAtribute("OLED", 15, 94); // Công nghệ màn hình
        seedDataVariantAtribute("2752 x 2064 pixel", 17, 94); // Độ phân giải
        seedDataVariantAtribute("Ultra Liquid Retina XDR", 16, 94); // Chuẩn màn hình
        seedDataVariantAtribute("1000 nits", 20, 94); // Độ sáng
        seedDataVariantAtribute("2.000.000:1", 21, 94); // Độ tương phản
        seedDataVariantAtribute("Double rear camera, Camera Type 1: Ultra Wide, Camera Type 2: Wide", 27, 94); // Số camera sau và Camera Type
        seedDataVariantAtribute("Resolution (Camera 1): 12.0 MP, Resolution (Camera 2): 12.0 MP", 28, 94); // Độ phân giải Camera
        seedDataVariantAtribute("Aperture (Camera 1): ƒ/2.4, Aperture (Camera 2): ƒ/1.8", 29, 94); // Độ mở Camera
        seedDataVariantAtribute("4K 2160p@30fps, HD 720p@30fps, FullHD 1060p@60fps, FullHD 1060p@30fps, FullHD 1060p@25fps, 4K 2160p@60fps, 4K 2160p@25fps, 4K 2160p@24fps", 30, 94); // Quay phim camera sau
        seedDataVariantAtribute("Single selfie camera", 32, 94); // Số Camera Selfie
        seedDataVariantAtribute("Quay phim FullHD", 34, 94); // Quay phim camera selfie

//
//

        // iPad mini 6 2021 8.3 inch WiFi 64GB
        seedDataProduct("iPad mini 6 2021 8.3 inch WiFi Xám 64GB", "Ipad", 0.462, 13, 3, 3, "iPadmini620218.3inchWiFi64GBxam.jpg");
        seedDataVariant("/src/assets/products/iPadmini620218.3inchWiFi64GBxam.jpg", " iPad mini 6 2021 8.3 inch WiFi Xám 64GB" ,12999018.0 , 8, 76);
        seedDataVariantAtribute("Xám", 3, 95); // Thông tin hàng hóa - Màu sắc
        seedDataVariantAtribute("64GB", 24, 95); // Dung lượng
        seedDataVariantAtribute("Trung Quốc", 1, 95); // Xuất xứ
        seedDataVariantAtribute("09/2021", 2, 95); // Thời điểm ra mắt
        seedDataVariantAtribute("12", 4, 95); // Thời gian bảo hành (tháng)
        seedDataVariantAtribute("134.8 x 6.3 x 195.4 mm", 5, 95); // Kích thước
        seedDataVariantAtribute("293 g", 6, 95); // Trọng lượng sản phẩm
        seedDataVariantAtribute("70%", 13, 95); // Tỷ lệ diện tích sử dụng màn hình
        seedDataVariantAtribute("Không", 18, 95); // Chuẩn kháng nước / Bụi bẩn
        seedDataVariantAtribute("Nhôm nguyên khối", 7, 95); // Chất liệu
        seedDataVariantAtribute("Apple A15 Bionic", 9, 95); // CPU Model
        seedDataVariantAtribute("Hexa-Core, 2 x 2.5 GHz Vortex + 4 x 1.6 GHz Tempest", 10, 95); // Loại CPU & CPU
        seedDataVariantAtribute("6", 11, 95); // Số nhân
        seedDataVariantAtribute("2.5 GHz", 12, 95); // Tốc độ tối đa
        seedDataVariantAtribute("4 GB", 79, 95); // Dung lượng RAM
        seedDataVariantAtribute("LPDDR4X", 66, 95); // Loại RAM
        seedDataVariantAtribute("8.3 inch", 14, 95); // Kích thước màn hình
        seedDataVariantAtribute("IPS LCD", 15, 95); // Công nghệ màn hình
        seedDataVariantAtribute("2048 x 1536 Pixels", 17, 95); // Độ phân giải
        seedDataVariantAtribute("Liquid Retina HD", 16, 95); // Chuẩn màn hình
        seedDataVariantAtribute("16 Triệu", 78, 95); // Màu màn hình
        seedDataVariantAtribute("Kính cường lực Oleophobic", 62, 95); // Chất liệu mặt kính
        seedDataVariantAtribute("Điện dung đa điểm", 63, 95); // Loại cảm ứng
        seedDataVariantAtribute("324 ppi", 22, 95); // Mật độ điểm ảnh
        seedDataVariantAtribute("4:3", 26, 95); // Tỷ lệ màn hình
        seedDataVariantAtribute("Apple GPU 5 nhân", 24, 95); // Chip đồ hoạ (GPU)
        seedDataVariantAtribute("467.478", 80, 95); // ANTUTU
        seedDataVariantAtribute("Tùy bộ nhớ", 82, 95); // Danh bạ lưu trữ
        seedDataVariantAtribute("Không", 83, 95); // Thẻ nhớ ngoài
        seedDataVariantAtribute("Standard", 27, 95); // Camera Type 1
        seedDataVariantAtribute("12.0 MP", 28, 95); // Resolution (Camera 1)
        seedDataVariantAtribute("ƒ/1.8", 29, 95); // Aperture (Camera 1)
        seedDataVariantAtribute("Tự động lấy nét (AF), ISO Setting, Nhận diện khuôn mặt, Trôi nhanh thời gian (Time Lapse), Gắn thẻ ảnh địa lý, Zoom kỹ thuật số, Cài đặt cân bằng trắng, Toàn cảnh (Panorama), HDR, Quay chậm (Slow Motion)", 35, 95); // Tính năng camera sau
        seedDataVariantAtribute("Single selfie camera", 32, 95); // Số Camera Selfie
        seedDataVariantAtribute("12.0 MP", 33, 95); // Resolution (Camera Selfie 1)
        seedDataVariantAtribute("Quay phim HD", 34, 95); // Quay phim camera selfie


        seedDataProduct("iPad mini 6 2021 8.3 inch WiFi Hồng 256GB", "Ipad", 0.462, 13, 3, 3, "iPadmini620218.3inchWiFi64GBhong.jpg");
        seedDataVariant("/src/assets/products/iPadmini620218.3inchWiFi64GBhong.jpg", " iPad mini 6 2021 8.3 inch WiFi Hồng 256GB" ,16999018.0 , 8, 77);
        seedDataVariantAtribute("Hồng", 3, 96); // Thông tin hàng hóa - Màu sắc
        seedDataVariantAtribute("256GB", 24, 96); // Dung lượng
        seedDataVariantAtribute("Trung Quốc", 1, 96); // Xuất xứ
        seedDataVariantAtribute("09/2021", 2, 96); // Thời điểm ra mắt
        seedDataVariantAtribute("12", 4, 96); // Thời gian bảo hành (tháng)
        seedDataVariantAtribute("134.8 x 6.3 x 195.4 mm", 5, 96); // Kích thước
        seedDataVariantAtribute("293 g", 6, 96); // Trọng lượng sản phẩm
        seedDataVariantAtribute("70%", 13, 96); // Tỷ lệ diện tích sử dụng màn hình
        seedDataVariantAtribute("Không", 18, 96); // Chuẩn kháng nước / Bụi bẩn
        seedDataVariantAtribute("Nhôm nguyên khối", 7, 96); // Chất liệu
        seedDataVariantAtribute("Apple A15 Bionic", 9, 96); // CPU Model
        seedDataVariantAtribute("Hexa-Core, 2 x 2.5 GHz Vortex + 4 x 1.6 GHz Tempest", 10, 96); // Loại CPU & CPU
        seedDataVariantAtribute("6", 11, 96); // Số nhân
        seedDataVariantAtribute("2.5 GHz", 12, 96); // Tốc độ tối đa
        seedDataVariantAtribute("4 GB", 79, 96); // Dung lượng RAM
        seedDataVariantAtribute("LPDDR4X", 66, 96); // Loại RAM
        seedDataVariantAtribute("8.3 inch", 14, 96); // Kích thước màn hình
        seedDataVariantAtribute("IPS LCD", 15, 96); // Công nghệ màn hình
        seedDataVariantAtribute("2048 x 1536 Pixels", 17, 96); // Độ phân giải
        seedDataVariantAtribute("Liquid Retina HD", 16, 96); // Chuẩn màn hình
        seedDataVariantAtribute("16 Triệu", 78, 96); // Màu màn hình
        seedDataVariantAtribute("Kính cường lực Oleophobic", 62, 96); // Chất liệu mặt kính
        seedDataVariantAtribute("Điện dung đa điểm", 63, 96); // Loại cảm ứng
        seedDataVariantAtribute("324 ppi", 22, 96); // Mật độ điểm ảnh
        seedDataVariantAtribute("4:3", 26, 96); // Tỷ lệ màn hình
        seedDataVariantAtribute("Apple GPU 5 nhân", 24, 96); // Chip đồ hoạ (GPU)
        seedDataVariantAtribute("467.478", 80, 96); // ANTUTU
        seedDataVariantAtribute("Tùy bộ nhớ", 82, 96); // Danh bạ lưu trữ
        seedDataVariantAtribute("Không", 83, 96); // Thẻ nhớ ngoài
        seedDataVariantAtribute("Standard", 27, 96); // Camera Type 1
        seedDataVariantAtribute("12.0 MP", 28, 96); // Resolution (Camera 1)
        seedDataVariantAtribute("ƒ/1.8", 29, 96); // Aperture (Camera 1)
        seedDataVariantAtribute("Tự động lấy nét (AF), ISO Setting, Nhận diện khuôn mặt, Trôi nhanh thời gian (Time Lapse), Gắn thẻ ảnh địa lý, Zoom kỹ thuật số, Cài đặt cân bằng trắng, Toàn cảnh (Panorama), HDR, Quay chậm (Slow Motion)", 35, 96); // Tính năng camera sau


        // Samsung Galaxy Tab S10 Plus Wifi 12GB 256GB

        seedDataProduct("Samsung Galaxy Tab S10 Plus Wifi Xám 12GB", "Ipad", 0.571, 22, 3, 3, "SamsungGalaxyTabS10Ultra5G12GB256GBxam.png");

        seedDataVariant("/src/assets/products/SamsungGalaxyTabS10Ultra5G12GB256GBxam.png", "Samsung Galaxy Tab S10 Plus Wifi Xám 12GB" ,25999018.0 , 8, 78);
        seedDataVariantAtribute("256 GB", 24, 97); // Dung lượng
        seedDataVariantAtribute("Xám", 3, 97); // Thông tin hàng hóa - Màu sắc
        seedDataVariantAtribute("Việt Nam / Trung Quốc", 1, 97); // Xuất xứ
        seedDataVariantAtribute("10/2024", 2, 97); // Thời điểm ra mắt
        seedDataVariantAtribute("12", 4, 97); // Thời gian bảo hành (tháng)
        seedDataVariantAtribute("Để nơi khô ráo, nhẹ tay, dễ vỡ. Xem trong sách hướng dẫn sử dụng", 48, 97); // Hướng dẫn bảo quản và sử dụng
        seedDataVariantAtribute("Dài 285.4 mm - Ngang 185.4 mm - Dày 5.7 mm", 5, 97); // Kích thước
        seedDataVariantAtribute("571 g", 6, 97); // Trọng lượng sản phẩm
        seedDataVariantAtribute("IP68", 18, 97); // Chuẩn kháng nước / Bụi bẩn
        seedDataVariantAtribute("Khung viền: Armor aluminum, Mặt lưng máy: Armor aluminum", 7, 97); // Chất liệu
        seedDataVariantAtribute("Dimensity 9300+", 9, 97); // CPU Model
        seedDataVariantAtribute("8", 11, 97); // Số nhân
        seedDataVariantAtribute("12 GB", 79, 97); // Dung lượng RAM
        seedDataVariantAtribute("12.4 inch", 14, 97); // Kích thước màn hình
        seedDataVariantAtribute("Dynamic AMOLED 2X", 15, 97); // Công nghệ màn hình
        seedDataVariantAtribute("1752 x 2800 Pixels", 17, 97); // Độ phân giải
        seedDataVariantAtribute("Dynamic AMOLED 2X", 16, 97); // Chuẩn màn hình
        seedDataVariantAtribute("16 Triệu", 78, 97); // Màu màn hình
        seedDataVariantAtribute("120", 22, 97); // Tần số quét
        seedDataVariantAtribute("Không giới hạn", 82, 97); // Danh bạ lưu trữ
        seedDataVariantAtribute("MicroSD", 83, 97); // Thẻ nhớ ngoài
        seedDataVariantAtribute("1.5 TB", 84, 97); // Hỗ trợ thẻ nhớ tối đa
        seedDataVariantAtribute("Double rear camera", 27, 97); // Số camera sau
        seedDataVariantAtribute("Resolution (Camera 1): 13.0 MP, Resolution (Camera 2): 8.0 MP", 28, 97); // Độ phân giải Camera
        seedDataVariantAtribute("4K 2160p@30fps", 30, 97); // Quay phim
        seedDataVariantAtribute("Tự động lấy nét (AF), Quét tài liệu, Xóa phông, Chụp góc siêu rộng (Ultrawide), Trôi nhanh thời gian (Time Lapse), Toàn cảnh (Panorama), Chuyên nghiệp (Pro), HDR", 35, 97); // Tính năng camera sau
        seedDataVariantAtribute("Single selfie camera", 32, 97); // Số Camera Selfie
        seedDataVariantAtribute("12.0 MP", 33, 97); // Resolution (Camera Selfie)

        // Samsung Galaxy Tab S10 Ultra 5G 12GB 256GB
        seedDataProduct("Samsung Galaxy Tab S10 Ultra 5G Xám 12GB", "Ipad", 0.571, 22, 3, 3, "SamsungGalaxyTabS10Ultra5G12GB256GBxam.png");
        seedDataVariant("/src/assets/products/SamsungGalaxyTabS10Ultra5G12GB256GBxam.png", "Samsung Galaxy Tab S10 Ultra 5G Xám 12GB" ,33999018.0 , 8, 79);
        seedDataVariantAtribute("256 GB", 24, 98); // Dung lượng
        seedDataVariantAtribute("Xám", 3, 98); // Thông tin hàng hóa - Màu sắc
        seedDataVariantAtribute("Việt Nam / Trung Quốc", 1, 98); // Xuất xứ
        seedDataVariantAtribute("10/2024", 2, 98); // Thời điểm ra mắt
        seedDataVariantAtribute("12", 4, 98); // Thời gian bảo hành (tháng)
        seedDataVariantAtribute("Để nơi khô ráo, nhẹ tay, dễ vỡ.", 48, 98); // Hướng dẫn bảo quản
        seedDataVariantAtribute("Dài 326.4 mm - Ngang 208.6 mm - Dày 5.4 mm", 5, 98); // Kích thước
        seedDataVariantAtribute("723 g", 6, 98); // Trọng lượng sản phẩm
        seedDataVariantAtribute("IP68", 18, 98); // Chuẩn kháng nước / Bụi bẩn
        seedDataVariantAtribute("Khung màn hình: Armor aluminum, Mặt lưng máy: Armor aluminum", 7, 98); // Chất liệu
        seedDataVariantAtribute("Dimensity 9300+", 9, 98); // CPU Model
        seedDataVariantAtribute("8", 11, 98); // Số nhân
        seedDataVariantAtribute("12 GB", 79, 98); // Dung lượng RAM
        seedDataVariantAtribute("14.6 inch", 14, 98); // Kích thước màn hình
        seedDataVariantAtribute("2960 x 1848 Pixels", 17, 98); // Độ phân giải
        seedDataVariantAtribute("Dynamic AMOLED 2X", 16, 98); // Chuẩn màn hình
        seedDataVariantAtribute("16 Triệu", 78, 98); // Màu màn hình
        seedDataVariantAtribute("Corning Gorilla Glass", 62, 98); // Chất liệu mặt kính
        seedDataVariantAtribute("Không giới hạn", 82, 98); // Danh bạ lưu trữ
        seedDataVariantAtribute("MicroSD", 83, 98); // Thẻ nhớ ngoài
        seedDataVariantAtribute("1.5 TB", 84, 98); // Hỗ trợ thẻ nhớ tối đa
        seedDataVariantAtribute("Double rear camera", 27, 98); // Số camera sau
        seedDataVariantAtribute("Resolution (Camera 1): 13.0 MP, Resolution (Camera 2): 8.0 MP", 28, 98); // Độ phân giải Camera
        seedDataVariantAtribute("4K 2160p@30fps", 30, 98); // Quay phim
        seedDataVariantAtribute("Tự động lấy nét (AF), Zoom quang học, Zoom kỹ thuật số, Xóa phông, Chụp góc siêu rộng (Ultrawide), Trôi nhanh thời gian (Time Lapse), Toàn cảnh (Panorama), Chuyên nghiệp (Pro), HDR, Quét tài liệu", 35, 98); // Tính năng camera sau
        seedDataVariantAtribute("Single selfie camera", 32, 98); // Số Camera Selfie
        seedDataVariantAtribute("12.0 MP", 33, 98); // Resolution (Camera Selfie)
        seedDataVariantAtribute("Chế độ chân dung, Xóa phông, Làm đẹp (Beautify), Chụp góc rộng (Wide), Bộ lọc màu, Hẹn giờ chụp tự động", 35, 98); // Tính năng camera selfie
        seedDataVariantAtribute("Mở khóa vân tay dưới màn hình", 37, 98); // Bảo mật
        seedDataVariantAtribute("1", 38, 98); // Số khe SIM


        // Samsung Galaxy Tab S9 FE WiFi 6GB 128GB
        seedDataProduct("Samsung Galaxy Tab S9 FE WiFi 6GB Xám 128GB", "Ipad", 0.571, 22, 3, 3, "SamsungGalaxyTabS9FEWiFi6GB128GBxam.jpg");
        seedDataVariant("/src/assets/products/SamsungGalaxyTabS9FEWiFi6GB128GBxam.jpg", "Samsung Galaxy Tab S9 FE WiFi 6GB Xám 128GB" ,9999018.0 , 8, 80);
        seedDataVariantAtribute("128 GB", 24, 99); // Dung lượng
        seedDataVariantAtribute("Xám", 3, 99); // Thông tin hàng hóa - Màu sắc
        seedDataVariantAtribute("Việt Nam / Trung Quốc", 1, 99); // Xuất xứ
        seedDataVariantAtribute("10/2023", 2, 99); // Thời điểm ra mắt
        seedDataVariantAtribute("12", 4, 99); // Thời gian bảo hành (tháng)
        seedDataVariantAtribute("Để nơi khô ráo, nhẹ tay, dễ vỡ. Xem trong sách hướng dẫn sử dụng", 48, 99); // Hướng dẫn bảo quản và sử dụng
        seedDataVariantAtribute("254.3 x 165.8 x 6.5 mm", 5, 99); // Kích thước
        seedDataVariantAtribute("520 g", 6, 99); // Trọng lượng sản phẩm
        seedDataVariantAtribute("IP68", 18, 99); // Chuẩn kháng nước / Bụi bẩn
        seedDataVariantAtribute("Mặt lưng máy: Kim loại", 7, 99); // Chất liệu
        seedDataVariantAtribute("Exynos 1380", 9, 99); // CPU Model
        seedDataVariantAtribute("8 x 2.4 GHz", 10, 99); // CPU
        seedDataVariantAtribute("8", 11, 99); // Số nhân
        seedDataVariantAtribute("2.4 GHz", 12, 99); // Tốc độ tối đa
        seedDataVariantAtribute("6 GB", 79, 99); // Dung lượng RAM
        seedDataVariantAtribute("10.9 inch", 14, 99); // Kích thước màn hình
        seedDataVariantAtribute("LCD", 15, 99); // Công nghệ màn hình
        seedDataVariantAtribute("2304 x 1440 Pixels", 17, 99); // Độ phân giải
        seedDataVariantAtribute("WUXGA", 16, 99); // Chuẩn màn hình
        seedDataVariantAtribute("16 Triệu", 78, 99); // Màu màn hình
        seedDataVariantAtribute("Điện dung đa điểm", 63, 99); // Loại cảm ứng
        seedDataVariantAtribute("90 Hz", 22, 99); // Tần số quét
        seedDataVariantAtribute("HDR10+", 73, 99); // Độ phủ màu
        seedDataVariantAtribute("16:10", 26, 99); // Tỷ lệ màn hình
        seedDataVariantAtribute("Không giới hạn", 82, 99); // Danh bạ lưu trữ
        seedDataVariantAtribute("1 TB", 84, 99); // Hỗ trợ thẻ nhớ tối đa
        seedDataVariantAtribute("Double rear camera", 27, 99); // Số camera sau
        seedDataVariantAtribute("Resolution (Camera 1): 8.0 MP, Resolution (Camera 2): 8.0 MP", 28, 99); // Độ phân giải Camera
        seedDataVariantAtribute("4K 2160p@30fps", 30, 99); // Quay phim
        seedDataVariantAtribute("Tự động lấy nét (AF), HDR, Chuyên nghiệp (Pro), Xóa phông, Toàn cảnh (Panorama), Chụp chuyển động, Chạm lấy nét, Làm đẹp (Beautify), Chụp góc siêu rộng (Ultrawide), Zoom kỹ thuật số", 35, 99); // Tính năng camera sau
        seedDataVariantAtribute("Single selfie camera", 32, 99); // Số Camera Selfie
        seedDataVariantAtribute("12.0 MP", 33, 99); // Resolution (Camera Selfie)
        seedDataVariantAtribute("Chụp góc rộng (Wide), HDR, Xoá phông, Bộ lọc màu, Flash màn hình", 35, 99); // Tính năng camera selfie
        seedDataVariantAtribute("Cảm biến gia tốc, Cảm biến ánh sáng", 36, 99); // Cảm biến
        seedDataVariantAtribute("Mở khóa vân tay", 37, 99); // Bảo mật

        // Samsung Galaxy Tab S9 FE Plus WiFi 8GB 128GB
        seedDataProduct("Samsung Galaxy Tab S9 FE Plus WiFi 8GB Bạc 128GB", "Ipad", 0.571, 22, 3, 3, "SamsungGalaxyTabS9FEWiFi6GB128GBbac.jpg");
        seedDataVariant("/src/assets/products/SamsungGalaxyTabS9FEWiFi6GB128GBbac.jpg", "Samsung Galaxy Tab S9 FE Plus WiFi 8GB Bạc 128GB " ,9999918.0 , 8, 81);
        seedDataVariantAtribute("128 GB", 24, 100); // Dung lượng
        seedDataVariantAtribute("Bạc", 3, 100); // Thông tin hàng hóa - Màu sắc
        seedDataVariantAtribute("Việt Nam / Trung Quốc", 1, 100); // Xuất xứ
        seedDataVariantAtribute("10/2023", 2, 100); // Thời điểm ra mắt
        seedDataVariantAtribute("12", 4, 100); // Thời gian bảo hành (tháng)
        seedDataVariantAtribute("Để nơi khô ráo, nhẹ tay, dễ vỡ. Xem trong sách hướng dẫn sử dụng", 48, 100); // Hướng dẫn bảo quản và sử dụng
        seedDataVariantAtribute("285.4 x 185.4 x 6.5 mm", 5, 100); // Kích thước
        seedDataVariantAtribute("627 g", 6, 100); // Trọng lượng sản phẩm
        seedDataVariantAtribute("IP68", 18, 100); // Chuẩn kháng nước / Bụi bẩn
        seedDataVariantAtribute("Mặt lưng máy: Kim loại", 7, 100); // Chất liệu
        seedDataVariantAtribute("Exynos 1380", 9, 100); // CPU Model
        seedDataVariantAtribute("8 x 2.4 GHz", 10, 100); // CPU
        seedDataVariantAtribute("8", 11, 100); // Số nhân
        seedDataVariantAtribute("2.4 GHz", 12, 100); // Tốc độ tối đa
        seedDataVariantAtribute("8 GB", 79, 100); // Dung lượng RAM
        seedDataVariantAtribute("12.4 inch", 14, 100); // Kích thước màn hình
        seedDataVariantAtribute("PLS LCD", 15, 100); // Công nghệ màn hình
        seedDataVariantAtribute("2560 x 1600 Pixels", 17, 100); // Độ phân giải
        seedDataVariantAtribute("WQXGA", 16, 100); // Chuẩn màn hình
        seedDataVariantAtribute("16 Triệu", 78, 100); // Màu màn hình
        seedDataVariantAtribute("Điện dung đa điểm", 63, 100); // Loại cảm ứng
        seedDataVariantAtribute("90 Hz", 22, 100); // Tần số quét
        seedDataVariantAtribute("16:10", 26, 100); // Tỷ lệ màn hình

        seedDataVariantAtribute("MicroSD", 83, 100); // Thẻ nhớ ngoài
        seedDataVariantAtribute("1 TB", 84, 100); // Hỗ trợ thẻ nhớ tối đa
        seedDataVariantAtribute("Double rear camera", 27, 100); // Số camera sau
        seedDataVariantAtribute("Wide", 27, 100); // Camera
        seedDataVariantAtribute("Resolution (Camera 1): 8.0 MP, Resolution (Camera 2): 8.0 MP", 28, 100); // Độ phân giải Camera
        seedDataVariantAtribute("4K 2160p@30fps", 30, 100); // Quay phim
        seedDataVariantAtribute("HDR, Bộ lọc màu, Chuyên nghiệp (Pro), Xóa phông, Toàn cảnh (Panorama), Trôi nhanh thời gian (Time Lapse), Chụp chuyển động, Chạm lấy nét, Làm đẹp (Beautify), Zoom kỹ thuật số, Tự động lấy nét (AF), Ban đêm (Night Mode)", 35, 100); // Tính năng camera sau
        seedDataVariantAtribute("Single selfie camera", 32, 100); // Số Camera Selfie
        seedDataVariantAtribute("12.0 MP", 33, 100); // Resolution (Camera Selfie)
        seedDataVariantAtribute("Tự động lấy nét (AF), Xoá phông, HDR, Chuyên nghiệp (Pro), Chụp góc rộng (Wide)", 35, 100); // Tính năng camera selfie
        seedDataVariantAtribute("Cảm biến gia tốc, Cảm biến ánh sáng", 36, 100); // Cảm biến
        seedDataVariantAtribute("Mở khóa vân tay", 37, 100); // Bảo mật


        // Xiaomi Pad 6S Pro WiFi 8GB 256GB
        seedDataProduct("Xiaomi Pad 6S Pro WiFi 8GB Xám 256GB", "Ipad", 0.571, 23, 3, 3, "XiaomiPad6SProWiFi8GB256GB.png");
        seedDataVariant("/src/assets/products/XiaomiPad6SProWiFi8GB256GB.png", "Xiaomi Pad 6S Pro WiFi 8GB Xám 256GB" ,12999118.0 , 8, 82);
        seedDataVariantAtribute("256GB", 24, 101); // Dung lượng
        seedDataVariantAtribute("Xám", 3, 101); // Thông tin hàng hóa - Màu sắc
        seedDataVariantAtribute("Việt Nam", 1, 101); // Xuất xứ
        seedDataVariantAtribute("09/2024", 2, 101); // Thời điểm ra mắt
        seedDataVariantAtribute("18", 4, 101); // Thời gian bảo hành (tháng)
        seedDataVariantAtribute("278.7 x 191.58 x 6.26 mm", 5, 101); // Kích thước
        seedDataVariantAtribute("590 g", 6, 101); // Trọng lượng sản phẩm
        seedDataVariantAtribute("88.5%", 13, 101); // Tỷ lệ diện tích sử dụng màn hình
        seedDataVariantAtribute("Hợp kim nhôm", 7, 101); // Chất liệu
        seedDataVariantAtribute("Snapdragon 8 Gen 2", 9, 101); // CPU Model
        seedDataVariantAtribute("8", 11, 101); // Số nhân
        seedDataVariantAtribute("8 GB", 79, 101); // Dung lượng RAM
        seedDataVariantAtribute("12.4 inch", 14, 101); // Kích thước màn hình
        seedDataVariantAtribute("2032 x 3048 Pixels", 17, 101); // Độ phân giải
        seedDataVariantAtribute("3K", 16, 101); // Chuẩn màn hình
        seedDataVariantAtribute("Hơn 68 tỷ màu", 78, 101); // Màu màn hình
        seedDataVariantAtribute("Corning Gorilla Glass", 62, 101); // Chất liệu mặt kính
        seedDataVariantAtribute("294 ppi", 22, 101); // Mật độ điểm ảnh
        seedDataVariantAtribute("144", 23, 101); // Tần số quét
        seedDataVariantAtribute("900 nits", 20, 101); // Độ sáng
        seedDataVariantAtribute("100% DCI-P3", 73, 101); // Độ phủ màu
        seedDataVariantAtribute("3:2", 26, 101); // Tỷ lệ màn hình
        seedDataVariantAtribute("1400:1", 21, 101); // Độ tương phản
        seedDataVariantAtribute("Double rear camera", 27, 101); // Số camera sau
        seedDataVariantAtribute("Resolution (Camera 1): 50 MP, Aperture (Camera 1): ƒ/1.8, Pixel size (Camera 1): 0.64 µm", 28, 101); // Camera 1
        seedDataVariantAtribute("Resolution (Camera 2): 2.0 MP, Aperture (Camera 2): ƒ/2.4, Pixel size (Camera 2): 1.75 µm", 28, 101); // Camera 2
        seedDataVariantAtribute("1060p@60fps, 1060p@30fps, 720p@30fps", 30, 101); // Quay phim camera sau
        seedDataVariantAtribute("32.0 MP", 33, 101); // Resolution (Camera Selfie)
        seedDataVariantAtribute("ƒ/2.2", 34, 101); // Aperture (Camera Selfie)

        // Xiaomi Pad 6 WiFi 8GB 256GB
        seedDataProduct("Xiaomi Red Mi Pad 6 WiFi 16GB Xám 256GB", "Ipad", 0.571, 23, 3, 3, "2023_8_9_638271866314863589_xiaomi-pad-6-xanh-3.jpg");
        seedDataVariant("/src/assets/products/2023_8_9_638271910620849769_xiaomi-pad-6-den-3.jpg", "Xiaomi Red Mi Pad 6 WiFi 16GB Xám 256GB " ,9299019.0 , 8, 83);
        seedDataVariantAtribute("256GB", 24, 102); // Dung lượng
        seedDataVariantAtribute("Xám", 3, 102); // Thông tin hàng hóa - Màu sắc
        seedDataVariantAtribute("Trung Quốc", 1, 102); // Xuất xứ
        seedDataVariantAtribute("08/2023", 2, 102); // Thời điểm ra mắt
        seedDataVariantAtribute("18", 4, 102); // Thời gian bảo hành (tháng)
        seedDataVariantAtribute("Để nơi khô ráo, nhẹ tay, dễ vỡ. Xem trong sách hướng dẫn sử dụng", 48, 102); // Hướng dẫn bảo quản và sử dụng
        seedDataVariantAtribute("253.95 x 165.18 x 6.51 mm", 5, 102); // Kích thước
        seedDataVariantAtribute("490 g", 6, 102); // Trọng lượng sản phẩm
        seedDataVariantAtribute("Khung máy: Kim loại", 7, 102); // Chất liệu
        seedDataVariantAtribute("Snapdragon 870", 9, 102); // CPU Model
        seedDataVariantAtribute("8", 11, 102); // Số nhân
        seedDataVariantAtribute("3.20 GHz", 12, 102); // Tốc độ tối đa
        seedDataVariantAtribute("8 GB", 79, 102); // Dung lượng RAM
        seedDataVariantAtribute("LPDDR4X", 66, 102); // Loại RAM
        seedDataVariantAtribute("11.0 inch", 14, 102); // Kích thước màn hình
        seedDataVariantAtribute("IPS LCD", 15, 102); // Công nghệ màn hình
        seedDataVariantAtribute("2880 x 1800 Pixels", 17, 102); // Độ phân giải
        seedDataVariantAtribute("WQHD+", 16, 102); // Chuẩn màn hình
        seedDataVariantAtribute("144 Hz", 23, 102); // Tần số quét
        seedDataVariantAtribute("Không", 83, 102); // Thẻ nhớ ngoài
        seedDataVariantAtribute("Single rear camera", 27, 102); // Số camera sau
        seedDataVariantAtribute("Standard", 27, 102); // Camera
        seedDataVariantAtribute("13.0 MP", 28, 102); // Resolution (Camera)
        seedDataVariantAtribute("ƒ/1.9", 29, 102); // Aperture (Camera)


        // màu đen
        seedDataProduct("Xiaomi Pad 6 WiFi 8GB Đen 256GB", "Ipad", 0.571, 23, 3, 3, "XiaomiPad6SProWiFi8GB256GB.png");
        seedDataVariant("/src/assets/products/XiaomiPad6SProWiFi8GB256GB.png", "Xiaomi Pad 6 WiFi 8GB Đen 256GB" ,9299020.0 , 8, 84);
        seedDataVariantAtribute("256GB", 24, 103); // Dung lượng
        seedDataVariantAtribute("Đen", 3, 103); // Thông tin hàng hóa - Màu sắc
        seedDataVariantAtribute("Trung Quốc", 1, 103); // Xuất xứ
        seedDataVariantAtribute("08/2023", 2, 103); // Thời điểm ra mắt
        seedDataVariantAtribute("18", 4, 103); // Thời gian bảo hành (tháng)
        seedDataVariantAtribute("Để nơi khô ráo, nhẹ tay, dễ vỡ. Xem trong sách hướng dẫn sử dụng", 48, 103); // Hướng dẫn bảo quản và sử dụng
        seedDataVariantAtribute("253.95 x 165.18 x 6.51 mm", 5, 103); // Kích thước
        seedDataVariantAtribute("490 g", 6, 103); // Trọng lượng sản phẩm
        seedDataVariantAtribute("Khung máy: Kim loại", 7, 103); // Chất liệu
        seedDataVariantAtribute("Snapdragon 870", 9, 103); // CPU Model
        seedDataVariantAtribute("8", 11, 103); // Số nhân
        seedDataVariantAtribute("3.20 GHz", 12, 103); // Tốc độ tối đa
        seedDataVariantAtribute("8 GB", 79, 103); // Dung lượng RAM
        seedDataVariantAtribute("LPDDR4X", 66, 103); // Loại RAM
        seedDataVariantAtribute("11.0 inch", 14, 103); // Kích thước màn hình
        seedDataVariantAtribute("IPS LCD", 15, 103); // Công nghệ màn hình
        seedDataVariantAtribute("2880 x 1800 Pixels", 17, 103); // Độ phân giải
        seedDataVariantAtribute("WQHD+", 16, 103); // Chuẩn màn hình
        seedDataVariantAtribute("144 Hz", 23, 103); // Tần số quét
        seedDataVariantAtribute("Không", 83, 103); // Thẻ nhớ ngoài
        seedDataVariantAtribute("Single rear camera", 27, 103); // Số camera sau
        seedDataVariantAtribute("Standard", 27, 103); // Camera
        seedDataVariantAtribute("13.0 MP", 28, 103); // Resolution (Camera)
        seedDataVariantAtribute("ƒ/1.9", 29, 103); // Aperture (Camera)
        seedDataVariantAtribute("1060p@30fps, 720p@30fps", 30, 103); // Quay phim camera sau
        seedDataVariantAtribute("8.0 MP", 33, 103); // Resolution (Camera Selfie)
        seedDataVariantAtribute("ƒ/2.1", 34, 103); // Aperture (Camera Selfie)
        seedDataVariantAtribute("Quay phim HD, Quay phim FullHD", 30, 103); // Quay phim camera selfie
        seedDataVariantAtribute("Bộ lọc màu, HDR, Tự động lấy nét (AF)", 35, 103); // Tính năng camera selfie

        //Xiaomi Redmi Pad Pro WiFi 8GB 128GB
        seedDataProduct("Xiaomi Redmi Pad Pro WiFi 8GB Xám 128GB", "Ipad", 0.571, 23, 3, 3, "XiaomiRedmiPadProWiFi8GB128GBxam.jpg");
        seedDataVariant("/src/assets/products/XiaomiRedmiPadProWiFi8GB128GBxam.jpg", "Xiaomi Redmi Pad Pro WiFi 8GB Xám 128GB" ,9299021.0 , 8, 85);

        seedDataVariantAtribute("128GB", 24, 104); // Dung lượng
        seedDataVariantAtribute("Xám", 3, 104); // Thông tin hàng hóa - Màu sắc
        seedDataVariantAtribute("Trung Quốc", 1, 104); // Xuất xứ
        seedDataVariantAtribute("06/2024", 2, 104); // Thời điểm ra mắt
        seedDataVariantAtribute("18", 4, 104); // Thời gian bảo hành (tháng)
        seedDataVariantAtribute("280 x 181.85 x 7.52 mm", 5, 104); // Kích thước
        seedDataVariantAtribute("571 g", 6, 104); // Trọng lượng sản phẩm
        seedDataVariantAtribute("83.60%", 13, 104); // Tỷ lệ diện tích sử dụng màn hình
        seedDataVariantAtribute("Khung máy: Kim loại", 7, 104); // Chất liệu
        seedDataVariantAtribute("Snapdragon 7s Gen 2", 9, 104); // CPU Model
        seedDataVariantAtribute("Octa-Core", 10, 104); // Loại CPU
        seedDataVariantAtribute("8", 11, 104); // Số nhân
        seedDataVariantAtribute("2.4 GHz", 12, 104); // Tốc độ tối đa
        seedDataVariantAtribute("8 GB", 79, 104); // Dung lượng RAM
        seedDataVariantAtribute("LPDDR4X", 66, 104); // Loại RAM
        seedDataVariantAtribute("12.1 inch", 14, 104); // Kích thước màn hình
        seedDataVariantAtribute("LCD", 15, 104); // Công nghệ màn hình
        seedDataVariantAtribute("1600 x 2560 Pixels", 17, 104); // Độ phân giải
        seedDataVariantAtribute("2.5K", 16, 104); // Chuẩn màn hình
        seedDataVariantAtribute("Hơn 68 tỷ màu", 78, 104); // Màu màn hình
        seedDataVariantAtribute("Gorilla Glass 3", 62, 104); // Chất liệu mặt kính
        seedDataVariantAtribute("249PPI", 22, 104); // Mật độ điểm ảnh
        seedDataVariantAtribute("120", 23, 104); // Tần số quét
        seedDataVariantAtribute("600 nits", 20, 104); // Độ sáng
        seedDataVariantAtribute("16:10", 26, 104); // Tỷ lệ màn hình
        seedDataVariantAtribute("1500:1", 21, 104); // Độ tương phản
        seedDataVariantAtribute("Khoảng 105 GB", 85, 104); // Bộ nhớ còn lại
        seedDataVariantAtribute("MicroSD", 83, 104); // Thẻ nhớ ngoài
        seedDataVariantAtribute("1.5 TB", 84, 104); // Hỗ trợ thẻ nhớ tối đa
        seedDataVariantAtribute("Single rear camera", 27, 104); // Số camera sau
        seedDataVariantAtribute("Standard", 27, 104); // Camera

        // Xiaomi Poco Pad WiFi 8GB 256GB
        seedDataProduct("Xiaomi Poco Pad WiFi 8GB Xám 256GB", "Ipad", 0.571, 23, 3, 3, "XiaomiRedmiPadProWiFi8GB128GBxam.jpg");
        seedDataVariant("/src/assets/products/XiaomiPocoPadWiFi8GBxam.jpg", "Xiaomi Poco Pad WiFi 8GB Xám 256GB" ,7299021.0 , 8, 86);
        seedDataVariantAtribute("256GB", 24, 105); // Dung lượng
        seedDataVariantAtribute("Xám", 3, 105); // Thông tin hàng hóa - Màu sắc
        seedDataVariantAtribute("Trung Quốc", 1, 105); // Xuất xứ
        seedDataVariantAtribute("06/2024", 2, 105); // Thời điểm ra mắt
        seedDataVariantAtribute("18", 4, 105); // Thời gian bảo hành (tháng)
        seedDataVariantAtribute("280 x 181.85 x 7.52 mm", 5, 105); // Kích thước
        seedDataVariantAtribute("571 g", 6, 105); // Trọng lượng sản phẩm
        seedDataVariantAtribute("83.60%", 13, 105); // Tỷ lệ diện tích sử dụng màn hình
        seedDataVariantAtribute("Khung máy: Kim loại", 7, 105); // Chất liệu
        seedDataVariantAtribute("Snapdragon 7s Gen 2", 9, 105); // CPU Model
        seedDataVariantAtribute("Octa-Core", 10, 105); // Loại CPU
        seedDataVariantAtribute("8", 11, 105); // Số nhân
        seedDataVariantAtribute("2.4 GHz", 12, 105); // Tốc độ tối đa
        seedDataVariantAtribute("8 GB", 79, 105); // Dung lượng RAM
        seedDataVariantAtribute("LPDDR4X", 66, 105); // Loại RAM
        seedDataVariantAtribute("12.1 inch", 14, 105); // Kích thước màn hình
        seedDataVariantAtribute("LCD", 15, 105); // Công nghệ màn hình
        seedDataVariantAtribute("1600 x 2560 Pixels", 17, 105); // Độ phân giải
        seedDataVariantAtribute("2.5K", 16, 105); // Chuẩn màn hình
        seedDataVariantAtribute("Hơn 68 tỷ màu", 78, 105); // Màu màn hình
        seedDataVariantAtribute("Gorilla Glass 3", 62, 105); // Chất liệu mặt kính
        seedDataVariantAtribute("249PPI", 22, 105); // Mật độ điểm ảnh
        seedDataVariantAtribute("120", 23, 105); // Tần số quét
        seedDataVariantAtribute("600 nits", 20, 105); // Độ sáng
        seedDataVariantAtribute("16:10", 26, 105); // Tỷ lệ màn hình
        seedDataVariantAtribute("1500:1", 21, 105); // Độ tương phản
        seedDataVariantAtribute("Khoảng 230 GB", 85, 105); // Bộ nhớ còn lại


        // Tai nghe AirPods Pro 2022
        seedDataProduct("Tai nghe AirPods Pro 2022 ", "Apple", 0.571, 14, 8, 3, "TaingheAirPodsPro2022.jpg");
        seedDataVariant("/src/assets/products/TaingheAirPodsPro2022.jpg", " Tai nghe AirPods Pro 2022 Trắng",5299021.0, 8, 87);
        seedDataVariantAtribute("AirPods Pro 2", 87, 106); // Model
        seedDataVariantAtribute("Trung Quốc", 1, 106); // Xuất xứ
        seedDataVariantAtribute("12", 4, 106); // Thời gian bảo hành (tháng)
        seedDataVariantAtribute("Để nơi khô ráo, nhẹ tay, dễ vỡ. Xem trong sách hướng dẫn sử dụng", 48, 106); // Hướng dẫn bảo quản và sử dụng
        seedDataVariantAtribute("Trắng", 3, 106); // Màu sắc
        seedDataVariantAtribute("50.8 g", 6, 106); // Trọng lượng sản phẩm
        seedDataVariantAtribute("Tai nghe không dây : Bluetooth", 86, 106); // Loại tai nghe
        seedDataVariantAtribute("v5.3", 44, 106); // Bluetooth
        seedDataVariantAtribute("Chống ồn, Sạc không dây", 35, 106); // Tính năng
        seedDataVariantAtribute("macOS", 49, 106); // Hệ điều hành tương thích
        seedDataVariantAtribute("Dây cáp sạc", 57, 106); // Phụ kiện đi kèm
//
        // Tai nghe AirPods 3 2022 Hộp sạc dây
        seedDataProduct("Tai nghe AirPods 3", "Apple", 0.571, 14, 8, 3, "TaingheAirPods32022.jpg");
        seedDataVariant("/src/assets/products/TaingheAirPods32022.jpg", "Tai nghe AirPods 3 2022 Trắng ", 4099021.0, 8, 88);
        seedDataVariantAtribute("AirPods 3", 87, 107); // Model
        seedDataVariantAtribute("Trung Quốc", 1, 107); // Xuất xứ
        seedDataVariantAtribute("12", 4, 107); // Thời gian bảo hành (tháng)
        seedDataVariantAtribute("Để nơi khô ráo, nhẹ tay, dễ vỡ. Xem trong sách hướng dẫn sử dụng", 48, 107); // Hướng dẫn bảo quản và sử dụng
        seedDataVariantAtribute("Trắng", 3, 107); // Màu sắc
        seedDataVariantAtribute("54.4 x 21.38 x 46.40 mm", 5, 107); // Kích thước
        seedDataVariantAtribute("37.91 g", 6, 107); // Trọng lượng sản phẩm
        seedDataVariantAtribute("Tai nghe không dây : Bluetooth", 86, 107); // Loại tai nghe
        seedDataVariantAtribute("3 - 5 giờ", 48, 107); // Thời gian sử dụng/1 lần sạc
        seedDataVariantAtribute("6 Giờ", 47, 107); // Dung lượng pin
        seedDataVariantAtribute("v5.0", 44, 107); // Bluetooth
        seedDataVariantAtribute("Cổng sạc: Lightning", 41, 107); // Cổng giao tiếp
        seedDataVariantAtribute("Nghe nhạc, Chống nước", 35, 107); // Tính năng
        seedDataVariantAtribute("iOS", 49, 107); // Hệ điều hành tương thích
        seedDataVariantAtribute("Sách HDSD, Cáp", 57, 107); // Phụ kiện đi kèm

//         Tai nghe AirPods Pro 2023 USB-C
        seedDataProduct("Tai nghe AirPods Pro 2023 USB-C", "Apple", 0.571, 14, 8, 3, "TaingheAirPodsPro2023USB-C.jpg");
        seedDataVariant("/src/assets/products/TaingheAirPodsPro2023USB-C.jpg", "Tai nghe AirPods Pro 2023 USB-C Trắng" , 5799021.0, 10, 89);
        seedDataVariantAtribute("AirPods Pro", 87, 108); // Model
        seedDataVariantAtribute("Trắng", 3, 108); // Thông tin hàng hóa - Màu sắc
        seedDataVariantAtribute("Trung Quốc", 1, 108); // Xuất xứ
        seedDataVariantAtribute("12", 4, 108); // Thời gian bảo hành (tháng)
        seedDataVariantAtribute("Trắng", 3, 108); // Màu sắc
        seedDataVariantAtribute("Tai nghe không dây", 86, 108); // Loại tai nghe
        seedDataVariantAtribute("Chống ồn, Sạc không dây", 35, 108); // Tính năng
        seedDataVariantAtribute("Dây cáp sạc", 57, 108); // Phụ kiện đi kèm

        // Tai nghe AirPods 4 - Chủ Động Khử Tiếng Ồn
        seedDataProduct("Tai nghe AirPods 4", "Apple", 0.571, 14, 8, 3, "TaingheAirPods4.jpg");
        seedDataVariant("/src/assets/products/TaingheAirPods4.jpg", "Tai nghe AirPods 4 Trắng", 4799021.0, 10, 90);
        seedDataVariantAtribute("AirPods 4", 87, 109); // Model
        seedDataVariantAtribute("Trung Quốc", 1, 109); // Xuất xứ
        seedDataVariantAtribute("12", 4, 109); // Thời gian bảo hành (tháng)
        seedDataVariantAtribute("Trắng", 3, 109); // Màu sắc
        seedDataVariantAtribute("240 g", 6, 109); // Trọng lượng sản phẩm
        seedDataVariantAtribute("Tai nghe không dây : Bluetooth", 86, 109); // Loại tai nghe
        seedDataVariantAtribute("5 Giờ", 47, 109); // Dung lượng pin
        seedDataVariantAtribute("Cổng sạc: USB Type-C", 41, 109); // Cổng giao tiếp
        seedDataVariantAtribute("Chế độ xuyên âm, Sạc không dây, Chống ồn, Nghe nhạc, Kháng nước IP54", 35, 109); // Tính năng
        seedDataVariantAtribute("Sách HDSD, Hộp sạc không dây", 57, 109); // Phụ kiện đi kèm

        // Tai nghe Apple EarPods 2023 USB-C
        seedDataProduct("Tai nghe Apple EarPods USB-C", "Apple", 0.031, 14, 8, 3, "TaingheAppleEarPodsUSB-C.jpg");

        seedDataVariant("/src/assets/products/TaingheAppleEarPodsUSB-C.jpg", "Tai nghe Apple EarPods USB-C Trắng " , 599000.0, 10, 91);
        seedDataVariantAtribute("EarPods (USB-C)", 87, 110); // Model
        seedDataVariantAtribute("Trung Quốc", 1, 110); // Xuất xứ
        seedDataVariantAtribute("12", 4, 110); // Thời gian bảo hành (tháng)
        seedDataVariantAtribute("Xem trong sách hướng dẫn sử dụng", 48, 110); // Hướng dẫn sử dụng
        seedDataVariantAtribute("Trắng", 3, 110); // Màu sắc
        seedDataVariantAtribute("31 g", 6, 110); // Trọng lượng sản phẩm
        seedDataVariantAtribute("Tai nghe nhét tai", 86, 110); // Loại tai nghe
        seedDataVariantAtribute("Điều khiển cuộc gọi, Điều khiển nhạc, Chống ồn", 45, 110); // Tính năng

        // Tai nghe Beats Studio Buds
        seedDataProduct("Tai nghe Beats Studio Buds Hồng", "Apple", 0.058, 14, 8, 3, "TaingheBeatsStudioBudsDen.jpg");

        seedDataVariant("/src/assets/products/TaingheBeatsStudioBudsHong.jpg", "Beats Studio Buds Hồng",3199001.0, 10, 92);
        seedDataVariantAtribute("Beats Studio Buds", 87, 111); // Model
        seedDataVariantAtribute("Trung Quốc", 1, 111); // Xuất xứ
        seedDataVariantAtribute("12", 4, 111); // Thời gian bảo hành (tháng)
        seedDataVariantAtribute("Để nơi khô ráo, nhẹ tay, dễ vỡ. Xem trong sách hướng dẫn sử dụng", 48, 111); // Hướng dẫn bảo quản và sử dụng
        seedDataVariantAtribute("Hồng", 3, 111); // Màu sắc
        seedDataVariantAtribute("58 g", 6, 111); // Trọng lượng sản phẩm
        seedDataVariantAtribute("Tai nghe không dây : Bluetooth", 86, 111); // Loại tai nghe
        seedDataVariantAtribute("Chống nước, Chống ồn", 35, 111); // Tính năng
        seedDataVariantAtribute("TVOS", 49, 111); // Hệ điều hành tương thích
        seedDataVariantAtribute("Cáp USB-C to USB-C", 48, 111); // Phụ kiện đi kèm

        seedDataProduct("Tai nghe Beats Studio Buds Đen", "Apple", 0.058, 14, 8, 3, "TaingheBeatsStudioBudsHong.jpg");
        seedDataVariant("/src/assets/products/TaingheBeatsStudioBudsHong.jpg", "Beats Studio Buds Đen", 3199000.0, 10, 93);
        seedDataVariantAtribute("Beats Studio Buds", 87, 112); // Model
        seedDataVariantAtribute("Trung Quốc", 1, 112); // Xuất xứ
        seedDataVariantAtribute("12", 4, 112); // Thời gian bảo hành (tháng)
        seedDataVariantAtribute("Để nơi khô ráo, nhẹ tay, dễ vỡ. Xem trong sách hướng dẫn sử dụng", 48, 112); // Hướng dẫn bảo quản và sử dụng
        seedDataVariantAtribute("Đen", 3, 112); // Màu sắc
        seedDataVariantAtribute("58 g", 6, 112); // Trọng lượng sản phẩm
        seedDataVariantAtribute("Tai nghe không dây : Bluetooth", 86, 112); // Loại tai nghe
        seedDataVariantAtribute("Chống nước, Chống ồn", 35, 112); // Tính năng
        seedDataVariantAtribute("TVOS", 49, 112); // Hệ điều hành tương thích
        seedDataVariantAtribute("Cáp USB-C to USB-C", 48, 112); // Phụ kiện đi kèm
//

        // Tai nghe AirPods Max
        seedDataProduct("Tai nghe AirPods Max Bạc", "Apple", 0.1, 14, 8, 3, "TaingheAirPodsMaxBac.jpg");

        seedDataVariant("/src/assets/products/TaingheAirPodsMaxBac.jpg"," Tai nghe AirPods Max Bạc" ,  12199005.0, 10, 94);
        seedDataVariantAtribute("Tai nghe AirPods Max", 87, 113); // Model
        seedDataVariantAtribute("Trung Quốc", 1, 113); // Xuất xứ
        seedDataVariantAtribute("12", 4, 113); // Thời gian bảo hành (tháng)
        seedDataVariantAtribute("Bạc", 3, 113); // Màu sắc
        seedDataVariantAtribute("187.3 x 168.6 x 83.4 mm", 5, 113); // Kích thước
        seedDataVariantAtribute("Vải, Khung máy: Kim loại", 7, 113); // Chất liệu
        seedDataVariantAtribute("Tai nghe chụp tai : Bluetooth", 86, 113); // Loại tai nghe
        seedDataVariantAtribute("20 Giờ", 47, 113); // Dung lượng pin
        seedDataVariantAtribute("Nghe nhạc, Chống ồn", 35, 113); // Tính năng
        seedDataVariantAtribute("TVOS", 49, 113); // Hệ điều hành tương thích
        seedDataVariantAtribute("Cáp USB to Lighting, Smart Case, Sách HDSD", 48, 113); // Phụ kiện đi kèm

        seedDataProduct("Tai nghe AirPods Max Xám", "Apple", 0.1, 14, 8, 3, "TaingheAirPodsMaxXam.jpg");
        seedDataVariant("/src/assets/products/TaingheAirPodsMaxXam.jpg","Tai nghe AirPods Max Xám" ,  12199025.0, 10, 95);
        seedDataVariantAtribute("Tai nghe AirPods Max", 87, 114); // Model
        seedDataVariantAtribute("Trung Quốc", 1, 114); // Xuất xứ
        seedDataVariantAtribute("12", 4, 114); // Thời gian bảo hành (tháng)
        seedDataVariantAtribute("Xám", 3, 114); // Màu sắc
        seedDataVariantAtribute("187.3 x 168.6 x 83.4 mm", 5, 114); // Kích thước
        seedDataVariantAtribute("Vải, Khung máy: Kim loại", 7, 114); // Chất liệu
        seedDataVariantAtribute("20 Giờ", 47, 114); // Dung lượng pin
        seedDataVariantAtribute("Nghe nhạc, Chống ồn", 35, 114); // Tính năng
        seedDataVariantAtribute("TVOS", 49, 114); // Hệ điều hành tương thích
        seedDataVariantAtribute("Cáp USB to Lighting, Smart Case, Sách HDSD", 48, 114); // Phụ kiện đi kèm

//
        // Tai nghe Beats Fit Pro True Wireless Earbuds

        seedDataProduct("Tai nghe Beats Fit Pro True Wireless Earbuds", "Apple", 0.005, 14, 8, 3, "TaingheBeatsFitProTrueWirelessEarbuds.jpg");
        seedDataVariant("/src/assets/products/TaingheBeatsFitProTrueWirelessEarbuds.jpg", "Tai nghe Beats Fit Pro True Wireless Earbuds Đen" , 4199005.0, 10, 96);

        seedDataVariantAtribute("Beats Fit Pro True Wireless Earbuds", 87, 115); // Model
        seedDataVariantAtribute("Trung Quốc", 1, 115); // Xuất xứ
        seedDataVariantAtribute("12", 4, 115); // Thời gian bảo hành (tháng)
        seedDataVariantAtribute("Đen", 3, 115); // Màu sắc
        seedDataVariantAtribute("190 g", 6, 115); // Trọng lượng sản phẩm
        seedDataVariantAtribute("Tai nghe nhét tai, Tai nghe không dây : Bluetooth", 86, 115); // Loại tai nghe
        seedDataVariantAtribute("6 giờ", 48, 115); // Thời gian sử dụng/1 lần sạc
        seedDataVariantAtribute("Điện thoại", 11, 115); // Sử dụng cho thiết bị
        seedDataVariantAtribute("v5.0", 44, 115); // Bluetooth
        seedDataVariantAtribute("Chống ồn, Nghe nhạc", 35, 115); // Tính năng
        seedDataVariantAtribute("Sách HDSD", 48, 115); // Phụ kiện đi kèm


        // Đồng hồ
        seedDataProduct("Amazfit BIP", "Xiaomi", 0.160, 24, 4, 3, "AmazfitBIP.png");
        seedDataVariant("/src/assets/products/AmazfitBIP.png", "Tai nghe Amazfit BIP Đen" , 4199305.0, 10, 97);
        seedDataVariantAtribute("Amazfit BIP 5 46mm", 87, 116); // Model
        seedDataVariantAtribute("Trung Quốc", 1, 116); // Xuất xứ
        seedDataVariantAtribute("Đen", 3, 116); // Thông tin hàng hóa - Màu
        seedDataVariantAtribute("2023", 2, 116); // Thời điểm ra mắt
        seedDataVariantAtribute("12", 4, 116); // Thời gian bảo hành (tháng)
        seedDataVariantAtribute("Để nơi khô ráo, nhẹ tay, dễ vỡ.", 48, 116); // Hướng dẫn bảo quản
        seedDataVariantAtribute("45.94 x 38.09 x 11.2 mm", 5, 116); // Kích thước
        seedDataVariantAtribute("160 g", 6, 116); // Trọng lượng sản phẩm
        seedDataVariantAtribute("Nhựa", 7, 116); // Chất liệu
        seedDataVariantAtribute("Mặt đồng hồ chữ nhật", 86, 116); // Kiểu dáng mặt đồng hồ
        seedDataVariantAtribute("Nam châm", 57, 116); // Cổng sạc
        seedDataVariantAtribute("5 ngày", 44, 116); // Thời gian sử dụng pin
        seedDataVariantAtribute("1.91 inch", 14, 116); // Kích thước màn hình
        seedDataVariantAtribute("TFT LCD", 15, 116); // Công nghệ màn hình
        seedDataVariantAtribute("320 x 380 Pixels", 16, 116); // Độ phân giải
        seedDataVariantAtribute("300 mAh", 45, 116); // Dung lượng pin
        seedDataVariantAtribute("GPS", 40, 116); // GPS
        seedDataVariantAtribute("v5.2", 44, 116); // Bluetooth
        seedDataVariantAtribute("Cảm biến PPG, Cảm biến gia tốc 3 trục", 36, 116); // Cảm biến


        seedDataProduct("Amazfit GTR Mini", "Xiaomi", 0.180, 24, 4, 3, "AmazfitGTRMini.jpg");

        seedDataVariant("/src/assets/products/AmazfitGTRMini.jpg", "Amazfit GTR Mini" , 2199305.0, 10, 98);
        seedDataVariantAtribute("GTR Mini", 87, 117); // Model
        seedDataVariantAtribute("Trung Quốc", 1, 117); // Xuất xứ
        seedDataVariantAtribute("Trắng", 3, 117); // Thông tin hàng hóa - Màu
        seedDataVariantAtribute("12", 4, 117); // Thời gian bảo hành (tháng)
        seedDataVariantAtribute("Để nơi khô ráo, nhẹ tay, dễ vỡ.", 48, 117); // Hướng dẫn bảo quản
        seedDataVariantAtribute("Xem trong sách hướng dẫn sử dụng", 48, 117); // Hướng dẫn sử dụng
        seedDataVariantAtribute("5 ATM (Đi tắm, Đi bơi)", 8, 117); // Chống nước
        seedDataVariantAtribute("Khung máy: Thép không gỉ, Mặt kính: Kính cường lực, Dây: Silicone", 7, 117); // Chất liệu
        seedDataVariantAtribute("Tối đa 28 ngày Chế độ bình thường", 44, 117); // Thời gian sử dụng pin
        seedDataVariantAtribute("2 giờ", 44, 117); // Thời gian sạc đầy
        seedDataVariantAtribute("1.28 inch", 14, 117); // Kích thước màn hình
        seedDataVariantAtribute("AMOLED Chính", 15, 117); // Công nghệ màn hình


        seedDataProduct("Apple Watch Ultra 2 49mm viền Titanium Dây Ocean Band", "Apple", 0.180, 25, 4, 3, "AmazfitGTRMini.jpg");

        seedDataVariant("/src/assets/products/AppleWatchUltra2Xanh.jpg", "Apple Watch Ultra 2 49mm viền Titanium Dây Ocean Band" , 20199005.0, 10, 99);
        seedDataVariantAtribute("Apple Watch Ultra 2 49mm viền Titanium", 87, 118); // Model
        seedDataVariantAtribute("12", 4, 118); // Thời gian bảo hành (tháng)
        seedDataVariantAtribute("0.463 kg", 6, 118); // Trọng lượng sản phẩm
        seedDataVariantAtribute("Xanh", 3, 118); // Thông tin hàng hóa - Màu
        seedDataVariantAtribute("iOS 17", 49, 118); // Version yêu cầu tối thiểu


        seedDataProduct("Xiaomi Smart Band 9", "Xiami", 0.180, 24, 4, 3, "xiaomi_band_9_trang_3_f653c876a3.jpg");

        seedDataVariant("/src/assets/products/xiaomi_band_9_trang_3_f653c876a3.jpg", "Xiaomi Smart Band 9" , 999115.0, 10, 100);
        seedDataVariantAtribute("46.53 x 21.63 x 10.95 mm", 5, 119); // Kích thước
        seedDataVariantAtribute("15.8 g", 6, 119); // Trọng lượng sản phẩm
        seedDataVariantAtribute("Trắng", 3, 119); // Thông tin hàng hóa - Màu
        seedDataVariantAtribute("5 ATM (Đi tắm, Đi bơi)", 8, 119); // Chống nước
        seedDataVariantAtribute("Vỏ thân máy: Nhôm + Nhựa cao cấp", 7, 119); // Chất liệu
        seedDataVariantAtribute("1.62 inch", 14, 119); // Kích thước màn hình
        seedDataVariantAtribute("AMOLED", 15, 119); // Công nghệ màn hình
        seedDataVariantAtribute("192 x 490 Pixels", 16, 119); // Độ phân giải
        seedDataVariantAtribute("21 ngày Chế độ bình thường", 44, 119); // Thời gian sử dụng pin
        seedDataVariantAtribute("Đa ngôn ngữ", 48, 119); // Ngôn ngữ
        seedDataVariantAtribute("Android, iOS", 49, 119); // Hệ điều hành tương thích


        seedDataProduct("Apple Watch Series 9 GPS + Cellular 45mm Viền nhôm Dây cao su ", "Aple", 0.180, 25, 4, 3, "2023_10_9_638324588772574350_apple.jpg");
        seedDataVariant("/src/assets/products/2023_10_9_638324588772574350_apple.jpg", "Apple Watch Series 9 GPS + Cellular 45mm Viền nhôm Dây cao su " , 12999105.0, 10, 101);
        seedDataVariantAtribute("Apple Watch Series 9 GPS + Cellular 45mm Viền nhôm", 87, 120); // Model
        seedDataVariantAtribute("Trung Quốc", 1, 120); // Xuất xứ
        seedDataVariantAtribute("09/2023", 2, 120); // Thời điểm ra mắt
        seedDataVariantAtribute("Đen", 3, 120); // Thông tin hàng hóa - Màu
        seedDataVariantAtribute("12", 4, 120); // Thời gian bảo hành (tháng)
        seedDataVariantAtribute("45 x 38 x 10.7 mm", 5, 120); // Kích thước
        seedDataVariantAtribute("38.7 g", 6, 120); // Trọng lượng sản phẩm
        seedDataVariantAtribute("IPX6", 8, 120); // Chống nước
        seedDataVariantAtribute("Viền máy: Nhôm, Dây: Cao su", 7, 120); // Chất liệu
        seedDataVariantAtribute("18 giờ", 44, 120); // Thời gian sử dụng pin
        seedDataVariantAtribute("Đa ngôn ngữ", 48, 120); // Ngôn ngữ
        seedDataVariantAtribute("iOS", 49, 120); // Hệ điều hành tương thích
        seedDataVariantAtribute("Cuộc gọi, Tin nhắn", 35, 120); // Hiển thị thông báo

        seedDataProduct("Samsung Galaxy Fit3", "Samsung", 0.180, 26, 4, 3, "2024_2_23_638442845332012006_samsung-galaxy-fit3-den-1.jpg");
        seedDataVariant("/src/assets/products/2024_2_23_638442845332012006_samsung-galaxy-fit3-den-1.jpg", "Samsung Galaxy Fit3" , 1299105.0, 10, 102);
        seedDataVariantAtribute("Galaxy Fit3", 87, 121); // Model
        seedDataVariantAtribute("Việt Nam / Trung Quốc", 1, 121); // Xuất xứ
        seedDataVariantAtribute("02/2024", 2, 121); // Thời điểm ra mắt
        seedDataVariantAtribute("Đen", 3, 121); // Thông tin hàng hóa - Màu
        seedDataVariantAtribute("12", 4, 121); // Thời gian bảo hành (tháng)
        seedDataVariantAtribute("Để nơi khô ráo, nhẹ tay, dễ vỡ.", 48, 121); // Hướng dẫn bảo quản
        seedDataVariantAtribute("Xem trong sách hướng dẫn sử dụng", 48, 121); // Hướng dẫn sử dụng
        seedDataVariantAtribute("42.9 x 28.8 x 9.9 mm", 5, 121); // Kích thước
        seedDataVariantAtribute("36.2 g", 6, 121); // Trọng lượng sản phẩm
        seedDataVariantAtribute("IP68", 8, 121); // Chống nước
        seedDataVariantAtribute("Viền máy: Kim loại nhôm", 7, 121); // Chất liệu
        seedDataVariantAtribute("Mặt đồng hồ chữ nhật", 86, 121); // Kiểu dáng thiết kế
        seedDataVariantAtribute("1.6 inch", 14, 121); // Kích thước màn hình
        seedDataVariantAtribute("AMOLED", 15, 121); // Công nghệ màn hình
        seedDataVariantAtribute("256 x 402 Pixels", 16, 121); // Độ phân giải
        seedDataVariantAtribute("13 ngày", 44, 121); // Thời gian sử dụng pin

        seedDataProduct("Samsung Galaxy Watch6 BT 40mm", "Samsung", 0.180, 26, 4, 3, "2023_7_25_638258823929528383_samsung-galaxy-watch6-vang-1.jpg");
        seedDataVariant("/src/assets/products/2023_7_25_638258823929528383_samsung-galaxy-watch6-vang-1.jpg", "Samsung Galaxy Watch6 BT 40mm" , 1299105.0, 10, 103);
        seedDataVariantAtribute("Galaxy Watch6 BT 40mm", 87, 122); // Model
        seedDataVariantAtribute("Vàng", 3, 122); // Thông tin hàng hóa - Màu
        seedDataVariantAtribute("Việt Nam / Trung Quốc", 1, 122); // Xuất xứ
        seedDataVariantAtribute("2023", 2, 122); // Thời điểm ra mắt
        seedDataVariantAtribute("12", 4, 122); // Thời gian bảo hành (tháng)
        seedDataVariantAtribute("Để nơi khô ráo, nhẹ tay, dễ vỡ.", 48, 122); // Hướng dẫn bảo quản
        seedDataVariantAtribute("Xem trong sách hướng dẫn sử dụng", 48, 122); // Hướng dẫn sử dụng
        seedDataVariantAtribute("39.3 x 40.4 x 9.8 mm", 5, 122); // Kích thước
        seedDataVariantAtribute("48.2 g", 6, 122); // Trọng lượng sản phẩm
        seedDataVariantAtribute("Có", 8, 122); // Chống nước
        seedDataVariantAtribute("Mặt kính: Kính Sapphire", 7, 122); // Chất liệu
        seedDataVariantAtribute("Mặt đồng hồ tròn", 86, 122); // Kiểu dáng mặt đồng hồ
        seedDataVariantAtribute("Sạc không dây", 57, 122); // Cổng sạc
        seedDataVariantAtribute("Khoảng 1.5 ngày", 44, 122); // Thời gian sử dụng pin
        seedDataVariantAtribute("Bluetooth, Wi-, GPS", 44, 122); // Kết nối
        seedDataVariantAtribute("Đa ngôn ngữ", 48, 122); // Ngôn ngữ
        seedDataVariantAtribute("Android", 49, 122); // Hệ điều hành tương thích

        seedDataProduct("Samsung Galaxy Watch7 LTE 40mm", "Samsung", 0.180, 26, 4, 3, "samsung_galaxy_watch7_40mm_green_9975309aba.png");
        seedDataVariant("/src/assets/products/samsung_galaxy_watch7_40mm_green_9975309aba.png", "Samsung Galaxy Watch7 LTE 40mm" , 7299105.0, 10, 104);
        seedDataVariantAtribute("Galaxy Watch7 LTE 40mm", 87, 123); // Model
        seedDataVariantAtribute("Nâu", 3, 123); // Thông tin hàng hóa - Màu
        seedDataVariantAtribute("Việt Nam / Trung Quốc", 1, 123); // Xuất xứ
        seedDataVariantAtribute("07/2024", 2, 123); // Thời điểm ra mắt
        seedDataVariantAtribute("12", 4, 123); // Thời gian bảo hành (tháng)
        seedDataVariantAtribute("Để nơi khô ráo, nhẹ tay, dễ vỡ.", 48, 123); // Hướng dẫn bảo quản
        seedDataVariantAtribute("Xem trong sách hướng dẫn sử dụng", 48, 123); // Hướng dẫn sử dụng
        seedDataVariantAtribute("40.4 x 40.4 x 9.7 mm", 5, 123); // Kích thước
        seedDataVariantAtribute("26.6 g", 6, 123); // Trọng lượng sản phẩm
        seedDataVariantAtribute("IP68", 8, 123); // Chống nước
        seedDataVariantAtribute("240 mm", 8, 123); // Độ dài dây
        seedDataVariantAtribute("24.1 mm", 8, 123); // Độ rộng dây
        seedDataVariantAtribute("Khung máy: Hợp kim nhôm, Mặt kính: Kính Sapphire, Dây: Silicone", 7, 123); // Chất liệu
        seedDataVariantAtribute("Mặt đồng hồ tròn", 86, 123); // Kiểu dáng thiết kế
        seedDataVariantAtribute("1.3 inch", 14, 123); // Kích thước màn hình
        seedDataVariantAtribute("Super AMOLED", 15, 123); // Công nghệ màn hình
        seedDataVariantAtribute("432 x 432 pixels", 16, 123); // Độ phân giải
        seedDataVariantAtribute("Exynos W1000", 58, 123); // CPU
        seedDataVariantAtribute("Sạc không dây", 57, 123); // Cổng sạc
        seedDataVariantAtribute("40 giờ Chế độ tiết kiệm Pin - tắt AOD", 44, 123); // Thời gian sử dụng pin


        seedDataProduct("Samsung Galaxy Watch FE", "Samsung", 0.180, 26, 4, 3, "samsung_galaxy_watch_fe_black_af8a8c8abc.png");
        seedDataVariant("/src/assets/products/samsung_galaxy_watch_fe_black_af8a8c8abc.png", "Samsung Galaxy Watch FE" , 8299105.0, 10, 105);
        seedDataVariantAtribute("Galaxy Watch FE 40mm", 87, 124); // Model
        seedDataVariantAtribute("Việt Nam / Trung Quốc", 1, 124); // Xuất xứ
        seedDataVariantAtribute("Đen", 3, 124); // Thông tin hàng hóa - Màu
        seedDataVariantAtribute("07/2024", 2, 124); // Thời điểm ra mắt
        seedDataVariantAtribute("12", 4, 124); // Thời gian bảo hành (tháng)
        seedDataVariantAtribute("Để nơi khô ráo, nhẹ tay, dễ vỡ.", 48, 124); // Hướng dẫn bảo quản
        seedDataVariantAtribute("Xem trong sách hướng dẫn sử dụng", 48, 124); // Hướng dẫn sử dụng
        seedDataVariantAtribute("39.3 x 40.4 x 9.8 mm", 5, 124); // Kích thước
        seedDataVariantAtribute("26.6 g", 6, 124); // Trọng lượng sản phẩm
        seedDataVariantAtribute("5 ATM (Đi tắm, Đi bơi)", 8, 124); // Chống nước
        seedDataVariantAtribute("240 mm", 8, 124); // Độ dài dây
        seedDataVariantAtribute("24.1 mm", 8, 124); // Độ rộng dây
        seedDataVariantAtribute("Kim loại nguyên khối, Dây: Silicone", 7, 124); // Chất liệu
        seedDataVariantAtribute("Mặt đồng hồ tròn", 86, 124); // Kiểu dáng thiết kế

        seedDataProduct("Samsung Galaxy Watch Ultra LTE 47mm", "Samsung", 0.180, 26, 4, 3, "samsung_galaxy_watch_ultra_silver_black_454ec16181.png");
        seedDataVariant("/src/assets/products/samsung_galaxy_watch_ultra_silver_black_454ec16181.png", "Samsung Galaxy Watch Ultra LTE 47mm" , 20299105.0, 10, 106);
        seedDataVariantAtribute("Galaxy Watch Ultra", 87, 125); // Model
        seedDataVariantAtribute("Đen", 3, 125); // Thông tin hàng hóa - Màu
        seedDataVariantAtribute("Việt Nam / Trung Quốc", 1, 125); // Xuất xứ
        seedDataVariantAtribute("07/2024", 2, 125); // Thời điểm ra mắt
        seedDataVariantAtribute("12", 4, 125); // Thời gian bảo hành (tháng)
        seedDataVariantAtribute("Để nơi khô ráo, nhẹ tay, dễ vỡ.", 48, 125); // Hướng dẫn bảo quản
        seedDataVariantAtribute("Xem trong sách hướng dẫn sử dụng", 48, 125); // Hướng dẫn sử dụng
        seedDataVariantAtribute("47.4 x 47.4 x 12.1 mm", 5, 125); // Kích thước
        seedDataVariantAtribute("94 g", 6, 125); // Trọng lượng sản phẩm
        seedDataVariantAtribute("IP68", 8, 125); // Chống nước
        seedDataVariantAtribute("240 mm", 8, 125); // Độ dài dây
        seedDataVariantAtribute("24.1 mm", 8, 125); // Độ rộng dây
        seedDataVariantAtribute("Khung máy: Titan, Mặt kính: Kính Sapphire, Dây: Silicone", 7, 125); // Chất liệu
        seedDataVariantAtribute("Mặt đồng hồ tròn", 86, 125); // Kiểu dáng thiết kế
        seedDataVariantAtribute("1.47 inch", 14, 125); // Kích thước màn hình
        seedDataVariantAtribute("Super AMOLED", 15, 125); // Công nghệ màn hình
        seedDataVariantAtribute("480 x 480 pixels", 16, 125); // Độ phân giải
        seedDataVariantAtribute("Exynos W1000", 58, 125); // CPU
        seedDataVariantAtribute("Sạc không dây", 57, 125); // Cổng sạc

        // Phụ Kiện Điện Tử
        seedDataProduct("Quạt sạc cầm tay Hotwell ", "Xiaomi", 0.180, 27, 6, 3, "2024_5_21_638519081533397837_quat-sac-cam-tay-hotwell-fr12h1-1.jpg");
        seedDataVariant("/src/assets/products/2024_5_21_638519081533397837_quat-sac-cam-tay-hotwell-fr12h1-1.jpg", "Quạt sạc cầm tay Hotwell" , 1199105.0, 10, 107);
        seedDataVariantAtribute("FR12H1", 87, 126); // Model
        seedDataVariantAtribute("Trung Quốc", 1, 126); // Xuất xứ
        seedDataVariantAtribute("2024", 2, 126); // Thời điểm ra mắt
        seedDataVariantAtribute("12", 4, 126); // Thời gian bảo hành (tháng)
        seedDataVariantAtribute("Để nơi khô ráo, nhẹ tay, dễ vỡ.", 48, 126); // Hướng dẫn bảo quản
        seedDataVariantAtribute("Xem trong sách hướng dẫn sử dụng", 48, 126); // Hướng dẫn sử dụng
        seedDataVariantAtribute("Trắng", 3, 126); // Màu sắc
        seedDataVariantAtribute("19.6 x 9.8 x 3.8 cm", 5, 126); // Kích thước
        seedDataVariantAtribute("200 g", 6, 126); // Trọng lượng sản phẩm
        seedDataVariantAtribute("Khung lồng quạt: Nhựa ABS", 7, 126); // Chất liệu
        seedDataVariantAtribute("Tổng: 5 W", 58, 126); // Công suất
        seedDataVariantAtribute("5 V", 59, 126); // Điện áp
        seedDataVariantAtribute("Bảo hành tại hãng", 4, 126); // Chế độ bảo hành

        seedDataProduct("Quạt tháp Xiaomi Smart Tower Fan ", "Xiaomi", 1.0, 27, 6, 3, "2023_4_20_638176062564130716_quat-thap-xiaomi-smart-tower-fan-4.jpg");
        seedDataVariant("/src/assets/products/2023_4_20_638176062564130716_quat-thap-xiaomi-smart-tower-fan-4.jpg", "Quạt tháp Xiaomi Smart Tower Fan" , 1098105.0, 10, 108);
        seedDataVariantAtribute("Máy quạt đứng thông minh Xiaomi Fan 1C", 87, 127); // Model
        seedDataVariantAtribute("Trung Quốc", 1, 127); // Xuất xứ
        seedDataVariantAtribute("2023", 2, 127); // Thời điểm ra mắt
        seedDataVariantAtribute("12", 4, 127); // Thời gian bảo hành (tháng)
        seedDataVariantAtribute("Tấm làm mát và lưới lọc bụi: 0 tháng, Điều khiển: 0 tháng", 4, 127); // Thời hạn bảo hành phụ kiện
        seedDataVariantAtribute("Để nơi khô ráo, nhẹ tay, dễ vỡ.", 48, 127); // Hướng dẫn bảo quản
        seedDataVariantAtribute("Xem trong sách hướng dẫn sử dụng", 48, 127); // Hướng dẫn sử dụng
        seedDataVariantAtribute("Trắng", 3, 127); // Màu sắc
        seedDataVariantAtribute("31 x 31 x 111.1 cm", 5, 127); // Kích thước
        seedDataVariantAtribute("5.5 kg", 6, 127); // Trọng lượng sản phẩm
        seedDataVariantAtribute("Nhựa", 7, 127); // Chất liệu
        seedDataVariantAtribute("Quạt đứng", 86, 127); // Kiểu dáng thiết kế
        seedDataVariantAtribute("22 W", 58, 127); // Công suất

        seedDataProduct("Quạt máy đứng Xiaomi Smart Fan 2 Lite ", "Xiaomi", 1.0, 27, 6, 3, "2021_6_23_637600624151529277_xiaomi-smart-fan-2-lite-pyv4007gl-trang-1.jpg");
        seedDataVariant("/src/assets/products/2021_6_23_637600624151529277_xiaomi-smart-fan-2-lite-pyv4007gl-trang-1.jpg", "Quạt máy đứng Xiaomi Smart Fan 2 Lite (PYV4007GL)" , 1099105.0, 10, 109);
        seedDataVariantAtribute("Quạt máy đứng Xiaomi Smart Fan 2 Lite", 87, 128); // Model
        seedDataVariantAtribute("Trung Quốc", 1, 128); // Xuất xứ
        seedDataVariantAtribute("2021", 2, 128); // Thời điểm ra mắt
        seedDataVariantAtribute("Trắng", 3, 128); // Màu sắc
        seedDataVariantAtribute("12", 4, 128); // Thời gian bảo hành (tháng)
        seedDataVariantAtribute("Để nơi khô ráo, nhẹ tay, dễ vỡ.", 48, 128); // Hướng dẫn bảo quản
        seedDataVariantAtribute("Xem trong sách hướng dẫn sử dụng", 48, 128); // Hướng dẫn sử dụng
        seedDataVariantAtribute("Trắng", 3, 128); // Màu sắc
        seedDataVariantAtribute("642 - 1000 x 330 x 343 mm", 5, 128); // Kích thước
        seedDataVariantAtribute("3.5 kg", 6, 128); // Trọng lượng sản phẩm
        seedDataVariantAtribute("Nhựa", 7, 128); // Chất liệu
        seedDataVariantAtribute("38 W", 58, 128); // Công suất
        seedDataVariantAtribute("220 V", 59, 128); // Điện áp
        seedDataVariantAtribute("27 m3/h", 60, 128); // Lưu lượng gió


        seedDataProduct("Quạt sưởi gốm Ceramic Fujihome FH2000M 2000W", "Fujihome", 1.0, 18, 6, 3, "00912173_quat_suoi_gom_ceramic_fujihome_fh2000m_2000w_629f74b7b7.png");
        seedDataVariant("/src/assets/products/00912173_quat_suoi_gom_ceramic_fujihome_fh2000m_2000w_629f74b7b7.png", "Quạt sưởi gốm Ceramic Fujihome " , 1119105.0, 10, 110);
        seedDataVariantAtribute("FH2000M", 87, 129); // Model
        seedDataVariantAtribute("Trung Quốc", 1, 129); // Xuất xứ
        seedDataVariantAtribute("2022", 2, 129); // Thời điểm ra mắt
        seedDataVariantAtribute("24", 4, 129); // Thời gian bảo hành (tháng)
        seedDataVariantAtribute("Để nơi khô ráo, nhẹ tay, dễ vỡ.", 48, 129); // Hướng dẫn bảo quản
        seedDataVariantAtribute("Xem trong sách hướng dẫn sử dụng", 48, 129); // Hướng dẫn sử dụng
        seedDataVariantAtribute("Xanh", 3, 129); // Màu sắc
        seedDataVariantAtribute("Bảo hành tại hãng", 4, 129); // Chế độ bảo hành
        seedDataVariantAtribute("Sưởi gốm", 86, 129); // Loại quạt sưởi
        seedDataVariantAtribute("Sưởi gốm", 35, 129); // Công nghệ sưởi
        seedDataVariantAtribute("Tổng: 2000 W", 58, 129); // Công suất
        seedDataVariantAtribute("220 V / 50 Hz", 59, 129); // Điện áp
        seedDataVariantAtribute("10 - 20 m2", 60, 129); // Phạm vi làm ấm

        seedDataProduct("Pin sạc dự phòng UmeTravel 10000mAh TRIP10000 Quick Charge", "Xiaomi", 0.5, 28, 9, 3, "2022_9_5_637979820693210196_pin-sac-du-phong-quick-charge-li-polymer-10000mah-umetravel-trip10000-den.jpg");
        seedDataVariant("/src/assets/products/2022_9_5_637979820693210196_pin-sac-du-phong-quick-charge-li-polymer-10000mah-umetravel-trip10000-den.jpg", "Pin sạc dự phòng UmeTravel 10000mAh TRIP10000 Quick Charge" , 1399105.0, 10, 111);
        seedDataVariantAtribute("TRIP10000", 87, 130); // Model
        seedDataVariantAtribute("Trung Quốc", 1, 130); // Xuất xứ
        seedDataVariantAtribute("12", 4, 130); // Thời gian bảo hành (tháng)
        seedDataVariantAtribute("Trắng", 3, 130); // Màu sắc
        seedDataVariantAtribute("86 x 63 x 24 mm", 5, 130); // Kích thước
        seedDataVariantAtribute("190 g", 6, 130); // Trọng lượng sản phẩm
        seedDataVariantAtribute("Nhựa PC, Nhựa ABS", 7, 130); // Chất liệu
        seedDataVariantAtribute("65%", 58, 130); // Hiệu suất sử dụng
        seedDataVariantAtribute("QC 3.0", 59, 130); // Tiêu chuẩn sạc
        seedDataVariantAtribute("18 W", 60, 130); // Công suất sạc tối đa
        seedDataVariantAtribute("6 - 10 giờ", 61, 130); // Thời gian sạc đầy

        seedDataProduct("Chuột Gaming không dây Logitech G305 Lightspeed", "Xiami", 0.5, 19, 13, 3, "2024_6_6_638532949083597300_logitech-g305-lightspeed-black.jpg");
        seedDataVariant("/src/assets/products/2024_6_6_638532949083597300_logitech-g305-lightspeed-black.jpg", "Chuột Gaming không dây Logitech G305 Lightspeed" , 599105.0, 10, 112);
        seedDataVariantAtribute("G305", 87, 131); // Model
        seedDataVariantAtribute("Việt Nam / Trung Quốc", 1, 131); // Xuất xứ
        seedDataVariantAtribute("12", 4, 131); // Thời gian bảo hành (tháng)
        seedDataVariantAtribute("Đen", 3, 131); // Màu sắc
        seedDataVariantAtribute("99 g", 6, 131); // Trọng lượng sản phẩm
        seedDataVariantAtribute("Chuột không dây", 86, 131); // Loại chuột
        seedDataVariantAtribute("USB", 59, 131); // Kiểu kết nối
        seedDataVariantAtribute("Laptop, Máy tính để bàn", 63, 131); // Sử dụng cho thiết bị

        seedDataProduct("Bàn phím không dây HyperWork HyperOne Gen 2", "Xiaomi", 0.5, 19, 14, 3, "ban_phim_khong_day_hyperwork_hyperone_gen_2_1_561c59dd7b.jpg");
        seedDataVariant("/src/assets/products/ban_phim_khong_day_hyperwork_hyperone_gen_2_1_561c59dd7b.jpg", "Bàn phím không dây HyperWork HyperOne Gen 2" , 799105.0, 10, 113);
        seedDataVariantAtribute("HPW-KB1-G2-BLK", 87, 132); // Model
        seedDataVariantAtribute("Trung Quốc", 1, 132); // Xuất xứ
        seedDataVariantAtribute("12", 4, 132); // Thời gian bảo hành (tháng)
        seedDataVariantAtribute("Đen", 3, 132); // Màu sắc
        seedDataVariantAtribute("0.60 -1.2 x 28 x 12 cm", 5, 132); // Kích thước
        seedDataVariantAtribute("295 g", 6, 132); // Trọng lượng sản phẩm
        seedDataVariantAtribute("Bàn phím không dây", 86, 132); // Loại bàn phím
        seedDataVariantAtribute("Windows, macOS, Android", 49, 132); // Hệ điều hành tương thích
        seedDataVariantAtribute("Bluetooth", 59, 132); // Kiểu kết nối

        seedDataProduct("Chuột không dây HyperWork Silentium", "Xiaomi", 0.5, 19, 13, 3, "ban_phim_khong_day_hyperwork_hyperone_gen_2_1_561c59dd7b.jpg");
        seedDataVariant("/src/assets/products/ban_phim_khong_day_hyperwork_hyperone_gen_2_1_561c59dd7b.jpg", "Chuột không dây HyperWork Silentium" , 799175.0, 10, 114);
        seedDataVariantAtribute("HPW-KB1-G2-BLK", 87, 133); // Model
        seedDataVariantAtribute("Trung Quốc", 1, 133); // Xuất xứ
        seedDataVariantAtribute("12", 4, 133); // Thời gian bảo hành (tháng)
        seedDataVariantAtribute("Đen", 3, 133); // Màu sắc
        seedDataVariantAtribute("0.60 -1.2 x 28 x 12 cm", 5, 133); // Kích thước
        seedDataVariantAtribute("295 g", 6, 133); // Trọng lượng sản phẩm
        seedDataVariantAtribute("Bàn phím không dây", 86, 133); // Loại bàn phím
        seedDataVariantAtribute("Windows, macOS, Android", 49, 133); // Hệ điều hành tương thích
        seedDataVariantAtribute("Bluetooth", 59, 133); // Kiểu kết nối

        seedDataProduct("Cáp Hub USB-C to HDMI 5in1 1549 Ugreen", "Xiaomi", 0.5, 29, 10, 3, "2024_5_20_638518124703463958_ugreen-15495.jpg");
        seedDataVariant("/src/assets/products/2024_5_20_638518124703463958_ugreen-15495.jpg", "Cáp Hub USB-C to HDMI 5in1 1549 Ugreen" , 99105.0, 10, 115);
        seedDataVariantAtribute("CM478", 87, 134); // Model
        seedDataVariantAtribute("Trung Quốc", 1, 134); // Xuất xứ
        seedDataVariantAtribute("12", 4, 134); // Thời gian bảo hành (tháng)
        seedDataVariantAtribute("Để nơi khô ráo, nhẹ tay, dễ vỡ.", 48, 134); // Hướng dẫn bảo quản
        seedDataVariantAtribute("Xem trong sách hướng dẫn sử dụng", 48, 134); // Hướng dẫn sử dụng
        seedDataVariantAtribute("Xám đen", 3, 134); // Màu sắc
        seedDataVariantAtribute("11.5 x 3.5 x 1.25 cm", 5, 134); // Kích thước
        seedDataVariantAtribute("0.1 kg", 6, 134); // Trọng lượng sản phẩm
        seedDataVariantAtribute("15 cm", 66, 134); // Độ dài dây cáp
        seedDataVariantAtribute("Vỏ: Hợp kim", 7, 134); // Chất liệu
        seedDataVariantAtribute("5A", 58, 134); // Cường độ dòng điện
        seedDataVariantAtribute("Laptop, Máy tính để bàn", 63, 134); // Sử dụng cho thiết bị
        seedDataVariantAtribute("1 x USB-C (Dây liền)", 67, 134); // Cổng đầu vào
        seedDataVariantAtribute("1 x USB-A (USB 3.0)", 68, 134); // Cổng đầu ra
        seedDataVariantAtribute("Truyền dữ liệu", 35, 134); // Tính năng

        seedDataProduct("Bộ sạc nhanh 1 cổng 30W ", "Xiaomi", 0.5, 29, 10, 3, "bo_sac_nhanh_1_cong_30w_kem_cap_type_c_to_type_c_1m_smart_serie_devia_3_dae9db5b53.jpg");
        seedDataVariant("/src/assets/products/bo_sac_nhanh_1_cong_30w_kem_cap_type_c_to_type_c_1m_smart_serie_devia_3_dae9db5b53.jpg", "Bộ sạc nhanh 1 cổng 30W kèm cáp Type-C to Type-C 1M Smart Serie Devia" , 199105.0, 10, 116);
        seedDataVariantAtribute("Bộ sạc devia 30w", 87, 135); // Model
        seedDataVariantAtribute("Trung Quốc", 1, 135); // Xuất xứ
        seedDataVariantAtribute("12", 4, 135); // Thời gian bảo hành (tháng)
        seedDataVariantAtribute("Để nơi khô ráo, nhẹ tay, dễ vỡ.", 48, 135); // Hướng dẫn bảo quản
        seedDataVariantAtribute("Xem trong sách hướng dẫn sử dụng", 48, 135); // Hướng dẫn sử dụng
        seedDataVariantAtribute("Trắng", 3, 135); // Màu sắc
        seedDataVariantAtribute("78.7 x 42.4 x 27.3 mm", 5, 135); // Kích thước
        seedDataVariantAtribute("50 g", 6, 135); // Trọng lượng sản phẩm
        seedDataVariantAtribute("1 m", 66, 135); // Độ dài dây cáp
        seedDataVariantAtribute("Nhựa PC, Nhựa ABS", 7, 135); // Chất liệu
        seedDataVariantAtribute("3A", 58, 135); // Cường độ dòng điện
        seedDataVariantAtribute("Điện thoại, Máy tính bảng", 63, 135); // Sử dụng cho thiết bị
        seedDataVariantAtribute("Type C", 67, 135); // Cổng cáp kết nối
        seedDataVariantAtribute("Sạc nhanh", 35, 135); // Tính năng

        seedDataProduct("Nồi áp suất điện Sunhouse 6 lit SHD1657", "Sunhouse", 0.5, 20, 6, 3, "noi-ap-suat-dien-sunhouse-6-lit-shd1657-nau-1.jpg");
        seedDataVariant("/src/assets/products/noi-ap-suat-dien-sunhouse-6-lit-shd1657-nau-1.jpg", "Nồi áp suất điện Sunhouse 6 lit SHD1657" , 1499105.0, 10, 117);
        seedDataVariantAtribute("SHD1657", 87, 136); // Model
        seedDataVariantAtribute("Việt Nam", 1, 136); // Xuất xứ
        seedDataVariantAtribute("2019", 2, 136); // Năm ra mắt
        seedDataVariantAtribute("12", 4, 136); // Thời gian bảo hành (tháng)
        seedDataVariantAtribute("Nâu", 3, 136); // Màu sắc
        seedDataVariantAtribute("4.62 kg", 6, 136); // Trọng lượng sản phẩm
        seedDataVariantAtribute("Lòng nồi: Hợp kim nhôm phủ chống dính", 7, 136); // Chất liệu
        seedDataVariantAtribute("6 lít", 58, 136); // Dung tích thực
        seedDataVariantAtribute("1000 W", 59, 136); // Công suất
        seedDataVariantAtribute("Nút vặn", 60, 136); // Bảng điều khiển
        seedDataVariantAtribute("Nấu gà/vịt, Nấu canh, Làm bánh, Nấu cháo, Nấu cơm, Giữ ấm", 35, 136); // Chức năng chính
        seedDataVariantAtribute("Dây điện có thể tháo rời, Nắp tháo rời", 35, 136); // Tiện ích
        seedDataVariantAtribute("1 van", 61, 136); // Van an toàn
        seedDataVariantAtribute("Van xả áp khi áp suất cao, Khoá nắp nồi khi có áp suất cao", 62, 136); // An toàn sử dụng
        seedDataVariantAtribute("Dây nguồn, Muỗng cơm, Cốc đong", 66, 136); // Phụ kiện trong hộp

        seedDataProduct("Bình thủy điện Sunhouse 3.5 lít SH1535", "Sunhouse", 0.5, 20, 6, 3, "binh-thuy-dien-sunhouse-3-5-lit-sh1535-1.jpg");
        seedDataVariant("/src/assets/products/binh-thuy-dien-sunhouse-3-5-lit-sh1535-1.jpg", "Bình thủy điện Sunhouse 3.5 lít SH1535" , 1099115.0, 10, 118);
        seedDataVariantAtribute("SH1535", 87, 137); // Model
        seedDataVariantAtribute("Trung Quốc", 1, 137); // Xuất xứ
        seedDataVariantAtribute("2016", 2, 137); // Thời điểm ra mắt
        seedDataVariantAtribute("12", 4, 137); // Thời gian bảo hành (tháng)
        seedDataVariantAtribute("Để nơi khô ráo, nhẹ tay, dễ vỡ.", 48, 137); // Hướng dẫn bảo quản
        seedDataVariantAtribute("Xem trong sách hướng dẫn sử dụng", 48, 137); // Hướng dẫn sử dụng
        seedDataVariantAtribute("Trắng", 3, 137); // Màu sắc
        seedDataVariantAtribute("259 x 224 x 306 mm", 5, 137); // Kích thước
        seedDataVariantAtribute("3.1 kg", 6, 137); // Trọng lượng sản phẩm
        seedDataVariantAtribute("Ruột bình: Inox 304, Vỏ bình: Nhựa", 7, 137); // Chất liệu
        seedDataVariantAtribute("3.5 lít", 58, 137); // Dung tích sử dụng
        seedDataVariantAtribute("750 W", 59, 137); // Công suất
        seedDataVariantAtribute("220 V", 60, 137); // Điện áp
        seedDataVariantAtribute("Không", 61, 137); // Hẹn giờ đun sôi
        seedDataVariantAtribute("Bơm tay", 62, 137); // Cách lấy nước
        seedDataVariantAtribute("Đun sôi 100 độ C, Giữ ấm 80 độ C", 63, 137); // Nhiệt độ bình
        seedDataVariantAtribute("Cột hiển thị mực nước, Tự đun sôi lại khi nước nguội, Có chế độ tẩy cặn", 35, 137); // Tiện ích
        seedDataVariantAtribute("Khoá bơm tay rót nước", 64, 137); // An toàn sử dụng

        seedDataProduct("Máy sấy tóc Philips BHC010/10", "Philips", 0.5, 21, 6, 3, "may-say-toc-philips-bhc010-10-den-1.jpg");
        seedDataVariant("/src/assets/products/may-say-toc-philips-bhc010-10-den-1.jpg", "Bình thủy điện Sunhouse 3.5 lít SH1535" , 999215.0, 10, 119);
        seedDataVariantAtribute("BHC010/10", 87, 138); // Model
        seedDataVariantAtribute("Trung Quốc", 1, 138); // Xuất xứ
        seedDataVariantAtribute("24", 4, 138); // Thời gian bảo hành (tháng)
        seedDataVariantAtribute("Xem trong sách hướng dẫn sử dụng", 48, 138); // Hướng dẫn sử dụng
        seedDataVariantAtribute("Đen", 3, 138); // Màu sắc
        seedDataVariantAtribute("220 x 77 x 114 mm", 5, 138); // Kích thước
        seedDataVariantAtribute("340 g", 6, 138); // Trọng lượng sản phẩm
        seedDataVariantAtribute("Vỏ: Nhựa", 7, 138); // Chất liệu
        seedDataVariantAtribute("Tay cầm gấp gọn", 86, 138); // Kiểu dáng
        seedDataVariantAtribute("1.5 m", 66, 138); // Chiều dài dây điện
        seedDataVariantAtribute("1200 W", 59, 138); // Công suất
        seedDataVariantAtribute("220 V", 60, 138); // Điện áp
        seedDataVariantAtribute("3 chế độ", 61, 138); // Chế độ sấy
        seedDataVariantAtribute("Sấy mát", 35, 138); // Tiện ích
        seedDataVariantAtribute("Đầu sấy", 66, 138); // Phụ kiện trong hộp

        seedDataProduct("Bàn ủi hơi nước Sunhouse SHD2067", "Sunhouse", 0.5, 20, 6, 3, "ban-ui-hoi-nuoc-sunhouse-shd2067-ct1.jpg");
        seedDataVariant("/src/assets/products/ban-ui-hoi-nuoc-sunhouse-shd2067-ct1.jpg", "Bàn ủi hơi nước Sunhouse SHD2067" , 599215.0, 10, 120);
        seedDataVariantAtribute("SHD2067", 87, 139); // Model
        seedDataVariantAtribute("Trung Quốc", 1, 139); // Xuất xứ
        seedDataVariantAtribute("2019", 2, 139); // Thời điểm ra mắt
        seedDataVariantAtribute("12", 4, 139); // Thời gian bảo hành (tháng)
        seedDataVariantAtribute("Để nơi khô ráo, nhẹ tay, dễ vỡ.", 48, 139); // Hướng dẫn bảo quản
        seedDataVariantAtribute("Xem trong sách hướng dẫn sử dụng", 48, 139); // Hướng dẫn sử dụng
        seedDataVariantAtribute("Vàng", 3, 139); // Màu sắc
        seedDataVariantAtribute("290 x 110 x 156 mm", 5, 139); // Kích thước
        seedDataVariantAtribute("670 g", 6, 139); // Trọng lượng sản phẩm
        seedDataVariantAtribute("Ceramic", 7, 139); // Chất liệu
        seedDataVariantAtribute("Bàn ủi hơi nước", 86, 139); // Loại bàn ủi
        seedDataVariantAtribute("1800 W", 59, 139); // Công suất
        seedDataVariantAtribute("220 V", 60, 139); // Điện áp
        seedDataVariantAtribute("0.16 lít", 61, 139); // Bình nước
        seedDataVariantAtribute("Phun tia, Phun hơi thẳng đứng, Ủi hơi nước", 35, 139); // Chức năng
        seedDataVariantAtribute("Chống xoắn dây nguồn, Nút trượt xả cặn, Mặt đế chống dính, Chống đóng cặn lỗ phun hơi nước", 35, 139); // Tiện ích
        seedDataVariantAtribute("Tự ngắt điện khi quá tải", 64, 139); // An toàn sử dụng
        seedDataVariantAtribute("Cốc", 66, 139); // Phụ kiện trong hộp











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

        // stockReceive
        seedDataReceive(1L, 20990000.0, LocalDateTime.now(), "");
        seedDataReceive(2L, 22990000.0, LocalDateTime.now(), "");

        // stockReceiveDetail
        seedDataReceiveDetail(1L, 1L, 1, 20990000.0);
        seedDataReceiveDetail(2L, 1L, 1, 20990000.0);

        // Imei
        seedDataImei("12345", "available", 1L);
        seedDataImei("12346", "available", 2L);
        seedDataImei("0", "default", null);


        // order

        seedDataOrder("abc", "Chờ duyệt", "Cash", "Chưa thanh toán", 24990000.0, 1L, LocalDateTime.now(), "abc", "0374974098");
        seedDataOrder("abc", "Chờ duyệt", "BankTransfer", "Đã thanh toán", 27990000.0, 2L, LocalDateTime.now(), "abc","0374974097");

        // orderDetail
        seedDataOrderDetail(1L,1L,1, 24990000.0, 24990000.0, 3L);
        seedDataOrderDetail(2L, 1L,1, 27990000.0, 27990000.0, 3L);


        System.out.println("Khởi tạo xong");
    }

    public void seedDataReceive(Long supplierId, Double total, LocalDateTime date, String note) {
        List<StockReceive> stockReceives = stockReceiveRepository.findStockReceivesBySupplier_Id(supplierId);
        if (stockReceives.isEmpty()) {
            StockReceive stockReceive = new StockReceive();
            stockReceive.setReceive_date(date);
            stockReceive.setSupplier(supplierRepository.findById(supplierId).get());
            stockReceive.setTotal(total);
            stockReceive.setNote(note);
            stockReceiveRepository.save(stockReceive);
        }

    }

    public void seedDataReceiveDetail(Long stockReceiveId, Long variantId, int quantity, Double price) {
        Optional<StockReceiveDetail> stockReceive = stockReceiveDetailRepository.findStockReceiveDetailByStockReceive_IdAndVariant_Id(stockReceiveId,variantId);
        if (stockReceive.isEmpty()) {
            StockReceiveDetail stockReceiveDetail = new StockReceiveDetail();
            stockReceiveDetail.setStockReceive(stockReceiveRepository.findById(stockReceiveId).get());
            stockReceiveDetail.setVariant(variantRepository.findById(variantId).get());
            stockReceiveDetail.setQuantity(quantity);
            stockReceiveDetail.setPrice(price);
            stockReceiveDetailRepository.save(stockReceiveDetail);
        }
    }
    public void seedDataOrder(String note, String order_status, String payment_method, String payment_status, double total, Long customerId, LocalDateTime order_date, String address,String phone) {
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
            order.setAddress(address);
            order.setPhone(phone);
            orderRepository.save(order);

        }
    }

    public void seedDataOrderDetail(Long orderId,Long variantId, int quantity, Double price, Double total, Long imeiId) {
        OrderDetail orderDetails = orderDetailRepository.findByOrderIdAndImei_Id(orderId,imeiId);
        if (orderDetails == null) {
            OrderDetail orderDetail = new OrderDetail();
            orderDetail.setVariantId(variantId);
            orderDetail.setOrder(orderRepository.findById(orderId).orElseThrow(() -> new RuntimeException("Order not found")));
            orderDetail.setImei(imeiRepository.findImeiById(imeiId).orElseThrow(() -> new RuntimeException("Imei not found")));
            orderDetail.setQuantity(quantity);
            orderDetail.setPrice(price);
            orderDetail.setTotal(total);
            orderDetailRepository.save(orderDetail);
        }
    }
    public void seedDataImei(String imei_code,String status, Long stockReceiveDetail){
        Optional<Imei> imeis = imeiRepository.findImeiByImeiCode(imei_code);
        if (imeis.isEmpty()) {
            Imei imei = new Imei();
            imei.setImeiCode(imei_code);
            imei.setStatus(status);
            if(stockReceiveDetail != null){
                imei.setStockReceiveDetail(stockReceiveDetailRepository.findById(stockReceiveDetail).get());
            }

            imeiRepository.save(imei);
        }
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

    public void seedDataVariant(String image , String name, Double price, int quantity, int product_id) {
        List<Variant> variants = variantRepository.findByProductsIdAndPrice((long) product_id, price);
//        if (variants.isEmpty()) {
        Variant variant = new Variant();
        variant.setImage(image);
        variant.setName(name);
        variant.setPrice(price);
        variant.setQuantity(quantity);
        variant.setProducts(productRepository.findById((long) product_id).get());
        variant.setStatus("active");
        variantRepository.save(variant);
//        }
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
//        if (products.isEmpty()) {
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
//        }
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

    public void seedDataOrder(String note, String order_status, String payment_method, String payment_status, double total, Long customerId, LocalDateTime order_date) {
        List<Order> orders = orderRepository.findOrdersByCustomerId(customerId);
        if (orders.isEmpty()) {
            Order order = new Order();
            order.setNote(note);
            order.setOrderStatus(order_status);
            order.setPayment_status(payment_status);

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
