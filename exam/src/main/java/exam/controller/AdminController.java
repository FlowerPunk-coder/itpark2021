package exam.controller;


import exam.dto.*;
import exam.service.*;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import javax.transaction.Transactional;
import java.sql.Timestamp;
import java.util.Calendar;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@Controller
@RequiredArgsConstructor
public class AdminController {

    private final StreetService streetService;
    private final DistrictService districtService;
    private final HouseService houseService;
    private final HouseDetailsService houseDetailsService;
    private final EntranceService entranceService;
    private final FireBoxService fireBoxService;




    @GetMapping("/smc")
    public String getDistricts(Model model) {
        List<DistrictDto> districts = districtService.findAll();
        model.addAttribute("districts", districts);
        return "/exam/smc";
    }

    @GetMapping("/add")
    public String addForms(Model model) {
        List<DistrictDto> districts = districtService.findAll();
        model.addAttribute("districts", districts);
        return "/exam/add";
    }


    @GetMapping("/smc/street/add")
    public String addStreetForm(Model model) {
        List<DistrictDto> districts = districtService.findAll();
        model.addAttribute("districts", districts);
        return "/exam/street";
    }

    @PostMapping("/smc/district/save")
    public String saveDistrict(DistrictDto districtDto) {
        districtService.save(districtDto);
        return "redirect:/add";
    }


    @PostMapping("/smc/street/save")
    public String saveStreet(Long streetId, StreetDto streetDto) {
        streetService.save(streetId, streetDto);
        return "redirect:/add";
    }

    @PostMapping("/smc/house/save")
    public String saveHouse(Long houseId, HouseDto houseDto){
        houseService.save(houseId, houseDto);
        return "redirect:/add";
    }

    @GetMapping("/smc/check")
    public String check(long houseId, Model model) {
        HouseDto houseDto = houseService.findById(houseId);
        HouseDetailsDto houseDetailsDto = houseDetailsService.findByHouseIdOrNew(houseId);
        houseDetailsDto.setHouse(houseDto);
        model.addAttribute("address", houseDto);
        model.addAttribute("details", houseDetailsDto);
        return "/exam/check";
    }

    @PostMapping("/smc/houseDetails/save")
    @Transactional
    public String saveHouseDetails(HouseDetailsDto houseDetailsDto, Model model) {
        houseDetailsService.save(houseDetailsDto);
        int count = houseDetailsDto.getNumberOfEntrances();
        List<EntranceDto> entranceDtos = entranceService.findAllEntrancesByHouseDetailsIdOrNew(houseDetailsDto.getId());
        if (entranceDtos.size() == 0) {
            entranceDtos = IntStream.range(0, count)
                    .mapToObj(e -> new EntranceDto())
                    .peek(e -> e.setHouseDetails(houseDetailsDto))
                    .collect(Collectors.toList());
        }
        model.addAttribute("entrances", entranceDtos);
        return "/exam/entrance";
    }

    @PostMapping("/smc/entrance/save")
    @Transactional
    public String saveEntrance(long houseDetailsId, long houseId, EntranceDto entranceDto) {
        HouseDto house = houseService.findById(houseId);
        house.setDate(Timestamp.from(Calendar.getInstance().toInstant()));
        house.setChecked(true);
        houseService.update(house);
        HouseDetailsDto houseDetailsDto = houseDetailsService.findByHouseIdOrException(houseDetailsId);
        entranceDto.setHouseDetails(houseDetailsDto);
        entranceService.save(entranceDto);
        return "redirect:/smc";
    }
}
