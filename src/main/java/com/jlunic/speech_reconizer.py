# speech_recognizer.py
import sys
import speech_recognition as sr

def recognize_speech_from_audio(audio_file):
    recognizer = sr.Recognizer()
    try:
        with sr.AudioFile(audio_file) as source:
            audio_data = recognizer.record(source)
            text = recognizer.recognize_google(audio_data, language="es-ES")
            return text
    except Exception as e:
        return f"Error al reconocer el audio: {str(e)}"

if __name__ == "__main__":
    if len(sys.argv) > 1:
        audio_file = sys.argv[1]
        print(recognize_speech_from_audio(audio_file))
    else:
        print("Por favor, proporciona un archivo de audio.")