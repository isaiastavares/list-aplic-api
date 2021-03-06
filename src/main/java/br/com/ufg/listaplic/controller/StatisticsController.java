package br.com.ufg.listaplic.controller;

import br.com.ufg.listaplic.dto.StatisticsDTO;
import br.com.ufg.listaplic.service.StatisticsService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/statistics")
@Api(value = "statistics")
public class StatisticsController {

    @Autowired
    StatisticsService statisticsService;

    @ApiOperation(
            value = "Get classroom statistics",
            response = StatisticsDTO.class
    )
    @ApiResponse(
            code = 200,
            message = "Classroom statistics",
            response = StatisticsDTO.class
    )
    @GetMapping("/classroom/{id}")
    @ResponseStatus(HttpStatus.OK)
    public StatisticsDTO getClassroomStatistics(@PathVariable("id") UUID classroomId) {
        return statisticsService.calculateClassroomStatistics(classroomId);
    }

    @ApiOperation(
            value = "Get instructor statistics",
            response = StatisticsDTO.class
    )
    @ApiResponse(
            code = 200,
            message = "Instructor statistics",
            response = StatisticsDTO.class
    )
    @GetMapping("/instructor/{id}")
    @ResponseStatus(HttpStatus.OK)
    public StatisticsDTO getInstructorStatistics(@PathVariable("id") String instructorId) {
        return statisticsService.calculateInstructorStatistics(instructorId);
    }
}
