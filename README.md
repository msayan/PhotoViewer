[![](https://jitpack.io/#msayan/PhotoViewer.svg)](https://jitpack.io/#msayan/PhotoViewer)

# Photo Viewer

Ready to use photo viewer screen.

![sample_video](assets/sample.gif)

## Usage


```java

        new PhotoViewer.Builder(MainActivity.this)
                        .url(images) // List of Uri, file or String url
                        .placeHolder(R.drawable.ic_launcher_background) // placeHolder for images
                        .position(2)
			.pageChangeListener(new ViewPager.OnPageChangeListener() {
                            @Override
                            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

                            }

                            @Override
                            public void onPageSelected(int position) {
                                Toast.makeText(MainActivity.this, "Page Selected : " + position, Toast.LENGTH_SHORT).show();
                            }

                            @Override
                            public void onPageScrollStateChanged(int state) {

                            }
                        })
                        .build()
                        .show();

```


## Download

### Step 1. Add the JitPack repository to your build file

Add it in your root build.gradle at the end of repositories:

```groovy

	allprojects {
		repositories {
			...
			maven { url 'https://jitpack.io' }
		}
	}
```

### Step 2. Add the dependency

```groovy

	dependencies {
		compile 'com.github.msayan:PhotoViewer:v1.0.1'
	}

```

## License

    MIT License

    Copyright (c) 2018 Mehmet Ayan

    Permission is hereby granted, free of charge, to any person obtaining a copy
    of this software and associated documentation files (the "Software"), to deal
    in the Software without restriction, including without limitation the rights
    to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
    copies of the Software, and to permit persons to whom the Software is
    furnished to do so, subject to the following conditions:

    The above copyright notice and this permission notice shall be included in all
    copies or substantial portions of the Software.

    THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
    IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
    FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
    AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
    LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
    OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
    SOFTWARE.
