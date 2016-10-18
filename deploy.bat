#!/bin/bash

mvn install -pl web -am && mvn wildfly:deploy -pl web
