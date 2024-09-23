/*
 * Copyright 2021 Spotify AB
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

import com.vanniktech.maven.publish.MavenPublishBaseExtension
import com.vanniktech.maven.publish.SonatypeHost
import org.gradle.api.Project
import org.gradle.kotlin.dsl.extra

const val RULER_PLUGIN_GROUP = "com.hadisatrio.libs.android"
const val RULER_PLUGIN_VERSION = "1.0.0-alpha.2" // Also adapt this version in the README
const val EXT_POM_NAME = "POM_NAME"
const val EXT_POM_DESCRIPTION = "POM_DESCRIPTION"

fun MavenPublishBaseExtension.configurePublications(project: Project) {
    publishToMavenCentral(SonatypeHost.CENTRAL_PORTAL, automaticRelease = true)

    coordinates(RULER_PLUGIN_GROUP, project.name, RULER_PLUGIN_VERSION)
    signAllPublications()

    pom {
        name.set(project.extra[EXT_POM_NAME].toString())
        description.set(project.extra[EXT_POM_DESCRIPTION].toString())
        url.set("https://github.com/MrHadiSatrio/Ruler")

        scm {
            url.set("https://github.com/MrHadiSatrio/Ruler")
            connection.set("scm:git@github.com:MrHadiSatrio/Ruler.git")
            developerConnection.set("scm:git@github.com:MrHadiSatrio/Ruler.git")
        }
        licenses {
            license {
                name.set("The Apache Software License, Version 2.0")
                url.set("http://www.apache.org/licenses/LICENSE-2.0.txt")
            }
        }
        developers {
            developer {
                id.set("MrHadiSatrio")
                name.set("Hadi Satrio")
            }
        }
    }
}
