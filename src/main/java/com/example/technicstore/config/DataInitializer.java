package com.example.technicstore.config;

import com.example.technicstore.TechnicStoreApplication;
import com.example.technicstore.entity.*;
import com.example.technicstore.entity.Module;
import com.example.technicstore.repository.*;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
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
    public DataInitializer(CustomerRepository customerRepository, AttributeRepository attributeRepository, BrandRepository brandRepository, CategoryRepository categoryRepository, SupplierRepository supplierRepository, CarrierRepository carrierRepository, WarrantyRepository warrantyRepository, RoleRepository roleRepository, FunctionRepository functionRepository, ModuleRepository moduleRepository, DecentralizationRepository decentralizationRepository) {
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
        seedDataAttribute("Bộ nhớ");
        seedDataAttribute("RAM");
        //endregion

        // region brand
        seedDataBrand("Apple");
        seedDataBrand("Samsung");
        seedDataBrand("Dell");
        seedDataBrand("HP");
        seedDataBrand("Lenovo");
        seedDataBrand("Xiaomi");
        seedDataBrand("Asus");
        seedDataBrand("Sony");
        seedDataBrand("Microsoft");
        seedDataBrand("Huawei");
        // endregion

        // region category
        seedDataCategory("Điện thoại di động");
        seedDataCategory("Laptop");
        seedDataCategory("Máy tính bảng");
        seedDataCategory("Tai nghe");
        seedDataCategory("Smartwatch");
        seedDataCategory("Phụ kiện");
        seedDataCategory("Thiết bị mạng");
        seedDataCategory("Thiết bị gia dụng");
        seedDataCategory("Đồ chơi công nghệ");
        // endregion

        // region supplier
        seedDataSupplier("Apple", "apple@gmail.com", "0123456789");
        seedDataSupplier("Samsung", "samsung@gmail.com", "0987654321");
        seedDataSupplier("Dell", "dell@gmail.com", "0112233445");
        seedDataSupplier("HP", "hp@gmail.com", "0223344556");
        seedDataSupplier("Lenovo", "lenovo@gmail.com", "0334455667");
        seedDataSupplier("Xiaomi", "xiaomi@gmail.com", "0445566778");
        seedDataSupplier("Asus", "asus@gmail.com", "0556677889");
        seedDataSupplier("Sony", "sony@gmail.com", "0667788990");
        seedDataSupplier("Microsoft", "microsoft@gmail.com", "0778899001");
        seedDataSupplier("Huawei", "huawei@gmail.com", "0889900112");
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
        seedDataWarranty("Bảo hành 10 ngày", "Ngày", 10);
        seedDataWarranty("Bảo hành 10 ngày", "Ngày", 10);
        seedDataWarranty("Bảo hành 1 tháng", "Tháng", 1);
        seedDataWarranty("Bảo hành 6 tháng", "Tháng", 6);
        seedDataWarranty("Bảo hành 1 năm", "Năm", 1);
        seedDataWarranty("Bảo hành 2 năm", "Năm", 2);
        seedDataWarranty("Bảo hành 3 tháng", "Tháng", 3);
        seedDataWarranty("Bảo hành 30 ngày", "Ngày", 30);
        seedDataWarranty("Bảo hành 90 ngày", "Ngày", 90);
        // endregion
    }

    public void seedDataCustomer(String name, String phone, String address, String email, String district, String city) {
        Optional<Customer> customers = customerRepository.findCustomerByPhoneOrEmail(phone, email);
        if (customers.isEmpty()) {
            Customer customer = new Customer(name, email, phone, address, district, city);
            customerRepository.save(customer);
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

    public void seedDataSupplier(String name, String email, String phone) {
        Optional<Supplier> suppliers = supplierRepository.findSupplierByName(name);
        if (suppliers.isEmpty()) {
            Supplier supplier = new Supplier();
            supplier.setName(name);
            supplier.setEmail(email);
            supplier.setPhone(phone);
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

    public void seedDataWarranty(String name, String unit , int value) {
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
    public static void main(String[] args) {
        // thêm data vào database


    }
}
