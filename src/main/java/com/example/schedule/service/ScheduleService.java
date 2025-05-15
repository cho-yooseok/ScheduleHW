package com.example.schedule.service;

import com.example.schedule.entity.Schedule;
import com.example.schedule.repository.ScheduleRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ScheduleService {

	private final ScheduleRepository scheduleRepository;

	// 일정 생성
	@Transactional
	public Schedule createSchedule(Schedule schedule) {
		return scheduleRepository.save(schedule);
	}

	// 전체 일정 목록 조회
	@Transactional(readOnly = true)
	public List<Schedule> getAllSchedules() {
		return scheduleRepository.findAll();
	}

	// 단일 일정 조회
	@Transactional(readOnly = true)
	public Schedule getScheduleById(Long id) {
		return scheduleRepository.findById(id)
			.orElseThrow(() -> new RuntimeException("일정을 찾을 수 없습니다. ID: " + id));
	}

	// 일정 수정
	@Transactional
	public Schedule updateSchedule(Long id, Schedule scheduleDetails) {
		Schedule schedule = getScheduleById(id);

		schedule.setTitle(scheduleDetails.getTitle());
		schedule.setContent(scheduleDetails.getContent());

		return scheduleRepository.save(schedule);
	}

	// 일정 삭제
	@Transactional
	public void deleteSchedule(Long id) {
		Schedule schedule = getScheduleById(id);
		scheduleRepository.delete(schedule);
	}
}
