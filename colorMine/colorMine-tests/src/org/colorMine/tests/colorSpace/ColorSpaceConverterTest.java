package org.colorMine.tests.colorSpace;

import java.awt.Color;

import org.colorMine.colorSpace.ColorSpaceConverter;
import org.colorMine.colorSpace.Hsl;
import org.colorMine.colorSpace.Lab;
import org.colorMine.colorSpace.Xyz;
import org.testng.AssertJUnit;
import org.testng.annotations.Test;

@Test
public class ColorSpaceConverterTest {

	public void ColorToHsl_GivenHslValue_ReturnsRgb() {

		// ARRANGE
		Hsl expected = new Hsl(.66, .44, .62);
		Color color = new Color(115, 115, 200);

		// ACT
		Hsl result = ColorSpaceConverter.colorToHsl(color);

		// ASSERT
		AssertJUnit.assertTrue(ColorSpaceConverter.isNearMatch(expected, result, .01));
	}

	public void colorToXyz_givenColor_ReturnsXyz() {

		// ARRANGE
		Color color = new Color(255,0,0);
		Xyz expected = new Xyz(41.240, 21.260, 1.930);

		// ACT
		Xyz xyz = ColorSpaceConverter.colorToXyz(color);

		// ASSERT
		assert (ColorSpaceConverter.isNearMatch(xyz, expected, .001));
	}

	public void XyzToLab_givenXyz_ReturnsLab() {
		
		Xyz xyz = new Xyz(41.240, 21.260, 1.930);
		Lab lab = ColorSpaceConverter.xyzToLab(xyz);
		Lab expected = new Lab(53.233, 80.109, 67.220);

		assert (ColorSpaceConverter.isNearMatch(lab, expected, .001));

	}

	public void colorToLab_givenColor_ReturnsLab() {

		Color color = new Color(255,0,0);
		Lab lab = ColorSpaceConverter.colorToLab(color);
		Lab expected = new Lab(53.233, 80.109, 67.220);

		assert (ColorSpaceConverter.isNearMatch(lab, expected, .001));

	}


}