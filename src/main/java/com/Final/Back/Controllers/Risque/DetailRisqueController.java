package com.Final.Back.Controllers.Risque;

import com.Final.Back.Modles.Risques.DetailRisque;
import com.Final.Back.Services.RisqueServ.DetailRisqueService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/admin/detail-risque")
public class DetailRisqueController {

    private final DetailRisqueService detailRisqueService;

    @Autowired
    public DetailRisqueController(DetailRisqueService detailRisqueService) {
        this.detailRisqueService = detailRisqueService;
    }

    @GetMapping("/all")
    public List<DetailRisque> getAllDetailRisques() {
        return detailRisqueService.getAllDetailRisques();
    }

    @GetMapping("/{id}")
    public Optional<DetailRisque> getDetailRisqueById(@PathVariable Long id) {
        return detailRisqueService.getDetailRisqueById(id);
    }

    @PostMapping("/add")
    public DetailRisque saveDetailRisque(@RequestBody DetailRisque detailRisque) {
        return detailRisqueService.saveDetailRisque(detailRisque);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteDetailRisqueById(@PathVariable Long id) {
        detailRisqueService.deleteDetailRisqueById(id);
    }
}
