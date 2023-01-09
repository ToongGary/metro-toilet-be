CREATE TABLE IF NOT EXISTS station_toilet (
    id INT AUTO_INCREMENT NOT NULL,
    station_id INT NOT NULL,
    toilet_detail_location VARCHAR(255) COMMENT '상세위치',
    toilet_gate_type VARCHAR(255) COMMENT '게이트내외구분',
    toilet_near_exit_number VARCHAR(255) COMMENT '출구번호',
    toilet_floor_type VARCHAR(255) COMMENT '지상구분',
    toilet_floor INT COMMENT '역층',
    toilet_sex_type VARCHAR(255) COMMENT '남녀구분',
    toilet_count INT COMMENT '화장실개수',
    toilet_diaper_count INT COMMENT '기저귀교환대개수',
    operating_agency_code VARCHAR(255) COMMENT '철도운영기관코드',
    created_at DATETIME DEFAULT CURRENT_TIMESTAMP,
    updated_at DATETIME DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
    PRIMARY KEY (id)
)
ENGINE=InnoDB
DEFAULT CHARSET=utf8mb4
COLLATE=utf8mb4_0900_ai_ci
COMMENT='지하철 역 화장실 목록'