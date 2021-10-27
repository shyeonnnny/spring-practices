package com.douzone.container.config.videosystem.mixing;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

import com.douzone.container.videosystem.DVDPlayer;
import com.douzone.container.videosystem.DigitalVideoDisc;


/**
 * 
 * JavaConfig1이 있으면 JavaConfig2에 바로 땡겨온다.
 * 
 * JavaConfig2 <-------------Javaconfig2
 * 				  import
 *
 */
@Configuration
@Import(DVDConfig.class)
public class DVDPlayerConfig {
	
	@Bean
	public DVDPlayer dvdPlayer (@Qualifier("avengersInfinityWar") DigitalVideoDisc dvd) {
		return new DVDPlayer(dvd);
	}
}
