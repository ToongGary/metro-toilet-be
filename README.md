# Metro Toilet Backend

**Docker compose**
```
docker compose up -d db
gradle jibDockerBuild --image=metro-toilet-be
docker compose up -d metro-toilet-be
```