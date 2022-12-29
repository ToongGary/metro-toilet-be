CREATE TABLE IF NOT EXISTS metro_toilet (
    id INT AUTO_INCREMENT NOT NULL,
    line_id INT NOT NULL COMMENT '선코드',
    station_code VARCHAR(10) NOT NULL COMMENT '역코드',
    diaper_exchange_station_count INT NOT NULL COMMENT '기저귀교환대개수',
    detailed_location VARCHAR(255) NOT NULL COMMENT '상세위치',
    exit_number INT NOT NULL COMMENT '출구번호',
    gate_inside_outside_division VARCHAR(255) NOT NULL COMMENT '게이트내외구분',
    ground_division VARCHAR(255) NOT NULL COMMENT '지상구분',
    male_female_division VARCHAR(255) NOT NULL COMMENT '남녀구분',
    railway_operating_agency_code VARCHAR(255) NOT NULL COMMENT '철도운영기관코드',
    station_floor INT NOT NULL COMMENT '역층',
    toilet_count INT NOT NULL COMMENT '화장실개수',
    PRIMARY KEY (id)
)
ENGINE=InnoDB
DEFAULT CHARSET=utf8mb4
COLLATE=utf8mb4_0900_ai_ci
COMMENT='지하철 역 시설 목록'