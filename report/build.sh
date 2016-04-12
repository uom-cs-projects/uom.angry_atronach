#!/bin/sh
OUTPUT_DIR=../target/report

if [ -z "$1" ]
then
  INPUT=main.tex
else
  INPUT=$1
fi

mkdir -p $OUTPUT_DIR

# Run the command twice to ensure the TOC etc are up to date
pdflatex -output-directory $OUTPUT_DIR $INPUT
pdflatex -output-directory $OUTPUT_DIR $INPUT
