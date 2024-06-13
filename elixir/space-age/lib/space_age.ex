defmodule SpaceAge do
  @type planet ::
          :mercury
          | :venus
          | :earth
          | :mars
          | :jupiter
          | :saturn
          | :uranus
          | :neptune

  @doc """
  Return the number of years a person that has lived for 'seconds' seconds is
  aged on 'planet', or an error if 'planet' is not a planet.
  """
  @spec age_on(planet, pos_integer) :: {:ok, float} | {:error, String.t()}
  def age_on(planet, seconds) do
    case planet do
      :mercury -> {:ok, planet_age_by_planet_year(seconds, 0.2408467)}
      :venus -> {:ok, planet_age_by_planet_year(seconds, 0.61519726)}
      :earth -> {:ok, planet_age_by_planet_year(seconds)}
      :mars -> {:ok, planet_age_by_planet_year(seconds, 1.8808158)}
      :jupiter -> {:ok, planet_age_by_planet_year(seconds, 11.862615)}
      :saturn -> {:ok, planet_age_by_planet_year(seconds, 29.447498)}
      :uranus -> {:ok, planet_age_by_planet_year(seconds, 84.016846)}
      :neptune -> {:ok, planet_age_by_planet_year(seconds, 164.79132)}
      _ -> {:error, "not a planet"}
    end
  end

  defp planet_age_by_planet_year(seconds, planet_year \\ 1),
    do: Float.round(seconds / (31_557_600 * planet_year), 2)
end
