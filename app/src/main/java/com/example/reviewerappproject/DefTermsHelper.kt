package com.example.reviewerappproject

import kotlin.random.Random

class DefTermsHelper {
    companion object {
        private fun getNumber():Int {
            return Random.nextInt(1,11)
        }

        fun displayDefTerms():String{
            val defTerms = mapOf(
                Pair(1,"DIODE ALTERNATING CURRENT\n\nIt is a two-terminal parallel-inverse of semiconductor layers that permits triggering in either direction."),
                Pair(2,"VACUUM TUBE DIODE\n\nIt is similar to incandescent light bulbs, which contains a ‘FILAMENT’ in an evacuated glass envelope, but with another electrode, the ‘PLATE’."),
                Pair(3,"COEFFICIENT OF THERMAL EXPANSION\n\nIt is the unit change in dimension of a material for a unit change in temperature."),
                Pair(4,"PROGRAMMABLE UNIJUNCTION TRANSISTOR\n\nIt is a four-layer device whose operation is similar to the UJT."),
                Pair(5,"VOLTAGE REGULATOR\n\nIt provides a constant DC output voltage regardless of the change in the input voltage coming from the filter circuit or a change in load."),
                Pair(6,"ZENER DIODE\n\nIt is a heavily doped semiconductor device that is designed to operate in the reverse direction."),
                Pair(7,"BAUD\n\nIt is the unit of signaling speed equal to the number of signal events per second."),
                Pair(8,"ALTERNATING CURRENT\n\nIt is an electric current that rises to a maximum in one direction, falls back to zero and then rises to a maximum in the opposite direction and then repeats."),
                Pair(9,"BANDWIDTH\n\nIt is the numerical difference between upper and lower frequencies of a band of electromagnetic radiation."),
                Pair(10,"TANK CIRCUIT\n\nIt is a simple electrical circuit that uses magnetic resonance to store an electric charge or produce an electromagnetic frequency.")
            )
            return when (getNumber().toInt()) {
                (1) -> { defTerms[1].toString() }
                (2) -> { defTerms[2].toString() }
                (3) -> { defTerms[3].toString() }
                (4) -> { defTerms[4].toString() }
                (5) -> { defTerms[5].toString() }
                (6) -> { defTerms[6].toString() }
                (7) -> { defTerms[7].toString() }
                (8) -> { defTerms[8].toString() }
                (9) -> { defTerms[9].toString() }
                (10) -> { defTerms[10].toString() }
                else -> { defTerms[1].toString() }
            }
        }

    }
}
