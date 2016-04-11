#!/bin/sh
OUTPUT=target/report
INPUT=report/hello.latex

mkdir -p $OUTPUT
pdflatex -output-directory $OUTPUT $INPUT
