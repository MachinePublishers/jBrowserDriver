/* 
 * jBrowserDriver (TM)
 * Copyright (C) 2014-2015 Machine Publishers, LLC
 * ops@machinepublishers.com | screenslicer.com | machinepublishers.com
 * Cincinnati, Ohio, USA
 *
 * You can redistribute this program and/or modify it under the terms of the GNU Affero General Public
 * License version 3 as published by the Free Software Foundation.
 *
 * "ScreenSlicer", "jBrowserDriver", "Machine Publishers", and "automatic, zero-config web scraping"
 * are trademarks of Machine Publishers, LLC.
 * 
 * This program is distributed in the hope that it will be useful, but WITHOUT ANY WARRANTY; without
 * even the implied warranty of MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the GNU
 * Affero General Public License version 3 for more details.
 * 
 * You should have received a copy of the GNU Affero General Public License version 3 along with this
 * program. If not, see http://www.gnu.org/licenses/
 * 
 * For general details about how to investigate and report license violations, please see
 * https://www.gnu.org/licenses/gpl-violation.html and email the author, ops@machinepublishers.com
 */
package com.machinepublishers.browser;

import org.openqa.selenium.HasCapabilities;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.HasInputDevices;
import org.openqa.selenium.internal.FindsByClassName;
import org.openqa.selenium.internal.FindsByCssSelector;
import org.openqa.selenium.internal.FindsById;
import org.openqa.selenium.internal.FindsByLinkText;
import org.openqa.selenium.internal.FindsByName;
import org.openqa.selenium.internal.FindsByTagName;
import org.openqa.selenium.internal.FindsByXPath;
import org.openqa.selenium.internal.Killable;

public interface Browser extends WebDriver, JavascriptExecutor, FindsById,
    FindsByClassName, FindsByLinkText, FindsByName, FindsByCssSelector, FindsByTagName,
    FindsByXPath, HasInputDevices, HasCapabilities, TakesScreenshot, Killable {
  /**
   * A problem occurred, but it's likely temporary,
   * so the original operation should simply be retried.
   */
  static class Retry extends RuntimeException {
    private static final long serialVersionUID = 1L;

    public Retry() {
      super();
    }

    public Retry(Throwable nested) {
      super(nested);
    }

    public Retry(String message) {
      super(message);
    }
  }

  /**
   * A fatal error occurred and merely retrying the operation will likely fail.
   */
  static class Fatal extends RuntimeException {
    private static final long serialVersionUID = 1L;

    public Fatal() {
      super();
    }

    public Fatal(Throwable nested) {
      super(nested);
    }

    public Fatal(String message) {
      super(message);
    }

    public Fatal(String message, Throwable nested) {
      super(message, nested);
    }
  }

  /**
   * Blocks until an HTTP status code is obtained.
   * 
   * @return HTTP status code
   */
  int getStatusCode();
}