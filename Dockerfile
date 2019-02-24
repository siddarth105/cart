FROM ubuntu:16.04

ENV DEBIAN_FRONTEND noninteractive
ENV JAVA_HOME       /usr/lib/jvm/java-8-oracle
ENV LANG            en_US.UTF-8
ENV LC_ALL          en_US.UTF-8

RUN apt-get update && \
  apt-get install -y --no-install-recommends locales && \
  locale-gen en_US.UTF-8 && \
  apt-get dist-upgrade -y && \
  apt-get --purge remove openjdk* && \
  echo "oracle-java8-installer shared/accepted-oracle-license-v1-1 select true" | debconf-set-selections && \
  echo "deb http://ppa.launchpad.net/webupd8team/java/ubuntu xenial main" > /etc/apt/sources.list.d/webupd8team-java-trusty.list && \
  apt-key adv --keyserver keyserver.ubuntu.com --recv-keys EEA14886 && \
  apt-get update && \
  apt-get install -y --no-install-recommends oracle-java8-installer oracle-java8-set-default && \
  apt-get update && apt-get install -y unzip && \
  wget --no-check-certificate https://releases.hashicorp.com/consul-template/0.16.0/consul-template_0.16.0_linux_amd64.zip && \
  unzip consul-template_0.16.0_linux_amd64.zip -d /usr/local/bin && \
  apt-get update && apt-get install -y nginx && \
  apt-get update && apt-get install -y curl wget && \
  rm -rf /tmp/* /var/tmp/* /var/cache/apk/* && \
  apt-get clean all
  
RUN printf "After installation"    
ADD /target/cart-0.0.1-SNAPSHOT.jar cart-0.0.1-SNAPSHOT.jar
ADD /etc/nginx/conf.d/nginx.ctmpl /opt/consul_template/nginx.ctmpl
RUN chmod +777 /opt/consul_template/nginx.ctmpl
    
ENTRYPOINT ["java","-jar","/cart-0.0.1-SNAPSHOT.jar"]
EXPOSE 8080