# Hadoop Example

腾讯俱乐部技术部二面面试题-03数据

## Usage

Windows

```shell
./gradlew.bat -Pinput=input/ -Poutput=out/ run
```

Mac & Linux

```shell
./gradlew -Pinput=input/ -Poutput=out/ run
```

Tips: 

-   需使用管理员用户执行命令
-   需要设置`HADOOP_HOME`环境变量
-   命令中的`input/`和`output/`可以替换为自定义的输入输出目录

 ## Output

省份编号为奇数的城市位于`output/part-r-00001`文件中，省份编号为偶数的城市位于`output/part-r-00000`文件中