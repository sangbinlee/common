# TODO

### local dev set
	echo "# common" >> README.md
	git init
	git add README.md
	git commit -m "first commit"
	git branch -M main
	git remote add origin https://github.com/sangbinlee/common.git
	git push -u origin main


### local dev test

	C:\backend\workspace-spring-tool-suite-4-4.24.0.RELEASE\common>gradlew bootJar
	
	Welcome to Gradle 8.8!
	
	Here are the highlights of this release:
	 - Running Gradle on Java 22
	 - Configurable Gradle daemon JVM
	 - Improved IDE performance for large projects
	
	For more details see https://docs.gradle.org/8.8/release-notes.html
	
	Starting a Gradle Daemon, 1 incompatible Daemon could not be reused, use --status for details
	
	BUILD SUCCESSFUL in 21s
	4 actionable tasks: 4 executed
	C:\backend\workspace-spring-tool-suite-4-4.24.0.RELEASE\common>
	


### db set - mysql
	revoke all on mydatabase.* from 'myuser'@'%';
	grant select, insert, delete, update on mydatabase.* to 'myuser'@'%';

### 1. 실행 (gradlew)

	gradle dependencies
	gradle bootRun
	gradle bootJar
	gradle build
	jar tvf build/libs/common-0.0.1-SNAPSHOT.jar
	java -jar build/libs/myproject-0.0.1-SNAPSHOT.jar
	
	
	
	
### db 먼저
	
	sangbinlee9@app-1:~$ sudo docker compose up -d
	[+] Running 11/11
	 ✔ mysql 10 layers [⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿]      0B/0B      Pulled                                                           39.2s
	   ✔ d9a40b27c30f Pull complete                                                                                  14.9s
	   ✔ fe4b01031aab Pull complete                                                                                   0.7s
	   ✔ aa72c34c4347 Pull complete                                                                                   0.9s
	   ✔ 473ade985fa2 Pull complete                                                                                   2.3s
	   ✔ cc168a9482de Pull complete                                                                                   1.9s
	   ✔ 3ca3786815dd Pull complete                                                                                   2.6s
	   ✔ 3e3fac98ea83 Pull complete                                                                                  15.5s
	   ✔ 10e5505c3ae4 Pull complete                                                                                   3.5s
	   ✔ a79ade39aab9 Pull complete                                                                                  11.2s
	   ✔ ae34d51c6da2 Pull complete                                                                                  11.9s
	[+] Running 2/2
	 ✔ Network sangbinlee9_default  Created                                                                           0.4s
	 ✔ Container guide-mysql        Started                                                                           1.1s
	
	
	
	
	
### local dev set







### 2. 
로그인관리, 사용자관리. 메뉴관리, 권한관리, 코드관리, API 모듈, 로깅관리

"# common" 
