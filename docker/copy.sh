#!/bin/sh

# 复制项目的文件到对应docker路径，便于一键生成镜像。
usage() {
	echo "Usage: sh copy.sh"
	exit 1
}


# copy sql
echo "begin copy sql "
cp ../sql/ry_20230706.sql ./mysql/db
cp ../sql/ry_config_20220929.sql ./mysql/db

# copy html
echo "begin copy html "
cp -r ../swpu-ui/dist/** ./nginx/html/dist


# copy jar
echo "begin copy swpu-gateway "
cp ../swpu-gateway/target/swpu-gateway.jar ./swpu/gateway/jar

echo "begin copy swpu-auth "
cp ../swpu-auth/target/swpu-auth.jar ./swpu/auth/jar

echo "begin copy swpu-visual "
cp ../swpu-visual/swpu-monitor/target/swpu-visual-monitor.jar  ./swpu/visual/monitor/jar

echo "begin copy swpu-modules-system "
cp ../swpu-modules/swpu-system/target/swpu-modules-system.jar ./swpu/modules/system/jar

echo "begin copy swpu-modules-file "
cp ../swpu-modules/swpu-file/target/swpu-modules-file.jar ./swpu/modules/file/jar

echo "begin copy swpu-modules-job "
cp ../swpu-modules/swpu-job/target/swpu-modules-job.jar ./swpu/modules/job/jar

echo "begin copy swpu-modules-gen "
cp ../swpu-modules/swpu-gen/target/swpu-modules-gen.jar ./swpu/modules/gen/jar

