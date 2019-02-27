

xml代码
<build>
    <finalName>test</finalName>
    <!--
    这样也可以把所有的xml文件，打包到相应位置。
    <resources>
        <resource>
            <directory>src/main/resources</directory>
            <includes>
                <include>**/*.properties</include>
                <include>**/*.xml</include>
                <include>**/*.tld</include>
            </includes>
            <filtering>false</filtering><--这里是false，用true会报 数据库连接 错误-->
        </resource>
        <resource>
            <directory>src/main/java</directory>
            <includes>
                <include>**/*.properties</include>
                <include>**/*.xml</include>
                <include>**/*.tld</include>
            </includes>
            <filtering>false</filtering>
        </resource>
    </resources>
</build>

方法2，利用build-helper-maven-plugin插件

<build>
    ...
    </plugins>
        ...
        <!--
        此plugin可以用
        利用此plugin，把源代码中的xml文件，
        打包到相应位置，这里主要是为了打包Mybatis的mapper.xml文件 
        -->
        <plugin>
            <groupId>org.codehaus.mojo</groupId>
            <artifactId>build-helper-maven-plugin</artifactId>
            <version>1.8</version>
            <executions>
                <execution>
                    <id>add-resource</id>
                    <phase>generate-resources</phase>
                    <goals>
                        <goal>add-resource</goal>
                    </goals>
                    <configuration>
                        <resources>
                            <resource>
                                <directory>src/main/java</directory>
                                <includes>
                                    <include>**/*.xml</include>
                                </includes>
                            </resource>
                        </resources>
                    </configuration>
                </execution>
            </executions>
        </plugin>   
        ...
    </plugins>     
    ...
</build>

方法3，利用maven-resources-plugin插件

<build>
    ...
    </plugins>
        ...
        <!--
        此plugin可以用
        利用此plugin，把源代码中的xml文件，打包到相应位置，
        这里主要是为了打包Mybatis的mapper.xml文件 
        -->
        <plugin>
            <artifactId>maven-resources-plugin</artifactId>
            <version>2.5</version>
            <executions>
                <execution>
                    <id>copy-xmls</id>
                    <phase>process-sources</phase>
                    <goals>
                        <goal>copy-resources</goal>
                    </goals>
                    <configuration>
                        <outputDirectory>${basedir}/target/classes</outputDirectory>
                        <resources>
                            <resource>
                                <directory>${basedir}/src/main/java</directory>
                                <includes>
                                    <include>**/*.xml</include>
                                </includes>
                            </resource>
                        </resources>
                    </configuration>
                </execution>
            </executions>
        </plugin>   
        ...
    </plugins>     
    ...
</build>


maven打包，提示找不到符号


添加插件 
<plugin>
				<groupId>org.codehaus.mojo</groupId>
				<artifactId>build-helper-maven-plugin</artifactId>
				<executions>
					<execution>
						<id>add-source</id>
						<phase>generate-sources</phase>
						<goals>
							<goal>add-source</goal>
						</goals>
						<configuration>
							<sources>
								<source>src/main/pay</source>
								

							</sources>
						</configuration>
					</execution>
				</executions>
			</plugin> 


