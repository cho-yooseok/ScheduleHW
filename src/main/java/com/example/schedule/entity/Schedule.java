package com.example.schedule.entity;

import jakarta.persistence.Column;
import jakarta.persistence.EntityListeners;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import jakarta.persistence.Entity;
import java.time.LocalDateTime;
import jakarta.persistence.Id;


@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@EntityListeners(AuditingEntityListener.class)  // JPA Auditing 기능 사용
public class Schedule {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(nullable = false)
	private String title;  // 일정 제목

	@Column(nullable = false)
	private String content;  // 일정 내용

	@Column(nullable = false)
	private String writerId;  // 작성자 ID

	@CreatedDate  // 생성 시간 자동 저장
	@Column(updatable = false)
	private LocalDateTime createdAt;  // 작성일

	@LastModifiedDate  // 수정 시간 자동 저장
	private LocalDateTime updatedAt;  // 수정일
}