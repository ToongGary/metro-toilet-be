CREATE TABLE IF NOT EXISTS metro_toilet (
    id INT AUTO_INCREMENT NOT NULL,
    line_code INT NOT NULL COMMENT '노선코드',
    station_code VARCHAR(10) NOT NULL COMMENT '역코드',
    toilet_detail_location VARCHAR(255) NOT NULL COMMENT '상세위치',
    toilet_gate_type VARCHAR(255) NOT NULL COMMENT '게이트내외구분',
    toilet_near_exit_number INT NOT NULL COMMENT '출구번호',
    toilet_floor_type VARCHAR(255) NOT NULL COMMENT '지상구분',
    toilet_floor INT NOT NULL COMMENT '역층',
    toilet_sex_type VARCHAR(255) NOT NULL COMMENT '남녀구분',
    toilet_count INT NOT NULL COMMENT '화장실개수',
    toilet_diaper_count INT NOT NULL COMMENT '기저귀교환대개수',
    operating_agency_code VARCHAR(255) NOT NULL COMMENT '철도운영기관코드',
    PRIMARY KEY (id)
)
ENGINE=InnoDB
DEFAULT CHARSET=utf8mb4
COLLATE=utf8mb4_0900_ai_ci
COMMENT='지하철 역 화장실 목록'