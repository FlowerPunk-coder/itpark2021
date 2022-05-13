package exam.controller.rest;

import exam.dto.HouseDto;
import exam.dto.StreetDto;
import exam.service.HouseService;
import exam.service.StreetService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class RestAdminController {

    private final StreetService streetService;
    private final HouseService houseService;

    @RequestMapping("/smc/street/{id}")
    public List<StreetDto> getStreetsById(@PathVariable("id") long id) {
        List<StreetDto> streetsByDistrictName = streetService.getStreetsByDistrictName(id);
        return streetsByDistrictName;
    }


    @RequestMapping("/smc/houses/{id}")
    public List<HouseDto> getHousesById(@PathVariable("id") long id) {
        List<HouseDto> houses = houseService.findByStreetId(id);
        return houses;
    }

    @RequestMapping("/smc/house/{id}")
    public HouseDto getHouse(@PathVariable("id") long id) {
        return houseService.findById(id);
    }





}
