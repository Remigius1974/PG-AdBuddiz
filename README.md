<!---
 license: Licensed to the Apache Software Foundation (ASF) under one
         or more contributor license agreements.  See the NOTICE file
         distributed with this work for additional information
         regarding copyright ownership.  The ASF licenses this file
         to you under the Apache License, Version 2.0 (the
         "License"); you may not use this file except in compliance
         with the License.  You may obtain a copy of the License at

           http://www.apache.org/licenses/LICENSE-2.0

         Unless required by applicable law or agreed to in writing,
         software distributed under the License is distributed on an
         "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
         KIND, either express or implied.  See the License for the
         specific language governing permissions and limitations
         under the License.
-->

# de.kijok.pgadbuddiz

I wrote this plugin, because I wanted to use AdBuddiz for my Android apps and could not find any implementation for PhoneGap.

Feel free to use it as you like and if you find some bugs or other things worth to improve, let me know.

# How to install
At the command line type:
``phonegap plugin add https://github.com/Remigius1974/PG-AdBuddiz.git``

Included is only the Android version!

#How to use
The Java part:

Copy the AdBuddiz-xxx.jar file into you libs directory located under APPNAME/platforms/android/libs.

Include in your main Java file:

``

	import com.purplebrain.adbuddiz.sdk.AdBuddiz;

	...

	public void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		...
		AdBuddiz.setPublisherKey("YOUR_PUBLISHER_KEY");
		AdBuddiz.cacheAds(this); // this = current Activity
		...
	}
``

If you want to turn on the test-mode or modify the log level, you should insert your code just before the cacheAds function.

``

	...
	AdBuddiz.setTestModeActive();
	AdBuddiz.setLogLevel(AdBuddizLogLevel.Info);    // or Error, Silent
	AdBuddiz.cacheAds(this); // this = current Activity
	...
	
``


The Javascript part:

In you javascript file there is an object ``window.pgadbuddiz`` available.

It has a function ``showAd``, that shows an ad from AdBuddiz. That all!

Something like this: ``window.pgadbuddiz.showAd();``

Other functions like logs or availability checks are not implemented.
