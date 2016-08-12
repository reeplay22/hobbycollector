package com.catalyst.hobbycollector.team1.controllers;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * use to navigate the pages
 * 
 * @return
 */
@Controller
public class HobbyWebServiceController {
		/**
		 * use to go to home page
		 * 
		 * @return
		 */
		@RequestMapping(value = "/collectable/add", method = RequestMethod.GET)
		public String collectibleAdd() {
			return "/add.html";
		}

		/**
		 * use to go to creation page
		 * 
		 * @return
		 */
		@RequestMapping(value = "/collectable/index", method = RequestMethod.GET)
		public String collectibleIndex() {
			return "/index.html";
		}
		/**
		 * use to go to update page
		 * 
		 * @return
		 */
		@RequestMapping(value = "/collectable/update", method = RequestMethod.GET)
		public String collectibleUpdate() {
			return "/update.html";
		}
		/**
		 * use to go to create-category page
		 * 
		 * @return
		 */
		@RequestMapping(value = "/collectable/create-category", method = RequestMethod.GET)
		public String collectibleCreateCategory() {
			return "/create-category.html";
		}
		/**
		 * use to go to update-category page
		 * 
		 * @return
		 */
		@RequestMapping(value = "/collectable/update-category", method = RequestMethod.GET)
		public String collectibleUpdateCategory() {
			return "/update-category.html";
		}
		/**
		 * use to go to create-color page
		 * 
		 * @return
		 */
		@RequestMapping(value = "/collectable/create-color", method = RequestMethod.GET)
		public String collectibleCreateColor() {
			return "/create-color.html";
		}
		/**
		 * use to go to update-color page
		 * 
		 * @return 
		 */
		@RequestMapping(value = "/collectable/update-color", method = RequestMethod.GET)
		public String collectibleUpdateColor() {
			return "/update-color.html";
		}
}
		

