package com.example.technicstore.config;

import com.example.technicstore.entity.*;
import com.example.technicstore.entity.Module;
import com.example.technicstore.repository.*;
import com.example.technicstore.repository.Variant_AttributeRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

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


    public DataInitializer(CustomerRepository customerRepository, AttributeRepository attributeRepository, BrandRepository brandRepository, CategoryRepository categoryRepository, SupplierRepository supplierRepository, CarrierRepository carrierRepository, WarrantyRepository warrantyRepository, RoleRepository roleRepository, FunctionRepository functionRepository, ModuleRepository moduleRepository, DecentralizationRepository decentralizationRepository, AccountRepository accountRepository, ProductRepository productRepository, ImeiRepository imeiRepository, VariantRepository variantRepository,Variant_AttributeRepository variantValueRepository1) {
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

        // region attribute
        seedDataAttribute("Màu sắc");
        seedDataAttribute("Dung lượng");
        //endregion

        // region brand
        //   Thương hiệu điện thoại
        seedDataBrand("iPhone");
        seedDataBrand("Samsung");
        seedDataBrand("Xiaomi");
        seedDataBrand("Oppo");
        seedDataBrand("Realme");

        //   Thương hiệu laptop
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
        seedDataCategory("Điện thoại di động");
        seedDataCategory("Laptop");
        seedDataCategory("Tablet");
        seedDataCategory("Smartwatch");


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
        seedDataSupplier("Apple", "apple@gmail.com", "0123456789", "123 Đường A, Quận 1, TP HCM","Đang giao dịch");
        seedDataSupplier("Samsung", "samsung@gmail.com", "0987654321", "456 Đường B, Quận 2, TP HCM","Đang giao dịch");
        seedDataSupplier("Dell", "dell@gmail.com", "0112233445", "789 Đường C, Quận 3, TP HCM","Đang giao dịch");
        seedDataSupplier("HP", "hp@gmail.com", "0223344556", "101 Đường D, Quận 4, TP HCM","Đang giao dịch");
        seedDataSupplier("Lenovo", "lenovo@gmail.com", "0334455667", "202 Đường E, Quận 5, TP HCM","Ngưng giao dịch");
        seedDataSupplier("Xiaomi", "xiaomi@gmail.com", "0445566778", "303 Đường F, Quận 6, TP HCM","Đang giao dịch");
        seedDataSupplier("Asus", "asus@gmail.com", "0556677889", "404 Đường G, Quận 7, TP HCM","Ngưng giao dịch");
        seedDataSupplier("Sony", "sony@gmail.com", "0667788990", "505 Đường H, Quận 8, TP HCM","Đang giao dịch");
        seedDataSupplier("Microsoft", "microsoft@gmail.com", "0778899001", "606 Đường I, Quận 9, TP HCM","Ngưng giao dịch");
        seedDataSupplier("Huawei", "huawei@gmail.com", "0889900112", "707 Đường K, Quận 10, TP HCM","Đang giao dịch");
        // endregion

        // region carrier
        seedDataCarrier("Grab");
        seedDataCarrier("Bee");
        seedDataCarrier("Giao hàng nhanh");
        seedDataCarrier("Giao hàng tiết kiệm");
        seedDataCarrier("Lalamove");
        seedDataCarrier("ViettelPost");
        // endregion

        // region warranty
        seedDataWarranty("Không bảo hành", "Không", 0);
        seedDataWarranty("Bảo hành 10 ngày", "Ngày", 10);
        seedDataWarranty("Bảo hành 1 tháng", "Tháng", 1);
        seedDataWarranty("Bảo hành 6 tháng", "Tháng", 6);
        seedDataWarranty("Bảo hành 1 năm", "Năm", 1);
        seedDataWarranty("Bảo hành 2 năm", "Năm", 2);
        seedDataWarranty("Bảo hành 3 tháng", "Tháng", 3);
        seedDataWarranty("Bảo hành 30 ngày", "Ngày", 30);
        seedDataWarranty("Bảo hành 90 ngày", "Ngày", 90);
        // endregion

        // region account

        seedDataAccount("admin", "admin", "0123456789", 1L);
        seedDataAccount("customer", "customer", "0987654321", 2L);
        seedDataAccount("carrier", "carrier", "0112233445", 3L);
        // endregion

        // region product
        // Điện thoại
        //Iphone
        seedDataProduct("Iphone 14", "Điện thoại", 0.5, 1, 1, 1 );
        seedDataProduct("Iphone 14 Pro Max", "Điện thoại", 0.5, 1, 1, 1);
        seedDataProduct("Iphone 15", "Điện thoại", 0.5, 1, 1, 1);
        seedDataProduct("Iphone 15 Pro Max", "Điện thoại", 0.5, 1, 1, 1);
        //Samsung
        seedDataProduct("Samsung Galaxy S21 FE 5G", "Điện thoại", 0.5, 2, 1,  1);
        seedDataProduct("Samsung Galaxy A55 5G", "Điện thoại", 0.5, 2, 1,  1);
        seedDataProduct("Samsung Galaxy Z Fold6", "Điện thoại", 0.5, 2, 1,  1);
        seedDataProduct("Samsung Galaxy M54", "Điện thoại", 0.5, 2, 1,  1);
        //Xiaomi
        seedDataProduct("Xiaomi Mi 11", "Điện thoại", 0.5, 3, 1,  1);
        seedDataProduct("Xiaomi Mi 11 Pro", "Điện thoại", 0.5, 3, 1,  1);
        seedDataProduct("Xiaomi Redmi Note 13", "Điện thoại", 0.5, 3, 1,  1);
        seedDataProduct("Xiaomi Redmi Note 13 Pro", "Điện thoại", 0.5, 3, 1, 1);
        //Oppo
        seedDataProduct("Oppo Reno 7", "Điện thoại", 0.5, 4, 1,  1);
        seedDataProduct("Oppo Reno 7 Pro", "Điện thoại", 0.5, 4, 1,  1);


        // Laptop
        // Thương hiệu Dell
        seedDataProduct("Laptop Dell Inspiron 15 3520 i5 1235U", "Laptop", 1.5, 6, 2,  2);
        seedDataProduct("Laptop Dell Inspiron 15 3530 i5 1334U", "Laptop", 1.5, 6, 2,  2);
        seedDataProduct("Laptop Dell Vostro 3520 i5 1235U", "Laptop", 1.5, 6, 2,  2);
        seedDataProduct("Laptop Dell Vostro 3530 i5 1335U", "Laptop", 1.5, 6, 2,  2);


        // Thương hiệu HP
        seedDataProduct("Laptop HP 15 fd0234TU i5 1334U", "Laptop", 1.5, 7, 2, 2);
        seedDataProduct("Laptop HP Pavilion 15 eg2081TU i5 1240P", "Laptop", 1.5, 7, 2,  2);
        seedDataProduct("Laptop HP 15 fd0303TU i3 1315U", "Laptop", 1.5, 7, 2,  2);
        seedDataProduct("Laptop HP 240 G9 i5 1235U/16GB/512GB/Win11", "Laptop", 1.5, 7, 2,  2);

        // Thể loại Tablet
        // Thương hiệu Iphone
        seedDataProduct("iPad Air 6 M2 11 inch WiFi 128GB", "Máy tính bảng", 1.0, 12, 3,  2);
        seedDataProduct("iPad Pro M4 11 inch WiFi 256GB", "Máy tính bảng", 1.0, 12, 3,  2);

        // Thương hiệu Samsung
        seedDataProduct("Samsung Galaxy Tab A9+ 5G 4GB/64GB", "Máy tính bảng", 1.0, 2, 3,  2);
        seedDataProduct("Samsung Galaxy Tab A9 4G 4GB/64GB", "Máy tính bảng", 1.0, 2, 3,  2);

        //Thương hiệu Levono
        seedDataProduct("Lenovo Tab Plus WiFi 8GB/256GB", "Máy tính bảng", 1.0, 8, 3,  2);

        // Thương hiệu Xiaomi
        seedDataProduct("Xiaomi Redmi Pad SE 8.7 WiFi 4GB/64GB", "Máy tính bảng", 1.0, 3, 3,  2);
        seedDataProduct("Xiaomi Redmi Pad Pro WiFi 8GB/128GB", "Máy tính bảng", 1.0, 3, 3,  2);

        // Thể loại Tai nghe
        // Thương hiệu Apple
        seedDataProduct("Bluetooth AirPods Pro Gen 2 MagSafe Charge (USB-C) Apple MTJV3", "Tai nghe", 0.1, 16, 6,  1);
        seedDataProduct("Tai nghe Có Dây Apple MMTN2", "Tai nghe", 0.1, 16, 6,  1);
        seedDataProduct("Tai nghe Có Dây Apple MTJY3", "Tai nghe", 0.1, 16, 6,  1);
        seedDataProduct("Tai nghe Bluetooth AirPods 3 Lightning Charge Apple MPNY3", "Tai nghe", 0.1, 16, 6,  1);

        // Thương hiệu Samsung
        seedDataProduct("Tai nghe TWS Samsung Galaxy Buds3 R530N", "Tai nghe", 0.1, 2, 6,  1);
        seedDataProduct("Tai nghe TWS Samsung Galaxy Buds3 Pro R630N", "Tai nghe", 0.1, 2, 6,  1);
        seedDataProduct("Tai nghe Bluetooth True Wireless Samsung Galaxy Buds FE R400N", "Tai nghe", 0.1, 2, 2, 1);


        // Thương hiệu Xiaomi
        seedDataProduct("Tai nghe Bluetooth True Wireless Xiaomi Redmi Buds 6 Play", "Tai nghe", 0.1, 3, 6, 1);
        seedDataProduct("Tai nghe Bluetooth TWS Xiaomi Redmi Buds 6 Lite", "Tai nghe", 0.1, 3, 6,  1);
        seedDataProduct("Tai nghe Bluetooth True Wireless Xiaomi Redmi Buds 5", "Tai nghe", 0.1, 3, 6,  1);

        // Thể loại Smartwatch
        // Thương hiệu SamSung
        seedDataProduct("Đồng hồ thông minh Samsung Galaxy Watch7 40mm", "Smartwatch", 0.2, 2, 4,1);
        seedDataProduct("Đồng hồ thông minh Galaxy Watch Ultra LTE 47mm", "Smartwatch", 0.2, 2, 4,1);
        seedDataProduct("Đồng hồ thông minh Samsung Galaxy Watch7 44mm", "Smartwatch", 0.2, 2, 4,1);

        // Thương hiệu Xiaomi
        seedDataProduct("Vòng đeo tay thông minh Mi Band 9", "Smartwatch", 0.2, 6, 5,  1);
        seedDataProduct("Vòng đeo tay thông minh Mi Band 8 Pro", "Smartwatch", 0.2, 6, 5,  1);
        seedDataProduct("Đồng hồ thông minh Xiaomi Watch S3 47mm", "Smartwatch", 0.2, 6, 5, 1);

        // Thể loại Sạc dự phòng
        // Thương hiệu Samsung
        seedDataProduct("Sạc dự phòng Samsung 10000mAh EB-P1100C", "Sạc dự phòng", 0.3, 2, 6,  1);

        // Thể loại ốp lưng
        // Thương hiệu Apple
        seedDataProduct("Ốp lưng iPhone 13 Pro Max", "Ốp lưng", 0.1, 16, 7,  9);
        seedDataProduct("Ốp lưng iPhone 13 Pro", "Ốp lưng", 0.1, 16, 7,  9);

        // Thương hiệu Samsung
        seedDataProduct("Ốp lưng Samsung Galaxy S21 Ultra", "Ốp lưng", 0.1, 2, 7,  9);
        seedDataProduct("Ốp lưng Samsung Galaxy S21", "Ốp lưng", 0.1, 2, 7,  9);

        // Thương hiệu Xiaomi
        seedDataProduct("Ốp lưng Xiaomi Redmi Note 13 Pro", "Ốp lưng", 0.1, 3, 7,  9);
        seedDataProduct("Ốp lưng Xiaomi Redmi Note 13", "Ốp lưng", 0.1, 3, 7,  9);

        // Thể loại Chuột
        // Thương hiệu Dell
        seedDataProduct("Chuột Dell MS3220W", "Chuột", 0.2, 6, 8,  1);
        seedDataProduct("Chuột Dell MS3220W", "Chuột", 0.2, 6, 8,  1);

        // Thương hiệu HP
        seedDataProduct("Chuột HP X1000", "Chuột", 0.2, 7, 8,  1);
        seedDataProduct("Chuột HP X1000", "Chuột", 0.2, 7, 8,  1);

        // Thương hiệu Lenovo
        seedDataProduct("Chuột Lenovo M120 Pro", "Chuột", 0.2, 8, 8,  1);

        // Thể loại Bàn phím
        // Thương hiệu Apple
        seedDataProduct("Bàn phím Apple Magic Keyboard", "Bàn phím", 0.3, 16, 9,  1);
        //Thương hiệu xiaomi
        seedDataProduct("Bàn phím Xiaomi Mi Wireless Keyboard", "Bàn phím", 0.3, 3, 9,  1);

        // endregion

        // region variant
        // Điện thoại
        // Iphone
        // iphone14
        seedDataVariant("iphone14", 17090000.0, 10, 1);
        seedDataVariant("iphone14", 19090000.0, 10, 1);
        seedDataVariant("iphone14", 24090000.0, 10, 1);

        //iphone 14 promax
        seedDataVariant("iphone14promax", 25090000.0, 10, 2);
        seedDataVariant("iphone14promax", 27090000.0, 10, 2);
        seedDataVariant("iphone14promax", 32090000.0, 10, 2);

        // iphone 15
        seedDataVariant("iphone15", 18090000.0, 10, 3);
        seedDataVariant("iphone15", 20090000.0, 10, 3);
        seedDataVariant("iphone15", 25090000.0, 10, 3);

        // iphone 15 promax
        seedDataVariant("iphone15promax", 28090000.0, 10, 4);

        // SamSung
        // Samsung Galaxy S21
        seedDataVariant("SamsungGalaxyS21", 15090000.0, 10, 5);
        seedDataVariant("SamsungGalaxyS21", 20090000.0, 10, 5);

        // Samsung Galaxy A55
        seedDataVariant("SamsungGalaxyA55G", 9690000.0, 10, 6);
        seedDataVariant("SamsungGalaxyA55G", 10790000.0, 10, 6);

        // Samsung Galaxy Z Fold6
        seedDataVariant("SamsungGalaxyZFold6", 39990000.0, 10, 7);
        seedDataVariant("SamsungGalaxyZFold6", 43990000.0, 10, 7);

        // Samsung Galaxy M54 5G
        seedDataVariant("SamsungGalaxyM54G", 7990000.0, 10, 8);

        // Xiaomi
        // Xiaomi Mi 11

        // endregion

        // region variant_attribute

        // điện thoại iphone 14 dung lượng 128 GB có 3 màu Đen, Trắng, Xanh giá 17.090.000
        seedDataVariantAtribute("Đen", 1, 1);
        seedDataVariantAtribute("Trắng", 1, 1);
        seedDataVariantAtribute("Xanh", 1, 1);
        seedDataVariantAtribute("128GB", 2, 1);

        // điện thoại iphone 14 dung lượng 256 GB có 3 màu Đen, Trắng, Xanh giá 19.090.000
        seedDataVariantAtribute("Đen", 1, 2);
        seedDataVariantAtribute("Trắng", 1, 2);
        seedDataVariantAtribute("Xanh", 1, 2);
        seedDataVariantAtribute("256GB", 2, 2);

        //điện thoại iphone 14 dung lượng 256 GB có 3 màu Đen, Trắng, Xanh giá 24.090.000
        seedDataVariantAtribute("Đen", 1, 3);
        seedDataVariantAtribute("Trắng", 1, 3);
        seedDataVariantAtribute("Xanh", 1, 3);
        seedDataVariantAtribute("512GB", 2, 3);

        // iphone 14 Pro Max dung lượng 128 GB có 3 màu Đen, Trắng, Xanh giá 25.090.000
        seedDataVariantAtribute("Đen", 1, 4);
        seedDataVariantAtribute("Trắng", 1, 4);
        seedDataVariantAtribute("Xanh", 1, 4);
        seedDataVariantAtribute("128GB", 2, 4);

        // iphone 14 Pro Max dung lượng 256 GB có 3 màu Đen, Trắng, Xanh giá 27.090.000
        seedDataVariantAtribute("Đen", 1, 5);
        seedDataVariantAtribute("Trắng", 1, 5);
        seedDataVariantAtribute("Xanh", 1, 5);
        seedDataVariantAtribute("256GB", 2, 5);

        // iphone 14 Pro Max dung lượng 512 GB có 3 màu Đen, Trắng, Xanh giá 32.090.000
        seedDataVariantAtribute("Đen", 1, 6);
        seedDataVariantAtribute("Trắng", 1, 6);
        seedDataVariantAtribute("Xanh", 1, 6);
        seedDataVariantAtribute("512GB", 2, 6);

        // iphone 15 dung lượng 128 GB có 2 màu Đen, Trắng giá 18.090.000
        seedDataVariantAtribute("Đen", 1, 7);
        seedDataVariantAtribute("Trắng", 1, 7);
        seedDataVariantAtribute("128GB", 2, 7);

        // iphone 15 dung lượng 256 GB có 2 màu Đen, Trắng giá 20.090.000
        seedDataVariantAtribute("Đen", 1, 8);
        seedDataVariantAtribute("Trắng", 1, 8);
        seedDataVariantAtribute("256GB", 2, 8);

        // iphone 15 dung lượng 512 GB có 2 màu Đen, Trắng giá 25.090.000
        seedDataVariantAtribute("Đen", 1, 9);
        seedDataVariantAtribute("Trắng", 1, 9);
        seedDataVariantAtribute("512GB", 2, 9);

        // iphone 15 Pro Max dung lượng 256 GB có 2 màu Đen, Trắng giá 28.090.000
        seedDataVariantAtribute("Đen", 1, 10);
        seedDataVariantAtribute("Trắng", 1, 10);
        seedDataVariantAtribute("256GB", 2, 10);

        // SamSung
        // Samsung Galaxy S21 FE 5G dung lượng 8GB - 128 GB có 3 màu Trắng,Xám giá 15.090.000
        seedDataVariantAtribute("Trắng", 1, 11);
        seedDataVariantAtribute("Xám", 1, 11);
        seedDataVariantAtribute("8GB - 128GB", 2, 11);

        // Samsung Galaxy S21 dung lượng 256 GB có 3 màu Trắng,Xám giá 20.090.000
        seedDataVariantAtribute("Trắng", 1, 12);
        seedDataVariantAtribute("Xám", 1, 12);
        seedDataVariantAtribute("8GB - 256GB", 2, 12);

        //Samsung Galaxy A55 5G dung lượng 8GB -128GB có 2 màu Đen, Trắng giá 9.690.000
        seedDataVariantAtribute("Đen", 1, 13);
        seedDataVariantAtribute("Trắng", 1, 13);
        seedDataVariantAtribute("8GB - 28GB", 2, 13);

        //Samsung Galaxy A55 5G dung lượng 8GB -256 có 2 màu Đen, Trắng giá 10.790.000
        seedDataVariantAtribute("Đen", 1, 14);
        seedDataVariantAtribute("Trắng", 1, 14);
        seedDataVariantAtribute("8GB - 256GB", 2, 14);

        // Samsung Galaxy Z Fold6 dung lượng 12GB - 256GB có 2 màu Hồng, Xanh dương giá 39.990.000
        seedDataVariantAtribute("Hồng", 1, 15);
        seedDataVariantAtribute("Xanh dương", 1, 15);
        seedDataVariantAtribute("12GB - 256GB", 2, 15);

        // Samsung Galaxy Z Fold6 dung lượng 12GB - 512GB có 2 màu Hồng, Xanh dương giá 43.990.000
        seedDataVariantAtribute("Hồng", 1, 16);
        seedDataVariantAtribute("Xanh dương", 1, 16);
        seedDataVariantAtribute("12GB - 512GB", 2, 16);

        // Xiaomi


        // endregion

    }


    public void seedDataVariant(String image, Double price, int quantity, int product_id) {
        Variant variant = new Variant();
        variant.setImage(image);
        variant.setPrice(price);
        variant.setQuantity(quantity);
        variant.setProducts(productRepository.findById((long) product_id).get());
        variantRepository.save(variant);
    }

    public void seedDataVariantAtribute(String value, int attribute_id, int variant_id) {
     Variant_Attribute variant_attribute = new Variant_Attribute();
        variant_attribute.setValue(value);
        variant_attribute.setAttribute(attributeRepository.findById((long) attribute_id).get());
        variant_attribute.setVariant(variantRepository.findById((long) variant_id).get());
        variantValueRepository.save(variant_attribute);
    }

    public void seedDataProduct(String name, String description, Double weight, int brand_id, int category_id, int warranty_id) {
        Product product = new Product();
        product.setName(name);
        product.setDescription(description);
        product.setWeight(weight);
        product.setBrand(brandRepository.findById((long) brand_id).get());
        product.setCategory(categoryRepository.findById((long) category_id).get());
        product.setWarranty(warrantyRepository.findById((long) warranty_id).get());
        productRepository.save(product);
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

    public void seedDataAttribute(String name) {
        Optional<Attribute> attributes = attributeRepository.findAttributeByName(name);
        if (attributes.isEmpty()) {
            Attribute attribute = new Attribute();
            attribute.setName(name);
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
