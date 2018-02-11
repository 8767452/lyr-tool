
#生成清除Eclipse项目结构：
exec mvn eclipse:eclipse
exec mvn eclipse:clean

#清理（删除target目录下编译内容）
exec mvn clean
exec mvn clean source:jar javadoc:javadoc install -Dmaven.test.skip=true

