#!/bin/bash

# Requirements hlm_backend
HLM_POSTGRES_DB=bizbook_test
HLM_POSTGRES_SCHEMA=healenium
HLM_POSTGRES_USER=bizbook
HLM_POSTGRES_PASSWORD=bizbook123
HLM_COLLECT_METRICS=true
HLM_SERVER_PORT=7878

# Deploy the services
SPRING_POSTGRES_DB=$HLM_POSTGRES_DB SPRING_POSTGRES_SCHEMA=$HLM_POSTGRES_SCHEMA SPRING_POSTGRES_USER=$HLM_POSTGRES_USER SPRING_POSTGRES_PASSWORD=$HLM_POSTGRES_PASSWORD COLLECT_METRICS=$HLM_COLLECT_METRICS SPRING_SERVER_PORT=$HLM_SERVER_PORT SPRING_POSTGRES_DB_HOST=bizbook-dev-db-cluster.ccoyob2ajd8x.us-east-1.rds.amazonaws.com java -jar hlm-backend.jar 2>&1 &

pip install --upgrade pip

pip install -r healenium-selector-imitator/requirements.txt

if [[ $OSTYPE == 'msys'* ]];
then
  python healenium-selector-imitator/app.py
else
  python3 healenium-selector-imitator/app.py
fi
