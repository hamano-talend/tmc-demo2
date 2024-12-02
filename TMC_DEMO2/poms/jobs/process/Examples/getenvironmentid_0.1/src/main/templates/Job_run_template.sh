#!/bin/sh
cd `dirname $0`
ROOT_PATH=`pwd`
java -Dtalend.component.manager.m2.repository=$ROOT_PATH/../lib -Xms256M -Xmx1024M -Dfile.encoding=UTF-8 -cp .:$ROOT_PATH:$ROOT_PATH/../lib/routines.jar:$ROOT_PATH/../lib/log4j-slf4j-impl-2.17.1.jar:$ROOT_PATH/../lib/log4j-api-2.17.1.jar:$ROOT_PATH/../lib/log4j-core-2.17.1.jar:$ROOT_PATH/../lib/jaxb-runtime-2.3.5.jar:$ROOT_PATH/../lib/avro-1.8.2.jar:$ROOT_PATH/../lib/geronimo-jsonb_1.0_spec-1.2.jar:$ROOT_PATH/../lib/json-smart-2.4.11.jar:$ROOT_PATH/../lib/rhino-1.7.14.jar:$ROOT_PATH/../lib/saaj-impl-1.5.3.jar:$ROOT_PATH/../lib/cxf-rt-transports-http-3.5.5.jar:$ROOT_PATH/../lib/geronimo-jta_1.1_spec-1.1.1.jar:$ROOT_PATH/../lib/common-httpclient-1.49.0.jar:$ROOT_PATH/../lib/stream-json-1.49.0.jar:$ROOT_PATH/../lib/jakarta.annotation-api-1.3.5.jar:$ROOT_PATH/../lib/job-audit-1.5.jar:$ROOT_PATH/../lib/jackson-mapper-asl-1.9.16-TALEND.jar:$ROOT_PATH/../lib/stax2-api-4.2.1.jar:$ROOT_PATH/../lib/talend_file_enhanced-1.3.jar:$ROOT_PATH/../lib/common-1.49.0.jar:$ROOT_PATH/../lib/jakarta.jws-api-2.1.0.jar:$ROOT_PATH/../lib/org.talend.maplang.hpath-1.6.1.jar:$ROOT_PATH/../lib/jakarta.xml.ws-api-2.3.3.jar:$ROOT_PATH/../lib/org.talend.maplang.selector.interpreter-1.6.1.jar:$ROOT_PATH/../lib/org.talend.maplang.selector.parser-1.6.1.jar:$ROOT_PATH/../lib/xmlschema-core-2.3.0.jar:$ROOT_PATH/../lib/johnzon-jsonb-1.2.20.jar:$ROOT_PATH/../lib/commons-compress-1.21.jar:$ROOT_PATH/../lib/component-runtime-manager-1.59.0.jar:$ROOT_PATH/../lib/daikon-url-validation-6.4.2.jar:$ROOT_PATH/../lib/stream-rawtext-1.49.0.jar:$ROOT_PATH/../lib/geronimo-annotation_1.3_spec-1.2.jar:$ROOT_PATH/../lib/http-common-1.49.0.jar:$ROOT_PATH/../lib/jakarta.xml.bind-api-2.3.3.jar:$ROOT_PATH/../lib/org.talend.maplang.el.interpreter-1.6.1.jar:$ROOT_PATH/../lib/org.talend.maplang.mql.parser-1.6.1.jar:$ROOT_PATH/../lib/commons-lang3-3.10.jar:$ROOT_PATH/../lib/component-api-1.59.0.jar:$ROOT_PATH/../lib/tck-dsl-1.49.0.jar:$ROOT_PATH/../lib/component-runtime-design-extension-1.59.0.jar:$ROOT_PATH/../lib/cxf-rt-security-3.5.5.jar:$ROOT_PATH/../lib/stax-ex-1.8.3.jar:$ROOT_PATH/../lib/audit-common-1.16.1.jar:$ROOT_PATH/../lib/istack-commons-runtime-3.0.12.jar:$ROOT_PATH/../lib/snappy-java-1.1.10.1.jar:$ROOT_PATH/../lib/jakarta.activation-api-1.2.2.jar:$ROOT_PATH/../lib/cxf-rt-frontend-jaxrs-3.5.5.jar:$ROOT_PATH/../lib/jackson-core-asl-1.9.16-TALEND.jar:$ROOT_PATH/../lib/component-runtime-di-1.59.0.jar:$ROOT_PATH/../lib/jboss-marshalling-2.0.12.Final.jar:$ROOT_PATH/../lib/johnzon-core-1.2.20.jar:$ROOT_PATH/../lib/xbean-reflect-4.20.jar:$ROOT_PATH/../lib/cxf-core-3.5.5.jar:$ROOT_PATH/../lib/container-core-1.59.0.jar:$ROOT_PATH/../lib/javax.mail-1.6.2.jar:$ROOT_PATH/../lib/slf4j-api-1.7.34.jar:$ROOT_PATH/../lib/jakarta.activation-1.2.2.jar:$ROOT_PATH/../lib/dom4j-2.1.3.jar:$ROOT_PATH/../lib/stream-api-1.49.0.jar:$ROOT_PATH/../lib/org.talend.maplang.mql.interpreter-1.6.1.jar:$ROOT_PATH/../lib/activation-1.1.jar:$ROOT_PATH/../lib/xbean-finder-shaded-4.20.jar:$ROOT_PATH/../lib/xbean-asm9-shaded-4.20.jar:$ROOT_PATH/../lib/accessors-smart-2.4.11.jar:$ROOT_PATH/../lib/txw2-2.3.5.jar:$ROOT_PATH/../lib/component-spi-1.59.0.jar:$ROOT_PATH/../lib/geronimo-json_1.1_spec-1.3.jar:$ROOT_PATH/../lib/org.talend.maplang.el.parser-1.6.1.jar:$ROOT_PATH/../lib/audit-log4j2-1.16.1.jar:$ROOT_PATH/../lib/http-studio-1.49.0.jar:$ROOT_PATH/../lib/http-common-ee-1.49.0.jar:$ROOT_PATH/../lib/johnzon-mapper-1.2.20.jar:$ROOT_PATH/../lib/logging-event-layout-1.16.1.jar:$ROOT_PATH/../lib/jakarta.ws.rs-api-2.1.6.jar:$ROOT_PATH/../lib/common-io-1.49.0.jar:$ROOT_PATH/../lib/crypto-utils-7.0.5.jar:$ROOT_PATH/../lib/asm-9.5.jar:$ROOT_PATH/../lib/jakarta.xml.soap-api-1.4.2.jar:$ROOT_PATH/../lib/cxf-rt-rs-client-3.5.5.jar:$ROOT_PATH/../lib/woodstox-core-6.5.0.jar:$ROOT_PATH/../lib/dssl-dictionary-1.49.0.jar:$ROOT_PATH/../lib/polling-1.49.0.jar:$ROOT_PATH/../lib/component-runtime-impl-1.59.0.jar:$ROOT_PATH/getenvironmentid_0_1.jar: tmc_demo2.getenvironmentid_0_1.getEnvironmentID "$@"