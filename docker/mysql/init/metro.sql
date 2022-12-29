CREATE TABLE IF NOT EXISTS metro (
	id INT AUTO_INCREMENT NOT NULL,
	line_id INT NOT NULL COMMENT '선코드',
	region_code VARCHAR(10) NOT NULL COMMENT '권역코드',
	operating_agency_code VARCHAR(10) NOT NULL COMMENT '철도운영기관코드',
	line_code VARCHAR(10) NOT NULL COMMENT '노선코드',
	line_name VARCHAR(100) NOT NULL COMMENT '노선명',
	station_code VARCHAR(10) NOT NULL COMMENT '역코드',
	station_order INT NOT NULL COMMENT '역구성순서',
	station_name VARCHAR(100) NOT NULL COMMENT '역명',
	PRIMARY KEY (id)
)
ENGINE=InnoDB
DEFAULT CHARSET=utf8mb4
COLLATE=utf8mb4_0900_ai_ci
COMMENT='지하철 역 목록';