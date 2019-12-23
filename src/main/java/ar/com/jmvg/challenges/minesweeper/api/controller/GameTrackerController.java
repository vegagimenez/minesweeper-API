package ar.com.jmvg.challenges.minesweeper.api.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/game/tracker")
public class GameTrackerController {

	private final Logger logger = LoggerFactory.getLogger(this.getClass());
}
