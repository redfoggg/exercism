defmodule ResistorColorDuo do
  @doc """
  Calculate a resistance value from two colors
  """
  @spec value(colors :: [atom]) :: integer
  def value([f, s | _rest]), do: combine_values(f, s)

  defp combine_values(f, s) do
    with {number, _rest} <-
           Integer.parse(value_from_color(f) <> value_from_color(s)) do
      number
    else
      :error -> {:not_a_number, "Não númerico"}
    end
  end

  defp value_from_color(resitor_label) do
    case resitor_label do
      :black -> "0"
      :brown -> "1"
      :red -> "2"
      :orange -> "3"
      :yellow -> "4"
      :green -> "5"
      :blue -> "6"
      :violet -> "7"
      :grey -> "8"
      :white -> "9"
    end
  end
end
