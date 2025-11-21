#!/bin/bash

# Chemins
PROJECT_DIR="$(pwd)"
SRC_DIR="$PROJECT_DIR/src"
WEB_INF_CLASSES="$PROJECT_DIR/WEB-INF/classes"
LIB_DIR="$PROJECT_DIR/WEB-INF/lib"
TOMCAT_WEBAPP_DIR="/home/antonio/Documents/apache-tomcat-10.1.48/webapps/test"

# Crée le répertoire classes si nécessaire
mkdir -p "$WEB_INF_CLASSES"

echo "Compilation des fichiers Java..."
# Compiler tous les fichiers .java de src vers WEB-INF/classes en incluant test.jar
find "$SRC_DIR" -name "*.java" > sources.txt

if [ -s sources.txt ]; then
    javac -d "$WEB_INF_CLASSES" -cp "$LIB_DIR/test.jar" @sources.txt
    if [ $? -ne 0 ]; then
        echo "Erreur lors de la compilation."
        rm sources.txt
        exit 1
    fi
    echo "Compilation terminée."
else
    echo "Aucun fichier Java trouvé dans $SRC_DIR"
fi
rm sources.txt

echo "Déploiement des fichiers vers Tomcat..."
# Copier tout sauf src et lib
rsync -av --exclude='src' --exclude='WEB-INF/lib' --exclude='deploy.sh' "$PROJECT_DIR/" "$TOMCAT_WEBAPP_DIR/"

echo "Déploiement terminé."
