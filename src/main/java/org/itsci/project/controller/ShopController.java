package org.itsci.project.controller;

import org.itsci.project.model.Product;
import org.itsci.project.model.Shop;
import org.itsci.project.service.ProductService;
import org.itsci.project.service.ShopService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping("/shop")
public class ShopController {

    private String title = "ร้านค้า";

    @Autowired
    private ShopService shopService;

    @Autowired
    private ProductService productService;

    @GetMapping("/list")
    public String listShop(Model model) {
        model.addAttribute("title", "รายการ" + title);
        model.addAttribute("shops", shopService.getShops());
        return "shop/list";
    }

    @GetMapping("/create")
    public String showFormForAdd(Model model) {
        model.addAttribute("title", "เพิ่ม" + title);
        model.addAttribute("shop", new Shop());
        return "shop/shop-form";
    }

    @GetMapping("/{id}/update")
    public String showFormForUpdate(@PathVariable("id") int id, Model model) {
        Shop shop = shopService.getShop(id);
        model.addAttribute("title", "แก้ไข" + title);
        model.addAttribute("shop", shop);
        return "shop/shop-form";
    }

    @RequestMapping(path = "/save", method = RequestMethod.POST)
    public String processForm(@Valid @ModelAttribute("shop") Shop shop, BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()) {
            model.addAttribute("title", "มีข้อผิดพลาดในการบันทึก" + title);
            return "shop/shop-form";
        } else {
            Shop entityShop = shopService.getShop(shop.getId());
            if (entityShop != null) {
                shopService.updateShop(entityShop, shop);
            } else {
                shopService.saveShop(shop);
            }
            return "redirect:/shop/list";
        }
    }

    @InitBinder
    public void initBinder(WebDataBinder dataBinder) {
        StringTrimmerEditor stringTrimmerEditor = new StringTrimmerEditor(true);
        dataBinder.registerCustomEditor(String.class, stringTrimmerEditor);
    }

    @GetMapping("/{id}/delete")
    public String deleteProduct(@PathVariable("id") int id) {
        shopService.deleteShop(id);
        return "redirect:/shop/list";
    }

    @GetMapping("/{id}/view-products")
    public String shopViewProduct(@PathVariable("id") int id, Model model) {
        Shop shop = shopService.getShop(id);
        model.addAttribute("title", title + " - รายการสินค้า");
        model.addAttribute("shop", shop);
        model.addAttribute("products", shop.getProducts());
        return "shop/shop-view-products";
    }

    @GetMapping("/{id}/product/add")
    public String showProductForAdd(@PathVariable("id") int id, Model model) {
        Shop shop = shopService.getShop(id);
        List<Product> products = productService.getProductDoesNotHaveShop(id);
        model.addAttribute("title", "เพิ่มสินค้า");
        model.addAttribute("shop", shop);
        model.addAttribute("products", products);
        return "shop/product-list";
    }

}
