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

### 1. 실행
 

### local dev set







### 2. 
로그인관리, 사용자관리. 메뉴관리, 권한관리, 코드관리, API 모듈, 로깅관리

"# common" 
