package com.chunjae.practice6.service.source.dto;

import com.chunjae.practice6.domain.entity.Funnel;
import com.chunjae.practice6.domain.entity.Source;
import lombok.Data;

import javax.persistence.Column;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.time.LocalDateTime;

@Data
public class DefaultSourceDto {
    Source source;
    Funnel funnel;
}
