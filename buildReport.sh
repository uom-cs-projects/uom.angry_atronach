#!/bin/sh
OUTPUT_DIR=target/report
INPUT_DIR=report

if [ -z "$1" ]
then
  INPUT=$INPUT_DIR/report.latex
else
  INPUT=$INPUT_DIR/$1
fi

mkdir -p $OUTPUT_DIR
pdflatex -output-directory $OUTPUT_DIR $INPUT
