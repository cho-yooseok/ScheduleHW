package com.example.schedule.controller;

import com.example.schedule.entity.Schedule;
import com.example.schedule.service.ScheduleService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/schedules")
@RequiredArgsConstructor
public class ScheduleController {

	private final ScheduleService scheduleService;

	// 일정 생성
	@PostMapping
	public ResponseEntity<Schedule> createSchedule(@RequestBody Schedule schedule) {
		return ResponseEntity.ok(scheduleService.createSchedule(schedule));
	}

	// 전체 일정 목록 조회
	@GetMapping
	public ResponseEntity<List<Schedule>> getAllSchedules() {
		return ResponseEntity.ok(scheduleService.getAllSchedules());
	}

	// 단일 일정 조회
	@GetMapping("/{id}")
	public ResponseEntity<Schedule> getScheduleById(@PathVariable Long id) {
		return ResponseEntity.ok(scheduleService.getScheduleById(id));
	}

	// 일정 수정
	@PutMapping("/{id}")
	public ResponseEntity<Schedule> updateSchedule(@PathVariable Long id, @RequestBody Schedule scheduleDetails) {
		return ResponseEntity.ok(scheduleService.updateSchedule(id, scheduleDetails));
	}

	// 일정 삭제
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deleteSchedule(@PathVariable Long id) {
		scheduleService.deleteSchedule(id);
		return ResponseEntity.ok().build();
	}
}