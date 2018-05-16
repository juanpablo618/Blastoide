SETUP
----

    Clone the Git Repo
        mkdir ~/work
        cd ~/work
        git clone https://<STASH ID HERE>@stash.swacorp.com:9090/ui/swa-ui-app-e2e.git


    Change Directories in swa-ui-app
       cd ~/work/swa-ui-app-e2e


Run all test with firefox
    ./gradlew clean test aggregate

Run all test with browser
    ./gradlew clean test -Dwebdriver.driver=chrome aggregate

Run all test with hub
    ./gradlew clean test -Dwebdriver.remote.url=http://localhost:4444/wd/hub -Dwebdriver.remote.driver=firefox aggregate

Run specific test based on meta-tags
    ./gradlew clean test -Dmetafilter="+product Car" aggregate

Run specific test on specific url, when -Dmode.live=true will create a PNR | false will use a PNR on stubs
         ./gradlew clean test -Dmetafilter="+product earlyBird" -Dwebdriver.base.url=http://.dev4..com/ -Dmode.live=true aggregate

Generate serenity report
    ./gradlew aggregate


Selenium grid:
    Hub:
        docker run -d -p 4444:4444 --name selenium-hub selenium/hub
    Node:
        docker run -d --link selenium-hub:hub selenium/node-firefox:2.53.0
        docker run -d --link selenium-hub:hub selenium/node-chrome
