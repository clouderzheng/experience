

xml����
<build>
    <finalName>test</finalName>
    <!--
    ����Ҳ���԰����е�xml�ļ����������Ӧλ�á�
    <resources>
        <resource>
            <directory>src/main/resources</directory>
            <includes>
                <include>**/*.properties</include>
                <include>**/*.xml</include>
                <include>**/*.tld</include>
            </includes>
            <filtering>false</filtering><--������false����true�ᱨ ���ݿ����� ����-->
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

����2������build-helper-maven-plugin���

<build>
    ...
    </plugins>
        ...
        <!--
        ��plugin������
        ���ô�plugin����Դ�����е�xml�ļ���
        �������Ӧλ�ã�������Ҫ��Ϊ�˴��Mybatis��mapper.xml�ļ� 
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

����3������maven-resources-plugin���

<build>
    ...
    </plugins>
        ...
        <!--
        ��plugin������
        ���ô�plugin����Դ�����е�xml�ļ����������Ӧλ�ã�
        ������Ҫ��Ϊ�˴��Mybatis��mapper.xml�ļ� 
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


maven�������ʾ�Ҳ�������


��Ӳ�� 
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


