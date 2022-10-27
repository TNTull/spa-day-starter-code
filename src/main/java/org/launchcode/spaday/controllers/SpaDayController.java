//Teresa Tull worked on this on 10-22-2022 java ch 13 studio in class
//Teresa Tull worked on this on 10-24-2022 java ch 14 studio in class

package org.launchcode.spaday.controllers;

import org.launchcode.spaday.models.Client;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import java.util.ArrayList;


@Controller
public class SpaDayController {

    @GetMapping
    public String customerForm () {
        return "serviceSelection";

    // below was for ch 13
//    public boolean checkSkinType(String skinType, String facialType) {
//        if (skinType.equals("oily")) {
//            return facialType.equals("Microdermabrasion") || facialType.equals("Rejuvenating");
//        }
//        else if (skinType.equals("combination")) {
//            return facialType.equals("Microdermabrasion") || facialType.equals("Rejuvenating") || facialType.equals("Enzyme Peel");
//        }
//        else if (skinType.equals("dry")) {
//            return facialType.equals("Rejuvenating") || facialType.equals("Hydrofacial");
//        }
//        else {
//            return true;
//        }
    }

    //customer form was for ch 13
//    @GetMapping(value="")
//    @ResponseBody
//    public String customerForm () {
//        String html = "<form method = 'post' action = '/menu'>" +
//                "Name: <br>" +
//                "<input type = 'text' name = 'name'>" +
//                "<br>Skin type: <br>" +
//                "<select name = 'skintype'>" +
//                "<option value = 'oily'>Oily</option>" +
//                "<option value = 'combination'>Combination</option>" +
//                "<option value = 'normal'>Normal</option>" +
//                "<option value = 'dry'>Dry</option>" +
//                "</select><br>" +
//                "Manicure or Pedicure? <br>" +
//                "<select name = 'manipedi'>" +
//                "<option value = 'manicure'>Manicure</option>" +
//                "<option value = 'pedicure'>Pedicure</option>" +
//                "<option value = 'both'>Both</option>" +
//                "</select><br>" +
//                "<input type = 'submit' value = 'Submit'>" +
//                "</form>";
//        return html;
//    }

    // for ch 14
    @PostMapping
    public String spaMenu(@RequestParam String skintype, @RequestParam String manipedi, Model model) {

        Client newClient = new Client(skintype, manipedi);
        newClient.setAppropriateFacials(skintype);
        model.addAttribute("client" , newClient);

        return "menu";
    }

        // below was for ch 13
//    @PostMapping(value="menu")
//    public String spaMenu(@RequestParam String name, @RequestParam String skintype, @RequestParam String manipedi, Model model) {
//
//        ArrayList<String> facials = new ArrayList<>();
//        facials.add("Microdermabrasion");
//        facials.add("Hydrofacial");
//        facials.add("Rejuvenating");
//        facials.add("Enzyme Peel");
//
//        ArrayList<String> appropriateFacials = new ArrayList<>();
//        for (int i = 0; i < facials.size(); i ++) {
//            if (checkSkinType(skintype,facials.get(i))) {
//                appropriateFacials.add(facials.get(i));
//            }
//        }
//        model.addAttribute("name",name);
//        model.addAttribute("skintype",skintype);
//        model.addAttribute("manipedi",manipedi);
//        model.addAttribute("appropriateFacials",appropriateFacials);
//        return "menu";
//    }
}
