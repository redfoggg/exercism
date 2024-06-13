defmodule ResistorColorTrio do
  @doc """
  Calculate the resistance value in ohms from resistor colors
  """
  @spec label(colors :: [atom]) :: {number, :ohms | :kiloohms | :megaohms | :gigaohms}
  def label(colors) do
    case colors do
      [f, s, t | _rest] when t in [:black, :brown] -> {combine_values(f, s, t), :ohms}
      [f, s, t | _rest] when t in [:red, :orange, :yellow] -> {combine_values(f, s, t)/1000, :kiloohms}
      [f, s, t | _rest] when t in [:green, :blue] -> {combine_values(f, s, t)/1000000, :megaohms}
      [f, s, t | _rest] when t in [:violet, :grey, :white] -> {combine_values(f, s, t)/1000000000, :gigaohms}
    end
  end

  defp combine_values(f, s, t) do
    with {number, _rest} <-
           Integer.parse(value_from_color(f) <> value_from_color(s) <> zeros_from_color(t)) do
      number
    else
      :error -> {:not_a_number, "Não númerico"}
    end
  end

  defp zeros_from_color(t) do
    case t do
      :black -> ""
      :brown -> "0"
      :red -> "00"
      :orange -> "000"
      :yellow -> "0000"
      :green -> "00000"
      :blue -> "000000"
      :violet -> "0000000"
      :grey -> "00000000"
      :white -> "000000000"
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
