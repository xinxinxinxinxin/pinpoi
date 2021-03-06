package io.github.fvasco.pinpoi.importer

import org.junit.Test

/**
 * @author Francesco Vasco
 */
class GeoRssImporterTest : AbstractImporterTestCase() {


    @Test
    @Throws(Exception::class)
    fun testimportAtom() {
        val list = importPlacemark(GeoRssImporter(), "georss.atom.xml")

        assertEquals(1, list.size)

        val p = list[0]
        assertEquals("M 3.2, Mona Passage", p.name)
        assertEquals("We just had a big one.", p.description)
        assertEquals(45.256, p.coordinates.latitude.toDouble(), 0.1)
        assertEquals(-71.92, p.coordinates.longitude.toDouble(), 0.1)
    }

    @Test
    @Throws(Exception::class)
    fun testimportRss() {
        val list = importPlacemark(GeoRssImporter(), "georss.rss.xml")

        assertEquals(1, list.size)

        val p = list[0]
        assertEquals("M 5.3, northern Sumatra, Indonesia", p.name)
        assertEquals("December 28, 2007 05:24:17 GMT", p.description)
        assertEquals(5.5319, p.coordinates.latitude.toDouble(), 0.1)
        assertEquals(95.8972, p.coordinates.longitude.toDouble(), 0.1)
    }
}