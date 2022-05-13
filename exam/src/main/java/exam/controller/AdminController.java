package exam.controller;


import exam.dto.DistrictDto;
import exam.dto.StreetDto;
import exam.service.DistrictService;
import exam.service.StreetService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class AdminController {

    private final StreetService streetService;
    private final DistrictService districtService;



    @GetMapping("/smc")
    public String getDistricts(Model model) {
        List<DistrictDto> districts = districtService.findAll();
        model.addAttribute("districts", districts);
        return "/exam/smc";
    }

    @GetMapping("/smc/addStreet")
    public String addStreet(Model model) {
        List<DistrictDto> districts = districtService.findAll();
        model.addAttribute("districts", districts);
        return "/exam/street";
    }

    @PostMapping("/smc/street/save")
    public String saveStreet(Long id, String name) {
        DistrictDto districtDto = districtService.findById(id);
        StreetDto streetDto = new StreetDto(name, districtDto);
        streetService.save(streetDto);
        return "/exam/smc";
    }

  /*  @PostMapping("/smc/check")
    public String getStreets(Model model) {
        List<StreetDto> streets = streetService.getStreetsByDistrictName(id);
        List<DistrictDto> districts = districtService.findAll();
        model.addAttribute("districts", districts);
        model.addAttribute("streets", streets);
        return "/exam/check";
    }*/
}
