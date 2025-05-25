package ContosoAir.Operations;




/*
Licensed to the Software Freedom Conservancy (SFC) under one
or more contributor license agreements. See the NOTICE file
distributed with this work for additional information
regarding copyright ownership. The SFC licenses this file
to you under the Apache License, Version 2.0 (the
"License"); you may not use this file except in compliance
with the License. You may obtain a copy of the License at
http://www.apache.org/licenses/LICENSE-2.0
Unless required by applicable law or agreed to in writing,
software distributed under the License is distributed on an
"AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
KIND, either express or implied. See the License for the
specific language governing permissions and limitations
under the License.

Author: Vijay
*/

/**
 * Defines the contract for homepage operations, such as navigation,
 * login, and image/text verification.
 */
public interface HomePageOperations {

    /**
     * Navigates to the specified URL.
     * @param url The URL to navigate to.
     */
    void navigateToUrl(String url);

    /**
     * Performs login with the given credentials.
     * @param username The username for login.
     * @param password The password for login.
     */
    void performLogin(String username, String password);

    /**
     * Verifies the homepage logo is present.
     */
    void getLogo();

    /**
     * Retrieves the text of the title element.
     * @return The title text.
     */
    String getTitle();

    /**
     * Retrieves the subtitle text.
     * @return The subtitle text.
     */
    String subTitle();

    /**
     * Retrieves the suggestion title text.
     * @return The suggestion title.
     */
    String getSuggestTitle();

    /**
     * Verifies the Hawaii image is present.
     */
    void checkHawaiiImage();

    /**
     * Retrieves the Hawaii image caption.
     * @return Hawaii caption.
     */
    String checkHawaiiCaption();

    /**
     * Verifies the Paris image is present.
     */
    void checkParisImage();

    /**
     * Retrieves the Paris image caption.
     * @return Paris caption.
     */
    String checkParisCaption();

    /**
     * Verifies the Barcelona image is present.
     */
    void checkBarcelonaImage();

    /**
     * Retrieves the Barcelona image caption.
     * @return Barcelona caption.
     */
    String checkBarcelonaCaption();

    /**
     * Closes the browser and performs cleanup.
     */
    void tearDown();
}