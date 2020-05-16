#!/usr/bin/env bash
javahome='/opt/java8-oracle/jdk1.8.0_181'
M2_HOME='/usr/share/maven'
export M2_HOME
M2=${M2_HOME}
export M2
mvn=${M2}/bin/mvn
export JAVA_HOME=${javahome}
cd ../
${mvn} clean install