/*
 * Copyright 2010-2012 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

/**
 * @author Andres.Almiray
 */
class ChartsGriffonPlugin {
    // the plugin version
    String version = '1.0.0'
    // the version or versions of Griffon the plugin is designed for
    String griffonVersion = '1.0.0 > *'
    // the other plugins this plugin depends on
    Map dependsOn = [swing: '1.0.0']
    // resources that are included in plugin packaging
    List pluginIncludes = []
    // the plugin license
    String license = 'Apache Software License 2.0'
    // Toolkit compatibility. No value means compatible with all
    // Valid values are: swing, javafx, swt, pivot, qt
    List toolkits = ['swing']
    // Platform compatibility. No value means compatible with all
    // Valid values are:
    // linux, linux64, windows, windows64, macosx, macosx64, solaris
    List platforms = []
    // URL where documentation can be found
    String documentation = ''
    // URL where source can be found
    String source = 'https://github.com/griffon/griffon-charts-plugin'

    List authors = [
        [
            name: 'Andres Almiray',
            email: 'aalmiray@yahoo.com'
        ]
    ]
    String title = 'JFreeCharts support'
    // accepts Markdown syntax. See http://daringfireball.net/projects/markdown/ for details
    String description = '''
Provides integration with [JFreeChart][1] by means of [ChartBuilder][2].

Usage
-----

The following nodes will become available on a View script upon installing this plugin

| *Node* | *Property*        | *Type*              |
| ------ | ----------------- | ------------------- |
| chart  | chart             | JFreeChart or Class |
|        | width             | int                 |
|        | height            | int                 |
|        | minimumDrawWidth  | int                 |
|        | minimumDrawHeight | int                 |
|        | maximumDrawWidth  | int                 |
|        | maximumDrawHeight | int                 |
|        | useBuffer         | boolean             |
|        | properties        | boolean             |
|        | copy              | boolean             |
|        | save              | boolean             |
|        | print             | boolean             |
|        | zoom              | boolean             |
|        | tooltips          | boolean             |

If a Class is set as the value for `chart:` then it is assumed to be a script that can be parsed using ChartBuilder

### Scripts

 * __create-chart__ - creates a new Chart script that can be parsed using ChartBuilder

### Example

Chart scripts have access to all variables form their surrounding context. This means that a chart can read properties
from a Model if the chart is built inside a View script. Here is how the typical chart Script looks like

__griffon-app/conf/charts/sample/SampleChart.groovy__

        package sample
        import java.awt.Color
        import java.awt.Font
        import org.jfree.chart.labels.PieToolTipGenerator

        def largeFont = new Font('Arial', Font.BOLD, 15)

        piechart3d(title: 'Simple Pie Chart') {
            defaultPieDataset {
                Series1(40.0f)
                Series2(30.0f)
                Series3(30.0f)
            }
            antiAlias = true
            backgroundPaint(Color.WHITE)

            pieplot {
                sectionOutlinesVisible false
                labelFont largeFont
                labelGap 0.02
                toolTipGenerator ({ dataset, key -> return "[${dataset} ${key}]" as String } as PieToolTipGenerator)

                sectionPaint('Series1', paint: new Color(255,0,0))
                sectionPaint('Series2', paint: new Color(0,255,0))
                sectionPaint('Series3', paint: new Color(0,0,255))
            }
        }

This is how the previously defined chart may be embedded in a View

__griffon-app/views/sample/SampleView.groovy__

        package sample
        application(title: 'Charts',
                preferredSize: [320, 240],
                pack: true,
                locationByPlatform:true,
                iconImage: imageIcon('/griffon-icon-48x48.png').image,
                iconImages: [imageIcon('/griffon-icon-48x48.png').image,
                imageIcon('/griffon-icon-32x32.png').image,
                imageIcon('/griffon-icon-16x16.png').image]) {
            chart(SampleChart)
        }

[1]: http://www.jfree.org/jfreechart
[2]: https://java.net/projects/groovychart
'''
}
